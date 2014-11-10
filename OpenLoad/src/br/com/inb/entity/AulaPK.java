package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the aula database table.
 * 
 */
@Embeddable
public class AulaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idaula;

	@Column(name="fk_curso", insertable=false, updatable=false)
	private int fkCurso;

	public AulaPK() {
	}
	public int getIdaula() {
		return this.idaula;
	}
	public void setIdaula(int idaula) {
		this.idaula = idaula;
	}
	public int getFkCurso() {
		return this.fkCurso;
	}
	public void setFkCurso(int fkCurso) {
		this.fkCurso = fkCurso;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AulaPK)) {
			return false;
		}
		AulaPK castOther = (AulaPK)other;
		return 
			(this.idaula == castOther.idaula)
			&& (this.fkCurso == castOther.fkCurso);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idaula;
		hash = hash * prime + this.fkCurso;
		
		return hash;
	}
}