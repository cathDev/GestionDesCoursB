package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author USER
 */
@Entity
@Table(name = "etudiantcours", catalog = "GestionDesCours", schema = "public")
public class EtudiantCours implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private EtudiantCoursPK etudiantCoursPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "heure_arr_etud", nullable = false)
    private String heureArrEtud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "heure_dep_etud", nullable = false)
    private String heureDepEtud;
    @JoinColumn(name = "id_cour", referencedColumnName = "id_cour", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cours cours;
    @JoinColumn(name = "matricule_etud", referencedColumnName = "matricule_etud", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etudiants etudiants;

    public EtudiantCours() {
    }

    public EtudiantCours(EtudiantCoursPK etudiantCoursPK) {
        this.etudiantCoursPK = etudiantCoursPK;
    }

    public EtudiantCours(EtudiantCoursPK etudiantCoursPK, String heureArrEtud, String heureDepEtud) {
        this.etudiantCoursPK = etudiantCoursPK;
        this.heureArrEtud = heureArrEtud;
        this.heureDepEtud = heureDepEtud;
    }

    public EtudiantCours(String matriculeEtud, int idCour) {
        this.etudiantCoursPK = new EtudiantCoursPK(matriculeEtud, idCour);
    }

    public EtudiantCoursPK getEtudiantCoursPK() {
        return etudiantCoursPK;
    }

    public void setEtudiantCoursPK(EtudiantCoursPK etudiantCoursPK) {
        this.etudiantCoursPK = etudiantCoursPK;
    }

    public String getHeureArrEtud() {
        return heureArrEtud;
    }

    public void setHeureArrEtud(String heureArrEtud) {
        this.heureArrEtud = heureArrEtud;
    }

    public String getHeureDepEtud() {
        return heureDepEtud;
    }

    public void setHeureDepEtud(String heureDepEtud) {
        this.heureDepEtud = heureDepEtud;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Etudiants getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Etudiants etudiants) {
        this.etudiants = etudiants;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etudiantCoursPK != null ? etudiantCoursPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtudiantCours)) {
            return false;
        }
        EtudiantCours other = (EtudiantCours) object;
        if ((this.etudiantCoursPK == null && other.etudiantCoursPK != null) || (this.etudiantCoursPK != null && !this.etudiantCoursPK.equals(other.etudiantCoursPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.jpa.EtudiantCours[ etudiantCoursPK=" + etudiantCoursPK + " ]";
    }
    
}
