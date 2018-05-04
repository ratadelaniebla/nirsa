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
@NamedQuery(name="CamaraCajon.findAll", query="SELECT c FROM CamaraCajon c")
public class CamaraCajon implements Serializable {
	private static final long serialVersionUID = 1L;
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
	private List<AtcProduccionDetalleLoteCajon> atcProduccionDetalleLoteCajons;
	private List<BarcoEstibaCubaDetalleMezcla> barcoEstibaCubaDetalleMezclas;
	private List<CalidadDetallePcc> calidadDetallePccs;
	private List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons;
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;
	private BarcoDescarga barcoDescarga;
	private BarcoEstibaCuba barcoEstibaCuba;
	private Cajon cajon;
	private Camara camara;
	private CamaraArea camaraArea;
	private CamaraCajonRegistroSap camaraCajonRegistroSap;
	private CamaraFilaColumna camaraFilaColumna;
	private EspecieTalla especieTalla;
	private TipoCaptura tipoCaptura;
	private Turno turno;
	private Usuario usuario;
	private List<CamaraCajonUbicacion> camaraCajonUbicacions;
	private List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles;
	private List<PedidoProduccionDetalle> pedidoProduccionDetalles;
	private List<PlanificacionCargaDetalle> planificacionCargaDetalles;
	private List<ProduccionDetalleLoteCajon> produccionDetalleLoteCajons;

	public CamaraCajon() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcProduccionDetalleLoteCajon
	@OneToMany(mappedBy="camaraCajon")
	public List<AtcProduccionDetalleLoteCajon> getAtcProduccionDetalleLoteCajons() {
		return this.atcProduccionDetalleLoteCajons;
	}

	public void setAtcProduccionDetalleLoteCajons(List<AtcProduccionDetalleLoteCajon> atcProduccionDetalleLoteCajons) {
		this.atcProduccionDetalleLoteCajons = atcProduccionDetalleLoteCajons;
	}

	public AtcProduccionDetalleLoteCajon addAtcProduccionDetalleLoteCajon(AtcProduccionDetalleLoteCajon atcProduccionDetalleLoteCajon) {
		getAtcProduccionDetalleLoteCajons().add(atcProduccionDetalleLoteCajon);
		atcProduccionDetalleLoteCajon.setCamaraCajon(this);

		return atcProduccionDetalleLoteCajon;
	}

	public AtcProduccionDetalleLoteCajon removeAtcProduccionDetalleLoteCajon(AtcProduccionDetalleLoteCajon atcProduccionDetalleLoteCajon) {
		getAtcProduccionDetalleLoteCajons().remove(atcProduccionDetalleLoteCajon);
		atcProduccionDetalleLoteCajon.setCamaraCajon(null);

		return atcProduccionDetalleLoteCajon;
	}


	//bi-directional many-to-one association to BarcoEstibaCubaDetalleMezcla
	@OneToMany(mappedBy="camaraCajon")
	public List<BarcoEstibaCubaDetalleMezcla> getBarcoEstibaCubaDetalleMezclas() {
		return this.barcoEstibaCubaDetalleMezclas;
	}

	public void setBarcoEstibaCubaDetalleMezclas(List<BarcoEstibaCubaDetalleMezcla> barcoEstibaCubaDetalleMezclas) {
		this.barcoEstibaCubaDetalleMezclas = barcoEstibaCubaDetalleMezclas;
	}

	public BarcoEstibaCubaDetalleMezcla addBarcoEstibaCubaDetalleMezcla(BarcoEstibaCubaDetalleMezcla barcoEstibaCubaDetalleMezcla) {
		getBarcoEstibaCubaDetalleMezclas().add(barcoEstibaCubaDetalleMezcla);
		barcoEstibaCubaDetalleMezcla.setCamaraCajon(this);

		return barcoEstibaCubaDetalleMezcla;
	}

