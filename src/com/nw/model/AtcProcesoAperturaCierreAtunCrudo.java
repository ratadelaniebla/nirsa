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
public class AtcProcesoAperturaCierreAtunCrudo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatcprocesoaperturacierre;

	private Integer estado;

	private Timestamp fechaapertura;

	private Timestamp fechacierre;

	//bi-directional many-to-one association to AtcDescongeladoProceso
	@OneToMany(mappedBy="atcProcesoAperturaCierreAtunCrudo")
	private List<AtcDescongeladoProceso> atcDescongeladoProcesos;

	//bi-directional many-to-one association to AtcEvisceradoProceso
	@OneToMany(mappedBy="atcProcesoAperturaCierreAtunCrudo")
	private List<AtcEvisceradoProceso> atcEvisceradoProcesos;

	//bi-directional many-to-one association to AtcLimpiezaProceso
	@OneToMany(mappedBy="atcProcesoAperturaCierreAtunCrudo")
	private List<AtcLimpiezaProceso> atcLimpiezaProcesos;

	//bi-directional many-to-one association to AtcProceso
	@ManyToOne
	@JoinColumn(name="idatcproceso")
	private AtcProceso atcProceso;

	public AtcProcesoAperturaCierreAtunCrudo() {
	}

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

	public List<AtcDescongeladoProceso> getAtcDescongeladoProcesos() {
		return this.atcDescongeladoProcesos;
	}

	public void setAtcDescongeladoProcesos(List<AtcDescongeladoProceso> atcDescongeladoProcesos) {
		this.atcDescongeladoProcesos = atcDescongeladoProcesos;
	}

	public List<AtcEvisceradoProceso> getAtcEvisceradoProcesos() {
		return this.atcEvisceradoProcesos;
	}

	public void setAtcEvisceradoProcesos(List<AtcEvisceradoProceso> atcEvisceradoProcesos) {
		this.atcEvisceradoProcesos = atcEvisceradoProcesos;
	}

	public List<AtcLimpiezaProceso> getAtcLimpiezaProcesos() {
		return this.atcLimpiezaProcesos;
	}

	public void setAtcLimpiezaProcesos(List<AtcLimpiezaProceso> atcLimpiezaProcesos) {
		this.atcLimpiezaProcesos = atcLimpiezaProcesos;
	}

	public AtcProceso getAtcProceso() {
		return this.atcProceso;
	}

	public void setAtcProceso(AtcProceso atcProceso) {
		this.atcProceso = atcProceso;
	}

}