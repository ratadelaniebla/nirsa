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
@NamedQuery(name="LimpiezaProceso.findAll", query="SELECT l FROM LimpiezaProceso l")
public class LimpiezaProceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaproceso;
	private Integer estado;
	private Timestamp fechareg;
	private double objetivoGeneral;
	private double oee;
	private double periodoBaseCalidadLimpieza;
	private double periodoBaseGeneral;
	private double periodoBaseTiempoLimpieza;
	private double periodoBaseVelocidadLimpieza;
	private List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas;
	private List<EnvasadoProceso> envasadoProcesos;
	private List<LimpiezaCabeceraCortesPlanta> limpiezaCabeceraCortesPlantas;
	private List<LimpiezaCabeceraCortesPlantaLineaEmpleado> limpiezaCabeceraCortesPlantaLineaEmpleados;
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;
	private List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes;
	private List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes;
	private List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas;
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;
	private ObservacionesProceso observacionesProceso;
	private OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Produccion produccion;
	private Turno turno;
	private Usuario usuario;
	private List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados;
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;
	private List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials;
	private List<LimpiezaProcesoJornadaLinea> limpiezaProcesoJornadaLineas;
	private List<LimpiezaProcesoLineaTara> limpiezaProcesoLineaTaras;
	private List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos;
	private List<LimpiezaRalladoBatchCabecera> limpiezaRalladoBatchCabeceras;
	private List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos;
	private List<LimpiezaRalladoDetallePesosAlmacenado> limpiezaRalladoDetallePesosAlmacenados;
	private List<LonjasProceso> lonjasProcesos;

	public LimpiezaProceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="objetivo_general")
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


	@Column(name="periodo_base_calidad_limpieza")
	public double getPeriodoBaseCalidadLimpieza() {
		return this.periodoBaseCalidadLimpieza;
	}

	public void setPeriodoBaseCalidadLimpieza(double periodoBaseCalidadLimpieza) {
		this.periodoBaseCalidadLimpieza = periodoBaseCalidadLimpieza;
	}


	@Column(name="periodo_base_general")
	public double getPeriodoBaseGeneral() {
		return this.periodoBaseGeneral;
	}

	public void setPeriodoBaseGeneral(double periodoBaseGeneral) {
		this.periodoBaseGeneral = periodoBaseGeneral;
	}


	@Column(name="periodo_base_tiempo_limpieza")
	public double getPeriodoBaseTiempoLimpieza() {
		return this.periodoBaseTiempoLimpieza;
	}

	public void setPeriodoBaseTiempoLimpieza(double periodoBaseTiempoLimpieza) {
		this.periodoBaseTiempoLimpieza = periodoBaseTiempoLimpieza;
	}


	@Column(name="periodo_base_velocidad_limpieza")
	public double getPeriodoBaseVelocidadLimpieza() {
		return this.periodoBaseVelocidadLimpieza;
	}

	public void setPeriodoBaseVelocidadLimpieza(double periodoBaseVelocidadLimpieza) {
		this.periodoBaseVelocidadLimpieza = periodoBaseVelocidadLimpieza;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempLimpieza
	@OneToMany(mappedBy="limpiezaProceso")
	public List<CalidadMuestreoTempLimpieza> getCalidadMuestreoTempLimpiezas() {
		return this.calidadMuestreoTempLimpiezas;
	}

	public void setCalidadMuestreoTempLimpiezas(List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas) {
		this.calidadMuestreoTempLimpiezas = calidadMuestreoTempLimpiezas;
	}

	public CalidadMuestreoTempLimpieza addCalidadMuestreoTempLimpieza(CalidadMuestreoTempLimpieza calidadMuestreoTempLimpieza) {
		getCalidadMuestreoTempLimpiezas().add(calidadMuestreoTempLimpieza);
		calidadMuestreoTempLimpieza.setLimpiezaProceso(this);

		return calidadMuestreoTempLimpieza;
	}

	public CalidadMuestreoTempLimpieza removeCalidadMuestreoTempLimpieza(CalidadMuestreoTempLimpieza calidadMuestreoTempLimpieza) {
		getCalidadMuestreoTempLimpiezas().remove(calidadMuestreoTempLimpieza);
		calidadMuestreoTempLimpieza.setLimpiezaProceso(null);

		return calidadMuestreoTempLimpieza;
	}


	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="limpiezaProceso")
	public List<EnvasadoProceso> getEnvasadoProcesos() {
		return this.envasadoProcesos;
	}

	public void setEnvasadoProcesos(List<EnvasadoProceso> envasadoProcesos) {
		this.envasadoProcesos = envasadoProcesos;
	}

	public EnvasadoProceso addEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().add(envasadoProceso);
		envasadoProceso.setLimpiezaProceso(this);

		return envasadoProceso;
	}

	public EnvasadoProceso removeEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().remove(envasadoProceso);
		envasadoProceso.setLimpiezaProceso(null);

		return envasadoProceso;
	}


	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlanta
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaCabeceraCortesPlanta> getLimpiezaCabeceraCortesPlantas() {
		return this.limpiezaCabeceraCortesPlantas;
	}

	public void setLimpiezaCabeceraCortesPlantas(List<LimpiezaCabeceraCortesPlanta> limpiezaCabeceraCortesPlantas) {
		this.limpiezaCabeceraCortesPlantas = limpiezaCabeceraCortesPlantas;
	}

	public LimpiezaCabeceraCortesPlanta addLimpiezaCabeceraCortesPlanta(LimpiezaCabeceraCortesPlanta limpiezaCabeceraCortesPlanta) {
		getLimpiezaCabeceraCortesPlantas().add(limpiezaCabeceraCortesPlanta);
		limpiezaCabeceraCortesPlanta.setLimpiezaProceso(this);

		return limpiezaCabeceraCortesPlanta;
	}

	public LimpiezaCabeceraCortesPlanta removeLimpiezaCabeceraCortesPlanta(LimpiezaCabeceraCortesPlanta limpiezaCabeceraCortesPlanta) {
		getLimpiezaCabeceraCortesPlantas().remove(limpiezaCabeceraCortesPlanta);
		limpiezaCabeceraCortesPlanta.setLimpiezaProceso(null);

		return limpiezaCabeceraCortesPlanta;
	}


	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlantaLineaEmpleado
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaCabeceraCortesPlantaLineaEmpleado> getLimpiezaCabeceraCortesPlantaLineaEmpleados() {
		return this.limpiezaCabeceraCortesPlantaLineaEmpleados;
	}

	public void setLimpiezaCabeceraCortesPlantaLineaEmpleados(List<LimpiezaCabeceraCortesPlantaLineaEmpleado> limpiezaCabeceraCortesPlantaLineaEmpleados) {
		this.limpiezaCabeceraCortesPlantaLineaEmpleados = limpiezaCabeceraCortesPlantaLineaEmpleados;
	}

	public LimpiezaCabeceraCortesPlantaLineaEmpleado addLimpiezaCabeceraCortesPlantaLineaEmpleado(LimpiezaCabeceraCortesPlantaLineaEmpleado limpiezaCabeceraCortesPlantaLineaEmpleado) {
		getLimpiezaCabeceraCortesPlantaLineaEmpleados().add(limpiezaCabeceraCortesPlantaLineaEmpleado);
		limpiezaCabeceraCortesPlantaLineaEmpleado.setLimpiezaProceso(this);

		return limpiezaCabeceraCortesPlantaLineaEmpleado;
	}

	public LimpiezaCabeceraCortesPlantaLineaEmpleado removeLimpiezaCabeceraCortesPlantaLineaEmpleado(LimpiezaCabeceraCortesPlantaLineaEmpleado limpiezaCabeceraCortesPlantaLineaEmpleado) {
		getLimpiezaCabeceraCortesPlantaLineaEmpleados().remove(limpiezaCabeceraCortesPlantaLineaEmpleado);
		limpiezaCabeceraCortesPlantaLineaEmpleado.setLimpiezaProceso(null);

		return limpiezaCabeceraCortesPlantaLineaEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public LimpiezaDespellejadoPonchada addLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().add(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setLimpiezaProceso(this);

		return limpiezaDespellejadoPonchada;
	}

	public LimpiezaDespellejadoPonchada removeLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().remove(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setLimpiezaProceso(null);

		return limpiezaDespellejadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaDetalleProcesoLote> getLimpiezaDetalleProcesoLotes() {
		return this.limpiezaDetalleProcesoLotes;
	}

	public void setLimpiezaDetalleProcesoLotes(List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes) {
		this.limpiezaDetalleProcesoLotes = limpiezaDetalleProcesoLotes;
	}

	public LimpiezaDetalleProcesoLote addLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		getLimpiezaDetalleProcesoLotes().add(limpiezaDetalleProcesoLote);
		limpiezaDetalleProcesoLote.setLimpiezaProceso(this);

		return limpiezaDetalleProcesoLote;
	}

	public LimpiezaDetalleProcesoLote removeLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		getLimpiezaDetalleProcesoLotes().remove(limpiezaDetalleProcesoLote);
		limpiezaDetalleProcesoLote.setLimpiezaProceso(null);

		return limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LimpiezaDetalleTipoCorte
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaDetalleTipoCorte> getLimpiezaDetalleTipoCortes() {
		return this.limpiezaDetalleTipoCortes;
	}

	public void setLimpiezaDetalleTipoCortes(List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes) {
		this.limpiezaDetalleTipoCortes = limpiezaDetalleTipoCortes;
	}

	public LimpiezaDetalleTipoCorte addLimpiezaDetalleTipoCorte(LimpiezaDetalleTipoCorte limpiezaDetalleTipoCorte) {
		getLimpiezaDetalleTipoCortes().add(limpiezaDetalleTipoCorte);
		limpiezaDetalleTipoCorte.setLimpiezaProceso(this);

		return limpiezaDetalleTipoCorte;
	}

	public LimpiezaDetalleTipoCorte removeLimpiezaDetalleTipoCorte(LimpiezaDetalleTipoCorte limpiezaDetalleTipoCorte) {
		getLimpiezaDetalleTipoCortes().remove(limpiezaDetalleTipoCorte);
		limpiezaDetalleTipoCorte.setLimpiezaProceso(null);

		return limpiezaDetalleTipoCorte;
	}


	//bi-directional many-to-one association to LimpiezaDetalleTipoPara
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaDetalleTipoPara> getLimpiezaDetalleTipoParas() {
		return this.limpiezaDetalleTipoParas;
	}

	public void setLimpiezaDetalleTipoParas(List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas) {
		this.limpiezaDetalleTipoParas = limpiezaDetalleTipoParas;
	}

	public LimpiezaDetalleTipoPara addLimpiezaDetalleTipoPara(LimpiezaDetalleTipoPara limpiezaDetalleTipoPara) {
		getLimpiezaDetalleTipoParas().add(limpiezaDetalleTipoPara);
		limpiezaDetalleTipoPara.setLimpiezaProceso(this);

		return limpiezaDetalleTipoPara;
	}

	public LimpiezaDetalleTipoPara removeLimpiezaDetalleTipoPara(LimpiezaDetalleTipoPara limpiezaDetalleTipoPara) {
		getLimpiezaDetalleTipoParas().remove(limpiezaDetalleTipoPara);
		limpiezaDetalleTipoPara.setLimpiezaProceso(null);

		return limpiezaDetalleTipoPara;
	}


	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public LimpiezaFileteadoPonchada addLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().add(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setLimpiezaProceso(this);

		return limpiezaFileteadoPonchada;
	}

	public LimpiezaFileteadoPonchada removeLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().remove(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setLimpiezaProceso(null);

		return limpiezaFileteadoPonchada;
	}


	//bi-directional many-to-one association to ObservacionesProceso
	@ManyToOne
	@JoinColumn(name="idobservacionesprocesos")
	public ObservacionesProceso getObservacionesProceso() {
		return this.observacionesProceso;
	}

	public void setObservacionesProceso(ObservacionesProceso observacionesProceso) {
		this.observacionesProceso = observacionesProceso;
	}


	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@ManyToOne
	@JoinColumn(name="id_oee_periodo_base_objetivo")
	public OeePeriodoBaseObjetivo getOeePeriodoBaseObjetivo() {
		return this.oeePeriodoBaseObjetivo;
	}

	public void setOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		this.oeePeriodoBaseObjetivo = oeePeriodoBaseObjetivo;
	}


	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
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


	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaProcesoEmpleado> getLimpiezaProcesoEmpleados() {
		return this.limpiezaProcesoEmpleados;
	}

	public void setLimpiezaProcesoEmpleados(List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados) {
		this.limpiezaProcesoEmpleados = limpiezaProcesoEmpleados;
	}

	public LimpiezaProcesoEmpleado addLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		getLimpiezaProcesoEmpleados().add(limpiezaProcesoEmpleado);
		limpiezaProcesoEmpleado.setLimpiezaProceso(this);

		return limpiezaProcesoEmpleado;
	}

	public LimpiezaProcesoEmpleado removeLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		getLimpiezaProcesoEmpleados().remove(limpiezaProcesoEmpleado);
		limpiezaProcesoEmpleado.setLimpiezaProceso(null);

		return limpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento addLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().add(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setLimpiezaProceso(this);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento removeLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().remove(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setLimpiezaProceso(null);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoTotalInicial
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaProcesoEmpleadoTotalInicial> getLimpiezaProcesoEmpleadoTotalInicials() {
		return this.limpiezaProcesoEmpleadoTotalInicials;
	}

	public void setLimpiezaProcesoEmpleadoTotalInicials(List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials) {
		this.limpiezaProcesoEmpleadoTotalInicials = limpiezaProcesoEmpleadoTotalInicials;
	}

	public LimpiezaProcesoEmpleadoTotalInicial addLimpiezaProcesoEmpleadoTotalInicial(LimpiezaProcesoEmpleadoTotalInicial limpiezaProcesoEmpleadoTotalInicial) {
		getLimpiezaProcesoEmpleadoTotalInicials().add(limpiezaProcesoEmpleadoTotalInicial);
		limpiezaProcesoEmpleadoTotalInicial.setLimpiezaProceso(this);

		return limpiezaProcesoEmpleadoTotalInicial;
	}

	public LimpiezaProcesoEmpleadoTotalInicial removeLimpiezaProcesoEmpleadoTotalInicial(LimpiezaProcesoEmpleadoTotalInicial limpiezaProcesoEmpleadoTotalInicial) {
		getLimpiezaProcesoEmpleadoTotalInicials().remove(limpiezaProcesoEmpleadoTotalInicial);
		limpiezaProcesoEmpleadoTotalInicial.setLimpiezaProceso(null);

		return limpiezaProcesoEmpleadoTotalInicial;
	}


	//bi-directional many-to-one association to LimpiezaProcesoJornadaLinea
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaProcesoJornadaLinea> getLimpiezaProcesoJornadaLineas() {
		return this.limpiezaProcesoJornadaLineas;
	}

	public void setLimpiezaProcesoJornadaLineas(List<LimpiezaProcesoJornadaLinea> limpiezaProcesoJornadaLineas) {
		this.limpiezaProcesoJornadaLineas = limpiezaProcesoJornadaLineas;
	}

	public LimpiezaProcesoJornadaLinea addLimpiezaProcesoJornadaLinea(LimpiezaProcesoJornadaLinea limpiezaProcesoJornadaLinea) {
		getLimpiezaProcesoJornadaLineas().add(limpiezaProcesoJornadaLinea);
		limpiezaProcesoJornadaLinea.setLimpiezaProceso(this);

		return limpiezaProcesoJornadaLinea;
	}

	public LimpiezaProcesoJornadaLinea removeLimpiezaProcesoJornadaLinea(LimpiezaProcesoJornadaLinea limpiezaProcesoJornadaLinea) {
		getLimpiezaProcesoJornadaLineas().remove(limpiezaProcesoJornadaLinea);
		limpiezaProcesoJornadaLinea.setLimpiezaProceso(null);

		return limpiezaProcesoJornadaLinea;
	}


	//bi-directional many-to-one association to LimpiezaProcesoLineaTara
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaProcesoLineaTara> getLimpiezaProcesoLineaTaras() {
		return this.limpiezaProcesoLineaTaras;
	}

	public void setLimpiezaProcesoLineaTaras(List<LimpiezaProcesoLineaTara> limpiezaProcesoLineaTaras) {
		this.limpiezaProcesoLineaTaras = limpiezaProcesoLineaTaras;
	}

	public LimpiezaProcesoLineaTara addLimpiezaProcesoLineaTara(LimpiezaProcesoLineaTara limpiezaProcesoLineaTara) {
		getLimpiezaProcesoLineaTaras().add(limpiezaProcesoLineaTara);
		limpiezaProcesoLineaTara.setLimpiezaProceso(this);

		return limpiezaProcesoLineaTara;
	}

	public LimpiezaProcesoLineaTara removeLimpiezaProcesoLineaTara(LimpiezaProcesoLineaTara limpiezaProcesoLineaTara) {
		getLimpiezaProcesoLineaTaras().remove(limpiezaProcesoLineaTara);
		limpiezaProcesoLineaTara.setLimpiezaProceso(null);

		return limpiezaProcesoLineaTara;
	}


	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaProcesoLoteActivo> getLimpiezaProcesoLoteActivos() {
		return this.limpiezaProcesoLoteActivos;
	}

	public void setLimpiezaProcesoLoteActivos(List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos) {
		this.limpiezaProcesoLoteActivos = limpiezaProcesoLoteActivos;
	}

	public LimpiezaProcesoLoteActivo addLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		getLimpiezaProcesoLoteActivos().add(limpiezaProcesoLoteActivo);
		limpiezaProcesoLoteActivo.setLimpiezaProceso(this);

		return limpiezaProcesoLoteActivo;
	}

	public LimpiezaProcesoLoteActivo removeLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		getLimpiezaProcesoLoteActivos().remove(limpiezaProcesoLoteActivo);
		limpiezaProcesoLoteActivo.setLimpiezaProceso(null);

		return limpiezaProcesoLoteActivo;
	}


	//bi-directional many-to-one association to LimpiezaRalladoBatchCabecera
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaRalladoBatchCabecera> getLimpiezaRalladoBatchCabeceras() {
		return this.limpiezaRalladoBatchCabeceras;
	}

	public void setLimpiezaRalladoBatchCabeceras(List<LimpiezaRalladoBatchCabecera> limpiezaRalladoBatchCabeceras) {
		this.limpiezaRalladoBatchCabeceras = limpiezaRalladoBatchCabeceras;
	}

	public LimpiezaRalladoBatchCabecera addLimpiezaRalladoBatchCabecera(LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera) {
		getLimpiezaRalladoBatchCabeceras().add(limpiezaRalladoBatchCabecera);
		limpiezaRalladoBatchCabecera.setLimpiezaProceso(this);

		return limpiezaRalladoBatchCabecera;
	}

	public LimpiezaRalladoBatchCabecera removeLimpiezaRalladoBatchCabecera(LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera) {
		getLimpiezaRalladoBatchCabeceras().remove(limpiezaRalladoBatchCabecera);
		limpiezaRalladoBatchCabecera.setLimpiezaProceso(null);

		return limpiezaRalladoBatchCabecera;
	}


	//bi-directional many-to-one association to LimpiezaRalladoDetallePeso
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaRalladoDetallePeso> getLimpiezaRalladoDetallePesos() {
		return this.limpiezaRalladoDetallePesos;
	}

	public void setLimpiezaRalladoDetallePesos(List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos) {
		this.limpiezaRalladoDetallePesos = limpiezaRalladoDetallePesos;
	}

	public LimpiezaRalladoDetallePeso addLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		getLimpiezaRalladoDetallePesos().add(limpiezaRalladoDetallePeso);
		limpiezaRalladoDetallePeso.setLimpiezaProceso(this);

		return limpiezaRalladoDetallePeso;
	}

	public LimpiezaRalladoDetallePeso removeLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		getLimpiezaRalladoDetallePesos().remove(limpiezaRalladoDetallePeso);
		limpiezaRalladoDetallePeso.setLimpiezaProceso(null);

		return limpiezaRalladoDetallePeso;
	}


	//bi-directional many-to-one association to LimpiezaRalladoDetallePesosAlmacenado
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LimpiezaRalladoDetallePesosAlmacenado> getLimpiezaRalladoDetallePesosAlmacenados() {
		return this.limpiezaRalladoDetallePesosAlmacenados;
	}

	public void setLimpiezaRalladoDetallePesosAlmacenados(List<LimpiezaRalladoDetallePesosAlmacenado> limpiezaRalladoDetallePesosAlmacenados) {
		this.limpiezaRalladoDetallePesosAlmacenados = limpiezaRalladoDetallePesosAlmacenados;
	}

	public LimpiezaRalladoDetallePesosAlmacenado addLimpiezaRalladoDetallePesosAlmacenado(LimpiezaRalladoDetallePesosAlmacenado limpiezaRalladoDetallePesosAlmacenado) {
		getLimpiezaRalladoDetallePesosAlmacenados().add(limpiezaRalladoDetallePesosAlmacenado);
		limpiezaRalladoDetallePesosAlmacenado.setLimpiezaProceso(this);

		return limpiezaRalladoDetallePesosAlmacenado;
	}

	public LimpiezaRalladoDetallePesosAlmacenado removeLimpiezaRalladoDetallePesosAlmacenado(LimpiezaRalladoDetallePesosAlmacenado limpiezaRalladoDetallePesosAlmacenado) {
		getLimpiezaRalladoDetallePesosAlmacenados().remove(limpiezaRalladoDetallePesosAlmacenado);
		limpiezaRalladoDetallePesosAlmacenado.setLimpiezaProceso(null);

		return limpiezaRalladoDetallePesosAlmacenado;
	}


	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="limpiezaProceso")
	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
	}

	public LonjasProceso addLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().add(lonjasProceso);
		lonjasProceso.setLimpiezaProceso(this);

		return lonjasProceso;
	}

	public LonjasProceso removeLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().remove(lonjasProceso);
		lonjasProceso.setLimpiezaProceso(null);

		return lonjasProceso;
	}

}