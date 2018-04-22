package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oee_area_tablero database table.
 * 
 */
@Entity
@Table(name="oee_area_tablero")
public class OeeAreaTablero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_area_tablero")
	private Integer idOeeAreaTablero;

	private String descripcion;

	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@OneToMany(mappedBy="oeeAreaTablero")
	private List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos;

	public OeeAreaTablero() {
	}

	public Integer getIdOeeAreaTablero() {
		return this.idOeeAreaTablero;
	}

	public void setIdOeeAreaTablero(Integer idOeeAreaTablero) {
		this.idOeeAreaTablero = idOeeAreaTablero;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<OeePeriodoBaseObjetivo> getOeePeriodoBaseObjetivos() {
		return this.oeePeriodoBaseObjetivos;
	}

	public void setOeePeriodoBaseObjetivos(List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos) {
		this.oeePeriodoBaseObjetivos = oeePeriodoBaseObjetivos;
	}

}