package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the area_proceso database table. 
 * 
 */
@Entity
@Table(name="area_proceso")
public class AreaProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idareaproceso;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	private Area area;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	public AreaProceso() {
	}

	public Integer getIdareaproceso() {
		return this.idareaproceso;
	}

	public void setIdareaproceso(Integer idareaproceso) {
		this.idareaproceso = idareaproceso;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

}