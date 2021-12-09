package com.servicegenie.services;

import com.servicegenie.daos.BuyServiceDao;
import com.servicegenie.models.Order;
import com.servicegenie.models.ServiceForCustomers;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@org.springframework.stereotype.Service
public class BuyServiceService {

    private static Logger logger = Logger.getLogger(BuyServiceService.class.getName());

    private static BuyServiceDao buyServiceDao = new BuyServiceDao();

    public List<ServiceForCustomers> getAllServices() throws SQLException {

        List<ServiceForCustomers> serviceForCustomersList = buyServiceDao.getAllServices();
        if (serviceForCustomersList == null) {
            logger.log(Level.WARNING, "List for listing/providing service provider's service is null");
        }
        return serviceForCustomersList;
    }

    public ServiceForCustomers getServiceByID(String serviceID){
        ServiceForCustomers theServiceForCustomers = null;
        try{
            theServiceForCustomers = buyServiceDao.getServiceByID(serviceID);
        }catch(SQLException sqlException){
            logger.log(Level.SEVERE, "Exception while retrieving service using service id\n");
        }
        return theServiceForCustomers;
    }

    public boolean placeOrder(Order order) throws SQLException {
        return buyServiceDao.placeOrder(order);
    }

}
