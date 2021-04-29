package com.josekleiner.trackandbug.service;

import java.util.List;

import com.josekleiner.trackandbug.bo.Comentario;
import com.josekleiner.trackandbug.bo.Usuario;
import com.josekleiner.trackandbug.dto.ComentarioDTO;
import com.josekleiner.trackandbug.dto.TareaDTO;
import com.josekleiner.trackandbug.dto.UsuarioDTO;

public interface UsuarioService {

	public List<UsuarioDTO> mostrarUsuarios();
	public ComentarioDTO cargarComentario(Long idTarea, Long idUsuario, Comentario comentario);
	public UsuarioDTO buscarUsuarioPorId(Long idUsuario);
	public Long altaUsuario(Usuario usuario);
	public List<TareaDTO> verTareas(Long idUsuario);

}
