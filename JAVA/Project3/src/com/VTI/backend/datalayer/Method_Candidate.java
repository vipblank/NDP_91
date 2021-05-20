package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.VTI.ultis.jdbcUltis;

public class Method_Candidate implements ICandidate_Method_Repository {
	private jdbcUltis jdbc;

	public Method_Candidate() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, int ExplnYear, String ProSkill, String category)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO `db_quanlyungvien2`.`candidate` (`FirstName`, `Lastname`, `Phone`, `Email`, `Password`, `ExplnYear`, `ProSkill`, `Category`)\r\n"
				+ " VALUES 											(? ,			 ?,			?, 		?, 		   ?, 			?, 			?, 			?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, FirstName);
		preparedStatement.setString(2, Lastname);
		preparedStatement.setString(3, Phone);
		preparedStatement.setString(4, Email);
		preparedStatement.setString(5, Password);
		preparedStatement.setInt(6, ExplnYear);
		preparedStatement.setString(7, ProSkill);
		preparedStatement.setString(8, category);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean createFresherCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, String graduationRank, String category) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO `db_quanlyungvien2`.`candidate` (`FirstName`, `Lastname`, `Phone`, `Email`, `Password`, `GraduationRank`, `Category`)\r\n"
				+ " VALUES (? , ?, ?, ?, ?, ?, ?);";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, FirstName);
		preparedStatement.setString(2, Lastname);
		preparedStatement.setString(3, Phone);
		preparedStatement.setString(4, Email);
		preparedStatement.setString(5, Password);
		preparedStatement.setString(6, graduationRank);
		preparedStatement.setString(7, category);
		int result = preparedStatement.executeUpdate();
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT ID, FirstName, Lastname, Phone, Email, Category FROM db_quanlyungvien2.candidate WHERE Email = ? AND Password = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
			return false;
	}

	public boolean checkPhoneNumber(String Phone) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlyungvien2.candidate WHERE Phone = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, Phone);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}

	}
	public boolean checkEmail(String Email) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM db_quanlyungvien2.candidate WHERE Email = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, Email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			jdbc.disConnection();
			return false;
		}		
	}
}
