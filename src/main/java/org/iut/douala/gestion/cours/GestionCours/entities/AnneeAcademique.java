package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 *
 * @author USER
 */
@Entity
@Table(name = "anneeacademique", catalog = "GestionDesCours", schema = "public")

public class AnneeAcademique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "annee", nullable = false, length = 12)
    private String annee;
    @JoinTable(name = "inscription", joinColumns = {
        @JoinColumn(name = "annee", referencedColumnName = "annee", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_class", referencedColumnName = "id_class", nullable = false)})
    @ManyToMany
    private Collection<Classes> classesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annee")
    private Collection<Cours> coursCollection;

    public AnneeAcademique() {
    }

    public AnneeAcademique(String annee) {
        this.annee = annee;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
  
    public Collection<Cours> getCoursCollection() {
		return coursCollection;
	}
    
    @JsonIgnore
	public void setCoursCollection(Collection<Cours> coursCollection) {
		this.coursCollection = coursCollection;
	}

	@JsonIgnore
    public Collection<Classes> getClassesCollection() {
        return classesCollection;
    }

    public void setClassesCollection(Collection<Classes> classesCollection) {
        this.classesCollection = classesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (annee != null ? annee.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnneeAcademique)) {
            return false;
        }
        AnneeAcademique other = (AnneeAcademique) object;
        if ((this.annee == null && other.annee != null) || (this.annee != null && !this.annee.equals(other.annee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.jpa.Anneeacademique[ annee=" + annee + " ]";
    }
    
}
