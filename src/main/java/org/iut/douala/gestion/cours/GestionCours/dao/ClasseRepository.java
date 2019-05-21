package org.iut.douala.gestion.cours.GestionCours.dao;

import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.entities.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClasseRepository extends JpaRepository<Classes, Integer>{
	
	@Query("select c from Classes c  where c.departementId.departementId = ?1")
	public List<Classes> findClassesByDepartementId(String departementId);
	@Query("select c from Classes c where c.departementId.departementId = ?1 and c.idFormation.idFormation = ?2")
	public List<Classes> findClassesByDepartementIdAndIdFormation(String departementId, String idFormation);
	
}
