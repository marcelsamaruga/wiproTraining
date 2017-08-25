package com.rockers.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Contract extends BaseEntity {

	@Column(name = "name", nullable = false, unique=false)
	private String name;

}
