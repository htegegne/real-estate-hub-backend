package com.habte.real_estate.property.model;

import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PropertyAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	private String subCity;
	private String district;
	private String houseNo;
	private String blockName;
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the subCity
	 */
	public String getSubCity() {
		return subCity;
	}
	/**
	 * @param subCity the subCity to set
	 */
	public void setSubCity(String subCity) {
		this.subCity = subCity;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @return the houseNo
	 */
	public String getHouseNo() {
		return houseNo;
	}
	/**
	 * @param houseNo the houseNo to set
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	/**
	 * @return the blockName
	 */
	public String getBlockName() {
		return blockName;
	}
	/**
	 * @param blockName the blockName to set
	 */
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(addressId, blockName, district, houseNo, subCity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyAddress other = (PropertyAddress) obj;
		return Objects.equals(addressId, other.addressId) && Objects.equals(blockName, other.blockName)
				&& Objects.equals(district, other.district) && Objects.equals(houseNo, other.houseNo)
				&& Objects.equals(subCity, other.subCity);
	}
	@Override
	public String toString() {
		return "PropertyAddress [addressId=" + addressId + ", subCity=" + subCity + ", district=" + district
				+ ", houseNo=" + houseNo + ", blockName=" + blockName + "]";
	}
	
}
