package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.repositories.ContratRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContratServiceImplTest {

    @InjectMocks
    private ContratServiceImpl contratService;

    @Mock
    private ContratRepository contratRepository;

    // Initialize the mocks
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
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
    @Order(2)
    public void testRetrieveContrat() {
        // Create a sample Contrat ID
        Integer contratId = 1;
        // Create a sample Contrat
        Contrat sampleContrat = new Contrat();
        // Set up behavior for the mock repository
        when(contratRepository.findById(contratId)).thenReturn(Optional.of(sampleContrat));

        // Call the service method
        Contrat retrievedContrat = contratService.retrieveContrat(contratId);

        // Verify that the repository's findById method was called
        verify(contratRepository, times(1)).findById(contratId);

        // Check if the returned Contrat matches the sample Contrat
        assertEquals(sampleContrat, retrievedContrat);
    }

    // Add more test methods for other service methods

    @Test
    @Order(3)
    public void testUpdateContrat() {
        // Create a sample Contrat
        Contrat sampleContrat = new Contrat();
        // Set up behavior for the mock repository
        when(contratRepository.save(any(Contrat.class))).thenReturn(sampleContrat);

        // Call the service method
        Contrat savedContrat = contratService.updateContrat(sampleContrat);

        // Verify that the save method of the repository was called
        verify(contratRepository, times(1)).save(any(Contrat.class));

        // Check if the returned Contrat matches the one saved
        assertEquals(sampleContrat, savedContrat);
    }

    @Test
    @Order(4)
    public void testRemoveContrat() {
        // Create a sample Contrat ID
        Integer contratId = 1;
        // Create a sample Contrat
        Contrat sampleContrat = new Contrat();
        // Set up behavior for the mock repository
        when(contratRepository.findById(contratId)).thenReturn(Optional.of(sampleContrat));

        // Call the service method
        contratService.removeContrat(contratId);

        // Verify that the repository's findById method was called
        verify(contratRepository, times(1)).findById(contratId);
        // Verify that the repository's delete method was called
        verify(contratRepository, times(1)).delete(sampleContrat);
    }


}
