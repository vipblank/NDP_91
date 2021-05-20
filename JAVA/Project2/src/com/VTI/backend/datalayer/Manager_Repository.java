package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VTI.entity.Manager;
import com.VTI.ultis.jdbcUltis;

public class Manager_Repository implements IManager_Repository{
	private jdbcUltis jdbc;
	public Manager_Repository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
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
	public List<Manager> GetListManager() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlynhanvien.manager;";
		ResultSet resultSet = jdbc.executeQuery(sql);
		List<Manager> listMg = new ArrayList<Manager>();
		while (resultSet.next()) {
			Manager manager = new Manager(resultSet.getInt("ManagerID"), resultSet.getString("Fullname"),
					resultSet.getString("MgEmail"), resultSet.getString("Password"), resultSet.getInt("ExplnYear"));
			listMg.add(manager);
		}
		return listMg;
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

	@Override
	public boolean CreateManager(String fullname, String Email, String password, int ExplnYear)
			throws ClassNotFoundException, SQLException {
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
