package com.habte.real_estate.realtor.model;

import java.util.List;
import java.util.Objects;

import com.habte.real_estate.property.model.Property;
import com.habte.real_estate.realtor.dto.AddressDTO;
import com.habte.real_estate.realtor.dto.RealtorDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Realtor {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "realtor_id")
	private Integer realtorId;
	
	@Column(name = "first_name")
	@NotBlank(message="{customer.firstName.must}")
	private String firstName;
	@Column(name = "last_name")
	@NotBlank(message="{customer.lastName.must}")
	private String lastName;
	@Column(name = "email_id")
	@NotNull(message="{customer.email.must}")
	@Email(message = "{realtor.email.invalid}")
	private String emailId; 
	@Column(name = "phone_number")
	@NotNull(message="{customer.phone.must}")
	private String phoneNumber;
	@NotEmpty(message="{customer.password.must}")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address realtorAddress;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "realtor")
	private List<Property> properties;
	
	

	/**
	 * @return the realtorID
	 */
	public Integer getRealtorID() {
		return realtorId;
	}

	/**
	 * @param realtorID the realtorID to set
	 */
	public void setRealtorID(Integer realtorId) {
		this.realtorId = realtorId;
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
	 * @param emailId the emailId to s
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
	public int hashCode() {
		return Objects.hash(emailId, firstName, lastName, password, phoneNumber, properties, realtorAddress, realtorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Realtor other = (Realtor) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(properties, other.properties)
				&& Objects.equals(realtorAddress, other.realtorAddress) && Objects.equals(realtorId, other.realtorId);
	}

	@Override
	public String toString() {
		return "Realtor [realtorID=" + realtorId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", phoneNumber=" + phoneNumber + ", password=" + password + ", properties=" + properties
				+ ", realtorAddress=" + realtorAddress + "]";
	}
	
	// You may need to implement a method to convert RealtorDTO to Realtor entity
		 	public static Realtor convertToRealtorEntity(RealtorDTO realtorDTO) {
	        Realtor realtor = new Realtor();
	        realtor.setFirstName(realtorDTO.getFirstName());
	        realtor.setLastName(realtorDTO.getLastName());
	        realtor.setEmailId(realtorDTO.getEmailId());
	        realtor.setPhoneNumber(realtorDTO.getPhoneNumber());
	        realtor.setPassword(realtorDTO.getPassword());

	        // Convert AddressDTO to Address entity
	       Address address = realtor.getRealtorAddress();
	       // Address address = Address.convertToAddressEntity(realtor.getRealtorAddress());
	        realtor.setRealtorAddress(address);

	        // Set other properties as needed

	        return realtor;
	    	}
	
}