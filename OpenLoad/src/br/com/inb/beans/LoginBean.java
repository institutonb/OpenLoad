/**
 * 
 */
package br.com.inb.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.hibernate.criterion.Restrictions;

import br.com.inb.entity.Usuario;
import br.com.inb.dao.*;

/**
 * @author manoel
 *
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {

	/**
	 * 
	 */
	private Usuario user;

	private String email;
	private String password;
	private short status=1;
	

	/**
	 * @return the status
	 */
	public short getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(short status) {
		this.status = status;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the user
	 */
	public Usuario getUser() {
		if (user == null) {
			user = new Usuario();
		}
		return user;
	}

	public String goHome() {
		Dao.begin();
		this.user = (Usuario) Dao.getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("emailUsuario", this.email))
				.add(Restrictions.eq("senhaUsuario", this.password))
				.add(Restrictions.eq("statususuario", this.status ) ).list().get(0);

		if (user.getStatususuario() == 1) {
			if (user.getEmailUsuario().equals(this.email)
					&& user.getSenhaUsuario().equals(this.password)) {
				return "/pages/Curso/meusCursos?faces-redirect=true";
			} else {
				return "";
			}
		}
		Dao.commit();
		return null;

	}

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

}
