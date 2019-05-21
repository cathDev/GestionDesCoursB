package org.iut.douala.gestion.cours.GestionCours.dao;

import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatiereRepository extends JpaRepository<Matiere, String>{
	
	@Query("select m from Matiere m inner join ClasseMatiere cm  on m.codeMatiere = cm.classeMatierePK.code_matiere and cm.classeMatierePK.id_class = ?1")
	public List<Matiere> findMatiereByClasseId(int id_class);

}
