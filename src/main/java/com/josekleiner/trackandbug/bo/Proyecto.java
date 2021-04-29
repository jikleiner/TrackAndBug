package com.josekleiner.trackandbug.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROYECTOS")
public class Proyecto {

	@Id
	@GeneratedValue
	private Long idProyecto;
	private String nombreProyecto;
	@OneToOne
	private Usuario UsuarioResponsable;
	@OneToMany(mappedBy = "proyecto")
	private List<Tarea> tareasProyecto = new ArrayList<Tarea>();
	@ManyToMany
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private Long horasAsignadas;
	
	public Long getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public Usuario getUsuarioResponsable() {
		return UsuarioResponsable;
	}
	public void setUsuarioResponsable(Usuario usuarioResponsable) {
		UsuarioResponsable = usuarioResponsable;
	}
	public List<Tarea> getTareasProyecto() {
		return tareasProyecto;
	}
	public void setTareasProyecto(List<Tarea> tareasProyecto) {
		this.tareasProyecto = tareasProyecto;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Long getHorasAsignadas() {
		return horasAsignadas;
	}
	public void setHorasAsignadas(Long horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProyecto == null) ? 0 : idProyecto.hashCode());
		result = prime * result + ((nombreProyecto == null) ? 0 : nombreProyecto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		if (idProyecto == null) {
			if (other.idProyecto != null)
				return false;
		} else if (!idProyecto.equals(other.idProyecto))
			return false;
		if (nombreProyecto == null) {
			if (other.nombreProyecto != null)
				return false;
		} else if (!nombreProyecto.equals(other.nombreProyecto))
			return false;
		return true;
	}
	
}
