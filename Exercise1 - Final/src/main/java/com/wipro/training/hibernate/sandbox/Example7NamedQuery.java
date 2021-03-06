package com.wipro.training.hibernate.sandbox;

import java.util.List;

import com.wipro.training.hibernate.dao.StudentDAO;
import com.wipro.training.hibernate.entity.Student;

/**
 *
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
public class Example7NamedQuery {
	public static void main(final String[] args) {
		final StudentDAO dao = new StudentDAO();

		final List<Student> students = dao.findAllStudents();

		System.out.println(students);

		dao.dispose();
	}
}
