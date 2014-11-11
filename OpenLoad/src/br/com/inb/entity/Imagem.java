package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the imagem database table.
 * 
 */
@Entity
@NamedQuery(name="Imagem.findAll", query="SELECT i FROM Imagem i")
public class Imagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idimagem;

	private String nomeimagem;

	private String tipoimagem;

	//bi-directional one-to-one association to Curso
	@OneToOne(mappedBy="imagem", fetch=FetchType.LAZY)
	private Curso curso;

	public Imagem() {
	}

	public int getIdimagem() {
		return this.idimagem;
	}

	public void setIdimagem(int idimagem) {
		this.idimagem = idimagem;
	}

	public String getNomeimagem() {
		return this.nomeimagem;
	}

	public void setNomeimagem(String nomeimagem) {
		this.nomeimagem = nomeimagem;
	}

	public String getTipoimagem() {
		return this.tipoimagem;
	}

	public void setTipoimagem(String tipoimagem) {
		this.tipoimagem = tipoimagem;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}