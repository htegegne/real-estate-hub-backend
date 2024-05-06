package com.habte.real_estate.realtor;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

public class Address implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;
	
	@Column(name = "sub_city")
	private String subCity;
	private String district;
	@Column(name = "house_number")
	private String houseNo;
	// add id photo
	
	
	public Integer getAddressId() {
		return addressId;
	}
	
	public Address(Integer addressId, String subCity, String district, String houseNo) {
		super();
		this.addressId = addressId;
		this.subCity = subCity;
		this.district = district;
		this.houseNo = houseNo;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String subCity, String district, String houseNo) {
		super();
		this.subCity = subCity;
		this.district = district;
		this.houseNo = houseNo;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getSubCity() {
		return subCity;
	}
	public void setSubCity(String subCity) {
		this.subCity = subCity;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(addressId, district, houseNo, subCity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressId, other.addressId) && Objects.equals(district, other.district)
				&& Objects.equals(houseNo, other.houseNo) && Objects.equals(subCity, other.subCity);
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", subCity=" + subCity + ", district=" + district + ", houseNo="
				+ houseNo + "]";
	}
	
	 public static AddressDTO convertToAddressDTO(Address address) {
	        AddressDTO addressDTO = new AddressDTO();
	        addressDTO.setAddressId(address.getAddressId());
	        addressDTO.setSubCity(address.getSubCity());
	        addressDTO.setDistrict(address.getDistrict());
	        addressDTO.setHouseNo(address.getHouseNo());

	        // Set other properties as needed

	        return addressDTO;
	    }
	
}
