package com.wipro.training.hibernate.module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @since Sep 13, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
public class PersistenceModule {
	private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory factory;

	public static EntityManagerFactory getFactory() {
		if (factory == null)
			factory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
		return factory;
	}

	public static EntityManager getEntityManager() {
		EntityManager entityManager = ENTITY_MANAGER_CACHE.get();
		if (entityManager == null)
			ENTITY_MANAGER_CACHE.set(entityManager = getFactory().createEntityManager());
		return entityManager;
	}
}
