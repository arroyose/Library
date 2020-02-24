package com.arroyoe.library.dao;

import java.util.List;

import com.arroyoe.library.model.Book;

public interface BookDao{
	
	public List<Book> list();
	
	public Book get(int id);
	
	public void update(Book book);
	public void add(Book book);
	
	public void delete(int id);
}
