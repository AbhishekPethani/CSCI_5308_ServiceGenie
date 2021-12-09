package com.servicegenie.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicegenie.services.AddGrievanceService;



@Controller public class AddGrievanceController {

	@RequestMapping(method = RequestMethod.POST, value = "/add-grievance")
	public String AddNewService(@RequestParam("customer-Email") String customerEmail,@RequestParam("service-Id") String serviceId,
			@RequestParam("grievance-description") String grievanceDescription) throws SQLException {

		return AddGrievanceService.addGrievances(customerEmail,serviceId, grievanceDescription);

	}
}