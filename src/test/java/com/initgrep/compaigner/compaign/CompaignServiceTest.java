package com.initgrep.compaigner.compaign;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
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
public class CompaignServiceTest {
	Logger log = LoggerFactory.getLogger(CompaignServiceTest.class);

	@Autowired
	CompaignService service;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void get_test() throws DataNotFoundException {
		log.info("get_test START ");
		Compaign cmpn = new Compaign("test Compaign", "test comp desc", "yo@yoyo.com", true);
		Compaign expected = service.save(cmpn);
		
		Compaign actual = service.get(expected.getId());
		assertEquals(expected, actual);
		
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
	@Ignore
	public void getAll_testCount_positive() {
		log.info("getAll_testCount_positive START");
		int expectedCount = 2;
		int actualCount = service.getAll().size();
		assertEquals(expectedCount, actualCount);
		log.info("getAll_testCount_positive END");

	}

	@Test
	@DirtiesContext
	public void save_test() {
		log.info("save_test START");
		Compaign expected = new Compaign("test Compaign", "test comp desc", "yo@yoyo.com", true);
		Compaign actual = service.save(expected);
		assertEquals(expected, actual);
		log.info("save_test END");
	}

	@Test
	@DirtiesContext
	public void update_test_negative() throws DataNotFoundException {
		log.info("update_test_negative START");
		Compaign expected = new Compaign("test Compaign", "test comp desc", "yo@yoyo.com", true);
		expected.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.update(expected);
		log.info("update_test_negative END");
	}

	@Test
	@DirtiesContext
	public void update_test_positive() throws DataNotFoundException {
		log.info("update_test_positive START");
		Compaign cmpn = new Compaign("test Compaign", "test comp desc", "yo@yoyo.com", true);
		Compaign actual = service.save(cmpn);

		actual.setTitle("updated title");

		Compaign expected = service.save(actual);
		assertEquals(expected, actual);
		
		log.info("update_test_positive END");

	}

	@Test
	@DirtiesContext
	public void delete_test_negative() throws DataNotFoundException {
		log.info("delete_test_negative START");
		Compaign cmpn = new Compaign("test Compaign", "test comp desc", "yo@yoyo.com", true);
		cmpn.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.delete(cmpn);
		log.info("delete_test_negative END");
	}

	@Test
	@DirtiesContext
	public void delete_test_postive() throws DataNotFoundException {
		log.info("delete_test_postive START");
		Compaign cmpn = new Compaign("test Compaign", "test comp desc", "yo@yoyo.com", true);
		Compaign actual = service.save(cmpn);

		service.delete(actual);
		log.info("delete_test_postive END");
	}

	@Test
	@DirtiesContext
	public void deleteById_test_negative() throws DataNotFoundException {
		log.info("deleteById_test_negative START");
		thrown.expect(DataNotFoundException.class);
		service.deleteById(12000L);
		log.info("deleteById_test_negative END");
	}

	@Test
	@DirtiesContext
	public void deleteById_test_postive() throws DataNotFoundException {
		log.info("deleteById_test_postive START");
		Compaign cmpn = new Compaign("test Compaign", "test comp desc", "yo@yoyo.com", true);
		Compaign actual = service.save(cmpn);

		service.deleteById(actual.getId());
		log.info("deleteById_test_postive END");
	}

}
