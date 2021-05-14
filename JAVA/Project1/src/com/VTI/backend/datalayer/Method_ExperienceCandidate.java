package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.VTI.ultis.jdbcUltis;

public class Method_ExperienceCandidate implements IExperience_Method_Repository{
	private jdbcUltis jdbc;
	public Method_ExperienceCandidate() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email, String Password, int ExplnYear, String ProSkill) 
			throws ClassNotFoundException, SQLException {
		if (checkPhoneNumber(Phone)) {
			System.err.println("Số điện thoại này đã tồn tại");
			return false;
		}else if (checkEmail(Email)) {
			System.err.println("Email này đã tồn tại");
			return false;
		}else {
			String sql = "INSERT INTO `db_quanlyungvien`.`experiencecandidate` (`FirstName`, `Lastname`, `Phone`, `Email`, `Password`, `ExplnYear`, `ProSkill`) \r\n" + 
					"VALUES ( ? , ? , ? , ? , ? , ? , ? );";
			PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
			preparedStatement.setString(1, FirstName);
			preparedStatement.setString(2, Lastname);
			preparedStatement.setString(3, Phone);
			preparedStatement.setString(4, Email);
			preparedStatement.setString(5, Password);
			preparedStatement.setInt(6, ExplnYear);
			preparedStatement.setString(7, ProSkill);
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
	public boolean loginExperienceCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlyungvien.experiencecandidate WHERE Email = ? AND `Password` = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}else {
			return false;
		}	
	}

	@Override
	public boolean checkEmail(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlyungvien.experiencecandidate WHERE Email = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkPhoneNumber(String phoneNumber) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlyungvien.experiencecandidate WHERE Phone = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, phoneNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}
}
