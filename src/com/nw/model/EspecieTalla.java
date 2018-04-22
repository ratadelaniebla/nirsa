package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the especie_talla database table.
 * 
 */
@Entity
@Table(name="especie_talla")
public class EspecieTalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idespecietalla;

	private String descripcion;

	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@OneToMany(mappedBy="especieTalla")
	private List<AtcProduccionDetalleLote> atcProduccionDetalleLotes;

	//bi-directional many-to-one association to CajonDetalleBarcoDescarga
	@OneToMany(mappedBy="especieTalla")
	private List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas;

	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="especieTalla")
	private List<CalidadDetallePcc> calidadDetallePccs;

	//bi-directional many-to-one association to CalidadDetalleSensorialMp
	@OneToMany(mappedBy="especieTalla")
	private List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps;

	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="especieTalla")
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;

	//bi-directional many-to-one association to CalidadEspecietallaCajonBanda
	@OneToMany(mappedBy="especieTalla")
	private List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas;

	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="especieTalla")
	private List<CamaraCajon> camaraCajons;

	//bi-directional many-to-one association to Especie
	@ManyToOne
	@JoinColumn(name="idespecie")
	private Especie especie;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	//bi-directional many-to-one association to EstandarDesperdicioAtun
	@OneToMany(mappedBy="especieTalla")
	private List<EstandarDesperdicioAtun> estandarDesperdicioAtuns;

	//bi-directional many-to-one association to EstandarRendimientoAtun
	@OneToMany(mappedBy="especieTalla")
	private List<EstandarRendimientoAtun> estandarRendimientoAtuns;

	//bi-directional many-to-one association to EstandarRendimientosAtun
	@OneToMany(mappedBy="especieTalla")
	private List<EstandarRendimientosAtun> estandarRendimientosAtuns;

	//bi-directional many-to-one association to GrupoTallaEspecieTalla
	@OneToMany(mappedBy="especieTalla")
	private List<GrupoTallaEspecieTalla> grupoTallaEspecieTallas;

	//bi-directional many-to-one association to LonjasEspecietalla
	@OneToMany(mappedBy="especieTalla")
	private List<LonjasEspecietalla> lonjasEspecietallas;

	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="especieTalla")
	private List<ProduccionDetalleLote> produccionDetalleLotes;

	public EspecieTalla() {
	}

	public Integer getIdespecietalla() {
		return this.idespecietalla;
	}

	public void setIdespecietalla(Integer idespecietalla) {
		this.idespecietalla = idespecietalla;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<AtcProduccionDetalleLote> getAtcProduccionDetalleLotes() {
		return this.atcProduccionDetalleLotes;
	}

	public void setAtcProduccionDetalleLotes(List<AtcProduccionDetalleLote> atcProduccionDetalleLotes) {
		this.atcProduccionDetalleLotes = atcProduccionDetalleLotes;
	}

	public List<CajonDetalleBarcoDescarga> getCajonDetalleBarcoDescargas() {
		return this.cajonDetalleBarcoDescargas;
	}

	public void setCajonDetalleBarcoDescargas(List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas) {
		this.cajonDetalleBarcoDescargas = cajonDetalleBarcoDescargas;
	}

	public List<CalidadDetallePcc> getCalidadDetallePccs() {
		return this.calidadDetallePccs;
	}

	public void setCalidadDetallePccs(List<CalidadDetallePcc> calidadDetallePccs) {
		this.calidadDetallePccs = calidadDetallePccs;
	}

	public List<CalidadDetalleSensorialMp> getCalidadDetalleSensorialMps() {
		return this.calidadDetalleSensorialMps;
	}

	public void setCalidadDetalleSensorialMps(List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps) {
		this.calidadDetalleSensorialMps = calidadDetalleSensorialMps;
	}

	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public List<CalidadEspecietallaCajonBanda> getCalidadEspecietallaCajonBandas() {
		return this.calidadEspecietallaCajonBandas;
	}

	public void setCalidadEspecietallaCajonBandas(List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas) {
		this.calidadEspecietallaCajonBandas = calidadEspecietallaCajonBandas;
	}

	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public Especie getEspecie() {
		return this.especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

	public List<EstandarDesperdicioAtun> getEstandarDesperdicioAtuns() {
		return this.estandarDesperdicioAtuns;
	}

	public void setEstandarDesperdicioAtuns(List<EstandarDesperdicioAtun> estandarDesperdicioAtuns) {
		this.estandarDesperdicioAtuns = estandarDesperdicioAtuns;
	}

	public List<EstandarRendimientoAtun> getEstandarRendimientoAtuns() {
		return this.estandarRendimientoAtuns;
	}

	public void setEstandarRendimientoAtuns(List<EstandarRendimientoAtun> estandarRendimientoAtuns) {
		this.estandarRendimientoAtuns = estandarRendimientoAtuns;
	}

	public List<EstandarRendimientosAtun> getEstandarRendimientosAtuns() {
		return this.estandarRendimientosAtuns;
	}

	public void setEstandarRendimientosAtuns(List<EstandarRendimientosAtun> estandarRendimientosAtuns) {
		this.estandarRendimientosAtuns = estandarRendimientosAtuns;
	}

	public List<GrupoTallaEspecieTalla> getGrupoTallaEspecieTallas() {
		return this.grupoTallaEspecieTallas;
	}

	public void setGrupoTallaEspecieTallas(List<GrupoTallaEspecieTalla> grupoTallaEspecieTallas) {
		this.grupoTallaEspecieTallas = grupoTallaEspecieTallas;
	}

	public List<LonjasEspecietalla> getLonjasEspecietallas() {
		return this.lonjasEspecietallas;
	}

	public void setLonjasEspecietallas(List<LonjasEspecietalla> lonjasEspecietallas) {
		this.lonjasEspecietallas = lonjasEspecietallas;
	}

	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

}