package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the barco_estiba_cuba database table.
 * 
 */
@Entity
@Table(name="barco_estiba_cuba")
public class BarcoEstibaCuba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idbarcoestibacuba;

	private double capacidad;

	private double cardumenbrisa;

	private double cardumenplantado;

	private Integer estadocombobox;

	private Integer estadodescargacuba;

	private Long idbarcocuba;

	private Long idbarcocubacombinada;

	private Integer zonafao;

	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@OneToMany(mappedBy="barcoEstibaCuba")
	private List<AtcProduccionDetalleLote> atcProduccionDetalleLotes;

	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	private BarcoDescarga barcoDescarga;

	//bi-directional many-to-one association to BarcoEstibaCubaDetalleMezcla
	@OneToMany(mappedBy="barcoEstibaCuba")
	private List<BarcoEstibaCubaDetalleMezcla> barcoEstibaCubaDetalleMezclas;

	//bi-directional many-to-one association to CalidadAprobacionDescargaCuba
	@OneToMany(mappedBy="barcoEstibaCuba")
	private List<CalidadAprobacionDescargaCuba> calidadAprobacionDescargaCubas;

	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="barcoEstibaCuba")
	private List<CalidadDetallePcc> calidadDetallePccs;

	//bi-directional many-to-one association to CalidadDetalleSensorialMp
	@OneToMany(mappedBy="barcoEstibaCuba")
	private List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps;

	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="barcoEstibaCuba")
	private List<CamaraCajon> camaraCajons;

	//bi-directional many-to-one association to CamaraDetalleBanda
	@OneToMany(mappedBy="barcoEstibaCuba")
	private List<CamaraDetalleBanda> camaraDetalleBandas;

	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="barcoEstibaCuba")
	private List<ProduccionDetalleLote> produccionDetalleLotes;

	public BarcoEstibaCuba() {
	}

	public Long getIdbarcoestibacuba() {
		return this.idbarcoestibacuba;
	}

	public void setIdbarcoestibacuba(Long idbarcoestibacuba) {
		this.idbarcoestibacuba = idbarcoestibacuba;
	}

	public double getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	public double getCardumenbrisa() {
		return this.cardumenbrisa;
	}

	public void setCardumenbrisa(double cardumenbrisa) {
		this.cardumenbrisa = cardumenbrisa;
	}

	public double getCardumenplantado() {
		return this.cardumenplantado;
	}

	public void setCardumenplantado(double cardumenplantado) {
		this.cardumenplantado = cardumenplantado;
	}

	public Integer getEstadocombobox() {
		return this.estadocombobox;
	}

	public void setEstadocombobox(Integer estadocombobox) {
		this.estadocombobox = estadocombobox;
	}

	public Integer getEstadodescargacuba() {
		return this.estadodescargacuba;
	}

	public void setEstadodescargacuba(Integer estadodescargacuba) {
		this.estadodescargacuba = estadodescargacuba;
	}

	public Long getIdbarcocuba() {
		return this.idbarcocuba;
	}

	public void setIdbarcocuba(Long idbarcocuba) {
		this.idbarcocuba = idbarcocuba;
	}

	public Long getIdbarcocubacombinada() {
		return this.idbarcocubacombinada;
	}

	public void setIdbarcocubacombinada(Long idbarcocubacombinada) {
		this.idbarcocubacombinada = idbarcocubacombinada;
	}

	public Integer getZonafao() {
		return this.zonafao;
	}

	public void setZonafao(Integer zonafao) {
		this.zonafao = zonafao;
	}

	public List<AtcProduccionDetalleLote> getAtcProduccionDetalleLotes() {
		return this.atcProduccionDetalleLotes;
	}

	public void setAtcProduccionDetalleLotes(List<AtcProduccionDetalleLote> atcProduccionDetalleLotes) {
		this.atcProduccionDetalleLotes = atcProduccionDetalleLotes;
	}

	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}

	public List<BarcoEstibaCubaDetalleMezcla> getBarcoEstibaCubaDetalleMezclas() {
		return this.barcoEstibaCubaDetalleMezclas;
	}

	public void setBarcoEstibaCubaDetalleMezclas(List<BarcoEstibaCubaDetalleMezcla> barcoEstibaCubaDetalleMezclas) {
		this.barcoEstibaCubaDetalleMezclas = barcoEstibaCubaDetalleMezclas;
	}

	public List<CalidadAprobacionDescargaCuba> getCalidadAprobacionDescargaCubas() {
		return this.calidadAprobacionDescargaCubas;
	}

	public void setCalidadAprobacionDescargaCubas(List<CalidadAprobacionDescargaCuba> calidadAprobacionDescargaCubas) {
		this.calidadAprobacionDescargaCubas = calidadAprobacionDescargaCubas;
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

	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public List<CamaraDetalleBanda> getCamaraDetalleBandas() {
		return this.camaraDetalleBandas;
	}

	public void setCamaraDetalleBandas(List<CamaraDetalleBanda> camaraDetalleBandas) {
		this.camaraDetalleBandas = camaraDetalleBandas;
	}

	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

}