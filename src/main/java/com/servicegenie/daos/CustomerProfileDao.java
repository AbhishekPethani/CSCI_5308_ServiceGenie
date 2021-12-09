package com.servicegenie.daos;

import com.servicegenie.models.CustomerProfile;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class CustomerProfileDao {

    private static Logger logger = Logger.getLogger(CustomerProfileDao.class.getName());

    public CustomerProfile getCustomerProfile(String customerID) {
        CustomerProfile customerProfile = null;
        try(Connection connection = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
            Statement sql = connection.createStatement();) {
            ResultSet resultSet = sql.executeQuery("SELECT * FROM customer_details WHERE Customer_Email='"+customerID+"';");
            while (resultSet.next()) {
                customerProfile = new CustomerProfile();
                customerProfile.setFirstName(resultSet.getString("Customer_FirstName"));
                customerProfile.setLastName(resultSet.getString("Customer_LastName"));
                customerProfile.setEmail(resultSet.getString("Customer_Email"));
                customerProfile.setContactNumber(resultSet.getString("Customer_ContactNumber"));
                customerProfile.setAddress(resultSet.getString("Customer_Address"));
                customerProfile.setZipCode(resultSet.getString("Customer_ZipCode"));
            }
        }catch (SQLException sqlException) {
            logger.log(Level.SEVERE,sqlException.toString());
        }
        return customerProfile;
    }
}
