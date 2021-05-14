package com.VTI.backend;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.VTI.ultis.jdbcUltis;

public class Exercise2 {
	private static jdbcUltis jdbc;
	public Exercise2() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
	}
}
