package com.VTI.entity;

public class ProjectTeam {
	private Project project;
	private Manager manager;
	private Employee employee;
	private Manager manager1;
	private Employee employee1;
	
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
	
	public String getManager1() {
		return manager1.getFullname();
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	public void setManager1 (Manager manager1) {
		this.manager1 = manager1;
	}

	public int getEmployee() {
		return employee.getId();
	}
	
	public String getEmployee1() {
		return employee1.getFullname();
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	@Override
	public String toString() {
		return "ProjectTeam [project=" + project + ", manager=" + manager + ", employee=" + employee + "]";
	}
	
}
