package org.iut.douala.gestion.cours.GestionCours.restServices;

import java.util.List;
import java.util.Optional;

import org.iut.douala.gestion.cours.GestionCours.dao.AnneeAcademiqueRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.AnneeAcademique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AnneeAcademiqueRestService 
{
	@Autowired
	AnneeAcademiqueRepository anneeAcademique;
	
	//ce service fonctionne bien
	@RequestMapping(value="/anneeAcademiques", method=RequestMethod.POST)
	public AnneeAcademique saveAnnee(@RequestBody AnneeAcademique annee)
	{
		return anneeAcademique.save(annee);
	}
	
	//ce service fonctionne bien
	@RequestMapping(value="/anneeAcademiques", method=RequestMethod.GET)
	public List<AnneeAcademique> getListAnnee()
	{
		return anneeAcademique.findAll();
	}
	
	@RequestMapping(value="/anneeAcademiques/{id}", method=RequestMethod.GET)
	public AnneeAcademique getOneAnnee(@PathVariable int id)
	{
		return anneeAcademique.findById(id).orElse(null);
	}
}
