package com.poc.foreclosure.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.poc.foreclosure.dao.IForeClosureDAO;
import com.poc.foreclosure.dao.impl.mapper.PropertyRowMapper;
import com.poc.foreclosure.model.Property;

public class ForeClosureDAOImpl implements IForeClosureDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Property> getAllProperties() {

		return template.query("select * from FORECLOSURE_PROPERTIES",
				new PropertyRowMapper());
	}

	@Override
	public Property getPropertyById(long propertyId) {

		return template.queryForObject(
				"select * from FORECLOSURE_PROPERTIES WHERE PROPERTY_ID=?",
				new Object[] { propertyId }, new PropertyRowMapper());
	}

}
