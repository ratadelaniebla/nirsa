package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the camara_cajon database table.
 * 
 */
@Entity
@Table(name="camara_cajon")
public class CamaraCajon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcamaracajon;

	private String codigoalmacen;

	private String columnapasillo;

	private Integer estado;

	private Timestamp fechaactualizacion;

	private Timestamp fechaactualizacionmovimiento;

	private Timestamp fechareg;

	private Timestamp fechaultimomovimiento;

	private Long idbarcoestibacuba2;

	private Integer idmaterialanterior;

	private String ladopasillo;

	private String lotecajonsap;

	private String lotecajonsapantesdenacionalizar;

	private String lotecamara;

	private String lotehaccp;

	private String observacion;

	private double pesobruto;

	private double pesolibreutilizacion;

	private double pesoneto;

	private Integer procesado;

	private String proposito;

	private double tara;

	private String ticket;

	private String tipotratamiento;

	private String usuarioactualizacion;

	private String usuarioactualizacionmovimiento;

	private String usuarioultimomovimiento;

	private String zonafao;

	//bi-directional many-to-one association to AtcProduccionDetalleLoteCajon
	@OneToMany(mappedBy="camaraCajon")
	private List<AtcProduccionDetalleLoteCajon> atcProduccionDetalleLoteCajons;

	//bi-directional many-to-one association to BarcoEstibaCubaDetalleMezcla
	@OneToMany(mappedBy="camaraCajon")
	private List<BarcoEstibaCubaDetalleMezcla> barcoEstibaCubaDetalleMezclas;

	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="camaraCajon")
	private List<CalidadDetallePcc> calidadDetallePccs;

	//bi-directional many-to-one association to CalidadDetallePccRemuestreoCajon
	@OneToMany(mappedBy="camaraCajon")
	private List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons;

	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="camaraCajon")
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="camaraCajon")
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;

	//bi-directional many-to-one association to BarcoDescarga
	@ManyToOne
	@JoinColumn(name="idbarcodescarga")
	private BarcoDescarga barcoDescarga;

	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	private BarcoEstibaCuba barcoEstibaCuba;

	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	private Cajon cajon;

	//bi-directional many-to-one association to Camara
	@ManyToOne
	@JoinColumn(name="idcamara")
	private Camara camara;

	//bi-directional many-to-one association to CamaraArea
	@ManyToOne
	@JoinColumn(name="idcamaraarea")
	private CamaraArea camaraArea;

	//bi-directional many-to-one association to CamaraCajonRegistroSap
	@ManyToOne
	@JoinColumn(name="idcamaracajonregistrosap")
	private CamaraCajonRegistroSap camaraCajonRegistroSap;

	//bi-directional many-to-one association to CamaraFilaColumna
	@ManyToOne
	@JoinColumn(name="idfilacolumna")
	private CamaraFilaColumna camaraFilaColumna;

	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idmaterial")
	private EspecieTalla especieTalla;

	//bi-directional many-to-one association to TipoCaptura
	@ManyToOne
	@JoinColumn(name="idtipocaptura")
	private TipoCaptura tipoCaptura;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to CamaraCajonUbicacion
	@OneToMany(mappedBy="camaraCajon")
	private List<CamaraCajonUbicacion> camaraCajonUbicacions;

	//bi-directional many-to-one association to PedidoProduccionArchivoCargaDetalle
	@OneToMany(mappedBy="camaraCajon")
	private List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles;

	//bi-directional many-to-one association to PedidoProduccionDetalle
	@OneToMany(mappedBy="camaraCajon")
	private List<PedidoProduccionDetalle> pedidoProduccionDetalles;

	//bi-directional many-to-one association to PlanificacionCargaDetalle
	@OneToMany(mappedBy="camaraCajon")
	private List<PlanificacionCargaDetalle> planificacionCargaDetalles;

	//bi-directional many-to-one association to ProduccionDetalleLoteCajon
	@OneToMany(mappedBy="camaraCajon")
	private List<ProduccionDetalleLoteCajon> produccionDetalleLoteCajons;

	public CamaraCajon() {
	}

	public Long getIdcamaracajon() {
		return this.idcamaracajon;
	}

	public void setIdcamaracajon(Long idcamaracajon) {
		this.idcamaracajon = idcamaracajon;
	}

	public String getCodigoalmacen() {
		return this.codigoalmacen;
	}

	public void setCodigoalmacen(String codigoalmacen) {
		this.codigoalmacen = codigoalmacen;
	}

	public String getColumnapasillo() {
		return this.columnapasillo;
	}

	public void setColumnapasillo(String columnapasillo) {
		this.columnapasillo = columnapasillo;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public Timestamp getFechaactualizacionmovimiento() {
		return this.fechaactualizacionmovimiento;
	}

	public void setFechaactualizacionmovimiento(Timestamp fechaactualizacionmovimiento) {
		this.fechaactualizacionmovimiento = fechaactualizacionmovimiento;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Timestamp getFechaultimomovimiento() {
		return this.fechaultimomovimiento;
	}

	public void setFechaultimomovimiento(Timestamp fechaultimomovimiento) {
		this.fechaultimomovimiento = fechaultimomovimiento;
	}

	public Long getIdbarcoestibacuba2() {
		return this.idbarcoestibacuba2;
	}

	public void setIdbarcoestibacuba2(Long idbarcoestibacuba2) {
		this.idbarcoestibacuba2 = idbarcoestibacuba2;
	}

	public Integer getIdmaterialanterior() {
		return this.idmaterialanterior;
	}

	public void setIdmaterialanterior(Integer idmaterialanterior) {
		this.idmaterialanterior = idmaterialanterior;
	}

	public String getLadopasillo() {
		return this.ladopasillo;
	}

	public void setLadopasillo(String ladopasillo) {
		this.ladopasillo = ladopasillo;
	}

	public String getLotecajonsap() {
		return this.lotecajonsap;
	}

	public void setLotecajonsap(String lotecajonsap) {
		this.lotecajonsap = lotecajonsap;
	}

	public String getLotecajonsapantesdenacionalizar() {
		return this.lotecajonsapantesdenacionalizar;
	}

	public void setLotecajonsapantesdenacionalizar(String lotecajonsapantesdenacionalizar) {
		this.lotecajonsapantesdenacionalizar = lotecajonsapantesdenacionalizar;
	}

	public String getLotecamara() {
		return this.lotecamara;
	}

	public void setLotecamara(String lotecamara) {
		this.lotecamara = lotecamara;
	}

	public String getLotehaccp() {
		return this.lotehaccp;
	}

	public void setLotehaccp(String lotehaccp) {
		this.lotehaccp = lotehaccp;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public double getPesobruto() {
		return this.pesobruto;
	}

	public void setPesobruto(double pesobruto) {
		this.pesobruto = pesobruto;
	}

	public double getPesolibreutilizacion() {
		return this.pesolibreutilizacion;
	}

	public void setPesolibreutilizacion(double pesolibreutilizacion) {
		this.pesolibreutilizacion = pesolibreutilizacion;
	}

	public double getPesoneto() {
		return this.pesoneto;
	}

	public void setPesoneto(double pesoneto) {
		this.pesoneto = pesoneto;
	}

	public Integer getProcesado() {
		return this.procesado;
	}

	public void setProcesado(Integer procesado) {
		this.procesado = procesado;
	}

	public String getProposito() {
		return this.proposito;
	}

	public void setProposito(String proposito) {
		this.proposito = proposito;
	}

	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getTipotratamiento() {
		return this.tipotratamiento;
	}

	public void setTipotratamiento(String tipotratamiento) {
		this.tipotratamiento = tipotratamiento;
	}

	public String getUsuarioactualizacion() {
		return this.usuarioactualizacion;
	}

	public void setUsuarioactualizacion(String usuarioactualizacion) {
		this.usuarioactualizacion = usuarioactualizacion;
	}

	public String getUsuarioactualizacionmovimiento() {
		return this.usuarioactualizacionmovimiento;
	}

	public void setUsuarioactualizacionmovimiento(String usuarioactualizacionmovimiento) {
		this.usuarioactualizacionmovimiento = usuarioactualizacionmovimiento;
	}

	public String getUsuarioultimomovimiento() {
		return this.usuarioultimomovimiento;
	}

	public void setUsuarioultimomovimiento(String usuarioultimomovimiento) {
		this.usuarioultimomovimiento = usuarioultimomovimiento;
	}

	public String getZonafao() {
		return this.zonafao;
	}

	public void setZonafao(String zonafao) {
		this.zonafao = zonafao;
	}

	public List<AtcProduccionDetalleLoteCajon> getAtcProduccionDetalleLoteCajons() {
		return this.atcProduccionDetalleLoteCajons;
	}

	public void setAtcProduccionDetalleLoteCajons(List<AtcProduccionDetalleLoteCajon> atcProduccionDetalleLoteCajons) {
		this.atcProduccionDetalleLoteCajons = atcProduccionDetalleLoteCajons;
	}

	public List<BarcoEstibaCubaDetalleMezcla> getBarcoEstibaCubaDetalleMezclas() {
		return this.barcoEstibaCubaDetalleMezclas;
	}

	public void setBarcoEstibaCubaDetalleMezclas(List<BarcoEstibaCubaDetalleMezcla> barcoEstibaCubaDetalleMezclas) {
		this.barcoEstibaCubaDetalleMezclas = barcoEstibaCubaDetalleMezclas;
	}

	public List<CalidadDetallePcc> getCalidadDetallePccs() {
		return this.calidadDetallePccs;
	}

	public void setCalidadDetallePccs(List<CalidadDetallePcc> calidadDetallePccs) {
		this.calidadDetallePccs = calidadDetallePccs;
	}

	public List<CalidadDetallePccRemuestreoCajon> getCalidadDetallePccRemuestreoCajons() {
		return this.calidadDetallePccRemuestreoCajons;
	}

	public void setCalidadDetallePccRemuestreoCajons(List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons) {
		this.calidadDetallePccRemuestreoCajons = calidadDetallePccRemuestreoCajons;
	}

	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public BarcoDescarga getBarcoDescarga() {
		return this.barcoDescarga;
	}

	public void setBarcoDescarga(BarcoDescarga barcoDescarga) {
		this.barcoDescarga = barcoDescarga;
	}

	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
	}

	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}

	public Camara getCamara() {
		return this.camara;
	}

	public void setCamara(Camara camara) {
		this.camara = camara;
	}

	public CamaraArea getCamaraArea() {
		return this.camaraArea;
	}

	public void setCamaraArea(CamaraArea camaraArea) {
		this.camaraArea = camaraArea;
	}

	public CamaraCajonRegistroSap getCamaraCajonRegistroSap() {
		return this.camaraCajonRegistroSap;
	}

	public void setCamaraCajonRegistroSap(CamaraCajonRegistroSap camaraCajonRegistroSap) {
		this.camaraCajonRegistroSap = camaraCajonRegistroSap;
	}

	public CamaraFilaColumna getCamaraFilaColumna() {
		return this.camaraFilaColumna;
	}

	public void setCamaraFilaColumna(CamaraFilaColumna camaraFilaColumna) {
		this.camaraFilaColumna = camaraFilaColumna;
	}

	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}

	public TipoCaptura getTipoCaptura() {
		return this.tipoCaptura;
	}

	public void setTipoCaptura(TipoCaptura tipoCaptura) {
		this.tipoCaptura = tipoCaptura;
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

	public List<CamaraCajonUbicacion> getCamaraCajonUbicacions() {
		return this.camaraCajonUbicacions;
	}

	public void setCamaraCajonUbicacions(List<CamaraCajonUbicacion> camaraCajonUbicacions) {
		this.camaraCajonUbicacions = camaraCajonUbicacions;
	}

	public List<PedidoProduccionArchivoCargaDetalle> getPedidoProduccionArchivoCargaDetalles() {
		return this.pedidoProduccionArchivoCargaDetalles;
	}

	public void setPedidoProduccionArchivoCargaDetalles(List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles) {
		this.pedidoProduccionArchivoCargaDetalles = pedidoProduccionArchivoCargaDetalles;
	}

	public List<PedidoProduccionDetalle> getPedidoProduccionDetalles() {
		return this.pedidoProduccionDetalles;
	}

	public void setPedidoProduccionDetalles(List<PedidoProduccionDetalle> pedidoProduccionDetalles) {
		this.pedidoProduccionDetalles = pedidoProduccionDetalles;
	}

	public List<PlanificacionCargaDetalle> getPlanificacionCargaDetalles() {
		return this.planificacionCargaDetalles;
	}

	public void setPlanificacionCargaDetalles(List<PlanificacionCargaDetalle> planificacionCargaDetalles) {
		this.planificacionCargaDetalles = planificacionCargaDetalles;
	}

	public List<ProduccionDetalleLoteCajon> getProduccionDetalleLoteCajons() {
		return this.produccionDetalleLoteCajons;
	}

	public void setProduccionDetalleLoteCajons(List<ProduccionDetalleLoteCajon> produccionDetalleLoteCajons) {
		this.produccionDetalleLoteCajons = produccionDetalleLoteCajons;
	}

}