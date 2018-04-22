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
public class CalidadGrupoObservacionesMuestraCuba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcalidadgrupoobservaciones;

	private String descripcion;

	//bi-directional many-to-one association to CalidadObservacionesMuestraCuba
	@OneToMany(mappedBy="calidadGrupoObservacionesMuestraCuba")
	private List<CalidadObservacionesMuestraCuba> calidadObservacionesMuestraCubas;

	public CalidadGrupoObservacionesMuestraCuba() {
	}

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

	public List<CalidadObservacionesMuestraCuba> getCalidadObservacionesMuestraCubas() {
		return this.calidadObservacionesMuestraCubas;
	}

	public void setCalidadObservacionesMuestraCubas(List<CalidadObservacionesMuestraCuba> calidadObservacionesMuestraCubas) {
		this.calidadObservacionesMuestraCubas = calidadObservacionesMuestraCubas;
	}

}