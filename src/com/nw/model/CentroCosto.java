package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the centro_costo database table.
 * 
 */
@Entity
@Table(name="centro_costo")
public class CentroCosto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcentrocosto;

	private String descripcion;

	private Integer propiedad;

	//bi-directional many-to-one association to Nomina
	@OneToMany(mappedBy="centroCosto")
	private List<Nomina> nominas;

	public CentroCosto() {
	}

	public Integer getIdcentrocosto() {
		return this.idcentrocosto;
	}

	public void setIdcentrocosto(Integer idcentrocosto) {
		this.idcentrocosto = idcentrocosto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPropiedad() {
		return this.propiedad;
	}

	public void setPropiedad(Integer propiedad) {
		this.propiedad = propiedad;
	}

	public List<Nomina> getNominas() {
		return this.nominas;
	}

	public void setNominas(List<Nomina> nominas) {
		this.nominas = nominas;
	}

}