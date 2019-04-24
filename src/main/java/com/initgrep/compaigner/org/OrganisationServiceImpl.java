package com.initgrep.compaigner.org;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.initgrep.compaigner.exception.DataNotFoundException;

@Service
@Transactional
public class OrganisationServiceImpl implements OrganisationService {

	private OrganisationRepository repository;

	public OrganisationServiceImpl(OrganisationRepository repository) {
		this.repository = repository;
	}

	@Override
	public Organisation get(Long id) throws DataNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("Organisation was not found for id = " + id));
	}

	@Override
	public List<Organisation> getAll() {
		return repository.findAll();
	}

	@Override
	public Organisation save(Organisation org) {
		return repository.save(org);
	}

	@Override
	public Organisation update(Organisation org) throws DataNotFoundException {
		this.get(org.getId());
		return repository.save(org);
	}

	@Override
	public void delete(Organisation org) throws DataNotFoundException {
		this.get(org.getId());
		repository.delete(org);
	}

	@Override
	public void deleteById(Long id) throws DataNotFoundException {
		this.get(id);
		repository.deleteById(id);
	}

}
