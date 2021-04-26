package com.VTI.entity;

public class Congnhan extends Canbo {
	private int bac;

	public Congnhan(String hoten, int tuoi, Gioitinh gioitinh, String diachi, int bac) {
		super(hoten, tuoi, gioitinh, diachi);
		this.bac = bac;
	}


	@Override
	public String toString() {
		return super.toString() +  "Congnhan [bac=" + bac + "]";
	}
	
}
