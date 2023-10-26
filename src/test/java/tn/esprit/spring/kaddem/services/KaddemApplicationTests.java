package tn.esprit.spring.kaddem.services;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertSame;




@ContextConfiguration(classes = {ContratServiceImpl.class})
@ExtendWith(MockitoExtension.class)

public class KaddemApplicationTests {
    @Mock
    private ContratRepository contratRepository;

    @InjectMocks
    private ContratServiceImpl contratService;


     // Initialize the mocks
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRetrieveAllContrats() {
        List<Contrat> mockContats = new ArrayList<>();
        mockContats.add(new Contrat(1, new Date(2023, 10, 21), new Date(2023, 10, 21), Specialite.IA, false, 1));
        mockContats.add(new Contrat(2, new Date(2023, 10, 21), new Date(2023, 10, 21), Specialite.IA, false, 1));
        when(contratRepository.findAll()).thenReturn(mockContats);
        List<Contrat> result = contratService.retrieveAllContrats();
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(mockContats, result);
    }

  //  @Test
 /*   void testAddContrat() {
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setDateDebutContrat(new Date(2023, 10, 21));
        contrat.setDateFinContrat(new Date(2023, 10, 21));
        contrat.setSpecialite(Specialite.IA);
        contrat.setArchive(false);
        contrat.setMontantContrat(1);
        when(contratRepository.save(
                (Contrat) any())
        ).thenReturn(contrat);
        Contrat actualAddContactResult = contratService.addContrat(new Contrat());
        assertSame(contrat, actualAddContactResult);
        verify(contratRepository).save((Contrat) any());
    }*/



  /*  @Test
    void testUpdateContrat() {
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setDateDebutContrat(new Date(2023, 10, 21));
        contrat.setDateFinContrat(new Date(2023, 10, 21));
        contrat.setSpecialite(Specialite.IA);
        contrat.setArchive(false);
        contrat.setMontantContrat(1);
        when(contratRepository.save(
                (Contrat) any())
        ).thenReturn(contrat);
        Contrat actualUpdateContactResult = contratService.updateContrat(new Contrat());
        assertSame(contrat, actualUpdateContactResult);
        verify(contratRepository).save((Contrat) any());
    }


    @Test
    void testRetrieveContrat() {
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setDateDebutContrat(new Date(2023, 10, 21));
        contrat.setDateFinContrat(new Date(2023, 10, 21));
        contrat.setSpecialite(Specialite.IA);
        contrat.setArchive(false);
        contrat.setMontantContrat(1);
        when(contratRepository.findById((Integer) any())).thenReturn(Optional.<Contrat>of(contrat));
        Contrat actualRetrieveContactResult = contratService.retrieveContrat(1);
        assertSame(contrat, actualRetrieveContactResult);
        verify(contratRepository).findById((Integer) any());
    }*/





}