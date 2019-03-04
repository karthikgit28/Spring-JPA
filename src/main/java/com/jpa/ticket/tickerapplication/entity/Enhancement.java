package com.jpa.ticket.tickerapplication.entity;

import javax.persistence.Entity;

@Entity
public class Enhancement extends Tickets{

	private String enhancementName;
	
	private boolean newChange;
	
	public Enhancement() {
		
	}

	public Enhancement(String enhancementName, boolean newChange) {
		super();
		this.enhancementName = enhancementName;
		this.newChange = newChange;
	}

	public String getEnhancementName() {
		return enhancementName;
	}

	public void setEnhancementName(String enhancementName) {
		this.enhancementName = enhancementName;
	}

	public boolean isNewChange() {
		return newChange;
	}

	public void setNewChange(boolean newChange) {
		this.newChange = newChange;
	}
	
	
	
}
