package main;

public class Employee {
	int id;
	String firstName;
	String lastName;
	Employee prevEmployee;
	Employee nextEmployee;
	Employee supervisor;
	
	public void reassign(Employee supervisor,
			Employee newPrevNode, Employee newNextNode){
		
		// Link current prevEmployee and nextEmployee
		if (this.getPrevEmployee() != null){
			this.getPrevEmployee().setNextEmployee(this.getNextEmployee());
		}
		
		if (this.getNextEmployee() != null){
			this.getNextEmployee().setPrevEmployee(this.getPrevEmployee());
		}
		
		// Set new supervisor
		this.setSupervisor(supervisor);
		
		// if given a previous node
		if (newPrevNode != null){
			// set as current previous node
			this.setPrevEmployee(newPrevNode);
			// update that node's nextEmployee to this
			newPrevNode.setNextEmployee(this);
		}
		// if given a next node
		if (newNextNode != null){
			// set as current next node
			this.setNextEmployee(newNextNode);
			// update that node's prevEmployee to this
			newNextNode.setPrevEmployee(this);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Employee getNextEmployee() {
		return nextEmployee;
	}
	public void setNextEmployee(Employee nextEmployee) {
		this.nextEmployee = nextEmployee;
	}
	public Employee getPrevEmployee() {
		return prevEmployee;
	}
	public void setPrevEmployee(Employee prevEmployee) {
		this.prevEmployee = prevEmployee;
	}
	public Employee getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", " + (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (prevEmployee != null ? "prevEmployee=" + prevEmployee.getFirstName() + ", " : "")
				+ (nextEmployee != null ? "nextEmployee=" + nextEmployee.getFirstName() + ", " : "")
				+ (supervisor != null ? "supervisor=" + supervisor.getFirstName() : "") + "]";
	}
}
