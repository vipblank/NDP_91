package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VTI.entity.Employee;
import com.VTI.entity.Manager;
import com.VTI.entity.Project;
import com.VTI.entity.ProjectTeam;
import com.VTI.ultis.jdbcUltis;

public class ProjectTeam_Repository implements IProjectTeam_Repository{
	private jdbcUltis jdbc;
	public ProjectTeam_Repository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	@Override
	public List<ProjectTeam> ProjectTeamInfor1(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT pjt.ProjectID, pjt.ManagerID, mg.Fullname AS mgName, pjt.EmployeeID, ep.Fullname AS epName FROM db_quanlynhanvien.projectteam pjt\r\n" + 
				"INNER JOIN employee ep ON ep.EmployeeID = pjt.EmployeeID\r\n" + 
				"INNER JOIN manager mg ON mg.ManagerID = pjt.ManagerID\r\n" + 
				"WHERE pjt.ProjectID = ?\r\n" + 
				"ORDER BY pjt.ProjectID;";	
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<ProjectTeam> listPjTeam = new ArrayList<ProjectTeam>();
		while (resultSet.next()) {
			ProjectTeam projectTeam = new ProjectTeam();
			Manager_Repository manager_Repository = new Manager_Repository();
			Employee_repository employee_repository = new Employee_repository();
			Project_Repository project_Repository = new Project_Repository();

			Project project = project_Repository.GetProjectbyID(resultSet.getInt(1));
			projectTeam.setProject(project);

			Manager manager = manager_Repository.GetManagerbyID(resultSet.getInt(2));
			projectTeam.setManager(manager);
			Manager manager1 = manager_Repository.GetManagerbyName(resultSet.getString(3));
			projectTeam.setManager1(manager1);

			Employee employee = employee_repository.GetEmployeebyID(resultSet.getInt(4));
			projectTeam.setEmployee(employee);
			Employee employee1 = employee_repository.GetEmployeeByName(resultSet.getString(5));
			projectTeam.setEmployee1(employee1);
			
			listPjTeam.add(projectTeam);
		}
		return listPjTeam;
	}

	@Override
	public List<ProjectTeam> ProjectTeamInfor(String PjName)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT pjt.ProjectID, pj.ProjectName, pjt.ManagerID, mg.Fullname AS mgName, pjt.EmployeeID, ep.Fullname AS epName FROM db_quanlynhanvien.projectteam pjt\r\n" + 
				"INNER JOIN employee ep ON ep.EmployeeID = pjt.EmployeeID\r\n" + 
				"INNER JOIN manager mg ON mg.ManagerID = pjt.ManagerID\r\n" + 
				"INNER JOIN project pj ON pj.ProjectID = pjt.ProjectID\r\n" + 
				"WHERE pj.ProjectName = ?;";	
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, PjName);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<ProjectTeam> listPjTeam = new ArrayList<ProjectTeam>();
		while (resultSet.next()) {
			ProjectTeam projectTeam = new ProjectTeam();
			Manager_Repository manager_Repository = new Manager_Repository();
			Employee_repository employee_repository = new Employee_repository();
			Project_Repository project_Repository = new Project_Repository();

			Project project = project_Repository.GetProjectbyID(resultSet.getInt(1));
			projectTeam.setProject(project);
			Project project1 = project_Repository.GetProjectbyName(resultSet.getString(2));
			projectTeam.setProject1(project1);
			
			Manager manager = manager_Repository.GetManagerbyID(resultSet.getInt(3));
			projectTeam.setManager(manager);
			Manager manager1 = manager_Repository.GetManagerbyName(resultSet.getString(4));
			projectTeam.setManager1(manager1);

			Employee employee = employee_repository.GetEmployeebyID(resultSet.getInt(5));
			projectTeam.setEmployee(employee);
			Employee employee1 = employee_repository.GetEmployeeByName(resultSet.getString(6));
			projectTeam.setEmployee1(employee1);
			
			listPjTeam.add(projectTeam);
		}
		return listPjTeam;
	}

}
