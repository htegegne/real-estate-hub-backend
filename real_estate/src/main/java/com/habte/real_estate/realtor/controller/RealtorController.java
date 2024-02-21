package com.habte.real_estate.realtor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habte.real_estate.realtor.dto.AddressDTO;
import com.habte.real_estate.realtor.dto.RealtorDTO;
import com.habte.real_estate.realtor.model.Address;
import com.habte.real_estate.realtor.repository.AddressRepository;
import com.habte.real_estate.realtor.service.RealtorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/realtors")
public class RealtorController {

	@Autowired
	private RealtorService realtorService;

	@Autowired
    private AddressRepository addressRepository;
	@PostMapping("/add")
	public ResponseEntity<String> addRealtor(@Valid @RequestBody RealtorDTO realtorDTO){
		try {
			realtorService.addRealtor(realtorDTO);
			return ResponseEntity.ok("Realtor added sucessfully");
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Realtor:"
					+ e.getMessage());
		}
		
	}
	@GetMapping("/all_realtors")
    public ResponseEntity<List<RealtorDTO>> getAllRealtors() {
        try {
            List<RealtorDTO> realtors = realtorService.getAllRealtors();
            
            return ResponseEntity.ok(realtors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	@GetMapping("/alladdresses")
	 public ResponseEntity<List<Address>> getAllSimpleAddresses() {
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        
        return ResponseEntity.ok(addresses);
    }
	@PostMapping("/addaddress")
	public ResponseEntity<String> addAddress(@Valid @RequestBody AddressDTO addressDTO){
		try {
			realtorService.addAddress(addressDTO);
			
			//AddressDTO addedAddress = realtorService.addAddress(addressDTO);
	        return ResponseEntity.ok("Address Created sucessfully");
		}catch (Exception e) {
	        // Handle the exception, you may want to log it or return an appropriate response
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Address:"
					+ e.getMessage());
	    }
	}
}
