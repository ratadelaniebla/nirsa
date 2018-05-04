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
@NamedQuery(name="BarcoCuba.findAll", query="SELECT b FROM BarcoCuba b")
public class BarcoCuba implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idbarcocuba;
	private Barco barco;
	private Cuba cuba;
	private List<BarcoEstibaCuba> barcoEstibaCubas;
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;

	public BarcoCuba() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdbarcocuba() {
		return this.idbarcocuba;
	}

	public void setIdbarcocuba(Long idbarcocuba) {
		this.idbarcocuba = idbarcocuba;
	}


	//bi-directional many-to-one association to Barco
	@ManyToOne
	@JoinColumn(name="idbarco")
	public Barco getBarco() {
		return this.barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}


	//bi-directional many-to-one association to Cuba
	@ManyToOne
	@JoinColumn(name="idcuba")
	public Cuba getCuba() {
		return this.cuba;
	}

	public void setCuba(Cuba cuba) {
		this.cuba = cuba;
	}


	//bi-directional many-to-one association to BarcoEstibaCuba
	@OneToMany(mappedBy="barcoCuba")
	public List<BarcoEstibaCuba> getBarcoEstibaCubas() {
		return this.barcoEstibaCubas;
	}

	public void setBarcoEstibaCubas(List<BarcoEstibaCuba> barcoEstibaCubas) {
		this.barcoEstibaCubas = barcoEstibaCubas;
	}

	public BarcoEstibaCuba addBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		getBarcoEstibaCubas().add(barcoEstibaCuba);
		barcoEstibaCuba.setBarcoCuba(this);

		return barcoEstibaCuba;
	}

	public BarcoEstibaCuba removeBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		getBarcoEstibaCubas().remove(barcoEstibaCuba);
		barcoEstibaCuba.setBarcoCuba(null);

		return barcoEstibaCuba;
	}


	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="barcoCuba")
	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public CalidadDetalleTemperaturaCajonBanda addCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().add(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setBarcoCuba(this);

		return calidadDetalleTemperaturaCajonBanda;
	}

	public CalidadDetalleTemperaturaCajonBanda removeCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().remove(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setBarcoCuba(null);

		return calidadDetalleTemperaturaCajonBanda;
	}

}