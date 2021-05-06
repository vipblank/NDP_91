package com.VTI.entity;

public class HinhChuNhat extends HinhHoc{

	public HinhChuNhat(Float a, Float b) throws HinhHoc_Exception {
		super(a, b);
		
	}

	@Override
	public Float tinhchuvi(Float a, Float b) {
		
		return (a + b) * 2;
	}

	@Override
	public Float tinhdientich(Float a, Float b) {
		
		return (a * b);
	}
	
}
