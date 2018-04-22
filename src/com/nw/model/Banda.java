package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the banda database table.
 * 
 */
@Entity
public class Banda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idbanda;

	private String descripcionbanda;

	//bi-directional many-to-one association to CajonDetalleBarcoDescarga
	@OneToMany(mappedBy="banda")
	private List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas;

	//bi-directional many-to-one association to CamaraDetalleBanda
	@OneToMany(mappedBy="banda")
	private List<CamaraDetalleBanda> camaraDetalleBandas;

	public Banda() {
	}

	public Long getIdbanda() {
		return this.idbanda;
	}

	public void setIdbanda(Long idbanda) {
		this.idbanda = idbanda;
	}

	public String getDescripcionbanda() {
		return this.descripcionbanda;
	}

	public void setDescripcionbanda(String descripcionbanda) {
		this.descripcionbanda = descripcionbanda;
	}

	public List<CajonDetalleBarcoDescarga> getCajonDetalleBarcoDescargas() {
		return this.cajonDetalleBarcoDescargas;
	}

	public void setCajonDetalleBarcoDescargas(List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas) {
		this.cajonDetalleBarcoDescargas = cajonDetalleBarcoDescargas;
	}

	public List<CamaraDetalleBanda> getCamaraDetalleBandas() {
		return this.camaraDetalleBandas;
	}

	public void setCamaraDetalleBandas(List<CamaraDetalleBanda> camaraDetalleBandas) {
		this.camaraDetalleBandas = camaraDetalleBandas;
	}

}