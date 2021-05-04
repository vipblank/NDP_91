package com.VTI.entity;

import java.time.LocalDate;

public interface INews {
	
	  void Insert(int id, String title, LocalDate publishDate, String author, String content, int[]rate); 
	  
	  void Display();
	
	  void Caculate(int id);  
	  
}
