package com.habte.real_estate.realtor.model;

import java.util.Objects;

import com.habte.real_estate.realtor.dto.AddressDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
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
	
	
	public static Address convertToAddressEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setSubCity(addressDTO.getSubCity());
        address.setDistrict(addressDTO.getDistrict());
        address.setHouseNo(addressDTO.getHouseNo());

        // Set other properties as needed

        return address;
		}
}
