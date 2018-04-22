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
public class Planta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idplanta;

	private String descripcionplanta;

	//bi-directional many-to-one association to Area
	@OneToMany(mappedBy="planta")
	private List<Area> areas;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="planta")
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas;

	public Planta() {
	}

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

	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas() {
		return this.desperdicioCajonHarinas;
	}

	public void setDesperdicioCajonHarinas(List<DesperdicioCajonHarina> desperdicioCajonHarinas) {
		this.desperdicioCajonHarinas = desperdicioCajonHarinas;
	}

}