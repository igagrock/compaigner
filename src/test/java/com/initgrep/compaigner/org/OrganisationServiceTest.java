package com.initgrep.compaigner.org;

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

import com.initgrep.compaigner.address.AddressServiceTest;
import com.initgrep.compaigner.exception.DataNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganisationServiceTest {

	Logger log = LoggerFactory.getLogger(AddressServiceTest.class);

	@Autowired
	OrganisationService service;

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
		int expectedCount = 2;
		int actualCount = service.getAll().size();
		assertEquals(expectedCount, actualCount);
		log.info("getAll_testCount_positive END");

	}

	@Test
	@DirtiesContext
	public void save_test() {
		log.info("save_test START");
		Organisation expected = new Organisation("initgrep", "help@initgrep.com");
		Organisation actual = service.save(expected);
		assertEquals(expected, actual);
		log.info("save_test END");
	}

	@Test
	@DirtiesContext
	public void update_test_negative() throws DataNotFoundException {
		log.info("update_test_negative START");
		Organisation org = new Organisation("initgrep", "help@initgrep.com");
		org.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.update(org);
		log.info("update_test_negative END");
	}

	@Test
	@DirtiesContext
	public void update_test_positive() throws DataNotFoundException {
		log.info("update_test_positive START");
		Organisation org = new Organisation("initgrep", "help@initgrep.com");
		Organisation expected = service.save(org);
		expected.setTitle("initgrep-v1");
		Organisation actual = service.update(expected);
		assertEquals(expected, actual);
		log.info("update_test_positive END");

	}

	@Test
	@DirtiesContext
	public void delete_test_negative() throws DataNotFoundException {
		log.info("delete_test_negative START");
		Organisation org = new Organisation("initgrep", "help@initgrep.com");
		org.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.delete(org);
		log.info("delete_test_negative END");
	}

	@Test
	@DirtiesContext
	public void delete_test_postive() throws DataNotFoundException {
		log.info("delete_test_postive START");
		Organisation org = new Organisation("initgrep", "help@initgrep.com");

		Organisation expected = service.save(org);

		service.delete(expected);
		log.info("delete_test_postive END");
	}

	@Test
	@DirtiesContext
	public void deleteById_test_negative() throws DataNotFoundException {
		log.info("deleteById_test_negative START");
		Organisation org = new Organisation("initgrep", "help@initgrep.com");
		org.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.deleteById(org.getId());
		log.info("deleteById_test_negative END");
	}

	@Test
	@DirtiesContext
	public void deleteById_test_postive() throws DataNotFoundException {
		log.info("deleteById_test_postive START");
		Organisation org = new Organisation("initgrep", "help@initgrep.com");

		Organisation expected = service.save(org);

		service.deleteById(expected.getId());
		log.info("deleteById_test_postive END");
	}

}
