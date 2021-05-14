package com.VTI.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.VTI.entity.Position;

public interface IPosition_Service {
	public List<Position> getlistPositions() throws ClassNotFoundException, SQLException;
	
	public Position getPosByID(int id) throws ClassNotFoundException, SQLException;
	
	public boolean isPositionNameExists(String name) throws ClassNotFoundException, SQLException;
	
	public boolean createPosition (String name) throws ClassNotFoundException, SQLException;
	
	public boolean updatePosition(int id, String newname) throws ClassNotFoundException, SQLException;
	
	public boolean deletePosition(int id) throws ClassNotFoundException, SQLException;
	
}
