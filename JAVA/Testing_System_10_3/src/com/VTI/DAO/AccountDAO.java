package com.VTI.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.VTI.ultis.jdbcUltis;

public class AccountDAO {
	private static jdbcUltis jdbc;
	public AccountDAO() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
	
}
