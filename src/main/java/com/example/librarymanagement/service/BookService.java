package com.example.librarymanagement.service;


import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.exception.AllReadyExists;
import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public ResponseEntity<Book> addBook(
            Book book)  {

        // Book book = new Book(title, author, isbn, publisher, publishedDate);
     if(bookRepository.findByIsbn(book.getIsbn()).isPresent()){
         System.out.println("Book already exists");
throw new AllReadyExists("Book already exists");
     }else{
        bookRepository.save(book);
        System.out.println("Book added successfully");
        return ResponseEntity.status(HttpStatus.OK).body(book);
     
    }

}
@Cacheable("books")
    public ResponseEntity< List<Book> > getBooks() {
        if (bookRepository.findAll().isEmpty()) {
            System.out.println("No books found");
           throw new ResourceNotFoundException("No books found");
        } else {
            System.out.println("Books");
            return ResponseEntity.status(HttpStatus.OK).body(bookRepository.findAll());
        }
    }

    public Book getBookById(Long id) {
     

        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            System.out.println("Book not found");
            throw new ResourceNotFoundException("Book not found");
        } else {
            System.out.println("Book found");
            return book;
        }
    }

    public void updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setPublisher(book.getPublisher());
            existingBook.setPublishedDate(book.getPublishedDate());
            bookRepository.save(existingBook);
        }else{
            System.out.println("Book not found");
            throw new ResourceNotFoundException("Book not found");
        }
    }

    public void deleteBook(Long id) {
       
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            bookRepository.delete(book);
            System.out.println("Book deleted successfully");
        } else {
            System.out.println("Book not found");
            throw new ResourceNotFoundException("Book not found");
        }
    }

}
