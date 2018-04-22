package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cuartochillroom database table.
 * 
 */
@Entity
public class Cuartochillroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcuartochillroom;

	private String descripcion;

	//bi-directional many-to-one association to CuartoChillroomCocinadaDetalle
	@OneToMany(mappedBy="cuartochillroom")
	private List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles;

	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@OneToMany(mappedBy="cuartochillroom")
	private List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches;

	public Cuartochillroom() {
	}

	public Integer getIdcuartochillroom() {
		return this.idcuartochillroom;
	}

	public void setIdcuartochillroom(Integer idcuartochillroom) {
		this.idcuartochillroom = idcuartochillroom;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CuartoChillroomCocinadaDetalle> getCuartoChillroomCocinadaDetalles() {
		return this.cuartoChillroomCocinadaDetalles;
	}

	public void setCuartoChillroomCocinadaDetalles(List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles) {
		this.cuartoChillroomCocinadaDetalles = cuartoChillroomCocinadaDetalles;
	}

	public List<RociadoDetalleProcesoCoche> getRociadoDetalleProcesoCoches() {
		return this.rociadoDetalleProcesoCoches;
	}

	public void setRociadoDetalleProcesoCoches(List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches) {
		this.rociadoDetalleProcesoCoches = rociadoDetalleProcesoCoches;
	}

}