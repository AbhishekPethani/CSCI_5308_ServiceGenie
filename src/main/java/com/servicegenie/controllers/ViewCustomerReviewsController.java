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

import com.servicegenie.models.Reviews;
import com.servicegenie.services.ViewCustomerReviewsService;
import com.servicegenie.services.ViewReviewsService;

@Controller
public class ViewCustomerReviewsController {

	@Autowired
	public  ViewCustomerReviewsService viewCustomerReviewService;
	
	// Controller for handling service provider profile request
		@RequestMapping(method = RequestMethod.GET , value = "/show-customer-reviews")
		public ModelAndView getAllServices(@RequestParam("customer-Email") String customerEmail) throws SQLException {
			// create object of ModelAndView
			ModelAndView mv = new ModelAndView();
			List<Reviews> reviews = viewCustomerReviewService.getCustomerReviews(customerEmail);
			
			// set the name of returning view 
			mv.setViewName("ViewCustomerReviews2.html");
			
			// Set the  profile data returned by ServiceProviderProfileService service
			mv.addObject("reviews", reviews);
			
			System.out.println(reviews.size());
			
			return mv;

		}
}