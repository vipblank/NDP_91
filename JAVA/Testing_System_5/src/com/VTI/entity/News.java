package com.VTI.entity;

public class News implements INews{
	int id;
	String title;
	String 	publishDate;
	String author;
	String content;
	float averageRate;
	public News(int id, String title, String publishDate, String author, String content, float averageRate) {
		super();
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		this.averageRate = averageRate;
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
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
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
	public void Display() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public float Calculate() {
		// TODO Auto-generated method stub
		return 0;
	}

}
