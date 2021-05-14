package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.Employee;
import com.VTI.entity.Manager;
import com.VTI.entity.Project;
import com.VTI.entity.ProjectTeam;

public interface IMethod_Repository {
		
	public boolean EmployeeLogin(String email, String password) throws SQLException, ClassNotFoundException;
	
	public boolean ManagerLogin(String email, String password) throws ClassNotFoundException, SQLException;
	
	public boolean AdminLogin(String email, String password) throws SQLException, ClassNotFoundException;
	
	public List<ProjectTeam> ProjectTeamInfor(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public List<Project> GetManagerAtProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public List<Employee> GetListEmployee() throws ClassNotFoundException, SQLException;
	
	public List<Manager> GetListManager() throws ClassNotFoundException, SQLException;
	
	public List<Project> GetListProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public Employee GetEmployeebyID(int id) throws ClassNotFoundException, SQLException;
	
	public Manager GetManagerbyID(int id) throws ClassNotFoundException, SQLException;
	
	public Project GetProjectbyID(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public void UpdateEmployee();
	
	public void UpdateManager();
	
	public void DeleteEmployee();
	
	public void DeleteManager();
}
