package com.josekleiner.trackandbug.dto;

import com.josekleiner.trackandbug.bo.Proyecto;

public class ProyectoDTO {

	private Long idProyecto;
	private String nombreProyecto;
	private Long usuarioResponsableId;
	private String usuarioResponsableNombre;
	private Long horasAsignadas;
	
	public ProyectoDTO(Proyecto proyecto) {
		this.idProyecto = proyecto.getIdProyecto();
		this.nombreProyecto = proyecto.getNombreProyecto();
		if(proyecto.getUsuarioResponsable()!=null) {
			this.usuarioResponsableId = proyecto.getUsuarioResponsable().getId();
			this.usuarioResponsableNombre = proyecto.getUsuarioResponsable().getNombre();
		}
		this.horasAsignadas = proyecto.getHorasAsignadas();
	}
	
	public ProyectoDTO() {
		
	}

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

	public Long getUsuarioResponsableId() {
		return usuarioResponsableId;
	}

	public void setUsuarioResponsableId(Long usuarioResponsableId) {
		this.usuarioResponsableId = usuarioResponsableId;
	}

	public String getUsuarioResponsableNombre() {
		return usuarioResponsableNombre;
	}

	public void setUsuarioResponsableNombre(String usuarioResponsableNombre) {
		this.usuarioResponsableNombre = usuarioResponsableNombre;
	}

	public Long getHorasAsignadas() {
		return horasAsignadas;
	}

	public void setHorasAsignadas(Long horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}

}
