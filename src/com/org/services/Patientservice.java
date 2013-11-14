package com.org.services;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Iterator;
import java.util.List;
import java.util.Map;





import javax.ws.rs.DELETE;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
//import javax.ws.rs.PUT;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.orf.info.Doctorinfo;
import com.orf.info.Patientinfo;
import com.org.database.Doctordatabase;
import com.org.database.Patientdatabase;
import com.org.list.Patientlist;

@Path("patient")
public class Patientservice {
@GET
@Path("list")
@Produces(MediaType.APPLICATION_XML)
public Patientlist getpatients(){
	Map<String , Patientinfo> patients=Patientdatabase.getDatabase();
	Iterator<String> email=patients.keySet().iterator();
	List<Patientinfo> patientlist=new ArrayList<Patientinfo>();
	while(email.hasNext()){
		String emailid=email.next();
		patientlist.add(patients.get(emailid));
	}
	Patientlist plist=new Patientlist();
	plist.setPatients(patientlist);
	return plist;
}
@POST
@Path("list")
@Produces("text/plain")
public String addpatient(@QueryParam("fname") String firstName,
		@QueryParam("lname") String lastName,
		@QueryParam("dname") String dname,
		@QueryParam("emailid") String emailId){
			String response="UnAble to Add user";
			Map<String , Patientinfo> patients=Patientdatabase.getDatabase();
			Patientinfo newpatient=new Patientinfo();
			newpatient.setFirstname(firstName);
			newpatient.setLastname(lastName);
			newpatient.setEmail(emailId);
			newpatient.setDiseasename(dname);
			patients.put(newpatient.getEmail(), newpatient);
			Patientdatabase.setDatabase(patients);
			response="success";
			return response;
			
		}

@PUT
@Path("list")
@Produces("text/plain")
public String updatepatient(@QueryParam("fname") String firstName,
		@QueryParam("lname") String lastName,
		@QueryParam("dname") String dname,
		@QueryParam("emailid") String emailId,
		@QueryParam("nemailid") String nemailId){
	String response="UnAble to Update user";
	Map<String , Patientinfo> patients=Patientdatabase.getDatabase();
	Patientinfo upatient=patients.get(emailId);
	upatient.setFirstname(firstName);
	upatient.setLastname(lastName);
	upatient.setEmail(nemailId);
	upatient.setDiseasename(dname);
	response="success";
	return response;
}
@DELETE
@Path("list")
@Produces("text/plain")
public String deleteuser(@QueryParam("emailid") String emailId){
	String response="UnAble to delete user";
	Map<String , Patientinfo> patients=Patientdatabase.getDatabase();
	patients.remove(emailId);
	Patientdatabase.setDatabase(patients);
	response="success";
	return response;
	
}
@GET
@Path("list/{pid :[a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,3} }")
@Produces(MediaType.APPLICATION_XML)
public Patientlist get(@PathParam("pid") String patient_id){
	Map<String , Patientinfo> patients=Patientdatabase.getDatabase();
	List<Patientinfo> patientlist =new ArrayList<Patientinfo>();
	patientlist.add(patients.get(patient_id));
	Patientlist plist=new Patientlist();
	plist.setPatients(patientlist);
	return plist;
	
}
@POST
@Path("{pid}/{did}")
@Produces("text/plain")
public String relate(@PathParam("pid") String pid , @PathParam("did") String did){
	String response="unable to perform operation";
	Map<String , Doctorinfo> doctors=Doctordatabase.getDatabase();
	Map<String , Patientinfo> patients=Patientdatabase.getDatabase();
	//final List<Patientinfo> doctPatientsList = new ArrayList<Patientinfo>();
	Patientinfo pinfo= patients.get(pid);
	Doctorinfo dinfo= doctors.get(did);
	doctPatientsList.add(pinfo);
	
	dinfo.setPatients(doctPatientsList);
	
	//Doctorinfo.setPatients(patientlist);
	Doctordatabase.setDatabase(doctors);
	response="success";
	return response;
}

public static List<Patientinfo> doctPatientsList = new ArrayList<Patientinfo>();
@DELETE
@Path("{pid}/{did}")
@Produces("text/plain")
public String deletepatient(@PathParam("pid") String pid , @PathParam("did") String did){
	String response="unable to perform operation";
	Map<String , Doctorinfo> doctors=Doctordatabase.getDatabase();
	Map<String , Patientinfo> patients=Patientdatabase.getDatabase();
	doctPatientsList.remove(patients.get(pid));
	Doctorinfo dinfo= doctors.get(did);
	dinfo.setPatients(doctPatientsList);
	Doctordatabase.setDatabase(doctors);
	response="success";
	return response;
	
	
}

}