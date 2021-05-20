package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.datalayer.Employee_repository;
import com.VTI.entity.Employee;

public class Employee_Service implements IEmployee_Service{
	private Employee_repository employee;
	public Employee_Service() throws FileNotFoundException, IOException {
		employee = new Employee_repository();
	}
	@Override
	public boolean EmployeeLogin(String email, String password) throws SQLException, ClassNotFoundException {
		
		return employee.EmployeeLogin(email, password);
	}

	@Override
	public List<Employee> GetListEmployee() throws ClassNotFoundException, SQLException {
		
		return employee.GetListEmployee();
	}

	@Override
	public Employee GetEmployeebyID(int id) throws ClassNotFoundException, SQLException {
		
		return employee.GetEmployeebyID(id);
	}

	@Override
	public Employee GetEmployeeByName(String fullname) throws ClassNotFoundException, SQLException {
		
		return employee.GetEmployeeByName(fullname);
	}

	@Override
	public boolean CreateEmployee(String fullname, String Email, String password, String ProSkill)
			throws ClassNotFoundException, SQLException {
		if (employee.checkEmailAdmin(Email) || employee.checkEmailEmployee(Email) || employee.checkEmailManager(Email)) {
			System.err.println("Email này đã tồn tại. Tạo mới thất bại");
			return false;
		}
		return employee.CreateEmployee(fullname, Email, password, ProSkill);
	}
	
}
