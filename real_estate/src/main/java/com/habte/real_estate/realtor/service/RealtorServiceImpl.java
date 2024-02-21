package com.habte.real_estate.realtor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habte.real_estate.realtor.dto.AddressDTO;
import com.habte.real_estate.realtor.dto.RealtorDTO;
import com.habte.real_estate.realtor.model.Address;
import com.habte.real_estate.realtor.model.Realtor;
import com.habte.real_estate.realtor.repository.AddressRepository;
import com.habte.real_estate.realtor.repository.RealtorRepository;

import jakarta.transaction.Transactional;

@Service(value="realtorService")
@Transactional
public class RealtorServiceImpl implements RealtorService{

	@Autowired RealtorRepository realtorRepository;
	@Autowired AddressRepository addressRepository;
	@Override
	public void addRealtor(RealtorDTO realtorDTO) throws Exception {
		// TODO Auto-generated method stub
		 // You may want to add validation logic here based on your requirements
        if (realtorDTO == null || realtorDTO.getPhoneNumber() == null || realtorDTO.getEmailId() == null) {
            throw new IllegalArgumentException("RealtorDTO is invalid");
        }

        try {
            // Convert RealtorDTO to Realtor entity
            Realtor realtor = Realtor.convertToRealtorEntity(realtorDTO);

            // Save the Realtor to the database
            realtorRepository.save(realtor);

            // You can add additional logic here if needed
        } catch (Exception e) {
            throw new Exception("Failed to add Realtor", e);
        }
    }
	@Override
    public List<RealtorDTO> getAllRealtors() {
        List<Realtor> realtors = realtorRepository.findAll();
        return RealtorDTO.convertToRealtorDTOList(realtors);
    }
	@Override
	public void addAddress(AddressDTO addressDTO) throws Exception {
		// TODO Auto-generated method stub
		try {
			Address address = Address.convertToAddressEntity(addressDTO);
			addressRepository.save(address);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Failed to add Address", e);
		}
	}


	/*
	 * @Override public AddressDTO addAddress(AddressDTO addressDTO) { // You may
	 * want to add validation logic here based on your requirements if (addressDTO
	 * == null || addressDTO.getSubCity() == null || addressDTO.getDistrict() ==
	 * null) { throw new IllegalArgumentException("AddressDTO is invalid"); }
	 * 
	 * // Convert AddressDTO to Address entity Address address =
	 * Address.convertToAddressEntity(addressDTO);
	 * 
	 * // Save the Address to the database Address savedAddress =
	 * addressRepository.save(address);
	 * 
	 * // Convert the saved Address back to AddressDTO and return return
	 * AddressDTO.convertToAddressDTO(savedAddress); }
	 */


	
		

}
