package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cocina database table.
 * 
 */
@Entity
public class Cocina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcocina;

	private String descripcion;

	private Integer estado;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@OneToMany(mappedBy="cocina")
	private List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles;

	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="cocina")
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="cocina")
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;

	public Cocina() {
	}

	public Integer getIdcocina() {
		return this.idcocina;
	}

	public void setIdcocina(Integer idcocina) {
		this.idcocina = idcocina;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public List<CocinaAperturaCierreDetalle> getCocinaAperturaCierreDetalles() {
		return this.cocinaAperturaCierreDetalles;
	}

	public void setCocinaAperturaCierreDetalles(List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles) {
		this.cocinaAperturaCierreDetalles = cocinaAperturaCierreDetalles;
	}

	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

}