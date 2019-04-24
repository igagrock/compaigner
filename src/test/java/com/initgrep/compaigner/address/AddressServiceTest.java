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
	public void getAll_testCount_positive() {
		int expectedCount = 4;
		int actualCount =  service.getAll().size();
		assertEquals(expectedCount, actualCount);
		
	}
	@Test
	@DirtiesContext
	public void save_test() {
		 Address expected = new Address("444", "some lane", "Texas", "TDA", "12345");
		 Address actual = service.save(expected);
		 assertEquals(expected, actual);
	}
	
	
}
