package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the descongelado_detalle_proceso database table.
 * 
 */
@Entity
@Table(name="descongelado_detalle_proceso")
public class DescongeladoDetalleProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddescongeladodetalleproceso;

	private String cajonrevolteo;

	private Boolean checkpermitirpesodiferencia;

	private Integer checkpesocamara;

	private Boolean checkpesodividido;

	private Integer estado;

	private Timestamp fechaactualizacion;

	private Integer finforzado;

	private Integer finproceso;

	private Timestamp horafin;

	private Timestamp horafindescongelado;

	private Timestamp horafinforzado;

	private Timestamp horaingreso;

	private Timestamp horainicio;

	private Timestamp horapesocajon;

	private double horastranscurridas;

	private String idusuarioactualizacion;

	private String idusuarioingreso;

	private String idusuariopesocajon;

	private String idusuariosalida;

	private double minutostranscurridos;

	private Integer numeroduchadageneral;

	private String observaciones;

	private double peso;

	private double pesocomparativodiferenciacamara;

	private double pesodiferenciacamara;

	@Column(name="rango1_entregacamara")
	private double rango1Entregacamara;

	@Column(name="rango1_ingresodescongelado")
	private double rango1Ingresodescongelado;

	@Column(name="rango2_entregacamara")
	private double rango2Entregacamara;

	@Column(name="rango2_ingresodescongelado")
	private double rango2Ingresodescongelado;

	@Column(name="rango3_entregacamara")
	private double rango3Entregacamara;

	@Column(name="rango3_ingresodescongelado")
	private double rango3Ingresodescongelado;

	private double segundostranscurridos;

	private double tara;

	@Column(name="tiempo_estandar")
	private double tiempoEstandar;

	private String tipoingreso;

	private Integer ultimaidducha;

	//bi-directional many-to-one association to CalidadDescongeladoTempAgua
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	private List<CalidadDescongeladoTempAgua> calidadDescongeladoTempAguas;

	//bi-directional many-to-one association to CalidadDescongeladoTempPescado
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	private List<CalidadDescongeladoTempPescado> calidadDescongeladoTempPescados;

	//bi-directional many-to-one association to ContraloriaDetalleRackeoProcesoTemperatura
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	private List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas;

	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;

	//bi-directional many-to-one association to DescongeladoDetalleDuchaAperturaTalla
	@ManyToOne
	@JoinColumn(name="iddescongeladodetalleduchaaperturatalla")
	private DescongeladoDetalleDuchaAperturaTalla descongeladoDetalleDuchaAperturaTalla;

	//bi-directional many-to-one association to DescongeladoDucha
	@ManyToOne
	@JoinColumn(name="idducha")
	private DescongeladoDucha descongeladoDucha;

	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="ultimoiddescongeladoduchaaperturacierredetalle")
	private DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle1;

	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="iddescongeladoduchaaperturacierredetalle")
	private DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle2;

	//bi-directional many-to-one association to DescongeladoProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladoproceso")
	private DescongeladoProceso descongeladoProceso;

	//bi-directional many-to-one association to DuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idduchaaperturacierredetalle")
	private DuchaAperturaCierreDetalle duchaAperturaCierreDetalle;

	//bi-directional many-to-one association to ProduccionDetalleLoteCajon
	@ManyToOne
	@JoinColumn(name="idproducciondetallelotecajon")
	private ProduccionDetalleLoteCajon produccionDetalleLoteCajon;

	//bi-directional many-to-one association to RackeoProceso
	@ManyToOne
	@JoinColumn(name="idrackeoproceso")
	private RackeoProceso rackeoProceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to DescongeladoDetalleProcesoFinForzado
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	private List<DescongeladoDetalleProcesoFinForzado> descongeladoDetalleProcesoFinForzados;

	//bi-directional many-to-one association to DescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	private List<DescongeladoDetalleProcesoTempIng> descongeladoDetalleProcesoTempIngs;

	//bi-directional many-to-one association to DescongeladoDetalleProcesoTemperatura
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	private List<DescongeladoDetalleProcesoTemperatura> descongeladoDetalleProcesoTemperaturas;

	//bi-directional many-to-one association to OeeDetalleParadaRackeo
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	private List<OeeDetalleParadaRackeo> oeeDetalleParadaRackeos;

	public DescongeladoDetalleProceso() {
	}

	public Long getIddescongeladodetalleproceso() {
		return this.iddescongeladodetalleproceso;
	}

	public void setIddescongeladodetalleproceso(Long iddescongeladodetalleproceso) {
		this.iddescongeladodetalleproceso = iddescongeladodetalleproceso;
	}

	public String getCajonrevolteo() {
		return this.cajonrevolteo;
	}

	public void setCajonrevolteo(String cajonrevolteo) {
		this.cajonrevolteo = cajonrevolteo;
	}

	public Boolean getCheckpermitirpesodiferencia() {
		return this.checkpermitirpesodiferencia;
	}

	public void setCheckpermitirpesodiferencia(Boolean checkpermitirpesodiferencia) {
		this.checkpermitirpesodiferencia = checkpermitirpesodiferencia;
	}

	public Integer getCheckpesocamara() {
		return this.checkpesocamara;
	}

	public void setCheckpesocamara(Integer checkpesocamara) {
		this.checkpesocamara = checkpesocamara;
	}

	public Boolean getCheckpesodividido() {
		return this.checkpesodividido;
	}

	public void setCheckpesodividido(Boolean checkpesodividido) {
		this.checkpesodividido = checkpesodividido;
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

	public Integer getFinforzado() {
		return this.finforzado;
	}

	public void setFinforzado(Integer finforzado) {
		this.finforzado = finforzado;
	}

	public Integer getFinproceso() {
		return this.finproceso;
	}

	public void setFinproceso(Integer finproceso) {
		this.finproceso = finproceso;
	}

	public Timestamp getHorafin() {
		return this.horafin;
	}

	public void setHorafin(Timestamp horafin) {
		this.horafin = horafin;
	}

	public Timestamp getHorafindescongelado() {
		return this.horafindescongelado;
	}

	public void setHorafindescongelado(Timestamp horafindescongelado) {
		this.horafindescongelado = horafindescongelado;
	}

	public Timestamp getHorafinforzado() {
		return this.horafinforzado;
	}

	public void setHorafinforzado(Timestamp horafinforzado) {
		this.horafinforzado = horafinforzado;
	}

	public Timestamp getHoraingreso() {
		return this.horaingreso;
	}

	public void setHoraingreso(Timestamp horaingreso) {
		this.horaingreso = horaingreso;
	}

	public Timestamp getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Timestamp horainicio) {
		this.horainicio = horainicio;
	}

	public Timestamp getHorapesocajon() {
		return this.horapesocajon;
	}

	public void setHorapesocajon(Timestamp horapesocajon) {
		this.horapesocajon = horapesocajon;
	}

	public double getHorastranscurridas() {
		return this.horastranscurridas;
	}

	public void setHorastranscurridas(double horastranscurridas) {
		this.horastranscurridas = horastranscurridas;
	}

	public String getIdusuarioactualizacion() {
		return this.idusuarioactualizacion;
	}

	public void setIdusuarioactualizacion(String idusuarioactualizacion) {
		this.idusuarioactualizacion = idusuarioactualizacion;
	}

	public String getIdusuarioingreso() {
		return this.idusuarioingreso;
	}

	public void setIdusuarioingreso(String idusuarioingreso) {
		this.idusuarioingreso = idusuarioingreso;
	}

	public String getIdusuariopesocajon() {
		return this.idusuariopesocajon;
	}

	public void setIdusuariopesocajon(String idusuariopesocajon) {
		this.idusuariopesocajon = idusuariopesocajon;
	}

	public String getIdusuariosalida() {
		return this.idusuariosalida;
	}

	public void setIdusuariosalida(String idusuariosalida) {
		this.idusuariosalida = idusuariosalida;
	}

	public double getMinutostranscurridos() {
		return this.minutostranscurridos;
	}

	public void setMinutostranscurridos(double minutostranscurridos) {
		this.minutostranscurridos = minutostranscurridos;
	}

	public Integer getNumeroduchadageneral() {
		return this.numeroduchadageneral;
	}

	public void setNumeroduchadageneral(Integer numeroduchadageneral) {
		this.numeroduchadageneral = numeroduchadageneral;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPesocomparativodiferenciacamara() {
		return this.pesocomparativodiferenciacamara;
	}

	public void setPesocomparativodiferenciacamara(double pesocomparativodiferenciacamara) {
		this.pesocomparativodiferenciacamara = pesocomparativodiferenciacamara;
	}

	public double getPesodiferenciacamara() {
		return this.pesodiferenciacamara;
	}

	public void setPesodiferenciacamara(double pesodiferenciacamara) {
		this.pesodiferenciacamara = pesodiferenciacamara;
	}

	public double getRango1Entregacamara() {
		return this.rango1Entregacamara;
	}

	public void setRango1Entregacamara(double rango1Entregacamara) {
		this.rango1Entregacamara = rango1Entregacamara;
	}

	public double getRango1Ingresodescongelado() {
		return this.rango1Ingresodescongelado;
	}

	public void setRango1Ingresodescongelado(double rango1Ingresodescongelado) {
		this.rango1Ingresodescongelado = rango1Ingresodescongelado;
	}

	public double getRango2Entregacamara() {
		return this.rango2Entregacamara;
	}

	public void setRango2Entregacamara(double rango2Entregacamara) {
		this.rango2Entregacamara = rango2Entregacamara;
	}

	public double getRango2Ingresodescongelado() {
		return this.rango2Ingresodescongelado;
	}

	public void setRango2Ingresodescongelado(double rango2Ingresodescongelado) {
		this.rango2Ingresodescongelado = rango2Ingresodescongelado;
	}

	public double getRango3Entregacamara() {
		return this.rango3Entregacamara;
	}

	public void setRango3Entregacamara(double rango3Entregacamara) {
		this.rango3Entregacamara = rango3Entregacamara;
	}

	public double getRango3Ingresodescongelado() {
		return this.rango3Ingresodescongelado;
	}

	public void setRango3Ingresodescongelado(double rango3Ingresodescongelado) {
		this.rango3Ingresodescongelado = rango3Ingresodescongelado;
	}

	public double getSegundostranscurridos() {
		return this.segundostranscurridos;
	}

	public void setSegundostranscurridos(double segundostranscurridos) {
		this.segundostranscurridos = segundostranscurridos;
	}

	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	public double getTiempoEstandar() {
		return this.tiempoEstandar;
	}

	public void setTiempoEstandar(double tiempoEstandar) {
		this.tiempoEstandar = tiempoEstandar;
	}

	public String getTipoingreso() {
		return this.tipoingreso;
	}

	public void setTipoingreso(String tipoingreso) {
		this.tipoingreso = tipoingreso;
	}

	public Integer getUltimaidducha() {
		return this.ultimaidducha;
	}

	public void setUltimaidducha(Integer ultimaidducha) {
		this.ultimaidducha = ultimaidducha;
	}

	public List<CalidadDescongeladoTempAgua> getCalidadDescongeladoTempAguas() {
		return this.calidadDescongeladoTempAguas;
	}

	public void setCalidadDescongeladoTempAguas(List<CalidadDescongeladoTempAgua> calidadDescongeladoTempAguas) {
		this.calidadDescongeladoTempAguas = calidadDescongeladoTempAguas;
	}

	public List<CalidadDescongeladoTempPescado> getCalidadDescongeladoTempPescados() {
		return this.calidadDescongeladoTempPescados;
	}

	public void setCalidadDescongeladoTempPescados(List<CalidadDescongeladoTempPescado> calidadDescongeladoTempPescados) {
		this.calidadDescongeladoTempPescados = calidadDescongeladoTempPescados;
	}

	public List<ContraloriaDetalleRackeoProcesoTemperatura> getContraloriaDetalleRackeoProcesoTemperaturas() {
		return this.contraloriaDetalleRackeoProcesoTemperaturas;
	}

	public void setContraloriaDetalleRackeoProcesoTemperaturas(List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas) {
		this.contraloriaDetalleRackeoProcesoTemperaturas = contraloriaDetalleRackeoProcesoTemperaturas;
	}

	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public DescongeladoDetalleDuchaAperturaTalla getDescongeladoDetalleDuchaAperturaTalla() {
		return this.descongeladoDetalleDuchaAperturaTalla;
	}

	public void setDescongeladoDetalleDuchaAperturaTalla(DescongeladoDetalleDuchaAperturaTalla descongeladoDetalleDuchaAperturaTalla) {
		this.descongeladoDetalleDuchaAperturaTalla = descongeladoDetalleDuchaAperturaTalla;
	}

	public DescongeladoDucha getDescongeladoDucha() {
		return this.descongeladoDucha;
	}

	public void setDescongeladoDucha(DescongeladoDucha descongeladoDucha) {
		this.descongeladoDucha = descongeladoDucha;
	}

	public DescongeladoDuchaAperturaCierreDetalle getDescongeladoDuchaAperturaCierreDetalle1() {
		return this.descongeladoDuchaAperturaCierreDetalle1;
	}

	public void setDescongeladoDuchaAperturaCierreDetalle1(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle1) {
		this.descongeladoDuchaAperturaCierreDetalle1 = descongeladoDuchaAperturaCierreDetalle1;
	}

	public DescongeladoDuchaAperturaCierreDetalle getDescongeladoDuchaAperturaCierreDetalle2() {
		return this.descongeladoDuchaAperturaCierreDetalle2;
	}

	public void setDescongeladoDuchaAperturaCierreDetalle2(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle2) {
		this.descongeladoDuchaAperturaCierreDetalle2 = descongeladoDuchaAperturaCierreDetalle2;
	}

	public DescongeladoProceso getDescongeladoProceso() {
		return this.descongeladoProceso;
	}

	public void setDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		this.descongeladoProceso = descongeladoProceso;
	}

	public DuchaAperturaCierreDetalle getDuchaAperturaCierreDetalle() {
		return this.duchaAperturaCierreDetalle;
	}

	public void setDuchaAperturaCierreDetalle(DuchaAperturaCierreDetalle duchaAperturaCierreDetalle) {
		this.duchaAperturaCierreDetalle = duchaAperturaCierreDetalle;
	}

	public ProduccionDetalleLoteCajon getProduccionDetalleLoteCajon() {
		return this.produccionDetalleLoteCajon;
	}

	public void setProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		this.produccionDetalleLoteCajon = produccionDetalleLoteCajon;
	}

	public RackeoProceso getRackeoProceso() {
		return this.rackeoProceso;
	}

	public void setRackeoProceso(RackeoProceso rackeoProceso) {
		this.rackeoProceso = rackeoProceso;
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

	public List<DescongeladoDetalleProcesoFinForzado> getDescongeladoDetalleProcesoFinForzados() {
		return this.descongeladoDetalleProcesoFinForzados;
	}

	public void setDescongeladoDetalleProcesoFinForzados(List<DescongeladoDetalleProcesoFinForzado> descongeladoDetalleProcesoFinForzados) {
		this.descongeladoDetalleProcesoFinForzados = descongeladoDetalleProcesoFinForzados;
	}

	public List<DescongeladoDetalleProcesoTempIng> getDescongeladoDetalleProcesoTempIngs() {
		return this.descongeladoDetalleProcesoTempIngs;
	}

	public void setDescongeladoDetalleProcesoTempIngs(List<DescongeladoDetalleProcesoTempIng> descongeladoDetalleProcesoTempIngs) {
		this.descongeladoDetalleProcesoTempIngs = descongeladoDetalleProcesoTempIngs;
	}

	public List<DescongeladoDetalleProcesoTemperatura> getDescongeladoDetalleProcesoTemperaturas() {
		return this.descongeladoDetalleProcesoTemperaturas;
	}

	public void setDescongeladoDetalleProcesoTemperaturas(List<DescongeladoDetalleProcesoTemperatura> descongeladoDetalleProcesoTemperaturas) {
		this.descongeladoDetalleProcesoTemperaturas = descongeladoDetalleProcesoTemperaturas;
	}

	public List<OeeDetalleParadaRackeo> getOeeDetalleParadaRackeos() {
		return this.oeeDetalleParadaRackeos;
	}

	public void setOeeDetalleParadaRackeos(List<OeeDetalleParadaRackeo> oeeDetalleParadaRackeos) {
		this.oeeDetalleParadaRackeos = oeeDetalleParadaRackeos;
	}

}