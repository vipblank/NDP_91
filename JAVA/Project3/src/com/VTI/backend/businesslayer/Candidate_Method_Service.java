package com.VTI.backend.businesslayer;

import java.sql.SQLException;

import com.VTI.backend.datalayer.Method_Candidate;

public class Candidate_Method_Service implements ICandidate_Method_Service{
	private Method_Candidate methodCandidate;
	@Override
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, int ExplnYear1, String ProSkill1, String category)
			throws ClassNotFoundException, SQLException {
	
		return methodCandidate.createExperienceCandidate(FirstName, Lastname, Phone, Email, Password, ExplnYear1, ProSkill1, category);
	}

	@Override
	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		
		return methodCandidate.loginCandidate(email, password);
	}

	@Override
	public boolean createFresherCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, String graduationRank, String category) throws ClassNotFoundException, SQLException {
		
		return methodCandidate.createFresherCandidate(FirstName, Lastname, Phone, Email, Password, graduationRank, category);
	}



}
