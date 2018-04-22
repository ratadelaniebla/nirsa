package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_temperatura_cajon_banda database table.
 * 
 */
@Entity
@Table(name="calidad_temperatura_cajon_banda")
public class CalidadTemperaturaCajonBanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadtemperaturacajonbanda;

	private String accion;

	private String desviacion;

	private Timestamp fechareg;

	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="calidadTemperaturaCajonBanda")
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;

	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	private BarcoDescarga barcoDescarga;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadTemperaturaCajonBanda() {
	}

	public Long getIdcalidadtemperaturacajonbanda() {
		return this.idcalidadtemperaturacajonbanda;
	}

	public void setIdcalidadtemperaturacajonbanda(Long idcalidadtemperaturacajonbanda) {
		this.idcalidadtemperaturacajonbanda = idcalidadtemperaturacajonbanda;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getDesviacion() {
		return this.desviacion;
	}

	public void setDesviacion(String desviacion) {
		this.desviacion = desviacion;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}