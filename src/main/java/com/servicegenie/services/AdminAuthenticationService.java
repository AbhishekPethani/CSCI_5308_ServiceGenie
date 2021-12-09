//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.servicegenie.daos.AdminDao;
import com.servicegenie.daos.OffersDao;

@Service
public class AdminAuthenticationService 
{
	private AdminDao admin;

	public AdminAuthenticationService() throws SQLException 
	{
		AdminDao admin = new AdminDao();
		this.admin = admin;
	}

	// Check if userid and password entered matches or not
	// If the userId and password matches the user will be redirected to Customer Home page
	// Else the User will be redirected to Login page again which has an error message
	public String validateUser(String myUser , String myPass, ModelMap model) throws SQLException
	{
		ResultSet result = this.admin.getAdminCredentials();
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
	
	// Method to get all the model attributes required to populate the admin homepage dashboard
	public ModelMap getModelAttributes(ModelMap model) throws SQLException 
	{
		AdminDao admin = new AdminDao();
		model.addAttribute("customers_count",admin.getNumberOfCustomers().toString());
		model.addAttribute("serviceproviders_count", admin.getNumberOfServiceProviders());
		model.addAttribute("services_count", admin.getNumberOfServices());
		model.addAttribute("services", admin.getNameOfServices());
		return model;
	}

}
