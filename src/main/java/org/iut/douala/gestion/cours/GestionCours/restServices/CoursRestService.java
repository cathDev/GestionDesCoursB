package org.iut.douala.gestion.cours.GestionCours.restServices;

import java.sql.Date;
import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.dao.CoursRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CoursRestService 
{
	@Autowired
	private CoursRepository coursRepository;
	
	@RequestMapping(value= "/cours", method = RequestMethod.POST)
	public Cours programmerCours(@RequestBody Cours cour)
	{
		return coursRepository.save(cour);
	}
	
	@RequestMapping(value = "/cours", method = RequestMethod.GET)
	public List<Cours> getListCours()
	{
		return coursRepository.findAll();
	}
	
	@RequestMapping(value = "/cour/{id}", method = RequestMethod.GET)
	public Cours getCoursById(@PathVariable int id) 
	{
		return coursRepository.findById(id).orElse(null);
	}
	
	@RequestMapping(value = "/cours/{id}", method = RequestMethod.GET)
	public List<Cours> getCoursByIdClasse(@PathVariable int id) 
	{
		return coursRepository.findCoursByClasseId(id);
	}
		
	@RequestMapping(value = "/cours/{dateDeb}/{dateFin}", method = RequestMethod.GET)
	public List<Object> hourOfCours(@PathVariable Date dateDeb, @PathVariable Date dateFin,
			@RequestParam(value="matriculeEns", defaultValue = "%%", required=false) String matricule,
			@RequestParam(value="codeMatiere", defaultValue = "%%", required=false) String matiere,
			@RequestParam(value="idFormation", defaultValue = "%%", required=false) String formation ) 
	{ 
		return coursRepository.aggregateCoursHours(dateDeb, dateFin, matricule, matiere, formation);
	}
	
	
}
