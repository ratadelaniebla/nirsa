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
@NamedQuery(name="CalidadNumeroMuestreoPcc.findAll", query="SELECT c FROM CalidadNumeroMuestreoPcc c")
public class CalidadNumeroMuestreoPcc implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcalidadnumeromuestreopcc;
	private String descripcion;
	private List<CalidadDetallePcc> calidadDetallePccs;

	public CalidadNumeroMuestreoPcc() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="calidadNumeroMuestreoPcc")
	public List<CalidadDetallePcc> getCalidadDetallePccs() {
		return this.calidadDetallePccs;
	}

	public void setCalidadDetallePccs(List<CalidadDetallePcc> calidadDetallePccs) {
		this.calidadDetallePccs = calidadDetallePccs;
	}

	public CalidadDetallePcc addCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().add(calidadDetallePcc);
		calidadDetallePcc.setCalidadNumeroMuestreoPcc(this);

		return calidadDetallePcc;
	}

	public CalidadDetallePcc removeCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().remove(calidadDetallePcc);
		calidadDetallePcc.setCalidadNumeroMuestreoPcc(null);

		return calidadDetallePcc;
	}

}