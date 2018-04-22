package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mercante database table.
 * 
 */
@Entity
public class Mercante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idmercante;

	private String descripcionmercante;

	//bi-directional many-to-one association to Barco
	@OneToMany(mappedBy="mercante")
	private List<Barco> barcos;

	//bi-directional many-to-one association to BarcoDescarga
	@OneToMany(mappedBy="mercante")
	private List<BarcoDescarga> barcoDescargas;

	public Mercante() {
	}

	public Integer getIdmercante() {
		return this.idmercante;
	}

	public void setIdmercante(Integer idmercante) {
		this.idmercante = idmercante;
	}

	public String getDescripcionmercante() {
		return this.descripcionmercante;
	}

	public void setDescripcionmercante(String descripcionmercante) {
		this.descripcionmercante = descripcionmercante;
	}

	public List<Barco> getBarcos() {
		return this.barcos;
	}

	public void setBarcos(List<Barco> barcos) {
		this.barcos = barcos;
	}

	public List<BarcoDescarga> getBarcoDescargas() {
		return this.barcoDescargas;
	}

	public void setBarcoDescargas(List<BarcoDescarga> barcoDescargas) {
		this.barcoDescargas = barcoDescargas;
	}

}