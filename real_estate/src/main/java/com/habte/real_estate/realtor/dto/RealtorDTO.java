package com.habte.real_estate.realtor.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.habte.real_estate.property.model.Property;
import com.habte.real_estate.realtor.model.Address;
import com.habte.real_estate.realtor.model.Realtor;

public class RealtorDTO {

	private Integer realtorID;
	private String firstName;
	private String lastName;
	private String emailId; 
	private String phoneNumber;
	private String password;
	private List<Property> properties;
	private Address realtorAddress;
	/**
	 * @return the realtorID
	 */
	public Integer getRealtorID() {
		return realtorID;
	}
	/**
	 * @param integer the realtorID to set
	 */
	public void setRealtorID(Integer integer) {
		this.realtorID = integer;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the properties
	 */
	public List<Property> getProperties() {
		return properties;
	}
	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	/**
	 * @return the realtorAddress
	 */
	public Address getRealtorAddress() {
		return realtorAddress;
	}
	/**
	 * @param realtorAddress the realtorAddress to set
	 */
	public void setRealtorAddress(Address realtorAddress) {
		this.realtorAddress = realtorAddress;
	}
	@Override
	public String toString() {
		return "RealtorDTO [realtorID=" + realtorID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", password=" + password + ", properties="
				+ properties + ", realtorAddress=" + realtorAddress + "]";
	}
	
	// convert entity to DTO
	public static RealtorDTO convertToRealtorDTO(Realtor realtor) {
        RealtorDTO realtorDTO = new RealtorDTO();
        realtorDTO.setRealtorID(realtor.getRealtorID());
        realtorDTO.setFirstName(realtor.getFirstName());
        realtorDTO.setLastName(realtor.getLastName());
        realtorDTO.setEmailId(realtor.getEmailId());
        realtorDTO.setPhoneNumber(realtor.getPhoneNumber());
        realtorDTO.setPassword(realtor.getPassword());
        realtorDTO.setProperties(realtor.getProperties());
        realtorDTO.setRealtorAddress(realtor.getRealtorAddress());
        return realtorDTO;
    }

	public static List<RealtorDTO> convertToRealtorDTOList(List<Realtor> realtors) {
        return realtors.stream()
                .map(RealtorDTO::convertToRealtorDTO)
                .collect(Collectors.toList());
    }
}

