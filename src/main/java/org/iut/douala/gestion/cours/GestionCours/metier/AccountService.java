package org.iut.douala.gestion.cours.GestionCours.metier;

import org.iut.douala.gestion.cours.GestionCours.entities.Administrateurs;
import org.iut.douala.gestion.cours.GestionCours.entities.Enseignant;
import org.iut.douala.gestion.cours.GestionCours.entities.Etudiants;

public interface AccountService {

	public Enseignant saveEnseignant(Enseignant enseignant);
	public Etudiants saveEtudiant(Etudiants etudiant);
	public Administrateurs saveAdministrateur(Administrateurs admin);
	public Enseignant findEnseignantByMatricule(String matricule);
	public Etudiants findEtudiantByMatricule(String matricule);
	public Administrateurs findAdministrateurByMatricule(String matricule);
}
