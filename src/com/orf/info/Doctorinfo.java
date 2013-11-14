package com.orf.info;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;



public class Doctorinfo {
	private String firstname;
	private String lastname;
	private String email;
	private String hospitalname;
	private List<Patientinfo> patients;
	public String getFirstname() {
		return firstname;
	}
	@XmlElement
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	@XmlElement
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHospitalname() {
		return hospitalname;
	}
	@XmlElement
	public void setHospitalname(String hospitalname) {
		this.hospitalname = hospitalname;
	}
	
	public  List<Patientinfo> getPatients() {
		return patients;
	}
	@XmlElement
	public  void setPatients(List<Patientinfo> patients) {
		this.patients = patients;
	}
	

}
