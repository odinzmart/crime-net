package com.project.crimeportal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
public class Crimeportalcontroller {
	
@Autowired
Crimeportalservice crimeportalservice;

	@GetMapping("crimeportal")
	public List<Crimeportal>allcrimereport(){
		return crimeportalservice.allcrimereport();
	}
	
	@GetMapping("crimeportal/searchbyname")
	public List<Crimeportal> getreportbyname(@RequestParam("name")String name){
		return crimeportalservice.getreportbyname(name);
	}
	
	@PostMapping("crimeportal")
	public String addcrimereport(@RequestParam("caseid") int caseid,
			@RequestParam("name") String name,
			@RequestParam("location")String location,
			@RequestParam("crimetype")String crimetype,
			@RequestParam("crimestatus")String crimestatus){
		 crimeportalservice.addcrimereport(caseid,name,location,crimetype,crimestatus);
		 return "success";
	}
	
	@PutMapping("crimeportal/{caseid}")
	public String updatecrimereport(@PathVariable("caseid") int caseid,
			@RequestParam("name") String name,
			@RequestParam("location")String location,
			@RequestParam("crimetype")String crimetype,
			@RequestParam("crimestatus")String crimestatus) {
		
		 return crimeportalservice.updatecrimereport(caseid,name,location,crimetype,crimestatus);
		 
	}

}

