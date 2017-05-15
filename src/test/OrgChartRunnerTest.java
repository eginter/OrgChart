package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.DatabaseReader;
import main.Employee;
import main.OrgChartRunner;

public class OrgChartRunnerTest {


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
	public void testGetEmployeeByFirstName() {
		
		// test known names in database
		OrgChartRunner ocr = new OrgChartRunner();
		Employee testEmployee = ocr.getEmployeeByFirstName("Elijah");	
		assertEquals("Elijah", testEmployee.getFirstName());
		
		testEmployee = ocr.getEmployeeByFirstName("Joe");
		assertEquals("Joe", testEmployee.getFirstName());
		
		// test a name that does not exist in database
		testEmployee = ocr.getEmployeeByFirstName("Barbera");
		assertNull(testEmployee);
		
	}

}
