package com.initgrep.compaigner.compaign;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.initgrep.compaigner.exception.DataNotFoundException;

@Service
@Transactional
public class CompaignServiceImpl implements CompaignService {

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
