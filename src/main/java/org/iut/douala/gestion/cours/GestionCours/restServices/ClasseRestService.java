package org.iut.douala.gestion.cours.GestionCours.restServices;

import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.dao.ClasseRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ClasseRestService {

	@Autowired
	private ClasseRepository classeRepository;
	
	@RequestMapping(value="/classes", method=RequestMethod.GET)
	public List<Classes> getClasses()
	{
		return classeRepository.findAll();
	}
	
	@RequestMapping(value="/classes/{idDept}/{idFor}", method=RequestMethod.GET)
	public List<Classes> getClasseByDepartementAndFormation(@PathVariable String idDept, @PathVariable String idFor)
	{
		return classeRepository.findClassesByDepartementIdAndIdFormation(idDept, idFor);
	}
	
	@RequestMapping(value="/classe/{id}", method=RequestMethod.GET)
	public Classes getClasseById(@PathVariable int id)
	{
		return classeRepository.findById(id).orElse(null);
	}
	
	@RequestMapping(value="/class/{idDept}", method=RequestMethod.GET)
	public List<Classes> getClasseByDepartement(@PathVariable String idDept)
	{
		return classeRepository.findClassesByDepartementId(idDept);
	}
	
	@RequestMapping(value="/classes", method=RequestMethod.POST)
	public Classes saveClasse(@RequestBody Classes classe)
	{
		return classeRepository.save(classe);
	}
	
	@RequestMapping(value="/classes/{id}", method=RequestMethod.PUT)
	public Classes updateClasse(@PathVariable int id, @RequestBody Classes classe)
	{
		Classes classeFind = classeRepository.findById(id).orElse(null);
		classe.setIdClass(id);
		classeFind = classe;
		return classeRepository.save(classeFind);
	}
	
	@RequestMapping(value="/classes/{id}", method=RequestMethod.DELETE)
	public void deleteClasse(@PathVariable int id)
	{
		classeRepository.deleteById(id);
	}
}
