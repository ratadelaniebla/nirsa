package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the procedencia database table.
 * 
 */
@Entity
@NamedQuery(name="Procedencia.findAll", query="SELECT p FROM Procedencia p")
public class Procedencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idprocedencia;
	private String descripcionprocedencia;
	private List<Area> areas;

	public Procedencia() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to Area
	@OneToMany(mappedBy="procedencia")
	public List<Area> getAreas() {
		return this.areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Area addArea(Area area) {
		getAreas().add(area);
		area.setProcedencia(this);

		return area;
	}

	public Area removeArea(Area area) {
		getAreas().remove(area);
		area.setProcedencia(null);

		return area;
	}

}