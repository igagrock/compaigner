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
	public Address getAddress(Long id) throws DataNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("Address was not found for id = " + id));

	}

	@Override
	public List<Address> getAddresses() {
		return repository.findAll();
	}

	@Override
	public Address saveAddress(Address address) {
		return repository.save(address);
	}

	@Override
	public Address saveAddressById(Long id) {
		Address address = new Address();
		address.setId(id);
		return repository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		return repository.save(address);
	}

	@Override
	public void deleteAddress(Address address) {
		repository.delete(address);

	}

	@Override
	public void deleteAddressById(Long id) {
		repository.deleteById(id);

	}

}
