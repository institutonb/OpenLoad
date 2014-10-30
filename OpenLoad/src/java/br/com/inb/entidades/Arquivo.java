/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
    @NamedQuery(name = "Arquivo.findByIdarquivo", query = "SELECT a FROM Arquivo a WHERE a.idarquivo = :idarquivo"),
    @NamedQuery(name = "Arquivo.findByNomearquivo", query = "SELECT a FROM Arquivo a WHERE a.nomearquivo = :nomearquivo")})
public class Arquivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarquivo")
    private Integer idarquivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomearquivo")
    private String nomearquivo;
    @JoinColumns({
        @JoinColumn(name = "aula_idaula", referencedColumnName = "idaula"),
        @JoinColumn(name = "aula_fk_curso", referencedColumnName = "fk_curso")})
    @ManyToOne(optional = false)
    private Aula aula;

    public Arquivo() {
    }

    public Arquivo(Integer idarquivo) {
        this.idarquivo = idarquivo;
    }

    public Arquivo(Integer idarquivo, String nomearquivo) {
        this.idarquivo = idarquivo;
        this.nomearquivo = nomearquivo;
    }

    public Integer getIdarquivo() {
        return idarquivo;
    }

    public void setIdarquivo(Integer idarquivo) {
        this.idarquivo = idarquivo;
    }

    public String getNomearquivo() {
        return nomearquivo;
    }

    public void setNomearquivo(String nomearquivo) {
        this.nomearquivo = nomearquivo;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarquivo != null ? idarquivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquivo)) {
            return false;
        }
        Arquivo other = (Arquivo) object;
        if ((this.idarquivo == null && other.idarquivo != null) || (this.idarquivo != null && !this.idarquivo.equals(other.idarquivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.Arquivo[ idarquivo=" + idarquivo + " ]";
    }
    
}
