package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cuartochillroom database table.
 * 
 */
@Entity
@NamedQuery(name="Cuartochillroom.findAll", query="SELECT c FROM Cuartochillroom c")
public class Cuartochillroom implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcuartochillroom;
	private String descripcion;
	private List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles;
	private List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches;

	public Cuartochillroom() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CuartoChillroomCocinadaDetalle
	@OneToMany(mappedBy="cuartochillroom")
	public List<CuartoChillroomCocinadaDetalle> getCuartoChillroomCocinadaDetalles() {
		return this.cuartoChillroomCocinadaDetalles;
	}

	public void setCuartoChillroomCocinadaDetalles(List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles) {
		this.cuartoChillroomCocinadaDetalles = cuartoChillroomCocinadaDetalles;
	}

	public CuartoChillroomCocinadaDetalle addCuartoChillroomCocinadaDetalle(CuartoChillroomCocinadaDetalle cuartoChillroomCocinadaDetalle) {
		getCuartoChillroomCocinadaDetalles().add(cuartoChillroomCocinadaDetalle);
		cuartoChillroomCocinadaDetalle.setCuartochillroom(this);

		return cuartoChillroomCocinadaDetalle;
	}

	public CuartoChillroomCocinadaDetalle removeCuartoChillroomCocinadaDetalle(CuartoChillroomCocinadaDetalle cuartoChillroomCocinadaDetalle) {
		getCuartoChillroomCocinadaDetalles().remove(cuartoChillroomCocinadaDetalle);
		cuartoChillroomCocinadaDetalle.setCuartochillroom(null);

		return cuartoChillroomCocinadaDetalle;
	}


	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@OneToMany(mappedBy="cuartochillroom")
	public List<RociadoDetalleProcesoCoche> getRociadoDetalleProcesoCoches() {
		return this.rociadoDetalleProcesoCoches;
	}

	public void setRociadoDetalleProcesoCoches(List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches) {
		this.rociadoDetalleProcesoCoches = rociadoDetalleProcesoCoches;
	}

	public RociadoDetalleProcesoCoche addRociadoDetalleProcesoCoch(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoch) {
		getRociadoDetalleProcesoCoches().add(rociadoDetalleProcesoCoch);
		rociadoDetalleProcesoCoch.setCuartochillroom(this);

		return rociadoDetalleProcesoCoch;
	}

	public RociadoDetalleProcesoCoche removeRociadoDetalleProcesoCoch(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoch) {
		getRociadoDetalleProcesoCoches().remove(rociadoDetalleProcesoCoch);
		rociadoDetalleProcesoCoch.setCuartochillroom(null);

		return rociadoDetalleProcesoCoch;
	}

}