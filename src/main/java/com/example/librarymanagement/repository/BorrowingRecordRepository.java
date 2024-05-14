package com.example.librarymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.librarymanagement.model.BorrowingRecord;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long>{
    @Query("SELECT br FROM BorrowingRecord br WHERE br.book.id = :bookId AND br.patron.id = :patronId AND br.returnDate IS NULL")
    Optional<BorrowingRecord> findByBookIdAndPatronIdAndReturnDateIsNull(Long bookId, Long patronId);
    
} 
