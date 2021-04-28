package com.josekleiner.trackandbug.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMENTARIOS")
public class Comentario {

	@Id
	@GeneratedValue
	private Long idComentario;
	@ManyToOne										// ver si corresponde tipo de dato Long o objeto tarea
	private Tarea tarea;
	@ManyToOne
	private Usuario usuario;
	private String cuerpoComentario;
	private LocalDate fecha;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Long getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}
	public Tarea getTarea() {
		return tarea;
	}
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
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
