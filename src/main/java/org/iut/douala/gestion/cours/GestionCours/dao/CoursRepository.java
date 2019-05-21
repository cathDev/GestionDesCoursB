package org.iut.douala.gestion.cours.GestionCours.dao;

import java.sql.Date;
import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoursRepository extends JpaRepository<Cours, Integer>{
	
	@Query("select co from Cours co inner join Classes c on c.idClass = co.idClass where c.idClass = ?1 order by co.idCour")
	public List<Cours> findCoursByClasseId(int idClass);
	
	@Query(name="Cours.aggregateCoursHours")
    public List<Object> aggregateCoursHours(Date dateDeb, Date dateFin, String matricule, String matiere, String formation);
	
	
}
