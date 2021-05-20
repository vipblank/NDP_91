package com.VTI.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.Employee;

public interface IEmployee_Repository {

	public boolean EmployeeLogin(String email, String password) throws SQLException, ClassNotFoundException;
	
	public List<Employee> GetListEmployee() throws ClassNotFoundException, SQLException;
	
	public Employee GetEmployeebyID(int id) throws ClassNotFoundException, SQLException;
	
	public Employee GetEmployeeByName(String fullname) throws ClassNotFoundException, SQLException;
	
	public boolean CreateEmployee(String fullname, String Email, String password, String ProSkill) throws ClassNotFoundException, SQLException;
		
	
}
