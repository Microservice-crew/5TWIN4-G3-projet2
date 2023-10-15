package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ContratServicesImpMock {

    @Mock
    private ContratRepository contratRepository;
    @InjectMocks
    private ContratServiceImpl contratService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContrat() {
        // Create a sample Contrat
        Contrat sampleContrat = new Contrat();
        // Set up behavior for the mock repository
        when(contratRepository.save(any(Contrat.class))).thenReturn(sampleContrat);

        // Call the service method
        Contrat savedContrat = contratService.addContrat(sampleContrat);

        // Verify that the save method of the repository was called
        verify(contratRepository, times(1)).save(any(Contrat.class));

        // Check if the returned Contrat matches the one saved
        assertEquals(sampleContrat, savedContrat);
    }

    @Test
    public void testRetrieveContrat() {
        // Create a sample Contrat ID
        Integer contratId = 1;
        // Create a sample Contrat
        Contrat sampleContrat = new Contrat();
        // Set up behavior for the mock repository
        when(contratRepository.findById(contratId)).thenReturn(Optional.of(sampleContrat));

        // Call the service method
        Contrat retrievedContrat = contratService.retrieveContrat(contratId);

        // Verify that the find method of the repository was called
        verify(contratRepository, times(1)).findById(contratId);

        // Check if the returned Contrat matches the one from the repository
        assertEquals(sampleContrat, retrievedContrat);
    }

    @Test
    public void testUpdateContrat() {
        // Create a sample Contrat
        Contrat sampleContrat = new Contrat();
        // Set up behavior for the mock repository
        when(contratRepository.save(any(Contrat.class))).thenReturn(sampleContrat);

        // Call the service method
        Contrat updatedContrat = contratService.updateContrat(sampleContrat);

        // Verify that the save method of the repository was called
        verify(contratRepository, times(1)).save(any(Contrat.class));

        // Check if the returned Contrat matches the one saved
        assertEquals(sampleContrat, updatedContrat);
    }

    @Test
    public void testRemoveContrat() {
        // Create a sample Contrat ID
        Integer contratId = 1;
        // Create a sample Contrat
        Contrat sampleContrat = new Contrat();
        // Set up behavior for the mock repository
        when(contratRepository.findById(contratId)).thenReturn(Optional.of(sampleContrat));

        // Call the service method
        contratService.removeContrat(contratId);

        // Verify that the delete method of the repository was called
        verify(contratRepository, times(1)).delete(sampleContrat);
    }





}
