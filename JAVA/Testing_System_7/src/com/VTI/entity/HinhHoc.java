package com.VTI.entity;

public abstract class HinhHoc {
	private Float a;
	private Float b;
	private static int count;
	
	
	public abstract Float tinhchuvi(Float a, Float b);
	
	public abstract Float tinhdientich(Float a, Float b);
	
	public HinhHoc(Float a, Float b) throws HinhHoc_Exception {
		super();
		count++;
		if (count <= Config.SO_LUONG_HINH_TOI_DA) {
			this.a = a;
			this.b = b;
		}else {
			throw new HinhHoc_Exception();
		}
	}
}	
