package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VTI.entity.Manager;
import com.VTI.entity.Project;
import com.VTI.ultis.jdbcUltis;

public class Project_Repository implements IProject_Repository {
	private jdbcUltis jdbc;

	public Project_Repository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public List<Project> GetManagerAtProject1()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT pj.ProjectID, pj.ProjectName, pj.ProjectManagerID, mg.Fullname, pj.TeamSize FROM db_quanlynhanvien.project pj\r\n"
				+ "INNER JOIN manager mg ON pj.ProjectManagerID = mg.ManagerID;";
		List<Project> listPj = new ArrayList<Project>();
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			Project project = new Project();
			project.setProjectID(resultSet.getInt(1));
			project.setProjectName(resultSet.getString(2));
			
			Manager_Repository manager_Repository = new Manager_Repository();
			Manager manager = manager_Repository.GetManagerbyID(resultSet.getInt(3));
			project.setManager(manager);
			
			Manager manager1 = manager_Repository.GetManagerbyName(resultSet.getString(4));
			project.setManager1(manager1);
			project.setTeamSize(resultSet.getInt(5));
			listPj.add(project);
		}
		return listPj;
	}

	@Override
	public List<Project> GetListProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM db_quanlynhanvien.project;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Project> listPj = new ArrayList<Project>();
		while (resultSet.next()) {
			Project project = new Project();
			project.setProjectID(resultSet.getInt(1));
			project.setProjectName(resultSet.getString(2));

			Manager_Repository manager_Repository = new Manager_Repository();
			Manager manager = manager_Repository.GetManagerbyID(resultSet.getInt(3));
			project.setManager(manager);
			project.setTeamSize(resultSet.getInt(4));
			listPj.add(project);
		}
		return listPj;
	}

	@Override
	public Project GetProjectbyID(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM db_quanlynhanvien.project WHERE ProjectID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Project project = new Project();
			project.setProjectID(resultSet.getInt(1));
			project.setProjectName(resultSet.getString(2));
			Manager_Repository manager_Repository = new Manager_Repository();
			Manager manager = manager_Repository.GetManagerbyID(resultSet.getInt(3));
			project.setManager(manager);
			project.setTeamSize(resultSet.getInt(4));
			return project;

		}
		return null;
	}

	@Override
	public boolean CreateProject(String projectName, int managerID, int teamsize)
			throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `db_quanlynhanvien`.`project` (`ProjectName`, `ProjectManagerID`, `TeamSize`) VALUES ( ?, ? , ? );";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, projectName);
		preparedStatement.setInt(2, managerID);
		preparedStatement.setInt(3, teamsize);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println("Tạo mới thành công");
			return true;
		}
		return false;
	}

	@Override
	public boolean UpdateProject(int PjID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		
		return false;
	}

	@Override
	public Project GetProjectbyName(String PjName)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM db_quanlynhanvien.project WHERE ProjectName = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, PjName);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Project project = new Project();
			project.setProjectID(resultSet.getInt(1));
			project.setProjectName(resultSet.getString(2));
			Manager_Repository manager_Repository = new Manager_Repository();
			Manager manager = manager_Repository.GetManagerbyID(resultSet.getInt(3));
			project.setManager(manager);
			project.setTeamSize(resultSet.getInt(4));
			return project;

		}
		return null;
	}
	public boolean checkPjName(String projectName) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.project WHERE ProjectName = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, projectName);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}
}
