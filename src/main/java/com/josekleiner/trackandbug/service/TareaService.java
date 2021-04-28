package com.josekleiner.trackandbug.service;

import com.josekleiner.trackandbug.dto.TareaDTO;

public interface TareaService {

	public Long altaTarea(TareaDTO tarea);
	public Long asignarTareaProyecto(Long idTarea, Long idProyecto);
	public Long quitarTareaProyecto(Long idTarea, Long idProyecto);
	public TareaDTO buscarTareaPorId(Long idTarea);
	public boolean borrarTarea(Long idTarea);
	public void modificarEstadoTarea(Long idTarea, Long idEstado);
	
}
