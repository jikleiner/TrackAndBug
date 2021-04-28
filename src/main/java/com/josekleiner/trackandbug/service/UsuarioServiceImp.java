package com.josekleiner.trackandbug.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josekleiner.trackandbug.bo.Comentario;
import com.josekleiner.trackandbug.bo.Tarea;
import com.josekleiner.trackandbug.bo.Usuario;
import com.josekleiner.trackandbug.dto.ComentarioDTO;
import com.josekleiner.trackandbug.dto.UsuarioDTO;
import com.josekleiner.trackandbug.repository.ComentarioRepository;
import com.josekleiner.trackandbug.repository.TareaRepository;
import com.josekleiner.trackandbug.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private TareaRepository tareaRepository;

	@Override
	public List<UsuarioDTO> mostrarUsuarios() {
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		Iterable<Usuario> lista = usuarioRepository.findAll();
		for (Usuario usuario : lista) {
			usuarios.add(new UsuarioDTO(usuario));
		}
		return usuarios;
	}

	@Override
	public void cargarComentario(ComentarioDTO comentarioDto) {
		Comentario comentario = new Comentario();
		Usuario usuario = usuarioRepository.findById(comentarioDto.getIdUsuario()).get();
		Tarea tarea = tareaRepository.findById(comentarioDto.getIdTarea()).get();
		comentario.setCuerpoComentario(comentarioDto.getCuerpoComentario());
		comentario.setFecha(LocalDate.now());
		comentario.setUsuario(usuario);
		comentario.setTarea(tarea);
		comentarioRepository.save(comentario);
	}

	@Override
	public UsuarioDTO buscarUsuarioPorId(Long idUsuario) {
		UsuarioDTO usuario = new UsuarioDTO(usuarioRepository.findById(idUsuario).get());
		return usuario;
	}

}
