/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inb.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manoel
 */
@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByIdcurso", query = "SELECT c FROM Curso c WHERE c.idcurso = :idcurso"),
    @NamedQuery(name = "Curso.findByNomecurso", query = "SELECT c FROM Curso c WHERE c.nomecurso = :nomecurso"),
    @NamedQuery(name = "Curso.findByTipocurso", query = "SELECT c FROM Curso c WHERE c.tipocurso = :tipocurso"),
    @NamedQuery(name = "Curso.findByValorcurso", query = "SELECT c FROM Curso c WHERE c.valorcurso = :valorcurso"),
    @NamedQuery(name = "Curso.findByTempocurso", query = "SELECT c FROM Curso c WHERE c.tempocurso = :tempocurso"),
    @NamedQuery(name = "Curso.findByDatainiciocurso", query = "SELECT c FROM Curso c WHERE c.datainiciocurso = :datainiciocurso"),
    @NamedQuery(name = "Curso.findByDiasaulacurso", query = "SELECT c FROM Curso c WHERE c.diasaulacurso = :diasaulacurso"),
    @NamedQuery(name = "Curso.findByPublicoalvocurso", query = "SELECT c FROM Curso c WHERE c.publicoalvocurso = :publicoalvocurso")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcurso")
    private Integer idcurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomecurso")
    private String nomecurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipocurso")
    private short tipocurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorcurso")
    private float valorcurso;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descricaocurso")
    private String descricaocurso;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "conteudocurso")
    private String conteudocurso;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "prerequisitoscurso")
    private String prerequisitoscurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tempocurso")
    private String tempocurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datainiciocurso")
    @Temporal(TemporalType.DATE)
    private Date datainiciocurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "diasaulacurso")
    private String diasaulacurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "publicoalvocurso")
    private String publicoalvocurso;
    @JoinTable(name = "usuario_curso", joinColumns = {
        @JoinColumn(name = "curso_idcurso", referencedColumnName = "idcurso")}, inverseJoinColumns = {
        @JoinColumn(name = "idusuario_curso", referencedColumnName = "idUsuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<Aula> aulaList;

    public Curso() {
    }

    public Curso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public Curso(Integer idcurso, String nomecurso, short tipocurso, float valorcurso, String descricaocurso, String conteudocurso, String prerequisitoscurso, String tempocurso, Date datainiciocurso, String diasaulacurso, String publicoalvocurso) {
        this.idcurso = idcurso;
        this.nomecurso = nomecurso;
        this.tipocurso = tipocurso;
        this.valorcurso = valorcurso;
        this.descricaocurso = descricaocurso;
        this.conteudocurso = conteudocurso;
        this.prerequisitoscurso = prerequisitoscurso;
        this.tempocurso = tempocurso;
        this.datainiciocurso = datainiciocurso;
        this.diasaulacurso = diasaulacurso;
        this.publicoalvocurso = publicoalvocurso;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getNomecurso() {
        return nomecurso;
    }

    public void setNomecurso(String nomecurso) {
        this.nomecurso = nomecurso;
    }

    public short getTipocurso() {
        return tipocurso;
    }

    public void setTipocurso(short tipocurso) {
        this.tipocurso = tipocurso;
    }

    public float getValorcurso() {
        return valorcurso;
    }

    public void setValorcurso(float valorcurso) {
        this.valorcurso = valorcurso;
    }

    public String getDescricaocurso() {
        return descricaocurso;
    }

    public void setDescricaocurso(String descricaocurso) {
        this.descricaocurso = descricaocurso;
    }

    public String getConteudocurso() {
        return conteudocurso;
    }

    public void setConteudocurso(String conteudocurso) {
        this.conteudocurso = conteudocurso;
    }

    public String getPrerequisitoscurso() {
        return prerequisitoscurso;
    }

    public void setPrerequisitoscurso(String prerequisitoscurso) {
        this.prerequisitoscurso = prerequisitoscurso;
    }

    public String getTempocurso() {
        return tempocurso;
    }

    public void setTempocurso(String tempocurso) {
        this.tempocurso = tempocurso;
    }

    public Date getDatainiciocurso() {
        return datainiciocurso;
    }

    public void setDatainiciocurso(Date datainiciocurso) {
        this.datainiciocurso = datainiciocurso;
    }

    public String getDiasaulacurso() {
        return diasaulacurso;
    }

    public void setDiasaulacurso(String diasaulacurso) {
        this.diasaulacurso = diasaulacurso;
    }

    public String getPublicoalvocurso() {
        return publicoalvocurso;
    }

    public void setPublicoalvocurso(String publicoalvocurso) {
        this.publicoalvocurso = publicoalvocurso;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        hash += (idcurso != null ? idcurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idcurso == null && other.idcurso != null) || (this.idcurso != null && !this.idcurso.equals(other.idcurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.inb.entidades.Curso[ idcurso=" + idcurso + " ]";
    }
    
}
