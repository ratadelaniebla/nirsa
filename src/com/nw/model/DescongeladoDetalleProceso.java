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
@NamedQuery(name="DescongeladoDetalleProceso.findAll", query="SELECT d FROM DescongeladoDetalleProceso d")
public class DescongeladoDetalleProceso implements Serializable {
	private static final long serialVersionUID = 1L;
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
	private double rango1Entregacamara;
	private double rango1Ingresodescongelado;
	private double rango2Entregacamara;
	private double rango2Ingresodescongelado;
	private double rango3Entregacamara;
	private double rango3Ingresodescongelado;
	private double segundostranscurridos;
	private double tara;
	private double tiempoEstandar;
	private String tipoingreso;
	private Integer ultimaidducha;
	private List<CalidadDescongeladoTempAgua> calidadDescongeladoTempAguas;
	private List<CalidadDescongeladoTempPescado> calidadDescongeladoTempPescados;
	private List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas;
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;
	private DescongeladoDetalleDuchaAperturaTalla descongeladoDetalleDuchaAperturaTalla;
	private DescongeladoDucha descongeladoDucha;
	private DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle1;
	private DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle2;
	private DescongeladoProceso descongeladoProceso;
	private DuchaAperturaCierreDetalle duchaAperturaCierreDetalle;
	private ProduccionDetalleLoteCajon produccionDetalleLoteCajon;
	private RackeoProceso rackeoProceso;
	private Turno turno;
	private Usuario usuario;
	private List<DescongeladoDetalleProcesoFinForzado> descongeladoDetalleProcesoFinForzados;
	private List<DescongeladoDetalleProcesoTempIng> descongeladoDetalleProcesoTempIngs;
	private List<DescongeladoDetalleProcesoTemperatura> descongeladoDetalleProcesoTemperaturas;
	private List<OeeDetalleParadaRackeo> oeeDetalleParadaRackeos;

