package com.initgrep.compaigner.template;

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
public class TemplateServiceTest {

	Logger log = LoggerFactory.getLogger(TemplateServiceTest.class);

	@Autowired
	TemplateService service;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void get_test() throws DataNotFoundException {
		log.info("get_test START ");
		Template tpl  = new Template("title1", "test title", false, "too much html encoded content");
		Template savetpl = service.save(tpl);
		
		Template actual = service.get(savetpl.getId());
		assertEquals(savetpl, actual);
		
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
		int expectedCount = 4;
		int actualCount = service.getAll().size();
		assertEquals(expectedCount, actualCount);
		log.info("getAll_testCount_positive END");

	}

	@Test
	@DirtiesContext
	public void save_test() {
		log.info("save_test START");
		Template expected  = new Template("title1", "test title", false, "too much html encoded content");
		Template actual = service.save(expected);
		assertEquals(expected, actual);
		log.info("save_test END");
	}

	@Test
	@DirtiesContext
	public void update_test_negative() throws DataNotFoundException {
		log.info("update_test_negative START");
		Template expected  = new Template("title1", "test title", false, "too much html encoded content");
		expected.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.update(expected);
		log.info("update_test_negative END");
	}

	@Test
	@DirtiesContext
	public void update_test_positive() throws DataNotFoundException {
		log.info("update_test_positive START");
		Template tmplt  = new Template("title1", "test title", false, "too much html encoded content");
		Template actual = service.save(tmplt);

		actual.setTitle("updated title");

		Template expected = service.save(actual);
		assertEquals(expected, actual);
		
		log.info("update_test_positive END");

	}

	@Test
	@DirtiesContext
	public void delete_test_negative() throws DataNotFoundException {
		log.info("delete_test_negative START");
		Template tmplt  = new Template("title1", "test title", false, "too much html encoded content");
		tmplt.setId(123444L);
		thrown.expect(DataNotFoundException.class);
		service.delete(tmplt);
		log.info("delete_test_negative END");
	}

	@Test
	@DirtiesContext
	public void delete_test_postive() throws DataNotFoundException {
		log.info("delete_test_postive START");
		Template tmplt  = new Template("title1", "test title", false, "too much html encoded content");
		Template actual = service.save(tmplt);

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
		Template tmplt  = new Template("title1", "test title", false, "too much html encoded content");
		Template actual = service.save(tmplt);

		service.deleteById(actual.getId());
		log.info("deleteById_test_postive END");
	}

}
