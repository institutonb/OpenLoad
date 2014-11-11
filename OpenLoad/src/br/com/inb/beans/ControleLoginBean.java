/**
 * 
 */
package br.com.inb.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.inb.entity.Usuario;


@Named("controleLogin")
@SessionScoped
/**
 * @author manoel
 *
 */
public class ControleLoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2979848970585808327L;
	private Usuario usuario;

	public Boolean isLogado() {
		return usuario != null;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * 
	 */
	public ControleLoginBean() {
		// TODO Auto-generated constructor stub
	}

}
