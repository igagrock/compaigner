package com.initgrep.compaigner.address;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.initgrep.compaigner.exception.DataNotFoundException;
import com.initgrep.compaigner.owner.Owner;
import com.initgrep.compaigner.owner.OwnerService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	private AddressRepository repository;
	private OwnerService ownerService;

	public AddressServiceImpl(AddressRepository repository, OwnerService ownerService) {
		this.repository = repository;
		this.ownerService = ownerService;
	}

	@Override
	public Address get(Long id) throws DataNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("Address was not found for id = " + id));

	}

	@Override
	public List<Address> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Address> getAllByOwnerId(Long ownerId) throws DataNotFoundException {
		ownerService.get(ownerId);
		return repository.findAllByOwnerId(ownerId);
	}

	@Override
	public List<Address> getAllByOwnerEmail(String email) throws DataNotFoundException {
		ownerService.get(email);
		return repository.findAllByOwnerEmail(email);
	}

	@Override
	public Address getByIdAndOwnerEmail(Long id, String email) throws DataNotFoundException {
		ownerService.get(email);
		this.get(id);
		return repository.findByIdAndOwnerEmail(id, email)
				.orElseThrow(() -> 
				new DataNotFoundException("Address was not found for user = "+email + " and address = "+id ));
		
	}

	@Override
	public Address save(Address address) {
		return repository.save(address);
	}
	
	@Override
	public Address saveByOwnerEmail(String email , Address address) throws DataNotFoundException {
		Owner owner = ownerService.get(email);
		address.setOwner(owner);
		return this.save(address);
	}
	

	@Override
	public Address update(Address address) throws DataNotFoundException {
		this.get(address.getId());
		return repository.save(address);

	}

	@Override
	public void delete(Address address) throws DataNotFoundException {
		this.get(address.getId());
		repository.delete(address);

	}

	@Override
	public void deleteById(Long id) throws DataNotFoundException {
		this.get(id);
		repository.deleteById(id);

	}

}
