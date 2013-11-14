package com.org.database;

import java.util.HashMap;
import java.util.Map;

import com.orf.info.Patientinfo;

public class Patientdatabase {
private Patientdatabase(){
	
}
private static Map<String , Patientinfo> database;
public static Map<String , Patientinfo> getinstance(){
	Patientinfo patient1=new Patientinfo();
	patient1.setFirstname("manish");
	patient1.setLastname("dahiya");
	patient1.setEmail("m.p.dahiya@accenture.com");
	patient1.setDiseasename("marijuana");
	Patientinfo patient2=new Patientinfo();
	patient2.setFirstname("vivek");
	patient2.setLastname("agarwal");
	patient2.setEmail("vivek.c.agarwal@accenture.com");
	patient2.setDiseasename("asthma");
	Patientinfo patient3=new Patientinfo();
	patient3.setFirstname("manu");
	patient3.setLastname("raj");
	patient3.setEmail("raj.manu@accenture.com");
	patient3.setDiseasename("loveria");
	Patientinfo patient4=new Patientinfo();
	patient4.setFirstname("sumit");
	patient4.setLastname("kuma");
	patient4.setEmail("sumit.kuma@accenture.com");
	patient4.setDiseasename("fukeria");
	database=new HashMap<String , Patientinfo>();
	database.put(patient1.getEmail(), patient1);
	database.put(patient2.getEmail(), patient2);
	database.put(patient3.getEmail(), patient3);
	database.put(patient4.getEmail(), patient4);
	return database;
	
	
}
public static Map<String, Patientinfo> getDatabase() {
	if(database==null){
		database=getinstance();
	}
	return database;
}
public static void setDatabase(Map<String, Patientinfo> database) {
	Patientdatabase.database = database;
}
}
