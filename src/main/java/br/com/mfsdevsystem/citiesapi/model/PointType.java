package br.com.mfsdevsystem.citiesapi.model;


import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.postgresql.geometric.PGpoint;
import org.springframework.data.geo.Point;


public class PointType implements UserType {

    public static final PointType INSTANCE = new PointType();

    @Override
    public int[] sqlTypes() {
      return new int[] {java.sql.Types.OTHER};
    }

	@Override
	public Class<Point> returnedClass() {
		
		return Point.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return false;
	}

	@Override
	public int hashCode(Object x) {
		return 0;
	}

	 @Override
	  public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session,
	                            Object owner) throws HibernateException, SQLException {
	    /* 1st 
	    Object object = rs.getObject(names[0]);
	    Double[] points = StringLocationUtils.transform(object.toString());
	    //return new Point(points[0], points);
	    return new Point(points[0], points[1]);
        */
	    /* 2nd */ 
		String stringValue = rs.getString(names[0]);
		
		
		if (stringValue == null) {
		   return null;
		 }
		// Transformar a String em um PGpoint
		
		PGpoint value = new PGpoint(stringValue);
	    //PGpoint value = (PGpoint) rs.getObject(names[0]);
	    return new Point(value.x, value.y);
	    
	  }

	 @Override
	  public void nullSafeSet(PreparedStatement st, Object value, int index,
	                          SharedSessionContractImplementor session)
	      throws HibernateException, SQLException {

	  }

	@Override
	public Object deepCopy(Object value) {
		
		 return null;
	}

	@Override
	public boolean isMutable() {
		
		return false;
	}

	@Override
	public Serializable disassemble(Object value) {
		
	   return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) {
		 if (cached == null)
	            return null;
	        return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		
		return null;
	}
	
	

}
