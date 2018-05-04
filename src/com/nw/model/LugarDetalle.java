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
@NamedQuery(name="LugarDetalle.findAll", query="SELECT l FROM LugarDetalle l")
public class LugarDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlugardetalle;
	private Integer numerolugar;
	private List<DesperdicioDetalle> desperdicioDetalles;
	private Area area;
	private Lugar lugar;

	public LugarDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="lugarDetalle")
	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public DesperdicioDetalle addDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().add(desperdicioDetalle);
		desperdicioDetalle.setLugarDetalle(this);

		return desperdicioDetalle;
	}

	public DesperdicioDetalle removeDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().remove(desperdicioDetalle);
		desperdicioDetalle.setLugarDetalle(null);

		return desperdicioDetalle;
	}


	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	//bi-directional many-to-one association to Lugar
	@ManyToOne
	@JoinColumn(name="idlugar")
	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

}