package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DatabaseReader {

	private static String URL = "jdbc:mysql://localhost:3306/myDB";

	public static Map<Integer, Employee> loadEmployees() throws SQLException {
		Map<Integer, Employee> employees = new HashMap<>();
		
		// Get connectivity to DB
		String user = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(URL, user, password);

		// Fetch all employees from database
		String sqltxt;
		sqltxt = "SELECT * FROM employee";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sqltxt);

		// keep a counter to reference index of previous employee while loading into memory.
		int counter = 0;
		while (rs.next()) {
			counter++;
			Employee temp = new Employee();
			temp.setId(rs.getInt(1));
			temp.setFirstName(rs.getString(2));
			temp.setLastName(rs.getString(3));

			// set prevEmployee since it's already created.
			if (employees.containsKey(rs.getInt(4))) {
				temp.setPrevEmployee(employees.get(rs.getInt(4)));
			}

			// set supervisor since it's already created
			if (employees.containsKey(rs.getInt(6))) {
				temp.setSupervisor(employees.get(rs.getInt(6)));
			}

			// store in hashmap, keyed off of ID
			employees.put(rs.getInt(1), temp);

			// if previous node has the same supervisor, set it's nextEmployee
			// to this one.
			if (employees.get(counter - 1) != null) {
				if (employees.get(counter - 1).getSupervisor() == temp.getSupervisor()) {
					employees.get(counter - 1).setNextEmployee(temp);
				}
			}
		}

		rs.close();
		stmt.close();
		conn.close();
		return employees;
	}
}
