package com.initgrep.compaigner.owner;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class OwnerServiceImpl implements OwnerService {

	private OwnerRepository ownerRepository;

	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Owner getOwner(String email) throws NotFoundException {
		Optional<Owner> opOwner = ownerRepository.findByEmail(email);
		if (opOwner.isPresent()) {
			return opOwner.get();
		} else {
			throw new NotFoundException("User is present for email = " + email);
		}
	}

	@Override
	public List<Owner> getOwners() {
		return ownerRepository.findAll();
	}

	@Override
	public Owner getOwner(Long id) throws NotFoundException {
		Optional<Owner> opOwner = ownerRepository.findById(id);
		if (opOwner.isPresent()) {
			return opOwner.get();
		} else {
			throw new NotFoundException("User is present for id = " + id);

		}
	}

}
