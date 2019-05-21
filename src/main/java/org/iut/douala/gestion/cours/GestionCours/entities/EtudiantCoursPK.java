package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class EtudiantCoursPK implements Serializable {

    private String matricule_etud;
    private int id_cour;

    public EtudiantCoursPK() {
    }

    public EtudiantCoursPK(String matriculeEtud, int idCour) {
        this.matricule_etud = matriculeEtud;
        this.id_cour = idCour;
    }

    public String getMatriculeEtud() {
        return matricule_etud;
    }

    public void setMatriculeEtud(String matriculeEtud) {
        this.matricule_etud = matriculeEtud;
    }

    public int getIdCour() {
        return id_cour;
    }

    public void setIdCour(int idCour) {
        this.id_cour = idCour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricule_etud != null ? matricule_etud.hashCode() : 0);
        hash += (int) id_cour;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtudiantCoursPK)) {
            return false;
        }
        EtudiantCoursPK other = (EtudiantCoursPK) object;
        if ((this.matricule_etud == null && other.matricule_etud != null) || (this.matricule_etud != null && !this.matricule_etud.equals(other.matricule_etud))) {
            return false;
        }
        if (this.id_cour != other.id_cour) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.src.jpa.EtudiantCoursPK[ matriculeEtud=" + matricule_etud + ", idCour=" + id_cour + " ]";
    }
    
}
