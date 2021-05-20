package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.VTI.backend.businesslayer.Candidate_Method_Service;
import com.VTI.backend.businesslayer.ICandidate_Method_Service;

public class Candidate_Method_ConTroller implements ICandidate_Method_Service{
	private Candidate_Method_Service candidateS;
	
	public Candidate_Method_ConTroller() throws FileNotFoundException, IOException {
		candidateS = new Candidate_Method_Service();
	}
	
	@Override
	public boolean createExperienceCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, int ExplnYear1, String ProSkill1, String category)
			throws ClassNotFoundException, SQLException {
	
			return candidateS.createExperienceCandidate(FirstName, Lastname, Phone, Email, Password, ExplnYear1, ProSkill1, category);
		
	}
	@Override
	public boolean loginCandidate(String email, String password) throws ClassNotFoundException, SQLException {
	
		return candidateS.loginCandidate(email, password);
	}
	@Override
	public boolean createFresherCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, String graduationRank, String category) throws ClassNotFoundException, SQLException {
		
			return candidateS.createFresherCandidate(FirstName, Lastname, Phone, Email, Password, graduationRank, category);
			
	}

}	
