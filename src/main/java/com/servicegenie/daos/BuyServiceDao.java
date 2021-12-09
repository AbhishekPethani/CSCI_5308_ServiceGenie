package com.servicegenie.daos;

import com.servicegenie.ObtainDatabaseConnection;
import com.servicegenie.constants.CustomerUtil;
import com.servicegenie.models.Offer;
import com.servicegenie.models.Order;
import com.servicegenie.models.ServiceForCustomers;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class BuyServiceDao {

    private static Logger logger = Logger.getLogger(BuyServiceDao.class.getName());

    public List<ServiceForCustomers> getAllServices() throws SQLException {

        List<ServiceForCustomers> serviceForCustomersList = new ArrayList<>();
        ObtainDatabaseConnection dbConnection = null;
        try {
            dbConnection = new ObtainDatabaseConnection();
            Statement selectStatement = dbConnection.GetMyConnection().createStatement();
            ResultSet resultSet = selectStatement.executeQuery(CustomerUtil.QUERY_SERVICE_DETAILS.toString());

            while (resultSet.next()) {
                String serviceID = resultSet.getString("ServiceID");
                String serviceProviderID = resultSet.getString("ServiceProviderID");
                String serviceName = resultSet.getString("ServiceName");
                String serviceDescription = resultSet.getString("ServiceDescription");
                Double servicePrice = resultSet.getDouble("ServicePrice");
                Integer offerID = resultSet.getInt("offer_id");
                Offer offer = this.getOfferID(offerID);
                ServiceForCustomers serviceForCustomers = new ServiceForCustomers(serviceID, serviceProviderID, serviceName, serviceDescription, servicePrice, offer, offerID);
                serviceForCustomersList.add(serviceForCustomers);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.log(Level.SEVERE, "SQL Exception while getting services");
        } finally {
            dbConnection.TerminateConnection(dbConnection);
        }

        return serviceForCustomersList;
    }

    public ServiceForCustomers getServiceByID(String serviceID) throws SQLException {
        ServiceForCustomers theServiceForCustomers = null;
        ObtainDatabaseConnection dbConnection = null;
        try {
            dbConnection = new ObtainDatabaseConnection();
            Statement selectStatement = dbConnection.GetMyConnection().createStatement();
            ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM services_details where serviceID='" + serviceID + "';");
            while (resultSet.next()) {
                String id = resultSet.getString("ServiceID");
                String serviceProviderID = resultSet.getString("ServiceProviderID");
                String serviceName = resultSet.getString("ServiceName");
                String serviceDescription = resultSet.getString("ServiceDescription");
                Double servicePrice = resultSet.getDouble("ServicePrice");
                Integer offerID = resultSet.getInt("offer_id");
                Offer offer = this.getOfferID(offerID);
                theServiceForCustomers = new ServiceForCustomers(id, serviceProviderID, serviceName, serviceDescription, servicePrice, offer, offerID);

            }

        } catch (SQLException sqlException) {
            logger.log(Level.SEVERE, "SQL Exception while getting services");
        } finally {
            dbConnection.TerminateConnection(dbConnection);
        }
        return theServiceForCustomers;
    }

    private Offer getOfferID(int offerID) throws SQLException {
        Offer offer = null;
        ObtainDatabaseConnection dbConnection = null;
        try {
            dbConnection = new ObtainDatabaseConnection();
            Statement selectStatement = dbConnection.GetMyConnection().createStatement();
            ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM offers where offer_id='" + offerID + "';");
            while (resultSet.next()) {
                offer = new Offer();
                offer.setOfferID(resultSet.getInt("offer_id"));
                offer.setOfferCode(resultSet.getString("offer_code"));
                offer.setMinimumAmount(resultSet.getDouble("minimum_amount"));
                offer.setDiscountPercentage(resultSet.getDouble("discount_percentage"));
            }

        } catch (SQLException sqlException) {
            logger.log(Level.SEVERE, "SQL Exception while getting offers");
        } finally {
            dbConnection.TerminateConnection(dbConnection);
        }
        return offer;
    }

    public boolean placeOrder(Order order) throws SQLException {
        boolean isOrderPlace = Boolean.FALSE;
        ObtainDatabaseConnection dbconnect = new ObtainDatabaseConnection();
        String insertNewServiceQuery = " insert into orders ("
                + "customer_id, service_provider_id, order_amount, order_date, service_name)"
                + " values (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = dbconnect.GetMyConnection().prepareStatement(insertNewServiceQuery);
            preparedStatement.setString(1, order.getCustomerID());
            preparedStatement.setString(2, order.getService().getServiceProviderID());
            preparedStatement.setDouble(3, order.getOrderAmount());
            preparedStatement.setString(4, order.getOrderDate().toString());
            preparedStatement.setString(5, order.getService().getServiceName());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                isOrderPlace = Boolean.TRUE;
            }
        } catch (SQLException sqlException) {
            logger.log(Level.WARNING, sqlException.toString());
            logger.log(Level.SEVERE, "Exception while inserting into order table");
        } finally {
            dbconnect.TerminateConnection(dbconnect);
        }
        return isOrderPlace;
    }
}
