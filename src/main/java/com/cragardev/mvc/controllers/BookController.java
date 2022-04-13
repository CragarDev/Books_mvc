package com.cragardev.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cragardev.mvc.models.Book;
import com.cragardev.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	// Home page showing all the books
	@GetMapping("/books")
	public String books(Model model) {
		
		List<Book> books = bookService.allBooks();
//		
		model.addAttribute("books", books);
		
		return "index.jsp";
	}
	
	// page showing just one book by id
	@GetMapping("/show/{bookId}")
	public String show(Model model, @PathVariable("bookId") long bookId) {
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	
	
	// page for creating a new book
	@GetMapping("/books/new")
	public String booksNew() {
		

		return "newBook.jsp";
	}
	
	// page for creating a new book
	@PostMapping("/books/new/process")
	public String booksNewProcess(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
        System.out.println(book);
        bookService.createBook(book);
        
		return "redirect:/books";
	}
	
	// page for updating a book
	@GetMapping("/books/update/{bookId}")
	public String booksUpdate(Model model, @PathVariable(value="bookId") long bookId) {
		
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book", book);	
		
		return "updateBook.jsp";
	}
	
	// page for creating a new book
	@PostMapping("/books/update/process/{bookId}")
	public String booksUpdateProcess(
			@PathVariable(value="bookId") long bookId,
			@RequestParam(value="title") String title, 
			@RequestParam(value="description") String desc, 
			@RequestParam(value="language") String lang, 
			@RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		System.out.println(book);
		bookService.updateBook(bookId, title, desc, lang, numOfPages);
		
		return "redirect:/books";
	}
	
//	@RequestMapping(value="/books/delete/{bookId}", method=RequestMethod.DELETE)
//    public void destroy(@PathVariable("id") Long bookId) {
//        bookService.deleteBook(bookId);
//       
//    }
	
	
}
