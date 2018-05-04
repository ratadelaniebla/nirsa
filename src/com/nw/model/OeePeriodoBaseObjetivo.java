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
@NamedQuery(name="OeePeriodoBaseObjetivo.findAll", query="SELECT o FROM OeePeriodoBaseObjetivo o")
public class OeePeriodoBaseObjetivo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idOeePeriodoBaseObjetivo;
	private Boolean estado;
	private Date fechaFinPeriodo;
	private Date fechaInicioPeriodo;
	private Timestamp fechaRegistro;
	private double objetivoGeneral;
	private Integer orden;
	private double periodoBaseCalidad;
	private double periodoBaseCantidad;
	private double periodoBaseGeneral;
	private double periodoBaseTiempo;
	private double periodoBaseVelocidad;
	private double rango1Entregacamara;
	private double rango1Ingresodescongelado;
	private double rango2Entregacamara;
	private double rango2Ingresodescongelado;
	private double rango3Entregacamara;
	private double rango3Ingresodescongelado;
	private String tablero;
	private List<DescongeladoProceso> descongeladoProcesos;
	private List<EnvasadoProceso> envasadoProcesos;
	private List<LimpiezaProceso> limpiezaProcesos;
	private List<LonjasProceso> lonjasProcesos;
	private OeeAreaTablero oeeAreaTablero;
	private Proceso proceso;
	private Usuario usuario;
	private List<OeePeriodoBaseObjetivoDetalle> oeePeriodoBaseObjetivoDetalles;
	private List<RackeoProceso> rackeoProcesos;

	public OeePeriodoBaseObjetivo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_periodo_base_objetivo")
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


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin_periodo")
	public Date getFechaFinPeriodo() {
		return this.fechaFinPeriodo;
	}

	public void setFechaFinPeriodo(Date fechaFinPeriodo) {
		this.fechaFinPeriodo = fechaFinPeriodo;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio_periodo")
	public Date getFechaInicioPeriodo() {
		return this.fechaInicioPeriodo;
	}

	public void setFechaInicioPeriodo(Date fechaInicioPeriodo) {
		this.fechaInicioPeriodo = fechaInicioPeriodo;
	}


	@Column(name="fecha_registro")
	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Column(name="objetivo_general")
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


	@Column(name="periodo_base_calidad")
	public double getPeriodoBaseCalidad() {
		return this.periodoBaseCalidad;
	}

	public void setPeriodoBaseCalidad(double periodoBaseCalidad) {
		this.periodoBaseCalidad = periodoBaseCalidad;
	}


	@Column(name="periodo_base_cantidad")
	public double getPeriodoBaseCantidad() {
		return this.periodoBaseCantidad;
	}

	public void setPeriodoBaseCantidad(double periodoBaseCantidad) {
		this.periodoBaseCantidad = periodoBaseCantidad;
	}


	@Column(name="periodo_base_general")
	public double getPeriodoBaseGeneral() {
		return this.periodoBaseGeneral;
	}

	public void setPeriodoBaseGeneral(double periodoBaseGeneral) {
		this.periodoBaseGeneral = periodoBaseGeneral;
	}


	@Column(name="periodo_base_tiempo")
	public double getPeriodoBaseTiempo() {
		return this.periodoBaseTiempo;
	}

	public void setPeriodoBaseTiempo(double periodoBaseTiempo) {
		this.periodoBaseTiempo = periodoBaseTiempo;
	}


	@Column(name="periodo_base_velocidad")
	public double getPeriodoBaseVelocidad() {
		return this.periodoBaseVelocidad;
	}

	public void setPeriodoBaseVelocidad(double periodoBaseVelocidad) {
		this.periodoBaseVelocidad = periodoBaseVelocidad;
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


	public String getTablero() {
		return this.tablero;
	}

	public void setTablero(String tablero) {
		this.tablero = tablero;
	}


	//bi-directional many-to-one association to DescongeladoProceso
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	public List<DescongeladoProceso> getDescongeladoProcesos() {
		return this.descongeladoProcesos;
	}

	public void setDescongeladoProcesos(List<DescongeladoProceso> descongeladoProcesos) {
		this.descongeladoProcesos = descongeladoProcesos;
	}

	public DescongeladoProceso addDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		getDescongeladoProcesos().add(descongeladoProceso);
		descongeladoProceso.setOeePeriodoBaseObjetivo(this);

		return descongeladoProceso;
	}

	public DescongeladoProceso removeDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		getDescongeladoProcesos().remove(descongeladoProceso);
		descongeladoProceso.setOeePeriodoBaseObjetivo(null);

		return descongeladoProceso;
	}


	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	public List<EnvasadoProceso> getEnvasadoProcesos() {
		return this.envasadoProcesos;
	}

	public void setEnvasadoProcesos(List<EnvasadoProceso> envasadoProcesos) {
		this.envasadoProcesos = envasadoProcesos;
	}

	public EnvasadoProceso addEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().add(envasadoProceso);
		envasadoProceso.setOeePeriodoBaseObjetivo(this);

		return envasadoProceso;
	}

	public EnvasadoProceso removeEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().remove(envasadoProceso);
		envasadoProceso.setOeePeriodoBaseObjetivo(null);

		return envasadoProceso;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
	}

	public LimpiezaProceso addLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().add(limpiezaProceso);
		limpiezaProceso.setOeePeriodoBaseObjetivo(this);

		return limpiezaProceso;
	}

	public LimpiezaProceso removeLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().remove(limpiezaProceso);
		limpiezaProceso.setOeePeriodoBaseObjetivo(null);

		return limpiezaProceso;
	}


	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
	}

	public LonjasProceso addLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().add(lonjasProceso);
		lonjasProceso.setOeePeriodoBaseObjetivo(this);

		return lonjasProceso;
	}

	public LonjasProceso removeLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().remove(lonjasProceso);
		lonjasProceso.setOeePeriodoBaseObjetivo(null);

		return lonjasProceso;
	}


	//bi-directional many-to-one association to OeeAreaTablero
	@ManyToOne
	@JoinColumn(name="id_oee_area_tablero")
	public OeeAreaTablero getOeeAreaTablero() {
		return this.oeeAreaTablero;
	}

	public void setOeeAreaTablero(OeeAreaTablero oeeAreaTablero) {
		this.oeeAreaTablero = oeeAreaTablero;
	}


	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
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


	//bi-directional many-to-one association to OeePeriodoBaseObjetivoDetalle
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	public List<OeePeriodoBaseObjetivoDetalle> getOeePeriodoBaseObjetivoDetalles() {
		return this.oeePeriodoBaseObjetivoDetalles;
	}

	public void setOeePeriodoBaseObjetivoDetalles(List<OeePeriodoBaseObjetivoDetalle> oeePeriodoBaseObjetivoDetalles) {
		this.oeePeriodoBaseObjetivoDetalles = oeePeriodoBaseObjetivoDetalles;
	}

	public OeePeriodoBaseObjetivoDetalle addOeePeriodoBaseObjetivoDetalle(OeePeriodoBaseObjetivoDetalle oeePeriodoBaseObjetivoDetalle) {
		getOeePeriodoBaseObjetivoDetalles().add(oeePeriodoBaseObjetivoDetalle);
		oeePeriodoBaseObjetivoDetalle.setOeePeriodoBaseObjetivo(this);

		return oeePeriodoBaseObjetivoDetalle;
	}

	public OeePeriodoBaseObjetivoDetalle removeOeePeriodoBaseObjetivoDetalle(OeePeriodoBaseObjetivoDetalle oeePeriodoBaseObjetivoDetalle) {
		getOeePeriodoBaseObjetivoDetalles().remove(oeePeriodoBaseObjetivoDetalle);
		oeePeriodoBaseObjetivoDetalle.setOeePeriodoBaseObjetivo(null);

		return oeePeriodoBaseObjetivoDetalle;
	}


	//bi-directional many-to-one association to RackeoProceso
	@OneToMany(mappedBy="oeePeriodoBaseObjetivo")
	public List<RackeoProceso> getRackeoProcesos() {
		return this.rackeoProcesos;
	}

	public void setRackeoProcesos(List<RackeoProceso> rackeoProcesos) {
		this.rackeoProcesos = rackeoProcesos;
	}

	public RackeoProceso addRackeoProceso(RackeoProceso rackeoProceso) {
		getRackeoProcesos().add(rackeoProceso);
		rackeoProceso.setOeePeriodoBaseObjetivo(this);

		return rackeoProceso;
	}

	public RackeoProceso removeRackeoProceso(RackeoProceso rackeoProceso) {
		getRackeoProcesos().remove(rackeoProceso);
		rackeoProceso.setOeePeriodoBaseObjetivo(null);

		return rackeoProceso;
	}

}