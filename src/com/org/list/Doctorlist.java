package com.org.list;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.orf.info.Doctorinfo;
@XmlRootElement(name="doctors")
public class Doctorlist {
private List<Doctorinfo> doctors=new ArrayList<Doctorinfo>();

public List<Doctorinfo> getDoctors() {
	return doctors;
}
@XmlElementWrapper(name="doctorlist")
public void setDoctors(List<Doctorinfo> doctors) {
	this.doctors = doctors;
}

}
