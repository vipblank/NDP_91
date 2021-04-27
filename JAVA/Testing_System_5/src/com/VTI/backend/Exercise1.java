package com.VTI.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.VTI.entity.News;

public class Exercise1 {
	private Scanner sc;	
	private ArrayList<News> listNews;
	public static int count;
	public void question1() {
		sc = new Scanner(System.in);
		listNews = new ArrayList<News>();
		while (true) {
			System.out.println("========================================================");
			System.out.println("================ Lựa Chọn Chức Năng ====================");
			System.out.println("================ 1: Insert news ========================");
			System.out.println("================ 2: View list news =====================");
			System.out.println("================ 3: Average rate =======================");
			System.out.println("================ 4: Exit ===============================");
			System.out.println("================ 5: Thoát khỏi chương trình=============");
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
		System.out.println("Mời bạn nhập vào đánh giá thứ 1");
		int addrate1 = sc.nextInt();
		System.out.println("Mời bạn nhập vào đánh giá thứ 2");
		int addrate2 = sc.nextInt();
		System.out.println("Mời bạn nhập vào đánh giá thứ 3");
		int addrate3 = sc.nextInt();
		count++;
		System.out.println("Mời bạn nhập vào content");
		News news = new News(count, addtitle, publishDate1, addauthor, addcontent);
		listNews.add(news);
	}
	public void Viewlistnews() {
		
	}
	public void Averagerate() {
		
	}
}
