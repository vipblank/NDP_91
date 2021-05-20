package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.datalayer.Project_Repository;
import com.VTI.entity.Project;

public class Project_Service implements IProject_Service {
	private Project_Repository project;

	public Project_Service() throws FileNotFoundException, IOException {
		project = new Project_Repository();
	}

	@Override
	public List<Project> GetManagerAtProject1()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		return project.GetManagerAtProject1();
	}

	@Override
	public List<Project> GetListProject()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		return project.GetListProject();
	}

	@Override
	public Project GetProjectbyID(int id)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		return project.GetProjectbyID(id);
	}

	@Override
	public boolean CreateProject(String projectName, int managerID, int teamsize)
			throws ClassNotFoundException, SQLException {
		if (project.checkPjName(projectName)) {
			System.err.println("ProjectName đã tồn tại");
			return false;
		}
		return project.CreateProject(projectName, managerID, teamsize);

	}

	@Override
	public boolean UpdateProject(int PjID)
			throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

		return false;
	}

	@Override
	public Project GetProjectbyName(String PjName)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

		return project.GetProjectbyName(PjName);
	}

}
