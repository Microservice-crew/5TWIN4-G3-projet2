package tn.esprit.spring.kaddem.services;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.repositories.ContratRepository;


import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertSame;



@SpringBootTest
@ContextConfiguration(classes = {ContratServiceImpl.class})
@ExtendWith(MockitoExtension.class)

public class KaddemApplicationTests {
    @MockBean
    private ContratRepository contratRepository;

    @InjectMocks
    private ContratServiceImpl contratService;

    @Autowired
   IContratService contratService1;
    @Test
    public void testRetreiveAllContrats(){

        List<Contrat> list = contratService1.retrieveAllContrats();
        Assertions.assertEquals(0, list.size());

    }
    @Test
    void testAddContrat() {
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setDateDebutContrat(null);
        contrat.setDateFinContrat(null);
        contrat.setSpecialite(null);
        contrat.setArchive(null);
        contrat.setMontantContrat(1);
        when(contratRepository.save(any())).thenReturn(contrat);
        Contrat actualAddContactResult = contratService.addContrat(new Contrat());
        assertSame(contrat, actualAddContactResult);
        verify(contratRepository).save((Contrat) any());
    }

    @Test
    void testDeleteContrat() {
        contratService.removeContrat(1);
        verify(contratRepository).deleteById((Integer) any());
    }
    @Test
    void testUpdateContrat() {
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setDateDebutContrat(null);
        contrat.setDateFinContrat(null);
        contrat.setSpecialite(null);
        contrat.setArchive(null);
        contrat.setMontantContrat(1);
        when(contratRepository.save(any())).thenReturn(contrat);
        Contrat actualUpdateContactResult = contratService.updateContrat(new Contrat());
        assertSame(contrat, actualUpdateContactResult);
        verify(contratRepository).save((Contrat) any());
    }


    @Test
    void testRetrieveContrat() {
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setDateDebutContrat(null);
        contrat.setDateFinContrat(null);
        contrat.setSpecialite(null);
        contrat.setArchive(null);
        contrat.setMontantContrat(1);
        when(contratRepository.findById((Integer) any())).thenReturn(Optional.<Contrat>of(contrat));
        Contrat actualRetrieveContactResult = contratService.retrieveContrat(1);
        assertSame(contrat, actualRetrieveContactResult);
        verify(contratRepository).findById((Integer) any());
    }





}