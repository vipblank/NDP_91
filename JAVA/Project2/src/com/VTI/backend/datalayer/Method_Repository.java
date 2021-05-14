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
import com.VTI.ultis.ScannerUltis;
import com.VTI.ultis.jdbcUltis;

public class Method_Repository implements IMethod_Repository {
	private jdbcUltis jdbc;

	public Method_Repository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public boolean AdminLogin(String email, String password) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM db_quanlynhanvien.admin WHERE Email = ? AND `Password` = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean ManagerLogin(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.manager WHERE Email = ? AND `Password` = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean EmployeeLogin(String email, String password) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM db_quanlynhanvien.employee WHERE Email = ? AND `Password` = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	@Override
	public List<ProjectTeam> ProjectTeamInfor(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM db_quanlynhanvien.projectteam WHERE ProjectID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<ProjectTeam> listPjTeam = new ArrayList<ProjectTeam>();
		while (resultSet.next()) {
			ProjectTeam projectTeam = new ProjectTeam();
			Method_Repository method_Repository = new Method_Repository();

			Project project = method_Repository.GetProjectbyID(resultSet.getInt(1));
			projectTeam.setProject(project);

			Manager manager = method_Repository.GetManagerbyID(resultSet.getInt(2));
			projectTeam.setManager(manager);

			Employee employee = method_Repository.GetEmployeebyID(resultSet.getInt(3));
			projectTeam.setEmployee(employee);
			listPjTeam.add(projectTeam);
		}
		return listPjTeam;
	}

	@Override
	public List<Project> GetManagerAtProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT ProjectID, ProjectManagerID FROM db_quanlynhanvien.project ORDER BY ProjectID;";
		List<Project> listPj = new ArrayList<Project>();
		ResultSet resultSet = jdbc.executeQuery(sql);
		while (resultSet.next()) {
			Project project = new Project();
			project.setProjectID(resultSet.getInt(1));
			Method_Repository method_Repository = new Method_Repository();
			Manager manager = method_Repository.GetManagerbyID(resultSet.getInt(2));
			project.setManager(manager);
			listPj.add(project);
		}
		return listPj;
	}

	@Override
	public Employee GetEmployeebyID(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.employee WHERE EmployeeID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Employee employee = new Employee(resultSet.getInt("EmployeeID"), resultSet.getString("Fullname"),
					resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getString("ProSkill"));
			return employee;
		} else {
			System.out.println("Không tìm thấy thông tin");
			return null;
		}
	}

	@Override
	public Manager GetManagerbyID(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.manager WHERE ManagerID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Manager manager = new Manager(resultSet.getInt("ManagerID"), resultSet.getString("Fullname"),
					resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("ExplnYear"));
			return manager;
		} else {
			System.out.println("Không tìm thấy thông tin");
			return null;
		}
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

			Method_Repository method_Repository = new Method_Repository();
			Manager manager = method_Repository.GetManagerbyID(resultSet.getInt(3));
			project.setManager(manager);

			project.setTeamSize(resultSet.getInt(4));
			return project;

		} else {
			System.out.println("Không tìm thấy thông tin");
			return null;
		}
	}

	@Override
	public List<Employee> GetListEmployee() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.employee;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Employee> listEp = new ArrayList<Employee>();
		while (resultSet.next()) {
			Employee employee = new Employee(resultSet.getInt("EmployeeID"), resultSet.getString("Fullname"),
					resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getString("ProSkill"));
			listEp.add(employee);
		}
		return listEp;
	}

	@Override
	public List<Manager> GetListManager() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.manager;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Manager> listMg = new ArrayList<Manager>();
		while (resultSet.next()) {
			Manager manager = new Manager(resultSet.getInt("ManagerID"), resultSet.getString("Fullname"),
					resultSet.getString("Email"), resultSet.getString("Password"), resultSet.getInt("ExplnYear"));
			listMg.add(manager);
		}
		return listMg;
	}
	
	@Override
	public List<Project> GetListProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sql = "SELECT * FROM db_quanlynhanvien.project;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Project> listPj = new ArrayList<Project>();
		while (resultSet.next()) {
			Project project = new Project();
			project.setProjectID(resultSet.getInt(1));
			project.setProjectName(resultSet.getString(2));
			
			Method_Repository method_Repository = new Method_Repository();
			Manager manager = method_Repository.GetManagerbyID(resultSet.getInt(3));
			project.setManager(manager);
			project.setTeamSize(resultSet.getInt(4));
			listPj.add(project);		
		}
		return listPj;
	}
	
	@Override
	public void UpdateEmployee() {

	}

	@Override
	public void UpdateManager() {

	}

	@Override
	public void DeleteEmployee() {

	}

	@Override
	public void DeleteManager() {

	}
}
