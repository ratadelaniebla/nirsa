package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lugar_detalle database table.
 * 
 */
@Entity
@Table(name="lugar_detalle")
public class LugarDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlugardetalle;

	private Integer numerolugar;

	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="lugarDetalle")
	private List<DesperdicioDetalle> desperdicioDetalles;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	private Area area;

	//bi-directional many-to-one association to Lugar
	@ManyToOne
	@JoinColumn(name="idlugar")
	private Lugar lugar;

	public LugarDetalle() {
	}

	public Integer getIdlugardetalle() {
		return this.idlugardetalle;
	}

	public void setIdlugardetalle(Integer idlugardetalle) {
		this.idlugardetalle = idlugardetalle;
	}

	public Integer getNumerolugar() {
		return this.numerolugar;
	}

	public void setNumerolugar(Integer numerolugar) {
		this.numerolugar = numerolugar;
	}

	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

}