package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EquipeServiceImplTest {

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Mock
    private EquipeRepository equipeRepository;

    // Initialize the mocks
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Order(1)
    public void testAddEquipe() {
        // Create a sample Equipe
        Equipe sampleEquipe = new Equipe();
        // Set up behavior for the mock repository
        when(equipeRepository.save(any(Equipe.class))).thenReturn(sampleEquipe);

        // Call the service method
        Equipe savedEquipe = equipeService.addEquipe(sampleEquipe);

        // Verify that the save method of the repository was called
        verify(equipeRepository, times(1)).save(any(Equipe.class));

        // Check if the returned Equipe matches the one saved
        assertEquals(sampleEquipe, savedEquipe);
    }

    @Test
    @Order(2)
    public void testRetrieveEquipe() {
        // Create a sample Equipe ID
        Integer equipeId = 1;
        // Create a sample Equipe
        Equipe sampleEquipe = new Equipe();
        // Set up behavior for the mock repository
        when(equipeRepository.findById(equipeId)).thenReturn(Optional.of(sampleEquipe));

        // Call the service method
        Equipe retrievedEquipe = equipeService.retrieveEquipe(equipeId);

        // Verify that the repository's findById method was called
        verify(equipeRepository, times(1)).findById(equipeId);

        // Check if the returned Equipe matches the sample Equipe
        assertEquals(sampleEquipe, retrievedEquipe);
    }

    // Add more test methods for other service methods

    @Test
    @Order(3)
    public void testUpdateEquipe() {
        // Create a sample Equipe
        Equipe sampleEquipe = new Equipe();
        // Set up behavior for the mock repository
        when(equipeRepository.save(any(Equipe.class))).thenReturn(sampleEquipe);

        // Call the service method
        Equipe savedEquipe = equipeService.updateEquipe(sampleEquipe);

        // Verify that the save method of the repository was called
        verify(equipeRepository, times(1)).save(any(Equipe.class));

        // Check if the returned Equipe matches the one saved
        assertEquals(sampleEquipe, savedEquipe);
    }

    @Test
    @Order(4)
    public void testRemoveEquipe() {
        // Create a sample Equipe ID
        Integer equipeId = 1;
        // Create a sample Equipe
        Equipe sampleEquipe = new Equipe();
        // Set up behavior for the mock repository
        when(equipeRepository.findById(equipeId)).thenReturn(Optional.of(sampleEquipe));

        // Call the service method
        equipeService.deleteEquipe(equipeId);

        // Verify that the repository's findById method was called
        verify(equipeRepository, times(1)).findById(equipeId);
        // Verify that the repository's delete method was called
        verify(equipeRepository, times(1)).delete(sampleEquipe);
    }


}
