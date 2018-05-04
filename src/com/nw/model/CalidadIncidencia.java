package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the calidad_incidencia database table.
 * 
 */
@Entity
@Table(name="calidad_incidencia")
@NamedQuery(name="CalidadIncidencia.findAll", query="SELECT c FROM CalidadIncidencia c")
public class CalidadIncidencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadincidencia;
	private Integer idcalidadobservacion;
	private BigDecimal idmuestra;
	private Long idnumformato;
	private Long idnummedio;
	private double valorcuantitativo;
	private Codificacion codificacion;
	private Medio medio;

	public CalidadIncidencia() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcalidadincidencia() {
		return this.idcalidadincidencia;
	}

	public void setIdcalidadincidencia(Long idcalidadincidencia) {
		this.idcalidadincidencia = idcalidadincidencia;
	}


	public Integer getIdcalidadobservacion() {
		return this.idcalidadobservacion;
	}

	public void setIdcalidadobservacion(Integer idcalidadobservacion) {
		this.idcalidadobservacion = idcalidadobservacion;
	}


	public BigDecimal getIdmuestra() {
		return this.idmuestra;
	}

	public void setIdmuestra(BigDecimal idmuestra) {
		this.idmuestra = idmuestra;
	}


	public Long getIdnumformato() {
		return this.idnumformato;
	}

	public void setIdnumformato(Long idnumformato) {
		this.idnumformato = idnumformato;
	}


	public Long getIdnummedio() {
		return this.idnummedio;
	}

	public void setIdnummedio(Long idnummedio) {
		this.idnummedio = idnummedio;
	}


	public double getValorcuantitativo() {
		return this.valorcuantitativo;
	}

	public void setValorcuantitativo(double valorcuantitativo) {
		this.valorcuantitativo = valorcuantitativo;
	}


	//bi-directional many-to-one association to Codificacion
	@ManyToOne
	@JoinColumn(name="idformato")
	public Codificacion getCodificacion() {
		return this.codificacion;
	}

	public void setCodificacion(Codificacion codificacion) {
		this.codificacion = codificacion;
	}


	//bi-directional many-to-one association to Medio
	@ManyToOne
	@JoinColumn(name="idmedio")
	public Medio getMedio() {
		return this.medio;
	}

	public void setMedio(Medio medio) {
		this.medio = medio;
	}

}