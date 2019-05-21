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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "enseignant", catalog = "GestionDesCours", schema = "public")
public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "matricule_ens", nullable = false, length = 25)
    private String matriculeEns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_ens", nullable = false, length = 100)
    private String nomEns;
    @Size(max = 100)
    @Column(name = "prenom_ens", length = 100)
    private String prenomEns;
    @Basic(optional = false)
    @NotNull
    @Size(max = 20)
    @Column(name = "tel", nullable = false, length = 20)
    private String tel;
    @Column(name = "num_bureau")
    private Integer numBureau;
    //@Size(max = 50)
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @Column(name = "email", length = 100)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricule") 
    private Collection<Cours> coursCollection;

    public Enseignant() {
    }

    public Enseignant(String matriculeEns) {
        this.matriculeEns = matriculeEns;
    }
    
    public Enseignant(String matriculeEns, String motDePasse) {
        this.matriculeEns = matriculeEns;
        this.motDePasse = motDePasse; 
    }

    public Enseignant(String matriculeEns, String nomEns, String tel) {
        this.matriculeEns = matriculeEns;
        this.nomEns = nomEns;
        this.tel = tel;
    }

    public String getMatriculeEns() {
        return matriculeEns;
    }

    public void setMatriculeEns(String matriculeEns) {
        this.matriculeEns = matriculeEns;
    }

    public String getNomEns() {
        return nomEns;
    }

    public void setNomEns(String nomEns) {
        this.nomEns = nomEns;
    }

    public String getPrenomEns() {
        return prenomEns;
    }

    public void setPrenomEns(String prenomEns) {
        this.prenomEns = prenomEns;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getNumBureau() {
        return numBureau;
    }

    public void setNumBureau(Integer numBureau) {
        this.numBureau = numBureau;
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
    public Collection<Cours> getCoursCollection() {
        return coursCollection;
    }

    public void setCoursCollection(Collection<Cours> coursCollection) {
        this.coursCollection = coursCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculeEns != null ? matriculeEns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.matriculeEns == null && other.matriculeEns != null) || (this.matriculeEns != null && !this.matriculeEns.equals(other.matriculeEns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.jpa.Enseignant[ matriculeEns=" + matriculeEns + " ]";
    }
    
}
