package com.josekleiner.trackandbug.dto;

import java.time.LocalDate;

import com.josekleiner.trackandbug.bo.Comentario;

public class ComentarioDTO {

	private Long idComentario;
	private Long idTarea;
	private Long IdUsuario;
	private String nombreUsuario;
	private String cuerpoComentario;
	private LocalDate fecha;
	
	public ComentarioDTO(Comentario comentario) {
		this.idComentario = comentario.getIdComentario();
		if (comentario.getTarea()!=null) {
			this.idTarea = comentario.getTarea().getIdTarea();
		}
		if (comentario.getUsuario()!=null) {
			this.IdUsuario = comentario.getUsuario().getId();
			this.nombreUsuario = comentario.getUsuario().getNombre();
		}
		this.cuerpoComentario = comentario.getCuerpoComentario();
		this.fecha = comentario.getFecha();
	}

	public ComentarioDTO() {
		
	}

	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public Long getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
	}

	public Long getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCuerpoComentario() {
		return cuerpoComentario;
	}

	public void setCuerpoComentario(String cuerpoComentario) {
		this.cuerpoComentario = cuerpoComentario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
