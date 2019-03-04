package com.jpa.ticket.tickerapplication.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name="applications")
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="app_id")
	private Integer id;
	
	@Column(name="app_name")
	private String name;
	
	@Column(name="desc",length = 2000)
	private String description;
	
//	@JsonFormat(shape=Shape.STRING,pattern="yyyy-mm-dd")
//	private LocalDate date;
//	
	@Transient
	private String password;
	
	public Application() {
		
	}

	public Application(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		//this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	

}
