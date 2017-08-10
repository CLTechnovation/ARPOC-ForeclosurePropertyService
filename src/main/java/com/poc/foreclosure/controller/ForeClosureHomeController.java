package com.poc.foreclosure.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poc.foreclosure.model.Property;
import com.poc.foreclosure.service.IForeClosureService;
import com.poc.foreclosure.util.RestURIConstants;

/**
 * Handles requests for the application home page.
 */
@RestController
public class ForeClosureHomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(ForeClosureHomeController.class);
	
	@Autowired
	IForeClosureService foreClosureService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = RestURIConstants.TEST, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = RestURIConstants.GET_PROPERTY, method = RequestMethod.GET)
	public Property getProprty(@PathVariable("propertyId") int propertyId) {
		logger.info("Start getProperty. ID="+propertyId);
		
		return foreClosureService.fetchPropertyWithId(propertyId);
	}
	
	@RequestMapping(value = RestURIConstants.GET_PROPERTY_LAT_LONG, method = RequestMethod.GET)
	public List<Property> getProprtyList(@PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) {
		logger.info("Start getPropertyList. latitude="+latitude+", longitude :"+longitude );
		return foreClosureService.fetchNearbyPropertyList(latitude, longitude);
	}
	
	@RequestMapping(value = RestURIConstants.GET_ALL_PROPERTY, method = RequestMethod.GET)
	public List<Property> getAllProperties() {
		logger.info("Start getAllProperties.");
		List<Property> properties = new ArrayList<Property>();
		
		return properties;
	}
	
}
