package com.initgrep.compaigner.owner;

import java.util.List;

import javassist.NotFoundException;

public interface OwnerService {
	
	public Owner getOwner(String email) throws NotFoundException;
	public Owner getOwner(Long id) throws NotFoundException;
	public List<Owner> getOwners();
}
