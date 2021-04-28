package com.josekleiner.trackandbug.dto;

import java.util.ArrayList;
import java.util.List;

import com.josekleiner.trackandbug.bo.Tarea;
import com.josekleiner.trackandbug.bo.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nombre;
	private List<TareaDTO> tareas = new ArrayList<TareaDTO>();
	private Long proyectoId;
	private String proyectoNombre;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
		if (usuario.getTareas()!=null) {
			for (Tarea tarea : usuario.getTareas()) {
				this.tareas.add(new TareaDTO(tarea));			
			}
		}
		if (usuario.getProyecto()!=null) {
			this.proyectoId = usuario.getProyecto().getIdProyecto();
			this.proyectoNombre = usuario.getProyecto().getNombreProyecto();
		}
	}
	
	public UsuarioDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<TareaDTO> getTareas() {
		return tareas;
	}

	public void setTareas(List<TareaDTO> tareas) {
		this.tareas = tareas;
	}

	public Long getProyectoId() {
		return proyectoId;
	}

	public void setProyectoId(Long proyectoId) {
		this.proyectoId = proyectoId;
	}

	public String getProyectoNombre() {
		return proyectoNombre;
	}

	public void setProyectoNombre(String proyectoNombre) {
		this.proyectoNombre = proyectoNombre;
	}

}
