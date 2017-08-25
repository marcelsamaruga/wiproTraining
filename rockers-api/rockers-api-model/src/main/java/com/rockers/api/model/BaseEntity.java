package com.rockers.api.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.Hibernate;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity{

	private static final long serialVersionUID = 5333747833084316462L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	
    @Override
    public int hashCode() {
        return getId() == null ? System.identityHashCode(this) : getId().hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return this == obj || obj != null && Hibernate.getClass(obj).equals(getClass()) && ((BaseEntity) obj).getId().equals(getId());
    }
	
}
