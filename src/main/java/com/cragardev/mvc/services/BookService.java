package com.cragardev.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cragardev.mvc.models.Book;
import com.cragardev.mvc.repositories.BookRepository;

@Service
public class BookService {
	
	
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // updates a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	// Check if book exists
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
//    		System.out.println("optionalBook--service " + optionalBook);
    		// get the book to work with
    		Book thisBook = optionalBook.get();
//    		System.out.println("optionalBook--service " + thisBook);
//    		System.out.println("optionalBook.getTitle--service " + thisBook.getTitle());
    		
    		// set the changes to the book
    		thisBook.setTitle(title);
    		thisBook.setDescription(desc);
    		thisBook.setLanguage(lang);
    		thisBook.setNumberOfPages(numOfPages);
    		
//    		System.out.println("optionalBook.getTitle--service-after update " + thisBook.getTitle());
    		// save the changes
    		return bookRepository.save(thisBook);
//    		return this.createBook(thisBook);
    	} else {
    		return null;
    	}
    }
    
    // updates a book
    public Book updateBookToo(Long id, String title, String desc, String lang, Integer numOfPages) {
    	// Check if book exists
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
//    		System.out.println("optionalBook--service " + optionalBook);
    		// get the book to work with
    		Book thisBook = optionalBook.get();
//    		System.out.println("optionalBook--service " + thisBook);
//    		System.out.println("optionalBook.getTitle--service " + thisBook.getTitle());
    		
    		// set the changes to the book
    		thisBook.setTitle(title);
    		thisBook.setDescription(desc);
    		thisBook.setLanguage(lang);
    		thisBook.setNumberOfPages(numOfPages);
    		
//    		System.out.println("optionalBook.getTitle--service-after update " + thisBook.getTitle());
    		// save the changes
    		return bookRepository.save(thisBook);
//    		return this.createBook(thisBook);
    	} else {
    		return null;
    	}
    }
    
    
    // Deletes a book by Id
    public Book deleteBook(Long id) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	if(optionalBook.isPresent()) {
    		bookRepository.deleteById(id);
    		return null;
    	}
		return null;
    	
    	
    }
}
