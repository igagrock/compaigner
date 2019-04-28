package com.initgrep.compaigner.owner;

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
public class OwnerServiceTest {
	
	Logger log = LoggerFactory.getLogger(OwnerServiceTest.class);
	
	@Autowired
	OwnerService service;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	
	
	@Test(expected = DataNotFoundException.class)
	public void get_test() throws DataNotFoundException {
		log.info("get_test START ");
		service.get(1000L);
		log.info("get_test END");
	}
	
	@Test
	public void get_negative() throws DataNotFoundException {
		log.info("get_negative START");
		thrown.expect(DataNotFoundException.class);
		service.get(1000L);
		log.info("get_negative END");
	}
	
	@Test
	public void getAll_testCount_positive() {
		log.info("getAll_testCount_positive START");
		int expectedCount = 2;
		int actualCount =  service.getAll().size();
		assertEquals(expectedCount, actualCount);
		log.info("getAll_testCount_positive END");
		
	}

	@Test
	@DirtiesContext
	public void save_test() {
		 log.info("save_test START");
		 Owner expected = new Owner("irs", "jay@email.com");
		 Owner actual = service.save(expected);
		 assertEquals(expected, actual);
		 log.info("save_test END");
	}
	
	@Test
	@DirtiesContext
	public void update_test_negative() throws DataNotFoundException {
		log.info("update_test_negative START");
		Owner expected = new Owner("irs", "jay@email.com");
		expected.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.update(expected);
		log.info("update_test_negative END");
	}
	
	
	@Test
	@DirtiesContext
	public void update_test_positive() throws DataNotFoundException {
		log.info("update_test_positive START");
		Owner owner = new Owner("dj", "dj@gmail.com");
		Owner actual = service.save(owner);
		
		actual.setEmail("coll@gmail.com");
	
		Owner expected = service.save(actual);
		
		assertEquals(actual.getEmail(),expected.getEmail());
		log.info("update_test_positive END");
		
	}
	
	@Test
	@DirtiesContext
	public void delete_test_negative() throws DataNotFoundException {
		log.info("delete_test_negative START");
		Owner owner = new Owner("irs", "jay@email.com");
		owner.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.delete(owner);
		log.info("delete_test_negative END");
	}
	
	@Test
	@DirtiesContext
	public void delete_test_postive() throws DataNotFoundException {
		log.info("delete_test_postive START");
		Owner owner = new Owner();
		owner.setId(2001L);
		service.delete(owner);
		log.info("delete_test_postive END");
	}
	
	@Test
	@DirtiesContext
	public void deleteById_test_negative() throws DataNotFoundException {
		log.info("deleteById_test_negative START");
		Owner owner = new Owner("irs", "jay@email.com");
		owner.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.deleteById(owner.getId());
		log.info("deleteById_test_negative END");
	}
	
	@Test
	@DirtiesContext
	public void deleteById_test_postive() throws DataNotFoundException {
		log.info("deleteById_test_postive START");
		Owner owner = new Owner("dsksd","sdksds@gmai.com");
		service.save(owner);
		service.deleteById(owner.getId());
		log.info("deleteById_test_postive END");
	}
	
	
	
}
