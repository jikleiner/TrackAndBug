package com.josekleiner.trackandbug.service;

import java.util.List;

import com.josekleiner.trackandbug.dto.ProyectoDTO;
import com.josekleiner.trackandbug.dto.TareaDTO;

public interface ProyectoService {

	public Long altaProyecto(ProyectoDTO pro);
	public List<TareaDTO> verTareasProyecto(Long idProyecto);
	public Long verHorasAsignadasProyecto(Long proyectoId);
	public ProyectoDTO buscarProyectoPorId(Long proyectoId);
	public List<ProyectoDTO> buscarProyectos();
	
}
