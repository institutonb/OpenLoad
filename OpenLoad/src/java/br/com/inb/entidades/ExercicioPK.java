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
public class ExercicioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idexercicio")
    private int idexercicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_usuario")
    private int fkUsuario;

    public ExercicioPK() {
    }

    public ExercicioPK(int idexercicio, int fkUsuario) {
        this.idexercicio = idexercicio;
        this.fkUsuario = fkUsuario;
    }

    public int getIdexercicio() {
        return idexercicio;
    }

    public void setIdexercicio(int idexercicio) {
        this.idexercicio = idexercicio;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idexercicio;
        hash += (int) fkUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExercicioPK)) {
            return false;
        }
        ExercicioPK other = (ExercicioPK) object;
        if (this.idexercicio != other.idexercicio) {
            return false;
        }
        if (this.fkUsuario != other.fkUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.ExercicioPK[ idexercicio=" + idexercicio + ", fkUsuario=" + fkUsuario + " ]";
    }
    
}
