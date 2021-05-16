package com.VTI.backend.datalayer;

import java.sql.SQLException;


public interface IFresher_Method_Repository {
	public boolean createFresherCandidate(String FirstName, String Lastname, String Phone, String Email, String Password, String graduationRank) 
			throws ClassNotFoundException, SQLException;
		
	public boolean loginFresherCandidate(String email, String password) throws ClassNotFoundException, SQLException;
	
}
