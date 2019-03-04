package com.jpa.ticket.tickerapplication.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Bug.findSeverity",query="Select t from Tickets t where t.severity=1")
public class Bug extends Tickets{
	
	private String severity;
	
	private String bugId;
	
	public Bug() {
		
	}

	public Bug(String severity, String bugId) {
		super();
		this.severity = severity;
		this.bugId = bugId;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getBugId() {
		return bugId;
	}

	public void setBugId(String bugId) {
		this.bugId = bugId;
	}

	
	
}
