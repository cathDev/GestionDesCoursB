package org.iut.douala.gestion.cours.GestionCours.entities;

public class EtudiantsEmail {
	
	private String email;

	public EtudiantsEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "{\n\t"
				+"\"email\": \"" + email + "\""
			    +"\n}";
	}

}
