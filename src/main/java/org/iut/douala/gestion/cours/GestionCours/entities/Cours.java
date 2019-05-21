package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SqlResultSetMappings({
	@SqlResultSetMapping
	(
		 name = "EnseignantStatistiqueCompletMapping",
		   classes = {
		     @ConstructorResult(
		       targetClass =  EnseignantStatistiqueComplet.class,
		         columns = {
		            @ColumnResult(name = "matricule_ens", type = String.class),
		            @ColumnResult(name = "nom_ens", type = String.class),
		            @ColumnResult(name = "prenom_ens", type = String.class),
		            @ColumnResult(name = "code_matiere", type = String.class),
		            @ColumnResult(name = "nom_matiere", type = String.class),
		            @ColumnResult(name = "id_formation", type = String.class),
		            @ColumnResult(name = "nom_formation", type = String.class),
		        	@ColumnResult(name = "heure_total_programme", type = String.class),
		        	@ColumnResult(name = "heure_total_enseigne", type = String.class),
		        	@ColumnResult(name = "heure_total_manque", type = String.class)
		       	 }
		      )
		 }
	)
})

@NamedNativeQueries({
	@NamedNativeQuery(
			name = "Cours.aggregateCoursHours", 
			query = "SELECT s.matricule_ens, s.nom_ens, s.prenom_ens, s.code_matiere, s.nom_matiere, s.id_formation,"
					+ " s.nom_formation, s.heure_total_programme, s.heure_total_enseigne, SUM (s.heure_total_programme - s.heure_total_enseigne)"
					+ "AS heure_total_manque FROM statistique(?1, ?2) s where"
					+ "((s.matricule_ens LIKE ?3) AND (s.code_matiere LIKE ?4) AND (s.id_formation LIKE ?5)) GROUP BY s.matricule_ens,"
					+ "s.nom_ens, s.prenom_ens, s.code_matiere, s.nom_matiere, s.id_formation, s.nom_formation, s.heure_total_programme, "
					+ "s.heure_total_enseigne ORDER BY s.matricule_ens, s.nom_ens", 
			resultSetMapping="EnseignantStatistiqueCompletMapping"
		)
  })	

@Table(name = "cours", catalog = "GestionDesCours", schema = "public")

public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cour", nullable = false)
    private Integer idCour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "salle", nullable = false, length = 20)
    private String salle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jour", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date jour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "heure_deb", nullable = false)
    private String  heureDeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "heure_fin", nullable = false)
    private String  heureFin;
    @Basic(optional = false)
    @Size(min = 1, max = 12)
    @Column(name = "heure_arr_ens", nullable = false)
    private String  heureArrEns;
    @Basic(optional = false)
    @Size(min = 1, max = 12)
    @Column(name = "heure_dep_ens", nullable = false)
    private String  heureDepEns;
    @JoinColumn(name = "id_formation", referencedColumnName = "id_formation", nullable = false)
    @ManyToOne(optional = false)
    private Formation idFormation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cours")
    private Collection<EtudiantCours> etudiantCoursCollection;
	@JoinColumn(name = "matricule_ens", referencedColumnName = "matricule_ens", nullable = false)
    @ManyToOne(optional = false)
    private Enseignant matricule;
    @JoinColumn(name = "id_class", referencedColumnName = "id_class", nullable = false)
    @ManyToOne(optional = false)
    private Classes idClass;
    @JoinColumn(name = "id_departement", referencedColumnName = "departement_id", nullable = false)
    @ManyToOne(optional = false)
    private Departement idDepartement;
    @JoinColumn(name = "code_matiere", referencedColumnName = "code_matiere", nullable = false)
    @ManyToOne(optional = false)
    private Matiere codeMatiere;
    @JoinColumn(name = "annee", referencedColumnName = "annee", nullable = false)
    @ManyToOne(optional = false)
    private AnneeAcademique annee;

    public Cours() {
    }

    public Cours(Integer idCour) {
        this.idCour = idCour;
    }

    public Cours(Integer idCour, String salle, Date jour, String heureDeb, String heureFin, String heureArrEns, String heureDepEns) {
        this.idCour = idCour;
        this.salle = salle;
        this.jour = jour;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
        this.heureArrEns = heureArrEns;
        this.heureDepEns = heureDepEns;
    }

    public Integer getIdCour() {
        return idCour;
    }

    public void setIdCour(Integer idCour) {
        this.idCour = idCour;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public String getHeureDeb() {
        return heureDeb;
    }

    public void setHeureDeb(String heureDeb) {
        this.heureDeb = heureDeb;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public String getHeureArrEns() {
        return heureArrEns;
    }

    public void setHeureArrEns(String heureArrEns) {
        this.heureArrEns = heureArrEns;
    }

    public String getHeureDepEns() {
        return heureDepEns;
    }

    public void setHeureDepEns(String heureDepEns) {
        this.heureDepEns = heureDepEns;
    }

    @JsonIgnore
    public Collection<EtudiantCours> getEtudiantCoursCollection() {
        return etudiantCoursCollection;
    }

    public void setEtudiantCoursCollection(Collection<EtudiantCours> etudiantCoursCollection) {
        this.etudiantCoursCollection = etudiantCoursCollection;
    }

    
    public Enseignant getMatricule() {
        return matricule;
    }

    public void setMatricule(Enseignant matricule) {
        this.matricule = matricule;
    }
    
    
    public Classes getIdClass() {
        return idClass;
    }
   
    public void setIdClass(Classes idClass) {
        this.idClass = idClass;
    }
    
   
    public Formation getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Formation idFormation) {
		this.idFormation = idFormation;
	}

	
	public Departement getIdDepartement() {
        return idDepartement;
    }
    
    public void setIdDepartement(Departement idDepartement) {
        this.idDepartement = idDepartement;
    }

    public Matiere getCodeMatiere() {
        return codeMatiere;
    }
    
    public void setCodeMatiere(Matiere codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public AnneeAcademique getAnnee() {
		return annee;
	}

	public void setAnnee(AnneeAcademique annee) {
		this.annee = annee;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idCour != null ? idCour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.idCour == null && other.idCour != null) || (this.idCour != null && !this.idCour.equals(other.idCour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.jpa.Cours[ idCour=" + idCour + " ]";
    }
    
}

