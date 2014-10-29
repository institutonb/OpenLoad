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
@Table(name = "dados_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DadosUsuario.findAll", query = "SELECT d FROM DadosUsuario d"),
    @NamedQuery(name = "DadosUsuario.findByIddadosUsuario", query = "SELECT d FROM DadosUsuario d WHERE d.dadosUsuarioPK.iddadosUsuario = :iddadosUsuario"),
    @NamedQuery(name = "DadosUsuario.findByNomedadosUsuario", query = "SELECT d FROM DadosUsuario d WHERE d.nomedadosUsuario = :nomedadosUsuario"),
    @NamedQuery(name = "DadosUsuario.findByCpfdadosUsuario", query = "SELECT d FROM DadosUsuario d WHERE d.cpfdadosUsuario = :cpfdadosUsuario"),
    @NamedQuery(name = "DadosUsuario.findByTelefonedadosUsuario", query = "SELECT d FROM DadosUsuario d WHERE d.telefonedadosUsuario = :telefonedadosUsuario"),
    @NamedQuery(name = "DadosUsuario.findByFkUsuario", query = "SELECT d FROM DadosUsuario d WHERE d.dadosUsuarioPK.fkUsuario = :fkUsuario"),
    @NamedQuery(name = "DadosUsuario.findByEnderecodadosUsuario", query = "SELECT d FROM DadosUsuario d WHERE d.enderecodadosUsuario = :enderecodadosUsuario")})
public class DadosUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DadosUsuarioPK dadosUsuarioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nomedados_usuario")
    private String nomedadosUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpfdados_usuario")
    private int cpfdadosUsuario;
    @Column(name = "telefonedados_usuario")
    private Integer telefonedadosUsuario;
    @Size(max = 80)
    @Column(name = "enderecodados_usuario")
    private String enderecodadosUsuario;
    @JoinColumn(name = "fk_usuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public DadosUsuario() {
    }

    public DadosUsuario(DadosUsuarioPK dadosUsuarioPK) {
        this.dadosUsuarioPK = dadosUsuarioPK;
    }

    public DadosUsuario(DadosUsuarioPK dadosUsuarioPK, String nomedadosUsuario, int cpfdadosUsuario) {
        this.dadosUsuarioPK = dadosUsuarioPK;
        this.nomedadosUsuario = nomedadosUsuario;
        this.cpfdadosUsuario = cpfdadosUsuario;
    }

    public DadosUsuario(int iddadosUsuario, int fkUsuario) {
        this.dadosUsuarioPK = new DadosUsuarioPK(iddadosUsuario, fkUsuario);
    }

    public DadosUsuarioPK getDadosUsuarioPK() {
        return dadosUsuarioPK;
    }

    public void setDadosUsuarioPK(DadosUsuarioPK dadosUsuarioPK) {
        this.dadosUsuarioPK = dadosUsuarioPK;
    }

    public String getNomedadosUsuario() {
        return nomedadosUsuario;
    }

    public void setNomedadosUsuario(String nomedadosUsuario) {
        this.nomedadosUsuario = nomedadosUsuario;
    }

    public int getCpfdadosUsuario() {
        return cpfdadosUsuario;
    }

    public void setCpfdadosUsuario(int cpfdadosUsuario) {
        this.cpfdadosUsuario = cpfdadosUsuario;
    }

    public Integer getTelefonedadosUsuario() {
        return telefonedadosUsuario;
    }

    public void setTelefonedadosUsuario(Integer telefonedadosUsuario) {
        this.telefonedadosUsuario = telefonedadosUsuario;
    }

    public String getEnderecodadosUsuario() {
        return enderecodadosUsuario;
    }

    public void setEnderecodadosUsuario(String enderecodadosUsuario) {
        this.enderecodadosUsuario = enderecodadosUsuario;
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
        hash += (dadosUsuarioPK != null ? dadosUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DadosUsuario)) {
            return false;
        }
        DadosUsuario other = (DadosUsuario) object;
        if ((this.dadosUsuarioPK == null && other.dadosUsuarioPK != null) || (this.dadosUsuarioPK != null && !this.dadosUsuarioPK.equals(other.dadosUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.DadosUsuario[ dadosUsuarioPK=" + dadosUsuarioPK + " ]";
    }
    
}
