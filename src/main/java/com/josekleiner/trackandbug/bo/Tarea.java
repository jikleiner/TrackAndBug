package com.josekleiner.trackandbug.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAREAS")
public class Tarea {

	@Id
	@GeneratedValue
	private Long idTarea;
	private Long duracion;
	@ManyToOne
	private TipoTarea tipo;
	@ManyToOne
	private EstadoTarea estado;
	@OneToMany(mappedBy = "tarea")
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	@ManyToOne
	private Usuario usuarioAsignado;
	@ManyToOne
	private Proyecto proyecto;
	
	public Long getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}
	public TipoTarea getTipo() {
		return tipo;
	}
	public void setTipo(TipoTarea tipo) {
		this.tipo = tipo;
	}
	public EstadoTarea getEstado() {
		return estado;
	}
	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public Usuario getUsuarioAsignado() {
		return usuarioAsignado;
	}
	public void setUsuarioAsignado(Usuario usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public Long getDuracion() {
		return duracion;
	}
	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTarea == null) ? 0 : idTarea.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Tarea other = (Tarea) obj;
		if (idTarea == null) {
			if (other.idTarea != null)
				return false;
		} else if (!idTarea.equals(other.idTarea))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	
	
}
