/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manoel
 */
@Entity
@Table(name = "exercicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exercicio.findAll", query = "SELECT e FROM Exercicio e"),
    @NamedQuery(name = "Exercicio.findByIdexercicio", query = "SELECT e FROM Exercicio e WHERE e.exercicioPK.idexercicio = :idexercicio"),
    @NamedQuery(name = "Exercicio.findByQtdacertosexercicio", query = "SELECT e FROM Exercicio e WHERE e.qtdacertosexercicio = :qtdacertosexercicio"),
    @NamedQuery(name = "Exercicio.findByQtderrosexercicio", query = "SELECT e FROM Exercicio e WHERE e.qtderrosexercicio = :qtderrosexercicio"),
    @NamedQuery(name = "Exercicio.findByFkUsuario", query = "SELECT e FROM Exercicio e WHERE e.exercicioPK.fkUsuario = :fkUsuario")})
public class Exercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExercicioPK exercicioPK;
    @Size(max = 45)
    @Column(name = "qtdacertosexercicio")
    private String qtdacertosexercicio;
    @Size(max = 45)
    @Column(name = "qtderrosexercicio")
    private String qtderrosexercicio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "perguntaexercicio")
    private String perguntaexercicio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "respostaexercicio")
    private String respostaexercicio;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Exercicio() {
    }

    public Exercicio(ExercicioPK exercicioPK) {
        this.exercicioPK = exercicioPK;
    }

    public Exercicio(ExercicioPK exercicioPK, String perguntaexercicio, String respostaexercicio) {
        this.exercicioPK = exercicioPK;
        this.perguntaexercicio = perguntaexercicio;
        this.respostaexercicio = respostaexercicio;
    }

    public Exercicio(int idexercicio, int fkUsuario) {
        this.exercicioPK = new ExercicioPK(idexercicio, fkUsuario);
    }

    public ExercicioPK getExercicioPK() {
        return exercicioPK;
    }

    public void setExercicioPK(ExercicioPK exercicioPK) {
        this.exercicioPK = exercicioPK;
    }

    public String getQtdacertosexercicio() {
        return qtdacertosexercicio;
    }

    public void setQtdacertosexercicio(String qtdacertosexercicio) {
        this.qtdacertosexercicio = qtdacertosexercicio;
    }

    public String getQtderrosexercicio() {
        return qtderrosexercicio;
    }

    public void setQtderrosexercicio(String qtderrosexercicio) {
        this.qtderrosexercicio = qtderrosexercicio;
    }

    public String getPerguntaexercicio() {
        return perguntaexercicio;
    }

    public void setPerguntaexercicio(String perguntaexercicio) {
        this.perguntaexercicio = perguntaexercicio;
    }

    public String getRespostaexercicio() {
        return respostaexercicio;
    }

    public void setRespostaexercicio(String respostaexercicio) {
        this.respostaexercicio = respostaexercicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exercicioPK != null ? exercicioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exercicio)) {
            return false;
        }
        Exercicio other = (Exercicio) object;
        if ((this.exercicioPK == null && other.exercicioPK != null) || (this.exercicioPK != null && !this.exercicioPK.equals(other.exercicioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.Exercicio[ exercicioPK=" + exercicioPK + " ]";
    }
    
}
