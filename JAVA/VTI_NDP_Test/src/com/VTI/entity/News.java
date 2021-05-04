package com.VTI.entity;

public class News implements INews{
	private static int count;
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;
	public int getId() {
		return id;
	}
	
	
	public News(String title, String publishDate, String author, String content) {
		count++;
		this.id = count;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
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
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", author=" + author
				+ ", content=" + content + "]";
	}
	@Override
	public void display() {
		
		
	}
	@Override
	public float calculate() {
		
		return 0;
	}
	
	
}
