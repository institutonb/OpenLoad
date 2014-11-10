package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aula database table.
 * 
 */
@Entity
@NamedQuery(name="Aula.findAll", query="SELECT a FROM Aula a")
public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AulaPK id;

	@Lob
	private String descricaoaula;

	@Lob
	private String linkaula;

	private String nomeaula;

	//bi-directional many-to-one association to Arquivo
	@OneToMany(mappedBy="aula")
	private List<Arquivo> arquivos;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="fk_curso",insertable=false,updatable=false)
	private Curso curso;

	//bi-directional many-to-one association to Exercicio
	@ManyToOne
	private Exercicio exercicio;

	public Aula() {
	}

	public AulaPK getId() {
		return this.id;
	}

	public void setId(AulaPK id) {
		this.id = id;
	}

	public String getDescricaoaula() {
		return this.descricaoaula;
	}

	public void setDescricaoaula(String descricaoaula) {
		this.descricaoaula = descricaoaula;
	}

	public String getLinkaula() {
		return this.linkaula;
	}

	public void setLinkaula(String linkaula) {
		this.linkaula = linkaula;
	}

	public String getNomeaula() {
		return this.nomeaula;
	}

	public void setNomeaula(String nomeaula) {
		this.nomeaula = nomeaula;
	}

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

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Exercicio getExercicio() {
		return this.exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

}