	public BarcoEstibaCubaDetalleMezcla removeBarcoEstibaCubaDetalleMezcla(BarcoEstibaCubaDetalleMezcla barcoEstibaCubaDetalleMezcla) {
		getBarcoEstibaCubaDetalleMezclas().remove(barcoEstibaCubaDetalleMezcla);
		barcoEstibaCubaDetalleMezcla.setCamaraCajon(null);

		return barcoEstibaCubaDetalleMezcla;
	}


	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="camaraCajon")
	public List<CalidadDetallePcc> getCalidadDetallePccs() {
		return this.calidadDetallePccs;
	}

	public void setCalidadDetallePccs(List<CalidadDetallePcc> calidadDetallePccs) {
		this.calidadDetallePccs = calidadDetallePccs;
	}

	public CalidadDetallePcc addCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().add(calidadDetallePcc);
		calidadDetallePcc.setCamaraCajon(this);

		return calidadDetallePcc;
	}

	public CalidadDetallePcc removeCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().remove(calidadDetallePcc);
		calidadDetallePcc.setCamaraCajon(null);

		return calidadDetallePcc;
	}


	//bi-directional many-to-one association to CalidadDetallePccRemuestreoCajon
	@OneToMany(mappedBy="camaraCajon")
	public List<CalidadDetallePccRemuestreoCajon> getCalidadDetallePccRemuestreoCajons() {
		return this.calidadDetallePccRemuestreoCajons;
	}

	public void setCalidadDetallePccRemuestreoCajons(List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons) {
		this.calidadDetallePccRemuestreoCajons = calidadDetallePccRemuestreoCajons;
	}

	public CalidadDetallePccRemuestreoCajon addCalidadDetallePccRemuestreoCajon(CalidadDetallePccRemuestreoCajon calidadDetallePccRemuestreoCajon) {
		getCalidadDetallePccRemuestreoCajons().add(calidadDetallePccRemuestreoCajon);
		calidadDetallePccRemuestreoCajon.setCamaraCajon(this);

		return calidadDetallePccRemuestreoCajon;
	}

	public CalidadDetallePccRemuestreoCajon removeCalidadDetallePccRemuestreoCajon(CalidadDetallePccRemuestreoCajon calidadDetallePccRemuestreoCajon) {
		getCalidadDetallePccRemuestreoCajons().remove(calidadDetallePccRemuestreoCajon);
		calidadDetallePccRemuestreoCajon.setCamaraCajon(null);

		return calidadDetallePccRemuestreoCajon;
	}


	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="camaraCajon")
	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public CalidadDetalleTemperaturaCajonBanda addCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().add(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setCamaraCajon(this);

		return calidadDetalleTemperaturaCajonBanda;
	}

	public CalidadDetalleTemperaturaCajonBanda removeCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().remove(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setCamaraCajon(null);

		return calidadDetalleTemperaturaCajonBanda;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="camaraCajon")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public CalidadMuestraAreaCabecera addCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().add(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setCamaraCajon(this);

		return calidadMuestraAreaCabecera;
	}

	public CalidadMuestraAreaCabecera removeCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().remove(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setCamaraCajon(null);

		return calidadMuestraAreaCabecera;
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


	//bi-directional many-to-one association to BarcoEstibaCuba
	@ManyToOne
	@JoinColumn(name="idbarcoestibacuba")
	public BarcoEstibaCuba getBarcoEstibaCuba() {
		return this.barcoEstibaCuba;
	}

	public void setBarcoEstibaCuba(BarcoEstibaCuba barcoEstibaCuba) {
		this.barcoEstibaCuba = barcoEstibaCuba;
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


	//bi-directional many-to-one association to Camara
	@ManyToOne
	@JoinColumn(name="idcamara")
	public Camara getCamara() {
		return this.camara;
	}

	public void setCamara(Camara camara) {
		this.camara = camara;
	}


	//bi-directional many-to-one association to CamaraArea
	@ManyToOne
	@JoinColumn(name="idcamaraarea")
	public CamaraArea getCamaraArea() {
		return this.camaraArea;
	}

	public void setCamaraArea(CamaraArea camaraArea) {
		this.camaraArea = camaraArea;
	}


	//bi-directional many-to-one association to CamaraCajonRegistroSap
	@ManyToOne
	@JoinColumn(name="idcamaracajonregistrosap")
	public CamaraCajonRegistroSap getCamaraCajonRegistroSap() {
		return this.camaraCajonRegistroSap;
	}

	public void setCamaraCajonRegistroSap(CamaraCajonRegistroSap camaraCajonRegistroSap) {
		this.camaraCajonRegistroSap = camaraCajonRegistroSap;
	}


	//bi-directional many-to-one association to CamaraFilaColumna
	@ManyToOne
	@JoinColumn(name="idfilacolumna")
	public CamaraFilaColumna getCamaraFilaColumna() {
		return this.camaraFilaColumna;
	}

	public void setCamaraFilaColumna(CamaraFilaColumna camaraFilaColumna) {
		this.camaraFilaColumna = camaraFilaColumna;
	}


	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idmaterial")
	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}


	//bi-directional many-to-one association to TipoCaptura
	@ManyToOne
	@JoinColumn(name="idtipocaptura")
	public TipoCaptura getTipoCaptura() {
		return this.tipoCaptura;
	}

	public void setTipoCaptura(TipoCaptura tipoCaptura) {
		this.tipoCaptura = tipoCaptura;
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


	//bi-directional many-to-one association to CamaraCajonUbicacion
	@OneToMany(mappedBy="camaraCajon")
	public List<CamaraCajonUbicacion> getCamaraCajonUbicacions() {
		return this.camaraCajonUbicacions;
	}

	public void setCamaraCajonUbicacions(List<CamaraCajonUbicacion> camaraCajonUbicacions) {
		this.camaraCajonUbicacions = camaraCajonUbicacions;
	}

	public CamaraCajonUbicacion addCamaraCajonUbicacion(CamaraCajonUbicacion camaraCajonUbicacion) {
		getCamaraCajonUbicacions().add(camaraCajonUbicacion);
		camaraCajonUbicacion.setCamaraCajon(this);

		return camaraCajonUbicacion;
	}

	public CamaraCajonUbicacion removeCamaraCajonUbicacion(CamaraCajonUbicacion camaraCajonUbicacion) {
		getCamaraCajonUbicacions().remove(camaraCajonUbicacion);
		camaraCajonUbicacion.setCamaraCajon(null);

		return camaraCajonUbicacion;
	}


	//bi-directional many-to-one association to PedidoProduccionArchivoCargaDetalle
	@OneToMany(mappedBy="camaraCajon")
	public List<PedidoProduccionArchivoCargaDetalle> getPedidoProduccionArchivoCargaDetalles() {
		return this.pedidoProduccionArchivoCargaDetalles;
	}

	public void setPedidoProduccionArchivoCargaDetalles(List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles) {
		this.pedidoProduccionArchivoCargaDetalles = pedidoProduccionArchivoCargaDetalles;
	}

	public PedidoProduccionArchivoCargaDetalle addPedidoProduccionArchivoCargaDetalle(PedidoProduccionArchivoCargaDetalle pedidoProduccionArchivoCargaDetalle) {
		getPedidoProduccionArchivoCargaDetalles().add(pedidoProduccionArchivoCargaDetalle);
		pedidoProduccionArchivoCargaDetalle.setCamaraCajon(this);

		return pedidoProduccionArchivoCargaDetalle;
	}

	public PedidoProduccionArchivoCargaDetalle removePedidoProduccionArchivoCargaDetalle(PedidoProduccionArchivoCargaDetalle pedidoProduccionArchivoCargaDetalle) {
		getPedidoProduccionArchivoCargaDetalles().remove(pedidoProduccionArchivoCargaDetalle);
		pedidoProduccionArchivoCargaDetalle.setCamaraCajon(null);

		return pedidoProduccionArchivoCargaDetalle;
	}


	//bi-directional many-to-one association to PedidoProduccionDetalle
	@OneToMany(mappedBy="camaraCajon")
	public List<PedidoProduccionDetalle> getPedidoProduccionDetalles() {
		return this.pedidoProduccionDetalles;
	}

	public void setPedidoProduccionDetalles(List<PedidoProduccionDetalle> pedidoProduccionDetalles) {
		this.pedidoProduccionDetalles = pedidoProduccionDetalles;
	}

	public PedidoProduccionDetalle addPedidoProduccionDetalle(PedidoProduccionDetalle pedidoProduccionDetalle) {
		getPedidoProduccionDetalles().add(pedidoProduccionDetalle);
		pedidoProduccionDetalle.setCamaraCajon(this);

		return pedidoProduccionDetalle;
	}

	public PedidoProduccionDetalle removePedidoProduccionDetalle(PedidoProduccionDetalle pedidoProduccionDetalle) {
		getPedidoProduccionDetalles().remove(pedidoProduccionDetalle);
		pedidoProduccionDetalle.setCamaraCajon(null);

		return pedidoProduccionDetalle;
	}


	//bi-directional many-to-one association to PlanificacionCargaDetalle
	@OneToMany(mappedBy="camaraCajon")
	public List<PlanificacionCargaDetalle> getPlanificacionCargaDetalles() {
		return this.planificacionCargaDetalles;
	}

	public void setPlanificacionCargaDetalles(List<PlanificacionCargaDetalle> planificacionCargaDetalles) {
		this.planificacionCargaDetalles = planificacionCargaDetalles;
	}

	public PlanificacionCargaDetalle addPlanificacionCargaDetalle(PlanificacionCargaDetalle planificacionCargaDetalle) {
		getPlanificacionCargaDetalles().add(planificacionCargaDetalle);
		planificacionCargaDetalle.setCamaraCajon(this);

		return planificacionCargaDetalle;
	}

	public PlanificacionCargaDetalle removePlanificacionCargaDetalle(PlanificacionCargaDetalle planificacionCargaDetalle) {
		getPlanificacionCargaDetalles().remove(planificacionCargaDetalle);
		planificacionCargaDetalle.setCamaraCajon(null);

		return planificacionCargaDetalle;
	}


	//bi-directional many-to-one association to ProduccionDetalleLoteCajon
	@OneToMany(mappedBy="camaraCajon")
	public List<ProduccionDetalleLoteCajon> getProduccionDetalleLoteCajons() {
		return this.produccionDetalleLoteCajons;
	}

	public void setProduccionDetalleLoteCajons(List<ProduccionDetalleLoteCajon> produccionDetalleLoteCajons) {
		this.produccionDetalleLoteCajons = produccionDetalleLoteCajons;
	}

	public ProduccionDetalleLoteCajon addProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		getProduccionDetalleLoteCajons().add(produccionDetalleLoteCajon);
		produccionDetalleLoteCajon.setCamaraCajon(this);

		return produccionDetalleLoteCajon;
	}

	public ProduccionDetalleLoteCajon removeProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		getProduccionDetalleLoteCajons().remove(produccionDetalleLoteCajon);
		produccionDetalleLoteCajon.setCamaraCajon(null);

		return produccionDetalleLoteCajon;
	}

}