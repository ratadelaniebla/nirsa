package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calidad_aprobacion_descarga_cuba database table.
 * 
 */
@Entity
@Table(name="calidad_aprobacion_descarga_cuba")
public class CalidadAprobacionDescargaCuba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadaprobaciondescargacuba;

	private String observacion;

	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	private BarcoEstibaCuba barcoEstibaCuba;

	public CalidadAprobacionDescargaCuba() {
	}

	public Long getIdcalidadaprobaciondescargacuba() {
		return this.idcalidadaprobaciondescargacuba;
	}

	public void setIdcalidadaprobaciondescargacuba(Long idcalidadaprobaciondescargacuba) {
		this.idcalidadaprobaciondescargacuba = idcalidadaprobaciondescargacuba;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
	}

}