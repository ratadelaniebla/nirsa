package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_proceso_apertura_cierre_atun_crudo database table.
 * 
 */
@Entity
@Table(name="atc_proceso_apertura_cierre_atun_crudo")
@NamedQuery(name="AtcProcesoAperturaCierreAtunCrudo.findAll", query="SELECT a FROM AtcProcesoAperturaCierreAtunCrudo a")
public class AtcProcesoAperturaCierreAtunCrudo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcprocesoaperturacierre;
	private Integer estado;
	private Timestamp fechaapertura;
	private Timestamp fechacierre;
	private List<AtcDescongeladoProceso> atcDescongeladoProcesos;
	private List<AtcEvisceradoProceso> atcEvisceradoProcesos;
	private List<AtcLimpiezaProceso> atcLimpiezaProcesos;
	private AtcProceso atcProceso;

	public AtcProcesoAperturaCierreAtunCrudo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdatcprocesoaperturacierre() {
		return this.idatcprocesoaperturacierre;
	}

	public void setIdatcprocesoaperturacierre(Long idatcprocesoaperturacierre) {
		this.idatcprocesoaperturacierre = idatcprocesoaperturacierre;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechaapertura() {
		return this.fechaapertura;
	}

	public void setFechaapertura(Timestamp fechaapertura) {
		this.fechaapertura = fechaapertura;
	}


	public Timestamp getFechacierre() {
		return this.fechacierre;
	}

	public void setFechacierre(Timestamp fechacierre) {
		this.fechacierre = fechacierre;
	}


	//bi-directional many-to-one association to AtcDescongeladoProceso
	@OneToMany(mappedBy="atcProcesoAperturaCierreAtunCrudo")
	public List<AtcDescongeladoProceso> getAtcDescongeladoProcesos() {
		return this.atcDescongeladoProcesos;
	}

	public void setAtcDescongeladoProcesos(List<AtcDescongeladoProceso> atcDescongeladoProcesos) {
		this.atcDescongeladoProcesos = atcDescongeladoProcesos;
	}

	public AtcDescongeladoProceso addAtcDescongeladoProceso(AtcDescongeladoProceso atcDescongeladoProceso) {
		getAtcDescongeladoProcesos().add(atcDescongeladoProceso);
		atcDescongeladoProceso.setAtcProcesoAperturaCierreAtunCrudo(this);

		return atcDescongeladoProceso;
	}

	public AtcDescongeladoProceso removeAtcDescongeladoProceso(AtcDescongeladoProceso atcDescongeladoProceso) {
		getAtcDescongeladoProcesos().remove(atcDescongeladoProceso);
		atcDescongeladoProceso.setAtcProcesoAperturaCierreAtunCrudo(null);

		return atcDescongeladoProceso;
	}


	//bi-directional many-to-one association to AtcEvisceradoProceso
	@OneToMany(mappedBy="atcProcesoAperturaCierreAtunCrudo")
	public List<AtcEvisceradoProceso> getAtcEvisceradoProcesos() {
		return this.atcEvisceradoProcesos;
	}

	public void setAtcEvisceradoProcesos(List<AtcEvisceradoProceso> atcEvisceradoProcesos) {
		this.atcEvisceradoProcesos = atcEvisceradoProcesos;
	}

	public AtcEvisceradoProceso addAtcEvisceradoProceso(AtcEvisceradoProceso atcEvisceradoProceso) {
		getAtcEvisceradoProcesos().add(atcEvisceradoProceso);
		atcEvisceradoProceso.setAtcProcesoAperturaCierreAtunCrudo(this);

		return atcEvisceradoProceso;
	}

	public AtcEvisceradoProceso removeAtcEvisceradoProceso(AtcEvisceradoProceso atcEvisceradoProceso) {
		getAtcEvisceradoProcesos().remove(atcEvisceradoProceso);
		atcEvisceradoProceso.setAtcProcesoAperturaCierreAtunCrudo(null);

		return atcEvisceradoProceso;
	}


	//bi-directional many-to-one association to AtcLimpiezaProceso
	@OneToMany(mappedBy="atcProcesoAperturaCierreAtunCrudo")
	public List<AtcLimpiezaProceso> getAtcLimpiezaProcesos() {
		return this.atcLimpiezaProcesos;
	}

	public void setAtcLimpiezaProcesos(List<AtcLimpiezaProceso> atcLimpiezaProcesos) {
		this.atcLimpiezaProcesos = atcLimpiezaProcesos;
	}

	public AtcLimpiezaProceso addAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		getAtcLimpiezaProcesos().add(atcLimpiezaProceso);
		atcLimpiezaProceso.setAtcProcesoAperturaCierreAtunCrudo(this);

		return atcLimpiezaProceso;
	}

	public AtcLimpiezaProceso removeAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		getAtcLimpiezaProcesos().remove(atcLimpiezaProceso);
		atcLimpiezaProceso.setAtcProcesoAperturaCierreAtunCrudo(null);

		return atcLimpiezaProceso;
	}


	//bi-directional many-to-one association to AtcProceso
	@ManyToOne
	@JoinColumn(name="idatcproceso")
	public AtcProceso getAtcProceso() {
		return this.atcProceso;
	}

	public void setAtcProceso(AtcProceso atcProceso) {
		this.atcProceso = atcProceso;
	}

}