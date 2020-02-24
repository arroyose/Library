package com.arroyoe.library.services;

import java.util.List;

import com.arroyoe.library.model.Book;

public interface BookService {
	public List<Book> list();
	
	public Book get(int id_book);
	
	public void update(Book book);
	public void add(Book book);
	
	public void delete(int id_book);
}
