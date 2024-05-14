package com.example.librarymanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.librarymanagement.controller.PatronController;
import com.example.librarymanagement.exception.ResourceNotFoundException;
import com.example.librarymanagement.model.Patron;
import com.example.librarymanagement.service.PatronService;

@ExtendWith(MockitoExtension.class)
public class PatronsControllerTest {

    @Mock
    private PatronService patronService;

    @InjectMocks
    private PatronController patronsController;

// Test for getPatrons method
@Test
    void testGetPatrons() {
        // Arrange
        List<Patron> patrons = new ArrayList<>();
        patrons.add(new Patron("John Doe", "john@example.com", 123456789, "Address 1"));
        patrons.add(new Patron("Jane Smith", "jane@example.com", 987654321, "Address 2"));
        when(patronService.getPatrons()).thenReturn(patrons);

        // Act
        List<Patron> result = patronsController.getPatrons1();

        // Assert
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("john@example.com", result.get(0).getEmail());
        assertEquals(123456789, result.get(0).getPhoneNumber());
        assertEquals("Address 1", result.get(0).getContactInfo());
        assertEquals("Jane Smith", result.get(1).getName());
        assertEquals("jane@example.com", result.get(1).getEmail());
        assertEquals(987654321, result.get(1).getPhoneNumber());
        assertEquals("Address 2", result.get(1).getContactInfo());
    }

    // Test for getPatronById method
    @Test
    public void testGetPatronById() {
        // Arrange
        Patron patron = new Patron("John Doe", "john@example.com", 123456789, "Address 1");
        when(patronService.getPatron(1L)).thenReturn(patron);

        // Act
        Patron result = patronsController.getPatronById(1L);

        // Assert
        assertEquals("John Doe", result.getName());

       
    } 

    // Test for addPatron method
    @Test
    public void testAddPatron() {
        // Arrange
     
     
        Patron patron = new Patron("John Doe", "john@example.com", 123456789, "Address 1");


        // Act
        patronsController.addPatron(patron);

        // Assert
        // No exception is thrown



    }

    // Test for updatePatron method
    @Test
   public void testUpdatePatron_NotFound() {
        // Arrange
        Long id = 1L;
        Patron patronToUpdate = new Patron("Updated Name", "updated@example.com", 987654321, "Updated Address");
        doThrow(ResourceNotFoundException.class).when(patronService).updatePatron(id, patronToUpdate);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            patronsController.updatePatron(patronToUpdate, id);
        });
    }
}

