package com.josekleiner.trackandbug.viewcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.josekleiner.trackandbug.bo.Proyecto;
import com.josekleiner.trackandbug.bo.Tarea;
import com.josekleiner.trackandbug.bo.Usuario;
import com.josekleiner.trackandbug.service.ProyectoService;
import com.josekleiner.trackandbug.service.TareaService;
import com.josekleiner.trackandbug.service.UsuarioService;

@Controller
public class MainController {
	
	@Autowired
	private ProyectoService proyectoService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TareaService tareaService;
	
	@GetMapping("/")
	public String principal(){
		return "principal";
	}
	
	@GetMapping("/project")
	public String proyectos(Model model){
		List<Proyecto> pro = proyectoService.buscarProyectos();
		model.addAttribute("proyectos", pro);
		return "proyectos";
	}
	
	@GetMapping("/users")
	public String usuarios(Model model) {
		List<Usuario> us = usuarioService.mostrarUsuarios();
		model.addAttribute("usuarios", us);
		return "usuarios";
	}
	
	@GetMapping("/tasks")
	public String tareas(Model model) {
		List<Tarea> ta = tareaService.mostrarTareas();
		model.addAttribute("tareas", ta);
		return "tareas";
	}
	
}
