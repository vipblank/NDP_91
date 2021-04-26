package com.VTI.entity;

public abstract class Canbo {
	private String hoten;
	private int tuoi;
	private Gioitinh gioitinh;
	private String diachi;
	public enum Gioitinh {
		NAM, NU, KHAC
	}
	@Override
	public String toString() {
		return "Canbo [hoten=" + hoten + ", tuoi=" + tuoi + ", gioitinh=" + gioitinh + ", diachi=" + diachi + "]";
	}
	public Canbo(String hoten, int tuoi, Gioitinh gioitinh, String diachi) {
		super();
		this.hoten = hoten;
		this.tuoi = tuoi;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	
}
