//Author
//Kandarp Sharad Parikh
//B00873863

package com.servicegenie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.servicegenie.services.ViewOrdersService;

public class ViewOrdersServiceTest {
	
	ViewOrdersService orders = new ViewOrdersService();
	public ViewOrdersServiceTest() throws SQLException {
		ViewOrdersService orders = new ViewOrdersService();
		this.orders = orders;
	}
	
	//Test to check the class is not null
	@Test
	void viewOrdersServiceNotNull() {
		assertNotNull(this.orders);
	}
	
	//Test to get list of service providers
	@Test
	void getListOfServiceProvidersTest() throws SQLException {
		assertThat(this.orders.getListOfServiceProviders() instanceof List);
	}
	
	//Test to get list of customers
	@Test
	void getListOfCustomersTest() throws SQLException {
		assertThat(this.orders.getListOfCustomers() instanceof List);
	}
	
	//Test to get list of all orders
	@Test
	void getAllOrdersTest() throws SQLException {
		assertThat(this.orders.getAllOrders() instanceof List);
	}
	
	//Test to get list of all orders by Service Providers
	@Test
	void viewOrdersByServiceProvidersTest() throws SQLException {
		String serviceProvider = "dalhousie11";
		assertThat(this.orders.viewOrdersByServiceProviders(serviceProvider) instanceof List);
	}
	
	//Test to get list of all orders by customers
	@Test
	void viewOrdersByCustomerTest() throws SQLException {
		String customer = "MyUser";
		assertThat(this.orders.viewOrdersByCustomer(customer) instanceof List);
	}

}
