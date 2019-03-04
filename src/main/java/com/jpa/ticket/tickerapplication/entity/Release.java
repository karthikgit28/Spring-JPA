package com.jpa.ticket.tickerapplication.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Release {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@JsonFormat(shape=Shape.STRING,pattern="YYYY-MM-DD")
	private String releaseDate;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Application> application = new ArrayList<Application>();
	
	public Release() {
		
	}

	public Release(Integer id, String releaseDate, List<Application> application) {
		super();
		this.id = id;
		this.releaseDate = releaseDate;
		this.application = application;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "Release [id=" + id + ", releaseDate=" + releaseDate + ", application=" + application + "]";
	}
	
	
	
	
}
