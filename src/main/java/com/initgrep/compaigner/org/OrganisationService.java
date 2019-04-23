package com.initgrep.compaigner.org;

import java.util.List;

import com.initgrep.compaigner.exception.DataNotFoundException;

public interface OrganisationService {

	public Organisation get(Long id) throws DataNotFoundException;
	
	public List<Organisation> getAll();
	
	public Organisation save(Organisation org);
	
	public Organisation update(Organisation org) throws DataNotFoundException;
	
	public void delete(Organisation org) throws DataNotFoundException;
	
	public void delete(Long id) throws DataNotFoundException;
}
