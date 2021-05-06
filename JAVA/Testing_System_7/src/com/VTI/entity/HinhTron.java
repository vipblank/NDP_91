package com.VTI.entity;

public class HinhTron extends HinhHoc{

	public HinhTron(Float a, Float b) throws HinhHoc_Exception {
		super(a, b);
		
	}

	@Override
	public Float tinhchuvi(Float a, Float b) {
		
		return 2 * a *(Config.Pi);
	}

	@Override
	public Float tinhdientich(Float a, Float b) {
		
		return (float) (Config.Pi * (Math.pow(a, 2)));
	}
	
}
