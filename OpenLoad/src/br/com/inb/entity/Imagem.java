package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the imagem database table.
 * 
 */
@Entity
@Table(name="imagem")
@NamedQuery(name="Imagem.findAll", query="SELECT i FROM Imagem i")
public class Imagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idimagem;

	@Column(length=45)
	private String nomeimagem;

	@Column(length=45)
	private String tipoimagem;

	//bi-directional one-to-one association to Curso
	@OneToOne(mappedBy="imagem", fetch=FetchType.LAZY)
	private Curso curso;

	//bi-directional many-to-one association to DadosUsuario
	@OneToMany(mappedBy="imagem")
	private List<DadosUsuario> dadosUsuarios;

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

	public List<DadosUsuario> getDadosUsuarios() {
		return this.dadosUsuarios;
	}

	public void setDadosUsuarios(List<DadosUsuario> dadosUsuarios) {
		this.dadosUsuarios = dadosUsuarios;
	}

	public DadosUsuario addDadosUsuario(DadosUsuario dadosUsuario) {
		getDadosUsuarios().add(dadosUsuario);
		dadosUsuario.setImagem(this);

		return dadosUsuario;
	}

	public DadosUsuario removeDadosUsuario(DadosUsuario dadosUsuario) {
		getDadosUsuarios().remove(dadosUsuario);
		dadosUsuario.setImagem(null);

		return dadosUsuario;
	}

}