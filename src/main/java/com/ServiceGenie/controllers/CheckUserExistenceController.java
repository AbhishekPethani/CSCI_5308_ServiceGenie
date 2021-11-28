package com.servicegenie.controllers;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.servicegenie.services.CheckUserExistenceService;


//Class to check if the User Already exists at the time of registration
@Controller
public class CheckUserExistenceController {
	@Autowired
	private CheckUserExistenceService checkuserexistenceservice;
	public boolean checkDatabase(String userId , String userType) throws SQLException {
		
		return checkuserexistenceservice.checkDatabase(userId, userType);
		
	}
}
