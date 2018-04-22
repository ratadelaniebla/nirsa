package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_numero_muestreo_pcc database table.
 * 
 */
@Entity
@Table(name="calidad_numero_muestreo_pcc")
public class CalidadNumeroMuestreoPcc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcalidadnumeromuestreopcc;

	private String descripcion;

	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="calidadNumeroMuestreoPcc")
	private List<CalidadDetallePcc> calidadDetallePccs;

	public CalidadNumeroMuestreoPcc() {
	}

	public Integer getIdcalidadnumeromuestreopcc() {
		return this.idcalidadnumeromuestreopcc;
	}

	public void setIdcalidadnumeromuestreopcc(Integer idcalidadnumeromuestreopcc) {
		this.idcalidadnumeromuestreopcc = idcalidadnumeromuestreopcc;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CalidadDetallePcc> getCalidadDetallePccs() {
		return this.calidadDetallePccs;
	}

	public void setCalidadDetallePccs(List<CalidadDetallePcc> calidadDetallePccs) {
		this.calidadDetallePccs = calidadDetallePccs;
	}

}