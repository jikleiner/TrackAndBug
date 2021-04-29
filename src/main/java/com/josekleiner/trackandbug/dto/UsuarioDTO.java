package com.josekleiner.trackandbug.dto;

import com.josekleiner.trackandbug.bo.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nombre;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
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

}
