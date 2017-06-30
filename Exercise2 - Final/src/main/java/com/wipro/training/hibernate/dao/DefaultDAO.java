package com.wipro.training.hibernate.dao;

import com.wipro.training.hibernate.entity.BaseEntity;
import com.wipro.training.hibernate.module.PersistenceModule;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @param <T>
 * @since Sep 20, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
public class DefaultDAO<T extends BaseEntity> {

	protected final EntityManager entityManager;
	private final Class<T> entityClass;

	public DefaultDAO(final Class<T> entityClass) {
		this.entityManager = PersistenceModule.getEntityManager();
		this.entityClass = entityClass;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public List<T> findAll() {
		final String hql = "from " + entityClass.getName();
		final TypedQuery<T> query = entityManager.createQuery(hql, entityClass);
		return query.getResultList();
	}

	public T find(final Long id) {
		return entityManager.find(entityClass, id);
	}

	public void delete(final T entity) {
		getTransaction().begin();
		entityManager.remove(entity);
		getTransaction().commit();
	}

	public void save(final T entity) {
		getTransaction().begin();
		entityManager.persist(entity);
		getTransaction().commit();
	}

	public T update(final T entity) {
		getTransaction().begin();
		final T updated = entityManager.merge(entity);
		getTransaction().commit();
		return updated;
	}

	public void refresh(final T entity) {
		entityManager.refresh(entity);
	}

	public boolean contains(final T entity) {
		return entityManager.contains(entity);
	}

	protected EntityTransaction getTransaction() {
		return entityManager.getTransaction();
	}

	public void dispose() {
		PersistenceModule.getEntityManager().close();
		PersistenceModule.getFactory().close();
	}

}
