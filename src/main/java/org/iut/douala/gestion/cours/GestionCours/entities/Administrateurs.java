package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "administrateurs", catalog = "GestionDesCours", schema = "public")
public class Administrateurs implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "matricule", nullable = false, length = 50)
	private String matricule;
	@Basic(optional = false)
    @NotNull
    @Column(name = "mot_de_passe", nullable = false)
	private String motDePasse;
	
	public Administrateurs(String matricule, String motDePasse) {
		this.matricule = matricule;
		this.motDePasse = motDePasse;
	}
	
	public Administrateurs() {		
	}
	
	public String getMatricule() {
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	@JsonIgnore
	public String getMotDePasse() {
		return motDePasse;
	}
	
	@JsonSetter
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
}
