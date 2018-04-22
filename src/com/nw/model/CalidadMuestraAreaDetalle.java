package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_muestra_area_detalle database table.
 * 
 */
@Entity
@Table(name="calidad_muestra_area_detalle")
public class CalidadMuestraAreaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadmuestraareadetalle;

	private String comentario;

	private Timestamp fecharegistro;

	private Integer grupo;

	private double histaminaindividual;

	private double histaminaporgrupo;

	private Integer idcalidadmuestragrupoanalisis;

	private Integer ordenregistro;

	private Integer pintar;

	private Integer sal;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@ManyToOne
	@JoinColumn(name="idcalidadmuestraareacabecera")
	private CalidadMuestraAreaCabecera calidadMuestraAreaCabecera;

	//bi-directional many-to-one association to CalidadMuestraCabeceraDescargaMotivo
	@ManyToOne
	@JoinColumn(name="idcalidadmuestracabeceradescargamotivo")
	private CalidadMuestraCabeceraDescargaMotivo calidadMuestraCabeceraDescargaMotivo;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadMuestraAreaDetalle() {
	}

	public Long getIdcalidadmuestraareadetalle() {
		return this.idcalidadmuestraareadetalle;
	}

	public void setIdcalidadmuestraareadetalle(Long idcalidadmuestraareadetalle) {
		this.idcalidadmuestraareadetalle = idcalidadmuestraareadetalle;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Integer getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	public double getHistaminaindividual() {
		return this.histaminaindividual;
	}

	public void setHistaminaindividual(double histaminaindividual) {
		this.histaminaindividual = histaminaindividual;
	}

	public double getHistaminaporgrupo() {
		return this.histaminaporgrupo;
	}

	public void setHistaminaporgrupo(double histaminaporgrupo) {
		this.histaminaporgrupo = histaminaporgrupo;
	}

	public Integer getIdcalidadmuestragrupoanalisis() {
		return this.idcalidadmuestragrupoanalisis;
	}

	public void setIdcalidadmuestragrupoanalisis(Integer idcalidadmuestragrupoanalisis) {
		this.idcalidadmuestragrupoanalisis = idcalidadmuestragrupoanalisis;
	}

	public Integer getOrdenregistro() {
		return this.ordenregistro;
	}

	public void setOrdenregistro(Integer ordenregistro) {
		this.ordenregistro = ordenregistro;
	}

	public Integer getPintar() {
		return this.pintar;
	}

	public void setPintar(Integer pintar) {
		this.pintar = pintar;
	}

	public Integer getSal() {
		return this.sal;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}

	public CalidadMuestraAreaCabecera getCalidadMuestraAreaCabecera() {
		return this.calidadMuestraAreaCabecera;
	}

	public void setCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		this.calidadMuestraAreaCabecera = calidadMuestraAreaCabecera;
	}

	public CalidadMuestraCabeceraDescargaMotivo getCalidadMuestraCabeceraDescargaMotivo() {
		return this.calidadMuestraCabeceraDescargaMotivo;
	}

	public void setCalidadMuestraCabeceraDescargaMotivo(CalidadMuestraCabeceraDescargaMotivo calidadMuestraCabeceraDescargaMotivo) {
		this.calidadMuestraCabeceraDescargaMotivo = calidadMuestraCabeceraDescargaMotivo;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}