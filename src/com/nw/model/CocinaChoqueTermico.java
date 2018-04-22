package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cocina_choque_termico database table.
 * 
 */
@Entity
@Table(name="cocina_choque_termico")
public class CocinaChoqueTermico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcocinachoquetermico;

	private String descripcion;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@OneToMany(mappedBy="cocinaChoqueTermico")
	private List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles;

	public CocinaChoqueTermico() {
	}

	public Integer getIdcocinachoquetermico() {
		return this.idcocinachoquetermico;
	}

	public void setIdcocinachoquetermico(Integer idcocinachoquetermico) {
		this.idcocinachoquetermico = idcocinachoquetermico;
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