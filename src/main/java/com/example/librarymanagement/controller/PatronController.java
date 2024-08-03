package com.example.librarymanagement.controller;

import java.util.List;

import com.example.librarymanagement.repository.PatronRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.model.Patron;
import com.example.librarymanagement.service.PatronService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PatronController {
private final  PatronService patronService;
    private final PatronRepository patronRepository;

    @RequestMapping("/login")
    public Patron login(Authentication authentication) {
        List<Patron> patrons = patronRepository.findByEmail(authentication.getName());
        if(patrons.size() > 0) {
            return patrons.get(0);
        }else {
            return null;
        }
    }

//    @RequestMapping("/register")
//    public void register(@RequestBody Patron patron) {
//        patronService.addPatron(patron);
//    }

    @PostMapping("/patrons")
    public void addPatron(
        @RequestBody Patron patron
    ) {
        patronService.addPatron(patron);
    }

    @GetMapping("/patrons")
    public List<Patron> getPatrons1() {
      return  patronService.getPatrons();
    }

    @PutMapping("/patrons/{id}")
    public void updatePatron(
        @RequestBody Patron patron,
        @PathVariable("id") Long id
    ) {
        patronService.updatePatron(
            id,
         patron
        );
    }

    @GetMapping("/patrons/{id}")
    public Patron getPatronById(
        @PathVariable("id") Long id
    ) {
      return  patronService.getPatron(id);
    }

    @DeleteMapping("/patrons/{id}")
    public void deletePatron(
        @PathVariable("id") Long id
    ) {
        patronService.deletePatron(id);
    }

}
