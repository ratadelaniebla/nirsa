package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the area_subproducto database table.
 * 
 */
@Entity
@Table(name="area_subproducto")
public class AreaSubproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idareasubproducto;

	private Integer iddesperdicioclasificacion;

	private Integer tipolote;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	private Area area;

	//bi-directional many-to-one association to Lugar
	@ManyToOne
	@JoinColumn(name="idlugar")
	private Lugar lugar;

	//bi-directional many-to-one association to Subproducto
	@ManyToOne
	@JoinColumn(name="idsubproducto")
	private Subproducto subproducto;

	public AreaSubproducto() {
	}

	public Integer getIdareasubproducto() {
		return this.idareasubproducto;
	}

	public void setIdareasubproducto(Integer idareasubproducto) {
		this.idareasubproducto = idareasubproducto;
	}

	public Integer getIddesperdicioclasificacion() {
		return this.iddesperdicioclasificacion;
	}

	public void setIddesperdicioclasificacion(Integer iddesperdicioclasificacion) {
		this.iddesperdicioclasificacion = iddesperdicioclasificacion;
	}

	public Integer getTipolote() {
		return this.tipolote;
	}

	public void setTipolote(Integer tipolote) {
		this.tipolote = tipolote;
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

	public Subproducto getSubproducto() {
		return this.subproducto;
	}

	public void setSubproducto(Subproducto subproducto) {
		this.subproducto = subproducto;
	}

}