	public DescongeladoDetalleProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="rango1_entregacamara")
	public double getRango1Entregacamara() {
		return this.rango1Entregacamara;
	}

	public void setRango1Entregacamara(double rango1Entregacamara) {
		this.rango1Entregacamara = rango1Entregacamara;
	}


	@Column(name="rango1_ingresodescongelado")
	public double getRango1Ingresodescongelado() {
		return this.rango1Ingresodescongelado;
	}

	public void setRango1Ingresodescongelado(double rango1Ingresodescongelado) {
		this.rango1Ingresodescongelado = rango1Ingresodescongelado;
	}


	@Column(name="rango2_entregacamara")
	public double getRango2Entregacamara() {
		return this.rango2Entregacamara;
	}

	public void setRango2Entregacamara(double rango2Entregacamara) {
		this.rango2Entregacamara = rango2Entregacamara;
	}


	@Column(name="rango2_ingresodescongelado")
	public double getRango2Ingresodescongelado() {
		return this.rango2Ingresodescongelado;
	}

	public void setRango2Ingresodescongelado(double rango2Ingresodescongelado) {
		this.rango2Ingresodescongelado = rango2Ingresodescongelado;
	}


	@Column(name="rango3_entregacamara")
	public double getRango3Entregacamara() {
		return this.rango3Entregacamara;
	}

	public void setRango3Entregacamara(double rango3Entregacamara) {
		this.rango3Entregacamara = rango3Entregacamara;
	}


	@Column(name="rango3_ingresodescongelado")
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


	@Column(name="tiempo_estandar")
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


	//bi-directional many-to-one association to CalidadDescongeladoTempAgua
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	public List<CalidadDescongeladoTempAgua> getCalidadDescongeladoTempAguas() {
		return this.calidadDescongeladoTempAguas;
	}

	public void setCalidadDescongeladoTempAguas(List<CalidadDescongeladoTempAgua> calidadDescongeladoTempAguas) {
		this.calidadDescongeladoTempAguas = calidadDescongeladoTempAguas;
	}

	public CalidadDescongeladoTempAgua addCalidadDescongeladoTempAgua(CalidadDescongeladoTempAgua calidadDescongeladoTempAgua) {
		getCalidadDescongeladoTempAguas().add(calidadDescongeladoTempAgua);
		calidadDescongeladoTempAgua.setDescongeladoDetalleProceso(this);

		return calidadDescongeladoTempAgua;
	}

	public CalidadDescongeladoTempAgua removeCalidadDescongeladoTempAgua(CalidadDescongeladoTempAgua calidadDescongeladoTempAgua) {
		getCalidadDescongeladoTempAguas().remove(calidadDescongeladoTempAgua);
		calidadDescongeladoTempAgua.setDescongeladoDetalleProceso(null);

		return calidadDescongeladoTempAgua;
	}


	//bi-directional many-to-one association to CalidadDescongeladoTempPescado
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	public List<CalidadDescongeladoTempPescado> getCalidadDescongeladoTempPescados() {
		return this.calidadDescongeladoTempPescados;
	}

	public void setCalidadDescongeladoTempPescados(List<CalidadDescongeladoTempPescado> calidadDescongeladoTempPescados) {
		this.calidadDescongeladoTempPescados = calidadDescongeladoTempPescados;
	}

	public CalidadDescongeladoTempPescado addCalidadDescongeladoTempPescado(CalidadDescongeladoTempPescado calidadDescongeladoTempPescado) {
		getCalidadDescongeladoTempPescados().add(calidadDescongeladoTempPescado);
		calidadDescongeladoTempPescado.setDescongeladoDetalleProceso(this);

		return calidadDescongeladoTempPescado;
	}

	public CalidadDescongeladoTempPescado removeCalidadDescongeladoTempPescado(CalidadDescongeladoTempPescado calidadDescongeladoTempPescado) {
		getCalidadDescongeladoTempPescados().remove(calidadDescongeladoTempPescado);
		calidadDescongeladoTempPescado.setDescongeladoDetalleProceso(null);

		return calidadDescongeladoTempPescado;
	}


	//bi-directional many-to-one association to ContraloriaDetalleRackeoProcesoTemperatura
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	public List<ContraloriaDetalleRackeoProcesoTemperatura> getContraloriaDetalleRackeoProcesoTemperaturas() {
		return this.contraloriaDetalleRackeoProcesoTemperaturas;
	}

	public void setContraloriaDetalleRackeoProcesoTemperaturas(List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas) {
		this.contraloriaDetalleRackeoProcesoTemperaturas = contraloriaDetalleRackeoProcesoTemperaturas;
	}

	public ContraloriaDetalleRackeoProcesoTemperatura addContraloriaDetalleRackeoProcesoTemperatura(ContraloriaDetalleRackeoProcesoTemperatura contraloriaDetalleRackeoProcesoTemperatura) {
		getContraloriaDetalleRackeoProcesoTemperaturas().add(contraloriaDetalleRackeoProcesoTemperatura);
		contraloriaDetalleRackeoProcesoTemperatura.setDescongeladoDetalleProceso(this);

		return contraloriaDetalleRackeoProcesoTemperatura;
	}

	public ContraloriaDetalleRackeoProcesoTemperatura removeContraloriaDetalleRackeoProcesoTemperatura(ContraloriaDetalleRackeoProcesoTemperatura contraloriaDetalleRackeoProcesoTemperatura) {
		getContraloriaDetalleRackeoProcesoTemperaturas().remove(contraloriaDetalleRackeoProcesoTemperatura);
		contraloriaDetalleRackeoProcesoTemperatura.setDescongeladoDetalleProceso(null);

		return contraloriaDetalleRackeoProcesoTemperatura;
	}


	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public DescongeladoCajonModificacion addDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().add(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setDescongeladoDetalleProceso(this);

		return descongeladoCajonModificacion;
	}

	public DescongeladoCajonModificacion removeDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().remove(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setDescongeladoDetalleProceso(null);

		return descongeladoCajonModificacion;
	}


	//bi-directional many-to-one association to DescongeladoDetalleDuchaAperturaTalla
	@ManyToOne
	@JoinColumn(name="iddescongeladodetalleduchaaperturatalla")
	public DescongeladoDetalleDuchaAperturaTalla getDescongeladoDetalleDuchaAperturaTalla() {
		return this.descongeladoDetalleDuchaAperturaTalla;
	}

	public void setDescongeladoDetalleDuchaAperturaTalla(DescongeladoDetalleDuchaAperturaTalla descongeladoDetalleDuchaAperturaTalla) {
		this.descongeladoDetalleDuchaAperturaTalla = descongeladoDetalleDuchaAperturaTalla;
	}


	//bi-directional many-to-one association to DescongeladoDucha
	@ManyToOne
	@JoinColumn(name="idducha")
	public DescongeladoDucha getDescongeladoDucha() {
		return this.descongeladoDucha;
	}

	public void setDescongeladoDucha(DescongeladoDucha descongeladoDucha) {
		this.descongeladoDucha = descongeladoDucha;
	}


	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="ultimoiddescongeladoduchaaperturacierredetalle")
	public DescongeladoDuchaAperturaCierreDetalle getDescongeladoDuchaAperturaCierreDetalle1() {
		return this.descongeladoDuchaAperturaCierreDetalle1;
	}

	public void setDescongeladoDuchaAperturaCierreDetalle1(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle1) {
		this.descongeladoDuchaAperturaCierreDetalle1 = descongeladoDuchaAperturaCierreDetalle1;
	}


	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="iddescongeladoduchaaperturacierredetalle")
	public DescongeladoDuchaAperturaCierreDetalle getDescongeladoDuchaAperturaCierreDetalle2() {
		return this.descongeladoDuchaAperturaCierreDetalle2;
	}

	public void setDescongeladoDuchaAperturaCierreDetalle2(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle2) {
		this.descongeladoDuchaAperturaCierreDetalle2 = descongeladoDuchaAperturaCierreDetalle2;
	}


	//bi-directional many-to-one association to DescongeladoProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladoproceso")
	public DescongeladoProceso getDescongeladoProceso() {
		return this.descongeladoProceso;
	}

	public void setDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		this.descongeladoProceso = descongeladoProceso;
	}


	//bi-directional many-to-one association to DuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="idduchaaperturacierredetalle")
	public DuchaAperturaCierreDetalle getDuchaAperturaCierreDetalle() {
		return this.duchaAperturaCierreDetalle;
	}

	public void setDuchaAperturaCierreDetalle(DuchaAperturaCierreDetalle duchaAperturaCierreDetalle) {
		this.duchaAperturaCierreDetalle = duchaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to ProduccionDetalleLoteCajon
	@ManyToOne
	@JoinColumn(name="idproducciondetallelotecajon")
	public ProduccionDetalleLoteCajon getProduccionDetalleLoteCajon() {
		return this.produccionDetalleLoteCajon;
	}

	public void setProduccionDetalleLoteCajon(ProduccionDetalleLoteCajon produccionDetalleLoteCajon) {
		this.produccionDetalleLoteCajon = produccionDetalleLoteCajon;
	}


	//bi-directional many-to-one association to RackeoProceso
	@ManyToOne
	@JoinColumn(name="idrackeoproceso")
	public RackeoProceso getRackeoProceso() {
		return this.rackeoProceso;
	}

	public void setRackeoProceso(RackeoProceso rackeoProceso) {
		this.rackeoProceso = rackeoProceso;
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


	//bi-directional many-to-one association to DescongeladoDetalleProcesoFinForzado
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	public List<DescongeladoDetalleProcesoFinForzado> getDescongeladoDetalleProcesoFinForzados() {
		return this.descongeladoDetalleProcesoFinForzados;
	}

	public void setDescongeladoDetalleProcesoFinForzados(List<DescongeladoDetalleProcesoFinForzado> descongeladoDetalleProcesoFinForzados) {
		this.descongeladoDetalleProcesoFinForzados = descongeladoDetalleProcesoFinForzados;
	}

	public DescongeladoDetalleProcesoFinForzado addDescongeladoDetalleProcesoFinForzado(DescongeladoDetalleProcesoFinForzado descongeladoDetalleProcesoFinForzado) {
		getDescongeladoDetalleProcesoFinForzados().add(descongeladoDetalleProcesoFinForzado);
		descongeladoDetalleProcesoFinForzado.setDescongeladoDetalleProceso(this);

		return descongeladoDetalleProcesoFinForzado;
	}

	public DescongeladoDetalleProcesoFinForzado removeDescongeladoDetalleProcesoFinForzado(DescongeladoDetalleProcesoFinForzado descongeladoDetalleProcesoFinForzado) {
		getDescongeladoDetalleProcesoFinForzados().remove(descongeladoDetalleProcesoFinForzado);
		descongeladoDetalleProcesoFinForzado.setDescongeladoDetalleProceso(null);

		return descongeladoDetalleProcesoFinForzado;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	public List<DescongeladoDetalleProcesoTempIng> getDescongeladoDetalleProcesoTempIngs() {
		return this.descongeladoDetalleProcesoTempIngs;
	}

	public void setDescongeladoDetalleProcesoTempIngs(List<DescongeladoDetalleProcesoTempIng> descongeladoDetalleProcesoTempIngs) {
		this.descongeladoDetalleProcesoTempIngs = descongeladoDetalleProcesoTempIngs;
	}

	public DescongeladoDetalleProcesoTempIng addDescongeladoDetalleProcesoTempIng(DescongeladoDetalleProcesoTempIng descongeladoDetalleProcesoTempIng) {
		getDescongeladoDetalleProcesoTempIngs().add(descongeladoDetalleProcesoTempIng);
		descongeladoDetalleProcesoTempIng.setDescongeladoDetalleProceso(this);

		return descongeladoDetalleProcesoTempIng;
	}

	public DescongeladoDetalleProcesoTempIng removeDescongeladoDetalleProcesoTempIng(DescongeladoDetalleProcesoTempIng descongeladoDetalleProcesoTempIng) {
		getDescongeladoDetalleProcesoTempIngs().remove(descongeladoDetalleProcesoTempIng);
		descongeladoDetalleProcesoTempIng.setDescongeladoDetalleProceso(null);

		return descongeladoDetalleProcesoTempIng;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProcesoTemperatura
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	public List<DescongeladoDetalleProcesoTemperatura> getDescongeladoDetalleProcesoTemperaturas() {
		return this.descongeladoDetalleProcesoTemperaturas;
	}

	public void setDescongeladoDetalleProcesoTemperaturas(List<DescongeladoDetalleProcesoTemperatura> descongeladoDetalleProcesoTemperaturas) {
		this.descongeladoDetalleProcesoTemperaturas = descongeladoDetalleProcesoTemperaturas;
	}

	public DescongeladoDetalleProcesoTemperatura addDescongeladoDetalleProcesoTemperatura(DescongeladoDetalleProcesoTemperatura descongeladoDetalleProcesoTemperatura) {
		getDescongeladoDetalleProcesoTemperaturas().add(descongeladoDetalleProcesoTemperatura);
		descongeladoDetalleProcesoTemperatura.setDescongeladoDetalleProceso(this);

		return descongeladoDetalleProcesoTemperatura;
	}

	public DescongeladoDetalleProcesoTemperatura removeDescongeladoDetalleProcesoTemperatura(DescongeladoDetalleProcesoTemperatura descongeladoDetalleProcesoTemperatura) {
		getDescongeladoDetalleProcesoTemperaturas().remove(descongeladoDetalleProcesoTemperatura);
		descongeladoDetalleProcesoTemperatura.setDescongeladoDetalleProceso(null);

		return descongeladoDetalleProcesoTemperatura;
	}


	//bi-directional many-to-one association to OeeDetalleParadaRackeo
	@OneToMany(mappedBy="descongeladoDetalleProceso")
	public List<OeeDetalleParadaRackeo> getOeeDetalleParadaRackeos() {
		return this.oeeDetalleParadaRackeos;
	}

	public void setOeeDetalleParadaRackeos(List<OeeDetalleParadaRackeo> oeeDetalleParadaRackeos) {
		this.oeeDetalleParadaRackeos = oeeDetalleParadaRackeos;
	}

	public OeeDetalleParadaRackeo addOeeDetalleParadaRackeo(OeeDetalleParadaRackeo oeeDetalleParadaRackeo) {
		getOeeDetalleParadaRackeos().add(oeeDetalleParadaRackeo);
		oeeDetalleParadaRackeo.setDescongeladoDetalleProceso(this);

		return oeeDetalleParadaRackeo;
	}

	public OeeDetalleParadaRackeo removeOeeDetalleParadaRackeo(OeeDetalleParadaRackeo oeeDetalleParadaRackeo) {
		getOeeDetalleParadaRackeos().remove(oeeDetalleParadaRackeo);
		oeeDetalleParadaRackeo.setDescongeladoDetalleProceso(null);

		return oeeDetalleParadaRackeo;
	}

}