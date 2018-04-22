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
public class AtcProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idatcproceso;

	private String descripcionproceso;

	//bi-directional many-to-one association to AtcProcesoAperturaCierreAtunCrudo
	@OneToMany(mappedBy="atcProceso")
	private List<AtcProcesoAperturaCierreAtunCrudo> atcProcesoAperturaCierreAtunCrudos;

	public AtcProceso() {
	}

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

	public List<AtcProcesoAperturaCierreAtunCrudo> getAtcProcesoAperturaCierreAtunCrudos() {
		return this.atcProcesoAperturaCierreAtunCrudos;
	}

	public void setAtcProcesoAperturaCierreAtunCrudos(List<AtcProcesoAperturaCierreAtunCrudo> atcProcesoAperturaCierreAtunCrudos) {
		this.atcProcesoAperturaCierreAtunCrudos = atcProcesoAperturaCierreAtunCrudos;
	}

}