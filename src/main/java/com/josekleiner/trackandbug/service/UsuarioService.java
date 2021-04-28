package com.josekleiner.trackandbug.service;

import java.util.List;

import com.josekleiner.trackandbug.dto.ComentarioDTO;
import com.josekleiner.trackandbug.dto.UsuarioDTO;

public interface UsuarioService {

	public List<UsuarioDTO> mostrarUsuarios();
	public void cargarComentario(ComentarioDTO comentario);
	public UsuarioDTO buscarUsuarioPorId(Long idUsuario);

}
