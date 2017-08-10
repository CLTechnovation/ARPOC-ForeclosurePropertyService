/**
 * 
 */
package com.poc.foreclosure.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.foreclosure.dao.IForeClosureDAO;
import com.poc.foreclosure.model.Property;
import com.poc.foreclosure.service.IForeClosureService;
import com.poc.foreclosure.util.DistanceCalculator;
import com.poc.foreclosure.util.DistanceUnit;

/**
 * @author u455612
 *
 */

@Service
public class ForeClosureServiceImpl implements IForeClosureService{

	 @Resource(name="myProperties")
	  private Properties myProperties;
	 @Autowired
	 private IForeClosureDAO foreClosureDAO;
	
	@Override
	public List<Property> fetchNearbyPropertyList(double latitude, double longitude) {
		double distance = Double.parseDouble(myProperties.getProperty("distance"));
		//List<Property> propertyList =  buildList();
		List<Property> propertyList =foreClosureDAO.getAllProperties();
		List<Property> newPropertyList = new ArrayList<Property>();
		for(Property prp: propertyList){
			double currentDistance = DistanceCalculator.distance(latitude, longitude, prp.getLatitude(), prp.getLongitude(), DistanceUnit.KILOMETERS);
			if(currentDistance < distance){
				prp.setDistanceFromCurrentPlace(currentDistance);
				newPropertyList.add(prp);
			}
		}
		return newPropertyList;
	}

	private List<Property> buildList(){
		List<Property> propertyList = new ArrayList<Property>();
		Property property1=new Property();
		property1.setPropertyId(1);
		property1.setName("ABC");
		property1.setAddress("ABC address");
		property1.setPrice(10000.00);
		property1.setSellDate("14 Oct 2015");
		property1.setLatitude(37.789252);
		property1.setLongitude(-122.403775);
		propertyList.add(property1);
		
		
		
		Property property2=new Property();
		property2.setPropertyId(2);
		property2.setName("Titan");
		property2.setAddress("Titan building");
		property2.setPrice(18000.00);
		property2.setSellDate("14 Dec 2015");
		propertyList.add(property2);
		property2.setLatitude(37.790223);
		property2.setLongitude(-122.400084);
		
		Property property3=new Property();
		property3.setPropertyId(3);
		property3.setName("XYZ ");
		property3.setAddress("XYZ address");
		property3.setPrice(67000.00);
		property3.setSellDate("8 Feb 2017");
		property3.setLatitude(37.790787);
		property3.setLongitude(-122.404043);
		propertyList.add(property3);
		
		Property property4=new Property();
		property4.setPropertyId(4);
		property4.setName("DGDGDG");
		property4.setAddress("DGDGDG address");
		property4.setPrice(65000.00);
		property4.setSellDate("25 Nov 2015");
		property4.setLatitude(37.791117);
		property4.setLongitude(-122.400766);
		propertyList.add(property4);
		
		Property property5=new Property();
		property5.setPropertyId(5);
		property5.setName("Sam Hospital");
		property5.setAddress("Sam Hospital address");
		property5.setPrice(65000.00);
		property5.setSellDate("25 Nov 2015");
		property5.setLatitude(37.785631);
		property5.setLongitude(-122.414595);
		propertyList.add(property5);
		return propertyList;
	}

	@Override
	public Property fetchPropertyWithId(long propertyId) {
	/*	Property property1=new Property();
		property1.setPropertyId(1);
		property1.setName("Onion Sheds");
		property1.setAddress("Onion Sheds,Whitestown,Greenore,Co. Louth");
		property1.setPrice(10000.00);
		property1.setSellDate("14 Oct 2015");
		property1.setLatitude(37.7896);
		property1.setLongitude(-122.402);*/
		Property property1=foreClosureDAO.getPropertyById(propertyId);
		property1.setDistanceFromCurrentPlace(5.12);
		return property1;
	}
}
