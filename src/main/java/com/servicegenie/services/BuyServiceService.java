package com.servicegenie.services;

import com.servicegenie.ObtainDatabaseConnection;
import com.servicegenie.daos.ObtainDatabaseConnectionDao;
import com.servicegenie.models.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuyServiceService {

    public List<Service> getAllService() throws SQLException {
        List<Service> serviceList = new ArrayList<>();
    	Connection myDBConnect = ObtainDatabaseConnectionDao.getInstance().getMyConnection();
        Statement selectStatement = myDBConnect.createStatement();
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
        return serviceList;
    }
}
