package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.repositories.ContratRepository;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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
        Contrat sampleContrat = new Contrat();
        sampleContrat.setIdContrat(1);
        sampleContrat.setMontantContrat(1000);
        sampleContrat.setArchive(true);
        sampleContrat.setDateDebutContrat(null);
        sampleContrat.setDateFinContrat(null);
        sampleContrat.setSpecialite(null);

        // Set up behavior for the mock repository
        when(contratRepository.save(any(Contrat.class))).thenReturn(sampleContrat);


    }

    @Test
    @Order(2)
    public void testRetrieveAllContrats(){

        List<Contrat> actualRetrieveAllContratResult = this.contratService.retrieveAllContrats();
        Assertions.assertEquals(0, actualRetrieveAllContratResult.size());

    }

    // Add more test methods for other service methods



}
