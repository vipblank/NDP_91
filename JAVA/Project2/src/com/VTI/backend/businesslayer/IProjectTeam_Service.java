package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.ProjectTeam;

public interface IProjectTeam_Service {

public List<ProjectTeam> ProjectTeamInfor1(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public List<ProjectTeam> ProjectTeamInfor(String PjName) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
}
