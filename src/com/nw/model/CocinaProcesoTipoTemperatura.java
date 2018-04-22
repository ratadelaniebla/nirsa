package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cocina_proceso_tipo_temperatura database table.
 * 
 */
@Entity
@Table(name="cocina_proceso_tipo_temperatura")
public class CocinaProcesoTipoTemperatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcocinaprocesotipotemperatura;

	private String descripcion;

	//bi-directional many-to-one association to CocinaProcesoControlEspinaDetalle
	@OneToMany(mappedBy="cocinaProcesoTipoTemperatura")
	private List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles;

	public CocinaProcesoTipoTemperatura() {
	}

	public Integer getIdcocinaprocesotipotemperatura() {
		return this.idcocinaprocesotipotemperatura;
	}

	public void setIdcocinaprocesotipotemperatura(Integer idcocinaprocesotipotemperatura) {
		this.idcocinaprocesotipotemperatura = idcocinaprocesotipotemperatura;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CocinaProcesoControlEspinaDetalle> getCocinaProcesoControlEspinaDetalles() {
		return this.cocinaProcesoControlEspinaDetalles;
	}

	public void setCocinaProcesoControlEspinaDetalles(List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles) {
		this.cocinaProcesoControlEspinaDetalles = cocinaProcesoControlEspinaDetalles;
	}

}