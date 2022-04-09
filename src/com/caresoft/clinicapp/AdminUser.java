package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	

    

    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    public AdminUser(Integer id, String role) {
		super(id);
		this.securityIncidents = new ArrayList<String>();
	}
    
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
	
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		ArrayList<String> incidents = this.getSecurityIncidents();
//		System.out.println(incidents);
		return incidents;
	}
	
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		int pinLength = String.valueOf(pin).length();
//		System.out.println(pinLength);
		int length = 6;
		if (pinLength != length) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if (confirmedAuthID != this.id) {
			authIncident();
			return false;
		}
		else {
			return true;
		}
	}
    
    
}
