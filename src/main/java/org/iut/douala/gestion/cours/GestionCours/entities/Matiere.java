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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "matiere", catalog = "GestionDesCours", schema = "public")
public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code_matiere", nullable = false, length = 10)
    private String codeMatiere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_matiere", nullable = false, length = 100)
    private String nomMatiere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "groupe", nullable = false, length = 50)
    private String groupe;
    @JoinTable(name = "departementmatiere", joinColumns = {
        @JoinColumn(name = "code_matiere", referencedColumnName = "code_matiere", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "departement_id", referencedColumnName = "departement_id", nullable = false)})
    @ManyToMany
    private Collection<Departement> departementCollection;
    @JoinTable(name = "classematiere", joinColumns = {
        @JoinColumn(name = "code_matiere", referencedColumnName = "code_matiere", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_class", referencedColumnName = "id_class", nullable = false)})
    @ManyToMany
    private Collection<Classes> classesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeMatiere")
    private Collection<Cours> coursCollection;

    public Matiere() {
    }

    public Matiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public Matiere(String codeMatiere, String nomMatiere, String groupe) {
        this.codeMatiere = codeMatiere;
        this.nomMatiere = nomMatiere;
        this.groupe = groupe;
    }

    public String getCodeMatiere() {
        return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
        this.codeMatiere = codeMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    @JsonIgnore
    public Collection<Departement> getDepartementCollection() {
        return departementCollection;
    }

    public void setDepartementCollection(Collection<Departement> departementCollection) {
        this.departementCollection = departementCollection;
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
        hash += (codeMatiere != null ? codeMatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.codeMatiere == null && other.codeMatiere != null) || (this.codeMatiere != null && !this.codeMatiere.equals(other.codeMatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.jpa.Matiere[ codeMatiere=" + codeMatiere + " ]";
    }
    
}

