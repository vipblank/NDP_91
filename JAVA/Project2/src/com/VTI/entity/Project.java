package com.VTI.entity;

public class Project {
	private int projectID;
	private String projectName;
	private Manager manager;
	private Manager manager1;
	private int teamSize;
	
	public Project(int projectID, String projectName, Manager manager, int teamSize) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.manager = manager;
		this.teamSize = teamSize;
	}
	public Project() {
		
	}
	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getManager() {
		return manager.getId();
	}
	
	public String getManager11() {
		return manager.getFullname();
		
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public void setManager1(Manager manager) {
		this.manager1 = manager;
	}
	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", projectName=" + projectName + ", manager=" + manager
				+ ", teamSize=" + teamSize + "]";
	}
}
