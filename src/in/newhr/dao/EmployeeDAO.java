package in.newhr.dao;

import java.util.ArrayList;

import in.newhr.dto.Employee;

public interface EmployeeDAO {
	public boolean insertEmployee(Employee e);
	public boolean updateEmployee(Employee e);
	public boolean deleteEmployee(Employee e);
	public Employee getEmployee(String mail, String password);
	public ArrayList<Employee> getEmployee();
	public Employee getEmployee(int id);
}
