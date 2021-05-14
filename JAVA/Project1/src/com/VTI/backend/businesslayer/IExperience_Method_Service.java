package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.VTI.backend.datalayer.Method_ExperienceCandidate;

public interface IExperience_Method_Service {
	
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email, String Password, int ExplnYear, String ProSkill) 
			throws ClassNotFoundException, SQLException;
	
	public boolean loginExperienceCandidate(String email, String password) throws ClassNotFoundException, SQLException;
}
