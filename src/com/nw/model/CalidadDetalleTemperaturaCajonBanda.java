package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_detalle_temperatura_cajon_banda database table.
 * 
 */
@Entity
@Table(name="calidad_detalle_temperatura_cajon_banda")
public class CalidadDetalleTemperaturaCajonBanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidaddetalletemperaturacajonbanda;

	private String cubaasociada;

	private Integer estadocajon;

	private Timestamp fechareg;

	private Timestamp fecharegactualizacion;

	private Integer limpieza;

	private Integer nummuestra;

	private String observaciones;

	private double temperatura;

	private String usuarioactualizacion;

	//bi-directional many-to-one association to BarcoCuba
	@ManyToOne
	@JoinColumn(name="idbarcocuba")
	private BarcoCuba barcoCuba;

	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	private Cajon cajon;

	//bi-directional many-to-one association to CalidadTemperaturaCajonBanda
	@ManyToOne
	@JoinColumn(name="idcalidadtemperaturacajonbanda")
	private CalidadTemperaturaCajonBanda calidadTemperaturaCajonBanda;

	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	private CamaraCajon camaraCajon;

	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	private EspecieTalla especieTalla;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadDetalleTemperaturaCajonBanda() {
	}

	public Long getIdcalidaddetalletemperaturacajonbanda() {
		return this.idcalidaddetalletemperaturacajonbanda;
	}

	public void setIdcalidaddetalletemperaturacajonbanda(Long idcalidaddetalletemperaturacajonbanda) {
		this.idcalidaddetalletemperaturacajonbanda = idcalidaddetalletemperaturacajonbanda;
	}

	public String getCubaasociada() {
		return this.cubaasociada;
	}

	public void setCubaasociada(String cubaasociada) {
		this.cubaasociada = cubaasociada;
	}

	public Integer getEstadocajon() {
		return this.estadocajon;
	}

	public void setEstadocajon(Integer estadocajon) {
		this.estadocajon = estadocajon;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Timestamp getFecharegactualizacion() {
		return this.fecharegactualizacion;
	}

	public void setFecharegactualizacion(Timestamp fecharegactualizacion) {
		this.fecharegactualizacion = fecharegactualizacion;
	}

	public Integer getLimpieza() {
		return this.limpieza;
	}

	public void setLimpieza(Integer limpieza) {
		this.limpieza = limpieza;
	}

	public Integer getNummuestra() {
		return this.nummuestra;
	}

	public void setNummuestra(Integer nummuestra) {
		this.nummuestra = nummuestra;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
	}

	public BarcoCuba getBarcoCuba() {
		return this.barcoCuba;
	}

	public void setBarcoCuba(BarcoCuba barcoCuba) {
		this.barcoCuba = barcoCuba;
	}

	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}

	public CalidadTemperaturaCajonBanda getCalidadTemperaturaCajonBanda() {
		return this.calidadTemperaturaCajonBanda;
	}

	public void setCalidadTemperaturaCajonBanda(CalidadTemperaturaCajonBanda calidadTemperaturaCajonBanda) {
		this.calidadTemperaturaCajonBanda = calidadTemperaturaCajonBanda;
	}

	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}

	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
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