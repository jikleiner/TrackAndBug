package com.josekleiner.trackandbug.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josekleiner.trackandbug.dto.ProyectoDTO;
import com.josekleiner.trackandbug.service.ProyectoService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoRest {
	
	@Autowired
	private ProyectoService proyectoService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<ProyectoDTO> buscarProyectoPorId(@PathVariable Long id) {
		ProyectoDTO proyecto = proyectoService.buscarProyectoPorId(id);
		return ResponseEntity.ok(proyecto);
	}
	
	@GetMapping
	public ResponseEntity<List<ProyectoDTO>> buscarProyectos() {
		List<ProyectoDTO> proyectos = proyectoService.buscarProyectos();
		return ResponseEntity.ok(proyectos);
	}
	
	@PostMapping
	public ResponseEntity<ProyectoDTO> altaProyecto(@RequestBody ProyectoDTO proyecto) {
		proyectoService.altaProyecto(proyecto);
		return ResponseEntity.status(HttpStatus.CREATED).body(proyecto);
	}
	
	/*
	@PutMapping
	public ResponseEntity modificarProyecto(@RequestBody ProyectoDTO proyecto) {
		proyectoService.
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity eliminarProyecto(@PathVariable Long id) {
		proyectoService.
	}
	*/
}
