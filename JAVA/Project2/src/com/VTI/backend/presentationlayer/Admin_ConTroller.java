package com.VTI.backend.presentationlayer;
import java.sql.SQLException;

import com.VTI.backend.businesslayer.Admin_Service;
import com.VTI.backend.businesslayer.IAdmin_Service;

public class Admin_ConTroller implements IAdmin_Service{
	private Admin_Service adminS;
	
	@Override
	public boolean AdminLogin(String email, String password) throws SQLException, ClassNotFoundException {
		
		return adminS.AdminLogin(email, password);
	}

	
}