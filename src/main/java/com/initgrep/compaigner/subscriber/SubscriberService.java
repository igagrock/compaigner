package com.initgrep.compaigner.subscriber;

import java.util.List;

import com.initgrep.compaigner.exception.DataNotFoundException;

public interface SubscriberService {
	
	public Subscriber  get(Long id) throws DataNotFoundException;
	
	public List<Subscriber> getAll();
	
	public Subscriber save(Subscriber subscriber);
	
	/**
	 * Update method will first check if we have a persistant id
	 * and then update the persistant data.
	 * 
	 * This is in difference with normal behaviour of Jpa repository
	 * the save method in jparepository would update the existing data and save the new.
	 * 
	 * @param subscriber the Subsriber to be updated
	 * @return the latest version of Subscriber
	 * @throws DataNotFoundException
	 */
	public Subscriber update(Subscriber subscriber) throws DataNotFoundException;
	
	public void delete(Subscriber subscriber) throws DataNotFoundException;
	
	public void delete(Long id) throws DataNotFoundException;
}
