package org.iut.douala.gestion.cours.GestionCours.restServices;

import java.util.List;
import java.util.Optional;

import org.iut.douala.gestion.cours.GestionCours.dao.EnseignantRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.Enseignant;
import org.iut.douala.gestion.cours.GestionCours.entities.Etudiants;
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
public class EnseignantRestServive
{
	@Autowired
	private EnseignantRepository enseignantRepository;
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value="/enseignants", method=RequestMethod.POST)
	public Enseignant saveEnseignant(@RequestBody Enseignant enseignant)
	{
		return accountService.saveEnseignant(enseignant);
	}
	
	@RequestMapping(value="/enseignants", method=RequestMethod.GET)
	public List<Enseignant> getListEnseignant()
	{
		return enseignantRepository.findAll();
	}
	
	@RequestMapping(value="/enseignants/{idCour}", method=RequestMethod.GET)
	public String findEmailOfEnseignant(@PathVariable int idCour)
	{
		return enseignantRepository.findEmailOfEnseignantByIdCour(idCour);
	}
	
	@RequestMapping(value="/enseignant/{matricule}", method=RequestMethod.GET)
	public Enseignant getOneEnseignant(@PathVariable String matricule)
	{
		return accountService.findEnseignantByMatricule(matricule);
	}
	
	@RequestMapping(value="/enseignants/{matricule}", method=RequestMethod.PUT)
	public Enseignant updateMatiere(@PathVariable String matricule, @RequestBody Enseignant enseignant)
	{
		Enseignant enseignantFind = accountService.findEnseignantByMatricule(matricule);
		enseignant.setMatriculeEns(enseignantFind.getMatriculeEns());
		enseignantFind = enseignant;
		return enseignantRepository.save(enseignantFind);
	}


}
