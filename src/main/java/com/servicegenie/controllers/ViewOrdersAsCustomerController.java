package com.servicegenie.controllers;

import com.servicegenie.constants.CustomerUtil;
import com.servicegenie.models.Order;
import com.servicegenie.services.ViewOrdersAsCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewOrdersAsCustomerController {

    @Autowired
    private ViewOrdersAsCustomerService viewOrdersAsCustomerService;

    @GetMapping("/view-customer-orders")
    public String getAllOrdersByCustomer(Model model){
        List<Order> orderList = viewOrdersAsCustomerService.getAllOrdersByCustomerID(CustomerUtil.CUSTOMER_ID.toString());
        model.addAttribute("orderList", orderList);
        return "CustomerOrderPage";
    }

}
