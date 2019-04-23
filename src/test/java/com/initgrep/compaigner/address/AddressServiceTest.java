package com.initgrep.compaigner.address;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.initgrep.compaigner.exception.DataNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {
	Logger log = LoggerFactory.getLogger(AddressServiceTest.class);
	
	@Autowired
	AddressService service;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test(expected = DataNotFoundException.class)
	public void getAddressById_test() throws DataNotFoundException {
		service.get(1000L);
	}
	
	@Test
	public void getAddressById_test1() throws DataNotFoundException {
		thrown.expect(DataNotFoundException.class);
		service.get(1000L);
	}
	
	@Test
	@DirtiesContext
	public void saveAddress_test() {
		Address expected = new Address("first Line", "2nd lIne", "3rd Line", "country", "121212");
		Address actual = service.save(new Address("first Line", "2nd lIne", "3rd Line", "country", "121212"));
		assertEquals(expected, actual);
	}

	@Test
	public void getAllAddresses_test() {
		service.getAll()
		.forEach( address -> log.info("address = {} ",address));
	}
	
	@Test
	@DirtiesContext
	public void deleteAddress_test_forNotFound() throws DataNotFoundException {
		thrown.expect(DataNotFoundException.class);
		service.delete(2000L);
	}
	
	@Test
	@DirtiesContext
	public void deleteAddress_test_forFound() throws DataNotFoundException {
		service.delete(2001L);
	}
	
	
}
