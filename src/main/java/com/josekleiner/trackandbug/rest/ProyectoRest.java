package com.josekleiner.trackandbug.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josekleiner.trackandbug.bo.Proyecto;
import com.josekleiner.trackandbug.dto.ComentarioDTO;
import com.josekleiner.trackandbug.dto.ProyectoDTO;
import com.josekleiner.trackandbug.dto.TareaDTO;
import com.josekleiner.trackandbug.service.ProyectoService;
import com.josekleiner.trackandbug.service.TareaService;

@RestController
@RequestMapping("/proyectos")
public class ProyectoRest {
	
	@Autowired
	private ProyectoService proyectoService;
	@Autowired
	private TareaService tareaService;

	//	POST - PUT - GET DE PROYECTOS
	@GetMapping(path = "/{id}")
	public ResponseEntity<ProyectoDTO> buscarProyectoPorId(@PathVariable Long id) {
		ProyectoDTO proyecto = proyectoService.buscarProyectoPorId(id);
		return ResponseEntity.ok(proyecto);
	}
	@GetMapping
	public ResponseEntity<List<ProyectoDTO>> buscarProyectos() {
		List<Proyecto> proyectos = proyectoService.buscarProyectos();
		List<ProyectoDTO> proyectosRes = new ArrayList<ProyectoDTO>();
		for (Proyecto proyecto : proyectos) {
			proyectosRes.add(new ProyectoDTO(proyecto));
		}
		return ResponseEntity.ok(proyectosRes);
	}
	@PostMapping
	public ResponseEntity<Long> altaProyecto(@RequestBody ProyectoDTO proyecto) {
		proyectoService.altaProyecto(proyecto);
		return ResponseEntity.status(HttpStatus.CREATED).body(proyecto.getIdProyecto());
	}
	@PutMapping(path="/{id}/usuarioresponsable")
	public ResponseEntity<Long> asignarResponsableProyecto(@PathVariable Long id, @RequestParam Long usuario) {
		proyectoService.asignarUsuarioResponsable(id, usuario);
		return ResponseEntity.ok(id);
	}
	
	//	POST - PUT - GET - DELETE DE TAREAS
	@PostMapping(path="/{id}/tareas")
	public ResponseEntity<Long> altaTareas(@PathVariable Long id, @RequestParam Long idTipo, 
			@RequestParam Long idEstado, @RequestBody TareaDTO tarea) {
		TareaDTO tareaRes = tareaService.altaTarea(id, tarea.getDuracion(), idTipo, idEstado);
		return ResponseEntity.status(HttpStatus.CREATED).body(tareaRes.getIdTarea());
	}
	@GetMapping(path="/{id}/tareas")
	public ResponseEntity<List<TareaDTO>> verTareasProyecto(@PathVariable Long id) {
		List<TareaDTO> tareas = tareaService.buscarTareasPorProyecto(id);
		return ResponseEntity.ok(tareas);	
	}
	@PutMapping(path="/{idProyecto}/tareas/{idTarea}")
	public ResponseEntity<Long> cargarUsuarioTarea(@PathVariable Long idProyecto, @PathVariable Long idTarea, 
			@RequestParam Long idUsuario){
		Long resultado = tareaService.asignarUsuarioATarea(idProyecto, idTarea, idUsuario);
		return ResponseEntity.ok(resultado);	
	}
	@GetMapping(path="/{idProyecto}/tareas/{idTarea}/comentarios")
	public ResponseEntity<List<ComentarioDTO>> mostrarComentariosTarea(@PathVariable Long idProyecto, 
			@PathVariable Long idTarea){
		List<ComentarioDTO> comentarios = tareaService.mostrarComentariosDeTarea(idTarea);
		return ResponseEntity.ok(comentarios);
	}
	@GetMapping(path="/{idProyecto}/tiempo")
	public ResponseEntity<Long> mostrarTiempoProyecto(@PathVariable Long idProyecto){
		Long res = proyectoService.verHorasAsignadasProyecto(idProyecto);
		return ResponseEntity.ok(res);
	}
}
