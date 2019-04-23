package com.initgrep.compaigner.owner;

import java.util.List;

import com.initgrep.compaigner.exception.DataNotFoundException;

public interface OwnerService {
	
	public Owner get(String email) throws DataNotFoundException;
	
	public Owner get(Long id) throws DataNotFoundException;
	
	public List<Owner> getAll();

	public Owner save(Owner owner);
	
	public Owner update(Owner owner) throws DataNotFoundException;
	
	public void delete(Owner owner) throws DataNotFoundException;
	
	
	
	
}
