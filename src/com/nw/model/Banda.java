package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the banda database table.
 * 
 */
@Entity
@NamedQuery(name="Banda.findAll", query="SELECT b FROM Banda b")
public class Banda implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idbanda;
	private String descripcionbanda;
	private List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas;
	private List<CamaraDetalleBanda> camaraDetalleBandas;

	public Banda() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CajonDetalleBarcoDescarga
	@OneToMany(mappedBy="banda")
	public List<CajonDetalleBarcoDescarga> getCajonDetalleBarcoDescargas() {
		return this.cajonDetalleBarcoDescargas;
	}

	public void setCajonDetalleBarcoDescargas(List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas) {
		this.cajonDetalleBarcoDescargas = cajonDetalleBarcoDescargas;
	}

	public CajonDetalleBarcoDescarga addCajonDetalleBarcoDescarga(CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga) {
		getCajonDetalleBarcoDescargas().add(cajonDetalleBarcoDescarga);
		cajonDetalleBarcoDescarga.setBanda(this);

		return cajonDetalleBarcoDescarga;
	}

	public CajonDetalleBarcoDescarga removeCajonDetalleBarcoDescarga(CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga) {
		getCajonDetalleBarcoDescargas().remove(cajonDetalleBarcoDescarga);
		cajonDetalleBarcoDescarga.setBanda(null);

		return cajonDetalleBarcoDescarga;
	}


	//bi-directional many-to-one association to CamaraDetalleBanda
	@OneToMany(mappedBy="banda")
	public List<CamaraDetalleBanda> getCamaraDetalleBandas() {
		return this.camaraDetalleBandas;
	}

	public void setCamaraDetalleBandas(List<CamaraDetalleBanda> camaraDetalleBandas) {
		this.camaraDetalleBandas = camaraDetalleBandas;
	}

	public CamaraDetalleBanda addCamaraDetalleBanda(CamaraDetalleBanda camaraDetalleBanda) {
		getCamaraDetalleBandas().add(camaraDetalleBanda);
		camaraDetalleBanda.setBanda(this);

		return camaraDetalleBanda;
	}

	public CamaraDetalleBanda removeCamaraDetalleBanda(CamaraDetalleBanda camaraDetalleBanda) {
		getCamaraDetalleBandas().remove(camaraDetalleBanda);
		camaraDetalleBanda.setBanda(null);

		return camaraDetalleBanda;
	}

}