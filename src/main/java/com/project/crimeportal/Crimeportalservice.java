package com.project.crimeportal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Crimeportalservice {
@Autowired
Crimeportalrepo crimeportalrepo;

	public List<Crimeportal> allcrimereport() {
		return crimeportalrepo.findAll();
	}

	public void addcrimereport(int caseid, String name, String location, String crimetype, String crimestatus) {
		Crimeportal crimeportal=new Crimeportal(caseid,name,location,crimetype,crimestatus);
	   crimeportalrepo.save(crimeportal);
	}

	public String updatecrimereport(int caseid, String name, String location, String crimetype, String crimestatus) {
		Crimeportal crime=crimeportalrepo.findById(caseid).orElse(null);
		if(crime !=null) {
			crime.setName(name);
			crime.setLocation(location);
			crime.setCrimetype(crimetype);
			crime.setCrimestatus(crimestatus);
			crimeportalrepo.save(crime);
			return "succes";
		}
		return "no number " + caseid + " was here";
	}

	public List<Crimeportal> getreportbyname(String name) {
		return crimeportalrepo.findByname(name);
	}

}
