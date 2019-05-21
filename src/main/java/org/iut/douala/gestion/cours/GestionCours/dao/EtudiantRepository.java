package org.iut.douala.gestion.cours.GestionCours.dao;

import java.sql.Date;
import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.entities.EtudiantStatistiqueFirst;
import org.iut.douala.gestion.cours.GestionCours.entities.EtudiantStatistiqueSecond;
import org.iut.douala.gestion.cours.GestionCours.entities.Etudiants;
import org.iut.douala.gestion.cours.GestionCours.entities.EtudiantsEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EtudiantRepository extends JpaRepository<Etudiants,String>{
	
	@Query(name = "Etudiants.findEmailOfEtudiantsByIdCour")
	public List<EtudiantsEmail> findEmailOfEtudiantsByIdCour(int idCour);
	
	@Query(name = "Etudiants.findCourseHourProForEtudiants")
	public List<EtudiantStatistiqueFirst> findProgrammingCourseHours(Date dateDeb, Date dateFin, 
															String codeMatiere, int idClasse, String matricule);
	@Query(name = "Etudiants.findCourseHourAssisteForEtudiants")
	public List<EtudiantStatistiqueSecond> findCourseHourAssiste(Date dateDeb, Date dateFin, 
															String codeMatiere, int idClasse, String matricule);
	
}
