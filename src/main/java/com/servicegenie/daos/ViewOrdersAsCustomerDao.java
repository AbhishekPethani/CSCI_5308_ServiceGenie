package com.servicegenie.daos;

import com.servicegenie.models.Order;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class ViewOrdersAsCustomerDao {

    private static Logger logger = Logger.getLogger(ViewOffersByCustomerDao.class.getName());

    //Method to get orders of a customer
    public List<Order> getAllOrdersByCustomerID(String customerID) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        Order order = null;

        //try with resources ensures that connection resource is closed at the end of the statement.
        try(Connection connection = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
            Statement sql = connection.createStatement();) {
            ResultSet resultSet = sql.executeQuery("SELECT * FROM orders WHERE customer_id='"+customerID+"';");
            while (resultSet.next()) {
                order = new Order();
                order.setOrderID(resultSet.getInt("order_id"));
                order.setCustomerID(resultSet.getString("customer_id"));
                order.setServiceProviderID(resultSet.getString("service_provider_id"));
                order.setOrderAmount(Double.parseDouble(resultSet.getString("order_amount")));
                order.setServiceName(resultSet.getString("service_name"));
                orderList.add(order);
            }
        }catch (SQLException sqlException) {
            logger.log(Level.SEVERE,sqlException.toString());
        }
        return orderList;
    }
}
