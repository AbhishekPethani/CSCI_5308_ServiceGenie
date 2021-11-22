package com.servicegenie.services;

import com.servicegenie.ObtainDatabaseConnection;
import com.servicegenie.entities.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuyServiceService {

    public List<Service> getAllService() throws SQLException {
        List<Service> serviceList = new ArrayList<>();
        ObtainDatabaseConnection dbConnection = new ObtainDatabaseConnection();
        Statement selectStatement = dbConnection.GetMyConnection().createStatement();
        ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM services_details;");
        while (resultSet.next()){
            String serviceID = resultSet.getString("ServiceID");
            String serviceProviderID = resultSet.getString("ServiceProviderID");
            String serviceName = resultSet.getString("ServiceName");
            String serviceDescription = resultSet.getString("ServiceDescription");
            Double servicePrice = resultSet.getDouble("ServicePrice");
            Service service = new Service(serviceID, serviceProviderID, serviceName, serviceDescription ,servicePrice);
            serviceList.add(service);
        }
        dbConnection.TerminateConnection(dbConnection);
        return serviceList;
    }
}
