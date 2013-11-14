package com.org.list;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.orf.info.Patientinfo;
@XmlRootElement(name="patients")
public class Patientlist {
private List<Patientinfo> patients=new ArrayList<Patientinfo>();

public List<Patientinfo> getPatients() {
	return patients;
}
@XmlElementWrapper(name="patientlist")
public void setPatients(List<Patientinfo> patients) {
	this.patients = patients;
}

}
