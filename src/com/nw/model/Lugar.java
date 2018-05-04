package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lugar database table.
 * 
 */
@Entity
@NamedQuery(name="Lugar.findAll", query="SELECT l FROM Lugar l")
public class Lugar implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlugar;
	private String descripcionlugar;
	private Integer desperdicio;
	private Integer validarlote;
	private List<AreaSubproducto> areaSubproductos;
	private List<DesperdicioDetalle> desperdicioDetalles;
	private Area area;
	private List<LugarDetalle> lugarDetalles;
	private List<Subproducto> subproductos;

	public Lugar() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AreaSubproducto
	@OneToMany(mappedBy="lugar")
	public List<AreaSubproducto> getAreaSubproductos() {
		return this.areaSubproductos;
	}

	public void setAreaSubproductos(List<AreaSubproducto> areaSubproductos) {
		this.areaSubproductos = areaSubproductos;
	}

	public AreaSubproducto addAreaSubproducto(AreaSubproducto areaSubproducto) {
		getAreaSubproductos().add(areaSubproducto);
		areaSubproducto.setLugar(this);

		return areaSubproducto;
	}

	public AreaSubproducto removeAreaSubproducto(AreaSubproducto areaSubproducto) {
		getAreaSubproductos().remove(areaSubproducto);
		areaSubproducto.setLugar(null);

		return areaSubproducto;
	}


	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="lugar")
	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public DesperdicioDetalle addDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().add(desperdicioDetalle);
		desperdicioDetalle.setLugar(this);

		return desperdicioDetalle;
	}

	public DesperdicioDetalle removeDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().remove(desperdicioDetalle);
		desperdicioDetalle.setLugar(null);

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


	//bi-directional many-to-one association to LugarDetalle
	@OneToMany(mappedBy="lugar")
	public List<LugarDetalle> getLugarDetalles() {
		return this.lugarDetalles;
	}

	public void setLugarDetalles(List<LugarDetalle> lugarDetalles) {
		this.lugarDetalles = lugarDetalles;
	}

	public LugarDetalle addLugarDetalle(LugarDetalle lugarDetalle) {
		getLugarDetalles().add(lugarDetalle);
		lugarDetalle.setLugar(this);

		return lugarDetalle;
	}

	public LugarDetalle removeLugarDetalle(LugarDetalle lugarDetalle) {
		getLugarDetalles().remove(lugarDetalle);
		lugarDetalle.setLugar(null);

		return lugarDetalle;
	}


	//bi-directional many-to-one association to Subproducto
	@OneToMany(mappedBy="lugar")
	public List<Subproducto> getSubproductos() {
		return this.subproductos;
	}

	public void setSubproductos(List<Subproducto> subproductos) {
		this.subproductos = subproductos;
	}

	public Subproducto addSubproducto(Subproducto subproducto) {
		getSubproductos().add(subproducto);
		subproducto.setLugar(this);

		return subproducto;
	}

	public Subproducto removeSubproducto(Subproducto subproducto) {
		getSubproductos().remove(subproducto);
		subproducto.setLugar(null);

		return subproducto;
	}

}