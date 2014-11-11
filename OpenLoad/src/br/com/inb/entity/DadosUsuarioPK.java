package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dados_usuario database table.
 * 
 */
@Embeddable
public class DadosUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="iddados_usuario", unique=true, nullable=false)
	private int iddadosUsuario;

	@Column(name="fk_usuario", insertable=false, updatable=false, unique=true, nullable=false)
	private int fkUsuario;

	public DadosUsuarioPK() {
	}
	public int getIddadosUsuario() {
		return this.iddadosUsuario;
	}
	public void setIddadosUsuario(int iddadosUsuario) {
		this.iddadosUsuario = iddadosUsuario;
	}
	public int getFkUsuario() {
		return this.fkUsuario;
	}
	public void setFkUsuario(int fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DadosUsuarioPK)) {
			return false;
		}
		DadosUsuarioPK castOther = (DadosUsuarioPK)other;
		return 
			(this.iddadosUsuario == castOther.iddadosUsuario)
			&& (this.fkUsuario == castOther.fkUsuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.iddadosUsuario;
		hash = hash * prime + this.fkUsuario;
		
		return hash;
	}
}