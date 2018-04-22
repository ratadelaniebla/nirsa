package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lugar database table.
 * 
 */
@Entity
public class Lugar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlugar;

	private String descripcionlugar;

	private Integer desperdicio;

	private Integer validarlote;

	//bi-directional many-to-one association to AreaSubproducto
	@OneToMany(mappedBy="lugar")
	private List<AreaSubproducto> areaSubproductos;

	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="lugar")
	private List<DesperdicioDetalle> desperdicioDetalles;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	private Area area;

	//bi-directional many-to-one association to LugarDetalle
	@OneToMany(mappedBy="lugar")
	private List<LugarDetalle> lugarDetalles;

	//bi-directional many-to-one association to Subproducto
	@OneToMany(mappedBy="lugar")
	private List<Subproducto> subproductos;

	public Lugar() {
	}

	public Integer getIdlugar() {
		return this.idlugar;
	}

	public void setIdlugar(Integer idlugar) {
		this.idlugar = idlugar;
	}

	public String getDescripcionlugar() {
		return this.descripcionlugar;
	}

	public void setDescripcionlugar(String descripcionlugar) {
		this.descripcionlugar = descripcionlugar;
	}

	public Integer getDesperdicio() {
		return this.desperdicio;
	}

	public void setDesperdicio(Integer desperdicio) {
		this.desperdicio = desperdicio;
	}

	public Integer getValidarlote() {
		return this.validarlote;
	}

	public void setValidarlote(Integer validarlote) {
		this.validarlote = validarlote;
	}

	public List<AreaSubproducto> getAreaSubproductos() {
		return this.areaSubproductos;
	}

	public void setAreaSubproductos(List<AreaSubproducto> areaSubproductos) {
		this.areaSubproductos = areaSubproductos;
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

	public List<LugarDetalle> getLugarDetalles() {
		return this.lugarDetalles;
	}

	public void setLugarDetalles(List<LugarDetalle> lugarDetalles) {
		this.lugarDetalles = lugarDetalles;
	}

	public List<Subproducto> getSubproductos() {
		return this.subproductos;
	}

	public void setSubproductos(List<Subproducto> subproductos) {
		this.subproductos = subproductos;
	}

}