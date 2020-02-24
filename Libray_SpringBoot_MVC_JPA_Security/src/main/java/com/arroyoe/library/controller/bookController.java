package com.arroyoe.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arroyoe.library.model.Book;
import com.arroyoe.library.services.BookService;

@Controller
public class bookController {
	
	@Autowired
	private BookService bookService;
	
	private static final Logger logger = LoggerFactory.getLogger(bookController.class);

	@RequestMapping("/index")
	public ModelAndView handleRequest() throws Exception {
		logger.info("-- en Listado");
		List<Book> listbook = bookService.list();
		ModelAndView model = new ModelAndView("index");
		model.addObject("bookList", listbook);
		//Book book = new Book();
		//model.addObject("newBook",book);
		return model;
	}	
	@RequestMapping("/adminIndex")
	public ModelAndView adminIndex() throws Exception {
		logger.info("-- en Listado");
		List<Book> listbook = bookService.list();
		ModelAndView model = new ModelAndView("adminIndex");
		model.addObject("bookList", listbook);
		Book book = new Book();
		model.addObject("newBook",book);
		return model;
	}	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request) {
		logger.info("-- en DELETE");
		int bookId = Integer.parseInt(request.getParameter("id"));
		bookService.delete(bookId);
		return new ModelAndView("redirect:/adminIndex");		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateBook(HttpServletRequest request) {
		logger.info("-- en UPDATE");
		ModelAndView model = new ModelAndView("update");
		int bookId = Integer.parseInt(request.getParameter("id"));
		System.out.println("El libro es IDENTIFICADOR :" + bookId);
		Book book = new Book();
		book=bookService.get(bookId);
		System.out.println("El libro es:" + book);
		model.addObject("bookToUpdate",book);
		return model;
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.GET)
	public ModelAndView saveBook(HttpServletRequest request) {
		logger.info("-- en GUARDANDO DATOS");
		System.out.println(request.getParameter("author"));
		
		Book book_update = new Book();
		book_update.setAuthor(request.getParameter("author"));
		book_update.setName(request.getParameter("name"));
		book_update.setIsbn(request.getParameter("isbn"));
		int id= Integer.parseInt(request.getParameter("id_book"));
		System.out.println("ID ESS*****************"+id);
		book_update.setId_book(id);
		
		System.out.println("*******************************************************:" + book_update+ "Esta Guardado");
		bookService.update((Book)book_update);
		System.out.println("El libro :" + book_update+ "Esta Guardado");
		return new ModelAndView("redirect:/adminIndex");
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newBook(@ModelAttribute("newBook")Book book_add) {
		logger.info("-- en NEW");
		System.out.println("ENTRA EN ADD"+book_add );
		bookService.add((Book) book_add);
		return new ModelAndView("redirect:/adminIndex");	
	}
	/*
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView newBook(@RequestParam("id") int id) {
		logger.info("-- en DELETE");
		System.out.println("ENTRA EN Deleat Libro "+id );
		bookService.delete(id);
		return new ModelAndView("redirect:/");	
	}*/
}
