package com.servicegenie.daos;

import com.servicegenie.ObtainDatabaseConnection;
import com.servicegenie.models.Offer;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class ViewOffersByCustomerDao {

    private static Logger logger = Logger.getLogger(ViewOffersByCustomerDao.class.getName());

    public List<Offer> getAllOffers() throws SQLException{

        List<Offer> offerList = new ArrayList<>();

        ObtainDatabaseConnection dbConnection = null;
        try {
            dbConnection = new ObtainDatabaseConnection();
            Statement selectStatement = dbConnection.GetMyConnection().createStatement();
            ResultSet resultSet = selectStatement.executeQuery("SELECT * FROM offers;");

            while (resultSet.next()) {
                Integer offerID = resultSet.getInt("offer_id");
                String offerCode = resultSet.getString("offer_code");
                Double minimumAmount = resultSet.getDouble("minimum_amount");
                Double discountPercentage = resultSet.getDouble("discount_percentage");
                Offer offer = new Offer(offerID, offerCode, minimumAmount, discountPercentage);
                offerList.add(offer);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            logger.log(Level.SEVERE, "SQL Exception while getting offers");
        } finally {
            dbConnection.TerminateConnection(dbConnection);
        }

        return offerList;
    }
}
