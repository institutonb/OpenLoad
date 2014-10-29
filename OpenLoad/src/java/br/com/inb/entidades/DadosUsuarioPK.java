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
public class DadosUsuarioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "iddados_usuario")
    private int iddadosUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_usuario")
    private int fkUsuario;

    public DadosUsuarioPK() {
    }

    public DadosUsuarioPK(int iddadosUsuario, int fkUsuario) {
        this.iddadosUsuario = iddadosUsuario;
        this.fkUsuario = fkUsuario;
    }

    public int getIddadosUsuario() {
        return iddadosUsuario;
    }

    public void setIddadosUsuario(int iddadosUsuario) {
        this.iddadosUsuario = iddadosUsuario;
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
        hash += (int) iddadosUsuario;
        hash += (int) fkUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DadosUsuarioPK)) {
            return false;
        }
        DadosUsuarioPK other = (DadosUsuarioPK) object;
        if (this.iddadosUsuario != other.iddadosUsuario) {
            return false;
        }
        if (this.fkUsuario != other.fkUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.DadosUsuarioPK[ iddadosUsuario=" + iddadosUsuario + ", fkUsuario=" + fkUsuario + " ]";
    }
    
}
