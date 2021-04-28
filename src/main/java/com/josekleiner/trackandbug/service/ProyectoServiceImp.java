package com.josekleiner.trackandbug.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josekleiner.trackandbug.bo.Proyecto;
import com.josekleiner.trackandbug.bo.Tarea;
import com.josekleiner.trackandbug.dto.ProyectoDTO;
import com.josekleiner.trackandbug.dto.TareaDTO;
import com.josekleiner.trackandbug.repository.ProyectoRepository;

@Service
@Transactional
public class ProyectoServiceImp implements ProyectoService {

	@Autowired
	private ProyectoRepository proyectoRepository;
	
	@Override
	public Long altaProyecto(ProyectoDTO pro) {
		Proyecto proyecto = new Proyecto();
		proyecto.setNombreProyecto(pro.getNombreProyecto());
		proyecto.setHorasAsignadas(pro.getHorasAsignadas());
		proyectoRepository.save(proyecto);
		return proyecto.getIdProyecto();
	}

	@Override
	public List<TareaDTO> verTareasProyecto(Long idProyecto) {
		Proyecto proyecto = extracted(idProyecto);
		List<TareaDTO> tareas = new ArrayList<TareaDTO>();
		for (Tarea tarea : proyecto.getTareasProyecto()) {
			tareas.add(new TareaDTO(tarea));
		}
		return tareas;
	}

	@Override
	public Long verHorasAsignadasProyecto(Long proyectoId) {
		Proyecto proyecto = extracted(proyectoId);
		ProyectoDTO proDto = new ProyectoDTO(proyecto);
		return proDto.getHorasAsignadas();
	}

	@Override
	public ProyectoDTO buscarProyectoPorId(Long proyectoId) {
		Proyecto proyecto = extracted(proyectoId);
		ProyectoDTO proyectoDto = new ProyectoDTO(proyecto);
		return proyectoDto;
	}
	
	@Override
	public List<ProyectoDTO> buscarProyectos() {
		Iterable<Proyecto> resultado = proyectoRepository.findAll();
		List<ProyectoDTO> proyectos = new ArrayList<ProyectoDTO>();
		for (Proyecto proyecto : resultado) {
			proyectos.add(new ProyectoDTO(proyecto));
		}
		return proyectos;
	}
	
	//	METODO REFACTORIZADO PARA BUSCAR PROYECTO
	private Proyecto extracted(Long proyectoId) {
		Optional<Proyecto> pr = proyectoRepository.findById(proyectoId);
		Proyecto proyecto = pr.get();
		return proyecto;
	}

}
