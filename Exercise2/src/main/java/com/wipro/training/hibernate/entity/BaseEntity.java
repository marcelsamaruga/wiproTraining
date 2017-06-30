package com.wipro.training.hibernate.entity;

import org.hibernate.Hibernate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Basic interface for persistent entities
 *
 * @since Sep 20, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */

public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 8747189793690340570L;

	public BaseEntity() {
	}

	public BaseEntity(final Long id) {
		this.id = id;
	}

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return getId() == null ? System.identityHashCode(this) : getId().hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		return this == obj || obj != null && Hibernate.getClass(obj).equals(getClass()) && ((BaseEntity) obj).getId().equals(getId());
	}
}
