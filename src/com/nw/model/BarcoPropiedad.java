package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the barco_propiedad database table.
 * 
 */
@Entity
@Table(name="barco_propiedad")
@NamedQuery(name="BarcoPropiedad.findAll", query="SELECT b FROM BarcoPropiedad b")
public class BarcoPropiedad implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idpropiedad;
	private String descripcion;
	private List<Barco> barcos;

	public BarcoPropiedad() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdpropiedad() {
		return this.idpropiedad;
	}

	public void setIdpropiedad(Integer idpropiedad) {
		this.idpropiedad = idpropiedad;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	//bi-directional many-to-one association to Barco
	@OneToMany(mappedBy="barcoPropiedad")
	public List<Barco> getBarcos() {
		return this.barcos;
	}

	public void setBarcos(List<Barco> barcos) {
		this.barcos = barcos;
	}

	public Barco addBarco(Barco barco) {
		getBarcos().add(barco);
		barco.setBarcoPropiedad(this);

		return barco;
	}

	public Barco removeBarco(Barco barco) {
		getBarcos().remove(barco);
		barco.setBarcoPropiedad(null);

		return barco;
	}

}