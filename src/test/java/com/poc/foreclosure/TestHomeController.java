package com.poc.foreclosure;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.poc.foreclosure.model.Property;
import com.poc.foreclosure.util.RestURIConstants;


public class TestHomeController {
	public static final String SERVER_URI = "http://localhost:8091/foreclosure";

	public static void main(String args[]) {

		testGetProperty();
		System.out.println("*****");
		testGetAllProperties();
		
		System.out.println("******* Get nearby properties **********");
		testGetNearbyProperties();
	}

	private static void testGetProperty() {

		RestTemplate restTemplate = new RestTemplate();
		Property property = restTemplate.getForObject(SERVER_URI + "/nearby/property/1",
				Property.class);
		System.out.println(property.toString());

	}

	private static void testGetAllProperties() {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> properties = restTemplate.getForObject(SERVER_URI
				 +RestURIConstants.GET_ALL_PROPERTY, List.class);
		System.out.println(properties.size());
		for (LinkedHashMap map : properties) {
			System.out.println("ID=" + map.get("propertyId") + ",Name="
					+ map.get("name") + ",Address=" + map.get("address")
					+ ",Price=" + map.get("price") + ",SellDate="
					+ map.get("sellDate")+", Latitude :"+map.get("latitude")+", Longitude: "+map.get("longitude"));
			;
		}

	}
	
	private static void testGetNearbyProperties() {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> properties = restTemplate.getForObject(SERVER_URI
				 +"/nearby/property/12.956669/77.701031", List.class);
		System.out.println(properties.size());
		for (LinkedHashMap map : properties) {
			System.out.println("ID=" + map.get("propertyId") + ",Name="
					+ map.get("name") + ",Address=" + map.get("address")
					+ ",Price=" + map.get("price") + ",SellDate="
					+ map.get("sellDate") );
			;
		}

	}
}
