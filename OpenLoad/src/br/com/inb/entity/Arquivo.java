package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the arquivo database table.
 * 
 */
@Entity
@Table(name="arquivo")
@NamedQuery(name="Arquivo.findAll", query="SELECT a FROM Arquivo a")
public class Arquivo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idarquivo;
	private String nomearquivo;
	private Aula aula;

	public Arquivo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdarquivo() {
		return this.idarquivo;
	}

	public void setIdarquivo(int idarquivo) {
		this.idarquivo = idarquivo;
	}


	@Column(nullable=false, length=45)
	public String getNomearquivo() {
		return this.nomearquivo;
	}

	public void setNomearquivo(String nomearquivo) {
		this.nomearquivo = nomearquivo;
	}


	//bi-directional many-to-one association to Aula
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="aula_fk_curso", referencedColumnName="fk_curso", nullable=false),
		@JoinColumn(name="aula_idaula", referencedColumnName="idaula", nullable=false)
		})
	public Aula getAula() {
		return this.aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

}