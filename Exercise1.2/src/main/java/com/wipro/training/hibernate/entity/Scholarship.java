package com.wipro.training.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
@Entity
public class Scholarship extends BaseEntity {
	private static final long serialVersionUID = 7886929755101391099L;

	public Scholarship() {
		super();
	}

	public Scholarship(final Long id) {
		super(id);
	}

	@Column(name = "description")
	private String description;

	@Column(name = "amount")
	private Integer amount;

	@OneToOne
	@JoinColumn(name = "student_id", unique = true)
	private Student grantedTo;

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(final Integer amount) {
		this.amount = amount;
	}

	public Student getGrantedTo() {
		return grantedTo;
	}

	public void setGrantedTo(final Student grantedTo) {
		this.grantedTo = grantedTo;
	}
}
