package tn.esprit.spring.kaddem;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;
import tn.esprit.spring.kaddem.services.IEtudiantService;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
@ContextConfiguration(classes = {EtudiantServiceImpl.class})
@ExtendWith(MockitoExtension.class)
public class KaddemApplicationTests {
    @MockBean
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Autowired
    IEtudiantService etudiant;

    @Test
    void testRetrieveAllEtudiants() {
        List<Etudiant> actualRetrieveAllEtudiantsResult = this.etudiantService.retrieveAllEtudiants();
        Assertions.assertEquals(0, actualRetrieveAllEtudiantsResult.size());
    }

    @Test
    void testAddEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setIdEtudiant(1);
        etudiant.setNomE("John Doe");
        etudiant.setPrenomE("Doe");
        etudiant.setOp(Option.GAMIX);

        when(etudiantRepository.save(any())).thenReturn(etudiant);

        Etudiant etudiant1 = new Etudiant();
        etudiant1.setIdEtudiant(1);
        etudiant1.setNomE("John Doe");
        etudiant1.setPrenomE("Doe");
        etudiant1.setOp(Option.GAMIX);

        assertSame(etudiant, etudiantService.addEtudiant(etudiant1));
        verify(etudiantRepository).save(any());
    }

    @Test
    void testDeleteEtudiant() {
        etudiantRepository.deleteById(1);
        verify(etudiantRepository).deleteById(1);
    }

    @Test
    void testUpdateEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setIdEtudiant(1);
        etudiant.setNomE("Nom");
        etudiant.setPrenomE("Prenom");
        etudiant.setOp(Option.SIM);

        when(etudiantRepository.save(any())).thenReturn(etudiant);

        Etudiant etudiant1 = new Etudiant();
        etudiant1.setIdEtudiant(1);
        etudiant1.setNomE("Nom");
        etudiant1.setPrenomE("Prenom");
        etudiant1.setOp(Option.SIM);

        assertSame(etudiant, etudiantService.updateEtudiant(etudiant1));
        verify(etudiantRepository).save(any());
    }

    @Test
    void testRetrieveEtudiant() {
        Etudiant etudiant = new Etudiant();
        etudiant.setIdEtudiant(1);
        etudiant.setNomE("John Doe");
        etudiant.setPrenomE("Doe");
        etudiant.setOp(Option.GAMIX);

        Optional<Etudiant> ofResult = Optional.of(etudiant);

        when(etudiantRepository.findById(anyInt())).thenReturn(ofResult);

        Etudiant retrievedEtudiant = etudiantService.retrieveEtudiant(1);

        verify(etudiantRepository).findById(1);

        assertSame(etudiant, retrievedEtudiant);
    }
}
