package com.wipro.training.hibernate.sandbox;

import com.wipro.training.hibernate.dao.StudentDAO;
import com.wipro.training.hibernate.entity.Student;

/**
 *
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
public class Example5Remove {
	public static void main(final String[] args) {
		final StudentDAO dao = new StudentDAO();

		final Student student = dao.find(1L);
		dao.delete(student);

		dao.dispose();
	}
}
