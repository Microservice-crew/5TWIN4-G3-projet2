package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class EquipeServicesImpMock {

    @Mock
    private EquipeRepository equipeRepository;
    @InjectMocks
    private EquipeServiceImpl equipeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
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
    public void testRetrieveEquipe() {
        // Create a sample Equipe ID
        Integer equipeId = 1;
        // Create a sample Equipe
        Equipe sampleEquipe = new Equipe();
        // Set up behavior for the mock repository
        when(equipeRepository.findById(equipeId)).thenReturn(Optional.of(sampleEquipe));

        // Call the service method
        Equipe retrievedEquipe = equipeService.retrieveEquipe(equipeId);

        // Verify that the find method of the repository was called
        verify(equipeRepository, times(1)).findById(equipeId);

        // Check if the returned Equipe matches the one from the repository
        assertEquals(sampleEquipe, retrievedEquipe);
    }

    @Test
    public void testUpdateEquipe() {
        // Create a sample Equipe
        Equipe sampleEquipe = new Equipe();
        // Set up behavior for the mock repository
        when(equipeRepository.save(any(Equipe.class))).thenReturn(sampleEquipe);

        // Call the service method
        Equipe updatedContrat = equipeService.updateEquipe(sampleEquipe);

        // Verify that the save method of the repository was called
        verify(equipeRepository, times(1)).save(any(Equipe.class));

        // Check if the returned Equipe matches the one saved
        assertEquals(sampleEquipe, updatedContrat);
    }

    @Test
    public void testRemoveEquipe() {
        // Create a sample Equipe ID
        Integer equipeId = 1;
        // Create a sample Equipe
        Equipe sampleEquipe = new Equipe();
        // Set up behavior for the mock repository
        when(equipeRepository.findById(equipeId)).thenReturn(Optional.of(sampleEquipe));

        // Call the service method
        equipeService.deleteEquipe(equipeId);

        // Verify that the delete method of the repository was called
        verify(equipeRepository, times(1)).delete(sampleEquipe);
    }





}
