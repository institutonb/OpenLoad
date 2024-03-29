package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dados_usuario database table.
 * 
 */
@Entity
@Table(name="dados_usuario")
@NamedQuery(name="DadosUsuario.findAll", query="SELECT d FROM DadosUsuario d")
public class DadosUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DadosUsuarioPK id;

	@Column(name="cpfdados_usuario", nullable=false)
	private int cpfdadosUsuario;

	@Column(name="enderecodados_usuario", length=80)
	private String enderecodadosUsuario;

	@Column(name="nomedados_usuario", nullable=false, length=80)
	private String nomedadosUsuario;

	@Column(name="telefonedados_usuario")
	private int telefonedadosUsuario;

	//bi-directional many-to-one association to Imagem
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_imagem")
	private Imagem imagem;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_usuario", nullable=false, insertable=false, updatable=false)
	private Usuario usuario;

	public DadosUsuario() {
	}

	public DadosUsuarioPK getId() {
		return this.id;
	}

	public void setId(DadosUsuarioPK id) {
		this.id = id;
	}

	public int getCpfdadosUsuario() {
		return this.cpfdadosUsuario;
	}

	public void setCpfdadosUsuario(int cpfdadosUsuario) {
		this.cpfdadosUsuario = cpfdadosUsuario;
	}

	public String getEnderecodadosUsuario() {
		return this.enderecodadosUsuario;
	}

	public void setEnderecodadosUsuario(String enderecodadosUsuario) {
		this.enderecodadosUsuario = enderecodadosUsuario;
	}

	public String getNomedadosUsuario() {
		return this.nomedadosUsuario;
	}

	public void setNomedadosUsuario(String nomedadosUsuario) {
		this.nomedadosUsuario = nomedadosUsuario;
	}

	public int getTelefonedadosUsuario() {
		return this.telefonedadosUsuario;
	}

	public void setTelefonedadosUsuario(int telefonedadosUsuario) {
		this.telefonedadosUsuario = telefonedadosUsuario;
	}

	public Imagem getImagem() {
		return this.imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}