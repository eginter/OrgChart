package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.DatabaseReader;
import main.Employee;

public class EmployeeTest {

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
	public void testReassign() {
		
		// Employee to reassign
		Employee tom = employees.get(5);
		// new supervisor
		Employee elijah = employees.get(1);
		// new prevEmployee
		Employee joe = employees.get(2);
		// new nextEmployee
		Employee tim = employees.get(3);
		
		tom.reassign(elijah, joe, tim);
		
		// Check all of toms updated fields
		assertEquals("Elijah", tom.getSupervisor().getFirstName());
		assertEquals("Joe", tom.getPrevEmployee().getFirstName());
		assertEquals("Tim", tom.getNextEmployee().getFirstName());
		
		// Check changes to previous prevEmployee
		Employee sara = employees.get(4);
		assertNull(sara.getNextEmployee());
		
		// Tom does not have nextEmployee initially
		
		// Check changes to new prevEmployee
		assertEquals("Tom", joe.getNextEmployee().getFirstName());
		assertEquals("Tom", tim.getPrevEmployee().getFirstName());
		
		
	}

}
