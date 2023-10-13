package tn.esprit.spring.kaddem;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;
import tn.esprit.spring.kaddem.services.IDepartementService;

import java.util.List;
import java.util.Optional;


@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class KaddemApplicationTests {
    @Mock
    private DepartementRepository departementRepository;

    @InjectMocks
    private DepartementServiceImpl departementService;

    @Autowired
    IDepartementService dep;
@Test
@Order(1)
public void testRetreiveAllDepartements(){
    List<Departement>listDepartements=dep.retrieveAllDepartements();
    Assertions.assertEquals(2,listDepartements.size());

    Departement departement = new Departement();
    departement.setNomDepart("Sample Departement");

    Mockito.when(departementRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(departement));

    Departement retrievedDepartement = departementService.retrieveDepartement(51);

    Assertions.assertNotNull(retrievedDepartement);
    Assertions.assertEquals("Sample Departement", retrievedDepartement.getNomDepart());


}
}
