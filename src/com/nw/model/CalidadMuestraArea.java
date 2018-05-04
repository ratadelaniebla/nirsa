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
@NamedQuery(name="CalidadMuestraArea.findAll", query="SELECT c FROM CalidadMuestraArea c")
public class CalidadMuestraArea implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadmuestraarea;
	private String accionCorrectiva;
	private String areaReferencia;
	private String descripcion;
	private Integer estado;
	private String identificacionArea;
	private Integer ordenArea;
	private Integer pescadosporarea;
	private String textoPiePaginaAccionCorrectiva;
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;
	private List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions;
	private List<CalidadVariable> calidadVariables;

	public CalidadMuestraArea() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidadmuestraarea() {
		return this.idcalidadmuestraarea;
	}

	public void setIdcalidadmuestraarea(Long idcalidadmuestraarea) {
		this.idcalidadmuestraarea = idcalidadmuestraarea;
	}


	@Column(name="accion_correctiva")
	public String getAccionCorrectiva() {
		return this.accionCorrectiva;
	}

	public void setAccionCorrectiva(String accionCorrectiva) {
		this.accionCorrectiva = accionCorrectiva;
	}


	@Column(name="area_referencia")
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


	@Column(name="identificacion_area")
	public String getIdentificacionArea() {
		return this.identificacionArea;
	}

	public void setIdentificacionArea(String identificacionArea) {
		this.identificacionArea = identificacionArea;
	}


	@Column(name="orden_area")
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


	@Column(name="texto_pie_pagina_accion_correctiva")
	public String getTextoPiePaginaAccionCorrectiva() {
		return this.textoPiePaginaAccionCorrectiva;
	}

	public void setTextoPiePaginaAccionCorrectiva(String textoPiePaginaAccionCorrectiva) {
		this.textoPiePaginaAccionCorrectiva = textoPiePaginaAccionCorrectiva;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="calidadMuestraArea")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public CalidadMuestraAreaCabecera addCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().add(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setCalidadMuestraArea(this);

		return calidadMuestraAreaCabecera;
	}

	public CalidadMuestraAreaCabecera removeCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().remove(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setCalidadMuestraArea(null);

		return calidadMuestraAreaCabecera;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaCabeceraAprobacion
	@OneToMany(mappedBy="calidadMuestraArea")
	public List<CalidadMuestraAreaCabeceraAprobacion> getCalidadMuestraAreaCabeceraAprobacions() {
		return this.calidadMuestraAreaCabeceraAprobacions;
	}

	public void setCalidadMuestraAreaCabeceraAprobacions(List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions) {
		this.calidadMuestraAreaCabeceraAprobacions = calidadMuestraAreaCabeceraAprobacions;
	}

	public CalidadMuestraAreaCabeceraAprobacion addCalidadMuestraAreaCabeceraAprobacion(CalidadMuestraAreaCabeceraAprobacion calidadMuestraAreaCabeceraAprobacion) {
		getCalidadMuestraAreaCabeceraAprobacions().add(calidadMuestraAreaCabeceraAprobacion);
		calidadMuestraAreaCabeceraAprobacion.setCalidadMuestraArea(this);

		return calidadMuestraAreaCabeceraAprobacion;
	}

	public CalidadMuestraAreaCabeceraAprobacion removeCalidadMuestraAreaCabeceraAprobacion(CalidadMuestraAreaCabeceraAprobacion calidadMuestraAreaCabeceraAprobacion) {
		getCalidadMuestraAreaCabeceraAprobacions().remove(calidadMuestraAreaCabeceraAprobacion);
		calidadMuestraAreaCabeceraAprobacion.setCalidadMuestraArea(null);

		return calidadMuestraAreaCabeceraAprobacion;
	}


	//bi-directional many-to-one association to CalidadVariable
	@OneToMany(mappedBy="calidadMuestraArea")
	public List<CalidadVariable> getCalidadVariables() {
		return this.calidadVariables;
	}

	public void setCalidadVariables(List<CalidadVariable> calidadVariables) {
		this.calidadVariables = calidadVariables;
	}

	public CalidadVariable addCalidadVariable(CalidadVariable calidadVariable) {
		getCalidadVariables().add(calidadVariable);
		calidadVariable.setCalidadMuestraArea(this);

		return calidadVariable;
	}

	public CalidadVariable removeCalidadVariable(CalidadVariable calidadVariable) {
		getCalidadVariables().remove(calidadVariable);
		calidadVariable.setCalidadMuestraArea(null);

		return calidadVariable;
	}

}