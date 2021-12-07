//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.servicegenie.services.BlockedUserService;

public class BlockedUserServiceTest 
{
	BlockedUserService user = new BlockedUserService();
	
	public BlockedUserServiceTest() throws SQLException 
	{
		BlockedUserService user = new BlockedUserService();
		this.user = user;
	}
	
	// Test to check if the class is not null
	@Test
	void BlockedUserServiceNotNUll(){
		assertNotNull(user);
	}
	
	// Test to check that the method returns instance of list
	void getBlockedUserDetailsTest() throws SQLException
	{
		assertThat(user.getBlockedUserDetails() instanceof List);
	}
	
	// Test to check that the method returns instance of list
	void getBlockedCustomersDetailsTest() throws SQLException
	{
		assertThat(user.getBlockedCustomersDetails() instanceof List);
	}
	
	// Test to check that the method returns instance of list
	void getAllBlockedServiceProvidersIDTest() throws SQLException
	{
		assertThat(user.getAllBlockedServiceProvidersID() instanceof List);
	}

	// Test to check that the method returns instance of list
	void getAllServiceProvidersIDTest() throws SQLException
	{
		assertThat(user.getAllServiceProvidersID() instanceof List);
	}
	
	// Test to check that the method returns instance of list
	void getAllCustomersIDTest() throws SQLException
	{
		assertThat(user.getAllCustomersID() instanceof List);
	}
}
