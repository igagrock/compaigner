package com.initgrep.compaigner.address;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.initgrep.compaigner.exception.DataNotFoundException;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	private AddressRepository repository;

	public AddressServiceImpl(AddressRepository repository) {
		this.repository = repository;
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
	public Address save(Address address) {
		return repository.save(address);
	}

	@Override
	public Address save(Long id) {
		Address address = new Address();
		address.setId(id);
		return repository.save(address);
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
	public void delete(Long id) throws DataNotFoundException {
		this.get(id);
		repository.deleteById(id);
		
	}

}
