package com.jpa.ticket.tickerapplication.entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

//@MappedSuperclass
@Entity
//@DiscriminatorColumn(name="NewColumn")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.JOINED)
public class Tickets {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String description;
	
	@JsonFormat(shape=Shape.STRING,pattern="yyyy-mm-dd")
	private String date;
	
	@ManyToOne
	@JoinColumn(name="app_id")
	private Application application;
	
	public Tickets() {
		
	}

	public Tickets(Integer id, String description, String date, Application application) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.application = application;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "Tickets [id=" + id + ", description=" + description + ", date=" + date + ", application=" + application
				+ "]";
	}
	
	
	
	
	
}
