//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;
import com.servicegenie.services.AdminAuthenticationService;
import com.servicegenie.services.BlockedUserService;

public class AdminAuthenticationServiceTest 
{
	AdminAuthenticationService admin = new AdminAuthenticationService();
	
	public AdminAuthenticationServiceTest() throws SQLException 
	{
		AdminAuthenticationService admin = new AdminAuthenticationService();
		this.admin = admin;
	}
	
	//Test to check if the class is not null
	@Test
	void AdminAuthenticationServiceNotNUll()
	{
		assertNotNull(admin);
	}
	
	//Test to check that the ModelAttributes return the ModelMap object
	@Test
	void getModelAttributesTest() throws SQLException 
	{
		ModelMap model = new ModelMap();
		assertThat(admin.getModelAttributes(model) instanceof ModelMap);
	}
}
