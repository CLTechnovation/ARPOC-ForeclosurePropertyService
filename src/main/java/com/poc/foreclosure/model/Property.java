package com.poc.foreclosure.model;

import java.io.Serializable;

public class Property implements Serializable {
	 
	public Property() {
	}
		private static final long serialVersionUID = 1L;
		private int propertyId;
		private String name;
		private String address;
		private double price;
		private String sellDate;
		private double latitude;
		private double longitude;
		private double distanceFromCurrentPlace;
		
		public int getPropertyId() {
			return propertyId;
		}
		public void setPropertyId(int propertyId) {
			this.propertyId = propertyId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getSellDate() {
			return sellDate;
		}
		public void setSellDate(String sellDate) {
			this.sellDate = sellDate;
		}

		public double getLatitude() {
			return latitude;
		}

		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}

		public double getLongitude() {
			return longitude;
		}

		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		
		// This is derived field . not be saved in DB
		public double getDistanceFromCurrentPlace() {
			return distanceFromCurrentPlace;
		}
		public void setDistanceFromCurrentPlace(double distanceFromCurrentPlace) {
			this.distanceFromCurrentPlace = distanceFromCurrentPlace;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("ID:"+propertyId+", Name :"+name+", Address: "+address+", Price: "+price+", Sell Date : "+sellDate+", Latitude :"+latitude+", Longitude :"+longitude);
			return builder.toString();
		}
		
}
