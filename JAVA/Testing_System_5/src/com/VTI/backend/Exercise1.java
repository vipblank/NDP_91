package com.VTI.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.VTI.entity.News;

public class Exercise1 {
	public Scanner sc;	
	public News vnNews;
	public static int count = 0;
	public void question1() {
		sc = new Scanner(System.in);
		vnNews = new News();
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("================ 1: Insert news ========================");
			System.out.println("================ 2: View list news =====================");
			System.out.println("================ 3: Average rate =======================");
			System.out.println("================ 4: Exit ===============================");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				Insertnews();
				break;
			case 2:
				Viewlistnews();
				break;
			case 3:
				Averagerate();
				break;
			case 4:
	
				return;
			default:
				System.out.println("Mời chọn chức năng");
				break;
			}
		}
	}
	public void Insertnews() {
		System.out.println("Mời bạn nhập vào title");
		String addtitle = sc.next();
		System.out.println("Mời bạn nhập vào ngày xuất bản");
		int addday = sc.nextInt();
		System.out.println("Mời bạn nhập vào tháng xuất bản");
		int addmonth = sc.nextInt();
		System.out.println("Mời bạn nhập vào năm xuất bản");
		int addyear = sc.nextInt();
		LocalDate publishDate1 = LocalDate.of(addyear, addmonth, addday);
		System.out.println("Mời bạn nhập vào author");
		String addauthor = sc.next();
		System.out.println("Mời bạn nhập vào content");
		String addcontent = sc.next();
		System.out.println("Mời bạn nhập vào đánh giá 1");
		int addrate1 = sc.nextInt();
		System.out.println("Mời bạn nhập vào đánh giá 2");
		int addrate2 = sc.nextInt();
		System.out.println("Mời bạn nhập vào đánh giá 3");
		int addrate3 = sc.nextInt();
		int[] rates = {addrate1, addrate2, addrate3};
		count++;
		vnNews.Insert(count, addtitle, publishDate1, addauthor, addcontent, rates);
		
	}
	public void Viewlistnews() {
		vnNews.Display();
	}
	public void Averagerate() {
		System.out.println("Mời nhập vào id");
		int id1 = sc.nextInt();
		vnNews.Caculate(id1);
	}
	public void question2() {
//		Check file TuyenSinh - entity
	}
}
