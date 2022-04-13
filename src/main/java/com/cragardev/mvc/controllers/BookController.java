package com.cragardev.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cragardev.mvc.models.Book;
import com.cragardev.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public String books() {
		
		
		return "index.jsp";
	}
	
	@GetMapping("/show/{bookId}")
	public String show(Model model, @PathVariable("bookId") long bookId) {
		Book book = bookService.findBook(bookId);
//		System.out.println(book.getTitle());
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
}
