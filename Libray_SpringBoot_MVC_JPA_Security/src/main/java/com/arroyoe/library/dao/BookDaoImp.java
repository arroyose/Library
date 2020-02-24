package com.arroyoe.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.arroyoe.library.model.Book;

@Repository
public class BookDaoImp implements BookDao {
	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	public BookDaoImp() {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Book> list() {
		String hql = "FROM Book ORDER BY id_book ASC";
		return (List<Book>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Book get(int id_book) {
		return entityManager.find(Book.class, id_book);
	}

	@Override
	@Transactional
	public void update(Book book) {
		
		Book book_update = get(book.getId_book());

		book_update.setName(book.getName());
		book_update.setAuthor(book.getAuthor());
		book_update.setIsbn(book.getIsbn());

		entityManager.flush();
		
	}

	@Override
	@Transactional
	public void add(Book book) {
		entityManager.merge(book);
	}

	@Override
	@Transactional
	public void delete(int id_book) {
		entityManager.remove(get(id_book));
		
	}
}
