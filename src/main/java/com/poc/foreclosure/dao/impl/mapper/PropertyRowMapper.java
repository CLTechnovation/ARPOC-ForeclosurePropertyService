package com.poc.foreclosure.dao.impl.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.poc.foreclosure.model.Property;

public class PropertyRowMapper implements RowMapper<Property> {

    @Override
    public Property mapRow(ResultSet rs, int line) throws SQLException {
    	SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
    	Property property1 = new Property();
    	property1.setPropertyId(rs.getInt("PROPERTY_ID"));
		property1.setName(rs.getString("NAME"));
		property1.setAddress(rs.getString("ADDRESS"));
		property1.setPrice(rs.getDouble("PRICE"));
		property1.setSellDate(rs.getDate("SELL_DATE")!=null?format.format(rs.getDate("SELL_DATE")):"");
		property1.setLatitude(rs.getDouble("LATITUDE"));
		property1.setLongitude(rs.getDouble("LONGITUDE"));
		return property1;
    }

}