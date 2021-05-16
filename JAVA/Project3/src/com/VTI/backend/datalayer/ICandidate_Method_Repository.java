package com.VTI.backend.datalayer;

import java.sql.SQLException;

import com.VTI.entity.Candidate.Category;

public interface ICandidate_Method_Repository {
	
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email, String Password, int ExplnYear1, String ProSkill1, String category) 
			throws ClassNotFoundException, SQLException;
		
	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException;
	
	public boolean createFresherCandidate(String FirstName, String Lastname, String Phone, String Email, String Password, String graduationRank, String category) 
			throws ClassNotFoundException, SQLException;
}
