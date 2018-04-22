package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_descongelado_proceso database table.
 * 
 */
@Entity
@Table(name="atc_descongelado_proceso")
public class AtcDescongeladoProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatcdescongeladoproceso;

	private Timestamp fechareg;

	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@OneToMany(mappedBy="atcDescongeladoProceso")
	private List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos;

	//bi-directional many-to-one association to AtcProcesoAperturaCierreAtunCrudo
	@ManyToOne
	@JoinColumn(name="idatcprocesoaperturacierre")
	private AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo;

	//bi-directional many-to-one association to AtcProduccion
	@ManyToOne
	@JoinColumn(name="idatcproduccion")
	private AtcProduccion atcProduccion;

	public AtcDescongeladoProceso() {
	}

	public Long getIdatcdescongeladoproceso() {
		return this.idatcdescongeladoproceso;
	}

	public void setIdatcdescongeladoproceso(Long idatcdescongeladoproceso) {
		this.idatcdescongeladoproceso = idatcdescongeladoproceso;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public List<AtcDescongeladoDetalleProceso> getAtcDescongeladoDetalleProcesos() {
		return this.atcDescongeladoDetalleProcesos;
	}

	public void setAtcDescongeladoDetalleProcesos(List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos) {
		this.atcDescongeladoDetalleProcesos = atcDescongeladoDetalleProcesos;
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

}