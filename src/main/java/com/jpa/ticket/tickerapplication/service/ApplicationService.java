package com.jpa.ticket.tickerapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.ticket.tickerapplication.dao.IApplicationDAO;
import com.jpa.ticket.tickerapplication.entity.Application;
import com.jpa.ticket.tickerapplication.entity.Bug;
import com.jpa.ticket.tickerapplication.entity.Release;
import com.jpa.ticket.tickerapplication.entity.Tickets;

@Service
public class ApplicationService implements IApplicationService{

	@Autowired
	private IApplicationDAO appDao;

	@Override
	public void addApplication(Application application) {
		appDao.addApplication(application);
	}

	@Override
	public void updateApplication(Application application) {
		appDao.updateApplication(application);		
	}

	@Override
	public void deleteApplication(Application application) {
		appDao.deleteApplication(application);
	}

	@Override
	public Application getApplicationById(Integer id) {
		return appDao.getApplicationById(id);
	}

	@Override
	public void addTicket(Tickets ticket) {
		appDao.addTicket(ticket);
	}

	@Override
	public void addRelease(Release release) {
		appDao.addRelease(release);
	}

	@Override
	public List<Application> getApplications() {
		return appDao.getApplications();
	}

	@Override
	public List<Application> getApplicationsParams(String name,String description) {
		return appDao.getApplicationsParams(name,description);
	}

	@Override
	public List<Bug> fingSeverityBugs() {
		return appDao.fingSeverityBugs();
	}

	@Override
	public List<Application> getApplicationsNative() {
		return appDao.getApplicationsNative();
	}

}
