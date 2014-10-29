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
public class AulaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idaula")
    private int idaula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_curso")
    private int fkCurso;

    public AulaPK() {
    }

    public AulaPK(int idaula, int fkCurso) {
        this.idaula = idaula;
        this.fkCurso = fkCurso;
    }

    public int getIdaula() {
        return idaula;
    }

    public void setIdaula(int idaula) {
        this.idaula = idaula;
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
        hash += (int) idaula;
        hash += (int) fkCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AulaPK)) {
            return false;
        }
        AulaPK other = (AulaPK) object;
        if (this.idaula != other.idaula) {
            return false;
        }
        if (this.fkCurso != other.fkCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.AulaPK[ idaula=" + idaula + ", fkCurso=" + fkCurso + " ]";
    }
    
}
