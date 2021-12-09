package com.servicegenie.services;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.servicegenie.daos.ViewServicesDao;
import com.servicegenie.model.ServiceProviderServices;

//author
//Abhishek Pareshbhai Pethani
//B00899521

@Service
public class ViewServicesService {
	// object of ViewServicesDao
	private ViewServicesDao viewServicesDao;

	public ViewServicesService() {
		viewServicesDao = new ViewServicesDao();
	}
	
	public void setViewServicesService(ViewServicesDao viewServicesDao) {
		this.viewServicesDao = viewServicesDao;
	}
	
    public List<ServiceProviderServices> getServices(String userID) throws SQLException {
    	List<ServiceProviderServices> services = new ArrayList<ServiceProviderServices>();
        services = viewServicesDao.getAllServices(userID);
        return services;
    }
	
}
