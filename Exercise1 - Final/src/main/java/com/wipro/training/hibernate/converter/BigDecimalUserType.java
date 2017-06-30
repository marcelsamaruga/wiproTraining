package com.wipro.training.hibernate.converter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

/**
 *
 * @since Sep 13, 2015
 * @author Robson Enke <robsonenke@gmail.com>
 */
public class BigDecimalUserType implements UserType {

	private static final int[] SQL_TYPES = new int[] { Types.DECIMAL, Types.INTEGER };

	@Override
	public Object assemble(final Serializable arg0, final Object arg1) throws HibernateException {
		return deepCopy(arg0);
	}

	@Override
	public Object deepCopy(final Object arg0) throws HibernateException {
		return arg0;
	}

	@Override
	public Serializable disassemble(final Object arg0) throws HibernateException {
		return (Serializable) arg0;
	}

	@Override
	public boolean equals(final Object arg0, final Object arg1) throws HibernateException {
		return arg0.equals(arg1);
	}

	@Override
	public int hashCode(final Object arg0) throws HibernateException {
		return arg0.hashCode();
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Object nullSafeGet(final ResultSet rs, final String[] names, final SessionImplementor implementor, final Object owner)
			throws HibernateException, SQLException {
		final BigDecimal bigDecimal = rs.getBigDecimal(names[0]);
		if (bigDecimal == null)
			return null;
		return bigDecimal.setScale(rs.getInt(names[1]), BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public void nullSafeSet(final PreparedStatement st, final Object value, final int index, final SessionImplementor implementor)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.DECIMAL);
			st.setNull(index + 1, Types.INTEGER);
		} else {
			st.setBigDecimal(index, (BigDecimal) value);
			st.setInt(index + 1, ((BigDecimal) value).scale());
		}
	}

	@Override
	public Object replace(final Object arg0, final Object arg1, final Object arg2) throws HibernateException {
		return arg0;
	}

	@Override
	public Class<?> returnedClass() {
		return BigDecimal.class;
	}

	@Override
	public int[] sqlTypes() {
		return SQL_TYPES;
	}

}