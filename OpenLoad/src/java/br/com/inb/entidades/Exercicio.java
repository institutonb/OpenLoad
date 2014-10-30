/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inb.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manoel
 */
@Entity
@Table(name = "exercicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exercicio.findAll", query = "SELECT e FROM Exercicio e"),
    @NamedQuery(name = "Exercicio.findByIdexercicio", query = "SELECT e FROM Exercicio e WHERE e.idexercicio = :idexercicio"),
    @NamedQuery(name = "Exercicio.findByQtdacertosexercicio", query = "SELECT e FROM Exercicio e WHERE e.qtdacertosexercicio = :qtdacertosexercicio"),
    @NamedQuery(name = "Exercicio.findByQtderrosexercicio", query = "SELECT e FROM Exercicio e WHERE e.qtderrosexercicio = :qtderrosexercicio")})
public class Exercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexercicio")
    private Integer idexercicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "qtdacertosexercicio")
    private String qtdacertosexercicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exercicioIdexercicio")
    private List<Aula> aulaList;

    public Exercicio() {
    }

    public Exercicio(Integer idexercicio) {
        this.idexercicio = idexercicio;
    }

    public Exercicio(Integer idexercicio, String qtdacertosexercicio, String qtderrosexercicio, String perguntaexercicio, String respostaexercicio) {
        this.idexercicio = idexercicio;
        this.qtdacertosexercicio = qtdacertosexercicio;
        this.qtderrosexercicio = qtderrosexercicio;
        this.perguntaexercicio = perguntaexercicio;
        this.respostaexercicio = respostaexercicio;
    }

    public Integer getIdexercicio() {
        return idexercicio;
    }

    public void setIdexercicio(Integer idexercicio) {
        this.idexercicio = idexercicio;
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

    @XmlTransient
    public List<Aula> getAulaList() {
        return aulaList;
    }

    public void setAulaList(List<Aula> aulaList) {
        this.aulaList = aulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexercicio != null ? idexercicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exercicio)) {
            return false;
        }
        Exercicio other = (Exercicio) object;
        if ((this.idexercicio == null && other.idexercicio != null) || (this.idexercicio != null && !this.idexercicio.equals(other.idexercicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.Exercicio[ idexercicio=" + idexercicio + " ]";
    }
    
}
