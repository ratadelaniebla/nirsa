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
@NamedQuery(name="CocinaProcesoTipoTemperatura.findAll", query="SELECT c FROM CocinaProcesoTipoTemperatura c")
public class CocinaProcesoTipoTemperatura implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcocinaprocesotipotemperatura;
	private String descripcion;
	private List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles;

	public CocinaProcesoTipoTemperatura() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CocinaProcesoControlEspinaDetalle
	@OneToMany(mappedBy="cocinaProcesoTipoTemperatura")
	public List<CocinaProcesoControlEspinaDetalle> getCocinaProcesoControlEspinaDetalles() {
		return this.cocinaProcesoControlEspinaDetalles;
	}

	public void setCocinaProcesoControlEspinaDetalles(List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles) {
		this.cocinaProcesoControlEspinaDetalles = cocinaProcesoControlEspinaDetalles;
	}

	public CocinaProcesoControlEspinaDetalle addCocinaProcesoControlEspinaDetalle(CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle) {
		getCocinaProcesoControlEspinaDetalles().add(cocinaProcesoControlEspinaDetalle);
		cocinaProcesoControlEspinaDetalle.setCocinaProcesoTipoTemperatura(this);

		return cocinaProcesoControlEspinaDetalle;
	}

	public CocinaProcesoControlEspinaDetalle removeCocinaProcesoControlEspinaDetalle(CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle) {
		getCocinaProcesoControlEspinaDetalles().remove(cocinaProcesoControlEspinaDetalle);
		cocinaProcesoControlEspinaDetalle.setCocinaProcesoTipoTemperatura(null);

		return cocinaProcesoControlEspinaDetalle;
	}

}