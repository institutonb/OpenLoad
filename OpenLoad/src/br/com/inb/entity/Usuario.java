package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;

	private String emailUsuario;

	private int nivelUsuario;

	private String senhaUsuario;

	private byte statususuario;

	//bi-directional many-to-one association to DadosUsuario
	@OneToMany(mappedBy="usuario")
	private List<DadosUsuario> dadosUsuarios;

	//bi-directional many-to-many association to Curso
	@ManyToMany
	@JoinTable(
		name="usuario_curso"
		, joinColumns={
			@JoinColumn(name="idusuario_curso")
			}
		, inverseJoinColumns={
			@JoinColumn(name="curso_idcurso")
			}
		)
	private List<Curso> cursos;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmailUsuario() {
		return this.emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public int getNivelUsuario() {
		return this.nivelUsuario;
	}

	public void setNivelUsuario(int nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}

	public String getSenhaUsuario() {
		return this.senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public byte getStatususuario() {
		return this.statususuario;
	}

	public void setStatususuario(byte statususuario) {
		this.statususuario = statususuario;
	}

	public List<DadosUsuario> getDadosUsuarios() {
		return this.dadosUsuarios;
	}

	public void setDadosUsuarios(List<DadosUsuario> dadosUsuarios) {
		this.dadosUsuarios = dadosUsuarios;
	}

	public DadosUsuario addDadosUsuario(DadosUsuario dadosUsuario) {
		getDadosUsuarios().add(dadosUsuario);
		dadosUsuario.setUsuario(this);

		return dadosUsuario;
	}

	public DadosUsuario removeDadosUsuario(DadosUsuario dadosUsuario) {
		getDadosUsuarios().remove(dadosUsuario);
		dadosUsuario.setUsuario(null);

		return dadosUsuario;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}