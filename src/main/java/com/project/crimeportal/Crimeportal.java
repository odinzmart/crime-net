package com.project.crimeportal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Crimeportal {

	@Id
	private int caseid;
	private String name;
	private String location;
	private String crimetype;
	private String crimestatus;
}
