package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_eviscerado_proceso database table.
 * 
 */
@Entity
@Table(name="atc_eviscerado_proceso")
@NamedQuery(name="AtcEvisceradoProceso.findAll", query="SELECT a FROM AtcEvisceradoProceso a")
public class AtcEvisceradoProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcevisceradoproceso;
	private Timestamp fechareg;
	private Integer secuenciaidcocheglobal;
	private List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes;
	private AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo;
	private AtcProduccion atcProduccion;
	private List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas;

	public AtcEvisceradoProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatcevisceradoproceso() {
		return this.idatcevisceradoproceso;
	}

	public void setIdatcevisceradoproceso(Long idatcevisceradoproceso) {
		this.idatcevisceradoproceso = idatcevisceradoproceso;
	}


	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}


	public Integer getSecuenciaidcocheglobal() {
		return this.secuenciaidcocheglobal;
	}

	public void setSecuenciaidcocheglobal(Integer secuenciaidcocheglobal) {
		this.secuenciaidcocheglobal = secuenciaidcocheglobal;
	}


	//bi-directional many-to-one association to AtcEvisceradoDetalleProcesoLote
	@OneToMany(mappedBy="atcEvisceradoProceso")
	public List<AtcEvisceradoDetalleProcesoLote> getAtcEvisceradoDetalleProcesoLotes() {
		return this.atcEvisceradoDetalleProcesoLotes;
	}

	public void setAtcEvisceradoDetalleProcesoLotes(List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes) {
		this.atcEvisceradoDetalleProcesoLotes = atcEvisceradoDetalleProcesoLotes;
	}

	public AtcEvisceradoDetalleProcesoLote addAtcEvisceradoDetalleProcesoLote(AtcEvisceradoDetalleProcesoLote atcEvisceradoDetalleProcesoLote) {
		getAtcEvisceradoDetalleProcesoLotes().add(atcEvisceradoDetalleProcesoLote);
		atcEvisceradoDetalleProcesoLote.setAtcEvisceradoProceso(this);

		return atcEvisceradoDetalleProcesoLote;
	}

	public AtcEvisceradoDetalleProcesoLote removeAtcEvisceradoDetalleProcesoLote(AtcEvisceradoDetalleProcesoLote atcEvisceradoDetalleProcesoLote) {
		getAtcEvisceradoDetalleProcesoLotes().remove(atcEvisceradoDetalleProcesoLote);
		atcEvisceradoDetalleProcesoLote.setAtcEvisceradoProceso(null);

		return atcEvisceradoDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcProcesoAperturaCierreAtunCrudo
	@ManyToOne
	@JoinColumn(name="idatcprocesoaperturacierre")
	public AtcProcesoAperturaCierreAtunCrudo getAtcProcesoAperturaCierreAtunCrudo() {
		return this.atcProcesoAperturaCierreAtunCrudo;
	}

	public void setAtcProcesoAperturaCierreAtunCrudo(AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo) {
		this.atcProcesoAperturaCierreAtunCrudo = atcProcesoAperturaCierreAtunCrudo;
	}


	//bi-directional many-to-one association to AtcProduccion
	@ManyToOne
	@JoinColumn(name="idatcproduccion")
	public AtcProduccion getAtcProduccion() {
		return this.atcProduccion;
	}

	public void setAtcProduccion(AtcProduccion atcProduccion) {
		this.atcProduccion = atcProduccion;
	}


	//bi-directional many-to-one association to AtcEvisceradoTempPanza
	@OneToMany(mappedBy="atcEvisceradoProceso")
	public List<AtcEvisceradoTempPanza> getAtcEvisceradoTempPanzas() {
		return this.atcEvisceradoTempPanzas;
	}

	public void setAtcEvisceradoTempPanzas(List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas) {
		this.atcEvisceradoTempPanzas = atcEvisceradoTempPanzas;
	}

	public AtcEvisceradoTempPanza addAtcEvisceradoTempPanza(AtcEvisceradoTempPanza atcEvisceradoTempPanza) {
		getAtcEvisceradoTempPanzas().add(atcEvisceradoTempPanza);
		atcEvisceradoTempPanza.setAtcEvisceradoProceso(this);

		return atcEvisceradoTempPanza;
	}

	public AtcEvisceradoTempPanza removeAtcEvisceradoTempPanza(AtcEvisceradoTempPanza atcEvisceradoTempPanza) {
		getAtcEvisceradoTempPanzas().remove(atcEvisceradoTempPanza);
		atcEvisceradoTempPanza.setAtcEvisceradoProceso(null);

		return atcEvisceradoTempPanza;
	}

}