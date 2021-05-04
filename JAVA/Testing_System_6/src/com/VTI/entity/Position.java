package com.VTI.entity;

import com.VTI.ultis.ScannerUltis;

public class Position {
	private int id;
	private String name;
	private int count;
	public Position() throws Exception {
		count++;
		this.id = count;
		this.name = inputname();
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	private String inputname() throws Exception {
		try {
			System.out.println("Mời nhập vào tên");
			String addname = ScannerUltis.inputString();
			return addname;
		} catch (Exception e) {
			throw new Exception("Mời nhập vào tên");
		}
	}
}
