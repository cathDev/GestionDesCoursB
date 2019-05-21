package org.iut.douala.gestion.cours.GestionCours.entities;

import java.sql.Time;

public class EtudiantStatistiqueSecond {

	private String matriculeEtud;
    private String nomEtud;
    private String prenomEtud;
    private String codeMatiere;
    private String nomMatiere;
    private Time heureTotalAssiste;
    
	public EtudiantStatistiqueSecond(String matriculeEtud, String nomEtud, String prenomEtud, String codeMatiere,
			String nomMatiere, Time heureTotalAssiste) {
		super();
		this.matriculeEtud = matriculeEtud;
		this.nomEtud = nomEtud;
		this.prenomEtud = prenomEtud;
		this.codeMatiere = codeMatiere;
		this.nomMatiere = nomMatiere;
		this.heureTotalAssiste = heureTotalAssiste;
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

	public Time getHeureTotalAssiste() {
		return heureTotalAssiste;
	}
    
}
