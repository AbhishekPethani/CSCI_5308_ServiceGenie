package com.servicegenie.controllers;

import com.servicegenie.models.CustomerProfile;
import com.servicegenie.services.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService customerProfileService;

    @GetMapping("/view-customer-profile")
    private String getCustomerProfile(Model model) {
        CustomerProfile customerProfile = customerProfileService.getCustomerProfile();
        model.addAttribute("customerProfile",customerProfile);
        return "CustomerProfile";
    }
}
