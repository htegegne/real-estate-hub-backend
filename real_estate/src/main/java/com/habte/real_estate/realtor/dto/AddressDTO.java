package com.habte.real_estate.realtor.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.habte.real_estate.realtor.model.Address;

public class AddressDTO {

	private Integer addressId;
	
	private String subCity;
	private String district;
	private String houseNo;
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
	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", subCity=" + subCity + ", district=" + district + ", houseNo="
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
	 public static List<AddressDTO> convertToAddressDTOList(List<Address> addresses) {
	        return addresses.stream()
	                .map(AddressDTO::convertToAddressDTO)
	                .collect(Collectors.toList());
	    }
}
