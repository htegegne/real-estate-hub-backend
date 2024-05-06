package com.habte.real_estate.realtor;

import java.util.List;
import java.util.stream.Collectors;

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
	public static Address convertToAddressEntity(AddressDTO addressDTO) {
        Address address = new Address(
        		addressDTO.getSubCity(),
        		addressDTO.getDistrict(),
        		addressDTO.getHouseNo());
       // address.setSubCity(addressDTO.getSubCity());
      //  address.setDistrict(addressDTO.getDistrict());
      //  address.setHouseNo(addressDTO.getHouseNo());

        // Set other properties as needed

        return address;
		}
	
//	 public static List<AddressDTO> convertToAddressDTOList(List<Address> addresses) {
//	        return addresses.stream()
//	                .map(AddressDTO::convertToAddressDTO)
//	                .collect(Collectors.toList());
//	    }
}
