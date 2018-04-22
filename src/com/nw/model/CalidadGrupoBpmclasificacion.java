package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_grupo_bpmclasificacion database table.
 * 
 */
@Entity
@Table(name="calidad_grupo_bpmclasificacion")
public class CalidadGrupoBpmclasificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idgrupobpmclasificacion;

	private String nombre;

	//bi-directional many-to-one association to CalidadPreguntaBpmclasificacion
	@OneToMany(mappedBy="calidadGrupoBpmclasificacion")
	private List<CalidadPreguntaBpmclasificacion> calidadPreguntaBpmclasificacions;

	public CalidadGrupoBpmclasificacion() {
	}

	public Integer getIdgrupobpmclasificacion() {
		return this.idgrupobpmclasificacion;
	}

	public void setIdgrupobpmclasificacion(Integer idgrupobpmclasificacion) {
		this.idgrupobpmclasificacion = idgrupobpmclasificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<CalidadPreguntaBpmclasificacion> getCalidadPreguntaBpmclasificacions() {
		return this.calidadPreguntaBpmclasificacions;
	}

	public void setCalidadPreguntaBpmclasificacions(List<CalidadPreguntaBpmclasificacion> calidadPreguntaBpmclasificacions) {
		this.calidadPreguntaBpmclasificacions = calidadPreguntaBpmclasificacions;
	}

}