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
public class CocinaCurva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcocinacurva;

	private String descripcion;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@OneToMany(mappedBy="cocinaCurva")
	private List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles;

	public CocinaCurva() {
	}

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

	public List<CocinaAperturaCierreDetalle> getCocinaAperturaCierreDetalles() {
		return this.cocinaAperturaCierreDetalles;
	}

	public void setCocinaAperturaCierreDetalles(List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles) {
		this.cocinaAperturaCierreDetalles = cocinaAperturaCierreDetalles;
	}

}