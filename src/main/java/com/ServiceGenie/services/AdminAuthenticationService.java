package com.servicegenie.services;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.servicegenie.daos.AdminDao;

//Author
//Kandarp Sharad Parikh
//B00873863

@Service
public class AdminAuthenticationService {
	
	
	public String validateUser(String myUser , String myPass, ModelMap model) throws SQLException
	{
		AdminDao admindao = new AdminDao();
		ResultSet result = admindao.getAdminCredentials();
		// Check if userid and password entered matches or not
		// If the userId and password matches the user will be redirected to Customer Home page
		// Else the User will be redirected to Login page again which has an error message
		getModelAttributes(model);
		while(result.next())
		{
			if(result.getString("User_ID").equals(myUser) && result.getString("User_Password").equals(myPass))
			{
				return "AdminHomePage.html";
			}
		}
		return "LoginFailed.html";
	}
	
	public ModelMap getModelAttributes(ModelMap model) throws SQLException {
		AdminDao ad = new AdminDao();
		model.addAttribute("customers_count",ad.getNumberOfCustomers().toString());
		model.addAttribute("serviceproviders_count", ad.getNumberOfServiceProviders());
		model.addAttribute("services_count", ad.getNumberOfServices());
		model.addAttribute("services", ad.getNameOfServices());
		return model;
	}

}
