package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.DatabaseReader;
import main.Employee;

public class DataBaseReaderTest {

	Map<Integer, Employee> employees = new HashMap<>();

	@Before
	public void setUp() throws Exception {
		employees = DatabaseReader.loadEmployees();
	}

	@After
	public void tearDown() throws Exception {
		employees = null;
	}

	@Test
	public void testAllEmployeesLoaded() {
		int expected = 8;
		int actual = employees.keySet().size();
		assertEquals(expected, actual);
	}
}
