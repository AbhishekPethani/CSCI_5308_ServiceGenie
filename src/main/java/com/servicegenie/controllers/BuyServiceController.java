package com.servicegenie.controllers;

import com.servicegenie.entities.Service;
import com.servicegenie.services.BuyServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BuyServiceController {


    private BuyServiceService buyServiceService=new BuyServiceService();


    @GetMapping("/user/services")
    public String getServices(Model model) throws SQLException {
        //System.out.println("Server Hit");

        List<Service> serviceList = new ArrayList<>();
        serviceList = buyServiceService.getAllService();
        model.addAttribute("serviceList",serviceList);
        //System.out.println(serviceList);
        return "BuyNewService";
    }


}
