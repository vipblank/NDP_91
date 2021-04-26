package com.VTI.entity;

public class Nhanvien extends Canbo {
	private String congviec;

	public Nhanvien(String hoten, int tuoi, Gioitinh gioitinh, String diachi, String congviec) {
		super(hoten, tuoi, gioitinh, diachi);
		this.congviec = congviec;
	}

	@Override
	public String toString() {
		return super.toString() + "Nhanvien [congviec=" + congviec + "]";
	}

}
