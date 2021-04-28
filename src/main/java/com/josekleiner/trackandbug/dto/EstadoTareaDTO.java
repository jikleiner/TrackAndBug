package com.josekleiner.trackandbug.dto;

import com.josekleiner.trackandbug.bo.EstadoTarea;

public class EstadoTareaDTO {

	private Long idEstado;
	private String descripcionEstado;
	
	public EstadoTareaDTO(EstadoTarea estadoTarea) {
		this.idEstado = estadoTarea.getIdEstado();
		this.descripcionEstado = estadoTarea.getDescripcionEstado();
	}

	public EstadoTareaDTO() {
		
	}
	
	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	
	
}
