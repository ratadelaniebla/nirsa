package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_grupo_observaciones_muestra_cuba database table.
 * 
 */
@Entity
@Table(name="calidad_grupo_observaciones_muestra_cuba")
@NamedQuery(name="CalidadGrupoObservacionesMuestraCuba.findAll", query="SELECT c FROM CalidadGrupoObservacionesMuestraCuba c")
public class CalidadGrupoObservacionesMuestraCuba implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcalidadgrupoobservaciones;
	private String descripcion;
	private List<CalidadObservacionesMuestraCuba> calidadObservacionesMuestraCubas;

	public CalidadGrupoObservacionesMuestraCuba() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdcalidadgrupoobservaciones() {
		return this.idcalidadgrupoobservaciones;
	}

	public void setIdcalidadgrupoobservaciones(Integer idcalidadgrupoobservaciones) {
		this.idcalidadgrupoobservaciones = idcalidadgrupoobservaciones;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to CalidadObservacionesMuestraCuba
	@OneToMany(mappedBy="calidadGrupoObservacionesMuestraCuba")
	public List<CalidadObservacionesMuestraCuba> getCalidadObservacionesMuestraCubas() {
		return this.calidadObservacionesMuestraCubas;
	}

	public void setCalidadObservacionesMuestraCubas(List<CalidadObservacionesMuestraCuba> calidadObservacionesMuestraCubas) {
		this.calidadObservacionesMuestraCubas = calidadObservacionesMuestraCubas;
	}

	public CalidadObservacionesMuestraCuba addCalidadObservacionesMuestraCuba(CalidadObservacionesMuestraCuba calidadObservacionesMuestraCuba) {
		getCalidadObservacionesMuestraCubas().add(calidadObservacionesMuestraCuba);
		calidadObservacionesMuestraCuba.setCalidadGrupoObservacionesMuestraCuba(this);

		return calidadObservacionesMuestraCuba;
	}

	public CalidadObservacionesMuestraCuba removeCalidadObservacionesMuestraCuba(CalidadObservacionesMuestraCuba calidadObservacionesMuestraCuba) {
		getCalidadObservacionesMuestraCubas().remove(calidadObservacionesMuestraCuba);
		calidadObservacionesMuestraCuba.setCalidadGrupoObservacionesMuestraCuba(null);

		return calidadObservacionesMuestraCuba;
	}

}