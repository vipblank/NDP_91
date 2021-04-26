package com.VTI.entity;

import java.time.LocalDate;

public class Bao extends Tailieu{
	private LocalDate ngayphathanh;

	public Bao(int matailieu, String nhaxuatban, int sobanphathanh, LocalDate ngayphathanh) {
		super(matailieu, nhaxuatban, sobanphathanh);
		this.ngayphathanh = ngayphathanh;
	}

	public LocalDate getNgayphathanh() {
		return ngayphathanh;
	}

	public void setNgayphathanh(LocalDate ngayphathanh) {
		this.ngayphathanh = ngayphathanh;
	}

	@Override
	public String toString() {
		return super.toString() +  "Bao [ngayphathanh=" + ngayphathanh + "]";
	}
	
}
