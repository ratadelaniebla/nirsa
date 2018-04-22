package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the limpieza_proceso database table.
 * 
 */
@Entity
@Table(name="limpieza_proceso")
public class LimpiezaProceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaproceso;

	private Integer estado;

	private Timestamp fechareg;

	@Column(name="objetivo_general")
	private double objetivoGeneral;

	private double oee;

	@Column(name="periodo_base_calidad_limpieza")
	private double periodoBaseCalidadLimpieza;

	@Column(name="periodo_base_general")
	private double periodoBaseGeneral;

	@Column(name="periodo_base_tiempo_limpieza")
	private double periodoBaseTiempoLimpieza;

	@Column(name="periodo_base_velocidad_limpieza")
	private double periodoBaseVelocidadLimpieza;

	//bi-directional many-to-one association to CalidadMuestreoTempLimpieza
	@OneToMany(mappedBy="limpiezaProceso")
	private List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas;

	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="limpiezaProceso")
	private List<EnvasadoProceso> envasadoProcesos;

	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlanta
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaCabeceraCortesPlanta> limpiezaCabeceraCortesPlantas;

	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlantaLineaEmpleado
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaCabeceraCortesPlantaLineaEmpleado> limpiezaCabeceraCortesPlantaLineaEmpleados;

	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes;

	//bi-directional many-to-one association to LimpiezaDetalleTipoCorte
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes;

	//bi-directional many-to-one association to LimpiezaDetalleTipoPara
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas;

	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;

	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	private ObservacionesProceso observacionesProceso;

	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@ManyToOne
	@JoinColumn(name="id_oee_periodo_base_objetivo")
	private OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	private ProcesoAperturaCierre procesoAperturaCierre;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoTotalInicial
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials;

	//bi-directional many-to-one association to LimpiezaProcesoJornadaLinea
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaProcesoJornadaLinea> limpiezaProcesoJornadaLineas;

	//bi-directional many-to-one association to LimpiezaProcesoLineaTara
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaProcesoLineaTara> limpiezaProcesoLineaTaras;

	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos;

	//bi-directional many-to-one association to LimpiezaRalladoBatchCabecera
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaRalladoBatchCabecera> limpiezaRalladoBatchCabeceras;

	//bi-directional many-to-one association to LimpiezaRalladoDetallePeso
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos;

	//bi-directional many-to-one association to LimpiezaRalladoDetallePesosAlmacenado
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LimpiezaRalladoDetallePesosAlmacenado> limpiezaRalladoDetallePesosAlmacenados;

	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="limpiezaProceso")
	private List<LonjasProceso> lonjasProcesos;

	public LimpiezaProceso() {
	}

	public Long getIdlimpiezaproceso() {
		return this.idlimpiezaproceso;
	}

	public void setIdlimpiezaproceso(Long idlimpiezaproceso) {
		this.idlimpiezaproceso = idlimpiezaproceso;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public double getObjetivoGeneral() {
		return this.objetivoGeneral;
	}

	public void setObjetivoGeneral(double objetivoGeneral) {
		this.objetivoGeneral = objetivoGeneral;
	}

	public double getOee() {
		return this.oee;
	}

	public void setOee(double oee) {
		this.oee = oee;
	}

	public double getPeriodoBaseCalidadLimpieza() {
		return this.periodoBaseCalidadLimpieza;
	}

	public void setPeriodoBaseCalidadLimpieza(double periodoBaseCalidadLimpieza) {
		this.periodoBaseCalidadLimpieza = periodoBaseCalidadLimpieza;
	}

	public double getPeriodoBaseGeneral() {
		return this.periodoBaseGeneral;
	}

	public void setPeriodoBaseGeneral(double periodoBaseGeneral) {
		this.periodoBaseGeneral = periodoBaseGeneral;
	}

	public double getPeriodoBaseTiempoLimpieza() {
		return this.periodoBaseTiempoLimpieza;
	}

	public void setPeriodoBaseTiempoLimpieza(double periodoBaseTiempoLimpieza) {
		this.periodoBaseTiempoLimpieza = periodoBaseTiempoLimpieza;
	}

	public double getPeriodoBaseVelocidadLimpieza() {
		return this.periodoBaseVelocidadLimpieza;
	}

	public void setPeriodoBaseVelocidadLimpieza(double periodoBaseVelocidadLimpieza) {
		this.periodoBaseVelocidadLimpieza = periodoBaseVelocidadLimpieza;
	}

	public List<CalidadMuestreoTempLimpieza> getCalidadMuestreoTempLimpiezas() {
		return this.calidadMuestreoTempLimpiezas;
	}

	public void setCalidadMuestreoTempLimpiezas(List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas) {
		this.calidadMuestreoTempLimpiezas = calidadMuestreoTempLimpiezas;
	}

	public List<EnvasadoProceso> getEnvasadoProcesos() {
		return this.envasadoProcesos;
	}

	public void setEnvasadoProcesos(List<EnvasadoProceso> envasadoProcesos) {
		this.envasadoProcesos = envasadoProcesos;
	}

	public List<LimpiezaCabeceraCortesPlanta> getLimpiezaCabeceraCortesPlantas() {
		return this.limpiezaCabeceraCortesPlantas;
	}

	public void setLimpiezaCabeceraCortesPlantas(List<LimpiezaCabeceraCortesPlanta> limpiezaCabeceraCortesPlantas) {
		this.limpiezaCabeceraCortesPlantas = limpiezaCabeceraCortesPlantas;
	}

	public List<LimpiezaCabeceraCortesPlantaLineaEmpleado> getLimpiezaCabeceraCortesPlantaLineaEmpleados() {
		return this.limpiezaCabeceraCortesPlantaLineaEmpleados;
	}

	public void setLimpiezaCabeceraCortesPlantaLineaEmpleados(List<LimpiezaCabeceraCortesPlantaLineaEmpleado> limpiezaCabeceraCortesPlantaLineaEmpleados) {
		this.limpiezaCabeceraCortesPlantaLineaEmpleados = limpiezaCabeceraCortesPlantaLineaEmpleados;
	}

	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public List<LimpiezaDetalleProcesoLote> getLimpiezaDetalleProcesoLotes() {
		return this.limpiezaDetalleProcesoLotes;
	}

	public void setLimpiezaDetalleProcesoLotes(List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes) {
		this.limpiezaDetalleProcesoLotes = limpiezaDetalleProcesoLotes;
	}

	public List<LimpiezaDetalleTipoCorte> getLimpiezaDetalleTipoCortes() {
		return this.limpiezaDetalleTipoCortes;
	}

	public void setLimpiezaDetalleTipoCortes(List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes) {
		this.limpiezaDetalleTipoCortes = limpiezaDetalleTipoCortes;
	}

	public List<LimpiezaDetalleTipoPara> getLimpiezaDetalleTipoParas() {
		return this.limpiezaDetalleTipoParas;
	}

	public void setLimpiezaDetalleTipoParas(List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas) {
		this.limpiezaDetalleTipoParas = limpiezaDetalleTipoParas;
	}

	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
	}

	public OeePeriodoBaseObjetivo getOeePeriodoBaseObjetivo() {
		return this.oeePeriodoBaseObjetivo;
	}

	public void setOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		this.oeePeriodoBaseObjetivo = oeePeriodoBaseObjetivo;
	}

	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
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

	public List<LimpiezaProcesoEmpleado> getLimpiezaProcesoEmpleados() {
		return this.limpiezaProcesoEmpleados;
	}

	public void setLimpiezaProcesoEmpleados(List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados) {
		this.limpiezaProcesoEmpleados = limpiezaProcesoEmpleados;
	}

	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public List<LimpiezaProcesoEmpleadoTotalInicial> getLimpiezaProcesoEmpleadoTotalInicials() {
		return this.limpiezaProcesoEmpleadoTotalInicials;
	}

	public void setLimpiezaProcesoEmpleadoTotalInicials(List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials) {
		this.limpiezaProcesoEmpleadoTotalInicials = limpiezaProcesoEmpleadoTotalInicials;
	}

	public List<LimpiezaProcesoJornadaLinea> getLimpiezaProcesoJornadaLineas() {
		return this.limpiezaProcesoJornadaLineas;
	}

	public void setLimpiezaProcesoJornadaLineas(List<LimpiezaProcesoJornadaLinea> limpiezaProcesoJornadaLineas) {
		this.limpiezaProcesoJornadaLineas = limpiezaProcesoJornadaLineas;
	}

	public List<LimpiezaProcesoLineaTara> getLimpiezaProcesoLineaTaras() {
		return this.limpiezaProcesoLineaTaras;
	}

	public void setLimpiezaProcesoLineaTaras(List<LimpiezaProcesoLineaTara> limpiezaProcesoLineaTaras) {
		this.limpiezaProcesoLineaTaras = limpiezaProcesoLineaTaras;
	}

	public List<LimpiezaProcesoLoteActivo> getLimpiezaProcesoLoteActivos() {
		return this.limpiezaProcesoLoteActivos;
	}

	public void setLimpiezaProcesoLoteActivos(List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos) {
		this.limpiezaProcesoLoteActivos = limpiezaProcesoLoteActivos;
	}

	public List<LimpiezaRalladoBatchCabecera> getLimpiezaRalladoBatchCabeceras() {
		return this.limpiezaRalladoBatchCabeceras;
	}

	public void setLimpiezaRalladoBatchCabeceras(List<LimpiezaRalladoBatchCabecera> limpiezaRalladoBatchCabeceras) {
		this.limpiezaRalladoBatchCabeceras = limpiezaRalladoBatchCabeceras;
	}

	public List<LimpiezaRalladoDetallePeso> getLimpiezaRalladoDetallePesos() {
		return this.limpiezaRalladoDetallePesos;
	}

	public void setLimpiezaRalladoDetallePesos(List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos) {
		this.limpiezaRalladoDetallePesos = limpiezaRalladoDetallePesos;
	}

	public List<LimpiezaRalladoDetallePesosAlmacenado> getLimpiezaRalladoDetallePesosAlmacenados() {
		return this.limpiezaRalladoDetallePesosAlmacenados;
	}

	public void setLimpiezaRalladoDetallePesosAlmacenados(List<LimpiezaRalladoDetallePesosAlmacenado> limpiezaRalladoDetallePesosAlmacenados) {
		this.limpiezaRalladoDetallePesosAlmacenados = limpiezaRalladoDetallePesosAlmacenados;
	}

	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
	}

}