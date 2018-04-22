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
public class AtcEvisceradoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatcevisceradoproceso;

	private Timestamp fechareg;

	private Integer secuenciaidcocheglobal;

	//bi-directional many-to-one association to AtcEvisceradoDetalleProcesoLote
	@OneToMany(mappedBy="atcEvisceradoProceso")
	private List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes;

	//bi-directional many-to-one association to AtcProcesoAperturaCierreAtunCrudo
	@ManyToOne
	@JoinColumn(name="idatcprocesoaperturacierre")
	private AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo;

	//bi-directional many-to-one association to AtcProduccion
	@ManyToOne
	@JoinColumn(name="idatcproduccion")
	private AtcProduccion atcProduccion;

	//bi-directional many-to-one association to AtcEvisceradoTempPanza
	@OneToMany(mappedBy="atcEvisceradoProceso")
	private List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas;

	public AtcEvisceradoProceso() {
	}

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

	public List<AtcEvisceradoDetalleProcesoLote> getAtcEvisceradoDetalleProcesoLotes() {
		return this.atcEvisceradoDetalleProcesoLotes;
	}

	public void setAtcEvisceradoDetalleProcesoLotes(List<AtcEvisceradoDetalleProcesoLote> atcEvisceradoDetalleProcesoLotes) {
		this.atcEvisceradoDetalleProcesoLotes = atcEvisceradoDetalleProcesoLotes;
	}

	public AtcProcesoAperturaCierreAtunCrudo getAtcProcesoAperturaCierreAtunCrudo() {
		return this.atcProcesoAperturaCierreAtunCrudo;
	}

	public void setAtcProcesoAperturaCierreAtunCrudo(AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo) {
		this.atcProcesoAperturaCierreAtunCrudo = atcProcesoAperturaCierreAtunCrudo;
	}

	public AtcProduccion getAtcProduccion() {
		return this.atcProduccion;
	}

	public void setAtcProduccion(AtcProduccion atcProduccion) {
		this.atcProduccion = atcProduccion;
	}

	public List<AtcEvisceradoTempPanza> getAtcEvisceradoTempPanzas() {
		return this.atcEvisceradoTempPanzas;
	}

	public void setAtcEvisceradoTempPanzas(List<AtcEvisceradoTempPanza> atcEvisceradoTempPanzas) {
		this.atcEvisceradoTempPanzas = atcEvisceradoTempPanzas;
	}

}