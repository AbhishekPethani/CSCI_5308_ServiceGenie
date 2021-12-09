package com.servicegenie.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.servicegenie.services.AddReviewsService;
import com.servicegenie.services.AddServiceService;

@Controller
public class AddReviewController {

	@Autowired
	AddReviewsService addReview;

	@RequestMapping(method = RequestMethod.POST, value = "/add-reviews")
	public String AddNewService(@RequestParam("service-Id") String serviceId,@RequestParam("customer-Email") String customerEmail,
			@RequestParam("review-description") String serviceDescription,@RequestParam("review-star") String reviewStar) throws SQLException {

		return AddReviewsService.addReviews(serviceId,customerEmail, serviceDescription, reviewStar);

	}
}