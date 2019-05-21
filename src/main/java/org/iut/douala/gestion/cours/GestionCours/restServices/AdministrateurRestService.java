package org.iut.douala.gestion.cours.GestionCours.restServices;

import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.dao.AdministrateursRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.Administrateurs;
import org.iut.douala.gestion.cours.GestionCours.metier.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministrateurRestService {
	
	@Autowired
	private AdministrateursRepository administrateursRepository;
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/administrateurs", method=RequestMethod.POST)
	public Administrateurs saveAdmin( @RequestBody Administrateurs admin ) {
		return accountService.saveAdministrateur(admin);
	}
	
	@RequestMapping(value="/administrateurs", method=RequestMethod.GET)
	public List<Administrateurs> getAllAdmin() {
		return administrateursRepository.findAll();
	}
	
	@RequestMapping(value="/administrateurs/{matricule}", method=RequestMethod.GET)
	public Administrateurs getAdminByMatricule(@PathVariable String matricule) {
		return accountService.findAdministrateurByMatricule(matricule);
	}
}
