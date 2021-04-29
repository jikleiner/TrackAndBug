package com.josekleiner.trackandbug.dto;

import com.josekleiner.trackandbug.bo.Tarea;

public class TareaDTO {

	private Long idTarea;
	private Long idTipoTarea;
	private String tipoTarea;
	private Long idEstadoTarea;
	private String estadoTarea;
	private UsuarioDTO usuarioDTO;
	private Long duracion;
	
	
	public TareaDTO(Tarea tarea) {
		this.idTarea = tarea.getIdTarea();
		if (tarea.getEstado()!=null) {
			this.idEstadoTarea = tarea.getEstado().getIdEstado();
			this.estadoTarea = tarea.getEstado().getDescripcionEstado();
		}
		if (tarea.getTipo()!=null) {
			this.idTipoTarea = tarea.getTipo().getIdTipo();
			this.tipoTarea = tarea.getTipo().getDescripcionTipo();
		}
		if (tarea.getUsuarioAsignado()!=null) {
			this.usuarioDTO = new UsuarioDTO(tarea.getUsuarioAsignado());
		}
		this.duracion = tarea.getDuracion();
	}

	public TareaDTO() {
		
	}

	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public Long getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public String getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	public Long getIdEstadoTarea() {
		return idEstadoTarea;
	}

	public void setIdEstadoTarea(Long idEstadoTarea) {
		this.idEstadoTarea = idEstadoTarea;
	}

	public String getEstadoTarea() {
		return estadoTarea;
	}

	public void setEstadoTarea(String estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public Long getDuracion() {
		return duracion;
	}

	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}


}
