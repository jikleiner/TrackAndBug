package com.josekleiner.trackandbug.viewcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.josekleiner.trackandbug.dto.UsuarioDTO;
import com.josekleiner.trackandbug.service.ProyectoService;
import com.josekleiner.trackandbug.service.UsuarioService;

@Controller
public class MainController {
	
	@Autowired
	private ProyectoService proyectoService;
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String principal(){
		return "principal";
	}
	
	@GetMapping("/project")
	public String proyectos(){
		return "proyectos";
	}
	
	@GetMapping("/users")
	public String usuarios() {
		return "usuarios";
	}
	
	@GetMapping("/users/{id}")
	public UsuarioDTO mostrarUsuario(Long id) {
		UsuarioDTO user = usuarioService.buscarUsuarioPorId(id);
		return user;
	}
	
}
