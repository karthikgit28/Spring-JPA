package com.jpa.ticket.tickerapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.ticket.tickerapplication.entity.Application;
import com.jpa.ticket.tickerapplication.entity.Release;
import com.jpa.ticket.tickerapplication.entity.Tickets;
import com.jpa.ticket.tickerapplication.service.IApplicationService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IApplicationService appservice;

	@PostMapping("/createApplication")
	public ResponseEntity<Void> createApplication(@RequestBody Application application) {
		appservice.addApplication(application);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/getApplication/{id}")
	public ResponseEntity<Application> getApplicationById(@PathVariable Integer id) {
		Application app = appservice.getApplicationById(id);
		return new ResponseEntity<Application>(app, HttpStatus.OK);		
	}

	@DeleteMapping("/deleteUser")
	public ResponseEntity<Void> deleteApplication(@RequestBody Application application){
		appservice.deleteApplication(application);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/updateApp")
	public ResponseEntity<Void> updateApplication(@RequestBody Application application){
		appservice.updateApplication(application);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/createTicket")
	public ResponseEntity<Void> createTicket(@RequestBody Tickets ticket) {
		appservice.addTicket(ticket);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/createRelease")
	public ResponseEntity<Void> createRelease(@RequestBody Release release) {
		appservice.addRelease(release);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getApplicationList")
	public ResponseEntity<List<Application>> getApplicationList() {
		List<Application> app = appservice.getApplications();
		return new ResponseEntity<List<Application>>(app, HttpStatus.OK);		
	}
	
	@GetMapping("/getApplicationParam")
	public ResponseEntity<List<Application>> getApplicationParam(String name,String description) {
		List<Application> app = appservice.getApplicationsParams(name,description);
		return new ResponseEntity<List<Application>>(app, HttpStatus.OK);		
	}
	
	@GetMapping("/getApplicationNative")
	public ResponseEntity<List<Application>> getApplicationNative() {
		List<Application> app = appservice.getApplicationsNative();
		return new ResponseEntity<List<Application>>(app, HttpStatus.OK);		
	}


}
