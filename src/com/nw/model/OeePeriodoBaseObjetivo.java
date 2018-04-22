package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the oee_periodo_base_objetivo database table.
 * 
 */
@Entity
@Table(name="oee_periodo_base_objetivo")
public class OeePeriodoBaseObjetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_periodo_base_objetivo")
	private Long idOeePeriodoBaseObjetivo;

	private Boolean estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_periodo")
	private Date fechaFinPeriodo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_periodo")
	private Date fechaInicioPeriodo;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	@Column(name="objetivo_general")
	private double objetivoGeneral;

	private Integer orden;

	@Column(name="periodo_base_calidad")
	private double periodoBaseCalidad;

	@Column(name="periodo_base_cantidad")
	private double periodoBaseCantidad;

	@Column(name="periodo_base_general")
	private double periodoBaseGeneral;

	@Column(name="periodo_base_tiempo")
	private double periodoBaseTiempo;

	@Column(name="periodo_base_velocidad")
	private double periodoBaseVelocidad;

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

	private String tablero;

	//bi-directional many-to-one association to DescongeladoProceso
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	private List<DescongeladoProceso> descongeladoProcesos;

	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	private List<EnvasadoProceso> envasadoProcesos;

	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	private List<LimpiezaProceso> limpiezaProcesos;

	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	private List<LonjasProceso> lonjasProcesos;

	//bi-directional many-to-one association to OeeAreaTablero
	@ManyToOne
	@JoinColumn(name="id_oee_area_tablero")
	private OeeAreaTablero oeeAreaTablero;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to OeePeriodoBaseObjetivoDetalle
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	private List<OeePeriodoBaseObjetivoDetalle> oeePeriodoBaseObjetivoDetalles;

	//bi-directional many-to-one association to RackeoProceso
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	private List<RackeoProceso> rackeoProcesos;

	public OeePeriodoBaseObjetivo() {
	}

	public Long getIdOeePeriodoBaseObjetivo() {
		return this.idOeePeriodoBaseObjetivo;
	}

	public void setIdOeePeriodoBaseObjetivo(Long idOeePeriodoBaseObjetivo) {
		this.idOeePeriodoBaseObjetivo = idOeePeriodoBaseObjetivo;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFechaFinPeriodo() {
		return this.fechaFinPeriodo;
	}

	public void setFechaFinPeriodo(Date fechaFinPeriodo) {
		this.fechaFinPeriodo = fechaFinPeriodo;
	}

	public Date getFechaInicioPeriodo() {
		return this.fechaInicioPeriodo;
	}

	public void setFechaInicioPeriodo(Date fechaInicioPeriodo) {
		this.fechaInicioPeriodo = fechaInicioPeriodo;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public double getObjetivoGeneral() {
		return this.objetivoGeneral;
	}

	public void setObjetivoGeneral(double objetivoGeneral) {
		this.objetivoGeneral = objetivoGeneral;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public double getPeriodoBaseCalidad() {
		return this.periodoBaseCalidad;
	}

	public void setPeriodoBaseCalidad(double periodoBaseCalidad) {
		this.periodoBaseCalidad = periodoBaseCalidad;
	}

	public double getPeriodoBaseCantidad() {
		return this.periodoBaseCantidad;
	}

	public void setPeriodoBaseCantidad(double periodoBaseCantidad) {
		this.periodoBaseCantidad = periodoBaseCantidad;
	}

	public double getPeriodoBaseGeneral() {
		return this.periodoBaseGeneral;
	}

	public void setPeriodoBaseGeneral(double periodoBaseGeneral) {
		this.periodoBaseGeneral = periodoBaseGeneral;
	}

	public double getPeriodoBaseTiempo() {
		return this.periodoBaseTiempo;
	}

	public void setPeriodoBaseTiempo(double periodoBaseTiempo) {
		this.periodoBaseTiempo = periodoBaseTiempo;
	}

	public double getPeriodoBaseVelocidad() {
		return this.periodoBaseVelocidad;
	}

	public void setPeriodoBaseVelocidad(double periodoBaseVelocidad) {
		this.periodoBaseVelocidad = periodoBaseVelocidad;
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

	public String getTablero() {
		return this.tablero;
	}

	public void setTablero(String tablero) {
		this.tablero = tablero;
	}

	public List<DescongeladoProceso> getDescongeladoProcesos() {
		return this.descongeladoProcesos;
	}

	public void setDescongeladoProcesos(List<DescongeladoProceso> descongeladoProcesos) {
		this.descongeladoProcesos = descongeladoProcesos;
	}

	public List<EnvasadoProceso> getEnvasadoProcesos() {
		return this.envasadoProcesos;
	}

	public void setEnvasadoProcesos(List<EnvasadoProceso> envasadoProcesos) {
		this.envasadoProcesos = envasadoProcesos;
	}

	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
	}

	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
	}

	public OeeAreaTablero getOeeAreaTablero() {
		return this.oeeAreaTablero;
	}

	public void setOeeAreaTablero(OeeAreaTablero oeeAreaTablero) {
		this.oeeAreaTablero = oeeAreaTablero;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<OeePeriodoBaseObjetivoDetalle> getOeePeriodoBaseObjetivoDetalles() {
		return this.oeePeriodoBaseObjetivoDetalles;
	}

	public void setOeePeriodoBaseObjetivoDetalles(List<OeePeriodoBaseObjetivoDetalle> oeePeriodoBaseObjetivoDetalles) {
		this.oeePeriodoBaseObjetivoDetalles = oeePeriodoBaseObjetivoDetalles;
	}

	public List<RackeoProceso> getRackeoProcesos() {
		return this.rackeoProcesos;
	}

	public void setRackeoProcesos(List<RackeoProceso> rackeoProcesos) {
		this.rackeoProcesos = rackeoProcesos;
	}

}