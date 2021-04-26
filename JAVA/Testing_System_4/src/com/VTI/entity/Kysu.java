package com.VTI.entity;

public class Kysu extends Canbo {
	private String chuyennganh;
	
	public Kysu(String hoten, int tuoi, Gioitinh gioitinh, String diachi, String chuyennganh) {
		super(hoten, tuoi, gioitinh, diachi);
		this.chuyennganh = chuyennganh;
	}

	@Override
	public String toString() {
		return super.toString() +  "Kysu [chuyennganh=" + chuyennganh + "]";
	}
	
}
