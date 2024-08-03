
package com.example.librarymanagement;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.sql.Date;

import java.util.ArrayList;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.example.librarymanagement.controller.BookController;
import com.example.librarymanagement.model.Book;

import com.example.librarymanagement.service.BookService;

import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    // getBooks endpoint test
    @Test
   public void testGetBooks() throws Exception {
        // Arrange
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("book1" , "author1", "isbn1", "publisher1", Date.valueOf("2021-01-01")));
//        books.add(new Book("book2" , "author2", "isbn2", "publisher2", Date.valueOf("2021-01-01")));
//        ResponseEntity<List<Book>> responseEntity = ResponseEntity.status(HttpStatus.OK).body(books);
//        when(bookService.getBooks()).thenReturn(responseEntity);
//
//      // Act
//      ResponseEntity<List<Book>> response = bookController.getBooks();
//
//      // Assert
//      assertEquals(HttpStatus.OK, response.getStatusCode());
//      assertEquals(2, response.getBody().size());
//      assertEquals("book1", response.getBody().get(0).getTitle());

         
    }

    // getBookById endpoint test
    @Test
    public void testGetBookById() throws Exception {
        // Arrange
//        Book book = new Book("book1" , "author1", "isbn1", "publisher1", Date.valueOf("2021-01-01"));
//        when(bookService.getBookById(1L)).thenReturn(book);
//
//        // Act
//        Book response = bookController.getBookById(1L);
//
//        // Assert
//        assertEquals("book1", response.getTitle());
//        assertEquals("author1", response.getAuthor());
//        assertEquals("isbn1", response.getIsbn());
//        assertEquals("publisher1", response.getPublisher());
//        assertEquals(Date.valueOf("2021-01-01"), response.getPublishedDate());
    }



    @Test
    void testUpdateBook() {
        // Arrange
//        Long id = 1L;
//        Book book = new Book("Updated Book" ,
//         "author1", "isbn1", "publisher1",
//         Date.valueOf("2021-01-01"));
//
//       // Act
//        bookController.updateBook(id, book);
//
//        // Assert
//        verify(bookService).updateBook(id, book);


    }

@Test
  public  void testDeleteBook() {
        // Arrange
        Long id = 1L;

        // Act
        bookController.deleteBook(id);

        // Assert
        verify(bookService).deleteBook(id);
    }


}
