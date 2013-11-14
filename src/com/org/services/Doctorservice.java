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
//import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
//import javax.ws.rs.FormParam;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.orf.info.Doctorinfo;
import com.org.database.Doctordatabase;
import com.org.list.Doctorlist;

@Path("doctor")
public class Doctorservice {
@GET
@Path("list")
@Produces(MediaType.APPLICATION_XML)
public Doctorlist getdoctors(){
	Map<String , Doctorinfo> doctors= Doctordatabase.getDatabase();
	Iterator<String> email=doctors.keySet().iterator();
	List<Doctorinfo> doctorlist=new ArrayList<Doctorinfo>();
	while(email.hasNext()){
		String emailid=email.next();
		doctorlist.add(doctors.get(emailid));
	}
	Doctorlist dlist=new Doctorlist();
	dlist.setDoctors(doctorlist);
	return dlist;
}
@POST
@Path("list")
@Produces("text/plain")
public String adddoctor(@QueryParam("fname") String firstName,
		@QueryParam("lname") String lastName,
		@QueryParam("hname") String hname,
		@QueryParam("emailid") String emailId,
		@QueryParam("nemailid") String nemailId){
			String response="UnAble to Add user";
			Map<String , Doctorinfo> doctors=Doctordatabase.getDatabase();
			Doctorinfo newdoctor=new Doctorinfo();
			newdoctor.setFirstname(firstName);
			newdoctor.setLastname(lastName);
			newdoctor.setEmail(nemailId);
			newdoctor.setHospitalname(hname);
			doctors.put(newdoctor.getEmail(), newdoctor);
			Doctordatabase.setDatabase(doctors);
			response="success";
			return response;
			
		}
@PUT
@Path("list")
@Produces("text/plain")
public String updatedoctor(@QueryParam("fname") String firstName,
		@QueryParam("lname") String lastName,
		@QueryParam("hname") String hname,
		@QueryParam("emailid") String emailId,
		@QueryParam("nemailid") String nemailId){
	String response="UnAble to Add user";
	Map<String , Doctorinfo> doctors=Doctordatabase.getDatabase();
	Doctorinfo udoctor=doctors.get(emailId);
	udoctor.setFirstname(firstName);
	udoctor.setLastname(lastName);
	udoctor.setEmail(nemailId);
	udoctor.setHospitalname(hname);
	response="success";
	return response;
}
@DELETE
@Path("list")
@Produces("text/plain")
public String deletedoctor(@QueryParam("emailid") String emailId){
	String response="UnAble to delete user";
	Map<String , Doctorinfo> doctors=Doctordatabase.getDatabase();
	doctors.remove(emailId);
	Doctordatabase.setDatabase(doctors);
	response="success";
	return response;
	
}
@GET
@Path("list/{pid : [a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}}")
@Produces(MediaType.APPLICATION_XML)
public Doctorlist get(@PathParam("pid") String doctor_id){
	Map<String , Doctorinfo> doctors=Doctordatabase.getDatabase();
	List<Doctorinfo> doctorlist =new ArrayList<Doctorinfo>();
	doctorlist.add(doctors.get(doctor_id));
	Doctorlist dlist=new Doctorlist();
	dlist.setDoctors(doctorlist);
	
	return dlist;
}

}
