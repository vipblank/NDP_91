package com.VTI.entity;

public class ProjectTeam {
	private Project project;
	private Manager manager;
	private Employee employee;
	
	public ProjectTeam(Project project, Manager manager, Employee employee) {
		super();
		this.project = project;
		this.manager = manager;
		this.employee = employee;
	}
	public ProjectTeam() {
		
	}
	public int getProject() {
		return project.getProjectID();
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getManager() {
		return manager.getId();
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public int getEmployee() {
		return employee.getId();
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ProjectTeam [project=" + project + ", manager=" + manager + ", employee=" + employee + "]";
	}
	
}
