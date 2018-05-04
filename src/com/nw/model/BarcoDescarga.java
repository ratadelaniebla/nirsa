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
@NamedQuery(name="BarcoDescarga.findAll", query="SELECT b FROM BarcoDescarga b")
public class BarcoDescarga implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idbarcodescarga;
	private Integer estado;
	private Timestamp fechacierre;
	private Timestamp fechadescarga;
	private Timestamp fechareg;
	private Long idordenfabricacion;
	private Integer origen;
	private String registro;
	private Integer viaje;
	private List<AtcProduccionDetalleLote> atcProduccionDetalleLotes;
	private Barco barco;
	private BarcoDescargaLugar barcoDescargaLugar;
	private BarcoDescargaMedioTransporte barcoDescargaMedioTransporte;
	private Mercante mercante;
	private Usuario usuario;
	private List<BarcoEstibaCuba> barcoEstibaCubas;
	private List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas;
	private List<CalidadBpmClasificacion> calidadBpmClasificacions;
	private List<CalidadBpmDesembarco> calidadBpmDesembarcos;
	private List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas;
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;
	private List<CalidadPcc> calidadPccs;
	private List<CalidadPccRemuestreoCajon> calidadPccRemuestreoCajons;
	private List<CalidadSensorialMp> calidadSensorialMps;
	private List<CalidadTemperaturaCajonBanda> calidadTemperaturaCajonBandas;
	private List<CamaraCajon> camaraCajons;
	private List<CamaraDetalleBanda> camaraDetalleBandas;
	private List<ProduccionDetalleLote> produccionDetalleLotes;
	private List<ReportesPuntoControl> reportesPuntoControls;

	public BarcoDescarga() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcProduccionDetalleLote
	@OneToMany(mappedBy="barcoDescarga")
	public List<AtcProduccionDetalleLote> getAtcProduccionDetalleLotes() {
		return this.atcProduccionDetalleLotes;
	}

	public void setAtcProduccionDetalleLotes(List<AtcProduccionDetalleLote> atcProduccionDetalleLotes) {
		this.atcProduccionDetalleLotes = atcProduccionDetalleLotes;
	}

	public AtcProduccionDetalleLote addAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		getAtcProduccionDetalleLotes().add(atcProduccionDetalleLote);
		atcProduccionDetalleLote.setBarcoDescarga(this);

		return atcProduccionDetalleLote;
	}

	public AtcProduccionDetalleLote removeAtcProduccionDetalleLote(AtcProduccionDetalleLote atcProduccionDetalleLote) {
		getAtcProduccionDetalleLotes().remove(atcProduccionDetalleLote);
		atcProduccionDetalleLote.setBarcoDescarga(null);

		return atcProduccionDetalleLote;
	}


	//bi-directional many-to-one association to Barco
	@ManyToOne
	@JoinColumn(name="idbarco")
	public Barco getBarco() {
		return this.barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}


	//bi-directional many-to-one association to BarcoDescargaLugar
	@ManyToOne
	@JoinColumn(name="idbarcodescargalugar")
	public BarcoDescargaLugar getBarcoDescargaLugar() {
		return this.barcoDescargaLugar;
	}

	public void setBarcoDescargaLugar(BarcoDescargaLugar barcoDescargaLugar) {
		this.barcoDescargaLugar = barcoDescargaLugar;
	}


	//bi-directional many-to-one association to BarcoDescargaMedioTransporte
	@ManyToOne
	@JoinColumn(name="idbarcodescargamediotransporte")
	public BarcoDescargaMedioTransporte getBarcoDescargaMedioTransporte() {
		return this.barcoDescargaMedioTransporte;
	}

	public void setBarcoDescargaMedioTransporte(BarcoDescargaMedioTransporte barcoDescargaMedioTransporte) {
		this.barcoDescargaMedioTransporte = barcoDescargaMedioTransporte;
	}


	//bi-directional many-to-one association to Mercante
	@ManyToOne
	@JoinColumn(name="idmercante")
	public Mercante getMercante() {
		return this.mercante;
	}

	public void setMercante(Mercante mercante) {
		this.mercante = mercante;
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


	//bi-directional many-to-one association to BarcoEstibaCuba
	@OneToMany(mappedBy="barcoDescarga")
	public List<BarcoEstibaCuba> getBarcoEstibaCubas() {
		return this.barcoEstibaCubas;
	}

	public void setBarcoEstibaCubas(List<BarcoEstibaCuba> barcoEstibaCubas) {
		this.barcoEstibaCubas = barcoEstibaCubas;
	}

	public BarcoEstibaCuba addBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		getBarcoEstibaCubas().add(barcoEstibaCuba);
		barcoEstibaCuba.setBarcoDescarga(this);

		return barcoEstibaCuba;
	}

	public BarcoEstibaCuba removeBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		getBarcoEstibaCubas().remove(barcoEstibaCuba);
		barcoEstibaCuba.setBarcoDescarga(null);

		return barcoEstibaCuba;
	}


	//bi-directional many-to-one association to CajonDetalleBarcoDescarga
	@OneToMany(mappedBy="barcoDescarga")
	public List<CajonDetalleBarcoDescarga> getCajonDetalleBarcoDescargas() {
		return this.cajonDetalleBarcoDescargas;
	}

	public void setCajonDetalleBarcoDescargas(List<CajonDetalleBarcoDescarga> cajonDetalleBarcoDescargas) {
		this.cajonDetalleBarcoDescargas = cajonDetalleBarcoDescargas;
	}

	public CajonDetalleBarcoDescarga addCajonDetalleBarcoDescarga(CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga) {
		getCajonDetalleBarcoDescargas().add(cajonDetalleBarcoDescarga);
		cajonDetalleBarcoDescarga.setBarcoDescarga(this);

		return cajonDetalleBarcoDescarga;
	}

	public CajonDetalleBarcoDescarga removeCajonDetalleBarcoDescarga(CajonDetalleBarcoDescarga cajonDetalleBarcoDescarga) {
		getCajonDetalleBarcoDescargas().remove(cajonDetalleBarcoDescarga);
		cajonDetalleBarcoDescarga.setBarcoDescarga(null);

		return cajonDetalleBarcoDescarga;
	}


	//bi-directional many-to-one association to CalidadBpmClasificacion
	@OneToMany(mappedBy="barcoDescarga")
	public List<CalidadBpmClasificacion> getCalidadBpmClasificacions() {
		return this.calidadBpmClasificacions;
	}

	public void setCalidadBpmClasificacions(List<CalidadBpmClasificacion> calidadBpmClasificacions) {
		this.calidadBpmClasificacions = calidadBpmClasificacions;
	}

	public CalidadBpmClasificacion addCalidadBpmClasificacion(CalidadBpmClasificacion calidadBpmClasificacion) {
		getCalidadBpmClasificacions().add(calidadBpmClasificacion);
		calidadBpmClasificacion.setBarcoDescarga(this);

		return calidadBpmClasificacion;
	}

	public CalidadBpmClasificacion removeCalidadBpmClasificacion(CalidadBpmClasificacion calidadBpmClasificacion) {
		getCalidadBpmClasificacions().remove(calidadBpmClasificacion);
		calidadBpmClasificacion.setBarcoDescarga(null);

		return calidadBpmClasificacion;
	}


	//bi-directional many-to-one association to CalidadBpmDesembarco
	@OneToMany(mappedBy="barcoDescarga")
	public List<CalidadBpmDesembarco> getCalidadBpmDesembarcos() {
		return this.calidadBpmDesembarcos;
	}

	public void setCalidadBpmDesembarcos(List<CalidadBpmDesembarco> calidadBpmDesembarcos) {
		this.calidadBpmDesembarcos = calidadBpmDesembarcos;
	}

	public CalidadBpmDesembarco addCalidadBpmDesembarco(CalidadBpmDesembarco calidadBpmDesembarco) {
		getCalidadBpmDesembarcos().add(calidadBpmDesembarco);
		calidadBpmDesembarco.setBarcoDescarga(this);

		return calidadBpmDesembarco;
	}

	public CalidadBpmDesembarco removeCalidadBpmDesembarco(CalidadBpmDesembarco calidadBpmDesembarco) {
		getCalidadBpmDesembarcos().remove(calidadBpmDesembarco);
		calidadBpmDesembarco.setBarcoDescarga(null);

		return calidadBpmDesembarco;
	}


	//bi-directional many-to-one association to CalidadEspecietallaCajonBanda
	@OneToMany(mappedBy="barcoDescarga")
	public List<CalidadEspecietallaCajonBanda> getCalidadEspecietallaCajonBandas() {
		return this.calidadEspecietallaCajonBandas;
	}

	public void setCalidadEspecietallaCajonBandas(List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas) {
		this.calidadEspecietallaCajonBandas = calidadEspecietallaCajonBandas;
	}

	public CalidadEspecietallaCajonBanda addCalidadEspecietallaCajonBanda(CalidadEspecietallaCajonBanda calidadEspecietallaCajonBanda) {
		getCalidadEspecietallaCajonBandas().add(calidadEspecietallaCajonBanda);
		calidadEspecietallaCajonBanda.setBarcoDescarga(this);

		return calidadEspecietallaCajonBanda;
	}

	public CalidadEspecietallaCajonBanda removeCalidadEspecietallaCajonBanda(CalidadEspecietallaCajonBanda calidadEspecietallaCajonBanda) {
		getCalidadEspecietallaCajonBandas().remove(calidadEspecietallaCajonBanda);
		calidadEspecietallaCajonBanda.setBarcoDescarga(null);

		return calidadEspecietallaCajonBanda;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="barcoDescarga")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public CalidadMuestraAreaCabecera addCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().add(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setBarcoDescarga(this);

		return calidadMuestraAreaCabecera;
	}

	public CalidadMuestraAreaCabecera removeCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().remove(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setBarcoDescarga(null);

		return calidadMuestraAreaCabecera;
	}


	//bi-directional many-to-one association to CalidadPcc
	@OneToMany(mappedBy="barcoDescarga")
	public List<CalidadPcc> getCalidadPccs() {
		return this.calidadPccs;
	}

	public void setCalidadPccs(List<CalidadPcc> calidadPccs) {
		this.calidadPccs = calidadPccs;
	}

	public CalidadPcc addCalidadPcc(CalidadPcc calidadPcc) {
		getCalidadPccs().add(calidadPcc);
		calidadPcc.setBarcoDescarga(this);

		return calidadPcc;
	}

	public CalidadPcc removeCalidadPcc(CalidadPcc calidadPcc) {
		getCalidadPccs().remove(calidadPcc);
		calidadPcc.setBarcoDescarga(null);

		return calidadPcc;
	}


	//bi-directional many-to-one association to CalidadPccRemuestreoCajon
	@OneToMany(mappedBy="barcoDescarga")
	public List<CalidadPccRemuestreoCajon> getCalidadPccRemuestreoCajons() {
		return this.calidadPccRemuestreoCajons;
	}

	public void setCalidadPccRemuestreoCajons(List<CalidadPccRemuestreoCajon> calidadPccRemuestreoCajons) {
		this.calidadPccRemuestreoCajons = calidadPccRemuestreoCajons;
	}

	public CalidadPccRemuestreoCajon addCalidadPccRemuestreoCajon(CalidadPccRemuestreoCajon calidadPccRemuestreoCajon) {
		getCalidadPccRemuestreoCajons().add(calidadPccRemuestreoCajon);
		calidadPccRemuestreoCajon.setBarcoDescarga(this);

		return calidadPccRemuestreoCajon;
	}

	public CalidadPccRemuestreoCajon removeCalidadPccRemuestreoCajon(CalidadPccRemuestreoCajon calidadPccRemuestreoCajon) {
		getCalidadPccRemuestreoCajons().remove(calidadPccRemuestreoCajon);
		calidadPccRemuestreoCajon.setBarcoDescarga(null);

		return calidadPccRemuestreoCajon;
	}


	//bi-directional many-to-one association to CalidadSensorialMp
	@OneToMany(mappedBy="barcoDescarga")
	public List<CalidadSensorialMp> getCalidadSensorialMps() {
		return this.calidadSensorialMps;
	}

	public void setCalidadSensorialMps(List<CalidadSensorialMp> calidadSensorialMps) {
		this.calidadSensorialMps = calidadSensorialMps;
	}

	public CalidadSensorialMp addCalidadSensorialMp(CalidadSensorialMp calidadSensorialMp) {
		getCalidadSensorialMps().add(calidadSensorialMp);
		calidadSensorialMp.setBarcoDescarga(this);

		return calidadSensorialMp;
	}

	public CalidadSensorialMp removeCalidadSensorialMp(CalidadSensorialMp calidadSensorialMp) {
		getCalidadSensorialMps().remove(calidadSensorialMp);
		calidadSensorialMp.setBarcoDescarga(null);

		return calidadSensorialMp;
	}


	//bi-directional many-to-one association to CalidadTemperaturaCajonBanda
	@OneToMany(mappedBy="barcoDescarga")
	public List<CalidadTemperaturaCajonBanda> getCalidadTemperaturaCajonBandas() {
		return this.calidadTemperaturaCajonBandas;
	}

	public void setCalidadTemperaturaCajonBandas(List<CalidadTemperaturaCajonBanda> calidadTemperaturaCajonBandas) {
		this.calidadTemperaturaCajonBandas = calidadTemperaturaCajonBandas;
	}

	public CalidadTemperaturaCajonBanda addCalidadTemperaturaCajonBanda(CalidadTemperaturaCajonBanda calidadTemperaturaCajonBanda) {
		getCalidadTemperaturaCajonBandas().add(calidadTemperaturaCajonBanda);
		calidadTemperaturaCajonBanda.setBarcoDescarga(this);

		return calidadTemperaturaCajonBanda;
	}

	public CalidadTemperaturaCajonBanda removeCalidadTemperaturaCajonBanda(CalidadTemperaturaCajonBanda calidadTemperaturaCajonBanda) {
		getCalidadTemperaturaCajonBandas().remove(calidadTemperaturaCajonBanda);
		calidadTemperaturaCajonBanda.setBarcoDescarga(null);

		return calidadTemperaturaCajonBanda;
	}


	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="barcoDescarga")
	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public CamaraCajon addCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().add(camaraCajon);
		camaraCajon.setBarcoDescarga(this);

		return camaraCajon;
	}

	public CamaraCajon removeCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().remove(camaraCajon);
		camaraCajon.setBarcoDescarga(null);

		return camaraCajon;
	}


	//bi-directional many-to-one association to CamaraDetalleBanda
	@OneToMany(mappedBy="barcoDescarga")
	public List<CamaraDetalleBanda> getCamaraDetalleBandas() {
		return this.camaraDetalleBandas;
	}

	public void setCamaraDetalleBandas(List<CamaraDetalleBanda> camaraDetalleBandas) {
		this.camaraDetalleBandas = camaraDetalleBandas;
	}

	public CamaraDetalleBanda addCamaraDetalleBanda(CamaraDetalleBanda camaraDetalleBanda) {
		getCamaraDetalleBandas().add(camaraDetalleBanda);
		camaraDetalleBanda.setBarcoDescarga(this);

		return camaraDetalleBanda;
	}

	public CamaraDetalleBanda removeCamaraDetalleBanda(CamaraDetalleBanda camaraDetalleBanda) {
		getCamaraDetalleBandas().remove(camaraDetalleBanda);
		camaraDetalleBanda.setBarcoDescarga(null);

		return camaraDetalleBanda;
	}


	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="barcoDescarga")
	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

	public ProduccionDetalleLote addProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().add(produccionDetalleLote);
		produccionDetalleLote.setBarcoDescarga(this);

		return produccionDetalleLote;
	}

	public ProduccionDetalleLote removeProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().remove(produccionDetalleLote);
		produccionDetalleLote.setBarcoDescarga(null);

		return produccionDetalleLote;
	}


	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="barcoDescarga")
	public List<ReportesPuntoControl> getReportesPuntoControls() {
		return this.reportesPuntoControls;
	}

	public void setReportesPuntoControls(List<ReportesPuntoControl> reportesPuntoControls) {
		this.reportesPuntoControls = reportesPuntoControls;
	}

	public ReportesPuntoControl addReportesPuntoControl(ReportesPuntoControl reportesPuntoControl) {
		getReportesPuntoControls().add(reportesPuntoControl);
		reportesPuntoControl.setBarcoDescarga(this);

		return reportesPuntoControl;
	}

	public ReportesPuntoControl removeReportesPuntoControl(ReportesPuntoControl reportesPuntoControl) {
		getReportesPuntoControls().remove(reportesPuntoControl);
		reportesPuntoControl.setBarcoDescarga(null);

		return reportesPuntoControl;
	}

}