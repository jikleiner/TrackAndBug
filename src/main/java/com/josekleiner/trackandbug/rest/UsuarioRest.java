package com.josekleiner.trackandbug.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josekleiner.trackandbug.dto.UsuarioDTO;
import com.josekleiner.trackandbug.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRest {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> buscarUsuarios(){
		List<UsuarioDTO> usuarios = usuarioService.mostrarUsuarios();
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<UsuarioDTO> buscarUsuarioId(@PathVariable Long id){
		UsuarioDTO usuario = usuarioService.buscarUsuarioPorId(id);
		return ResponseEntity.ok(usuario);
	}
	
}
