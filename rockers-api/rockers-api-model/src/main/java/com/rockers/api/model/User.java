package com.rockers.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table
public class User extends BaseEntity {

	@Column(name="login", nullable = false)
	private String login;
	
	@Column(name="password", nullable = false)
	private String password;

	@OneToOne	
	private Employee employee;
}
