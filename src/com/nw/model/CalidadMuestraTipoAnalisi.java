package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_muestra_tipo_analisis database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_tipo_analisis")
public class CalidadMuestraTipoAnalisi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcalidadmuestratipoanalisis;

	private Integer compositas;

	private String descripcion;

	private Integer limiteppm;

	@Column(name="texto_individual")
	private String textoIndividual;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="calidadMuestraTipoAnalisi")
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;

	public CalidadMuestraTipoAnalisi() {
	}

	public Integer getIdcalidadmuestratipoanalisis() {
		return this.idcalidadmuestratipoanalisis;
	}

	public void setIdcalidadmuestratipoanalisis(Integer idcalidadmuestratipoanalisis) {
		this.idcalidadmuestratipoanalisis = idcalidadmuestratipoanalisis;
	}

	public Integer getCompositas() {
		return this.compositas;
	}

	public void setCompositas(Integer compositas) {
		this.compositas = compositas;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getLimiteppm() {
		return this.limiteppm;
	}

	public void setLimiteppm(Integer limiteppm) {
		this.limiteppm = limiteppm;
	}

	public String getTextoIndividual() {
		return this.textoIndividual;
	}

	public void setTextoIndividual(String textoIndividual) {
		this.textoIndividual = textoIndividual;
	}

	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

}