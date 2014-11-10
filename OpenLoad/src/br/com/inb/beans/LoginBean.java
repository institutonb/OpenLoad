/**
 * 
 */
package br.com.inb.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.inb.entity.Usuario;
import br.com.inb.dao.*;


/**
 * @author manoel
 *
 */
@ManagedBean(name="login")
@ViewScoped
public class LoginBean {

	/**
	 * 
	 */
	private Usuario user;
		
	
	/**
	 * @return the user
	 */
	public Usuario getUser() {
		if (user == null) {
			user=new Usuario();
		}
		return user;
	}	

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void gravar(){
		Dao.begin();
		Dao.getSession().save(this.user);
		Dao.commit();
		Dao.close();
	}
	

}
