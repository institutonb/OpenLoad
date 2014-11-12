package br.com.inb.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.criterion.Restrictions;

import br.com.inb.dao.Dao;
import br.com.inb.entity.Curso;
import br.com.inb.entity.DadosUsuario;
import br.com.inb.entity.Imagem;
import br.com.inb.entity.Usuario;

@ManagedBean(name = "curso")
@ViewScoped
public class CursoBean {

    @ManagedProperty("#{login.user}")
	private Usuario user;
    
    private String courseId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
	
	public List<Imagem> getImagesCourses() {
		List<Curso> cursos = getCourseUser();
		List<Imagem> images= new ArrayList<Imagem>();
		for( Curso curso : cursos ){
			images.add(curso.getImagem());
		}
		return images;
	}
	
	public List<Curso> getCourseUser(){
		return getUser().getCursos();
	}
	
	public DadosUsuario getDataUser(){
		return getUser().getDadosUsuarios().get(0);
	}
	
	public List<DadosUsuario> getListDataUser(){
		return getUser().getDadosUsuarios();
	}
	
	
	
	
	
	/**
	 * @return the course
	 */
	public Curso getSelectedCourse() {

		List<Curso> cursos = getCourseUser();
		Curso selectedCourse = new Curso();
		int selectedIdCourse=Integer.parseInt(this.courseId);
		for( Curso curso : cursos ){
			if( selectedIdCourse == curso.getIdcurso()){
				selectedCourse = curso;
			}else{
				selectedCourse = null;
			}
		}
		
		return selectedCourse ;
	}
	
	/**
	 * @return the user
	 */
	public Usuario getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Usuario user) {
		this.user = user;
	}

	@PostConstruct
	private void beginDao(){
		
	}
	public CursoBean() {
	}
	
	

}
