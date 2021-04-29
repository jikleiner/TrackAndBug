package com.josekleiner.trackandbug.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.josekleiner.trackandbug.bo.Tarea;

public interface TareaRepository extends CrudRepository<Tarea, Long>{

	@Query(value = "from Tarea t where t.proyecto.idProyecto = :id")
	public List<Tarea> buscarTareasPorIdProyecto(@Param("id") Long id);
	
	@Query(value = "from Tarea t where t.usuarioAsignado.id = :id")
	public List<Tarea> buscarTareasPorIdUsuario(@Param("id") Long id);
	
}
