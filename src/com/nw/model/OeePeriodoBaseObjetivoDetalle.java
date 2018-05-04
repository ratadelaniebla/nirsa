package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_periodo_base_objetivo_detalle database table.
 * 
 */
@Entity
@Table(name="oee_periodo_base_objetivo_detalle")
@NamedQuery(name="OeePeriodoBaseObjetivoDetalle.findAll", query="SELECT o FROM OeePeriodoBaseObjetivoDetalle o")
public class OeePeriodoBaseObjetivoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idOeePeriodoBaseObjetivoDetalle;
	private String descripcionIndicador;
	private Boolean estado;
	private double objetivo;
	private Integer orden;
	private double periodoBase;
	private double rango1Entregacamara;
	private double rango1Ingresodescongelado;
	private double rango2Entregacamara;
	private double rango2Ingresodescongelado;
	private double rango3Entregacamara;
	private double rango3Ingresodescongelado;
	private OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo;

	public OeePeriodoBaseObjetivoDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_periodo_base_objetivo_detalle")
	public Long getIdOeePeriodoBaseObjetivoDetalle() {
		return this.idOeePeriodoBaseObjetivoDetalle;
	}

	public void setIdOeePeriodoBaseObjetivoDetalle(Long idOeePeriodoBaseObjetivoDetalle) {
		this.idOeePeriodoBaseObjetivoDetalle = idOeePeriodoBaseObjetivoDetalle;
	}


	@Column(name="descripcion_indicador")
	public String getDescripcionIndicador() {
		return this.descripcionIndicador;
	}

	public void setDescripcionIndicador(String descripcionIndicador) {
		this.descripcionIndicador = descripcionIndicador;
	}


	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public double getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(double objetivo) {
		this.objetivo = objetivo;
	}


	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}


	@Column(name="periodo_base")
	public double getPeriodoBase() {
		return this.periodoBase;
	}

	public void setPeriodoBase(double periodoBase) {
		this.periodoBase = periodoBase;
	}


	@Column(name="rango1_entregacamara")
	public double getRango1Entregacamara() {
		return this.rango1Entregacamara;
	}

	public void setRango1Entregacamara(double rango1Entregacamara) {
		this.rango1Entregacamara = rango1Entregacamara;
	}


	@Column(name="rango1_ingresodescongelado")
	public double getRango1Ingresodescongelado() {
		return this.rango1Ingresodescongelado;
	}

	public void setRango1Ingresodescongelado(double rango1Ingresodescongelado) {
		this.rango1Ingresodescongelado = rango1Ingresodescongelado;
	}


	@Column(name="rango2_entregacamara")
	public double getRango2Entregacamara() {
		return this.rango2Entregacamara;
	}

	public void setRango2Entregacamara(double rango2Entregacamara) {
		this.rango2Entregacamara = rango2Entregacamara;
	}


	@Column(name="rango2_ingresodescongelado")
	public double getRango2Ingresodescongelado() {
		return this.rango2Ingresodescongelado;
	}

	public void setRango2Ingresodescongelado(double rango2Ingresodescongelado) {
		this.rango2Ingresodescongelado = rango2Ingresodescongelado;
	}


	@Column(name="rango3_entregacamara")
	public double getRango3Entregacamara() {
		return this.rango3Entregacamara;
	}

	public void setRango3Entregacamara(double rango3Entregacamara) {
		this.rango3Entregacamara = rango3Entregacamara;
	}


	@Column(name="rango3_ingresodescongelado")
	public double getRango3Ingresodescongelado() {
		return this.rango3Ingresodescongelado;
	}

	public void setRango3Ingresodescongelado(double rango3Ingresodescongelado) {
		this.rango3Ingresodescongelado = rango3Ingresodescongelado;
	}


	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@ManyToOne
	@JoinColumn(name="id_oee_periodo_base_objetivo")
	public OeePeriodoBaseObjetivo getOeePeriodoBaseObjetivo() {
		return this.oeePeriodoBaseObjetivo;
	}

	public void setOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		this.oeePeriodoBaseObjetivo = oeePeriodoBaseObjetivo;
	}

}