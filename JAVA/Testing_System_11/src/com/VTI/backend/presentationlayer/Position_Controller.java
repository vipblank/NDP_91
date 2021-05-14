package com.VTI.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.VTI.backend.businesslayer.IPosition_Service;
import com.VTI.backend.datalayer.Position_Repository;
import com.VTI.entity.Position;

public class Position_Controller implements IPosition_Service{
	private Position_Repository positionRepository ;
	public Position_Controller() throws FileNotFoundException, IOException {
		positionRepository = new Position_Repository();
	}

	@Override
	public List<Position> getlistPositions() throws ClassNotFoundException, SQLException {
		
		return positionRepository.getlistPositions();
	}

	@Override
	public Position getPosByID(int id) throws ClassNotFoundException, SQLException {
		
		return positionRepository.getPosByID(id);
	}

	@Override
	public boolean isPositionNameExists(String name) throws ClassNotFoundException, SQLException {
		
		return positionRepository.isPositionNameExists(name);
	}

	@Override
	public boolean createPosition(String name) throws ClassNotFoundException, SQLException {
		
		return positionRepository.createPosition(name);
	}

	@Override
	public boolean updatePosition(int id, String newname) throws ClassNotFoundException, SQLException {
		
		return positionRepository.updatePosition(id, newname);
	}

	@Override
	public boolean deletePosition(int id) throws ClassNotFoundException, SQLException {
		
		return positionRepository.deletePosition(id);
	}
}
