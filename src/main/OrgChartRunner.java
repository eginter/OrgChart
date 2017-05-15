package main;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OrgChartRunner {

	public Map<Integer, Employee> employees = new HashMap<>();
	
	public OrgChartRunner(){
		try {
			this.employees = DatabaseReader.loadEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		printOrgChart();
	}

	public static void main(String[] args) {

		OrgChartRunner ocr = new OrgChartRunner();
		// Employee to reassign
		Employee frank = ocr.getEmployeeByFirstName("Frank");
		// new supervisor
		Employee elijah = ocr.getEmployeeByFirstName("Elijah");
		// new prevEmployee
		Employee joe = ocr.getEmployeeByFirstName("Joe");
		// new nextEmployee
		Employee tim = ocr.getEmployeeByFirstName("Tim");
		frank.reassign(elijah, joe, tim);

		// Print again to see reassignment
		ocr.printOrgChart();
	}

	public void printOrgChart() {
		System.out.println("******************************************");
		for (int key : employees.keySet()) {
			Employee temp = employees.get(key);
			if (temp != null) {
				System.out.println(temp);
			}
		}
		System.out.println("******************************************");
	}

	public Employee getEmployeeByFirstName(String firstName) {
		for (int key : employees.keySet()) {
			Employee temp = employees.get(key);
			if (temp.getFirstName().equals(firstName)) {
				return temp;
			}
		}
		return null;
	}

}
