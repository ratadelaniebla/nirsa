package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcargo;

	private String descripcion;

	public Cargo() {
	}

	public Integer getIdcargo() {
		return this.idcargo;
	}

	public void setIdcargo(Integer idcargo) {
		this.idcargo = idcargo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}