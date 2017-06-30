package com.wipro.training.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
@Entity
public class Course extends BaseEntity {
	private static final long serialVersionUID = 1606445939623655417L;

	public Course() {
		super();
	}

	public Course(final Long id) {
		super(id);
	}

	@Column(name = "course_number")
	private String courseNumber;

	@Column(name = "title")
	private String title;

	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(final String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(final List<Student> students) {
		this.students = students;
	}
}
