package com.josekleiner.trackandbug.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josekleiner.trackandbug.bo.Proyecto;
import com.josekleiner.trackandbug.bo.Tarea;
import com.josekleiner.trackandbug.bo.Usuario;
import com.josekleiner.trackandbug.dto.ProyectoDTO;
import com.josekleiner.trackandbug.dto.TareaDTO;
import com.josekleiner.trackandbug.repository.ProyectoRepository;
import com.josekleiner.trackandbug.repository.UsuarioRepository;

@Service
@Transactional
public class ProyectoServiceImp implements ProyectoService {

	@Autowired
	private ProyectoRepository proyectoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Long altaProyecto(Proyecto pro) {
		proyectoRepository.save(pro);
		return pro.getIdProyecto();
	}

	@Override
	public List<TareaDTO> verTareasProyecto(Long idProyecto) {
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		List<TareaDTO> tareas = new ArrayList<TareaDTO>();
		for (Tarea tarea : proyecto.getTareasProyecto()) {
			tareas.add(new TareaDTO(tarea));
		}
		return tareas;
	}

	@Override
	public Long verHorasAsignadasProyecto(Long proyectoId) {
		Proyecto proyecto = proyectoRepository.findById(proyectoId).get();
		ProyectoDTO proDto = new ProyectoDTO(proyecto);
		return proDto.getHorasAsignadas();
	}

	@Override
	public ProyectoDTO buscarProyectoPorId(Long proyectoId) {
		Proyecto proyecto = proyectoRepository.findById(proyectoId).get();
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
	
	@Override
	public Long asignarUsuarioResponsable(Long idProyecto, Long idUsuario) {
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		Usuario usuario = usuarioRepository.findById(idUsuario).get(); 
		proyecto.setUsuarioResponsable(usuario);
		proyectoRepository.save(proyecto);
		return usuario.getId();
	}

}
