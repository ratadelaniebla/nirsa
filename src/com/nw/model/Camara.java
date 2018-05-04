package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the camara database table.
 * 
 */
@Entity
@NamedQuery(name="Camara.findAll", query="SELECT c FROM Camara c")
public class Camara implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcamara;
	private Integer descripcion;
	private Integer estado;
	private String idcamarasap;
	private Integer tipo;
	private List<CamaraCajon> camaraCajons;
	private List<CamaraCajonUbicacion> camaraCajonUbicacions;
	private List<CamaraFilaColumna> camaraFilaColumnas;

	public Camara() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcamara() {
		return this.idcamara;
	}

	public void setIdcamara(Long idcamara) {
		this.idcamara = idcamara;
	}


	public Integer getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(Integer descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public String getIdcamarasap() {
		return this.idcamarasap;
	}

	public void setIdcamarasap(String idcamarasap) {
		this.idcamarasap = idcamarasap;
	}


	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="camara")
	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public CamaraCajon addCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().add(camaraCajon);
		camaraCajon.setCamara(this);

		return camaraCajon;
	}

	public CamaraCajon removeCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().remove(camaraCajon);
		camaraCajon.setCamara(null);

		return camaraCajon;
	}


	//bi-directional many-to-one association to CamaraCajonUbicacion
	@OneToMany(mappedBy="camara")
	public List<CamaraCajonUbicacion> getCamaraCajonUbicacions() {
		return this.camaraCajonUbicacions;
	}

	public void setCamaraCajonUbicacions(List<CamaraCajonUbicacion> camaraCajonUbicacions) {
		this.camaraCajonUbicacions = camaraCajonUbicacions;
	}

	public CamaraCajonUbicacion addCamaraCajonUbicacion(CamaraCajonUbicacion camaraCajonUbicacion) {
		getCamaraCajonUbicacions().add(camaraCajonUbicacion);
		camaraCajonUbicacion.setCamara(this);

		return camaraCajonUbicacion;
	}

	public CamaraCajonUbicacion removeCamaraCajonUbicacion(CamaraCajonUbicacion camaraCajonUbicacion) {
		getCamaraCajonUbicacions().remove(camaraCajonUbicacion);
		camaraCajonUbicacion.setCamara(null);

		return camaraCajonUbicacion;
	}


	//bi-directional many-to-one association to CamaraFilaColumna
	@OneToMany(mappedBy="camara")
	public List<CamaraFilaColumna> getCamaraFilaColumnas() {
		return this.camaraFilaColumnas;
	}

	public void setCamaraFilaColumnas(List<CamaraFilaColumna> camaraFilaColumnas) {
		this.camaraFilaColumnas = camaraFilaColumnas;
	}

	public CamaraFilaColumna addCamaraFilaColumna(CamaraFilaColumna camaraFilaColumna) {
		getCamaraFilaColumnas().add(camaraFilaColumna);
		camaraFilaColumna.setCamara(this);

		return camaraFilaColumna;
	}

	public CamaraFilaColumna removeCamaraFilaColumna(CamaraFilaColumna camaraFilaColumna) {
		getCamaraFilaColumnas().remove(camaraFilaColumna);
		camaraFilaColumna.setCamara(null);

		return camaraFilaColumna;
	}

}