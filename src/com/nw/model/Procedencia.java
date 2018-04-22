package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the procedencia database table.
 * 
 */
@Entity
public class Procedencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idprocedencia;

	private String descripcionprocedencia;

	//bi-directional many-to-one association to Area
	@OneToMany(mappedBy="procedencia")
	private List<Area> areas;

	public Procedencia() {
	}

	public Integer getIdprocedencia() {
		return this.idprocedencia;
	}

	public void setIdprocedencia(Integer idprocedencia) {
		this.idprocedencia = idprocedencia;
	}

	public String getDescripcionprocedencia() {
		return this.descripcionprocedencia;
	}

	public void setDescripcionprocedencia(String descripcionprocedencia) {
		this.descripcionprocedencia = descripcionprocedencia;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

}