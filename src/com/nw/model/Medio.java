package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medio database table.
 * 
 */
@Entity
public class Medio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idmedio;

	private String descripcion;

	//bi-directional many-to-one association to CalidadIncidencia
	@OneToMany(mappedBy="medio")
	private List<CalidadIncidencia> calidadIncidencias;

	public Medio() {
	}

	public Integer getIdmedio() {
		return this.idmedio;
	}

	public void setIdmedio(Integer idmedio) {
		this.idmedio = idmedio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CalidadIncidencia> getCalidadIncidencias() {
		return this.calidadIncidencias;
	}

	public void setCalidadIncidencias(List<CalidadIncidencia> calidadIncidencias) {
		this.calidadIncidencias = calidadIncidencias;
	}

}