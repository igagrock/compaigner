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
		log.info("getAddressById_test START ");
		service.get(1000L);
		log.info("getAddressById_test END");
	}
	
	@Test
	public void getAddressById_test1() throws DataNotFoundException {
		log.info("getAddressById_test1 START");
		thrown.expect(DataNotFoundException.class);
		service.get(1000L);
		log.info("getAddressById_test1 END");
	}
	
	@Test
	public void getAll_testCount_positive() {
		log.info("getAll_testCount_positive START");
		int expectedCount = 4;
		int actualCount =  service.getAll().size();
		assertEquals(expectedCount, actualCount);
		log.info("getAll_testCount_positive END");
		
	}

	@Test
	public void getAllByOwnerId_test() throws DataNotFoundException {
		log.info("getAllByOwnerId_test START");
		int expectedCount = 2;
		int actualCount =  service.getAllByOwnerId(1001L).size();
		assertEquals(expectedCount, actualCount);
		log.info("getAllByOwnerId_test END");
		
	}
	
	@Test
	public void getAllByOwnerEmail_test() throws DataNotFoundException {
		log.info("getAllByOwnerEmail_test START");
		int expectedCount = 2;
		int actualCount =  service.getAllByOwnerEmail("irshad@gmail.com").size();
		assertEquals(expectedCount, actualCount);
		log.info("getAllByOwnerEmail_test END");
		
	}
	
	@Test
	public void getAddressByIdAndOwnerEmail_test() throws DataNotFoundException {
		log.info("getAddressByIdAndOwnerEmail_test START");
		
		service.getByIdAndOwnerEmail(2001L, "irshad@gmail.com");
//		assertEquals(expectedCount, actualCount);
		log.info("getAddressByIdAndOwnerEmail_test END");
		
	}
	
	@Test
	@DirtiesContext
	public void save_test() {
		 log.info("save_test START");
		 Address expected = new Address("444", "some lane", "Texas", "TDA", "12345");
		 Address actual = service.save(expected);
		 assertEquals(expected, actual);
		 log.info("save_test END");
	}
	
	@Test
	@DirtiesContext
	public void update_test_negative() throws DataNotFoundException {
		log.info("update_test_negative START");
		Address address = new Address("444", "some lane", "Texas", "TDA", "12345");
		address.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.update(address);
		log.info("update_test_negative END");
	}
	
	
	@Test
	@DirtiesContext
	public void update_test_positive() throws DataNotFoundException {
		log.info("update_test_positive START");
		Address address = new Address("444", "some lane", "Texas", "TDA", "12345");
		Address expected = service.save(address);
		expected.setCity("oudor");
		Address actual = service.update(address);
		assertEquals(expected, actual);
		log.info("update_test_positive END");
		
	}
	
	@Test
	@DirtiesContext
	public void delete_test_negative() throws DataNotFoundException {
		log.info("delete_test_negative START");
		Address address = new Address("444", "some lane", "Texas", "TDA", "12345");
		address.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.delete(address);
		log.info("delete_test_negative END");
	}
	
	@Test
	@DirtiesContext
	public void delete_test_postive() throws DataNotFoundException {
		log.info("delete_test_postive START");
		Address address = new Address();
		address.setId(2001L);
		service.delete(address);
		log.info("delete_test_postive END");
	}
	
	@Test
	@DirtiesContext
	public void deleteById_test_negative() throws DataNotFoundException {
		log.info("deleteById_test_negative START");
		Address address = new Address("444", "some lane", "Texas", "TDA", "12345");
		address.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.deleteById(address.getId());
		log.info("deleteById_test_negative END");
	}
	
	@Test
	@DirtiesContext
	public void deleteById_test_postive() throws DataNotFoundException {
		log.info("deleteById_test_postive START");
		Address address = new Address();
		address.setId(2001L);
		service.deleteById(address.getId());
		log.info("deleteById_test_postive END");
	}
	
	
	
}
