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
@NamedQuery(name="CalidadMuestraAreaMotivo.findAll", query="SELECT c FROM CalidadMuestraAreaMotivo c")
public class CalidadMuestraAreaMotivo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcalidadmuestraareamotivo;
	private String descripcion;
	private Integer estado;
	private String texto;
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;
	private List<CalidadMuestraCabeceraDescargaMotivo> calidadMuestraCabeceraDescargaMotivos;

	public CalidadMuestraAreaMotivo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="calidadMuestraAreaMotivo")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public CalidadMuestraAreaCabecera addCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().add(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setCalidadMuestraAreaMotivo(this);

		return calidadMuestraAreaCabecera;
	}

	public CalidadMuestraAreaCabecera removeCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().remove(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setCalidadMuestraAreaMotivo(null);

		return calidadMuestraAreaCabecera;
	}


	//bi-directional many-to-one association to CalidadMuestraCabeceraDescargaMotivo
	@OneToMany(mappedBy="calidadMuestraAreaMotivo")
	public List<CalidadMuestraCabeceraDescargaMotivo> getCalidadMuestraCabeceraDescargaMotivos() {
		return this.calidadMuestraCabeceraDescargaMotivos;
	}

	public void setCalidadMuestraCabeceraDescargaMotivos(List<CalidadMuestraCabeceraDescargaMotivo> calidadMuestraCabeceraDescargaMotivos) {
		this.calidadMuestraCabeceraDescargaMotivos = calidadMuestraCabeceraDescargaMotivos;
	}

	public CalidadMuestraCabeceraDescargaMotivo addCalidadMuestraCabeceraDescargaMotivo(CalidadMuestraCabeceraDescargaMotivo calidadMuestraCabeceraDescargaMotivo) {
		getCalidadMuestraCabeceraDescargaMotivos().add(calidadMuestraCabeceraDescargaMotivo);
		calidadMuestraCabeceraDescargaMotivo.setCalidadMuestraAreaMotivo(this);

		return calidadMuestraCabeceraDescargaMotivo;
	}

	public CalidadMuestraCabeceraDescargaMotivo removeCalidadMuestraCabeceraDescargaMotivo(CalidadMuestraCabeceraDescargaMotivo calidadMuestraCabeceraDescargaMotivo) {
		getCalidadMuestraCabeceraDescargaMotivos().remove(calidadMuestraCabeceraDescargaMotivo);
		calidadMuestraCabeceraDescargaMotivo.setCalidadMuestraAreaMotivo(null);

		return calidadMuestraCabeceraDescargaMotivo;
	}

}