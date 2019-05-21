package org.iut.douala.gestion.cours.GestionCours.entities;

public class EnseignantStatistiqueComplet {
	private String matriculeEns;
	private String nomEns;
	private String prenomEns;
	private String codeMatiere;
	private String nomMatiere;
	private String idFormation;
	private String nomFormation;
	private String heureTotalProgramme;
	private String heureTotalEnseigne;
	private String heureTotalManque;
	
	public EnseignantStatistiqueComplet(String matriculeEns, String nomEns, String prenomEns, String codeMatiere,
			String nomMatiere, String idFormation, String nomFormation, String heureTotalProgramme,
			String heureTotalEnseigne, String heureTotalManque) {
		super();
		this.matriculeEns = matriculeEns;
		this.nomEns = nomEns;
		this.prenomEns = prenomEns;
		this.codeMatiere = codeMatiere;
		this.nomMatiere = nomMatiere;
		this.idFormation = idFormation;
		this.nomFormation = nomFormation;
		this.heureTotalProgramme = heureTotalProgramme;
		this.heureTotalEnseigne = heureTotalEnseigne;
		this.heureTotalManque = heureTotalManque;
	}

	public String getMatriculeEns() {
		return matriculeEns;
	}

	public String getNomEns() {
		return nomEns;
	}
	
	public String getPrenomEns() {
		return prenomEns;
	}
	
	public String getCodeMatiere() {
		return codeMatiere;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public String getIdFormation() {
		return idFormation;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public String getHeureTotalProgramme() {
		return heureTotalProgramme;
	}
	
	public String getHeureTotalEnseigne() {
		return heureTotalEnseigne;
	}
	
	public String getHeureTotalManque() {
		return heureTotalManque;
	}

	@Override
	public String toString() {
		return "{\n\t"
				+"\"matriculeEns\": \"" + matriculeEns + "\""
				+"\"nomEns\": \"" + nomEns + "\""
				+"\"prenomEns\": \"" + prenomEns + "\""
				+"\"codeMatiere\": \"" + codeMatiere + "\""
				+"\"nomMatiere\": \"" + nomMatiere + "\""
				+"\"idFormation\": \"" + idFormation + "\""
				+"\"nomFormation\": \"" + nomFormation + "\""
				+"\"heureTotalProgramme\": \"" + heureTotalProgramme + "\""
				+"\"heureTotalEnseigne\": \"" + heureTotalEnseigne + "\""
				+"\"heureTotalManque\": \"" + heureTotalManque + "\""
			    +"\n}";
		
	}
	
}
