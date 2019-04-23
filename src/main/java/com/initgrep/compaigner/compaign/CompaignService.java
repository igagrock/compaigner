package com.initgrep.compaigner.compaign;

import java.util.List;

import com.initgrep.compaigner.exception.DataNotFoundException;

public interface CompaignService {
	
	public Compaign get(Long id) throws DataNotFoundException;
	
	public List<Compaign> getAll();
	
	public Compaign save(Compaign compaign);
	
	public Compaign update(Compaign compaign) throws DataNotFoundException;
	
	public void delete(Compaign compaign) throws DataNotFoundException;
	
	public void delete(Long id) throws DataNotFoundException;

}
