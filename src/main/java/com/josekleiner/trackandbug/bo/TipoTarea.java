package com.josekleiner.trackandbug.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_TAREAS")
public class TipoTarea {

	@Id
	@GeneratedValue
	private Long idTipo;
	private String descripcionTipo;
	
	public Long getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripcionTipo() {
		return descripcionTipo;
	}
	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcionTipo == null) ? 0 : descripcionTipo.hashCode());
		result = prime * result + ((idTipo == null) ? 0 : idTipo.hashCode());
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
		TipoTarea other = (TipoTarea) obj;
		if (descripcionTipo == null) {
			if (other.descripcionTipo != null)
				return false;
		} else if (!descripcionTipo.equals(other.descripcionTipo))
			return false;
		if (idTipo == null) {
			if (other.idTipo != null)
				return false;
		} else if (!idTipo.equals(other.idTipo))
			return false;
		return true;
	}
	
	
}
