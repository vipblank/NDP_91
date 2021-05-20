package com.VTI.backend.datalayer;
import java.sql.SQLException;

public interface IAdmin_Repository {
	
	public boolean AdminLogin(String email, String password) throws SQLException, ClassNotFoundException;


}