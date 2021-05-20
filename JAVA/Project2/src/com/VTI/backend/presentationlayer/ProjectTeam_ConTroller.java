package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.businesslayer.IProjectTeam_Service;
import com.VTI.backend.businesslayer.ProjectTeam_Service;
import com.VTI.entity.ProjectTeam;

public class ProjectTeam_ConTroller implements IProjectTeam_Service{
	private ProjectTeam_Service projectTeamS;
	public ProjectTeam_ConTroller() throws FileNotFoundException, IOException {
		projectTeamS = new ProjectTeam_Service();
	}
	@Override
	public List<ProjectTeam> ProjectTeamInfor1(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return projectTeamS.ProjectTeamInfor1(id);
	}

	@Override
	public List<ProjectTeam> ProjectTeamInfor(String PjName)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return projectTeamS.ProjectTeamInfor(PjName);
	}

}
