package org.iut.douala.gestion.cours.GestionCours.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "classematiere", catalog = "GestionDesCours", schema = "public")
public class ClasseMatiere implements Serializable{
		
	    private static final long serialVersionUID = 1L;
	    @EmbeddedId
	    private ClasseMatierePK classeMatierePK;
	    @JoinColumn(name = "id_class", referencedColumnName = "id_class", nullable = false, insertable = false, updatable = false)
	    @ManyToOne(optional = false)
	    private Classes classes;
	    @JoinColumn(name = "code_matiere", referencedColumnName = "code_matiere", nullable = false, insertable = false, updatable = false)
	    @ManyToOne(optional = false)
	    private Matiere matiere;

	    public ClasseMatiere() {
	    }

	    public ClasseMatiere(ClasseMatierePK classeMatierePK) {
	        this.classeMatierePK = classeMatierePK;
	    }

	    public ClasseMatiere(String codeMatiere, int idClass) {
	        this.classeMatierePK = new ClasseMatierePK(codeMatiere, idClass);
	    }

	  

	    public ClasseMatierePK getClasseMatierePK() {
			return classeMatierePK;
		}

		public void setClasseMatierePK(ClasseMatierePK classeMatierePK) {
			this.classeMatierePK = classeMatierePK;
		}

		public Classes getClasses() {
			return classes;
		}

		public void setClasses(Classes classes) {
			this.classes = classes;
		}

		public Matiere getMatiere() {
			return matiere;
		}

		public void setMatiere(Matiere matiere) {
			this.matiere = matiere;
		}

		@Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (classeMatierePK != null ? classeMatierePK.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof ClasseMatiere)) {
	            return false;
	        }
	        ClasseMatiere other = (ClasseMatiere) object;
	        if ((this.classeMatierePK == null && other.classeMatierePK != null) || (this.classeMatierePK != null && !this.classeMatierePK.equals(other.classeMatierePK))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "com.src.jpa.ClasseMatiere[ classeMatierePK=" + classeMatierePK + " ]";
	    }

}
