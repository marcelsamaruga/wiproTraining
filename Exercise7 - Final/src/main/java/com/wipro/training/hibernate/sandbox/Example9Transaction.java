package com.wipro.training.hibernate.sandbox;

import com.wipro.training.hibernate.dao.StudentDAO;

/**
 *
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
public class Example9Transaction {
	public static void main(final String[] args) {
		final StudentDAO dao = new StudentDAO();

		dao.transactionExample();

		System.out.println(dao.findAll());

		dao.dispose();
	}
}
