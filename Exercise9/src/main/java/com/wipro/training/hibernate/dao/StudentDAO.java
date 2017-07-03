package com.wipro.training.hibernate.dao;

import com.wipro.training.hibernate.entity.Student;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
public class StudentDAO extends DefaultDAO<Student> {

	public StudentDAO() {
		super(Student.class);
	}


	public List<Student> findStudentsByRegistrationNumber(final Integer registrationNumber) {
		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<Student> criteria = builder.createQuery(Student.class);

		final ParameterExpression<Integer> parameter = builder.parameter(Integer.class);

		final Root<Student> s = criteria.from(Student.class);
		criteria.select(s).where(builder.equal(s.get("registrationNumber"), parameter));

		final TypedQuery<Student> typedQuery = entityManager.createQuery(criteria);
		typedQuery.setParameter(parameter, registrationNumber);
		return typedQuery.getResultList();
	}

	public void transactionExample() {
		try {
			getTransaction().begin();

			final List<Student> students = findAll();
			int i = 0;
			for (final Student student : students)
				student.setRegistrationNumber(i++);

			getTransaction().commit();
		} catch (final Exception e) {
			getTransaction().rollback();
		}
	}
}
