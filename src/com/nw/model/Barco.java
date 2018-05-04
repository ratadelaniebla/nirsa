package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the barco database table.
 * 
 */
@Entity
@NamedQuery(name="Barco.findAll", query="SELECT b FROM Barco b")
public class Barco implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idbarco;
	private String idnomina;
	private String nombre;
	private String numbarco;
	private BarcoPropiedad barcoPropiedad;
	private Mercante mercante;
	private List<BarcoCuba> barcoCubas;
	private List<BarcoDescarga> barcoDescargas;

	public Barco() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to BarcoPropiedad
	@ManyToOne
	@JoinColumn(name="idpropiedad")
	public BarcoPropiedad getBarcoPropiedad() {
		return this.barcoPropiedad;
	}

	public void setBarcoPropiedad(BarcoPropiedad barcoPropiedad) {
		this.barcoPropiedad = barcoPropiedad;
	}


	//bi-directional many-to-one association to Mercante
	@ManyToOne
	@JoinColumn(name="idmercante")
	public Mercante getMercante() {
		return this.mercante;
	}

	public void setMercante(Mercante mercante) {
		this.mercante = mercante;
	}


	//bi-directional many-to-one association to BarcoCuba
	@OneToMany(mappedBy="barco")
	public List<BarcoCuba> getBarcoCubas() {
		return this.barcoCubas;
	}

	public void setBarcoCubas(List<BarcoCuba> barcoCubas) {
		this.barcoCubas = barcoCubas;
	}

	public BarcoCuba addBarcoCuba(BarcoCuba barcoCuba) {
		getBarcoCubas().add(barcoCuba);
		barcoCuba.setBarco(this);

		return barcoCuba;
	}

	public BarcoCuba removeBarcoCuba(BarcoCuba barcoCuba) {
		getBarcoCubas().remove(barcoCuba);
		barcoCuba.setBarco(null);

		return barcoCuba;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@OneToMany(mappedBy="barco")
	public List<BarcoDescarga> getBarcoDescargas() {
		return this.barcoDescargas;
	}

	public void setBarcoDescargas(List<BarcoDescarga> barcoDescargas) {
		this.barcoDescargas = barcoDescargas;
	}

	public BarcoDescarga addBarcoDescarga(BarcoDescarga barcoDescarga) {
		getBarcoDescargas().add(barcoDescarga);
		barcoDescarga.setBarco(this);

		return barcoDescarga;
	}

	public BarcoDescarga removeBarcoDescarga(BarcoDescarga barcoDescarga) {
		getBarcoDescargas().remove(barcoDescarga);
		barcoDescarga.setBarco(null);

		return barcoDescarga;
	}

}