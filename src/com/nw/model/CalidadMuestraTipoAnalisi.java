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
@NamedQuery(name="CalidadMuestraTipoAnalisi.findAll", query="SELECT c FROM CalidadMuestraTipoAnalisi c")
public class CalidadMuestraTipoAnalisi implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcalidadmuestratipoanalisis;
	private Integer compositas;
	private String descripcion;
	private Integer limiteppm;
	private String textoIndividual;
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;

	public CalidadMuestraTipoAnalisi() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="texto_individual")
	public String getTextoIndividual() {
		return this.textoIndividual;
	}

	public void setTextoIndividual(String textoIndividual) {
		this.textoIndividual = textoIndividual;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="calidadMuestraTipoAnalisi")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public CalidadMuestraAreaCabecera addCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().add(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setCalidadMuestraTipoAnalisi(this);

		return calidadMuestraAreaCabecera;
	}

	public CalidadMuestraAreaCabecera removeCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().remove(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setCalidadMuestraTipoAnalisi(null);

		return calidadMuestraAreaCabecera;
	}

}