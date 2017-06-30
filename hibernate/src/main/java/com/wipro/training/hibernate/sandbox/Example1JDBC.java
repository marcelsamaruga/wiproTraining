package com.wipro.training.hibernate.sandbox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wipro.training.hibernate.entity.Student;

/**
 *
 * @since Sep 21, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
public class Example1JDBC {
	public List<Student> listStudentsByPrefix(final String name) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = getConnection();
			statement = connection.prepareStatement("select s.id as id, s.name as name from student s where s.name like ?");
			statement.setString(1, name);

			final ResultSet resultSet = statement.executeQuery();
			final List<Student> students = new ArrayList<Student>();
			while (resultSet.next()) {
				final Student student = new Student();
				student.setId(resultSet.getLong("id"));
				student.setName(resultSet.getString("name"));
				students.add(student);
			}

			return students;

		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			if (connection != null)
				try {
					connection.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}

	private Connection getConnection() {
		// mock method for retrieving connection
		return null;
	}
}
