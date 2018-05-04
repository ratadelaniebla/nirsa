package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the calidad_variable database table.
 * 
 */
@Entity
@Table(name="calidad_variable")
@NamedQuery(name="CalidadVariable.findAll", query="SELECT c FROM CalidadVariable c")
public class CalidadVariable implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadvariable;
	private Integer estado;
	private Integer numerovariable;
	private Integer ordentexto;
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;
	private CalidadAccionCorrectivaTexto calidadAccionCorrectivaTexto;
	private CalidadMuestraArea calidadMuestraArea;

	public CalidadVariable() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidadvariable() {
		return this.idcalidadvariable;
	}

	public void setIdcalidadvariable(Long idcalidadvariable) {
		this.idcalidadvariable = idcalidadvariable;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Integer getNumerovariable() {
		return this.numerovariable;
	}

	public void setNumerovariable(Integer numerovariable) {
		this.numerovariable = numerovariable;
	}


	public Integer getOrdentexto() {
		return this.ordentexto;
	}

	public void setOrdentexto(Integer ordentexto) {
		this.ordentexto = ordentexto;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="calidadVariable")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public CalidadMuestraAreaCabecera addCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().add(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setCalidadVariable(this);

		return calidadMuestraAreaCabecera;
	}

	public CalidadMuestraAreaCabecera removeCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().remove(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setCalidadVariable(null);

		return calidadMuestraAreaCabecera;
	}


	//bi-directional many-to-one association to CalidadAccionCorrectivaTexto
	@ManyToOne
	@JoinColumn(name="idcalidadaccioncorrectivatexto")
	public CalidadAccionCorrectivaTexto getCalidadAccionCorrectivaTexto() {
		return this.calidadAccionCorrectivaTexto;
	}

	public void setCalidadAccionCorrectivaTexto(CalidadAccionCorrectivaTexto calidadAccionCorrectivaTexto) {
		this.calidadAccionCorrectivaTexto = calidadAccionCorrectivaTexto;
	}


	//bi-directional many-to-one association to CalidadMuestraArea
	@ManyToOne
	@JoinColumn(name="idcalidadmuestraarea")
	public CalidadMuestraArea getCalidadMuestraArea() {
		return this.calidadMuestraArea;
	}

	public void setCalidadMuestraArea(CalidadMuestraArea calidadMuestraArea) {
		this.calidadMuestraArea = calidadMuestraArea;
	}

}