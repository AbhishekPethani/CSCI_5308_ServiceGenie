package com.servicegenie.controllers;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.servicegenie.models.Greivances;
import com.servicegenie.services.ViewGreivancesService;

@Controller
public class ViewGreivanceController {

	@Autowired
	public  ViewGreivancesService viewGreivanceService;
	
	// Controller for handling service provider profile request
		@RequestMapping(method = RequestMethod.GET , value = "/view-all-greivance")
		public ModelAndView getAllServices() throws SQLException {
			// create object of ModelAndView
			ModelAndView mv = new ModelAndView();
			List<Greivances> greivances = viewGreivanceService.getGreivances();
			System.out.println();
			
			
			// set the name of returning view 
			mv.setViewName("ViewGreivance2.html");
			
			// Set the  profile data returned by ServiceProviderProfileService service
			mv.addObject("greivances", greivances);
			
			return mv;

		}
}
