package com.cragardev.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.cragardev.mvc.models.Book;
import com.cragardev.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	// ------------------------------------------ Home/Show All Books ----------------------------------
	// Home page showing all the books
	@GetMapping("/books")
	public String books(Model model) {
		
		List<Book> books = bookService.allBooks();
		
		model.addAttribute("books", books);
		
		return "index.jsp";
	}
	
	// ------------------------------------------ Show One Book ----------------------------------
	
	// page showing just one book by id
	@GetMapping("/show/{bookId}")
	public String show(Model model, @PathVariable("bookId") long bookId) {
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
	// ------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ----------------------------------
	
	
	// ------------------------------------------ Create New Book Original ----------------------------------
	// my original way for creating a new book
	// page for creating a new book
	@GetMapping("/books/new")
	public String booksNew() {
		

		return "newBook.jsp";
	}
	
	// processing for creating a new book
	@PostMapping("/books/new/process")
	public String booksNewProcess(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
//        System.out.println(book);
        bookService.createBook(book);
        
		return "redirect:/books";
	}
	
	// ------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ----------------------------------
	
	
	
	
	// ------------------------------------------ Create New Book new Method ----------------------------------
	// New method of getting the data for creating a new book
	// page for creating a new book
	@GetMapping("/books/newToo")
	public String booksNewToo(@ModelAttribute("book") Book book) {
		
		
		return "newBookToo.jsp";
	}
	
	// processing for creating a new book
	@PostMapping("/books/newToo/process")
	public String booksNewTooProcess(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		
		if (result.hasErrors()) {
            return "newBookToo.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
	}
	
	// ------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ----------------------------------
	

	
	// ------------------------------------------ Updating Book Old method ----------------------------------
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
		bookService.updateBook(bookId, title, desc, lang, numOfPages);
		
		return "redirect:/books";
	}
	
	// ------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ----------------------------------
	
	
	
	
	// ------------------------------------------ Updating Book NEW METHOD ----------------------------------
	// page for updating a book
	@GetMapping("/books/updateToo/{bookId}")
	public String booksUpdateToo(Model model, @PathVariable(value="bookId") long bookId) {
		
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book", book);	
		
		return "updateBookToo.jsp";
	}
	
	
	// page for creating a new book
	@PostMapping("/books/updateToo/process/{bookId}")
	public String booksUpdateTooProcess(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("bookId") long bookId) {
//		
		if (result.hasErrors()) {
            return "updateBookToo.jsp";
        } else {
            
            bookService.updateBook(bookId, book.getTitle(), book.getDescription(), book.getLanguage(), book.getNumberOfPages());
            return "redirect:/books";
        }
	}
	
	
	// ------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ----------------------------------
	
	
	// ------------------------------------------ Delete Book ----------------------------------
	
	@RequestMapping(value="/books/delete/{bookId}")
	public String destroy(@PathVariable("bookId") Long bookId) {
		bookService.deleteBook(bookId);
		
		return "redirect:/books";
	}
	
	// ------------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ----------------------------------
}

