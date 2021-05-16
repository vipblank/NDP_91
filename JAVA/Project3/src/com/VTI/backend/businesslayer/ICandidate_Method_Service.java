package com.VTI.backend.businesslayer;

import java.sql.SQLException;

public interface ICandidate_Method_Service {
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email, String Password, int ExplnYear1, String ProSkill1, String category) 
			throws ClassNotFoundException, SQLException;
		
	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException;
	
	public boolean createFresherCandidate(String FirstName, String Lastname, String Phone, String Email, String Password, String graduationRank, String category) 
			throws ClassNotFoundException, SQLException;
	
}
