package com.habte.real_estate.property;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.habte.real_estate.realtor.Realtor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@Column(name = "property_id")
    private Integer propertyId;
	
	private String title;
	
	private String description;
	
	private double price;
	
	private double area;
	
	private int bedrooms;
	
	private double bathrooms;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "property_address_id")
	private PropertyAddress propertyAddress;
	
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "addressId") private PropertyAddress address;
	 */
	//@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "realtor_id")
	private Realtor realtor;

	/**
	 * @return the propertyId
	 */
	public Integer getPropertyId() {
		return propertyId;
	}

	/**
	 * @param propertyId the propertyId to set
	 */
	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the area
	 */
	public double getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(double area) {
		this.area = area;
	}

	/**
	 * @return the bedrooms
	 */
	public int getBedrooms() {
		return bedrooms;
	}

	/**
	 * @param bedrooms the bedrooms to set
	 */
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	/**
	 * @return the bathrooms
	 */
	public double getBathrooms() {
		return bathrooms;
	}

	/**
	 * @param bathrooms the bathrooms to set
	 */
	public void setBathrooms(double bathrooms) {
		this.bathrooms = bathrooms;
	}

	/**
	 * @return the propertyAddress
	 */
	public PropertyAddress getPropertyAddress() {
		return propertyAddress;
	}

	/**
	 * @param propertyAddress the propertyAddress to set
	 */
	public void setPropertyAddress(PropertyAddress propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	/**
	 * @return the realtor
	 */
	public Realtor getRealtor() {
		return realtor;
	}

	/**
	 * @param realtor the realtor to set
	 */
	public void setRealtor(Realtor realtor) {
		this.realtor = realtor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, bathrooms, bedrooms, description, price, propertyAddress, propertyId, realtor, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		return Double.doubleToLongBits(area) == Double.doubleToLongBits(other.area)
				&& Double.doubleToLongBits(bathrooms) == Double.doubleToLongBits(other.bathrooms)
				&& bedrooms == other.bedrooms && Objects.equals(description, other.description)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(propertyAddress, other.propertyAddress)
				&& Objects.equals(propertyId, other.propertyId) && Objects.equals(realtor, other.realtor)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", title=" + title + ", description=" + description + ", price="
				+ price + ", area=" + area + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms
				+ ", propertyAddress=" + propertyAddress + ", realtor=" + realtor + "]";
	}
	
	
	
}
