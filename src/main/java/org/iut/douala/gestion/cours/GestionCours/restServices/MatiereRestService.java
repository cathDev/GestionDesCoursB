package org.iut.douala.gestion.cours.GestionCours.restServices;

import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.dao.MatiereRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class MatiereRestService {
	
	@Autowired
	private MatiereRepository matiereRepository;
	
	@RequestMapping(value="/matieres", method=RequestMethod.GET)
	public List<Matiere> getMatiere()
	{
		return matiereRepository.findAll();
	}
	
	@RequestMapping(value="/matieres/{id}", method=RequestMethod.GET)
	public List<Matiere> getMatiereByClasseId(@PathVariable int id)
	{
		return matiereRepository.findMatiereByClasseId(id);
	}
	
	@RequestMapping(value="/matieres", method=RequestMethod.POST)
	public Matiere saveMatiere(@RequestBody Matiere matiere)
	{
		return matiereRepository.save(matiere);
	}
	
	@RequestMapping(value="/matieres/{code}", method=RequestMethod.PUT)
	public Matiere updateMatiere(@PathVariable String code, @RequestBody Matiere matiere)
	{
		Matiere matiereFind = matiereRepository.findById(code).orElse(null);
		matiere.setCodeMatiere(matiereFind.getCodeMatiere());
		matiereFind = matiere;
		return matiereRepository.save(matiereFind);
	}
	
	@RequestMapping(value="/matieres/{code}", method=RequestMethod.DELETE)
	public void deleteMatiere(@PathVariable String code)
	{
		 matiereRepository.deleteById(code);
	}
}
