package com.josekleiner.trackandbug.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO_TAREAS")
public class EstadoTarea {

	@Id
	@GeneratedValue
	private Long idEstado;
	private String descripcionEstado;
	
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcionEstado == null) ? 0 : descripcionEstado.hashCode());
		result = prime * result + ((idEstado == null) ? 0 : idEstado.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoTarea other = (EstadoTarea) obj;
		if (descripcionEstado == null) {
			if (other.descripcionEstado != null)
				return false;
		} else if (!descripcionEstado.equals(other.descripcionEstado))
			return false;
		if (idEstado == null) {
			if (other.idEstado != null)
				return false;
		} else if (!idEstado.equals(other.idEstado))
			return false;
		return true;
	}
	
	
}
