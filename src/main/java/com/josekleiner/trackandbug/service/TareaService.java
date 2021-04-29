package com.josekleiner.trackandbug.service;

import java.util.List;

import com.josekleiner.trackandbug.dto.ComentarioDTO;
import com.josekleiner.trackandbug.dto.TareaDTO;

public interface TareaService {

	public TareaDTO altaTarea(Long idProyecto, Long duracion, Long idTipo, Long idEstado);
	public Long quitarTareaProyecto(Long idTarea, Long idProyecto);// ver si cabe sacarlo
	public TareaDTO buscarTareaPorId(Long idTarea);
	public List<TareaDTO> buscarTareasPorProyecto(Long idProyecto);
	public boolean borrarTarea(Long idTarea);
	public void modificarEstadoTarea(Long idTarea, Long idEstado);
	public Long asignarUsuarioATarea(Long idProyecto, Long idTarea, Long idUsuario);
	public List<ComentarioDTO> mostrarComentariosDeTarea (Long idTarea);
	
}
