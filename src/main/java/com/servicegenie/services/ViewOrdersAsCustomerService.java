package com.servicegenie.services;

import com.servicegenie.daos.ViewOffersByCustomerDao;
import com.servicegenie.daos.ViewOrdersAsCustomerDao;
import com.servicegenie.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ViewOrdersAsCustomerService {

    private static Logger logger = Logger.getLogger(ViewOffersByCustomerDao.class.getName());

    @Autowired
    private ViewOrdersAsCustomerDao viewOrdersAsCustomerDao;

    public List<Order> getAllOrdersByCustomerID(String customerID){
        List<Order> orderList = null;
        try {
            orderList = viewOrdersAsCustomerDao.getAllOrdersByCustomerID(customerID);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.log(Level.SEVERE,sqlException.toString());
            logger.log(Level.SEVERE,"Error While retrieving order");
        }
        return orderList;
    }
}
