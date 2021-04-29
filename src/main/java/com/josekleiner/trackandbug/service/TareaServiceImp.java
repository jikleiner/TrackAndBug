package com.josekleiner.trackandbug.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josekleiner.trackandbug.bo.Comentario;
import com.josekleiner.trackandbug.bo.EstadoTarea;
import com.josekleiner.trackandbug.bo.Proyecto;
import com.josekleiner.trackandbug.bo.Tarea;
import com.josekleiner.trackandbug.bo.TipoTarea;
import com.josekleiner.trackandbug.bo.Usuario;
import com.josekleiner.trackandbug.dto.ComentarioDTO;
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
	public TareaDTO altaTarea(Long idProyecto, Long duracion, Long idTipo, Long idEstado) {
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		TareaDTO tareaRetorno;
		if ((proyecto.getHorasAsignadas() - duracion) >= 0) {
			TipoTarea tipo = tipoRepository.findById(idTipo).get();
			EstadoTarea estado = estadoRepository.findById(idEstado).get();
			Tarea tarea = new Tarea();
			tareaRetorno = new TareaDTO(tarea);
			tarea.setDuracion(duracion);
			tarea.setEstado(estado);
			tarea.setTipo(tipo);
			tarea.setProyecto(proyecto);
			proyecto.setHorasAsignadas(proyecto.getHorasAsignadas() - tarea.getDuracion());
			proyectoRepository.save(proyecto);	//	GUARDADO DEL CAMBIO EN LA CATIDAD DE HORAS ASIGNADAS AL PROYECTO
			tarea.setProyecto(proyecto);
			tareaRepository.save(tarea);
		}else {
			tareaRetorno = null;
		}
		return tareaRetorno;
	}
	
	@Override
	public Long quitarTareaProyecto(Long idTarea, Long idProyecto) {
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		Tarea tarea = tareaRepository.findById(idTarea).get();
		proyecto.setHorasAsignadas(proyecto.getHorasAsignadas() + tarea.getDuracion());
		proyectoRepository.save(proyecto);	//	GUARDADO DEL CAMBIO EN LA CATIDAD DE HORAS ASIGNADAS AL PROYECTO
		tarea.setProyecto(null);
		tareaRepository.save(tarea);
		return proyecto.getHorasAsignadas();
	}

	@Override
	public TareaDTO buscarTareaPorId(Long idTarea) {
		Tarea tarea = tareaRepository.findById(idTarea).get();
		TareaDTO tareaDto = new TareaDTO(tarea);
		return tareaDto;
	}

	@Override
	public boolean borrarTarea(Long idTarea) {
		boolean retorno = false;
		Tarea tarea = tareaRepository.findById(idTarea).get();
		Proyecto proyecto = tarea.getProyecto();
		Long correccionHoras = tarea.getDuracion();
		Long horasProyecto = tarea.getProyecto().getHorasAsignadas();
		horasProyecto += correccionHoras;
		proyecto.setHorasAsignadas(horasProyecto);
		proyectoRepository.save(proyecto);
		tareaRepository.deleteById(idTarea);
		if (tareaRepository.existsById(idTarea)) {
			retorno = true;
		}
		return retorno;
	}
	@Override
	public void modificarEstadoTarea(Long idTarea, Long idEstado) {
		Tarea tarea = tareaRepository.findById(idTarea).get();
		// BUSQUEDA DEL ESTADO DE TAREA POR ID
		EstadoTarea estado = estadoRepository.findById(idEstado).get();
		// SET Y SAVE
		tarea.setEstado(estado);
		tareaRepository.save(tarea);
	}
	@Override
	public List<TareaDTO> buscarTareasPorProyecto(Long idProyecto) {
		List<TareaDTO> tareaDTO = new ArrayList<TareaDTO>();
		List<Tarea> tareas = tareaRepository.buscarTareasPorIdProyecto(idProyecto);
		for (Tarea tarea : tareas) {
			tareaDTO.add(new TareaDTO(tarea));
		}
		return tareaDTO;
	}

	@Override
	public Long asignarUsuarioATarea(Long idProyecto, Long idTarea, Long idUsuario) {
		Proyecto proyecto = proyectoRepository.findById(idProyecto).get();
		Tarea tarea = tareaRepository.findById(idTarea).get();
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		Long resultado = 0L;
		if(proyecto.getTareasProyecto().contains(tarea)) {
			tarea.setUsuarioAsignado(usuario);
			tareaRepository.save(tarea);
			resultado = tarea.getUsuarioAsignado().getId();
		}
		return resultado;
	}

	@Override
	public List<ComentarioDTO> mostrarComentariosDeTarea(Long idTarea) {
		Tarea tarea = tareaRepository.findById(idTarea).get();
		List<Comentario> comentarios = tarea.getComentarios();
		List<ComentarioDTO> CommRes = new ArrayList<ComentarioDTO>();
		for (Comentario comentario : comentarios) {
			CommRes.add(new ComentarioDTO(comentario));
		}
		return CommRes;
	}
	
}
