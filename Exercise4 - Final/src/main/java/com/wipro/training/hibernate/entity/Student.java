package com.wipro.training.hibernate.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.google.common.base.MoreObjects;

/**
 *
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
@Entity
@NamedQuery(name = Student.QUERY_SELECT_ALL, query = "select s from Student s")
public class Student extends BaseEntity {
	private static final long serialVersionUID = 8506212579379285824L;

	public static final String QUERY_SELECT_ALL = "select_all";

	public Student() {
		super();
	}

	public Student(final Long id) {
		super(id);
	}

	@Column(name = "registration_number")
	private Integer registrationNumber;

	@Column(name = "name")
	private String name;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "grantedTo")
	private Scholarship scholarship;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<ExamResult> examResults;

	//@ManyToMany(mappedBy = "students")
	@Transient
	private List<Course> courses;

	public Integer getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(final Integer registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public List<ExamResult> getExamResults() {
		return examResults;
	}

	public void setExamResults(final List<ExamResult> examResults) {
		this.examResults = examResults;
	}

	public Scholarship getScholarship() {
		return scholarship;
	}

	public void setScholarship(Scholarship scholarship) {
		this.scholarship = scholarship;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("id", getId()).add("name", getName()).add("registrationNumber", getRegistrationNumber()).toString();
	}
}
