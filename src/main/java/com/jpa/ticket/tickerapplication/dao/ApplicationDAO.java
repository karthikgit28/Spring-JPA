package com.jpa.ticket.tickerapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.ticket.tickerapplication.entity.Application;
import com.jpa.ticket.tickerapplication.entity.Bug;
import com.jpa.ticket.tickerapplication.entity.Release;
import com.jpa.ticket.tickerapplication.entity.Tickets;

@Repository
@Transactional
public class ApplicationDAO implements IApplicationDAO{

	@PersistenceContext
	private EntityManager entityManger;

	public List<Application> getApplications(){
//		//Class name is case sensitive and variable name should be used instead of coloumn name
//		String sql = "Select t from Application t order by t.description";
//		List<Application> list = (List<Application>) entityManger.createQuery(sql).getResultList();
		
		
		//Criteria Query as an alternative
		CriteriaBuilder builder = entityManger.getCriteriaBuilder();
		CriteriaQuery<Application> criteriaQuery = builder.createQuery(Application.class);
		Root<Application> root = criteriaQuery.from(Application.class);
		criteriaQuery.select(root);
		TypedQuery<Application> query = entityManger.createQuery(criteriaQuery);
		List<Application> list = query.getResultList();
		return list;
	}

	public List<Application> getApplicationsParams(String name,String description){
		//Class name is case sensitive and variable name should be used instead of coloumn name
//		String sql = "Select t from Application t where t.name= :name and t.description= :description";
//		List<Application> list = (List<Application>) entityManger.createQuery(sql)
//				.setParameter("name", name).setParameter("description", description).getResultList();
		
		//CriteiaApi as an alternative
		CriteriaBuilder builder = entityManger.getCriteriaBuilder();
		CriteriaQuery<Application> criteria = builder.createQuery(Application.class);
		Root<Application> root = criteria.from(Application.class);
		criteria.select(root).where(builder.equal(root.get("name"), "Karthik"));
		
		TypedQuery<Application> query = entityManger.createQuery(criteria);
		List<Application> list = query.getResultList();
		return list;
	}
	
	public List<Bug> fingSeverityBugs(){
		return entityManger.createNamedQuery("Bug.findSeverity").getResultList();
	}
	
	public List<Application> getApplicationsNative(){
		//Should be with DB column names
//		String sql = "Select a.app_name,t.description from Applications a,Tickets t where t.app_id = a.app_id";
//		List<Application> list = (List<Application>) entityManger.createNativeQuery(sql).getResultList();
		
		//Criteria API as an alternative
		CriteriaBuilder builder = entityManger.getCriteriaBuilder();
		CriteriaQuery<Application> criteriaQuery = builder.createQuery(Application.class);
		Root<Application> root = criteriaQuery.from(Application.class);
		criteriaQuery.select(root);
		
		Join<Application, Tickets> joins = root.join("app_id");
		
		TypedQuery<Application> query = entityManger.createQuery(criteriaQuery);
		List<Application> list = query.getResultList();
		return list;
	}


	@Override
	public void addApplication(Application application) {
		entityManger.persist(application);
	}

	@Override
	public void updateApplication(Application application) {
		Application appData = getApplicationById(application.getId());
		if(appData != null) {
			//appData.setDate(application.getDate());
			appData.setDescription(application.getDescription());
			appData.setName(application.getName());
			entityManger.flush();
		}
	}

	@Override
	public void deleteApplication(Application application) {
		entityManger.remove(getApplicationById(application.getId()));
	}

	@Override
	public Application getApplicationById(Integer id) {
		Application applicationData =  entityManger.find(Application.class, id);
		return applicationData;
	}

	@Override
	public void addTicket(Tickets ticket) {
		entityManger.persist(ticket);
	}

	@Override
	public void addRelease(Release release) {
		entityManger.persist(release);
	}



}
