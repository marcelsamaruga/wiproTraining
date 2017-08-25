package com.rockers.api.model;


import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table
public class Team extends BaseEntity{

	@Column(name = "name")
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Contract contract;
	
	@OneToMany
	private List<Employee> employees;

		
		
}
