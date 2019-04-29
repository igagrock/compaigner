package com.initgrep.compaigner.owner;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.initgrep.compaigner.exception.DataNotFoundException;
import com.initgrep.compaigner.template.Template;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {
	
	final static Logger log = LoggerFactory.getLogger(OwnerService.class);

	private OwnerRepository repository;

	
	public OwnerServiceImpl(OwnerRepository repository) {
		super();
		this.repository = repository;
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

	/**
	 * The deletion of the Owner results in deletion of its address and organisations
	 * However, we are keeping the Templates since they might be used by Other owners in their compaign
	 * 
	 * TODO: Implementation should be changed later due to performance issues
	 * This implemenation will send over one delete call for each associated entity instance
	 * Instead we can use a native query to set the association to empty and batch delete the rest
	 */ 
	@Override
	public void deleteById(Long id) throws DataNotFoundException {
		log.info("deleteById called = {} ", id);
		Owner owner = this.get(id);
		List<Template> templates = owner.getTemplates();
		
		templates.forEach((template)->{
			template.setOwner(null);
		});
		
		owner.setTemplates(new ArrayList<>());
		repository.deleteById(id);
	}

}
