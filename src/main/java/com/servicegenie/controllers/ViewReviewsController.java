package com.servicegenie.controllers;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.servicegenie.models.Reviews;
import com.servicegenie.services.ViewReviewsService;

@Controller
public class ViewReviewsController {

	@Autowired
	public  ViewReviewsService viewReviewService;
	
	// Controller for handling service provider profile request
		@RequestMapping(method = RequestMethod.GET , value = "/view-all-reviews")
		public ModelAndView getAllServices() throws SQLException {
			// create object of ModelAndView
			ModelAndView mv = new ModelAndView();
			List<Reviews> reviews = viewReviewService.getReviews();
			
			// set the name of returning view 
			mv.setViewName("ViewReviews2.html");
			
			// Set the  profile data returned by ServiceProviderProfileService service
			mv.addObject("reviews", reviews);
			
			return mv;

		}
}
