package com.servicegenie.controllers;

import com.servicegenie.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class PaymentController {

    @Autowired
    public PaymentService paymentService;


    @RequestMapping(method = RequestMethod.POST , value = "/buy-service")
    public String payForService(@RequestParam("id") String id) throws SQLException {
        System.out.println("Payment Controller HIT");
        return paymentService.payForService(id);
    }

}
