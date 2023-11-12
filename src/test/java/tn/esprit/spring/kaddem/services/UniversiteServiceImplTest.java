// UniversiteServiceImplTest

package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;


import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UniversiteServiceImplTest {

    @InjectMocks
    private UniversiteServiceImpl universiteService;

    @Mock
    private UniversiteRepository universiteRepository;




    // Initialize the mocks
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUniversite() {
        // Create a sample Universite
        Universite sampleUniversite = new Universite();
        // Set up behavior for the mock repository
        when(universiteRepository.save(any(Universite.class))).thenReturn(sampleUniversite);

        // Call the service method
        Universite savedUniversite = universiteService.addUniversite(sampleUniversite);

        // Verify that the save method of the repository was called
        verify(universiteRepository, times(1)).save(any(Universite.class));

        // Check if the returned Universite matches the one saved
        assertEquals(sampleUniversite, savedUniversite);
    }

    @Test
    public void testRetrieveUniversite() {
        // Create a sample Universite ID
        Integer universiteId = 1;
        // Create a sample Universite
        Universite sampleUniversite = new Universite();
        // Set up behavior for the mock repository
        when(universiteRepository.findById(universiteId)).thenReturn(Optional.of(sampleUniversite));

        // Call the service method
        Universite retrievedUniversite = universiteService.retrieveUniversite(universiteId);

        // Verify that the repository's findById method was called
        verify(universiteRepository, times(1)).findById(universiteId);

        // Check if the returned Universite matches the sample Universite
        assertEquals(sampleUniversite, retrievedUniversite);
    }

    // Add more test methods for other service methods

    @Test
    public void testDeleteUniversite() {
        // Create a sample Universite ID
        Integer universiteId = 1;
        // Create a sample Universite
        Universite sampleUniversite = new Universite();
        when(universiteRepository.findById(universiteId)).thenReturn(Optional.of(sampleUniversite));

        // Call the service method
        universiteService.deleteUniversite(universiteId);

        // Verify that the repository's delete method was called
        verify(universiteRepository, times(1)).delete(sampleUniversite);
    }




}
