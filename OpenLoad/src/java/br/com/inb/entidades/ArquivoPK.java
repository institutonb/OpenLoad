/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inb.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author manoel
 */
@Embeddable
public class ArquivoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idarquivo")
    private int idarquivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_curso")
    private int fkCurso;

    public ArquivoPK() {
    }

    public ArquivoPK(int idarquivo, int fkCurso) {
        this.idarquivo = idarquivo;
        this.fkCurso = fkCurso;
    }

    public int getIdarquivo() {
        return idarquivo;
    }

    public void setIdarquivo(int idarquivo) {
        this.idarquivo = idarquivo;
    }

    public int getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(int fkCurso) {
        this.fkCurso = fkCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idarquivo;
        hash += (int) fkCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArquivoPK)) {
            return false;
        }
        ArquivoPK other = (ArquivoPK) object;
        if (this.idarquivo != other.idarquivo) {
            return false;
        }
        if (this.fkCurso != other.fkCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.ArquivoPK[ idarquivo=" + idarquivo + ", fkCurso=" + fkCurso + " ]";
    }
    
}
