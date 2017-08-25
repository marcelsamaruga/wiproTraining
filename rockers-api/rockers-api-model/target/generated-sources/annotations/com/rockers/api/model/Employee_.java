package com.rockers.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ extends com.rockers.api.model.BaseEntity_ {

	public static volatile SingularAttribute<Employee, String> mcId;
	public static volatile SingularAttribute<Employee, String> wiproId;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Team> team;
	public static volatile SingularAttribute<Employee, User> user;
	public static volatile SingularAttribute<Employee, String> email;

}

