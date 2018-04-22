package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the barco_descarga database table.
 * 
 */
@Entity
@Table(name="barco_descarga")
public class BarcoDescarga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idbarcodescarga;

	private Integer estado;

	private Timestamp fechacierre;

	private Timestamp fechadescarga;

	private Timestamp fechareg;

	private Long idordenfabricacion;

	private Integer origen;

	private String registro;

	private Integer viaje;

	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@OneToMany(mappedBy="barcoDescarga")
	private List<AtcProduccionDetalleLote> atcProduccionDetalleLotes;

	//bi-directional many-to-one association to Barco
	@ManyToOne
	@JoinColumn(name="idbarco")
	private Barco barco;

	//bi-directional many-to-one association to BarcoDescargaLugar
	@ManyToOne
	@JoinColumn(name="idbarcodescargalugar")
	private BarcoDescargaLugar barcoDescargaLugar;

	//bi-directional many-to-one association to BarcoDescargaMedioTransporte
	@ManyToOne
	@JoinColumn(name="idbarcodescargamediotransporte")
	private BarcoDescargaMedioTransporte barcoDescargaMedioTransporte;

	//bi-directional many-to-one association to Mercante
	@ManyToOne
	@JoinColumn(name="idmercante")
	private Mercante mercante;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to BarcoEstibaCuba
	@OneToMany(mappedBy="barcoDescarga")
	private List<BarcoEstibaCuba> barcoEstibaCubas;

	//bi-directional many-to-one association to CajonDetalleBarcoDescarga
	@OneToMany(mappedBy="barcoDescarga")
	private List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas;

	//bi-directional many-to-one association to CalidadBpmClasificacion
	@OneToMany(mappedBy="barcoDescarga")
	private List<CalidadBpmClasificacion> calidadBpmClasificacions;

	//bi-directional many-to-one association to CalidadBpmDesembarco
	@OneToMany(mappedBy="barcoDescarga")
	private List<CalidadBpmDesembarco> calidadBpmDesembarcos;

	//bi-directional many-to-one association to CalidadEspecietallaCajonBanda
	@OneToMany(mappedBy="barcoDescarga")
	private List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="barcoDescarga")
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;

	//bi-directional many-to-one association to CalidadPcc
	@OneToMany(mappedBy="barcoDescarga")
	private List<CalidadPcc> calidadPccs;

	//bi-directional many-to-one association to CalidadPccRemuestreoCajon
	@OneToMany(mappedBy="barcoDescarga")
	private List<CalidadPccRemuestreoCajon> calidadPccRemuestreoCajons;

	//bi-directional many-to-one association to CalidadSensorialMp
	@OneToMany(mappedBy="barcoDescarga")
	private List<CalidadSensorialMp> calidadSensorialMps;

	//bi-directional many-to-one association to CalidadTemperaturaCajonBanda
	@OneToMany(mappedBy="barcoDescarga")
	private List<CalidadTemperaturaCajonBanda> calidadTemperaturaCajonBandas;

	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="barcoDescarga")
	private List<CamaraCajon> camaraCajons;

	//bi-directional many-to-one association to CamaraDetalleBanda
	@OneToMany(mappedBy="barcoDescarga")
	private List<CamaraDetalleBanda> camaraDetalleBandas;

	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="barcoDescarga")
	private List<ProduccionDetalleLote> produccionDetalleLotes;

	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="barcoDescarga")
	private List<ReportesPuntoControl> reportesPuntoControls;

	public BarcoDescarga() {
	}

	public Long getIdbarcodescarga() {
		return this.idbarcodescarga;
	}

	public void setIdbarcodescarga(Long idbarcodescarga) {
		this.idbarcodescarga = idbarcodescarga;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechacierre() {
		return this.fechacierre;
	}

	public void setFechacierre(Timestamp fechacierre) {
		this.fechacierre = fechacierre;
	}

	public Timestamp getFechadescarga() {
		return this.fechadescarga;
	}

	public void setFechadescarga(Timestamp fechadescarga) {
		this.fechadescarga = fechadescarga;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Long getIdordenfabricacion() {
		return this.idordenfabricacion;
	}

	public void setIdordenfabricacion(Long idordenfabricacion) {
		this.idordenfabricacion = idordenfabricacion;
	}

	public Integer getOrigen() {
		return this.origen;
	}

	public void setOrigen(Integer origen) {
		this.origen = origen;
	}

	public String getRegistro() {
		return this.registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public Integer getViaje() {
		return this.viaje;
	}

	public void setViaje(Integer viaje) {
		this.viaje = viaje;
	}

	public List<AtcProduccionDetalleLote> getAtcProduccionDetalleLotes() {
		return this.atcProduccionDetalleLotes;
	}

	public void setAtcProduccionDetalleLotes(List<AtcProduccionDetalleLote> atcProduccionDetalleLotes) {
		this.atcProduccionDetalleLotes = atcProduccionDetalleLotes;
	}

	public Barco getBarco() {
		return this.barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public BarcoDescargaLugar getBarcoDescargaLugar() {
		return this.barcoDescargaLugar;
	}

	public void setBarcoDescargaLugar(BarcoDescargaLugar barcoDescargaLugar) {
		this.barcoDescargaLugar = barcoDescargaLugar;
	}

	public BarcoDescargaMedioTransporte getBarcoDescargaMedioTransporte() {
		return this.barcoDescargaMedioTransporte;
	}

	public void setBarcoDescargaMedioTransporte(BarcoDescargaMedioTransporte barcoDescargaMedioTransporte) {
		this.barcoDescargaMedioTransporte = barcoDescargaMedioTransporte;
	}

	public Mercante getMercante() {
		return this.mercante;
	}

	public void setMercante(Mercante mercante) {
		this.mercante = mercante;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<BarcoEstibaCuba> getBarcoEstibaCubas() {
		return this.barcoEstibaCubas;
	}

	public void setBarcoEstibaCubas(List<BarcoEstibaCuba> barcoEstibaCubas) {
		this.barcoEstibaCubas = barcoEstibaCubas;
	}

	public List<CajonDetalleBarcoDescarga> getCajonDetalleBarcoDescargas() {
		return this.cajonDetalleBarcoDescargas;
	}

	public void setCajonDetalleBarcoDescargas(List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas) {
		this.cajonDetalleBarcoDescargas = cajonDetalleBarcoDescargas;
	}

	public List<CalidadBpmClasificacion> getCalidadBpmClasificacions() {
		return this.calidadBpmClasificacions;
	}

	public void setCalidadBpmClasificacions(List<CalidadBpmClasificacion> calidadBpmClasificacions) {
		this.calidadBpmClasificacions = calidadBpmClasificacions;
	}

	public List<CalidadBpmDesembarco> getCalidadBpmDesembarcos() {
		return this.calidadBpmDesembarcos;
	}

	public void setCalidadBpmDesembarcos(List<CalidadBpmDesembarco> calidadBpmDesembarcos) {
		this.calidadBpmDesembarcos = calidadBpmDesembarcos;
	}

	public List<CalidadEspecietallaCajonBanda> getCalidadEspecietallaCajonBandas() {
		return this.calidadEspecietallaCajonBandas;
	}

	public void setCalidadEspecietallaCajonBandas(List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas) {
		this.calidadEspecietallaCajonBandas = calidadEspecietallaCajonBandas;
	}

	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public List<CalidadPcc> getCalidadPccs() {
		return this.calidadPccs;
	}

	public void setCalidadPccs(List<CalidadPcc> calidadPccs) {
		this.calidadPccs = calidadPccs;
	}

	public List<CalidadPccRemuestreoCajon> getCalidadPccRemuestreoCajons() {
		return this.calidadPccRemuestreoCajons;
	}

	public void setCalidadPccRemuestreoCajons(List<CalidadPccRemuestreoCajon> calidadPccRemuestreoCajons) {
		this.calidadPccRemuestreoCajons = calidadPccRemuestreoCajons;
	}

	public List<CalidadSensorialMp> getCalidadSensorialMps() {
		return this.calidadSensorialMps;
	}

	public void setCalidadSensorialMps(List<CalidadSensorialMp> calidadSensorialMps) {
		this.calidadSensorialMps = calidadSensorialMps;
	}

	public List<CalidadTemperaturaCajonBanda> getCalidadTemperaturaCajonBandas() {
		return this.calidadTemperaturaCajonBandas;
	}

	public void setCalidadTemperaturaCajonBandas(List<CalidadTemperaturaCajonBanda> calidadTemperaturaCajonBandas) {
		this.calidadTemperaturaCajonBandas = calidadTemperaturaCajonBandas;
	}

	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public List<CamaraDetalleBanda> getCamaraDetalleBandas() {
		return this.camaraDetalleBandas;
	}

	public void setCamaraDetalleBandas(List<CamaraDetalleBanda> camaraDetalleBandas) {
		this.camaraDetalleBandas = camaraDetalleBandas;
	}

	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

	public List<ReportesPuntoControl> getReportesPuntoControls() {
		return this.reportesPuntoControls;
	}

	public void setReportesPuntoControls(List<ReportesPuntoControl> reportesPuntoControls) {
		this.reportesPuntoControls = reportesPuntoControls;
	}

}