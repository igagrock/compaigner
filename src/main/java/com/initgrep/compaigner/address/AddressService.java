package com.initgrep.compaigner.address;

import java.util.List;

import com.initgrep.compaigner.exception.DataNotFoundException;

public interface AddressService {
	
	/**
	 * get the address based on the Id of the address
	 * @param id the Id of the address
	 * @return the address
	 * @throws DataNotFoundException
	 */
	public Address getAddress(Long id) throws DataNotFoundException;
	
	/**
	 * get All the addresses
	 * TODO: add another method which is pageable and sortable
	 * @return the List of address objects
	 */
	public List<Address> getAddresses();
	
	
	/**
	 * save the address passed as a parameter
	 * @param address the address
	 * @return the address
	 */
	public Address saveAddress(Address address);
	
	/**
	 * creates an address and sets id passed in parameter.
	 * Then saves the address.
	 * `Avoid this method in the production code. 
	 * It will be used for mock object creation during testing`
	 * @param Id
	 * @return
	 */
	public Address saveAddressById(Long Id);
	
	/**
	 * Update an existing address.
	 * 
	 * @param address the address object
	 * @return the updated address
	 */
	public Address updateAddress(Address address);
	
	/**
	 * deletes the address
	 * @param address the address object
	 */
	public void deleteAddress(Address address);
	
	/**
	 * deletes the address 
	 * @param id the id of the address
	 */
	public void deleteAddressById(Long id);
}
