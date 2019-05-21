package org.iut.douala.gestion.cours.GestionCours.restServices;

import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.dao.ClasseMatiereRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.ClasseMatiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClasseMatiereRestService {
	
	@Autowired
	private ClasseMatiereRepository classeMatiereRepository;
	
	
	@RequestMapping(value="/classematieres", method=RequestMethod.GET)
	public List<ClasseMatiere> getClasses()
	{
		return classeMatiereRepository.findAll();
	}
	
	
	@RequestMapping(value="/classematieres", method=RequestMethod.POST)
	public ClasseMatiere saveClasseMatiere(@RequestBody ClasseMatiere classeMatiere)
	{
		return classeMatiereRepository.save(classeMatiere);
	}
	
}
