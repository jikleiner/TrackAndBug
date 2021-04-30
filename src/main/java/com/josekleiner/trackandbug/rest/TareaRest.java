package com.josekleiner.trackandbug.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josekleiner.trackandbug.bo.Tarea;
import com.josekleiner.trackandbug.dto.TareaDTO;
import com.josekleiner.trackandbug.service.TareaService;

@RestController
@RequestMapping("/tareas")
public class TareaRest {
	
	@Autowired
	private TareaService tareaService;

	@GetMapping
	public ResponseEntity<List<TareaDTO>> listarTareas(){
		List<Tarea> tareas = tareaService.mostrarTareas();
		List<TareaDTO> tareasRes = new ArrayList<TareaDTO>();
		for (Tarea tarea : tareas) {
			tareasRes.add(new TareaDTO(tarea));
		}
		return ResponseEntity.ok(tareasRes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TareaDTO> mostrarTareaPorId(@PathVariable Long id){
		TareaDTO tarea = tareaService.buscarTareaPorId(id);
		return ResponseEntity.ok(tarea);
	}
	@PutMapping("/{id}estado{idEstado}")
	public ResponseEntity<TareaDTO> cambiarEstadoDeTarea(@PathVariable Long id, @PathVariable Long idEstado){
		TareaDTO tarea = tareaService.modificarEstadoTarea(id, idEstado);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(tarea);
	}
	@PutMapping("/{id}usuario/{idUsuario}")
	public ResponseEntity<TareaDTO> cambiarUsuarioAsignado(@PathVariable Long id, @PathVariable Long idUsuario){
		TareaDTO tarea = tareaService.asignarUsuarioATarea(id, idUsuario);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(tarea);
	}
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity eliminarTarea(@PathVariable Long id) {
		tareaService.borrarTarea(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}
