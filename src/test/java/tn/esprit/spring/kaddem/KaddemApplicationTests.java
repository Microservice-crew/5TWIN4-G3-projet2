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
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;
import tn.esprit.spring.kaddem.services.IEquipeService;

import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertSame;



@ContextConfiguration(classes = {EquipeServiceImpl.class})
@ExtendWith(MockitoExtension.class)

public class KaddemApplicationTests {
    @MockBean
    private EquipeRepository equipeRepository;

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Autowired
    IEquipeService equi;
@Test
public void testRetreiveAllEquipes(){

    List<Equipe> actualRetreiveAllEquipesResult = this.equipeService.retrieveAllEquipes();
    Assertions.assertEquals(0, actualRetreiveAllEquipesResult.size());

}
    @Test
    void testAddEquipes() {
        Equipe equipee = new Equipe();
        equipee.setIdEquipe(1);
        equipee.setNomEquipe("first");
        when(equipeRepository.save(any())).thenReturn(equipee);

        Equipe equipe1 = new Equipe();
        equipe1.setIdEquipe(1);
        equipe1.setNomEquipe("first");
        assertSame(equipee, equipeService.addEquipe(equipe1));
        verify(equipeRepository).save(any());
    }

    @Test
    void testDeleteEquipe() {
        equipeRepository.deleteById(1);
        verify(equipeRepository).deleteById(1);
    }
    @Test
    void testUpdateEquipe() {
        Equipe equipe = new Equipe();
        equipe.setIdEquipe(1);
        equipe.setNomEquipe("Nom");
        when(equipeRepository.save(any())).thenReturn(equipe);

        Equipe equipe1 = new Equipe();
        equipe1.setIdEquipe(1);
        equipe1.setNomEquipe("Nom");
        assertSame(equipe, equipeService.updateEquipe(equipe1));
        verify(equipeRepository).save((Equipe) any());
    }


    @Test
    void testRetrieveEquipe() {
        Equipe equipe = new Equipe();
        equipe.setIdEquipe(55);
        equipe.setNomEquipe("Nom");

        Optional<Equipe> ofResult = Optional.of(equipe);

        when(equipeRepository.findById(anyInt())).thenReturn(ofResult);

        Equipe retrievedEquipe = equipeService.retrieveEquipe(1);

        verify(equipeRepository).findById(1);

        assertSame(equipe, retrievedEquipe);
    }





}
