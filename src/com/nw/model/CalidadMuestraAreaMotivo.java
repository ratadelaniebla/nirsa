package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_muestra_area_motivo database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_area_motivo")
public class CalidadMuestraAreaMotivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcalidadmuestraareamotivo;

	private String descripcion;

	private Integer estado;

	private String texto;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="calidadMuestraAreaMotivo")
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;

	//bi-directional many-to-one association to CalidadMuestraCabeceraDescargaMotivo
	@OneToMany(mappedBy="calidadMuestraAreaMotivo")
	private List<CalidadMuestraCabeceraDescargaMotivo> calidadMuestraCabeceraDescargaMotivos;

	public CalidadMuestraAreaMotivo() {
	}

	public Integer getIdcalidadmuestraareamotivo() {
		return this.idcalidadmuestraareamotivo;
	}

	public void setIdcalidadmuestraareamotivo(Integer idcalidadmuestraareamotivo) {
		this.idcalidadmuestraareamotivo = idcalidadmuestraareamotivo;
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

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public List<CalidadMuestraCabeceraDescargaMotivo> getCalidadMuestraCabeceraDescargaMotivos() {
		return this.calidadMuestraCabeceraDescargaMotivos;
	}

	public void setCalidadMuestraCabeceraDescargaMotivos(List<CalidadMuestraCabeceraDescargaMotivo> calidadMuestraCabeceraDescargaMotivos) {
		this.calidadMuestraCabeceraDescargaMotivos = calidadMuestraCabeceraDescargaMotivos;
	}

}