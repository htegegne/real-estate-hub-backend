package com.habte.real_estate.realtor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.habte.real_estate.property.Property;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Realtor implements Serializable {

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
	
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	
	@JoinColumn(name = "address_id")
	private Address realtorAddress;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "realtor")
	private List<Property> properties;
	
	

	public Realtor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Realtor( String firstName,
			 String lastName,
			 String emailId,
		 String phoneNumber,
			 String password, 
			 Address realtorAddress,
			List<Property> properties) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.realtorAddress = realtorAddress;
		this.properties = properties;
	}
	public Realtor(Integer realtorId, String firstName,
			 String lastName,
			 String emailId,
		 String phoneNumber,
			 String password, 
			 Address realtorAddress,
			List<Property> properties) {
		super();
		this.realtorId = realtorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.realtorAddress = realtorAddress;
		this.properties = properties;
	}
	

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
		return "Realtor [realtorIdEntity=" + realtorId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", phoneNumber=" + phoneNumber + ", password=" + password + ", properties=" + properties
				+ ", realtorAddress=" + realtorAddress + "]";
	}
	public static RealtorDTO convertToRealtorDTO(Realtor realtor) {
        RealtorDTO realtorDTO = new RealtorDTO();
        realtorDTO.setRealtorID(realtor.getRealtorID());
        realtorDTO.setFirstName(realtor.getFirstName());
        realtorDTO.setLastName(realtor.getLastName());
        realtorDTO.setEmailId(realtor.getEmailId());
        realtorDTO.setPhoneNumber(realtor.getPhoneNumber());
        realtorDTO.setPassword(realtor.getPassword());
        realtorDTO.setProperties(realtor.getProperties());
        realtorDTO.setRealtorAddress(realtor.getRealtorAddress()); // Set empty AddressDTO if address is null
        return realtorDTO;
    }

	
//	public static List<RealtorDTO> convertToRealtorDTOList(List<Realtor> realtors) {
//        return realtors.stream()
//                .map(RealtorDTO::convertToRealtorDTO)
//                .collect(Collectors.toList());
//    }
	
	
	
}