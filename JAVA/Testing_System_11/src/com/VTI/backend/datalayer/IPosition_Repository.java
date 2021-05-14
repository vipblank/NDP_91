package com.VTI.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.Position;

public interface IPosition_Repository {
	public List<Position> getlistPositions() throws SQLException, ClassNotFoundException;
	
	public Position getPosByID(int id) throws ClassNotFoundException, SQLException;
	
	public boolean isPositionNameExists(String name) throws SQLException, ClassNotFoundException;
	
	public boolean createPosition (String name) throws ClassNotFoundException, SQLException;
	
	public boolean updatePosition(int id, String newname) throws SQLException, ClassNotFoundException;
	
	public boolean deletePosition(int id) throws ClassNotFoundException, SQLException;
	
}
