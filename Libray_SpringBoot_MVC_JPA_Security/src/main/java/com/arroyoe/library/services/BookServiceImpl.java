package com.arroyoe.library.services;
import com.arroyoe.library.dao.BookDao;
import com.arroyoe.library.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> list() {
		return bookDao.list();
	}

	@Override
	public Book get(int id_book) {
		return bookDao.get(id_book);
	}

	@Override
	public void update(Book book) {
		bookDao.update(book);
		
	}

	@Override
	public void add(Book book) {
		bookDao.add(book);
		
	}

	@Override
	public void delete(int id_book) {
		bookDao.delete(id_book);
		
	}
	
	
	
}
