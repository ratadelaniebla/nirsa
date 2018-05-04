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
@NamedQuery(name="AtcDescongeladoProceso.findAll", query="SELECT a FROM AtcDescongeladoProceso a")
public class AtcDescongeladoProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatcdescongeladoproceso;
	private Timestamp fechareg;
	private List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos;
	private AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo;
	private AtcProduccion atcProduccion;

	public AtcDescongeladoProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcDescongeladoDetalleProceso
	@OneToMany(mappedBy="atcDescongeladoProceso")
	public List<AtcDescongeladoDetalleProceso> getAtcDescongeladoDetalleProcesos() {
		return this.atcDescongeladoDetalleProcesos;
	}

	public void setAtcDescongeladoDetalleProcesos(List<AtcDescongeladoDetalleProceso> atcDescongeladoDetalleProcesos) {
		this.atcDescongeladoDetalleProcesos = atcDescongeladoDetalleProcesos;
	}

	public AtcDescongeladoDetalleProceso addAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		getAtcDescongeladoDetalleProcesos().add(atcDescongeladoDetalleProceso);
		atcDescongeladoDetalleProceso.setAtcDescongeladoProceso(this);

		return atcDescongeladoDetalleProceso;
	}

	public AtcDescongeladoDetalleProceso removeAtcDescongeladoDetalleProceso(AtcDescongeladoDetalleProceso atcDescongeladoDetalleProceso) {
		getAtcDescongeladoDetalleProcesos().remove(atcDescongeladoDetalleProceso);
		atcDescongeladoDetalleProceso.setAtcDescongeladoProceso(null);

		return atcDescongeladoDetalleProceso;
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

}