package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calidad_sensorial_mp database table.
 * 
 */
@Entity
@Table(name="calidad_sensorial_mp")
@NamedQuery(name="CalidadSensorialMp.findAll", query="SELECT c FROM CalidadSensorialMp c")
public class CalidadSensorialMp implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadsensorialmp;
	private Integer estado;
	private String observaciones;
	private BarcoDescarga barcoDescarga;

	public CalidadSensorialMp() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidadsensorialmp() {
		return this.idcalidadsensorialmp;
	}

	public void setIdcalidadsensorialmp(Long idcalidadsensorialmp) {
		this.idcalidadsensorialmp = idcalidadsensorialmp;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}

}