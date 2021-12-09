package com.servicegenie.services;

import java.sql.SQLException;
import org.springframework.stereotype.Service;
import com.servicegenie.daos.AddServiceDao;
import com.servicegenie.model.ServiceProviderServices;

//author
//Abhishek Pareshbhai Pethani
//B00899521

@Service
public class AddServiceService {
	// object of AddServiceDao
	private AddServiceDao addServiceDao;
	
	public AddServiceService(){
		addServiceDao = new AddServiceDao();
	}
	
	public void setAddServiceDao(AddServiceDao addServiceDao) {
		this.addServiceDao = addServiceDao;
	}
	
	public String addService(ServiceProviderServices service) throws SQLException {
		// String message for displaying operations result on UI
		String message = "";
		message = addServiceDao.addServiceByUserID(service);
		return message;
	}
}
