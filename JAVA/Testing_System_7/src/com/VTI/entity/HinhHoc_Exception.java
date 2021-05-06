package com.VTI.entity;

public class HinhHoc_Exception extends Exception {
	public HinhHoc_Exception() {
		super("Số lượng hình đã tạo vượt quá số lượng cho phép là: " + Config.SO_LUONG_HINH_TOI_DA + "hãy kiểm tra lại.");
	}
}
