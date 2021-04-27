package com.VTI.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class News implements INews{
	private int id;
	private String title; 
	private LocalDate publishDate;
	private String author;
	private String content;
	private float averageRate;;
	public ArrayList<News> listNews;
	public News() {
		listNews = new ArrayList<News>();	
	}
	@Override
	public void Insert(int id, String title, LocalDate publishDate, String author, String content) {
		News news = new News(id, title, publishDate, author, content);
		listNews.add(news);	
		
	}
	@Override
	public void Display() {
		for (News news : listNews) {
			System.out.println(news);
		}		
	}
	@Override
	public float Caculate(int id) {
		for (News news : listNews) {
			if (news.getId() == id) {
				float averageRate = 0;
				int[] rate = {5,10,15};
				averageRate += (rate[0] + rate[1] + rate[2])/3;
			}
		}	
		return  averageRate;
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
		return averageRate ;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", author=" + author
				+ ", content=" + content + "]";
	}
	public News(int id, String title, LocalDate publishDate, String author, String content) {
		super();
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
	}

}
