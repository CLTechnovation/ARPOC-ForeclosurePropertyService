/**
 * 
 */
package com.poc.foreclosure.service;

import java.util.List;

import com.poc.foreclosure.model.Property;

/**
 * @author u455612
 *
 */
public interface IForeClosureService {
	List<Property> fetchNearbyPropertyList(double latitude, double longitude);
	Property fetchPropertyWithId(long propertyId);
}
