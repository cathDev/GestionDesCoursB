package org.iut.douala.gestion.cours.GestionCours.entities;

import java.sql.Time;

public class EtudiantStatistiqueFirst {

	private String matriculeEtud;
    private String nomEtud;
    private String prenomEtud;
    private String codeMatiere;
    private String nomMatiere;
    private Time heureTotalProgramme;
    
	public EtudiantStatistiqueFirst(String matriculeEtud, String nomEtud, String prenomEtud, String codeMatiere,
			String nomMatiere, Time heureTotalProgramme) {
		this.matriculeEtud = matriculeEtud;
		this.nomEtud = nomEtud;
		this.prenomEtud = prenomEtud;
		this.codeMatiere = codeMatiere;
		this.nomMatiere = nomMatiere;
		this.heureTotalProgramme = heureTotalProgramme;
	}

	public String getMatriculeEtud() {
		return matriculeEtud;
	}

	public String getNomEtud() {
		return nomEtud;
	}

	public String getPrenomEtud() {
		return prenomEtud;
	}

	public String getCodeMatiere() {
		return codeMatiere;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public Time getHeureTotalProgramme() {
		return heureTotalProgramme;
	}
    
    
}
