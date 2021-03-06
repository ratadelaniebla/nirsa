package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medio database table.
 * 
 */
@Entity
@NamedQuery(name="Medio.findAll", query="SELECT m FROM Medio m")
public class Medio implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idmedio;
	private String descripcion;
	private List<CalidadIncidencia> calidadIncidencias;

	public Medio() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadIncidencia
	@OneToMany(mappedBy="medio")
	public List<CalidadIncidencia> getCalidadIncidencias() {
		return this.calidadIncidencias;
	}

	public void setCalidadIncidencias(List<CalidadIncidencia> calidadIncidencias) {
		this.calidadIncidencias = calidadIncidencias;
	}

	public CalidadIncidencia addCalidadIncidencia(CalidadIncidencia calidadIncidencia) {
		getCalidadIncidencias().add(calidadIncidencia);
		calidadIncidencia.setMedio(this);

		return calidadIncidencia;
	}

	public CalidadIncidencia removeCalidadIncidencia(CalidadIncidencia calidadIncidencia) {
		getCalidadIncidencias().remove(calidadIncidencia);
		calidadIncidencia.setMedio(null);

		return calidadIncidencia;
	}

}