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
@NamedQuery(name="CocinaChoqueTermico.findAll", query="SELECT c FROM CocinaChoqueTermico c")
public class CocinaChoqueTermico implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcocinachoquetermico;
	private String descripcion;
	private List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles;

	public CocinaChoqueTermico() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@OneToMany(mappedBy="cocinaChoqueTermico")
	public List<CocinaAperturaCierreDetalle> getCocinaAperturaCierreDetalles() {
		return this.cocinaAperturaCierreDetalles;
	}

	public void setCocinaAperturaCierreDetalles(List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles) {
		this.cocinaAperturaCierreDetalles = cocinaAperturaCierreDetalles;
	}

	public CocinaAperturaCierreDetalle addCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		getCocinaAperturaCierreDetalles().add(cocinaAperturaCierreDetalle);
		cocinaAperturaCierreDetalle.setCocinaChoqueTermico(this);

		return cocinaAperturaCierreDetalle;
	}

	public CocinaAperturaCierreDetalle removeCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		getCocinaAperturaCierreDetalles().remove(cocinaAperturaCierreDetalle);
		cocinaAperturaCierreDetalle.setCocinaChoqueTermico(null);

		return cocinaAperturaCierreDetalle;
	}

}