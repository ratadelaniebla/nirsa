package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the barco database table.
 * 
 */
@Entity
public class Barco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbarco;

	private String idnomina;

	private String nombre;

	private String numbarco;

	//bi-directional many-to-one association to BarcoPropiedad
	@ManyToOne
	@JoinColumn(name="idpropiedad")
	private BarcoPropiedad barcoPropiedad;

	//bi-directional many-to-one association to Mercante
	@ManyToOne
	@JoinColumn(name="idmercante")
	private Mercante mercante;

	//bi-directional many-to-one association to BarcoCuba
	@OneToMany(mappedBy="barco")
	private List<BarcoCuba> barcoCubas;

	//bi-directional many-to-one association to BarcoDescarga
	@OneToMany(mappedBy="barco")
	private List<BarcoDescarga> barcoDescargas;

	public Barco() {
	}

	public Integer getIdbarco() {
		return this.idbarco;
	}

	public void setIdbarco(Integer idbarco) {
		this.idbarco = idbarco;
	}

	public String getIdnomina() {
		return this.idnomina;
	}

	public void setIdnomina(String idnomina) {
		this.idnomina = idnomina;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumbarco() {
		return this.numbarco;
	}

	public void setNumbarco(String numbarco) {
		this.numbarco = numbarco;
	}

	public BarcoPropiedad getBarcoPropiedad() {
		return this.barcoPropiedad;
	}

	public void setBarcoPropiedad(BarcoPropiedad barcoPropiedad) {
		this.barcoPropiedad = barcoPropiedad;
	}

	public Mercante getMercante() {
		return this.mercante;
	}

	public void setMercante(Mercante mercante) {
		this.mercante = mercante;
	}

	public List<BarcoCuba> getBarcoCubas() {
		return this.barcoCubas;
	}

	public void setBarcoCubas(List<BarcoCuba> barcoCubas) {
		this.barcoCubas = barcoCubas;
	}

	public List<BarcoDescarga> getBarcoDescargas() {
		return this.barcoDescargas;
	}

	public void setBarcoDescargas(List<BarcoDescarga> barcoDescargas) {
		this.barcoDescargas = barcoDescargas;
	}

}