package com.servicegenie.controllers;

import com.servicegenie.models.Offer;
import com.servicegenie.services.ViewOffersByCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewOffersByCustomerController {

    @Autowired
    private ViewOffersByCustomerService viewOffersByCustomerService;

    @GetMapping("/view-customer-offers")
    public String getAllOffers(Model model){
        List<Offer> offerList = viewOffersByCustomerService.getAllOffers();
        model.addAttribute("offerList", offerList);
        return "ViewOffersByCustomer";
    }

}
