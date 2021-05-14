package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.VTI.entity.FresherCandidate;
import com.VTI.ultis.ScannerUltis;
import com.VTI.ultis.jdbcUltis;

public class Method_FresherCandidate implements IFresher_Method_Repository {
	private jdbcUltis jdbc;

	public Method_FresherCandidate() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}

	@Override
	public boolean loginFresherCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlyungvien.freshercandidate WHERE Email = ? AND `Password` = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean createFresherCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, String graduationRank) throws ClassNotFoundException, SQLException {
		if (checkPhoneNumber(Phone)) {
			System.err.println("Số điện thoại này đã tồn tại");
			return false;
		} else if (checkEmail(Email)) {
			System.err.println("Email này đã tồn tại");
			return false;
		} else {
			String sql = "INSERT INTO `db_quanlyungvien`.`freshercandidate` (`FirstName`, `Lastname`, `Phone`, `Email`, `Password`, `GraduationRank`) \r\n"
					+ "VALUES ( ? , ? , ? , ? , ? , ? );";
			PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
			preparedStatement.setString(1, FirstName);
			preparedStatement.setString(2, Lastname);
			preparedStatement.setString(3, Phone);
			preparedStatement.setString(4, Email);
			preparedStatement.setString(5, Password);
			preparedStatement.setString(6, graduationRank);
			int result = preparedStatement.executeUpdate();
			if (result == 1) {
				return true;
			}
			return false;
		}
	}

	@Override
	public boolean checkEmail(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlyungvien.freshercandidate WHERE Email = ?;";
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
		String sql = "SELECT * FROM db_quanlyungvien.freshercandidate WHERE Phone = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, phoneNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}
}
