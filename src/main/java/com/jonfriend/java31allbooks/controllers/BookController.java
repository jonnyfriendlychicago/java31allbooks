package com.jonfriend.java31allbooks.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonfriend.java31allbooks.models.Book;
import com.jonfriend.java31allbooks.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookservice; 
	
	@RequestMapping("/books/{bookId}") 
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
//		System.out.println("bookId: " + bookId); 
		
		Book book = bookservice.findBook(bookId); 
		
//		System.out.println("book: " + book); 
		
		List<Book> bookListy = bookservice.allBooks(); 
		
		
		model.addAttribute("book", book); 
		model.addAttribute("bookListy", bookListy); 
		
		
		return "index.jsp"; 
	}

}
