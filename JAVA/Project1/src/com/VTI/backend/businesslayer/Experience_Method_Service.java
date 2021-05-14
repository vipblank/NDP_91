package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.VTI.backend.datalayer.Method_ExperienceCandidate;

public class Experience_Method_Service implements IExperience_Method_Service{
	private Method_ExperienceCandidate registerExperienceCandidate;
	public Experience_Method_Service() throws FileNotFoundException, IOException {
		registerExperienceCandidate = new Method_ExperienceCandidate();
	}

	@Override
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, int ExplnYear, String ProSkill) throws ClassNotFoundException, SQLException {
		
		return registerExperienceCandidate.createExperienceCandidate(FirstName, Lastname, Phone, Email, Password, ExplnYear, ProSkill);
	}

	@Override
	public boolean loginExperienceCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		
		return registerExperienceCandidate.loginExperienceCandidate(email, password);
	}

}
