package org.iut.douala.gestion.cours.GestionCours.restServices;

import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.dao.FormationRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class FormationRestService {

	@Autowired
	private FormationRepository formationRepository;
	
	@RequestMapping(value="/formations", method=RequestMethod.GET)
	public List<Formation> getFormation()
	{
		return formationRepository.findAll();
	}
	
	@RequestMapping(value="/formations", method=RequestMethod.POST)
	public Formation saveFormation(@RequestBody Formation formation)
	{
		return formationRepository.save(formation);
	}
	
	@RequestMapping(value="/formations/{code}", method=RequestMethod.PUT)
	public Formation updateFormation(@PathVariable String code, @RequestBody Formation formation)
	{
		Formation formationFind = formationRepository.findById(code).orElse(null);
		formation.setIdFormation(code);
		formationFind = formation;
		return formationRepository.save(formationFind);
	}
	
	@RequestMapping(value="/formations/{code}", method=RequestMethod.DELETE)
	public void deleteFormation(@PathVariable String code)
	{
		 formationRepository.deleteById(code);
	}
}
