package br.com.inb.intercptors;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.com.inb.beans.ControleLoginBean;

@Interceptor @Login
public class LoginInterceptor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7574484898320655417L;

	@Inject
	private ControleLoginBean session;
	
	public LoginInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {
		 FacesContext context = FacesContext.getCurrentInstance();
	        if (!session.isLogado()) {
	            context.getApplication().getNavigationHandler().handleNavigation(context, null, "login");
	        }
	        try {
	            return ic.proceed();
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	
	}

}
