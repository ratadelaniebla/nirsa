package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calidad_aprobacion_descarga_cuba database table.
 * 
 */
@Entity
@Table(name="calidad_aprobacion_descarga_cuba")
@NamedQuery(name="CalidadAprobacionDescargaCuba.findAll", query="SELECT c FROM CalidadAprobacionDescargaCuba c")
public class CalidadAprobacionDescargaCuba implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadaprobaciondescargacuba;
	private String observacion;
	private BarcoEstibaCuba barcoEstibaCuba;

	public CalidadAprobacionDescargaCuba() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
	}

}