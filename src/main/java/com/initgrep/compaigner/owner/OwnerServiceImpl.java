package com.initgrep.compaigner.owner;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.initgrep.compaigner.address.Address;
import com.initgrep.compaigner.exception.DataNotFoundException;
import com.initgrep.compaigner.org.Organisation;
import com.initgrep.compaigner.template.Template;

@Service
public class OwnerServiceImpl implements OwnerService {

	private OwnerRepository ownerRepository;

	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Owner get(String email) throws DataNotFoundException {
		Optional<Owner> opOwner = ownerRepository.findByEmail(email);
		if (opOwner.isPresent()) {
			return opOwner.get();
		} else {
			throw new DataNotFoundException("User is present for email = " + email);
		}
	}

	@Override
	public List<Owner> getAll() {
		return ownerRepository.findAll();
	}

	@Override
	public Owner get(Long id) throws DataNotFoundException {
		Optional<Owner> opOwner = ownerRepository.findById(id);
		if (opOwner.isPresent()) {
			return opOwner.get();
		} else {
			throw new DataNotFoundException("User is present for id = " + id);

		}
	}

	@Override
	public Owner save(Owner owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner update(Owner owner) throws DataNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Owner owner) throws DataNotFoundException {
		// TODO Auto-generated method stub
		
	}

	

	

}
