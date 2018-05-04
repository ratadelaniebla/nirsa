package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the area_proceso database table.
 * 
 */
@Entity
@Table(name="area_proceso")
@NamedQuery(name="AreaProceso.findAll", query="SELECT a FROM AreaProceso a")
public class AreaProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idareaproceso;
	private Area area;
	private Proceso proceso;

	public AreaProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdareaproceso() {
		return this.idareaproceso;
	}

	public void setIdareaproceso(Integer idareaproceso) {
		this.idareaproceso = idareaproceso;
	}


	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

}