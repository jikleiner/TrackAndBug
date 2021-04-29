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
import com.josekleiner.trackandbug.dto.TareaDTO;
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
	public ComentarioDTO cargarComentario(Long idTarea, Long idUsuario, Comentario comentario) {
		Comentario comentarioNuevo = new Comentario();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		Tarea tarea = tareaRepository.findById(idTarea).get();
		comentarioNuevo.setCuerpoComentario(comentario.getCuerpoComentario());
		comentarioNuevo.setFecha(LocalDate.now());
		comentarioNuevo.setUsuario(usuario);
		comentarioNuevo.setTarea(tarea);
		ComentarioDTO coment = new ComentarioDTO(comentarioNuevo);
		comentarioRepository.save(comentarioNuevo);
		return coment;
	}

	@Override
	public UsuarioDTO buscarUsuarioPorId(Long idUsuario) {
		UsuarioDTO usuario = new UsuarioDTO(usuarioRepository.findById(idUsuario).get());
		return usuario;
	}

	@Override
	public Long altaUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario.getId();
	}

	@Override
	public List<TareaDTO> verTareas(Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		List<Tarea> tareas = usuario.getTareas();
		List<TareaDTO> tareasDto = new ArrayList<TareaDTO>(); 
		for (Tarea tarea : tareas) {
			tareasDto.add(new TareaDTO(tarea));
		}
		return tareasDto;
	}

}
