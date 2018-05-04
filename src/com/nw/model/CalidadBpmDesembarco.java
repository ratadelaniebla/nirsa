package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_bpm_desembarco database table.
 * 
 */
@Entity
@Table(name="calidad_bpm_desembarco")
@NamedQuery(name="CalidadBpmDesembarco.findAll", query="SELECT c FROM CalidadBpmDesembarco c")
public class CalidadBpmDesembarco implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idbpmdesembarco;
	private Integer estado;
	private Timestamp fecha;
	private String observaciones;
	private BarcoDescarga barcoDescarga;

	public CalidadBpmDesembarco() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdbpmdesembarco() {
		return this.idbpmdesembarco;
	}

	public void setIdbpmdesembarco(Long idbpmdesembarco) {
		this.idbpmdesembarco = idbpmdesembarco;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
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