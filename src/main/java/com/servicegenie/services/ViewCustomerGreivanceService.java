
package com.servicegenie.services;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.servicegenie.daos.ViewGreivanceDao;
import com.servicegenie.daos.ViewReviewsDao;
import com.servicegenie.models.Greivances;
import com.servicegenie.models.Reviews;

@Service
public class ViewCustomerGreivanceService {
	
	private ViewGreivanceDao viewServiceDao;
	
	public ViewCustomerGreivanceService() throws SQLException{
		ViewGreivanceDao viewGreivanceDao = new ViewGreivanceDao();
		this.viewServiceDao = viewGreivanceDao;
	}
	
	
	public List<Greivances> getCustomerGreivance (String CustomerEmail) throws SQLException {
		List<Greivances> Greivance = new ArrayList<Greivances>();
		
		ResultSet resultSet = viewServiceDao.getCustomerGreivance(CustomerEmail);
		
		while (resultSet.next()) {
			String grievanceId = resultSet.getString("GrievanceId");
			String customerEmail = resultSet.getString("Customer_Email");
			String serviceId = resultSet.getString("ServiceId");
			String grievanceDescription = resultSet.getString("GrievanceDescription");

			Greivances r = new Greivances(grievanceId, customerEmail, serviceId, grievanceDescription);

			Greivance.add(r);
		}
		
		return Greivance;	
	}
	
}
