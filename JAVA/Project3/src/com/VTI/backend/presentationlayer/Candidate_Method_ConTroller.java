package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.VTI.backend.businesslayer.ICandidate_Method_Service;
import com.VTI.backend.datalayer.Method_Candidate;
import com.VTI.ultis.jdbcUltis;

public class Candidate_Method_ConTroller implements ICandidate_Method_Service{
	private Method_Candidate methodCandidate;
	private jdbcUltis jdbc;
	public Candidate_Method_ConTroller() throws FileNotFoundException, IOException {
		methodCandidate = new Method_Candidate();
		jdbc = new jdbcUltis();
	}
	
	@Override
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, int ExplnYear1, String ProSkill1, String category)
			throws ClassNotFoundException, SQLException {
		if (checkPhoneNumber(Phone)) {
			System.err.println("Số điện thoại này đã tồn tại");
			return false;
		}else if (checkEmail(Email)) {
			System.err.println("Email này đã tồn tại");
			return false;
		}else {
			return methodCandidate.createExperienceCandidate(FirstName, Lastname, Phone, Email, Password, ExplnYear1, ProSkill1, category);
		}
	}
	@Override
	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException {
	
		return methodCandidate.loginCandidate(email, password);
	}
	@Override
	public boolean createFresherCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, String graduationRank, String category) throws ClassNotFoundException, SQLException {
		if (checkPhoneNumber(Phone)) {
			System.err.println("Số điện thoại này đã tồn tại");
			return false;
		}else if (checkEmail(Email)) {
			System.err.println("Email này đã tồn tại");
			return false;
		}else {
			return methodCandidate.createFresherCandidate(FirstName, Lastname, Phone, Email, Password, graduationRank, category);
		}		
	}

	public boolean checkPhoneNumber(String phoneNumber) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlyungvien2.Candidate WHERE Phone = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, phoneNumber);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}
	public boolean checkEmail(String email) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM db_quanlyungvien2.Candidate WHERE Email = ?;";
		PreparedStatement preparedStatement = jdbc.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}
}	
