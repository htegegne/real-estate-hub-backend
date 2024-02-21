package com.habte.real_estate.property.model;

import com.habte.real_estate.realtor.model.Realtor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Property {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyId;
	
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "addressId") private PropertyAddress address;
	 */
	
	@ManyToOne
	@JoinColumn(name = "realtorId")
	private Realtor realtor;
	
	
	
}
