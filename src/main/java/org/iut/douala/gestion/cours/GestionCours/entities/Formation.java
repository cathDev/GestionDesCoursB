package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "formation", catalog = "GestionDesCours", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f")
    , @NamedQuery(name = "Formation.findByIdFormation", query = "SELECT f FROM Formation f WHERE f.idFormation = :idFormation")
    , @NamedQuery(name = "Formation.findByNomFormation", query = "SELECT f FROM Formation f WHERE f.nomFormation = :nomFormation")
    , @NamedQuery(name = "Formation.findByTimeDeb", query = "SELECT f FROM Formation f WHERE f.timeDeb = :timeDeb")
    , @NamedQuery(name = "Formation.findByTimeFin", query = "SELECT f FROM Formation f WHERE f.timeFin = :timeFin")})
public class Formation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id_formation", nullable = false, length = 10)
    private String idFormation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_formation", nullable = false, length = 50)
    private String nomFormation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "time_deb", nullable = false)
    private String timeDeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "time_fin", nullable = false)
    private String timeFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormation")  
    private Collection<Cours> coursCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormation")  
    private Collection<Classes> classesCollection;
    
    public Formation() {
    }

    public Formation(String idFormation) {
        this.idFormation = idFormation;
    }

    public Formation(String idFormation, String nomFormation, String timeDeb, String timeFin) {
        this.idFormation = idFormation;
        this.nomFormation = nomFormation;
        this.timeDeb = timeDeb;
        this.timeFin = timeFin;
    }

    public String getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(String idFormation) {
        this.idFormation = idFormation;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public String getTimeDeb() {
        return timeDeb;
    }

    public void setTimeDeb(String timeDeb) {
        this.timeDeb = timeDeb;
    }

    public String getTimeFin() {
        return timeFin;
    }

    public void setTimeFin(String timeFin) {
        this.timeFin = timeFin;
    }
    
    @JsonIgnore
    public Collection<Cours> getCoursCollection() {
        return coursCollection;
    }
    
   
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
        hash += (idFormation != null ? idFormation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.idFormation == null && other.idFormation != null) || (this.idFormation != null && !this.idFormation.equals(other.idFormation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.jpa.Formation[ idFormation=" + idFormation + " ]";
    }
    
}

