package com.rockers.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Team.class)
public abstract class Team_ extends com.rockers.api.model.BaseEntity_ {

	public static volatile SingularAttribute<Team, Contract> contract;
	public static volatile SingularAttribute<Team, String> name;
	public static volatile ListAttribute<Team, Employee> employees;

}

