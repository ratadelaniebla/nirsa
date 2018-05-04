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
@NamedQuery(name="CamaraArea.findAll", query="SELECT c FROM CamaraArea c")
public class CamaraArea implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcamaraarea;
	private String descripcioncamaraarea;
	private List<CamaraCajon> camaraCajons;
	private List<CamaraCajonUbicacion> camaraCajonUbicacions;

	public CamaraArea() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="camaraArea")
	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public CamaraCajon addCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().add(camaraCajon);
		camaraCajon.setCamaraArea(this);

		return camaraCajon;
	}

	public CamaraCajon removeCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().remove(camaraCajon);
		camaraCajon.setCamaraArea(null);

		return camaraCajon;
	}


	//bi-directional many-to-one association to CamaraCajonUbicacion
	@OneToMany(mappedBy="camaraArea")
	public List<CamaraCajonUbicacion> getCamaraCajonUbicacions() {
		return this.camaraCajonUbicacions;
	}

	public void setCamaraCajonUbicacions(List<CamaraCajonUbicacion> camaraCajonUbicacions) {
		this.camaraCajonUbicacions = camaraCajonUbicacions;
	}

	public CamaraCajonUbicacion addCamaraCajonUbicacion(CamaraCajonUbicacion camaraCajonUbicacion) {
		getCamaraCajonUbicacions().add(camaraCajonUbicacion);
		camaraCajonUbicacion.setCamaraArea(this);

		return camaraCajonUbicacion;
	}

	public CamaraCajonUbicacion removeCamaraCajonUbicacion(CamaraCajonUbicacion camaraCajonUbicacion) {
		getCamaraCajonUbicacions().remove(camaraCajonUbicacion);
		camaraCajonUbicacion.setCamaraArea(null);

		return camaraCajonUbicacion;
	}

}