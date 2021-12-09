package com.servicegenie;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import com.servicegenie.services.RegisterAsServiceProviderService;

//author
//Abhishek Pareshbhai Pethani
//B00899521

public class RegisterAsServiceProviderServiceTest {
	@Test
	void checkRegisterAsServiceProviderServiceClassExist() {
		assertNotNull(new RegisterAsServiceProviderService());
	}
	
	
}
