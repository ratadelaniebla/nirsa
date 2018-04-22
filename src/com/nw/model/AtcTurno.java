package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atc_turno database table.
 * 
 */
@Entity
@Table(name="atc_turno")
public class AtcTurno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idatcturno;

	private String nombre;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@OneToMany(mappedBy="atcTurno")
	private List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProcesoTemp
	@OneToMany(mappedBy="atcTurno")
	private List<AtcDescongeladoDetalleProcesoTemp> atcDescongeladoDetalleProcesoTemps;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="atcTurno")
	private List<AtcDescongeladoDetalleProcesoTempIng> atcDescongeladoDetalleProcesoTempIngs;

	//bi-directional many-to-one association to AtcEvisceradoDetalleTempPanza
	@OneToMany(mappedBy="atcTurno")
	private List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas;

	//bi-directional many-to-one association to AtcEvisceradoTempPanza
	@OneToMany(mappedBy="atcTurno")
	private List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas;

	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcTurno")
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;

	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="atcTurno")
	private List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes;

	//bi-directional many-to-one association to AtcLimpiezaDetalleTempAguaLav
	@OneToMany(mappedBy="atcTurno")
	private List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs;

	//bi-directional many-to-one association to AtcLimpiezaDetalleTempLomo
	@OneToMany(mappedBy="atcTurno")
	private List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos;

	//bi-directional many-to-one association to AtcLimpiezaProceso
	@OneToMany(mappedBy="atcTurno")
	private List<AtcLimpiezaProceso> atcLimpiezaProcesos;

	//bi-directional many-to-one association to AtcLimpiezaTempAguaLav
	@OneToMany(mappedBy="atcTurno")
	private List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs;

	//bi-directional many-to-one association to AtcLimpiezaTempLomo
	@OneToMany(mappedBy="atcTurno")
	private List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos;

	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@OneToMany(mappedBy="atcTurno")
	private List<AtcProduccionDetalleLote> atcProduccionDetalleLotes;

	public AtcTurno() {
	}

	public Integer getIdatcturno() {
		return this.idatcturno;
	}

	public void setIdatcturno(Integer idatcturno) {
		this.idatcturno = idatcturno;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AtcDescongeladoDetalleProceso> getAtcDescongeladoDetalleProcesos() {
		return this.atcDescongeladoDetalleProcesos;
	}

	public void setAtcDescongeladoDetalleProcesos(List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos) {
		this.atcDescongeladoDetalleProcesos = atcDescongeladoDetalleProcesos;
	}

	public List<AtcDescongeladoDetalleProcesoTemp> getAtcDescongeladoDetalleProcesoTemps() {
		return this.atcDescongeladoDetalleProcesoTemps;
	}

	public void setAtcDescongeladoDetalleProcesoTemps(List<AtcDescongeladoDetalleProcesoTemp> atcDescongeladoDetalleProcesoTemps) {
		this.atcDescongeladoDetalleProcesoTemps = atcDescongeladoDetalleProcesoTemps;
	}

	public List<AtcDescongeladoDetalleProcesoTempIng> getAtcDescongeladoDetalleProcesoTempIngs() {
		return this.atcDescongeladoDetalleProcesoTempIngs;
	}

	public void setAtcDescongeladoDetalleProcesoTempIngs(List<AtcDescongeladoDetalleProcesoTempIng> atcDescongeladoDetalleProcesoTempIngs) {
		this.atcDescongeladoDetalleProcesoTempIngs = atcDescongeladoDetalleProcesoTempIngs;
	}

	public List<AtcEvisceradoDetalleTempPanza> getAtcEvisceradoDetalleTempPanzas() {
		return this.atcEvisceradoDetalleTempPanzas;
	}

	public void setAtcEvisceradoDetalleTempPanzas(List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas) {
		this.atcEvisceradoDetalleTempPanzas = atcEvisceradoDetalleTempPanzas;
	}

	public List<AtcEvisceradoTempPanza> getAtcEvisceradoTempPanzas() {
		return this.atcEvisceradoTempPanzas;
	}

	public void setAtcEvisceradoTempPanzas(List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas) {
		this.atcEvisceradoTempPanzas = atcEvisceradoTempPanzas;
	}

	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public List<AtcLimpiezaDetalleProcesoLote> getAtcLimpiezaDetalleProcesoLotes() {
		return this.atcLimpiezaDetalleProcesoLotes;
	}

	public void setAtcLimpiezaDetalleProcesoLotes(List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes) {
		this.atcLimpiezaDetalleProcesoLotes = atcLimpiezaDetalleProcesoLotes;
	}

	public List<AtcLimpiezaDetalleTempAguaLav> getAtcLimpiezaDetalleTempAguaLavs() {
		return this.atcLimpiezaDetalleTempAguaLavs;
	}

	public void setAtcLimpiezaDetalleTempAguaLavs(List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs) {
		this.atcLimpiezaDetalleTempAguaLavs = atcLimpiezaDetalleTempAguaLavs;
	}

	public List<AtcLimpiezaDetalleTempLomo> getAtcLimpiezaDetalleTempLomos() {
		return this.atcLimpiezaDetalleTempLomos;
	}

	public void setAtcLimpiezaDetalleTempLomos(List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos) {
		this.atcLimpiezaDetalleTempLomos = atcLimpiezaDetalleTempLomos;
	}

	public List<AtcLimpiezaProceso> getAtcLimpiezaProcesos() {
		return this.atcLimpiezaProcesos;
	}

	public void setAtcLimpiezaProcesos(List<AtcLimpiezaProceso> atcLimpiezaProcesos) {
		this.atcLimpiezaProcesos = atcLimpiezaProcesos;
	}

	public List<AtcLimpiezaTempAguaLav> getAtcLimpiezaTempAguaLavs() {
		return this.atcLimpiezaTempAguaLavs;
	}

	public void setAtcLimpiezaTempAguaLavs(List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs) {
		this.atcLimpiezaTempAguaLavs = atcLimpiezaTempAguaLavs;
	}

	public List<AtcLimpiezaTempLomo> getAtcLimpiezaTempLomos() {
		return this.atcLimpiezaTempLomos;
	}

	public void setAtcLimpiezaTempLomos(List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos) {
		this.atcLimpiezaTempLomos = atcLimpiezaTempLomos;
	}

	public List<AtcProduccionDetalleLote> getAtcProduccionDetalleLotes() {
		return this.atcProduccionDetalleLotes;
	}

	public void setAtcProduccionDetalleLotes(List<AtcProduccionDetalleLote> atcProduccionDetalleLotes) {
		this.atcProduccionDetalleLotes = atcProduccionDetalleLotes;
	}

}