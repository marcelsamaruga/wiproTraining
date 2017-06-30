package com.wipro.training.hibernate.sandbox;

import com.wipro.training.hibernate.dao.StudentDAO;
import com.wipro.training.hibernate.entity.Student;

/**
 *
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
public class Example3Merge {
	public static void main(final String[] args) {
		final StudentDAO dao = new StudentDAO();

		final Student student = new Student(1L);
		student.setName("Mariazinha");
		student.setRegistrationNumber(20);

		final Student updated = dao.merge(student);

		System.out.println(updated);

		dao.dispose();
	}
}
