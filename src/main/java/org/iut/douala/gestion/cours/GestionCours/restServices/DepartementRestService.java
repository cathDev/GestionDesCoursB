package org.iut.douala.gestion.cours.GestionCours.restServices;

import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.dao.DepartementRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class DepartementRestService 
{
	@Autowired
	private DepartementRepository departementRepository;
	
	
	@RequestMapping(value="/departements", method = RequestMethod.POST) 
	public Departement saveDepartement(@RequestBody Departement departement) 
	{
		return departementRepository.save(departement);
	}
	
	
	@RequestMapping(value = "/departements", method = RequestMethod.GET)
	public List<Departement> getListDepartement()
	{
		return departementRepository.findAll();
	}
	
	@RequestMapping(value = "/departements/{code}", method = RequestMethod.GET)
	public Departement getOneDepartement(@PathVariable String code)
	{
		return departementRepository.findById(code).orElse(null);
	}
	
	@RequestMapping(value = "/departements/{id}", method = RequestMethod.PUT)
	public Departement updateDepartement(@PathVariable String id, @RequestBody Departement departement)
	{
		Departement depart = departementRepository.findById(id).orElse(null);
		departement.setDepartementId(id);
		depart = departement;
		return departementRepository.save(depart);
	}
	
	@RequestMapping(value = "/departements/{id}", method = RequestMethod.DELETE)
	public boolean deleteDepartement(@PathVariable String id)
	{
		 departementRepository.deleteById(id);
		 return true;
	}

}
