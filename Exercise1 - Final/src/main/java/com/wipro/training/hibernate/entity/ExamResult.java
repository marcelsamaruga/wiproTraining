package com.wipro.training.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
@Entity
public class ExamResult {

	@Id
	private Long id;

	@Column(name = "exam_date")
	@Temporal(TemporalType.DATE)
	private Date examDate;

	@Column(name = "mark")
	private int mark;

	@ManyToOne
	private Student student;

	@Transient
	private String examLocation;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(final Date examDate) {
		this.examDate = examDate;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(final int mark) {
		this.mark = mark;
	}

	public String getExamLocation() {
		return examLocation;
	}

	public void setExamLocation(final String examLocation) {
		this.examLocation = examLocation;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(final Student student) {
		this.student = student;
	}
}
