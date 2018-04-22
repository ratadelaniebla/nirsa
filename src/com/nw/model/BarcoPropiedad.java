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
public class BarcoPropiedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idpropiedad;

	private String descripcion;

	//bi-directional many-to-one association to Barco
	@OneToMany(mappedBy="barcoPropiedad")
	private List<Barco> barcos;

	public BarcoPropiedad() {
	}

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

	public List<Barco> getBarcos() {
		return this.barcos;
	}

	public void setBarcos(List<Barco> barcos) {
		this.barcos = barcos;
	}

}