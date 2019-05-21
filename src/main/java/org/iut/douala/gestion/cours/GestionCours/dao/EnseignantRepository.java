package org.iut.douala.gestion.cours.GestionCours.dao;

import org.iut.douala.gestion.cours.GestionCours.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnseignantRepository extends JpaRepository<Enseignant, String>{

	@Query("select e.email from Enseignant e inner join Cours c on e.matriculeEns = c.matricule where c.idCour = ?1")
	public String findEmailOfEnseignantByIdCour(int idCour);
}
