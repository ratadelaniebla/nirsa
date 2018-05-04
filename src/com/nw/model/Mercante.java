package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mercante database table.
 * 
 */
@Entity
@NamedQuery(name="Mercante.findAll", query="SELECT m FROM Mercante m")
public class Mercante implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idmercante;
	private String descripcionmercante;
	private List<Barco> barcos;
	private List<BarcoDescarga> barcoDescargas;

	public Mercante() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to Barco
	@OneToMany(mappedBy="mercante")
	public List<Barco> getBarcos() {
		return this.barcos;
	}

	public void setBarcos(List<Barco> barcos) {
		this.barcos = barcos;
	}

	public Barco addBarco(Barco barco) {
		getBarcos().add(barco);
		barco.setMercante(this);

		return barco;
	}

	public Barco removeBarco(Barco barco) {
		getBarcos().remove(barco);
		barco.setMercante(null);

		return barco;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@OneToMany(mappedBy="mercante")
	public List<BarcoDescarga> getBarcoDescargas() {
		return this.barcoDescargas;
	}

	public void setBarcoDescargas(List<BarcoDescarga> barcoDescargas) {
		this.barcoDescargas = barcoDescargas;
	}

	public BarcoDescarga addBarcoDescarga(BarcoDescarga barcoDescarga) {
		getBarcoDescargas().add(barcoDescarga);
		barcoDescarga.setMercante(this);

		return barcoDescarga;
	}

	public BarcoDescarga removeBarcoDescarga(BarcoDescarga barcoDescarga) {
		getBarcoDescargas().remove(barcoDescarga);
		barcoDescarga.setMercante(null);

		return barcoDescarga;
	}

}