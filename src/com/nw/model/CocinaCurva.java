package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cocina_curva database table.
 * 
 */
@Entity
@Table(name="cocina_curva")
@NamedQuery(name="CocinaCurva.findAll", query="SELECT c FROM CocinaCurva c")
public class CocinaCurva implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcocinacurva;
	private String descripcion;
	private List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles;

	public CocinaCurva() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdcocinacurva() {
		return this.idcocinacurva;
	}

	public void setIdcocinacurva(Integer idcocinacurva) {
		this.idcocinacurva = idcocinacurva;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@OneToMany(mappedBy="cocinaCurva")
	public List<CocinaAperturaCierreDetalle> getCocinaAperturaCierreDetalles() {
		return this.cocinaAperturaCierreDetalles;
	}

	public void setCocinaAperturaCierreDetalles(List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles) {
		this.cocinaAperturaCierreDetalles = cocinaAperturaCierreDetalles;
	}

	public CocinaAperturaCierreDetalle addCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		getCocinaAperturaCierreDetalles().add(cocinaAperturaCierreDetalle);
		cocinaAperturaCierreDetalle.setCocinaCurva(this);

		return cocinaAperturaCierreDetalle;
	}

	public CocinaAperturaCierreDetalle removeCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		getCocinaAperturaCierreDetalles().remove(cocinaAperturaCierreDetalle);
		cocinaAperturaCierreDetalle.setCocinaCurva(null);

		return cocinaAperturaCierreDetalle;
	}

}