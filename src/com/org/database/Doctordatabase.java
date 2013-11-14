package com.org.database;


import java.util.HashMap;

import java.util.Map;

import com.orf.info.Doctorinfo;



public class Doctordatabase {
private Doctordatabase(){
	
}
private static Map<String, Doctorinfo> database;
public static Map<String , Doctorinfo> getinstance(){
	Doctorinfo doctor1=new Doctorinfo();
	
	
	
	doctor1.setFirstname("Dr");
	doctor1.setLastname("batra");
	doctor1.setEmail("batra@trident.com");
	doctor1.setHospitalname("Trident");
	
	Doctorinfo doctor2=new Doctorinfo();
	
	doctor2.setFirstname("Dr");
	doctor2.setLastname("arora");
	doctor2.setEmail("arora@ttk.com");
	doctor2.setHospitalname("TTk");
	//doctor2.setPatients(patientlist2);
	Doctorinfo doctor3=new Doctorinfo();
	
	doctor3.setFirstname("Dr");
	doctor3.setLastname("saluja");
	doctor3.setEmail("saluja@dental.com");
	doctor3.setHospitalname("Brookfield");
	//doctor3.setPatients(patientlist3);
	Doctorinfo doctor4=new Doctorinfo();
	
	
	doctor4.setFirstname("Dr");
	doctor4.setLastname("ahuja");
	doctor4.setEmail("ahuja@trident.com");
	doctor4.setHospitalname("Trident");
	//doctor4.setPatients(patientlist4);
	database=new HashMap<String , Doctorinfo>();
	database.put(doctor1.getEmail(), doctor1);
	database.put(doctor2.getEmail(), doctor2);
	database.put(doctor3.getEmail(), doctor3);
	database.put(doctor4.getEmail(), doctor4);
	return database;
}
public static Map<String, Doctorinfo> getDatabase() {
	if(database==null){
		database=getinstance();
	}
	return database;
}
public static void setDatabase(Map<String, Doctorinfo> database) {
	Doctordatabase.database = database;
}

}
