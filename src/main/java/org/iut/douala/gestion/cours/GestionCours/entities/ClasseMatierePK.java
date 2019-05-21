package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class ClasseMatierePK implements Serializable{
	
	  private int id_class;
	  private String code_matiere;
	    

	    public ClasseMatierePK() {
	    }

	    public ClasseMatierePK(String codeMatiere, int idClass) {
	        this.code_matiere = codeMatiere;
	        this.id_class = idClass;
	    }

	    public int getId_class() {
			return id_class;
		}

		public void setId_class(int id_class) {
			this.id_class = id_class;
		}

		public String getCode_matiere() {
			return code_matiere;
		}

		public void setCode_matiere(String code_matiere) {
			this.code_matiere = code_matiere;
		}

		@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (code_matiere != null ? code_matiere.hashCode() : 0);
	        hash += (int) id_class;
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof ClasseMatierePK)) {
	            return false;
	        }
	        ClasseMatierePK other = (ClasseMatierePK) object;
	        if ((this.code_matiere == null && other.code_matiere != null) || (this.code_matiere != null && !this.code_matiere.equals(other.code_matiere))) {
	            return false;
	        }
	        if (this.id_class != other.id_class) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.src.jpa.ClasseMatierePK[ codeMatiere=" + code_matiere + ", idClass=" + id_class + " ]";
	    }
	    

}
