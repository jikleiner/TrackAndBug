package com.josekleiner.trackandbug.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josekleiner.trackandbug.bo.Usuario;
import com.josekleiner.trackandbug.dto.ComentarioDTO;
import com.josekleiner.trackandbug.dto.TareaDTO;
import com.josekleiner.trackandbug.dto.UsuarioDTO;
import com.josekleiner.trackandbug.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRest {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> buscarUsuarios(){
		List<Usuario> usuarios = usuarioService.mostrarUsuarios();
		List<UsuarioDTO> usuariosRes = new ArrayList<UsuarioDTO>();
		for (Usuario usuario : usuarios) {
			usuariosRes.add(new UsuarioDTO(usuario));
		}
		return ResponseEntity.ok(usuariosRes);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<UsuarioDTO> buscarUsuarioId(@PathVariable Long id){
		UsuarioDTO usuario = usuarioService.buscarUsuarioPorId(id);
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Long> altaUsuario(@RequestBody UsuarioDTO usuario){
		usuarioService.altaUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario.getId());
	}
	
	@GetMapping(path = "/{id}tareas")
	public ResponseEntity<List<TareaDTO>> verTareasUsuario(@PathVariable Long id){
		List<TareaDTO> tareas = usuarioService.verTareas(id);
		return ResponseEntity.ok(tareas);
	}
	
	@PostMapping(path = "/{idUsuario}tareas{idTarea}/cargarcomentario")
	public ResponseEntity<ComentarioDTO> cargarComentarioTareaUsuario(@PathVariable Long idUsuario, 
			@PathVariable Long idTarea, @RequestBody ComentarioDTO comentario){
		ComentarioDTO comment = usuarioService.cargarComentario(idTarea, idUsuario, comentario);
		return ResponseEntity.status(HttpStatus.CREATED).body(comment);
	}
}
