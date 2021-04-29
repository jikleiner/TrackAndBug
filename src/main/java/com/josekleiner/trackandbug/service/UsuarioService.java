package com.josekleiner.trackandbug.service;

import java.util.List;

import com.josekleiner.trackandbug.dto.ComentarioDTO;
import com.josekleiner.trackandbug.dto.TareaDTO;
import com.josekleiner.trackandbug.dto.UsuarioDTO;

public interface UsuarioService {

	public List<UsuarioDTO> mostrarUsuarios();
	public ComentarioDTO cargarComentario(Long idTarea, Long idUsuario, ComentarioDTO comentario);
	public UsuarioDTO buscarUsuarioPorId(Long idUsuario);
	public Long altaUsuario(UsuarioDTO usuario);
	public List<TareaDTO> verTareas(Long idUsuario);

}
