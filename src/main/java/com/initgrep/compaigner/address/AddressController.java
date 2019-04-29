package com.initgrep.compaigner.address;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.initgrep.compaigner.exception.DataNotFoundException;
import com.initgrep.compaigner.exception.NotFoundException;

@RestController
@RequestMapping("/owner/{email}/address")
public class AddressController {
	private static final Logger log = LoggerFactory.getLogger(AddressController.class);
	
	private AddressService service;
	
	public AddressController(AddressService service) {
		this.service = service;
	}

	@GetMapping
	public List<Address> getAddresses(@PathVariable("email") String email) {
		try {
			return service.getAllByOwnerEmail(email);
		} catch (DataNotFoundException e) {
			log.debug("exception thrown with message : {} ",e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public Address getAddressByIdAndOwnerEmail( @PathVariable("email") String email, @PathVariable("id") Long id) {
		try {
			return service.getByIdAndOwnerEmail(id, email);
		} catch (DataNotFoundException e) {
			log.debug("exception thrown with message : {} ",e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
	}
	
	/** update Delete method 
	 * Logic:
	 * fetch the Owners address
	 * if the Owner has the same address
	 * update/delete the address
	 * else exception
	 */
	
	
}
