package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calidad_grado_medicion_sensorial database table.
 * 
 */
@Entity
@Table(name="calidad_grado_medicion_sensorial")
public class CalidadGradoMedicionSensorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idgrado;

	private String abreviacion;

	private String descripcion;

	private String valor;

	public CalidadGradoMedicionSensorial() {
	}

	public Integer getIdgrado() {
		return this.idgrado;
	}

	public void setIdgrado(Integer idgrado) {
		this.idgrado = idgrado;
	}

	public String getAbreviacion() {
		return this.abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}