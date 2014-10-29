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
@Table(name = "arquivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arquivo.findAll", query = "SELECT a FROM Arquivo a"),
    @NamedQuery(name = "Arquivo.findByIdarquivo", query = "SELECT a FROM Arquivo a WHERE a.arquivoPK.idarquivo = :idarquivo"),
    @NamedQuery(name = "Arquivo.findByNomearquivo", query = "SELECT a FROM Arquivo a WHERE a.nomearquivo = :nomearquivo"),
    @NamedQuery(name = "Arquivo.findByFkCurso", query = "SELECT a FROM Arquivo a WHERE a.arquivoPK.fkCurso = :fkCurso")})
public class Arquivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArquivoPK arquivoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomearquivo")
    private String nomearquivo;
    @JoinColumn(name = "fk_curso", referencedColumnName = "idcurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;

    public Arquivo() {
    }

    public Arquivo(ArquivoPK arquivoPK) {
        this.arquivoPK = arquivoPK;
    }

    public Arquivo(ArquivoPK arquivoPK, String nomearquivo) {
        this.arquivoPK = arquivoPK;
        this.nomearquivo = nomearquivo;
    }

    public Arquivo(int idarquivo, int fkCurso) {
        this.arquivoPK = new ArquivoPK(idarquivo, fkCurso);
    }

    public ArquivoPK getArquivoPK() {
        return arquivoPK;
    }

    public void setArquivoPK(ArquivoPK arquivoPK) {
        this.arquivoPK = arquivoPK;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (arquivoPK != null ? arquivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquivo)) {
            return false;
        }
        Arquivo other = (Arquivo) object;
        if ((this.arquivoPK == null && other.arquivoPK != null) || (this.arquivoPK != null && !this.arquivoPK.equals(other.arquivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.Arquivo[ arquivoPK=" + arquivoPK + " ]";
    }
    
}
