package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the camara_area database table.
 * 
 */
@Entity
@Table(name="camara_area")
public class CamaraArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcamaraarea;

	private String descripcioncamaraarea;

	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="camaraArea")
	private List<CamaraCajon> camaraCajons;

	//bi-directional many-to-one association to CamaraCajonUbicacion
	@OneToMany(mappedBy="camaraArea")
	private List<CamaraCajonUbicacion> camaraCajonUbicacions;

	public CamaraArea() {
	}

	public Integer getIdcamaraarea() {
		return this.idcamaraarea;
	}

	public void setIdcamaraarea(Integer idcamaraarea) {
		this.idcamaraarea = idcamaraarea;
	}

	public String getDescripcioncamaraarea() {
		return this.descripcioncamaraarea;
	}

	public void setDescripcioncamaraarea(String descripcioncamaraarea) {
		this.descripcioncamaraarea = descripcioncamaraarea;
	}

	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public List<CamaraCajonUbicacion> getCamaraCajonUbicacions() {
		return this.camaraCajonUbicacions;
	}

	public void setCamaraCajonUbicacions(List<CamaraCajonUbicacion> camaraCajonUbicacions) {
		this.camaraCajonUbicacions = camaraCajonUbicacions;
	}

}