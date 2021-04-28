package com.josekleiner.trackandbug.dto;

import java.util.ArrayList;
import java.util.List;

import com.josekleiner.trackandbug.bo.Comentario;
import com.josekleiner.trackandbug.bo.Tarea;

public class TareaDTO {

	private Long idTarea;
	private Long idTipoTarea;
	private String tipoTarea;
	private Long idEstadoTarea;
	private String estadoTarea;
	private List<ComentarioDTO> comentariosDTO;
	private Long usuarioAsignadoId;
	private String usuarioAsignadoNombre;
	private String proyectoNombre;
	private Long idProyecto;
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
		if (!tarea.getComentarios().isEmpty()) {
			this.comentariosDTO = new ArrayList<ComentarioDTO>();
			for (Comentario comentario : tarea.getComentarios()) {
				this.comentariosDTO.add(new ComentarioDTO(comentario));
			}
		}
		if (tarea.getUsuarioAsignado()!=null) {
			this.usuarioAsignadoId = tarea.getUsuarioAsignado().getId();
			this.usuarioAsignadoNombre = tarea.getUsuarioAsignado().getNombre();
		}
		if (tarea.getProyecto()!=null) {
			this.idProyecto = tarea.getProyecto().getIdProyecto();
			this.proyectoNombre = tarea.getProyecto().getNombreProyecto();
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

	public String getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	public String getEstadoTarea() {
		return estadoTarea;
	}

	public void setEstadoTarea(String estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	public List<ComentarioDTO> getComentariosDTO() {
		return comentariosDTO;
	}

	public void setComentariosDTO(List<ComentarioDTO> comentariosDTO) {
		this.comentariosDTO = comentariosDTO;
	}

	public Long getUsuarioAsignadoId() {
		return usuarioAsignadoId;
	}

	public void setUsuarioAsignadoId(Long usuarioAsignadoId) {
		this.usuarioAsignadoId = usuarioAsignadoId;
	}

	public String getUsuarioAsignadoNombre() {
		return usuarioAsignadoNombre;
	}

	public void setUsuarioAsignadoNombre(String usuarioAsignadoNombre) {
		this.usuarioAsignadoNombre = usuarioAsignadoNombre;
	}

	public String getProyectoNombre() {
		return proyectoNombre;
	}

	public void setProyectoNombre(String proyectoNombre) {
		this.proyectoNombre = proyectoNombre;
	}

	public Long getDuracion() {
		return duracion;
	}

	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}

	public Long getIdTipoTarea() {
		return idTipoTarea;
	}

	public void setIdTipoTarea(Long idTipoTarea) {
		this.idTipoTarea = idTipoTarea;
	}

	public Long getIdEstadoTarea() {
		return idEstadoTarea;
	}

	public void setIdEstadoTarea(Long idEstadoTarea) {
		this.idEstadoTarea = idEstadoTarea;
	}

	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

}
