package com.habte.real_estate.realtor.service;

import java.util.List;

import com.habte.real_estate.realtor.dto.AddressDTO;
import com.habte.real_estate.realtor.dto.RealtorDTO;

public interface RealtorService {
	
	public void addRealtor(RealtorDTO realtor) throws Exception;
	List<RealtorDTO> getAllRealtors();
	//AddressDTO addAddress(AddressDTO addressDTO);
	public void addAddress(AddressDTO addressDTO) throws Exception;
}
