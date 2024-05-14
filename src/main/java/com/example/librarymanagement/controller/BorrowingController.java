package com.example.librarymanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.service.BorrowingService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BorrowingController {
    private final BorrowingService borrowingService;
    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public void postMethodName(@PathVariable("bookId") Long bookId ,
    @PathVariable("patronId") Long patronId) {
 
        borrowingService.borrowBook(bookId, patronId);
        System.out.println("Book borrowed successfully");
        
      
    }

    @PutMapping("/borrow/{bookId}/patron/{patronId}")
    public String putMethodName(
        @PathVariable("bookId") Long bookId,
        @PathVariable("patronId") Long patronId
    ) {
        borrowingService.returnBook(bookId, patronId);
        return "Book returned successfully";
    }
   
    

}
