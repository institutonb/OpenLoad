/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inb.nbeans;

import br.com.inb.DAO.Dao;
import br.com.inb.entidades.Usuario;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author manoel
 */
@Named(value = "login")
@SessionScoped
public class LoginBean {

    private Usuario usuario;

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LoginBean() {
    }

    public String loga() {
        Dao.begin();
        Usuario usuario = (Usuario) Dao.getSession().getNamedQuery("Usuario.findAll").list().get(0);
        if (this.usuario.getEmailUsuario().equals(usuario.getEmailUsuario())
                && this.usuario.getSenhaUsuario().equals(usuario.getSenhaUsuario())) {
            return "dashBoard";
        } else {
            return null;
        }

    }

}
