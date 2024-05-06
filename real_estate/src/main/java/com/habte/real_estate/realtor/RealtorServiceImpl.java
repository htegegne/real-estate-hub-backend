package com.habte.real_estate.realtor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habte.real_estate.generic.GenericService;
import com.habte.real_estate.generic.GenericServiceImpl;

import jakarta.transaction.Transactional;

@Service(value="realtorService")
@Transactional
//public class RealtorServiceImpl implements RealtorService{
public class RealtorServiceImpl implements RealtorService {
	
	@Autowired RealtorRepository realtorRepository;
	@Autowired AddressRepository addressRepository;
	@Override
	public void addRealtor(RealtorDTO realtorDTO) throws Exception {
		
		 // add validation logic here based on your requirements
        if (realtorDTO == null || realtorDTO.getPhoneNumber() == null || realtorDTO.getEmailId() == null) {
            throw new IllegalArgumentException("RealtorDTO is invalid");
        }

        try {
            // Convert RealtorDTO to Realtor entity
            Realtor realtor = RealtorDTO.convertToRealtorEntity(realtorDTO);
         
            // Save the Realtor to the database
            realtorRepository.save(realtor);

            // You can add additional logic here if needed
        } catch (Exception e) {
            throw new Exception("Failed to add Realtor", e);
        }
    }
	@Override
    public List<Realtor> getAllRealtors() {
       return realtorRepository.findAll();
        
    }
	@Override
	public List<Address> getAllAddress() {
		return addressRepository.findAll()
;		// TODO Auto-generated method stub
//		List<Address> addresses = addressRepository.findAll();
//		return AddressDTO.convertToAddressDTOList(addresses);
//		
	}
	@Override
	public Optional<Realtor> getRealtorById(Integer realtorId) throws Exception {
		 Optional<Realtor> optionalRealtor = realtorRepository.findById(realtorId);
		// Handle the case where the Realtor with the specified ID is not found
	        if (!optionalRealtor.isPresent()) {
	            return Optional.empty(); // Return empty Optional
	        }

	        return optionalRealtor;
		 //	        if (optionalRealtor.isPresent()) {
//	            Realtor realtor = optionalRealtor.get();
////	            Optional<AddressDTO> optionalAddressDTO = Optional.ofNullable(realtor.getRealtorAddress())
////	                    .map(AddressDTO::convertToAddressDTO);
//	            return RealtorDTO.convertToRealtorDTO(realtor);
//	        } else {
//	            // Handle the case where the Realtor with the specified ID is not found
//	            throw new Exception("Realtor with ID " + realtorId + " not found");
//	        }
	}
	@Override
	public RealtorDTO updateRealtor(Integer id, RealtorDTO updatedRealtorDTO) throws Exception {
		// Find the Realtor by ID
        Optional<Realtor> optionalRealtor = realtorRepository.findById(id);
        if (optionalRealtor.isPresent()) {
            Realtor realtor = optionalRealtor.get();

            // Update the Realtor properties
            realtor.setFirstName(updatedRealtorDTO.getFirstName());
            realtor.setLastName(updatedRealtorDTO.getLastName());
            realtor.setEmailId(updatedRealtorDTO.getEmailId());
            realtor.setPhoneNumber(updatedRealtorDTO.getPhoneNumber());
            realtor.setPassword(updatedRealtorDTO.getPassword());

            // Save the updated Realtor entity
            Realtor updatedRealtor = realtorRepository.save(realtor);

            // Convert and return the updated RealtorDTO
            return Realtor.convertToRealtorDTO(updatedRealtor);
        } else {
            // Handle the case where the Realtor with the specified ID is not found
            throw new Exception("Realtor with ID " + id + " not found");
        }
	}
	@Override
	public void deleteRealtor(Integer id) {
		// TODO Auto-generated method stub
		 realtorRepository.deleteById(id);
		
	}
	@Override
	public AddressDTO getAddressByRealtorId(Integer realtorId) throws RealtorNotFoundException {
		// TODO Auto-generated method stub
		 Optional<Realtor> optionalRealtor = realtorRepository.findById(realtorId);
		    if (optionalRealtor.isPresent()) {
		        // Retrieve the Address entity associated with the Realtor
		        Address realtorAddress = optionalRealtor.get().getRealtorAddress();
		        // Convert and return the AddressDTO
		        return Address.convertToAddressDTO(realtorAddress);
		    } else {
		        // Handle the case where the Realtor with the specified ID is not found
		        throw new RealtorNotFoundException("Realtor with ID " + realtorId + " not found");
		    }
	}
	@Override
	public AddressDTO addAddressToRealtor(Integer realtorId, AddressDTO addressDTO) throws Exception {
		// TODO Auto-generated method stub
		Optional<Realtor> optionalRealtor = realtorRepository.findById(realtorId);
        if (optionalRealtor.isPresent()) {
            Realtor realtor = optionalRealtor.get();

            // Convert AddressDTO to Address entity
            Address address = AddressDTO.convertToAddressEntity(addressDTO);

            // Set the Address entity to the Realtor
            realtor.setRealtorAddress(address);

            // Save the updated Realtor entity
            realtorRepository.save(realtor);

            // Return the added AddressDTO
            return addressDTO;
        } else {
            // Handle the case where the Realtor with the specified ID is not found
            throw new Exception("Realtor with ID " + realtorId + " not found");
        }
	}
	@Override
	public AddressDTO updateAddressForRealtor(Integer realtorId, AddressDTO updatedAddressDTO) throws Exception {
		// TODO Auto-generated method stub
		Optional<Realtor> optionalRealtor = realtorRepository.findById(realtorId);
        if (optionalRealtor.isPresent()) {
            Realtor realtor = optionalRealtor.get();

            // Update the Address properties
            Address address = realtor.getRealtorAddress();
            address.setSubCity(updatedAddressDTO.getSubCity());
            address.setDistrict(updatedAddressDTO.getDistrict());
            address.setHouseNo(updatedAddressDTO.getHouseNo());
          

            // Save the updated Address entity
            Address updatedAddress = addressRepository.save(address);

            // Convert and return the updated AddressDTO
            return Address.convertToAddressDTO(updatedAddress);
        } else {
            // Handle the case where the Realtor with the specified ID is not found
            throw new Exception("Realtor with ID " + realtorId + " not found");
        }
	}
	@Override
	public void deleteAddressForRealtor(Integer realtorId) throws Exception {
		// TODO Auto-generated method stub
		// Find the Realtor by ID
        Optional<Realtor> optionalRealtor = realtorRepository.findById(realtorId);
        if (optionalRealtor.isPresent()) {
            Realtor realtor = optionalRealtor.get();

            // Remove the Address entity from the Realtor
            realtor.setRealtorAddress(null);

            // Save the updated Realtor entity
            realtorRepository.save(realtor);
        } else {
            // Handle the case where the Realtor with the specified ID is not found
            throw new Exception("Realtor with ID " + realtorId + " not found");
        }
	}
	//@Override
//	public List<RealtorDTO> getRealtorsByNameOrPhone(String query) {
//		// TODO Auto-generated method stub
//		return RealtorDTO.convertToRealtorDTOList(realtorRepository.findByNameOrPhone(query));
//	}
//	
	@Override
	public List<RealtorDTO> getRealtorsByNameOrPhone(String query) {
		// TODO Auto-generated method stub
		return null;
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


//@Autowired
//private GenericService<Realtor, Integer> realtorService;
//
//@Autowired
//private GenericService<Address, Integer> addressService;
//
//@Override
//public void addRealtor(RealtorDTO realtorDTO) throws Exception {
//    // Convert RealtorDTO to Realtor entity
//    Realtor realtor = Realtor.convertToRealtorEntity(realtorDTO);
//
//    // Save the Realtor using the generic service
//    realtorService.save(realtor);
//}
//
//@Override
//public List<RealtorDTO> getAllRealtors() {
//    // Get all realtors using the generic service
//    List<Realtor> realtors = realtorService.findAll();
//    return RealtorDTO.convertToRealtorDTOList(realtors);
//}
//
//@Override
//public void addAddress(AddressDTO addressDTO) {
//    // Convert AddressDTO to Address entity
//    Address address = Address.convertToAddressEntity(addressDTO);
//
//    // Save the Address using the generic service
//    addressService.save(address);
//
//    // Convert the saved Address back to AddressDTO and return
//   
//}
//
//private AddressDTO convertToAddressDTO(Address address) {
//    AddressDTO addressDTO = new AddressDTO();
//    addressDTO.setAddressId(address.getAddressId());
//    addressDTO.setSubCity(address.getSubCity());
//    addressDTO.setDistrict(address.getDistrict());
//    addressDTO.setHouseNo(address.getHouseNo());
//    // Set other properties as needed
//    return addressDTO;
//}
		


