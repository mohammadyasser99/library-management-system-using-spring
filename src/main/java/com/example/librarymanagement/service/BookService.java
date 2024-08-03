package com.example.librarymanagement.service;


import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Date;
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
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;


@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public ResponseEntity<Book> addBook(String title, String author, String isbn, String publisher, Date publishedDate, MultipartFile image) throws SQLException, IOException {
        if (bookRepository.findByIsbn(isbn).isPresent()) {
            System.out.println("Book already exists");
            throw new AllReadyExists("Book already exists");
        } else {

            if (!image.isEmpty()){
                byte[] photoBytes = image.getBytes();
                Blob photoBlob = new SerialBlob(photoBytes);
                Book book = new Book(title, author, isbn, publisher, publishedDate, photoBlob);

                bookRepository.save(book);
                System.out.println("Book added successfully");
                return ResponseEntity.status(HttpStatus.CREATED).body(book);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);





        }
    }


  //  @Cacheable("books")
    public ResponseEntity< List<Book> > getBooks() {

        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            System.out.println("No books found");
            throw new ResourceNotFoundException("No books found");
        } else {
            System.out.println("Books found");
            return ResponseEntity.status(HttpStatus.OK).body(books);
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

    public ResponseEntity<?> updateBook(Long id, String title, String author, String isbn, String publisher,
                                        Date publishedDate, MultipartFile image) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        try {
            byte[] imageData = image.getBytes();
            Blob photoblob =new SerialBlob(imageData);
            existingBook.setTitle(title);
            existingBook.setAuthor(author);
            existingBook.setIsbn(isbn);
            existingBook.setPublisher(publisher);
            existingBook.setPublishedDate(publishedDate);
            existingBook.setPhoto(photoblob);
            bookRepository.save(existingBook);
            return ResponseEntity.status(HttpStatus.OK).body(existingBook);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update book");
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
