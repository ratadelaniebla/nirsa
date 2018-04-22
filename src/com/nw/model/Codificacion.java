package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the codificacion database table.
 * 
 */
@Entity
public class Codificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcodificacion;

	private String codigo;

	private String descripcion;

	//bi-directional many-to-one association to CalidadIncidencia
	@OneToMany(mappedBy="codificacion")
	private List<CalidadIncidencia> calidadIncidencias;

	public Codificacion() {
	}

	public Integer getIdcodificacion() {
		return this.idcodificacion;
	}

	public void setIdcodificacion(Integer idcodificacion) {
		this.idcodificacion = idcodificacion;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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