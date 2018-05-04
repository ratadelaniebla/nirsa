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
@NamedQuery(name="CalidadGrupoBpmclasificacion.findAll", query="SELECT c FROM CalidadGrupoBpmclasificacion c")
public class CalidadGrupoBpmclasificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idgrupobpmclasificacion;
	private String nombre;
	private List<CalidadPreguntaBpmclasificacion> calidadPreguntaBpmclasificacions;

	public CalidadGrupoBpmclasificacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadPreguntaBpmclasificacion
	@OneToMany(mappedBy="calidadGrupoBpmclasificacion")
	public List<CalidadPreguntaBpmclasificacion> getCalidadPreguntaBpmclasificacions() {
		return this.calidadPreguntaBpmclasificacions;
	}

	public void setCalidadPreguntaBpmclasificacions(List<CalidadPreguntaBpmclasificacion> calidadPreguntaBpmclasificacions) {
		this.calidadPreguntaBpmclasificacions = calidadPreguntaBpmclasificacions;
	}

	public CalidadPreguntaBpmclasificacion addCalidadPreguntaBpmclasificacion(CalidadPreguntaBpmclasificacion calidadPreguntaBpmclasificacion) {
		getCalidadPreguntaBpmclasificacions().add(calidadPreguntaBpmclasificacion);
		calidadPreguntaBpmclasificacion.setCalidadGrupoBpmclasificacion(this);

		return calidadPreguntaBpmclasificacion;
	}

	public CalidadPreguntaBpmclasificacion removeCalidadPreguntaBpmclasificacion(CalidadPreguntaBpmclasificacion calidadPreguntaBpmclasificacion) {
		getCalidadPreguntaBpmclasificacions().remove(calidadPreguntaBpmclasificacion);
		calidadPreguntaBpmclasificacion.setCalidadGrupoBpmclasificacion(null);

		return calidadPreguntaBpmclasificacion;
	}

}