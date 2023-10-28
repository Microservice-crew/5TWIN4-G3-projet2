package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.repositories.ContratRepository;

import java.util.*;


@ExtendWith(MockitoExtension.class)
class ContratServiceMockTests {

    @InjectMocks
    ContratServiceImpl contratService;

    ContratRepository contratRepository = Mockito.mock(ContratRepository.class);


    Contrat contrat;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setDateDebutContrat(new Date());
        contrat.setDateFinContrat(new Date());
    }

    @Test
    void retrieveContrat() {
        Mockito.when(contratRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(contrat));
        Contrat retrievedContrat = contratService.retrieveContrat(1);
        Assertions.assertNotNull(retrievedContrat);
    }

    @Test
    void retrieveAllContrats() {
        List<Contrat> contratList = Collections.singletonList(contrat);
        Mockito.when(contratRepository.findAll()).thenReturn(contratList);
        List<Contrat> allContrats = contratService.retrieveAllContrats();
        Assertions.assertEquals(1, allContrats.size());
    }

    @Test
    void updateContrat() {
        Mockito.when(contratRepository.save(contrat)).thenReturn(contrat);
        Contrat updatedContrat = contratService.updateContrat(contrat);
        Assertions.assertNotNull(updatedContrat);
    }

    @Test
    void addContrat() {
        Mockito.when(contratRepository.save(contrat)).thenReturn(contrat);
        Contrat addedContrat = contratService.addContrat(contrat);
        Assertions.assertNotNull(addedContrat);
    }

    @Test
    void deleteContrat() {
        Integer contratId = 1;

        Mockito.when(contratRepository.findById(contratId)).thenReturn(Optional.of(contrat));
        Mockito.doNothing().when(contratRepository).delete(contrat);

        contratService.removeContrat(contratId);
    }





    @Test
    void nbContratsValides() {
        Date startDate = new Date();
        Date endDate = new Date();
        Mockito.when(contratRepository.getnbContratsValides(startDate, endDate)).thenReturn(5);
        int count = contratService.nbContratsValides(startDate, endDate);
        Assertions.assertEquals(5, count);
    }




    @Test
    void getChiffreAffaireEntreDeuxDates() {
        Date startDate = new Date();
        Date endDate = new Date();
        List<Contrat> contrats = Collections.singletonList(contrat);
        Mockito.when(contratRepository.findAll()).thenReturn(contrats);
        float chiffreAffaire = contratService.getChiffreAffaireEntreDeuxDates(startDate, endDate);
        Assertions.assertEquals(0, chiffreAffaire);
    }
}
