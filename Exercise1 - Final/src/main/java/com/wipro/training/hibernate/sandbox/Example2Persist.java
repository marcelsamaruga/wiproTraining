package com.wipro.training.hibernate.sandbox;

import com.wipro.training.hibernate.dao.StudentDAO;
import com.wipro.training.hibernate.entity.Student;

/**
 *
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
public class Example2Persist {
	public static void main(final String[] args) {
		final StudentDAO dao = new StudentDAO();

		final Student student = new Student();
		student.setName("Joaozinho");
		student.setRegistrationNumber(10);
		dao.insert(student);

		dao.dispose();
	}
}
