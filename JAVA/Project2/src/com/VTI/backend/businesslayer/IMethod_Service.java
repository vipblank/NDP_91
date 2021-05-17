package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.Employee;
import com.VTI.entity.Manager;
import com.VTI.entity.Project;
import com.VTI.entity.ProjectTeam;

public interface IMethod_Service {
	public void Login1(String email, String password) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public boolean EmployeeLogin(String email, String password) throws SQLException, ClassNotFoundException;
	
	public boolean ManagerLogin(String email, String password) throws ClassNotFoundException, SQLException;
	
	public boolean AdminLogin(String email, String password) throws SQLException, ClassNotFoundException;
	
	public List<ProjectTeam> ProjectTeamInfor(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public List<Project> GetManagerAtProject1() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public List<Employee> GetListEmployee() throws ClassNotFoundException, SQLException;
	
	public List<Manager> GetListManager() throws ClassNotFoundException, SQLException;
	
	public List<Project> GetListProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public Employee GetEmployeebyID(int id) throws ClassNotFoundException, SQLException;
	
	public Manager GetManagerbyID(int id) throws ClassNotFoundException, SQLException;
	
	public Project GetProjectbyID(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public boolean CreateManager(String fullname, String Email, String password, int ExplnYear) throws ClassNotFoundException, SQLException;
	
	public boolean CreateEmployee(String fullname, String Email, String password, String ProSkill) throws ClassNotFoundException, SQLException;
	
	public boolean CreateProject(String projectName, int managerID, int teamsize) throws ClassNotFoundException, SQLException;
	
	public boolean UpdateManager();
	
	public boolean UpdateEmployee();
	
	public boolean UpdateProject(int PjID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	public boolean DeleteManager();
	
	public boolean DeleteEmployee();
	
	public boolean DeleteProject(int PjID);

}