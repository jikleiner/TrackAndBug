package com.josekleiner.trackandbug.dto;

import com.josekleiner.trackandbug.bo.TipoTarea;

public class TipoTareaDTO {

	private Long idTipo;
	private String descripcionTipo;
	
	public TipoTareaDTO(TipoTarea tipo) {
		this.idTipo = tipo.getIdTipo();
		this.descripcionTipo = tipo.getDescripcionTipo();
	}

	public TipoTareaDTO() {
		
	}

	public Long getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcionTipo() {
		return descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}
	
}
