package com.VTI.frontend;

import java.io.File;

import com.VTI.ultis.FileUltis;
import com.VTI.ultis.ScannerUltis;

public class Main_code2 {
	public static void main(String[] args) {
//		System.out.println("Xử lý file: ");
//		System.out.println("Nhập vào đường dẫn file: ");
//		String pathname = ScannerUltis.inputString();
//		
//		if (FileUltis.isFileExists(pathname) == true) {
//			System.out.println("file đã tồn tại");
//		}else {
//			System.out.println("file chưa tồn tại");
//		}
		System.out.println("check folder có tồn tại hay không");
		System.out.println("Nhập vào đường dẫn folder");
		String pathFoder = ScannerUltis.inputString();
		if (FileUltis.isFolder(pathFoder) == true) {
			System.out.println("folder đã tồn tại");
		}else {
			System.out.println("folder chưa tồn tại");
		}
	}
}
