package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aula database table.
 * 
 */
@Entity
@Table(name="aula")
@NamedQuery(name="Aula.findAll", query="SELECT a FROM Aula a")
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;
	private AulaPK id;
	private String descricaoaula;
	private String linkaula;
	private String nomeaula;
	private List<Arquivo> arquivos;
	private Curso curso;
	private Exercicio exercicio;

	public Aula() {
	}


	@EmbeddedId
	public AulaPK getId() {
		return this.id;
	}

	public void setId(AulaPK id) {
		this.id = id;
	}


	@Lob
	@Column(nullable=false)
	public String getDescricaoaula() {
		return this.descricaoaula;
	}

	public void setDescricaoaula(String descricaoaula) {
		this.descricaoaula = descricaoaula;
	}


	@Lob
	@Column(nullable=false)
	public String getLinkaula() {
		return this.linkaula;
	}

	public void setLinkaula(String linkaula) {
		this.linkaula = linkaula;
	}


	@Column(nullable=false, length=40)
	public String getNomeaula() {
		return this.nomeaula;
	}

	public void setNomeaula(String nomeaula) {
		this.nomeaula = nomeaula;
	}


	//bi-directional many-to-one association to Arquivo
	@OneToMany(mappedBy="aula")
	public List<Arquivo> getArquivos() {
		return this.arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	public Arquivo addArquivo(Arquivo arquivo) {
		getArquivos().add(arquivo);
		arquivo.setAula(this);

		return arquivo;
	}

	public Arquivo removeArquivo(Arquivo arquivo) {
		getArquivos().remove(arquivo);
		arquivo.setAula(null);

		return arquivo;
	}


	//bi-directional many-to-one association to Curso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_curso", nullable=false, insertable=false, updatable=false)
	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	//bi-directional many-to-one association to Exercicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="exercicio_idexercicio", nullable=false)
	public Exercicio getExercicio() {
		return this.exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

}