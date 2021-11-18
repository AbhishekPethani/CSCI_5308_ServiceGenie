package com.servicegenie.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.servicegenie.services.CheckUserExistenceService;
import com.servicegenie.services.ObtainDatabaseConnectionService;


//Class to check if the User Already exists at the time of registration
@Controller
public class CheckUserExistenceController {
	@Autowired
	private CheckUserExistenceService checkuserexistenceservice;
	public boolean CheckDatabase(String userId , String userType) throws SQLException {
		
		return checkuserexistenceservice.CheckDatabase(userId, userType);
		
	}
}
