package com.VTI.ultis;

import java.io.File;

public class FileUltis_NDP {
//	check file
	public static boolean isFileExists(String pathfile) {
		File file = new File(pathfile);
		if (file.exists()) {
			return true;
		}else {			
			return false;	
		}		
	}
//	Check folder is exists
	public static boolean isFolderExists(String pathFolder) {
		File file = new File(pathFolder);
		if (file.exists()) {
			return true;
		}else {
			return false;
		}	
	}	
//	Create file
	public static void createFile(String pathfile) throws Exception {
		if (isFileExists(pathfile)) {
			throw new Exception("file đã tồn tại");
		}
		boolean result = new File(pathfile).createNewFile();
		System.out.println("Tạo file thành công" + result);
	}	
	public static void createNewfile(String path, String fileName) throws Exception {
		String pathFile = path + "\\" + fileName;
		createFile(pathFile);
	}
//	Delete file
	public static void deleteFile(String pathfile) throws Exception {
		if (!isFileExists(pathfile)) {
			throw new Exception("file chưa tồn tại");
		}	
		boolean result = new File(pathfile).delete();
		System.out.println("Xóa file thành công");
	}
//	Check path is File or Folder
	public static void isFolderOrFile(String pathfile) {
		File file = new File(pathfile);
		if (file.isDirectory()) {
			System.out.println("Đây là 1 folder");
		}else if (file.isFile()) {
			System.out.println("Đây là 1 file");
		}else {
			System.out.println("Đây không phải folder, cũng không phải file");
		}
	}
//	Check path is Folder
	public static boolean isFolder(String pathfile) {
		File file = new File(pathfile);
		return file.isDirectory();
		
	}
//	Get all file name of folder
	public static String[] getAllFileName(String path) {
		File file = new File(path);
		if (!isFolder(path)) {
			System.out.println("Xin kiểm tra lại đường dẫn");
			return null;
		}else {
			return file.list();
		}		
	}
//	Copy File
	public static void copyFile(String sourceFile, String destinationPath) throws Exception {

	}
}
