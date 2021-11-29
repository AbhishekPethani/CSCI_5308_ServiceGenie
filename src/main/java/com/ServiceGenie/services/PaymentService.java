package com.ServiceGenie.services;

import com.servicegenie.ObtainDatabaseConnection;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PaymentService {
    public String payForService(String id) throws SQLException {
        System.out.println("Payment Page");
        ObtainDatabaseConnection dbconnect = new ObtainDatabaseConnection();
        String insertNewServiceQuery = " insert into order_id ( order_id, "
                + "customer_id, service_provider_id, order_amount, order_date, service_name)"
                + " values (?, ?, ?, ?, ?, ?)";

        PreparedStatement MyPreparedStatement;
        try {
            MyPreparedStatement = dbconnect.GetMyConnection().prepareStatement(insertNewServiceQuery);
            MyPreparedStatement.setString(1, id);
            MyPreparedStatement.setString(2, "customer "+id);
            MyPreparedStatement.setString(3, "service provider"+id);
            MyPreparedStatement.setString(4, "50");
            DateTimeFormatter dateTimeFormatterater = DateTimeFormatter.ofPattern("dd MMM yyyy");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dateTimeFormatterater.format(now));
            MyPreparedStatement.setString(5, dateTimeFormatterater.format(now));
            MyPreparedStatement.setString(6, "service name"+id);
            MyPreparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbconnect.TerminateConnection(dbconnect);
        }
        return "PaymentPage";
    }
}
