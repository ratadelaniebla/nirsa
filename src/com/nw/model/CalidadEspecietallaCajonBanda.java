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
@NamedQuery(name="CalidadEspecietallaCajonBanda.findAll", query="SELECT c FROM CalidadEspecietallaCajonBanda c")
public class CalidadEspecietallaCajonBanda implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcalidadespecietallacajonbanda;
	private Timestamp fechareg;
	private String observaciones;
	private List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas;
	private BarcoDescarga barcoDescarga;
	private EspecieTalla especieTalla;
	private Turno turno;
	private Usuario usuario;

	public CalidadEspecietallaCajonBanda() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadDetalleEspecietallaCajonBanda
	@OneToMany(mappedBy="calidadEspecietallaCajonBanda")
	public List<CalidadDetalleEspecietallaCajonBanda> getCalidadDetalleEspecietallaCajonBandas() {
		return this.calidadDetalleEspecietallaCajonBandas;
	}

	public void setCalidadDetalleEspecietallaCajonBandas(List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas) {
		this.calidadDetalleEspecietallaCajonBandas = calidadDetalleEspecietallaCajonBandas;
	}

	public CalidadDetalleEspecietallaCajonBanda addCalidadDetalleEspecietallaCajonBanda(CalidadDetalleEspecietallaCajonBanda calidadDetalleEspecietallaCajonBanda) {
		getCalidadDetalleEspecietallaCajonBandas().add(calidadDetalleEspecietallaCajonBanda);
		calidadDetalleEspecietallaCajonBanda.setCalidadEspecietallaCajonBanda(this);

		return calidadDetalleEspecietallaCajonBanda;
	}

	public CalidadDetalleEspecietallaCajonBanda removeCalidadDetalleEspecietallaCajonBanda(CalidadDetalleEspecietallaCajonBanda calidadDetalleEspecietallaCajonBanda) {
		getCalidadDetalleEspecietallaCajonBandas().remove(calidadDetalleEspecietallaCajonBanda);
		calidadDetalleEspecietallaCajonBanda.setCalidadEspecietallaCajonBanda(null);

		return calidadDetalleEspecietallaCajonBanda;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}


	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalladeclarada")
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