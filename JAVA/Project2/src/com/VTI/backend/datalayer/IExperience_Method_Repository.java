package com.VTI.backend.datalayer;

import java.sql.SQLException;

public interface IExperience_Method_Repository {
	
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email, String Password, int ExplnYear, String ProSkill) 
			throws ClassNotFoundException, SQLException;
		
	public boolean loginExperienceCandidate(String email, String password) throws ClassNotFoundException, SQLException;
	
}
