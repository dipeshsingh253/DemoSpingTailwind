package com.ecommerce.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private String buildingName;
	private String societyName;
	private String area;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
}
