package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the calidad_detalle_especietalla_cajon_banda database table.
 * 
 */
@Entity
@Table(name="calidad_detalle_especietalla_cajon_banda")
public class CalidadDetalleEspecietallaCajonBanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidaddetalleespecietallacajonbanda;

	private Boolean barcoexterno;

	private Timestamp fechareg;

	private Timestamp fecharegactualizacion;

	private String idcajonexterno;

	private double longitud;

	private Integer nummuestra;

	private double peso;

	private String usuarioactualizacion;

	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	private Cajon cajon;

	//bi-directional many-to-one association to CalidadEspecietallaCajonBanda
	@ManyToOne
	@JoinColumn(name="idcalidadespecietallacajonbanda")
	private CalidadEspecietallaCajonBanda calidadEspecietallaCajonBanda;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public CalidadDetalleEspecietallaCajonBanda() {
	}

	public Long getIdcalidaddetalleespecietallacajonbanda() {
		return this.idcalidaddetalleespecietallacajonbanda;
	}

	public void setIdcalidaddetalleespecietallacajonbanda(Long idcalidaddetalleespecietallacajonbanda) {
		this.idcalidaddetalleespecietallacajonbanda = idcalidaddetalleespecietallacajonbanda;
	}

	public Boolean getBarcoexterno() {
		return this.barcoexterno;
	}

	public void setBarcoexterno(Boolean barcoexterno) {
		this.barcoexterno = barcoexterno;
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

	public String getIdcajonexterno() {
		return this.idcajonexterno;
	}

	public void setIdcajonexterno(String idcajonexterno) {
		this.idcajonexterno = idcajonexterno;
	}

	public double getLongitud() {
		return this.longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public Integer getNummuestra() {
		return this.nummuestra;
	}

	public void setNummuestra(Integer nummuestra) {
		this.nummuestra = nummuestra;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
	}

	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}

	public CalidadEspecietallaCajonBanda getCalidadEspecietallaCajonBanda() {
		return this.calidadEspecietallaCajonBanda;
	}

	public void setCalidadEspecietallaCajonBanda(CalidadEspecietallaCajonBanda calidadEspecietallaCajonBanda) {
		this.calidadEspecietallaCajonBanda = calidadEspecietallaCajonBanda;
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