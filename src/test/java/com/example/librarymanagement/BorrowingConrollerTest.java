package com.example.librarymanagement;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.librarymanagement.controller.BorrowingController;
import com.example.librarymanagement.service.BorrowingService;
@ExtendWith(MockitoExtension.class)
public class BorrowingConrollerTest {

       @Mock
    private BorrowingService borrowingService;

    @InjectMocks
    private BorrowingController borrowingController;

    @Test
   public void testBorrowBook() {
        // Arrange
        Long bookId = 1L;
        Long patronId = 1L;

        // Act
        borrowingController.postMethodName(bookId, patronId);

        // Assert
        verify(borrowingService).borrowBook(bookId, patronId);
    }

    @Test
    public void testReturnBook() {
        // Arrange
        Long bookId = 1L;
        Long patronId = 1L;

        // Act
        borrowingController.putMethodName(bookId, patronId);

        // Assert
        verify(borrowingService).returnBook(bookId, patronId);
    }


}
