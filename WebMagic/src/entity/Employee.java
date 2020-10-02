package entity;

public class Employee {
  private String jobnameString;

public String getJobnameString() {
	return jobnameString;
}

public void setJobnameString(String jobnameString) {
	this.jobnameString = jobnameString;
}

public Employee(String jobnameString) {
	super();
	this.jobnameString = jobnameString;
}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "Employee [jobnameString=" + jobnameString + "]";
}
  
}
