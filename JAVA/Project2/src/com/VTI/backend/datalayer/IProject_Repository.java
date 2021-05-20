package com.VTI.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.Project;

public interface IProject_Repository {

	public List<Project> GetManagerAtProject1() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public List<Project> GetListProject() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public Project GetProjectbyID(int id) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
	public boolean CreateProject(String projectName, int managerID, int teamsize) throws ClassNotFoundException, SQLException;
	
	public boolean UpdateProject(int PjID) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException;
	
	public Project GetProjectbyName(String PjName) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException;
	
}
