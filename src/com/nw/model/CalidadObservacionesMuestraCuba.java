package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calidad_observaciones_muestra_cuba database table.
 * 
 */
@Entity
@Table(name="calidad_observaciones_muestra_cuba")
@NamedQuery(name="CalidadObservacionesMuestraCuba.findAll", query="SELECT c FROM CalidadObservacionesMuestraCuba c")
public class CalidadObservacionesMuestraCuba implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcalidadobservacion;
	private String abreviatura;
	private Integer calificacion;
	private String descripcion;
	private Integer estado;
	private double valordesde;
	private double valorhasta;
	private CalidadGrupoObservacionesMuestraCuba calidadGrupoObservacionesMuestraCuba;
	private CalidadTipoObservacion calidadTipoObservacion;

	public CalidadObservacionesMuestraCuba() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdcalidadobservacion() {
		return this.idcalidadobservacion;
	}

	public void setIdcalidadobservacion(Integer idcalidadobservacion) {
		this.idcalidadobservacion = idcalidadobservacion;
	}


	public String getAbreviatura() {
		return this.abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}


	public Integer getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public double getValordesde() {
		return this.valordesde;
	}

	public void setValordesde(double valordesde) {
		this.valordesde = valordesde;
	}


	public double getValorhasta() {
		return this.valorhasta;
	}

	public void setValorhasta(double valorhasta) {
		this.valorhasta = valorhasta;
	}


	//bi-directional many-to-one association to CalidadGrupoObservacionesMuestraCuba
	@ManyToOne
	@JoinColumn(name="idcalidadgrupoobservaciones")
	public CalidadGrupoObservacionesMuestraCuba getCalidadGrupoObservacionesMuestraCuba() {
		return this.calidadGrupoObservacionesMuestraCuba;
	}

	public void setCalidadGrupoObservacionesMuestraCuba(CalidadGrupoObservacionesMuestraCuba calidadGrupoObservacionesMuestraCuba) {
		this.calidadGrupoObservacionesMuestraCuba = calidadGrupoObservacionesMuestraCuba;
	}


	//bi-directional many-to-one association to CalidadTipoObservacion
	@ManyToOne
	@JoinColumn(name="idcalidadtipoobservacion")
	public CalidadTipoObservacion getCalidadTipoObservacion() {
		return this.calidadTipoObservacion;
	}

	public void setCalidadTipoObservacion(CalidadTipoObservacion calidadTipoObservacion) {
		this.calidadTipoObservacion = calidadTipoObservacion;
	}

}