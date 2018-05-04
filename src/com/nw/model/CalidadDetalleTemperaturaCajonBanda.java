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
@NamedQuery(name="CalidadDetalleTemperaturaCajonBanda.findAll", query="SELECT c FROM CalidadDetalleTemperaturaCajonBanda c")
public class CalidadDetalleTemperaturaCajonBanda implements Serializable {
	private static final long serialVersionUID = 1L;
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
	private BarcoCuba barcoCuba;
	private Cajon cajon;
	private CalidadTemperaturaCajonBanda calidadTemperaturaCajonBanda;
	private CamaraCajon camaraCajon;
	private EspecieTalla especieTalla;
	private Turno turno;
	private Usuario usuario;

	public CalidadDetalleTemperaturaCajonBanda() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to BarcoCuba
	@ManyToOne
	@JoinColumn(name="idbarcocuba")
	public BarcoCuba getBarcoCuba() {
		return this.barcoCuba;
	}

	public void setBarcoCuba(BarcoCuba barcoCuba) {
		this.barcoCuba = barcoCuba;
	}


	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}


	//bi-directional many-to-one association to CalidadTemperaturaCajonBanda
	@ManyToOne
	@JoinColumn(name="idcalidadtemperaturacajonbanda")
	public CalidadTemperaturaCajonBanda getCalidadTemperaturaCajonBanda() {
		return this.calidadTemperaturaCajonBanda;
	}

	public void setCalidadTemperaturaCajonBanda(CalidadTemperaturaCajonBanda calidadTemperaturaCajonBanda) {
		this.calidadTemperaturaCajonBanda = calidadTemperaturaCajonBanda;
	}


	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
	}


	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}