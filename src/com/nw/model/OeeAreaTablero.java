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
@NamedQuery(name="OeeAreaTablero.findAll", query="SELECT o FROM OeeAreaTablero o")
public class OeeAreaTablero implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idOeeAreaTablero;
	private String descripcion;
	private List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos;

	public OeeAreaTablero() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_area_tablero")
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


	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@OneToMany(mappedBy="oeeAreaTablero")
	public List<OeePeriodoBaseObjetivo> getOeePeriodoBaseObjetivos() {
		return this.oeePeriodoBaseObjetivos;
	}

	public void setOeePeriodoBaseObjetivos(List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos) {
		this.oeePeriodoBaseObjetivos = oeePeriodoBaseObjetivos;
	}

	public OeePeriodoBaseObjetivo addOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		getOeePeriodoBaseObjetivos().add(oeePeriodoBaseObjetivo);
		oeePeriodoBaseObjetivo.setOeeAreaTablero(this);

		return oeePeriodoBaseObjetivo;
	}

	public OeePeriodoBaseObjetivo removeOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		getOeePeriodoBaseObjetivos().remove(oeePeriodoBaseObjetivo);
		oeePeriodoBaseObjetivo.setOeeAreaTablero(null);

		return oeePeriodoBaseObjetivo;
	}

}