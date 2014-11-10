package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the arquivo database table.
 * 
 */
@Entity
@NamedQuery(name="Arquivo.findAll", query="SELECT a FROM Arquivo a")
public class Arquivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idarquivo;

	private String nomearquivo;

	//bi-directional many-to-one association to Aula
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="aula_fk_curso", referencedColumnName="fk_curso"),
		@JoinColumn(name="aula_idaula", referencedColumnName="idaula")
		})
	private Aula aula;

	public Arquivo() {
	}

	public int getIdarquivo() {
		return this.idarquivo;
	}

	public void setIdarquivo(int idarquivo) {
		this.idarquivo = idarquivo;
	}

	public String getNomearquivo() {
		return this.nomearquivo;
	}

	public void setNomearquivo(String nomearquivo) {
		this.nomearquivo = nomearquivo;
	}

	public Aula getAula() {
		return this.aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

}