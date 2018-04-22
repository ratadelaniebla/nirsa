package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_muestra_area database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_area")
public class CalidadMuestraArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestraarea;

	@Column(name="accion_correctiva")
	private String accionCorrectiva;

	@Column(name="area_referencia")
	private String areaReferencia;

	private String descripcion;

	private Integer estado;

	@Column(name="identificacion_area")
	private String identificacionArea;

	@Column(name="orden_area")
	private Integer ordenArea;

	private Integer pescadosporarea;

	@Column(name="texto_pie_pagina_accion_correctiva")
	private String textoPiePaginaAccionCorrectiva;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="calidadMuestraArea")
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;

	//bi-directional many-to-one association to CalidadMuestraAreaCabeceraAprobacion
	@OneToMany(mappedBy="calidadMuestraArea")
	private List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions;

	//bi-directional many-to-one association to CalidadVariable
	@OneToMany(mappedBy="calidadMuestraArea")
	private List<CalidadVariable> calidadVariables;

	public CalidadMuestraArea() {
	}

	public Long getIdcalidadmuestraarea() {
		return this.idcalidadmuestraarea;
	}

	public void setIdcalidadmuestraarea(Long idcalidadmuestraarea) {
		this.idcalidadmuestraarea = idcalidadmuestraarea;
	}

	public String getAccionCorrectiva() {
		return this.accionCorrectiva;
	}

	public void setAccionCorrectiva(String accionCorrectiva) {
		this.accionCorrectiva = accionCorrectiva;
	}

	public String getAreaReferencia() {
		return this.areaReferencia;
	}

	public void setAreaReferencia(String areaReferencia) {
		this.areaReferencia = areaReferencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getIdentificacionArea() {
		return this.identificacionArea;
	}

	public void setIdentificacionArea(String identificacionArea) {
		this.identificacionArea = identificacionArea;
	}

	public Integer getOrdenArea() {
		return this.ordenArea;
	}

	public void setOrdenArea(Integer ordenArea) {
		this.ordenArea = ordenArea;
	}

	public Integer getPescadosporarea() {
		return this.pescadosporarea;
	}

	public void setPescadosporarea(Integer pescadosporarea) {
		this.pescadosporarea = pescadosporarea;
	}

	public String getTextoPiePaginaAccionCorrectiva() {
		return this.textoPiePaginaAccionCorrectiva;
	}

	public void setTextoPiePaginaAccionCorrectiva(String textoPiePaginaAccionCorrectiva) {
		this.textoPiePaginaAccionCorrectiva = textoPiePaginaAccionCorrectiva;
	}

	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public List<CalidadMuestraAreaCabeceraAprobacion> getCalidadMuestraAreaCabeceraAprobacions() {
		return this.calidadMuestraAreaCabeceraAprobacions;
	}

	public void setCalidadMuestraAreaCabeceraAprobacions(List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions) {
		this.calidadMuestraAreaCabeceraAprobacions = calidadMuestraAreaCabeceraAprobacions;
	}

	public List<CalidadVariable> getCalidadVariables() {
		return this.calidadVariables;
	}

	public void setCalidadVariables(List<CalidadVariable> calidadVariables) {
		this.calidadVariables = calidadVariables;
	}

}