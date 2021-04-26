package com.VTI.entity;

import java.time.LocalDate;

public class Tapchi extends Tailieu{
	private int sophathanh;
	private LocalDate ngayphathanh;
	
	public Tapchi(int matailieu, String nhaxuatban, int sobanphathanh, int sophathanh, LocalDate ngayphathanh) {
		super(matailieu, nhaxuatban, sobanphathanh);
		this.sophathanh = sophathanh;
		this.ngayphathanh = ngayphathanh;
	}

	public int getSophathanh() {
		return sophathanh;
	}

	public void setSophathanh(int sophathanh) {
		this.sophathanh = sophathanh;
	}

	public LocalDate getNgayphathanh() {
		return ngayphathanh;
	}

	public void setNgayphathanh(LocalDate ngayphathanh) {
		this.ngayphathanh = ngayphathanh;
	}

	@Override
	public String toString() {
		return super.toString() + "Tapchi [sophathanh=" + sophathanh + ", ngayphathanh=" + ngayphathanh + "]";
	}
	
}
