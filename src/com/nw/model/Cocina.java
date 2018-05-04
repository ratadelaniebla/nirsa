package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cocina database table.
 * 
 */
@Entity
@NamedQuery(name="Cocina.findAll", query="SELECT c FROM Cocina c")
public class Cocina implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcocina;
	private String descripcion;
	private Integer estado;
	private List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles;
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;
	private List<PanzasDetalleProcesoCoche> panzasDetalleProcesoCoches;

	public Cocina() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@OneToMany(mappedBy="cocina")
	public List<CocinaAperturaCierreDetalle> getCocinaAperturaCierreDetalles() {
		return this.cocinaAperturaCierreDetalles;
	}

	public void setCocinaAperturaCierreDetalles(List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles) {
		this.cocinaAperturaCierreDetalles = cocinaAperturaCierreDetalles;
	}

	public CocinaAperturaCierreDetalle addCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		getCocinaAperturaCierreDetalles().add(cocinaAperturaCierreDetalle);
		cocinaAperturaCierreDetalle.setCocina(this);

		return cocinaAperturaCierreDetalle;
	}

	public CocinaAperturaCierreDetalle removeCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		getCocinaAperturaCierreDetalles().remove(cocinaAperturaCierreDetalle);
		cocinaAperturaCierreDetalle.setCocina(null);

		return cocinaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="cocina")
	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public EvisceradoCocheModificacion addEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().add(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setCocina(this);

		return evisceradoCocheModificacion;
	}

	public EvisceradoCocheModificacion removeEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().remove(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setCocina(null);

		return evisceradoCocheModificacion;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="cocina")
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public EvisceradoDetalleProcesoCoche addEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().add(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setCocina(this);

		return evisceradoDetalleProcesoCoch;
	}

	public EvisceradoDetalleProcesoCoche removeEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().remove(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setCocina(null);

		return evisceradoDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoCoche
	@OneToMany(mappedBy="cocina")
	public List<PanzasDetalleProcesoCoche> getPanzasDetalleProcesoCoches() {
		return this.panzasDetalleProcesoCoches;
	}

	public void setPanzasDetalleProcesoCoches(List<PanzasDetalleProcesoCoche> panzasDetalleProcesoCoches) {
		this.panzasDetalleProcesoCoches = panzasDetalleProcesoCoches;
	}

	public PanzasDetalleProcesoCoche addPanzasDetalleProcesoCoch(PanzasDetalleProcesoCoche panzasDetalleProcesoCoch) {
		getPanzasDetalleProcesoCoches().add(panzasDetalleProcesoCoch);
		panzasDetalleProcesoCoch.setCocina(this);

		return panzasDetalleProcesoCoch;
	}

	public PanzasDetalleProcesoCoche removePanzasDetalleProcesoCoch(PanzasDetalleProcesoCoche panzasDetalleProcesoCoch) {
		getPanzasDetalleProcesoCoches().remove(panzasDetalleProcesoCoch);
		panzasDetalleProcesoCoch.setCocina(null);

		return panzasDetalleProcesoCoch;
	}

}