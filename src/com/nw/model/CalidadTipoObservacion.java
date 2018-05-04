package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_tipo_observacion database table.
 * 
 */
@Entity
@Table(name="calidad_tipo_observacion")
@NamedQuery(name="CalidadTipoObservacion.findAll", query="SELECT c FROM CalidadTipoObservacion c")
public class CalidadTipoObservacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcalidadtipoobservacion;
	private String descripcion;
	private List<CalidadObservacionesMuestraCuba> calidadObservacionesMuestraCubas;

	public CalidadTipoObservacion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdcalidadtipoobservacion() {
		return this.idcalidadtipoobservacion;
	}

	public void setIdcalidadtipoobservacion(Integer idcalidadtipoobservacion) {
		this.idcalidadtipoobservacion = idcalidadtipoobservacion;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to CalidadObservacionesMuestraCuba
	@OneToMany(mappedBy="calidadTipoObservacion")
	public List<CalidadObservacionesMuestraCuba> getCalidadObservacionesMuestraCubas() {
		return this.calidadObservacionesMuestraCubas;
	}

	public void setCalidadObservacionesMuestraCubas(List<CalidadObservacionesMuestraCuba> calidadObservacionesMuestraCubas) {
		this.calidadObservacionesMuestraCubas = calidadObservacionesMuestraCubas;
	}

	public CalidadObservacionesMuestraCuba addCalidadObservacionesMuestraCuba(CalidadObservacionesMuestraCuba calidadObservacionesMuestraCuba) {
		getCalidadObservacionesMuestraCubas().add(calidadObservacionesMuestraCuba);
		calidadObservacionesMuestraCuba.setCalidadTipoObservacion(this);

		return calidadObservacionesMuestraCuba;
	}

	public CalidadObservacionesMuestraCuba removeCalidadObservacionesMuestraCuba(CalidadObservacionesMuestraCuba calidadObservacionesMuestraCuba) {
		getCalidadObservacionesMuestraCubas().remove(calidadObservacionesMuestraCuba);
		calidadObservacionesMuestraCuba.setCalidadTipoObservacion(null);

		return calidadObservacionesMuestraCuba;
	}

}