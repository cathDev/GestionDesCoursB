package org.iut.douala.gestion.cours.GestionCours.dao;

import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.entities.ClasseMatiere;
import org.iut.douala.gestion.cours.GestionCours.entities.ClasseMatierePK;
import org.iut.douala.gestion.cours.GestionCours.entities.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClasseMatiereRepository extends JpaRepository<ClasseMatiere, ClasseMatierePK>{
	
	}
