package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the atc_proceso database table.
 * 
 */
@Entity
@Table(name="atc_proceso")
@NamedQuery(name="AtcProceso.findAll", query="SELECT a FROM AtcProceso a")
public class AtcProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idatcproceso;
	private String descripcionproceso;
	private List<AtcProcesoAperturaCierreAtunCrudo> atcProcesoAperturaCierreAtunCrudos;

	public AtcProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdatcproceso() {
		return this.idatcproceso;
	}

	public void setIdatcproceso(Integer idatcproceso) {
		this.idatcproceso = idatcproceso;
	}


	public String getDescripcionproceso() {
		return this.descripcionproceso;
	}

	public void setDescripcionproceso(String descripcionproceso) {
		this.descripcionproceso = descripcionproceso;
	}


	//bi-directional many-to-one association to AtcProcesoAperturaCierreAtunCrudo
	@OneToMany(mappedBy="atcProceso")
	public List<AtcProcesoAperturaCierreAtunCrudo> getAtcProcesoAperturaCierreAtunCrudos() {
		return this.atcProcesoAperturaCierreAtunCrudos;
	}

	public void setAtcProcesoAperturaCierreAtunCrudos(List<AtcProcesoAperturaCierreAtunCrudo> atcProcesoAperturaCierreAtunCrudos) {
		this.atcProcesoAperturaCierreAtunCrudos = atcProcesoAperturaCierreAtunCrudos;
	}

	public AtcProcesoAperturaCierreAtunCrudo addAtcProcesoAperturaCierreAtunCrudo(AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo) {
		getAtcProcesoAperturaCierreAtunCrudos().add(atcProcesoAperturaCierreAtunCrudo);
		atcProcesoAperturaCierreAtunCrudo.setAtcProceso(this);

		return atcProcesoAperturaCierreAtunCrudo;
	}

	public AtcProcesoAperturaCierreAtunCrudo removeAtcProcesoAperturaCierreAtunCrudo(AtcProcesoAperturaCierreAtunCrudo atcProcesoAperturaCierreAtunCrudo) {
		getAtcProcesoAperturaCierreAtunCrudos().remove(atcProcesoAperturaCierreAtunCrudo);
		atcProcesoAperturaCierreAtunCrudo.setAtcProceso(null);

		return atcProcesoAperturaCierreAtunCrudo;
	}

}