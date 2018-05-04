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
@NamedQuery(name="AtcTurno.findAll", query="SELECT a FROM AtcTurno a")
public class AtcTurno implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idatcturno;
	private String nombre;
	private List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos;
	private List<AtcDescongeladoDetalleProcesoTemp> atcDescongeladoDetalleProcesoTemps;
	private List<AtcDescongeladoDetalleProcesoTempIng> atcDescongeladoDetalleProcesoTempIngs;
	private List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas;
	private List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas;
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;
	private List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes;
	private List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs;
	private List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos;
	private List<AtcLimpiezaProceso> atcLimpiezaProcesos;
	private List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs;
	private List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos;
	private List<AtcProduccionDetalleLote> atcProduccionDetalleLotes;

	public AtcTurno() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@OneToMany(mappedBy="atcTurno")
	public List<AtcDescongeladoDetalleProceso> getAtcDescongeladoDetalleProcesos() {
		return this.atcDescongeladoDetalleProcesos;
	}

	public void setAtcDescongeladoDetalleProcesos(List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos) {
		this.atcDescongeladoDetalleProcesos = atcDescongeladoDetalleProcesos;
	}

	public AtcDescongeladoDetalleProceso addAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		getAtcDescongeladoDetalleProcesos().add(atcDescongeladoDetalleProceso);
		atcDescongeladoDetalleProceso.setAtcTurno(this);

		return atcDescongeladoDetalleProceso;
	}

	public AtcDescongeladoDetalleProceso removeAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		getAtcDescongeladoDetalleProcesos().remove(atcDescongeladoDetalleProceso);
		atcDescongeladoDetalleProceso.setAtcTurno(null);

		return atcDescongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to AtcDescongeladoDetalleProcesoTemp
	@OneToMany(mappedBy="atcTurno")
	public List<AtcDescongeladoDetalleProcesoTemp> getAtcDescongeladoDetalleProcesoTemps() {
		return this.atcDescongeladoDetalleProcesoTemps;
	}

	public void setAtcDescongeladoDetalleProcesoTemps(List<AtcDescongeladoDetalleProcesoTemp> atcDescongeladoDetalleProcesoTemps) {
		this.atcDescongeladoDetalleProcesoTemps = atcDescongeladoDetalleProcesoTemps;
	}

	public AtcDescongeladoDetalleProcesoTemp addAtcDescongeladoDetalleProcesoTemp(AtcDescongeladoDetalleProcesoTemp atcDescongeladoDetalleProcesoTemp) {
		getAtcDescongeladoDetalleProcesoTemps().add(atcDescongeladoDetalleProcesoTemp);
		atcDescongeladoDetalleProcesoTemp.setAtcTurno(this);

		return atcDescongeladoDetalleProcesoTemp;
	}

	public AtcDescongeladoDetalleProcesoTemp removeAtcDescongeladoDetalleProcesoTemp(AtcDescongeladoDetalleProcesoTemp atcDescongeladoDetalleProcesoTemp) {
		getAtcDescongeladoDetalleProcesoTemps().remove(atcDescongeladoDetalleProcesoTemp);
		atcDescongeladoDetalleProcesoTemp.setAtcTurno(null);

		return atcDescongeladoDetalleProcesoTemp;
	}


	//bi-directional many-to-one association to AtcDescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="atcTurno")
	public List<AtcDescongeladoDetalleProcesoTempIng> getAtcDescongeladoDetalleProcesoTempIngs() {
		return this.atcDescongeladoDetalleProcesoTempIngs;
	}

	public void setAtcDescongeladoDetalleProcesoTempIngs(List<AtcDescongeladoDetalleProcesoTempIng> atcDescongeladoDetalleProcesoTempIngs) {
		this.atcDescongeladoDetalleProcesoTempIngs = atcDescongeladoDetalleProcesoTempIngs;
	}

	public AtcDescongeladoDetalleProcesoTempIng addAtcDescongeladoDetalleProcesoTempIng(AtcDescongeladoDetalleProcesoTempIng atcDescongeladoDetalleProcesoTempIng) {
		getAtcDescongeladoDetalleProcesoTempIngs().add(atcDescongeladoDetalleProcesoTempIng);
		atcDescongeladoDetalleProcesoTempIng.setAtcTurno(this);

		return atcDescongeladoDetalleProcesoTempIng;
	}

	public AtcDescongeladoDetalleProcesoTempIng removeAtcDescongeladoDetalleProcesoTempIng(AtcDescongeladoDetalleProcesoTempIng atcDescongeladoDetalleProcesoTempIng) {
		getAtcDescongeladoDetalleProcesoTempIngs().remove(atcDescongeladoDetalleProcesoTempIng);
		atcDescongeladoDetalleProcesoTempIng.setAtcTurno(null);

		return atcDescongeladoDetalleProcesoTempIng;
	}


	//bi-directional many-to-one association to AtcEvisceradoDetalleTempPanza
	@OneToMany(mappedBy="atcTurno")
	public List<AtcEvisceradoDetalleTempPanza> getAtcEvisceradoDetalleTempPanzas() {
		return this.atcEvisceradoDetalleTempPanzas;
	}

	public void setAtcEvisceradoDetalleTempPanzas(List<AtcEvisceradoDetalleTempPanza> atcEvisceradoDetalleTempPanzas) {
		this.atcEvisceradoDetalleTempPanzas = atcEvisceradoDetalleTempPanzas;
	}

	public AtcEvisceradoDetalleTempPanza addAtcEvisceradoDetalleTempPanza(AtcEvisceradoDetalleTempPanza atcEvisceradoDetalleTempPanza) {
		getAtcEvisceradoDetalleTempPanzas().add(atcEvisceradoDetalleTempPanza);
		atcEvisceradoDetalleTempPanza.setAtcTurno(this);

		return atcEvisceradoDetalleTempPanza;
	}

	public AtcEvisceradoDetalleTempPanza removeAtcEvisceradoDetalleTempPanza(AtcEvisceradoDetalleTempPanza atcEvisceradoDetalleTempPanza) {
		getAtcEvisceradoDetalleTempPanzas().remove(atcEvisceradoDetalleTempPanza);
		atcEvisceradoDetalleTempPanza.setAtcTurno(null);

		return atcEvisceradoDetalleTempPanza;
	}


	//bi-directional many-to-one association to AtcEvisceradoTempPanza
	@OneToMany(mappedBy="atcTurno")
	public List<AtcEvisceradoTempPanza> getAtcEvisceradoTempPanzas() {
		return this.atcEvisceradoTempPanzas;
	}

	public void setAtcEvisceradoTempPanzas(List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas) {
		this.atcEvisceradoTempPanzas = atcEvisceradoTempPanzas;
	}

	public AtcEvisceradoTempPanza addAtcEvisceradoTempPanza(AtcEvisceradoTempPanza atcEvisceradoTempPanza) {
		getAtcEvisceradoTempPanzas().add(atcEvisceradoTempPanza);
		atcEvisceradoTempPanza.setAtcTurno(this);

		return atcEvisceradoTempPanza;
	}

	public AtcEvisceradoTempPanza removeAtcEvisceradoTempPanza(AtcEvisceradoTempPanza atcEvisceradoTempPanza) {
		getAtcEvisceradoTempPanzas().remove(atcEvisceradoTempPanza);
		atcEvisceradoTempPanza.setAtcTurno(null);

		return atcEvisceradoTempPanza;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcTurno")
	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public AtcLimpiezaDetalleBandeja addAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().add(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcTurno(this);

		return atcLimpiezaDetalleBandeja;
	}

	public AtcLimpiezaDetalleBandeja removeAtcLimpiezaDetalleBandeja(AtcLimpiezaDetalleBandeja atcLimpiezaDetalleBandeja) {
		getAtcLimpiezaDetalleBandejas().remove(atcLimpiezaDetalleBandeja);
		atcLimpiezaDetalleBandeja.setAtcTurno(null);

		return atcLimpiezaDetalleBandeja;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="atcTurno")
	public List<AtcLimpiezaDetalleProcesoLote> getAtcLimpiezaDetalleProcesoLotes() {
		return this.atcLimpiezaDetalleProcesoLotes;
	}

	public void setAtcLimpiezaDetalleProcesoLotes(List<AtcLimpiezaDetalleProcesoLote> atcLimpiezaDetalleProcesoLotes) {
		this.atcLimpiezaDetalleProcesoLotes = atcLimpiezaDetalleProcesoLotes;
	}

	public AtcLimpiezaDetalleProcesoLote addAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		getAtcLimpiezaDetalleProcesoLotes().add(atcLimpiezaDetalleProcesoLote);
		atcLimpiezaDetalleProcesoLote.setAtcTurno(this);

		return atcLimpiezaDetalleProcesoLote;
	}

	public AtcLimpiezaDetalleProcesoLote removeAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		getAtcLimpiezaDetalleProcesoLotes().remove(atcLimpiezaDetalleProcesoLote);
		atcLimpiezaDetalleProcesoLote.setAtcTurno(null);

		return atcLimpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleTempAguaLav
	@OneToMany(mappedBy="atcTurno")
	public List<AtcLimpiezaDetalleTempAguaLav> getAtcLimpiezaDetalleTempAguaLavs() {
		return this.atcLimpiezaDetalleTempAguaLavs;
	}

	public void setAtcLimpiezaDetalleTempAguaLavs(List<AtcLimpiezaDetalleTempAguaLav> atcLimpiezaDetalleTempAguaLavs) {
		this.atcLimpiezaDetalleTempAguaLavs = atcLimpiezaDetalleTempAguaLavs;
	}

	public AtcLimpiezaDetalleTempAguaLav addAtcLimpiezaDetalleTempAguaLav(AtcLimpiezaDetalleTempAguaLav atcLimpiezaDetalleTempAguaLav) {
		getAtcLimpiezaDetalleTempAguaLavs().add(atcLimpiezaDetalleTempAguaLav);
		atcLimpiezaDetalleTempAguaLav.setAtcTurno(this);

		return atcLimpiezaDetalleTempAguaLav;
	}

	public AtcLimpiezaDetalleTempAguaLav removeAtcLimpiezaDetalleTempAguaLav(AtcLimpiezaDetalleTempAguaLav atcLimpiezaDetalleTempAguaLav) {
		getAtcLimpiezaDetalleTempAguaLavs().remove(atcLimpiezaDetalleTempAguaLav);
		atcLimpiezaDetalleTempAguaLav.setAtcTurno(null);

		return atcLimpiezaDetalleTempAguaLav;
	}


	//bi-directional many-to-one association to AtcLimpiezaDetalleTempLomo
	@OneToMany(mappedBy="atcTurno")
	public List<AtcLimpiezaDetalleTempLomo> getAtcLimpiezaDetalleTempLomos() {
		return this.atcLimpiezaDetalleTempLomos;
	}

	public void setAtcLimpiezaDetalleTempLomos(List<AtcLimpiezaDetalleTempLomo> atcLimpiezaDetalleTempLomos) {
		this.atcLimpiezaDetalleTempLomos = atcLimpiezaDetalleTempLomos;
	}

	public AtcLimpiezaDetalleTempLomo addAtcLimpiezaDetalleTempLomo(AtcLimpiezaDetalleTempLomo atcLimpiezaDetalleTempLomo) {
		getAtcLimpiezaDetalleTempLomos().add(atcLimpiezaDetalleTempLomo);
		atcLimpiezaDetalleTempLomo.setAtcTurno(this);

		return atcLimpiezaDetalleTempLomo;
	}

	public AtcLimpiezaDetalleTempLomo removeAtcLimpiezaDetalleTempLomo(AtcLimpiezaDetalleTempLomo atcLimpiezaDetalleTempLomo) {
		getAtcLimpiezaDetalleTempLomos().remove(atcLimpiezaDetalleTempLomo);
		atcLimpiezaDetalleTempLomo.setAtcTurno(null);

		return atcLimpiezaDetalleTempLomo;
	}


	//bi-directional many-to-one association to AtcLimpiezaProceso
	@OneToMany(mappedBy="atcTurno")
	public List<AtcLimpiezaProceso> getAtcLimpiezaProcesos() {
		return this.atcLimpiezaProcesos;
	}

	public void setAtcLimpiezaProcesos(List<AtcLimpiezaProceso> atcLimpiezaProcesos) {
		this.atcLimpiezaProcesos = atcLimpiezaProcesos;
	}

	public AtcLimpiezaProceso addAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		getAtcLimpiezaProcesos().add(atcLimpiezaProceso);
		atcLimpiezaProceso.setAtcTurno(this);

		return atcLimpiezaProceso;
	}

	public AtcLimpiezaProceso removeAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		getAtcLimpiezaProcesos().remove(atcLimpiezaProceso);
		atcLimpiezaProceso.setAtcTurno(null);

		return atcLimpiezaProceso;
	}


	//bi-directional many-to-one association to AtcLimpiezaTempAguaLav
	@OneToMany(mappedBy="atcTurno")
	public List<AtcLimpiezaTempAguaLav> getAtcLimpiezaTempAguaLavs() {
		return this.atcLimpiezaTempAguaLavs;
	}

	public void setAtcLimpiezaTempAguaLavs(List<AtcLimpiezaTempAguaLav> atcLimpiezaTempAguaLavs) {
		this.atcLimpiezaTempAguaLavs = atcLimpiezaTempAguaLavs;
	}

	public AtcLimpiezaTempAguaLav addAtcLimpiezaTempAguaLav(AtcLimpiezaTempAguaLav atcLimpiezaTempAguaLav) {
		getAtcLimpiezaTempAguaLavs().add(atcLimpiezaTempAguaLav);
		atcLimpiezaTempAguaLav.setAtcTurno(this);

		return atcLimpiezaTempAguaLav;
	}

	public AtcLimpiezaTempAguaLav removeAtcLimpiezaTempAguaLav(AtcLimpiezaTempAguaLav atcLimpiezaTempAguaLav) {
		getAtcLimpiezaTempAguaLavs().remove(atcLimpiezaTempAguaLav);
		atcLimpiezaTempAguaLav.setAtcTurno(null);

		return atcLimpiezaTempAguaLav;
	}


	//bi-directional many-to-one association to AtcLimpiezaTempLomo
	@OneToMany(mappedBy="atcTurno")
	public List<AtcLimpiezaTempLomo> getAtcLimpiezaTempLomos() {
		return this.atcLimpiezaTempLomos;
	}

	public void setAtcLimpiezaTempLomos(List<AtcLimpiezaTempLomo> atcLimpiezaTempLomos) {
		this.atcLimpiezaTempLomos = atcLimpiezaTempLomos;
	}

	public AtcLimpiezaTempLomo addAtcLimpiezaTempLomo(AtcLimpiezaTempLomo atcLimpiezaTempLomo) {
		getAtcLimpiezaTempLomos().add(atcLimpiezaTempLomo);
		atcLimpiezaTempLomo.setAtcTurno(this);

		return atcLimpiezaTempLomo;
	}

	public AtcLimpiezaTempLomo removeAtcLimpiezaTempLomo(AtcLimpiezaTempLomo atcLimpiezaTempLomo) {
		getAtcLimpiezaTempLomos().remove(atcLimpiezaTempLomo);
		atcLimpiezaTempLomo.setAtcTurno(null);

		return atcLimpiezaTempLomo;
	}


	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@OneToMany(mappedBy="atcTurno")
	public List<AtcProduccionDetalleLote> getAtcProduccionDetalleLotes() {
		return this.atcProduccionDetalleLotes;
	}

	public void setAtcProduccionDetalleLotes(List<AtcProduccionDetalleLote> atcProduccionDetalleLotes) {
		this.atcProduccionDetalleLotes = atcProduccionDetalleLotes;
	}

	public AtcProduccionDetalleLote addAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		getAtcProduccionDetalleLotes().add(atcProduccionDetalleLote);
		atcProduccionDetalleLote.setAtcTurno(this);

		return atcProduccionDetalleLote;
	}

	public AtcProduccionDetalleLote removeAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		getAtcProduccionDetalleLotes().remove(atcProduccionDetalleLote);
		atcProduccionDetalleLote.setAtcTurno(null);

		return atcProduccionDetalleLote;
	}

}