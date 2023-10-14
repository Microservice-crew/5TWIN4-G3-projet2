package tn.esprit.spring.kaddem;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;
import tn.esprit.spring.kaddem.services.IDepartementService;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertSame;



@SpringBootTest
@ContextConfiguration(classes = {DepartementServiceImpl.class})
@ExtendWith(MockitoExtension.class)

public class KaddemApplicationTests {
    @MockBean
    private DepartementRepository departementRepository;

    @InjectMocks
    private DepartementServiceImpl departementService;

    @Autowired
    IDepartementService dep;
@Test
public void testRetreiveAllDepartements(){

    List<Departement> actualRetrieveAllDepartementsResult = this.departementService.retrieveAllDepartements();
    Assertions.assertEquals(0, actualRetrieveAllDepartementsResult.size());

}
    @Test
    void testAddDepartements() {
        Departement departementt = new Departement();
        departementt.setIdDepart(1);
        departementt.setNomDepart("first");
        when(departementRepository.save(any())).thenReturn(departementt);

        Departement departement1 = new Departement();
        departement1.setIdDepart(1);
        departement1.setNomDepart("first");
        assertSame(departementt, departementService.addDepartement(departement1));
        verify(departementRepository).save(any());
    }

    @Test
    void testDeleteDepartement() {
        departementRepository.deleteById(1);
        verify(departementRepository).deleteById(1);
    }
    @Test
    void testUpdateDepartement() {
        Departement departement = new Departement();
        departement.setIdDepart(1);
        departement.setNomDepart("Nom");
        when(departementRepository.save(any())).thenReturn(departement);

        Departement departement1 = new Departement();
        departement1.setIdDepart(1);
        departement1.setNomDepart("Nom");
        assertSame(departement, departementService.updateDepartement(departement1));
        verify(departementRepository).save((Departement) any());
    }


    @Test
    void testRetrieveDepartement() {
        Departement departement = new Departement();
        departement.setIdDepart(55);
        departement.setNomDepart("Nom");

        Optional<Departement> ofResult = Optional.of(departement);

        when(departementRepository.findById(anyInt())).thenReturn(ofResult);

        Departement retrievedDepartement = departementService.retrieveDepartement(1);

        verify(departementRepository).findById(1);

        assertSame(departement, retrievedDepartement);
    }





}
