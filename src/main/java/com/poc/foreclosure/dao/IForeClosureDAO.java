package com.poc.foreclosure.dao;

import java.util.List;

import com.poc.foreclosure.model.Property;

public interface IForeClosureDAO {
	
	public List<Property> getAllProperties();
	public Property getPropertyById(long propertyId);

}
