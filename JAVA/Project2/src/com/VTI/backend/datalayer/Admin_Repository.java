package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.VTI.ultis.jdbcUltis;

public class Admin_Repository implements IAdmin_Repository {
	private static jdbcUltis jdbc;

	public Admin_Repository() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
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

}