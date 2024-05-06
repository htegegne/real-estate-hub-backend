package com.habte.real_estate.realtor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.habte.real_estate.generic.GenericController;
import com.habte.real_estate.generic.GenericService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/realtors")
public class RealtorController {

	@Autowired
	private RealtorService realtorService;
	
	@GetMapping("/allrealtors")
    public ResponseEntity<List<Realtor>> getAllRealtors() {
        try {
            List<Realtor> realtors = realtorService.getAllRealtors();
            
            return ResponseEntity.ok(realtors);
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

	@GetMapping("/alladdresses")
	 public ResponseEntity<List<Address>> getAllAddresses() {
		try {
			List<Address> addresses =  realtorService.getAllAddress();
			return ResponseEntity.ok(addresses);
		} catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
  }
	@GetMapping("/{realtorId}/address")
    public ResponseEntity<AddressDTO> getAddressByRealtorId(@PathVariable Integer realtorId) throws RealtorNotFoundException {
        AddressDTO addressDTO = realtorService.getAddressByRealtorId(realtorId);
        return ResponseEntity.ok(addressDTO);
    }
//	 @GetMapping("/{id}")
//	    public ResponseEntity<RealtorDTO> getRealtorById(@PathVariable("id") Integer id) {
//	        try {
//	            RealtorDTO realtorDTO = realtorService.getRealtorById(id);
//	           
//	                return ResponseEntity.ok(realtorDTO);
//	          
//	        } catch (Exception e) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//	        }
//	    }
	@GetMapping("/{id}")
	public ResponseEntity<Realtor> getRealtorById(@PathVariable("id") Integer id) throws Exception {
		 Optional<Realtor> optionalRealtor = realtorService.getRealtorById(id);

		    if (optionalRealtor.isPresent()) {
		        return ResponseEntity.ok(optionalRealtor.get());
		    } else {
		        // Handle the case where the Realtor was not found (e.g., return 404 Not Found)
		        return ResponseEntity.notFound().build();
		    }
		
//	    RealtorDTO realtorDTO = realtorService.getRealtorById(id);
//	    if (realtorDTO.getRealtorAddress() != null) { // Check if address exists
//	        return ResponseEntity.ok(realtorDTO);
//	    } else {
//	        // Handle the case where there's no address (e.g., return a default object, throw an exception)
//	        return ResponseEntity.notFound().build(); // Example: Return not found
//	    }
	}
	 @GetMapping("/search")
	    public ResponseEntity<List<RealtorDTO>> getRealtorsByNameOrPhone(@RequestParam String query) {
	        try {
	            List<RealtorDTO> realtors = realtorService.getRealtorsByNameOrPhone(query);
	            return ResponseEntity.ok(realtors);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	@PostMapping(value = "/add", consumes ={"application/json"})
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
	@PostMapping("/{realtorId}/address")
    public ResponseEntity<AddressDTO> addAddressToRealtor(@PathVariable Integer realtorId, @Valid @RequestBody AddressDTO addressDTO) throws Exception {
        AddressDTO addedAddressDTO = realtorService.addAddressToRealtor(realtorId, addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedAddressDTO);
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<RealtorDTO> updateRealtor(@PathVariable Integer id, @Valid @RequestBody RealtorDTO updatedRealtorDTO) throws Exception {
        RealtorDTO updatedRealtor = realtorService.updateRealtor(id, updatedRealtorDTO);
        return ResponseEntity.ok(updatedRealtor);
    }

    @PutMapping("/{realtorId}/address")
    public ResponseEntity<AddressDTO> updateAddressForRealtor(@PathVariable Integer realtorId, @Valid @RequestBody AddressDTO updatedAddressDTO) throws Exception {
    	 
    	    try {
    	        updatedAddressDTO = realtorService.updateAddressForRealtor(realtorId, updatedAddressDTO);
    	        return ResponseEntity.ok(updatedAddressDTO);
    	    } catch (RealtorNotFoundException e) {
    	        return ResponseEntity.notFound().build();
    	    }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRealtor(@PathVariable Integer id) {
        realtorService.deleteRealtor(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{realtorId}/address")
    public ResponseEntity<Void> deleteAddressForRealtor(@PathVariable Integer realtorId) throws Exception {
        realtorService.deleteAddressForRealtor(realtorId);
        return ResponseEntity.noContent().build();
    }
    
}
//	@PostMapping("/addaddress")
//	public ResponseEntity<String> addAddress(@Valid @RequestBody AddressDTO addressDTO){
//		try {
//			realtorService.addAddress(addressDTO);
//			
//			//AddressDTO addedAddress = realtorService.addAddress(addressDTO);
//	        return ResponseEntity.ok("Address Created sucessfully");
//		}catch (Exception e) {
//	        // Handle the exception, you may want to log it or return an appropriate response
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Address:"
//					+ e.getMessage());
//	    }
//	}

