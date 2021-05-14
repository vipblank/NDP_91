package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.VTI.backend.businesslayer.IFresher_Method_Service;
import com.VTI.backend.datalayer.Method_FresherCandidate;

public class Fresher_Method_ConTroller implements IFresher_Method_Service{
	private Method_FresherCandidate methodfresherCandidate;
	public Fresher_Method_ConTroller() throws FileNotFoundException, IOException {
		methodfresherCandidate = new Method_FresherCandidate();
	}
	@Override
	public boolean createFresherCandidate(String FirstName, String Lastname, String Phone, String Email,
			String Password, String graduationRank) throws ClassNotFoundException, SQLException {
		
		return methodfresherCandidate.createFresherCandidate(FirstName, Lastname, Phone, Email, Password, graduationRank);
	}
	@Override
	public boolean loginFresherCandidate(String email, String password) throws ClassNotFoundException, SQLException {
		
		return methodfresherCandidate.loginFresherCandidate(email, password);
	}
}	
