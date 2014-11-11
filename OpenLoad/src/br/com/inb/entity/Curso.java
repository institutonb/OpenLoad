package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@Table(name="curso")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int idcurso;

	private byte ativoCurso;

	@Lob
	@Column(nullable=false)
	private String conteudocurso;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date datainiciocurso;

	@Lob
	@Column(nullable=false)
	private String descricaocurso;

	@Column(nullable=false, length=80)
	private String diasaulacurso;

	@Column(nullable=false, length=45)
	private String nomecurso;

	private int porcentagemCurso;

	@Lob
	@Column(nullable=false)
	private String prerequisitoscurso;

	@Column(nullable=false, length=255)
	private String publicoalvocurso;

	@Column(nullable=false, length=15)
	private String tempocurso;

	@Column(nullable=false)
	private byte tipocurso;

	@Column(nullable=false)
	private float valorcurso;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="curso")
	private List<Aula> aulas;

	//bi-directional one-to-one association to Imagem
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcurso", nullable=false, insertable=false, updatable=false)
	private Imagem imagem;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="cursos")
	private List<Usuario> usuarios;

	public Curso() {
	}

	public int getIdcurso() {
		return this.idcurso;
	}

	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}

	public byte getAtivoCurso() {
		return this.ativoCurso;
	}

	public void setAtivoCurso(byte ativoCurso) {
		this.ativoCurso = ativoCurso;
	}

	public String getConteudocurso() {
		return this.conteudocurso;
	}

	public void setConteudocurso(String conteudocurso) {
		this.conteudocurso = conteudocurso;
	}

	public Date getDatainiciocurso() {
		return this.datainiciocurso;
	}

	public void setDatainiciocurso(Date datainiciocurso) {
		this.datainiciocurso = datainiciocurso;
	}

	public String getDescricaocurso() {
		return this.descricaocurso;
	}

	public void setDescricaocurso(String descricaocurso) {
		this.descricaocurso = descricaocurso;
	}

	public String getDiasaulacurso() {
		return this.diasaulacurso;
	}

	public void setDiasaulacurso(String diasaulacurso) {
		this.diasaulacurso = diasaulacurso;
	}

	public String getNomecurso() {
		return this.nomecurso;
	}

	public void setNomecurso(String nomecurso) {
		this.nomecurso = nomecurso;
	}

	public int getPorcentagemCurso() {
		return this.porcentagemCurso;
	}

	public void setPorcentagemCurso(int porcentagemCurso) {
		this.porcentagemCurso = porcentagemCurso;
	}

	public String getPrerequisitoscurso() {
		return this.prerequisitoscurso;
	}

	public void setPrerequisitoscurso(String prerequisitoscurso) {
		this.prerequisitoscurso = prerequisitoscurso;
	}

	public String getPublicoalvocurso() {
		return this.publicoalvocurso;
	}

	public void setPublicoalvocurso(String publicoalvocurso) {
		this.publicoalvocurso = publicoalvocurso;
	}

	public String getTempocurso() {
		return this.tempocurso;
	}

	public void setTempocurso(String tempocurso) {
		this.tempocurso = tempocurso;
	}

	public byte getTipocurso() {
		return this.tipocurso;
	}

	public void setTipocurso(byte tipocurso) {
		this.tipocurso = tipocurso;
	}

	public float getValorcurso() {
		return this.valorcurso;
	}

	public void setValorcurso(float valorcurso) {
		this.valorcurso = valorcurso;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula addAula(Aula aula) {
		getAulas().add(aula);
		aula.setCurso(this);

		return aula;
	}

	public Aula removeAula(Aula aula) {
		getAulas().remove(aula);
		aula.setCurso(null);

		return aula;
	}

	public Imagem getImagem() {
		return this.imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}