package org.iut.douala.gestion.cours.GestionCours.restServices;

import java.util.List;
import java.util.Optional;

import org.iut.douala.gestion.cours.GestionCours.dao.EtudiantRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.Etudiants;
import org.iut.douala.gestion.cours.GestionCours.entities.EtudiantsEmail;
import org.iut.douala.gestion.cours.GestionCours.entities.Matiere;
import org.iut.douala.gestion.cours.GestionCours.metier.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EtudiantRestService 
{
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/etudiants", method = RequestMethod.POST)
	public Etudiants saveEtudiant(@RequestBody Etudiants etud)
	{
		
		return accountService.saveEtudiant(etud);
	}
	
	@RequestMapping(value ="/etudiants", method = RequestMethod.GET)
	public List<Etudiants> getAllEtudiant()
	{
		return etudiantRepository.findAll();
	}
	
	@RequestMapping(value ="/etudiant/{matricule}", method = RequestMethod.GET)
	public Etudiants getOneEtudiant(@PathVariable String matricule)
	{
		return accountService.findEtudiantByMatricule(matricule);
	}
	
	@RequestMapping(value ="/etudiants/{idCour}", method = RequestMethod.GET)
	public List<EtudiantsEmail> getAllEtudiantsEmailByIdCour(@PathVariable int idCour)
	{
		return etudiantRepository.findEmailOfEtudiantsByIdCour(idCour);
	}
	
	@RequestMapping(value="/etudiants/{matricule}", method=RequestMethod.PUT)
	public Etudiants updateMatiere(@PathVariable String matricule, @RequestBody Etudiants etudiant)
	{
		Etudiants etudiantFind = etudiantRepository.findById(matricule).orElse(null);
		etudiant.setMatriculeEtud(etudiantFind.getMatriculeEtud());
		etudiantFind = etudiant;
		return etudiantRepository.save(etudiantFind);
	}
	
}
