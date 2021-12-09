package com.servicegenie.services;

import com.servicegenie.daos.ViewOffersByCustomerDao;
import com.servicegenie.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ViewOffersByCustomerService {

    private static Logger logger = Logger.getLogger(ViewOffersByCustomerService.class.getName());

    @Autowired
    private ViewOffersByCustomerDao viewOffersByCustomerDao;

    public List<Offer> getAllOffers() {
        List<Offer> offerList= null;
        try {
            offerList = viewOffersByCustomerDao.getAllOffers();
        } catch (SQLException sqlException) {
            logger.log(Level.SEVERE, "Please try again, couldn't get Offers for customer\n"+sqlException.toString());
        }
        return offerList;
    }

}
