package com.orf.info;

import javax.xml.bind.annotation.XmlElement;





public class Patientinfo {
private String firstname;
private String lastname;
private String email;
private String diseasename;
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
public String getDiseasename() {
	return diseasename;
}
@XmlElement
public void setDiseasename(String diseasename) {
	this.diseasename = diseasename;
}

}
