package com.VTI.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.Department;

public interface IDepartment_Service {
	
	public List<Department> getlistDepartments() throws ClassNotFoundException, SQLException;
	
	public Department getDepByID(int id) throws ClassNotFoundException, SQLException;
	
	public boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException;
	
	public boolean createDepartment (String name) throws ClassNotFoundException, SQLException;
	
	public boolean updateDepartmentName(int id, String newname) throws ClassNotFoundException, SQLException;
	
	public boolean deleteDepartment(int id) throws ClassNotFoundException, SQLException;
}
