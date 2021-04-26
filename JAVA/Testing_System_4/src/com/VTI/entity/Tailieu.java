package com.VTI.entity;

public abstract class Tailieu {
	private int matailieu;
	private String nhaxuatban;
	private int sobanphathanh;
	public int getMatailieu() {
		return matailieu;
	}
	public void setMatailieu(int matailieu) {
		this.matailieu = matailieu;
	}
	public String getNhaxuatban() {
		return nhaxuatban;
	}
	public void setNhaxuatban(String nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}
	public int getSobanphathanh() {
		return sobanphathanh;
	}
	public void setSobanphathanh(int sobanphathanh) {
		this.sobanphathanh = sobanphathanh;
	}
	public Tailieu(int matailieu, String nhaxuatban, int sobanphathanh) {
		super();
		this.matailieu = matailieu;
		this.nhaxuatban = nhaxuatban;
		this.sobanphathanh = sobanphathanh;
	}
	@Override
	public String toString() {
		return "Tailieu [matailieu=" + matailieu + ", nhaxuatban=" + nhaxuatban + ", sobanphathanh=" + sobanphathanh
				+ "]";
	}
	
}
