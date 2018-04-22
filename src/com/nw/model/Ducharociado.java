package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ducharociado database table.
 * 
 */
@Entity
public class Ducharociado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idducharociado;

	private String descripcion;

	//bi-directional many-to-one association to CoccionDetalleProcesoCoche
	@OneToMany(mappedBy="ducharociadoBean")
	private List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches;

	//bi-directional many-to-one association to RociadoCocinadaDetalle
	@OneToMany(mappedBy="ducharociado")
	private List<RociadoCocinadaDetalle> rociadoCocinadaDetalles;

	public Ducharociado() {
	}

	public Integer getIdducharociado() {
		return this.idducharociado;
	}

	public void setIdducharociado(Integer idducharociado) {
		this.idducharociado = idducharociado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CoccionDetalleProcesoCoche> getCoccionDetalleProcesoCoches() {
		return this.coccionDetalleProcesoCoches;
	}

	public void setCoccionDetalleProcesoCoches(List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches) {
		this.coccionDetalleProcesoCoches = coccionDetalleProcesoCoches;
	}

	public List<RociadoCocinadaDetalle> getRociadoCocinadaDetalles() {
		return this.rociadoCocinadaDetalles;
	}

	public void setRociadoCocinadaDetalles(List<RociadoCocinadaDetalle> rociadoCocinadaDetalles) {
		this.rociadoCocinadaDetalles = rociadoCocinadaDetalles;
	}

}