package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
@Table(name = "classes", catalog = "GestionDesCours", schema = "public")

public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_class", nullable = false)
    private Integer idClass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "parcours", nullable = false, length = 10)
    private String parcours;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "filiere", nullable = false, length = 150)
    private String filiere;
    @Basic(optional = false)
    @NotNull
    @Column(name = "niveau", nullable = false)
    private int niveau;
    @ManyToMany(mappedBy = "classesCollection")
    private Collection<AnneeAcademique> anneeacademiqueCollection;
    @ManyToMany(mappedBy = "classesCollection")
    private Collection<Matiere> matiereCollection;
    @JoinColumn(name = "departement_id", referencedColumnName = "departement_id", nullable = false)
    @ManyToOne(optional = false)
    private Departement departementId;
    @JoinColumn(name = "id_formation", referencedColumnName = "id_formation", nullable = false)
    @ManyToOne(optional = false)
    private Formation idFormation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClass") 
    private Collection<Cours> coursCollection;

    public Classes() {
    }

    public Classes(Integer idClass) {
        this.idClass = idClass;
    }

    public Classes(Integer idClass, String parcours, String filiere, int niveau) {
        this.idClass = idClass;
        this.parcours = parcours;
        this.filiere = filiere;
        this.niveau = niveau;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public String getParcours() {
        return parcours;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @JsonIgnore
    public Collection<AnneeAcademique> getAnneeacademiqueCollection() {
        return anneeacademiqueCollection;
    }

    public void setAnneeAcademiqueCollection(Collection<AnneeAcademique> anneeacademiqueCollection) {
        this.anneeacademiqueCollection = anneeacademiqueCollection;
    }

    @JsonIgnore
    public Collection<Matiere> getMatiereCollection() {
        return matiereCollection;
    }

    public void setMatiereCollection(Collection<Matiere> matiereCollection) {
        this.matiereCollection = matiereCollection;
    }
    
    public Departement getDepartementId() {
        return departementId;
    }
    
    public void setDepartementId(Departement departementId) {
        this.departementId = departementId;
    }

    @JsonIgnore
    public Collection<Cours> getCoursCollection() {
        return coursCollection;
    }

    public void setCoursCollection(Collection<Cours> coursCollection) {
        this.coursCollection = coursCollection;
    }
    
    public Formation getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Formation idFormation) {
		this.idFormation = idFormation;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idClass != null ? idClass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classes)) {
            return false;
        }
        Classes other = (Classes) object;
        if ((this.idClass == null && other.idClass != null) || (this.idClass != null && !this.idClass.equals(other.idClass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.jpa.Classes[ idClass=" + idClass + " ]";
    }
    
}

