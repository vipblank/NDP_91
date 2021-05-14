package com.VTI.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.datalayer.Department_Repository;
import com.VTI.entity.Department;

public class Department_Service implements IDepartment_Service{
	private Department_Repository departmentRepository;
	
	public Department_Service() throws FileNotFoundException, IOException {
		departmentRepository = new Department_Repository();
	}
	@Override
	public List<Department> getlistDepartments() throws ClassNotFoundException, SQLException {
		
		return departmentRepository.getlistDepartments();
	}

	@Override
	public Department getDepByID(int id) throws ClassNotFoundException, SQLException {
		
		return departmentRepository.getDepByID(id);
	}

	@Override
	public boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		
		return departmentRepository.isDepartmentNameExists(name);
	}

	@Override
	public boolean createDepartment(String name) throws ClassNotFoundException, SQLException {
		
		return departmentRepository.createDepartment(name);
	}

	@Override
	public boolean updateDepartmentName(int id, String newname) throws ClassNotFoundException, SQLException {
		
		return departmentRepository.updateDepartmentName(id, newname);
	}

	@Override
	public boolean deleteDepartment(int id) throws ClassNotFoundException, SQLException {
		
		return departmentRepository.deleteDepartment(id);
	}
	
}
