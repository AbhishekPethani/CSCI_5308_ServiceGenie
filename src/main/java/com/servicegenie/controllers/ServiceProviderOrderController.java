package com.servicegenie.controllers;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.servicegenie.model.ServiceProviderOrders;
import com.servicegenie.services.ServiceProviderOrderService;

//author
//Abhishek Pareshbhai Pethani
//B00899521

@Controller
public class ServiceProviderOrderController {
	// Object of ServiceProviderOrderService service class
	@Autowired
	public ServiceProviderOrderService serviceProviderOrderService;
			
	// Controller for handling service provider order request
	@RequestMapping(method = RequestMethod.GET , value = "/view-all-orders/{service-provider-userid}")
	public ModelAndView getAllOrders(@PathVariable("service-provider-userid")String userID) throws SQLException {
		// create object of ModelAndView
		ModelAndView mv = new ModelAndView();
		
		// set the name of returning view 
		mv.setViewName("ServiceProviderOrder.html");
		
		// Set the  orders returned by ServiceProviderOrderService service
		List<ServiceProviderOrders> orders = serviceProviderOrderService.getOrders(userID);
		mv.addObject("orders", orders);
		
		// Set the processed order returned by ServiceProviderOrderService service
		List<ServiceProviderOrders> processedOrders = serviceProviderOrderService.getProcessesOrders(userID);
		mv.addObject("processedOrders", processedOrders);
		
		// set the current service provider id
		mv.addObject("userID", userID);
		
		return mv;
	}
	
	// Controller for handling service provider order process request
	@RequestMapping(method = RequestMethod.POST , value = "/process-orders/{service-provider-userid}")
	public ModelAndView processOrders(@PathVariable("service-provider-userid")String userID, @RequestParam("order-id")String orderID) throws SQLException {
		
		// create object of ModelAndView
		ModelAndView mv = new ModelAndView();
		
		// set the current service provider id
		mv.addObject("userID", userID);
		
		// set the name of returning view 
		mv.setViewName("ServiceProviderOrder.html");
		
		// Set the  orders returned by ServiceProviderOrderService service
		boolean orderProcessed = serviceProviderOrderService.processOrder(orderID);
		System.out.println(orderProcessed);
		
		// Set the  orders returned by ServiceProviderOrderService service
		List<ServiceProviderOrders> orders = serviceProviderOrderService.getOrders(userID);
		mv.addObject("orders", orders);
		
		// Set the processed order returned by ServiceProviderOrderService service
		List<ServiceProviderOrders> processedOrders = serviceProviderOrderService.getProcessesOrders(userID);
		mv.addObject("processedOrders", processedOrders);		
		return mv;
	}
}