package com.initgrep.compaigner.owner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.initgrep.compaigner.exception.DataNotFoundException;
import com.initgrep.compaigner.exception.NotFoundException;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	Logger log = LoggerFactory.getLogger(OwnerController.class);

	OwnerService service;

	public OwnerController(OwnerService service) {
		super();
		this.service = service;
	}

	@GetMapping("/{email}")
	public Owner getOwner(@PathVariable("email") String email) {
		Owner owner;
		try {
			owner = service.get(email);
		} catch (DataNotFoundException e) {
			log.debug("Exception happened with message = {} ", e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return owner;
	}

	@GetMapping
	public List<Owner> getAllOwners() {
		return service.getAll();
	}

	@PostMapping
	public Owner saveOwner(@RequestBody Owner owner) {
		return service.save(owner);
	}

	@PutMapping
	public Owner updateOwner(@RequestBody Owner t) {
		Owner owner;
		try {
			owner = service.update(t);
		} catch (DataNotFoundException e) {
			log.debug("Exception happened with message = {} ", e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		return owner;
	}

	@DeleteMapping("/{id}")
	public void deleteOwner(@PathVariable("id") Long id) {
		try {
			service.deleteById(id);
		} catch (DataNotFoundException e) {
			log.debug("Exception happened with message = {} ", e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
	}

}
