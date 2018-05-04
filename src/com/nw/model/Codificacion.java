package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the codificacion database table.
 * 
 */
@Entity
@NamedQuery(name="Codificacion.findAll", query="SELECT c FROM Codificacion c")
public class Codificacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcodificacion;
	private String codigo;
	private String descripcion;
	private List<CalidadIncidencia> calidadIncidencias;

	public Codificacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadIncidencia
	@OneToMany(mappedBy="codificacion")
	public List<CalidadIncidencia> getCalidadIncidencias() {
		return this.calidadIncidencias;
	}

	public void setCalidadIncidencias(List<CalidadIncidencia> calidadIncidencias) {
		this.calidadIncidencias = calidadIncidencias;
	}

	public CalidadIncidencia addCalidadIncidencia(CalidadIncidencia calidadIncidencia) {
		getCalidadIncidencias().add(calidadIncidencia);
		calidadIncidencia.setCodificacion(this);

		return calidadIncidencia;
	}

	public CalidadIncidencia removeCalidadIncidencia(CalidadIncidencia calidadIncidencia) {
		getCalidadIncidencias().remove(calidadIncidencia);
		calidadIncidencia.setCodificacion(null);

		return calidadIncidencia;
	}

}