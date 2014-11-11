package br.com.inb.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.inb.dao.Dao;
import br.com.inb.entity.Curso;
import br.com.inb.entity.Imagem;
import br.com.inb.entity.Usuario;

@ManagedBean(name = "curso")
@ViewScoped
public class CursoBean {

	@SuppressWarnings("unchecked")
	public List<Imagem> getImagensCursos() {
		Dao.begin();
		List<Imagem> imagens = new ArrayList<Imagem>();
		imagens.addAll(Dao.getSession().getNamedQuery("Imagem.findAll").list());
		Dao.commit();
		return imagens;
	}
	
	public Usuario getUsuario() {
		Dao.begin();
		Usuario user= (Usuario) Dao.getSession().getNamedQuery("Usuario.findAll")
				.list().get(0);
		Dao.commit();
		return user;
	}
	

	@PostConstruct
	private void beginDao(){
		
	}
	public CursoBean() {
	}
	
	

}
