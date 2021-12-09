package com.servicegenie.services;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.servicegenie.daos.ViewGreivanceDao;
import com.servicegenie.models.Greivances;
import com.servicegenie.models.Reviews;

@Service
public class ViewGreivancesService {

	private ViewGreivanceDao viewGreivanceDao;

	public ViewGreivancesService() throws SQLException {
		ViewGreivanceDao viewGreivanceDao = new ViewGreivanceDao();
		this.viewGreivanceDao = viewGreivanceDao;
	}

	public List<Greivances> getGreivances() throws SQLException {
		List<Greivances> grievances = new ArrayList<Greivances>();

		ResultSet resultSet = viewGreivanceDao.getAllGreivance();

		while (resultSet.next()) {
			String grievanceId = resultSet.getString("GrievanceId");
			String customerEmail = resultSet.getString("Customer_Email");
			String serviceId = resultSet.getString("ServiceId");
			String grievanceDescription = resultSet.getString("GrievanceDescription");

			Greivances r = new Greivances(grievanceId, customerEmail, serviceId, grievanceDescription);

			grievances.add(r);
		}

		return grievances;
	}

}
