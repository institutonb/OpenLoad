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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a"),
    @NamedQuery(name = "Aula.findByIdaula", query = "SELECT a FROM Aula a WHERE a.aulaPK.idaula = :idaula"),
    @NamedQuery(name = "Aula.findByFkCurso", query = "SELECT a FROM Aula a WHERE a.aulaPK.fkCurso = :fkCurso"),
    @NamedQuery(name = "Aula.findByNomeaula", query = "SELECT a FROM Aula a WHERE a.nomeaula = :nomeaula")})
public class Aula implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AulaPK aulaPK;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "linkaula")
    private String linkaula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nomeaula")
    private String nomeaula;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descricaoaula")
    private String descricaoaula;
    @JoinColumn(name = "exercicio_idexercicio", referencedColumnName = "idexercicio")
    @ManyToOne(optional = false)
    private Exercicio exercicioIdexercicio;
    @JoinColumn(name = "fk_curso", referencedColumnName = "idcurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aula")
    private List<Arquivo> arquivoList;

    public Aula() {
    }

    public Aula(AulaPK aulaPK) {
        this.aulaPK = aulaPK;
    }

    public Aula(AulaPK aulaPK, String linkaula, String nomeaula, String descricaoaula) {
        this.aulaPK = aulaPK;
        this.linkaula = linkaula;
        this.nomeaula = nomeaula;
        this.descricaoaula = descricaoaula;
    }

    public Aula(int idaula, int fkCurso) {
        this.aulaPK = new AulaPK(idaula, fkCurso);
    }

    public AulaPK getAulaPK() {
        return aulaPK;
    }

    public void setAulaPK(AulaPK aulaPK) {
        this.aulaPK = aulaPK;
    }

    public String getLinkaula() {
        return linkaula;
    }

    public void setLinkaula(String linkaula) {
        this.linkaula = linkaula;
    }

    public String getNomeaula() {
        return nomeaula;
    }

    public void setNomeaula(String nomeaula) {
        this.nomeaula = nomeaula;
    }

    public String getDescricaoaula() {
        return descricaoaula;
    }

    public void setDescricaoaula(String descricaoaula) {
        this.descricaoaula = descricaoaula;
    }

    public Exercicio getExercicioIdexercicio() {
        return exercicioIdexercicio;
    }

    public void setExercicioIdexercicio(Exercicio exercicioIdexercicio) {
        this.exercicioIdexercicio = exercicioIdexercicio;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @XmlTransient
    public List<Arquivo> getArquivoList() {
        return arquivoList;
    }

    public void setArquivoList(List<Arquivo> arquivoList) {
        this.arquivoList = arquivoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aulaPK != null ? aulaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.aulaPK == null && other.aulaPK != null) || (this.aulaPK != null && !this.aulaPK.equals(other.aulaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.Aula[ aulaPK=" + aulaPK + " ]";
    }
    
}
