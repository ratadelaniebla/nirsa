package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the barco_cuba database table.
 * 
 */
@Entity
@Table(name="barco_cuba")
public class BarcoCuba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idbarcocuba;

	//bi-directional many-to-one association to Barco
	@ManyToOne
	@JoinColumn(name="idbarco")
	private Barco barco;

	//bi-directional many-to-one association to Cuba
	@ManyToOne
	@JoinColumn(name="idcuba")
	private Cuba cuba;

	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="barcoCuba")
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;

	public BarcoCuba() {
	}

	public Long getIdbarcocuba() {
		return this.idbarcocuba;
	}

	public void setIdbarcocuba(Long idbarcocuba) {
		this.idbarcocuba = idbarcocuba;
	}

	public Barco getBarco() {
		return this.barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public Cuba getCuba() {
		return this.cuba;
	}

	public void setCuba(Cuba cuba) {
		this.cuba = cuba;
	}

	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

}