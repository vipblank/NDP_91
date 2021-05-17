package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.businesslayer.IMethod_Service;
import com.VTI.backend.datalayer.Method_Repository;
import com.VTI.entity.Employee;
import com.VTI.entity.Manager;
import com.VTI.entity.Project;
import com.VTI.entity.ProjectTeam;

public class Method_ConTroller implements IMethod_Service{
	private Method_Repository methodRepository;
	
	@Override
	public void Login1(String email, String password) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		
	}

	@Override
	public boolean EmployeeLogin(String email, String password) throws SQLException, ClassNotFoundException {
	
		return methodRepository.EmployeeLogin(email, password);
	}

	@Override
	public boolean ManagerLogin(String email, String password) throws ClassNotFoundException, SQLException {
		
		return methodRepository.ManagerLogin(email, password);
	}

	@Override
	public boolean AdminLogin(String email, String password) throws SQLException, ClassNotFoundException {
		
		return methodRepository.AdminLogin(email, password);
	}

	@Override
	public List<ProjectTeam> ProjectTeamInfor(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return methodRepository.ProjectTeamInfor(id);
	}

	@Override
	public List<Employee> GetListEmployee() throws ClassNotFoundException, SQLException {
		
		return methodRepository.GetListEmployee();
	}
	
	@Override
	public List<Manager> GetListManager() throws ClassNotFoundException, SQLException {
		
		return methodRepository.GetListManager();
	}
	
	@Override
	public List<Project> GetListProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		return methodRepository.GetListProject();
	}
	
	@Override
	public Employee GetEmployeebyID(int id) throws ClassNotFoundException, SQLException {
		
		return methodRepository.GetEmployeebyID(id);
	}

	@Override
	public Manager GetManagerbyID(int id) throws ClassNotFoundException, SQLException {
		
		return methodRepository.GetManagerbyID(id);
	}

	@Override
	public Project GetProjectbyID(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return methodRepository.GetProjectbyID(id);
	}

	@Override
	public List<Project> GetManagerAtProject1()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return methodRepository.GetManagerAtProject1();
	}

	@Override
	public boolean CreateManager(String fullname, String Email, String password, int ExplnYear)
			throws ClassNotFoundException, SQLException {
		
		return CreateManager(fullname, Email, password, ExplnYear);
	}

	@Override
	public boolean CreateEmployee(String fullname, String Email, String password, String ProSkill)
			throws ClassNotFoundException, SQLException {
		
		return CreateEmployee(fullname, Email, password, ProSkill);
	}

	@Override
	public boolean CreateProject(String projectName, int managerID, int teamsize)
			throws ClassNotFoundException, SQLException {
		
		return methodRepository.CreateProject(projectName, managerID, teamsize);
	}

	@Override
	public boolean UpdateManager() {
		
		return false;
	}

	@Override
	public boolean UpdateEmployee() {
		
		return false;
	}

	@Override
	public boolean UpdateProject(int PjID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		
		return false;
	}

	@Override
	public boolean DeleteManager() {
		
		return false;
	}

	@Override
	public boolean DeleteEmployee() {
		
		return false;
	}

	@Override
	public boolean DeleteProject(int PjID) {
		
		return false;
	}

}