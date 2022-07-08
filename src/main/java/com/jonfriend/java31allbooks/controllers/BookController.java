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
	
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> bookListy = bookservice.allBooks(); 
		model.addAttribute("bookListy", bookListy);

//		List<Book> books = bookservice.allBooks();
//	    model.addAttribute("books", books);
//		model.addAttribute("book", book); 
		
		return "booklist.jsp";
	}


	@RequestMapping("/books/{bookId}") 
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
		Book book = bookservice.findBook(bookId); 
		model.addAttribute("book", book);  
		 
		
//		List<Book> bookListy = bookservice.allBooks(); 
//		model.addAttribute("bookListy", bookListy); 
		
		return "bookprofile.jsp"; 
	}


	
// end of methods
}
