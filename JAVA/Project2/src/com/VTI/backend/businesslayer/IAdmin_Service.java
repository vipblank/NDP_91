package com.VTI.backend.businesslayer;
import java.sql.SQLException;


public interface IAdmin_Service {
	
	public boolean AdminLogin(String email, String password) throws SQLException, ClassNotFoundException;

}