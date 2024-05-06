package com.habte.real_estate.realtor;

import java.util.List;
import java.util.Optional;

public interface RealtorService {
	
	
	public List<Realtor> getAllRealtors();
	public Optional<Realtor> getRealtorById(Integer id) throws Exception;
	public void addRealtor(RealtorDTO realtor) throws Exception;
	public RealtorDTO updateRealtor(Integer id, RealtorDTO updatedRealtorDTO) throws Exception;
	public void deleteRealtor(Integer id);
	public AddressDTO getAddressByRealtorId(Integer realtorId) throws RealtorNotFoundException;
    public AddressDTO addAddressToRealtor(Integer realtorId, AddressDTO addressDTO) throws Exception;
    public AddressDTO updateAddressForRealtor(Integer realtorId, AddressDTO updatedAddressDTO) throws Exception;
    public void deleteAddressForRealtor(Integer realtorId) throws Exception;
    public List<RealtorDTO> getRealtorsByNameOrPhone(String query);
	public List<Address> getAllAddress();
	
}
