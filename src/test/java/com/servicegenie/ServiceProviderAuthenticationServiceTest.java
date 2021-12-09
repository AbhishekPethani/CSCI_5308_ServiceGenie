package com.servicegenie;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.servicegenie.services.ServiceProviderAuthenticationService;

//author
//Abhishek Pareshbhai Pethani
//B00899521

class ServiceProviderAuthenticationServiceTest {

	@Test
	void checkServiceProviderAuthenticationServiceClassExist() {
		assertNotNull(new ServiceProviderAuthenticationService());
	}

}
