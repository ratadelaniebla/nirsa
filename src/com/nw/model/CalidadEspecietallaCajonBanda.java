package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the calidad_especietalla_cajon_banda database table.
 * 
 */
@Entity
@Table(name="calidad_especietalla_cajon_banda")
public class CalidadEspecietallaCajonBanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcalidadespecietallacajonbanda;

	private Timestamp fechareg;

	private String observaciones;

	//bi-directional many-to-one association to CalidadDetalleEspecietallaCajonBanda
	@OneToMany(mappedBy="calidadEspecietallaCajonBanda")
	private List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas;

	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	private BarcoDescarga barcoDescarga;

	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalladeclarada")
	private EspecieTalla especieTalla;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	public CalidadEspecietallaCajonBanda() {
	}

	public Long getIdcalidadespecietallacajonbanda() {
		return this.idcalidadespecietallacajonbanda;
	}

	public void setIdcalidadespecietallacajonbanda(Long idcalidadespecietallacajonbanda) {
		this.idcalidadespecietallacajonbanda = idcalidadespecietallacajonbanda;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<CalidadDetalleEspecietallaCajonBanda> getCalidadDetalleEspecietallaCajonBandas() {
		return this.calidadDetalleEspecietallaCajonBandas;
	}

	public void setCalidadDetalleEspecietallaCajonBandas(List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas) {
		this.calidadDetalleEspecietallaCajonBandas = calidadDetalleEspecietallaCajonBandas;
	}

	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}

	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}