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
	public List<Project> GetManagerAtProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return methodRepository.GetManagerAtProject();
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

}
