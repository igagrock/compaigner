package com.initgrep.compaigner.compaign;

import java.util.List;

import com.initgrep.compaigner.common.CommonCrudService;
import com.initgrep.compaigner.exception.DataNotFoundException;

public class CompaignServiceImpl implements CommonCrudService<Compaign, Long, DataNotFoundException> {

	private CompaignRepository repository;
	
	public CompaignServiceImpl(CompaignRepository compaignRepository) {
		this.repository = compaignRepository;
	}

	@Override
	public Compaign get(Long id) throws DataNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new DataNotFoundException("Compaign was not found for id = " + id));
	}

	@Override
	public List<Compaign> getAll() {
		return repository.findAll();
	}

	@Override
	public Compaign save(Compaign t) {
		return repository.save(t);
	}


	@Override
	public Compaign update(Compaign t) throws DataNotFoundException {
		this.get(t.getId());
		return repository.save(t);
	}

	@Override
	public void delete(Compaign t) throws DataNotFoundException {
		this.get(t.getId());
		repository.save(t);
		
	}

	@Override
	public void deleteById(Long id) throws DataNotFoundException {
		this.get(id);
		repository.deleteById(id);
		
	}

}
