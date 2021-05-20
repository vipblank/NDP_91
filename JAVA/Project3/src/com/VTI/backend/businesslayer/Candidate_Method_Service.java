package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.VTI.backend.datalayer.Method_Candidate;

public class Candidate_Method_Service implements ICandidate_Method_Service{
	private Method_Candidate methodCandidate;
	public Candidate_Method_Service() throws FileNotFoundException, IOException {
		methodCandidate = new Method_Candidate();
	}
	@Override
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, int ExplnYear1, String ProSkill1, String category)
			throws ClassNotFoundException, SQLException {
		if (methodCandidate.checkEmail(Email) && methodCandidate.checkPhoneNumber(Phone)) {
			System.err.println("PhoneNumber hoặc Email đã tồn tại. Tạo mới thất bại");
			return false;
		}
		return methodCandidate.createExperienceCandidate(FirstName, Lastname, Phone, Email, Password, ExplnYear1, ProSkill1, category);
	}

	@Override
	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		
		return methodCandidate.loginCandidate(email, password);
	}

	@Override
	public boolean createFresherCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, String graduationRank, String category) throws ClassNotFoundException, SQLException {
		if (methodCandidate.checkEmail(Email) && methodCandidate.checkPhoneNumber(Phone)) {
			System.err.println("PhoneNumber hoặc Email đã tồn tại. Tạo mới thất bại");
			return false;
		}
		return methodCandidate.createFresherCandidate(FirstName, Lastname, Phone, Email, Password, graduationRank, category);
	}



}
