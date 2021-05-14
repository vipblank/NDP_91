package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.businesslayer.Department_Service;
import com.VTI.backend.businesslayer.IDepartment_Service;
import com.VTI.entity.Department;

public class Department_Controller implements IDepartment_Service{
	private IDepartment_Service departmentService;
	
	public Department_Controller() throws FileNotFoundException, IOException {
		departmentService = new Department_Service();
	}

	@Override
	public List<Department> getlistDepartments() throws ClassNotFoundException, SQLException {
		
		return departmentService.getlistDepartments();
	}

	@Override
	public Department getDepByID(int id) throws ClassNotFoundException, SQLException {
		
		return departmentService.getDepByID(id);
	}

	@Override
	public boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		
		return departmentService.isDepartmentNameExists(name);
	}

	@Override
	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException {
		return departmentService.createDepartment(name);
			
	}

	@Override
	public boolean updateDepartmentName(int id, String newname) throws ClassNotFoundException, SQLException {
		return departmentService.updateDepartmentName(id, newname);
			
	}

	@Override
	public boolean deleteDepartment(int id) throws ClassNotFoundException, SQLException {
		
		return departmentService.deleteDepartment(id);
	}
	
}
