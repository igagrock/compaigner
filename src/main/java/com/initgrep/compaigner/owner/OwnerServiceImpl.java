package com.initgrep.compaigner.owner;

import java.util.List;

import org.springframework.stereotype.Service;

import com.initgrep.compaigner.exception.DataNotFoundException;

@Service
public class OwnerServiceImpl implements OwnerService {

	private OwnerRepository repository;

	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.repository = ownerRepository;
	}

	@Override
	public Owner get(Long id) throws DataNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("Owner was not found for id = " + id));
	}

	@Override
	public Owner get(String email) throws DataNotFoundException {
		return repository.findByEmail(email)
				.orElseThrow(() -> new DataNotFoundException("Owner was not found for Email = " + email));
	}

	@Override
	public List<Owner> getAll() {
		return repository.findAll();
	}

	@Override
	public Owner save(Owner t) {
		return repository.save(t);
	}

	@Override
	public Owner update(Owner t) throws DataNotFoundException {
		this.get(t.getId());
		return repository.save(t);
	}

	@Override
	public void delete(Owner t) throws DataNotFoundException {
		this.get(t.getId());
		repository.delete(t);
	}

	@Override
	public void deleteById(Long id) throws DataNotFoundException {
		this.get(id);
		repository.deleteById(id);
	}

}
