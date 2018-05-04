package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the area_subproducto database table.
 * 
 */
@Entity
@Table(name="area_subproducto")
@NamedQuery(name="AreaSubproducto.findAll", query="SELECT a FROM AreaSubproducto a")
public class AreaSubproducto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idareasubproducto;
	private Integer iddesperdicioclasificacion;
	private Integer tipolote;
	private Area area;
	private Lugar lugar;
	private Subproducto subproducto;

	public AreaSubproducto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to Subproducto
	@ManyToOne
	@JoinColumn(name="idsubproducto")
	public Subproducto getSubproducto() {
		return this.subproducto;
	}

	public void setSubproducto(Subproducto subproducto) {
		this.subproducto = subproducto;
	}

}