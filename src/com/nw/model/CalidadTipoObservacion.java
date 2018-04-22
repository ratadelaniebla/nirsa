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
public class CalidadTipoObservacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcalidadtipoobservacion;

	private String descripcion;

	//bi-directional many-to-one association to CalidadObservacionesMuestraCuba
	@OneToMany(mappedBy="calidadTipoObservacion")
	private List<CalidadObservacionesMuestraCuba> calidadObservacionesMuestraCubas;

	public CalidadTipoObservacion() {
	}

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

	public List<CalidadObservacionesMuestraCuba> getCalidadObservacionesMuestraCubas() {
		return this.calidadObservacionesMuestraCubas;
	}

	public void setCalidadObservacionesMuestraCubas(List<CalidadObservacionesMuestraCuba> calidadObservacionesMuestraCubas) {
		this.calidadObservacionesMuestraCubas = calidadObservacionesMuestraCubas;
	}

}