package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.businesslayer.IProject_Service;
import com.VTI.backend.businesslayer.Project_Service;
import com.VTI.entity.Project;

public class Project_ConTroller implements IProject_Service{
	private Project_Service projectS;
	public Project_ConTroller() throws FileNotFoundException, IOException {
		projectS = new Project_Service();
	}
	@Override
	public List<Project> GetManagerAtProject1()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return projectS.GetManagerAtProject1();
	}

	@Override
	public List<Project> GetListProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return projectS.GetListProject();
	}

	@Override
	public Project GetProjectbyID(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return projectS.GetProjectbyID(id);
	}

	@Override
	public boolean CreateProject(String projectName, int managerID, int teamsize)
			throws ClassNotFoundException, SQLException {
		
		return projectS.CreateProject(projectName, managerID, teamsize);
	}

	@Override
	public boolean UpdateProject(int PjID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		
		return false;
	}

	@Override
	public Project GetProjectbyName(String PjName)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		
		return projectS.GetProjectbyName(PjName);
	}

}
