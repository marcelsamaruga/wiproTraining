package com.rockers.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Employee extends BaseEntity {

	@Column(name = "name")
	private String name;
	
	@Column(name="wipro_id")
	private String wiproId;
	
	@Column(name = "mc_id")
	private String mcId;
	
	@Column(name = "email")
	private String email;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Team team;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

}
