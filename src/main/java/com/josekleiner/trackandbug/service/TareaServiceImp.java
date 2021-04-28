package com.josekleiner.trackandbug.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josekleiner.trackandbug.bo.EstadoTarea;
import com.josekleiner.trackandbug.bo.Proyecto;
import com.josekleiner.trackandbug.bo.Tarea;
import com.josekleiner.trackandbug.bo.TipoTarea;
import com.josekleiner.trackandbug.bo.Usuario;
import com.josekleiner.trackandbug.dto.TareaDTO;
import com.josekleiner.trackandbug.repository.EstadoTareaRepository;
import com.josekleiner.trackandbug.repository.ProyectoRepository;
import com.josekleiner.trackandbug.repository.TareaRepository;
import com.josekleiner.trackandbug.repository.TipoTareaRepository;
import com.josekleiner.trackandbug.repository.UsuarioRepository;

@Service
@Transactional
public class TareaServiceImp implements TareaService {
	
	@Autowired
	private TareaRepository tareaRepository;
	@Autowired
	private EstadoTareaRepository estadoRepository;
	@Autowired
	private TipoTareaRepository tipoRepository;
	@Autowired
	private ProyectoRepository proyectoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Long altaTarea(TareaDTO tareaDto) {
		Tarea tarea = new Tarea();
		tarea.setDuracion(tareaDto.getDuracion());
		// BUSQUEDA Y SETEO DEL TIPO DE TAREA POR ID
		TipoTarea tipo = extractedTipo(tareaDto.getIdTipoTarea());
		tarea.setTipo(tipo);
		// BUSQUEDA Y SETEO DEL ESTADO DE TAREA POR ID
		EstadoTarea estado = this.extractedEstado(tareaDto.getIdEstadoTarea());
		tarea.setEstado(estado);
		// BUSQUEDA Y SETEO DE USUARIO POR ID
		Usuario usuario = extractedUsuario(tareaDto.getUsuarioAsignadoId());
		tarea.setUsuarioAsignado(usuario);
		tareaRepository.save(tarea);
		return tarea.getIdTarea();
	}

	@Override
	public Long asignarTareaProyecto(Long idTarea, Long idProyecto) {
		Proyecto proyecto = extractedProyecto(idProyecto);
		Tarea tarea = extractedTarea(idTarea);
		proyecto.setHorasAsignadas(proyecto.getHorasAsignadas() - tarea.getDuracion());
		proyectoRepository.save(proyecto);	//	GUARDADO DEL CAMBIO EN LA CATIDAD DE HORAS ASIGNADAS AL PROYECTO
		tarea.setProyecto(proyecto);
		tareaRepository.save(tarea);
		return proyecto.getHorasAsignadas();
	}
	
	@Override
	public Long quitarTareaProyecto(Long idTarea, Long idProyecto) {
		Proyecto proyecto = extractedProyecto(idProyecto);
		Tarea tarea = extractedTarea(idTarea);
		proyecto.setHorasAsignadas(proyecto.getHorasAsignadas() + tarea.getDuracion());
		proyectoRepository.save(proyecto);	//	GUARDADO DEL CAMBIO EN LA CATIDAD DE HORAS ASIGNADAS AL PROYECTO
		tarea.setProyecto(null);
		tareaRepository.save(tarea);
		return proyecto.getHorasAsignadas();
	}

	@Override
	public TareaDTO buscarTareaPorId(Long idTarea) {
		Tarea tarea = extractedTarea(idTarea);
		TareaDTO tareaDto = new TareaDTO(tarea);
		return tareaDto;
	}

	@Override
	public boolean borrarTarea(Long idTarea) {
		boolean retorno = false;
		tareaRepository.deleteById(idTarea);
		if (tareaRepository.existsById(idTarea)) {
			retorno = true;
		}
		return retorno;
	}
	@Override
	public void modificarEstadoTarea(Long idTarea, Long idEstado) {
		Tarea tarea = extractedTarea(idTarea);
		// BUSQUEDA DEL ESTADO DE TAREA POR ID
		EstadoTarea estado = extractedEstado(idEstado);
		// SET Y SAVE
		tarea.setEstado(estado);
		tareaRepository.save(tarea);
	}

	
	
	//	METODO REFACTORIZADO PARA BUSCAR ESTADO
	private EstadoTarea extractedEstado(Long idEstado) {
		Optional<EstadoTarea> e = estadoRepository.findById(idEstado);
		EstadoTarea estado = e.get();
		return estado;
	}
	//	METODO REFACTORIZADO PARA BUSCAR TAREA
	private Tarea extractedTarea(Long idTarea) {
		Optional<Tarea> tareaOp = tareaRepository.findById(idTarea);
		Tarea tarea = tareaOp.get();
		return tarea;
	}
	//	METODO REFACTORIZADO PARA BUSCAR PROYECTO
	private Proyecto extractedProyecto(Long id) {
		Optional<Proyecto> p = proyectoRepository.findById(id);
		Proyecto proyecto = p.get();
		return proyecto;
	}
	// METODO REFACTORIZADO PARA BUSCAR TIPO
	private TipoTarea extractedTipo(Long id) {
		Optional<TipoTarea> t = tipoRepository.findById(id);
		TipoTarea tipo = t.get();
		return tipo;
	}
	//	METODO REFACTORIZADO PARA BUSCAR USUARIO
	private Usuario extractedUsuario(Long id) {
		Optional<Usuario> u = usuarioRepository.findById(id);
		Usuario usuario = u.get();
		return usuario;
	}
}
