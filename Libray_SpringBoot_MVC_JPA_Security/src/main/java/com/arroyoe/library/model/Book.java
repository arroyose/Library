package com.arroyoe.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name = "id_book")
	private int id_book;
	
	@Column(name = "name")
	private String name;
	@Column(name = "author")
	private String author;
	@Column(name = "isbn")
	private String isbn;
	
	
	public int getId_book() {
		return id_book;
	}
	
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String autor) {
		this.author = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id_book=" + id_book + ", name=" + name + ", author=" + author + ", isbn=" + isbn + "]";
	}
	
	
	
	
	
	
}
