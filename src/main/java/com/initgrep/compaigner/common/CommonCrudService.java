package com.initgrep.compaigner.common;

import java.util.List;

public interface CommonCrudService<T, ID, E extends Exception> {

	/**
	 * get the <T> based on id
	 * @param id the id of the <T>
	 * @return the entity <T>
	 * @throws <E> throws Exception of type Exception
	 */
	T get(ID id) throws E;

	/**
	 * fetch all the entities of the type <T>
	 * @return List of entities of type <T>
	 */
	List<T> getAll();

	/**
	 * save the entity of type <T>
	 * @param t the entity of type <T>
	 * @return the <T> entity
	 */
	T save(T t);

	/**
	 * check if the object  exists and update the  <T>
	 * @param t the entity <T>
	 * @return the updated Entity <T>
	 * @throws E throws the exception of type Exception 
	 * if the persistant entity does not exist
	 */
	T update(T t) throws E;

	/**
	 * check if the Object exists and delete the Object <T>
	 * @param t the entity <T>
	 * @throws E throws the exception of type Exception 
	 * if the persistant entity does not exist
	 */
	void delete(T t) throws E;

	/**
	 * check if the Object exists and delete the object
	 * @param id the id of the entity
	 * @throws E throws the exception of type Exception 
	 * if the persistant entity does not exist
	 */
	void deleteById(ID id) throws E;

	/*TODO
	 * 1) updateInBatch 2) deleteInBatch
	 */

}
