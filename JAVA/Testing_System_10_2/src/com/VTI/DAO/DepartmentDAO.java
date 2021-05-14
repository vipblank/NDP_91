package com.VTI.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.VTI.entity.Department;
import com.VTI.ultis.jdbcUltis;

public class DepartmentDAO {
	private static jdbcUltis jdbc;
	
	public DepartmentDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis(); 
	}
	public List<Department> getlistDepartments() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM DB_connect.department";
		ResultSet depResultSet = jdbc.executeQuery(sql);	
		List<Department> listdep = new ArrayList<Department>();
		while (depResultSet.next()) {
			Department department = new Department(depResultSet.getInt("DepartmentID"), depResultSet.getString("DepartmentName"));
			listdep.add(department);		
		}		
		return listdep;		
	}
	public Department getDepByID(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM DB_connect.department WHERE DepartmentID = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);	
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			Department department = new Department(resultSet.getInt("DepartmentID"), resultSet.getString("DepartmentName"));
			return department;
		}else {
			System.out.println("Không tìm được");
			return null;
		}		
	}
	public boolean isDepartmentNameExists(String name) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM DB_connect.department WHERE DepartmentName = ?";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);	
		preparedStatement.setString(1, name);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}else {
			return false;
		}	
	}
	public void createDepartment (String name) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `DB_connect`.`department` (`DepartmentName`) VALUES (?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, name);
		if (preparedStatement.executeUpdate() == 1) {
			System.out.println("Tạo mới thành công");
		}else {
			System.out.println("Không thể tạo mới. Mời kiểm tra lại");
		}
	}
	public void updateDepartmentName(int id, String newname) throws ClassNotFoundException, SQLException {
		Department departmentID = getDepByID(id);
		if (departmentID == null) {
			System.out.println("Phòng ban chưa được khởi tạo");
		}else {
			String sql = "UPDATE `db_connect`.`department` SET `DepartmentName` = ? WHERE (`DepartmentID` = ?);";
			PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
			preparedStatement.setString(1, newname);
			preparedStatement.setInt(2, id);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				System.out.println("Update thành công");
			}else {
				System.out.println("Không thể Update. Xin kiểm tra lại");
			}
		}	
	}
	public boolean deleteDepartment(int id) throws ClassNotFoundException, SQLException {
		Department departmentID = getDepByID(id);
		if (departmentID == null) {
			System.out.println("Phòng ban chưa được khởi tạo");
			return false;
	}else {
		String sql = "DELETE FROM `db_connect`.`department` WHERE (`DepartmentID` = ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setInt(1, id);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			System.out.println("Delete thành công");
			return true;
		}else {
			System.out.println("Không thể Delete. Xin kiểm tra lại");
			return false;
			}
		}
	}
}
