package com.habte.real_estate.realtor;

import java.util.List;
import java.util.stream.Collectors;

import com.habte.real_estate.property.Property;

public class RealtorDTO {

	private Integer realtorId;
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
		return realtorId;
	}
	/**
	 * @param integer the realtorID to set
	 */
	public void setRealtorID(Integer integer) {
		this.realtorId = integer;
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
	 * @param address the realtorAddress to set
	 */
	public void setRealtorAddress(Address address) {
		this.realtorAddress = address;
	}
	@Override
	public String toString() {
		return "RealtorDTO [realtorId=" + realtorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", password=" + password + ", properties="
				+ properties + ", realtorAddress=" + realtorAddress + "]";
	}
//  convert RealtorDTO to Realtor entity
		 	public static Realtor convertToRealtorEntity(RealtorDTO realtorDTO) {
	        Realtor realtor = new Realtor(
	        		realtorDTO.getRealtorID(),
	        		realtorDTO.getFirstName(),
	        		realtorDTO.getLastName(),
	        		realtorDTO.getEmailId(),
	        		realtorDTO.getPhoneNumber(),
	        		realtorDTO.getPassword(),
	        		realtorDTO.getRealtorAddress(),
	        		realtorDTO.getProperties());
//	        realtor.setFirstName(realtorDTO.getFirstName());
//	        realtor.setLastName(realtorDTO.getLastName());
//	        realtor.setEmailId(realtorDTO.getEmailId());
//	        realtor.setPhoneNumber(realtorDTO.getPhoneNumber());
//	        realtor.setPassword(realtorDTO.getPassword());

	        // Convert AddressDTO to Address entity
	 //      Address address = realtor.getRealtorAddress();
	       // Address address = Address.convertToAddressEntity(realtor.getRealtorAddress());
	 //       realtor.setRealtorAddress(address);

	        // Set other properties as needed

	        return realtor;
	    	}
	
	
}

