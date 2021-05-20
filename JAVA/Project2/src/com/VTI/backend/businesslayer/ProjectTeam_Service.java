package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.datalayer.ProjectTeam_Repository;
import com.VTI.entity.ProjectTeam;

public class ProjectTeam_Service implements IProjectTeam_Service{
	private ProjectTeam_Repository projectTeam;
	public ProjectTeam_Service() throws FileNotFoundException, IOException {
		projectTeam = new ProjectTeam_Repository();
	}
	
	@Override
	public List<ProjectTeam> ProjectTeamInfor1(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return projectTeam.ProjectTeamInfor1(id);
	}

	@Override
	public List<ProjectTeam> ProjectTeamInfor(String PjName)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return projectTeam.ProjectTeamInfor(PjName);
	}

}
