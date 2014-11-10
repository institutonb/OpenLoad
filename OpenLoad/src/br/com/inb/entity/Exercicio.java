package br.com.inb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the exercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Exercicio.findAll", query="SELECT e FROM Exercicio e")
public class Exercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idexercicio;

	@Lob
	private String perguntaexercicio;

	private String qtdacertosexercicio;

	private String qtderrosexercicio;

	@Lob
	private String respostaexercicio;

	//bi-directional many-to-one association to Aula
	@OneToMany(mappedBy="exercicio")
	private List<Aula> aulas;

	public Exercicio() {
	}

	public int getIdexercicio() {
		return this.idexercicio;
	}

	public void setIdexercicio(int idexercicio) {
		this.idexercicio = idexercicio;
	}

	public String getPerguntaexercicio() {
		return this.perguntaexercicio;
	}

	public void setPerguntaexercicio(String perguntaexercicio) {
		this.perguntaexercicio = perguntaexercicio;
	}

	public String getQtdacertosexercicio() {
		return this.qtdacertosexercicio;
	}

	public void setQtdacertosexercicio(String qtdacertosexercicio) {
		this.qtdacertosexercicio = qtdacertosexercicio;
	}

	public String getQtderrosexercicio() {
		return this.qtderrosexercicio;
	}

	public void setQtderrosexercicio(String qtderrosexercicio) {
		this.qtderrosexercicio = qtderrosexercicio;
	}

	public String getRespostaexercicio() {
		return this.respostaexercicio;
	}

	public void setRespostaexercicio(String respostaexercicio) {
		this.respostaexercicio = respostaexercicio;
	}

	public List<Aula> getAulas() {
		return this.aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Aula addAula(Aula aula) {
		getAulas().add(aula);
		aula.setExercicio(this);

		return aula;
	}

	public Aula removeAula(Aula aula) {
		getAulas().remove(aula);
		aula.setExercicio(null);

		return aula;
	}

}