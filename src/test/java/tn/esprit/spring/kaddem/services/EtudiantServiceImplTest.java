package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class EtudiantServiceImplTest {
    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Mock
    private EtudiantRepository etudiantRepository;

    // Initialize the mocks
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void testAddEtudiant() {
        // Create a sample Etudiant
        Etudiant sampleEtudiant = new Etudiant();
        // Set up behavior for the mock repository
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(sampleEtudiant);

        // Call the service method
        Etudiant savedEtudiant = etudiantService.addEtudiant(sampleEtudiant);

        // Verify that the save method of the repository was called
        verify(etudiantRepository, times(1)).save(any(Etudiant.class));

        // Check if the returned Etudiant matches the one saved
        assertEquals(sampleEtudiant, savedEtudiant);
    }

    @Test
    @Order(2)
    public void testRetrieveEtudiant() {
        // Create a sample Etudiant ID
        Integer etudiantId = 1;
        // Create a sample Etudiant
        Etudiant sampleEtudiant = new Etudiant();
        // Set up behavior for the mock repository
        when(etudiantRepository.findById(etudiantId)).thenReturn(Optional.of(sampleEtudiant));

        // Call the service method
        Etudiant retrievedEtudiant = etudiantService.retrieveEtudiant(etudiantId);

        // Verify that the repository's findById method was called
        verify(etudiantRepository, times(1)).findById(etudiantId);

        // Check if the returned Etudiant matches the sample Etudiant
        assertEquals(sampleEtudiant, retrievedEtudiant);
    }

    // Add more test methods for other service methods

    @Test
    @Order(3)
    public void testUpdateEtudiant() {
        // Create a sample Etudiant
        Etudiant sampleEtudiant = new Etudiant();
        // Set up behavior for the mock repository
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(sampleEtudiant);

        // Call the service method
        Etudiant savedEtudiant = etudiantService.updateEtudiant(sampleEtudiant);

        // Verify that the save method of the repository was called
        verify(etudiantRepository, times(1)).save(any(Etudiant.class));

        // Check if the returned Etudiant matches the one saved
        assertEquals(sampleEtudiant, savedEtudiant);
    }

    @Test
    @Order(4)
    public void testRemoveEtudiant() {
        // Create a sample Etudiant ID
        Integer etudiantId = 1;
        // Create a sample Etudiant
        Etudiant sampleEtudiant = new Etudiant();
        // Set up behavior for the mock repository
        when(etudiantRepository.findById(etudiantId)).thenReturn(Optional.of(sampleEtudiant));

        // Call the service method
        etudiantService.removeEtudiant(etudiantId);

        // Verify that the repository's findById method was called
        verify(etudiantRepository, times(1)).findById(etudiantId);
        // Verify that the repository's delete method was called
        verify(etudiantRepository, times(1)).delete(sampleEtudiant);
    }
}
