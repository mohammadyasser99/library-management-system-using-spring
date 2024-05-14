package com.example.librarymanagement.service;

import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.BorrowingRecord;
import com.example.librarymanagement.model.Patron;
import com.example.librarymanagement.repository.BookRepository;
import com.example.librarymanagement.repository.BorrowingRecordRepository;
import com.example.librarymanagement.repository.PatronRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowingService {
private final BorrowingRecordRepository borrowingRecordRepository;  
private final BookRepository bookRepository;
private final PatronRepository patronRepository;
    @Transactional
    public void borrowBook(Long bookId, Long patronId) {
         Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        Patron patron = patronRepository.findById(patronId).orElseThrow(() -> new ResourceNotFoundException("Patron not found"));      
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowingDate(new Date(System.currentTimeMillis()));
        borrowingRecordRepository.save(borrowingRecord);
    }
    @Transactional
    public void returnBook(Long bookId, Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId)
                .orElseThrow(() -> new RuntimeException("Borrowing record not found"));
        borrowingRecord.setReturnDate(new Date(System.currentTimeMillis()));
        borrowingRecordRepository.save(borrowingRecord);
    }

}
