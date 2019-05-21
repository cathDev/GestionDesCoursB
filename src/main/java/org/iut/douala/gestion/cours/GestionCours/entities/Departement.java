package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "departement", catalog = "GestionDesCours", schema = "public")

@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d")
    , @NamedQuery(name = "Departement.findByDepartementId", query = "SELECT d FROM Departement d WHERE d.departementId = :departementId")
    , @NamedQuery(name = "Departement.findByDepartementNom", query = "SELECT d FROM Departement d WHERE d.departementNom = :departementNom")})

public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "departement_id", nullable = false, length = 10)
    private String departementId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "departement_nom", nullable = false, length = 50)
    private String departementNom;
    @ManyToMany(mappedBy = "departementCollection")
    private Collection<Matiere> matiereCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departementId")
    private Collection<Classes> classesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartement")  
    private Collection<Cours> coursCollection;

    public Departement() {
    }

    public Departement(String departementId) {
        this.departementId = departementId;
    }

    public Departement(String departementId, String departementNom) {
        this.departementId = departementId;
        this.departementNom = departementNom;
    }

    public String getDepartementId() {
        return departementId;
    }

    public void setDepartementId(String departementId) {
        this.departementId = departementId;
    }

    public String getDepartementNom() {
        return departementNom;
    }

    public void setDepartementNom(String departementNom) {
        this.departementNom = departementNom;
    }

    @JsonIgnore
    public Collection<Matiere> getMatiereCollection() {
        return matiereCollection;
    }

    public void setMatiereCollection(Collection<Matiere> matiereCollection) {
        this.matiereCollection = matiereCollection;
    }

    @JsonIgnore
    public Collection<Classes> getClassesCollection() {
        return classesCollection;
    }

    public void setClassesCollection(Collection<Classes> classesCollection) {
        this.classesCollection = classesCollection;
    }

    @JsonIgnore
    public Collection<Cours> getCoursCollection() {
        return coursCollection;
    }
    
   
    public void setCoursCollection(Collection<Cours> coursCollection) {
        this.coursCollection = coursCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departementId != null ? departementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.departementId == null && other.departementId != null) || (this.departementId != null && !this.departementId.equals(other.departementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.jpa.Departement[ departementId=" + departementId + " ]";
    }
    
}
