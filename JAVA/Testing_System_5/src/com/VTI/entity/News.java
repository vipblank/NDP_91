package com.VTI.entity;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class News implements INews{
	private int id;
	private String title;
	private LocalDate publishDate;
	private String author;
	private String content;
	private float averageRate;
	private int rate1;
	private int rate2;
	private int rate3;
	
	@Override
	public void Display() {
		System.out.println("thông tin title: " + title);
		System.out.println("thông tin publishDate:" + publishDate);
		System.out.println("thông tin author: " + author);
		System.out.println("thông tin content:" + content);
		System.out.println("thông tin của averageRate: " + averageRate);
	}
	@Override
	public float Calculate() {
		 News rateArray = new News(rate1, rate2, rate3);
		 
		return 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getAverageRate() {
		return averageRate;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", author=" + author
				+ ", content=" + content + ", averageRate=" + averageRate + "]";
	}
	public News(int id, String title, LocalDate publishDate, String author, String content) {
		super();
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
	}
	public News(int rate12, int rate22, int rate32) {
		// TODO Auto-generated constructor stub
	}

	
}
