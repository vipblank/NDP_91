package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VTI.entity.Employee;
import com.VTI.ultis.jdbcUltis;

public class Employee_repository implements IEmployee_Repository{
	private jdbcUltis jdbc;
	public Employee_repository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
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
	public List<Employee> GetListEmployee() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.employee;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Employee> listEp = new ArrayList<Employee>();
		while (resultSet.next()) {
			Employee employee = new Employee(resultSet.getInt("EmployeeID"), resultSet.getString("Fullname"),
					resultSet.getString("EpEmail"), resultSet.getString("Password"), resultSet.getString("ProSkill"));
			listEp.add(employee);
		}
		return listEp;
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
	public boolean CreateEmployee(String fullname, String Email, String password, String ProSkill)
			throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `db_quanlynhanvien`.`employee` (`Fullname`, `EpEmail`, `Password`, `ProSkill`) VALUES ( ?, ?, ?, ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, fullname);
		preparedStatement.setString(2, Email);
		preparedStatement.setString(3, password);
		preparedStatement.setString(4, ProSkill);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			return true;
		} 
			return false;
	}
	public  boolean checkEmailManager(String email) throws ClassNotFoundException, SQLException {
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

	public  boolean checkEmailEmployee(String email) throws ClassNotFoundException, SQLException {
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

	public  boolean checkEmailAdmin(String email) throws ClassNotFoundException, SQLException {
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
}
