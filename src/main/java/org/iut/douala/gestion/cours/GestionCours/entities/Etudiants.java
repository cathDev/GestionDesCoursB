package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity

@SqlResultSetMappings ({
@SqlResultSetMapping (
	 name = "EtudiantsEmailMapping",
	   classes = {
	     @ConstructorResult(
	       targetClass =  EtudiantsEmail.class,
	         columns = {
	            @ColumnResult(name = "email", type = String.class),
	           
	          }
	      )
	 }),
	@SqlResultSetMapping (
		 name = "EtudiantsHeureProMapping",
		   classes = {
		     @ConstructorResult(
		       targetClass =  EtudiantStatistiqueFirst.class,
		         columns = {
		            @ColumnResult(name = "matricule_etud", type = String.class),
		            @ColumnResult(name = "nom_etud", type = String.class),
		            @ColumnResult(name = "prenom_etud", type = String.class),
		            @ColumnResult(name = "code_matiere", type = String.class),
		            @ColumnResult(name = "nom_matiere", type = String.class),
		            @ColumnResult(name = "heure_total_programme", type = Time.class)
			              
		          }
		      )
		 }),
	@SqlResultSetMapping (
		 name = "EtudiantsHeureAssisteMapping",
		   classes = {
		     @ConstructorResult(
		       targetClass =  EtudiantStatistiqueSecond.class,
		         columns = {
		            @ColumnResult(name = "matricule_etud", type = String.class),
		            @ColumnResult(name = "nom_etud", type = String.class),
		            @ColumnResult(name = "prenom_etud", type = String.class),
		            @ColumnResult(name = "code_matiere", type = String.class),
		            @ColumnResult(name = "nom_matiere", type = String.class),
		            @ColumnResult(name = "heure_total_assiste", type = Time.class)
			              
		          }
		      )
		 })
})

@NamedNativeQueries({
	@NamedNativeQuery(
		name = "Etudiants.findEmailOfEtudiantsByIdCour", 
		query = "SELECT e.email FROM etudiants e INNER JOIN inscription i ON e.matricule_etud = i.matricule_etud "  
				+ "INNER JOIN cours c ON i.id_class = c.id_class WHERE c.id_cour = ?1 and e.email IS NOT NULL "
				+ "ORDER BY e.matricule_etud",
		resultSetMapping="EtudiantsEmailMapping"
	),
	@NamedNativeQuery(
			name = "Etudiants.findCourseHourProForEtudiants", 
			query = "select e.matricule_etud, e.nom_etud, e.prenom_etud, m.code_matiere, m.nom_matiere, "  
					+ "SUM ((CAST (c.heure_fin AS TIME))-(CAST (c.heure_deb AS TIME))) AS heure_total_programme from "
					+ "etudiants e inner join inscription i on e.matricule_etud = i.matricule_etud  inner join cours"
					+ " c on i.id_class = c.id_class inner join matiere m on m.code_matiere = c.code_matiere where "
					+ "((c.jour between ?1  and ?2) and (m.code_matiere like ?3) and (c.id_class = ?4) and "
					+ "(e.matricule_etud like ?5)) GROUP BY m.code_matiere, e.matricule_etud ORDER BY m.nom_matiere, e.nom_etud",
			resultSetMapping="EtudiantsHeureProMapping"
		),
	@NamedNativeQuery(
			name = "Etudiants.findCourseHourAssisteForEtudiants", 
			query = "select e.matricule_etud, e.nom_etud, e.prenom_etud, m.code_matiere, m.nom_matiere, "  
					+ "SUM ((CAST (ec.heure_dep_etud AS TIME))-(CAST (ec.heure_arr_etud AS TIME))) AS heure_total_assiste from "  
					+ "etudiants e inner join etudiantcours ec on e.matricule_etud = ec.matricule_etud inner join cours c on "
					+ "c.id_cour = ec.id_cour inner join matiere m on m.code_matiere = c.code_matiere where "
					+ "((c.jour between ?1 and ?2) and (c.code_matiere like ?3) and (c.id_class = ?4) "
					+ "and (e.matricule_etud like ?5)) GROUP BY c.code_matiere, e.matricule_etud, m.code_matiere order by e.nom_etud",
			resultSetMapping="EtudiantsHeureAssisteMapping"
		)
})

@Table(name = "etudiants", catalog = "GestionDesCours", schema = "public")
public class Etudiants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "matricule_etud", nullable = false, length = 25)
    private String matriculeEtud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_etud", nullable = false, length = 100)
    private String nomEtud;
    @Size(max = 100)
    @Column(name = "prenom_etud", length = 100)
    private String prenomEtud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tel", nullable = false, length = 100)
    private String tel;
    @Size(max = 2147483647)
    @Column(name = "adresse_parent")
    private String adresseParent;
   // @Size(max = 50)
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etudiants")
    private Collection<EtudiantCours> etudiantCoursCollection;

    public Etudiants() {
    }

    public Etudiants(String matriculeEtud) {
        this.matriculeEtud = matriculeEtud;
    }

    public Etudiants(String matriculeEtud, String nomEtud, String tel) {
        this.matriculeEtud = matriculeEtud;
        this.nomEtud = nomEtud;
        this.tel = tel;
    }
    
    public Etudiants(String matriculeEtud, String motDePasse) {
        this.matriculeEtud = matriculeEtud;
        this.motDePasse = motDePasse;
    }


	public String getMatriculeEtud() {
        return matriculeEtud;
    }

    public void setMatriculeEtud(String matriculeEtud) {
        this.matriculeEtud = matriculeEtud;
    }

    public String getNomEtud() {
        return nomEtud;
    }

    public void setNomEtud(String nomEtud) {
        this.nomEtud = nomEtud;
    }

    public String getPrenomEtud() {
        return prenomEtud;
    }

    public void setPrenomEtud(String prenomEtud) {
        this.prenomEtud = prenomEtud;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresseParent() {
        return adresseParent;
    }

    public void setAdresseParent(String adresseParent) {
        this.adresseParent = adresseParent;
    }

    @JsonIgnore
   public String getMotDePasse() {
		return motDePasse;
	}

    @JsonSetter
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

@JsonIgnore
    public Collection<EtudiantCours> getEtudiantCoursCollection() {
        return etudiantCoursCollection;
    }

    public void setEtudiantCoursCollection(Collection<EtudiantCours> etudiantCoursCollection) {
        this.etudiantCoursCollection = etudiantCoursCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculeEtud != null ? matriculeEtud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiants)) {
            return false;
        }
        Etudiants other = (Etudiants) object;
        if ((this.matriculeEtud == null && other.matriculeEtud != null) || (this.matriculeEtud != null && !this.matriculeEtud.equals(other.matriculeEtud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.jpa.Etudiants[ matriculeEtud=" + matriculeEtud + " ]";
    }
    
}
