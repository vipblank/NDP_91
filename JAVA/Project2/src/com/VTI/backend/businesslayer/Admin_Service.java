package com.VTI.backend.businesslayer;
import java.sql.SQLException;
import com.VTI.backend.datalayer.Admin_Repository;


public class Admin_Service implements IAdmin_Service{
	private static Admin_Repository adminR;

	@Override
	public boolean AdminLogin(String email, String password) throws SQLException, ClassNotFoundException {
		
		return adminR.AdminLogin(email, password);
	}

}