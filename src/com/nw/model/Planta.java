package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the plantas database table.
 * 
 */
@Entity
@Table(name="plantas")
@NamedQuery(name="Planta.findAll", query="SELECT p FROM Planta p")
public class Planta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idplanta;
	private String descripcionplanta;
	private List<Area> areas;
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas;

	public Planta() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdplanta() {
		return this.idplanta;
	}

	public void setIdplanta(Integer idplanta) {
		this.idplanta = idplanta;
	}


	public String getDescripcionplanta() {
		return this.descripcionplanta;
	}

	public void setDescripcionplanta(String descripcionplanta) {
		this.descripcionplanta = descripcionplanta;
	}


	//bi-directional many-to-one association to Area
	@OneToMany(mappedBy="planta")
	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Area addArea(Area area) {
		getAreas().add(area);
		area.setPlanta(this);

		return area;
	}

	public Area removeArea(Area area) {
		getAreas().remove(area);
		area.setPlanta(null);

		return area;
	}


	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="planta")
	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas() {
		return this.desperdicioCajonHarinas;
	}

	public void setDesperdicioCajonHarinas(List<DesperdicioCajonHarina> desperdicioCajonHarinas) {
		this.desperdicioCajonHarinas = desperdicioCajonHarinas;
	}

	public DesperdicioCajonHarina addDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		getDesperdicioCajonHarinas().add(desperdicioCajonHarina);
		desperdicioCajonHarina.setPlanta(this);

		return desperdicioCajonHarina;
	}

	public DesperdicioCajonHarina removeDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		getDesperdicioCajonHarinas().remove(desperdicioCajonHarina);
		desperdicioCajonHarina.setPlanta(null);

		return desperdicioCajonHarina;
	}

}