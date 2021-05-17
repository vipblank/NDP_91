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

public class Method_Repository implements IMethod_Repository {
	private static jdbcUltis jdbc;

	public Method_Repository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
	@Override
	public void Login1(String email, String password)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		if (checkEmailAdmin(email) && checkPassAdmin(password)) {
			Method_Repository method_Repository = new Method_Repository();
			method_Repository.AdminLogin(email, password);
		} else if (checkEmailEmployee(email) && checkPassEmployee(password)) {
			Method_Repository method_Repository = new Method_Repository();
			method_Repository.EmployeeLogin(email, password);
		} else if (checkEmailManager(email) && checkPassManager(password)) {
			Method_Repository method_Repository = new Method_Repository();
			method_Repository.ManagerLogin(email, password);
		}
	}

	@Override
	public boolean AdminLogin(String email, String password) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM db_quanlynhanvien.admin WHERE AdEmail = ? AND `Password` = ?;";
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
		String sql = "SELECT * FROM db_quanlynhanvien.manager WHERE MgEmail = ? AND `Password` = ?;";
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
		String sql = "SELECT * FROM db_quanlynhanvien.employee WHERE EpEmail = ? AND `Password` = ?;";
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
			Method_Repository method_Repository = new Method_Repository();

			Project project = method_Repository.GetProjectbyID(resultSet.getInt(1));
			projectTeam.setProject(project);

			Manager manager = method_Repository.GetManagerbyID(resultSet.getInt(2));
			projectTeam.setManager(manager);
			Manager manager1 = method_Repository.GetManagerbyName(resultSet.getString(3));
			projectTeam.setManager1(manager1);

			Employee employee = method_Repository.GetEmployeebyID(resultSet.getInt(4));
			projectTeam.setEmployee(employee);
			Employee employee1 = method_Repository.GetEmployeeByName(resultSet.getString(5));
			projectTeam.setEmployee1(employee1);
			
			listPjTeam.add(projectTeam);
		}
		return listPjTeam;
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
			Method_Repository method_Repository = new Method_Repository();
			Manager manager = method_Repository.GetManagerbyID(resultSet.getInt(3));
			project.setManager(manager);
			Manager manager1 = method_Repository.GetManagerbyName(resultSet.getString(4));
			project.setManager1(manager1);
			project.setTeamSize(resultSet.getInt(5));
			listPj.add(project);
		}
		return listPj;
	}

	public Manager GetManagerbyName(String fullname) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.manager WHERE Fullname = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, fullname);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Manager manager = new Manager(resultSet.getInt("ManagerID"), resultSet.getString("Fullname"),
					resultSet.getString("MgEmail"), resultSet.getString("Password"), resultSet.getInt("ExplnYear"));
			return manager;
		}
		return null;
	}
	
	public Employee GetEmployeeByName(String fullname) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.employee WHERE Fullname = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, fullname);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Employee employee = new Employee(resultSet.getInt("EmployeeID"), resultSet.getString("Fullname"),
					resultSet.getString("EpEmail"), resultSet.getString("Password"), resultSet.getString("ProSkill"));
			return employee;
		}
		return null;
	}

	@Override
	public Employee GetEmployeebyID(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.employee WHERE EmployeeID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Employee employee = new Employee(resultSet.getInt("EmployeeID"), resultSet.getString("Fullname"),
					resultSet.getString("EpEmail"), resultSet.getString("Password"), resultSet.getString("ProSkill"));
			return employee;
		} 
			return null;
	}

	@Override
	public Manager GetManagerbyID(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.manager WHERE ManagerID = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Manager manager = new Manager(resultSet.getInt("ManagerID"), resultSet.getString("Fullname"),
					resultSet.getString("MgEmail"), resultSet.getString("Password"), resultSet.getInt("ExplnYear"));
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
	public List<Project> GetListProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
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
	public boolean UpdateEmployee() {
		return false;

	}

	@Override
	public boolean UpdateManager() {
		return false;

	}

	@Override
	public boolean DeleteEmployee() {
		return false;

	}

	@Override
	public boolean DeleteManager() {
		return false;

	}

	@Override
	public boolean CreateManager(String fullname, String Email, String password, int ExplnYear)
			throws ClassNotFoundException, SQLException {
		if (checkEmailManager(Email) || checkEmailAdmin(Email) || checkEmailEmployee(Email)) {
			System.err.println("Email này đã tồn tại");
			return false;
		} else {
			String sql = "INSERT INTO `db_quanlynhanvien`.`manager` (`Fullname`, `MgEmail`, `Password`, `ExplnYear`) VALUES ( ?, ?, ?, ?);";
			PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
			preparedStatement.setString(1, fullname);
			preparedStatement.setString(2, Email);
			preparedStatement.setString(3, password);
			preparedStatement.setInt(4, ExplnYear);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean CreateEmployee(String fullname, String Email, String password, String ProSkill)
			throws ClassNotFoundException, SQLException {
		if (checkEmailManager(Email) || checkEmailAdmin(Email) || checkEmailEmployee(Email)) {
			System.err.println("Email này đã tồn tại");
			return false;
		} else {
			String sql = "INSERT INTO `db_quanlynhanvien`.`employee` (`Fullname`, `EpEmail`, `Password`, `ProSkill`) VALUES ( ?, ?, ?, ?);";
			PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
			preparedStatement.setString(1, fullname);
			preparedStatement.setString(2, Email);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, ProSkill);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				System.out.println("Không thể tạo mới. Mời kiểm tra lại");
				return false;
			}
		}
	}

	@Override
	public boolean CreateProject(String projectName, int managerID, int teamsize)
			throws ClassNotFoundException, SQLException {
		if (checkPjName(projectName)) {
			System.err.println("ProjectName đã tồn tại");
			return false;
		} else {
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
		}
		return false;
	}

	@Override
	public boolean UpdateProject(int PjID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
				return false;
	}

	@Override
	public boolean DeleteProject(int PjID) {

		return false;
	}

	public static boolean checkEmailManager(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.manager WHERE MgEmail = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public static boolean checkEmailEmployee(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.employee WHERE EpEmail = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}

	}

	public static boolean checkEmailAdmin(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.admin WHERE AdEmail = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public static boolean checkPassEmployee(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.admin WHERE Password = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public static boolean checkPassManager(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.admin WHERE Password = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public static boolean checkPassAdmin(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.admin WHERE Password = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}
	}

	public static boolean checkPjName(String projectName) throws ClassNotFoundException, SQLException {
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