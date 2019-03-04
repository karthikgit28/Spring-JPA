package com.jpa.ticket.tickerapplication.service;

import java.util.List;

import com.jpa.ticket.tickerapplication.entity.Application;
import com.jpa.ticket.tickerapplication.entity.Bug;
import com.jpa.ticket.tickerapplication.entity.Release;
import com.jpa.ticket.tickerapplication.entity.Tickets;

public interface IApplicationService {

	public void addApplication(Application application);

	public void updateApplication(Application application);

	public void deleteApplication(Application application);

	public Application getApplicationById(Integer id);

	public void addTicket(Tickets ticket);

	public void addRelease(Release release);

	public List<Application> getApplications();

	public List<Application> getApplicationsParams(String name,String description);

	public List<Bug> fingSeverityBugs();

	public List<Application> getApplicationsNative();


}
