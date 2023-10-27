package tn.esprit.spring.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import java.util.*;

@Slf4j
@AllArgsConstructor
@Service
public class EquipeServiceImpl implements IEquipeService{
	EquipeRepository equipeRepository;


	public List<Equipe> retrieveAllEquipes(){
	return  (List<Equipe>) equipeRepository.findAll();
	}
	public Equipe addEquipe(Equipe e){
		return (equipeRepository.save(e));
	}

	public  void deleteEquipe(Integer idEquipe){
		Equipe e=retrieveEquipe(idEquipe);
		equipeRepository.delete(e);
	}

	public Equipe retrieveEquipe(Integer equipeId) {
		Optional<Equipe> equipeOptional = equipeRepository.findById(equipeId);

        return equipeOptional.orElse(null);
	}


	public Equipe updateEquipe(Equipe e){
	return (	equipeRepository.save(e));
	}

	public void evoluerEquipes() {
		List<Equipe> equipes = (List<Equipe>) equipeRepository.findAll();

		for (Equipe equipe : equipes) {
			if (equipe.getNiveau().equals(Niveau.JUNIOR) || equipe.getNiveau().equals(Niveau.SENIOR)) {
				List<Etudiant> etudiants = new ArrayList<>(equipe.getEtudiants());
				int nbEtudiantsAvecContratsActifs = 0;

				for (Etudiant etudiant : etudiants) {
					Set<Contrat> contrats = etudiant.getContrats();

					for (Contrat contrat : contrats) {
						Date dateSysteme = new Date();
						long differenceEnTemps = dateSysteme.getTime() - contrat.getDateFinContrat().getTime();
						long differenceEnAnnees = (differenceEnTemps / (1000L * 60 * 60 * 24 * 365));

						if (contrat.getArchive() == false && differenceEnAnnees > 1) {
							nbEtudiantsAvecContratsActifs++;
							if (nbEtudiantsAvecContratsActifs >= 3) {
								break;
							}
						}
					}
				}

				if (nbEtudiantsAvecContratsActifs >= 3) {
					if (equipe.getNiveau().equals(Niveau.JUNIOR)) {
						equipe.setNiveau(Niveau.SENIOR);
					} else if (equipe.getNiveau().equals(Niveau.SENIOR)) {
						equipe.setNiveau(Niveau.EXPERT);
					}
					equipeRepository.save(equipe);
				}
			}
		}
	}

}