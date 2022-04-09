package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	 private ArrayList<String> patientNotes;
	public Physician(Integer id) {
		super(id);
		this.patientNotes = new ArrayList<String>();
	}

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
    

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}


	@Override
	public boolean assignPin(int pin) {
		int pinLength = String.valueOf(pin).length();
//		System.out.println(pinLength);
		int length = 4;
		if (pinLength != length) {
			return false;
		}
		else {
			return true;
		}
	}


	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (confirmedAuthID != this.id) {
			return false;
		}
		else {
			return true;
		}
	}
    
}
