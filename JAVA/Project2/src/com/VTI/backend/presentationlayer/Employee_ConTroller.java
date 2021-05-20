package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.businesslayer.Employee_Service;
import com.VTI.backend.businesslayer.IEmployee_Service;
import com.VTI.entity.Employee;

public class Employee_ConTroller implements IEmployee_Service{
	private Employee_Service employeeS;
	public Employee_ConTroller() throws FileNotFoundException, IOException {
		employeeS = new Employee_Service();
	}
	@Override
	public boolean EmployeeLogin(String email, String password) throws SQLException, ClassNotFoundException {
		
		return employeeS.EmployeeLogin(email, password);
	}

	@Override
	public List<Employee> GetListEmployee() throws ClassNotFoundException, SQLException {
		
		return employeeS.GetListEmployee();
	}

	@Override
	public Employee GetEmployeebyID(int id) throws ClassNotFoundException, SQLException {
		
		return employeeS.GetEmployeebyID(id);
	}

	@Override
	public Employee GetEmployeeByName(String fullname) throws ClassNotFoundException, SQLException {
		
		return employeeS.GetEmployeeByName(fullname);
	}

	@Override
	public boolean CreateEmployee(String fullname, String Email, String password, String ProSkill)
			throws ClassNotFoundException, SQLException {
		
		return employeeS.CreateEmployee(fullname, Email, password, ProSkill);
	}

}
