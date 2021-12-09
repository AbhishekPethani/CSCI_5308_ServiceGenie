package com.servicegenie.services;

import com.servicegenie.constants.CustomerUtil;
import com.servicegenie.daos.CustomerProfileDao;
import com.servicegenie.models.CustomerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CustomerProfileService {

    @Autowired
    private CustomerProfileDao customerProfileDao;

    private static Logger logger = Logger.getLogger(CustomerProfileDao.class.getName());

    public CustomerProfile getCustomerProfile(){
        CustomerProfile customerProfile = customerProfileDao.getCustomerProfile(CustomerUtil.CUSTOMER_EMAIL.toString());
        if (customerProfile == null) {
            logger.log(Level.SEVERE,"Unable to retrieve Customer Profile");
        }
        return customerProfile;
    }
}
