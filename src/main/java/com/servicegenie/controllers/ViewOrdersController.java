//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.servicegenie.services.ViewOrdersService;

@Controller
public class ViewOrdersController {
	
	@Autowired
	private ViewOrdersService vieworders;
	
	@RequestMapping(method = RequestMethod.GET , value = "/ViewOrders")
	public String getContentForDropDownList(ModelMap model) throws SQLException
	{   
		model.addAttribute("serviceProviders", vieworders.getListOfServiceProviders());
		model.addAttribute("customers", vieworders.getListOfCustomers());
		return "ViewOrders.html";
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/ViewAllOrders")
	public ModelAndView getAllOrders(ModelAndView mv) throws SQLException
	{   
		mv.setViewName("ViewOrders.html");
		mv.addObject("serviceProviders", vieworders.getListOfServiceProviders());
		mv.addObject("customers", vieworders.getListOfCustomers());
		mv.addObject("orders",vieworders.getAllOrders());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/ViewOrdersByServiceProvider")
	public ModelAndView getOrdersByServiceProviders(@RequestParam("service_providerId")String serviceProvider ,ModelMap model , ModelAndView mv) throws SQLException
	{   
		mv.setViewName("ViewOrders.html");
		mv.addObject("serviceProviders", vieworders.getListOfServiceProviders());
		mv.addObject("customers", vieworders.getListOfCustomers());
		mv.addObject("ordersbyserviceprovider",vieworders.viewOrdersByServiceProviders(serviceProvider.substring(1)));
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST , value = "/ViewOrdersByCustomer")
	public ModelAndView getOrdersByCustomer(@RequestParam("customer_Id")String customerid ,ModelMap model , ModelAndView mv) throws SQLException
	{   
		mv.setViewName("ViewOrders.html");
		mv.addObject("serviceProviders", vieworders.getListOfServiceProviders());
		mv.addObject("customers", vieworders.getListOfCustomers());
		mv.addObject("ordersbycustomer",vieworders.viewOrdersByCustomer(customerid.substring(1)));
		return mv;
	}
}
