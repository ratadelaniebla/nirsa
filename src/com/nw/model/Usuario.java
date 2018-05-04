package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idusuario;
	private String clave;
	private String usuario;
	private List<BarcoDescarga> barcoDescargas;
	private List<CalidadDescongeladoDetalleTempAgua> calidadDescongeladoDetalleTempAguas;
	private List<CalidadDescongeladoDetalleTempPescado> calidadDescongeladoDetalleTempPescados;
	private List<CalidadDescongeladoTempAgua> calidadDescongeladoTempAguas;
	private List<CalidadDescongeladoTempPescado> calidadDescongeladoTempPescados;
	private List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas;
	private List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas;
	private List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions;
	private List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados;
	private List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas;
	private List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados;
	private List<CalidadDetallePcc> calidadDetallePccs;
	private List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons;
	private List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps;
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;
	private List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas;
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;
	private List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions;
	private List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles;
	private List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras;
	private List<CalidadMuestraCabeceraDescargaMotivo> calidadMuestraCabeceraDescargaMotivos;
	private List<CalidadMuestreoCocina> calidadMuestreoCocinas;
	private List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions;
	private List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados;
	private List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas;
	private List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados;
	private List<CalidadPccRemuestreoCajon> calidadPccRemuestreoCajons;
	private List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions;
	private List<CalidadRespuestaPreguntaBpmdesembarco> calidadRespuestaPreguntaBpmdesembarcos;
	private List<CalidadTemperaturaCajonBanda> calidadTemperaturaCajonBandas;
	private List<CamaraCajon> camaraCajons;
	private List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches;
	private List<CoccionDetalleMuestreoTempCocheAdic> coccionDetalleMuestreoTempCocheAdics;
	private List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos;
	private List<CoccionDetalleProcesoCocheTemperatura> coccionDetalleProcesoCocheTemperaturas;
	private List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches;
	private List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos;
	private List<CoccionProceso> coccionProcesos;
	private List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles;
	private List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles;
	private List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches;
	private List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas;
	private List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches;
	private List<ControlBatchProceso> controlBatchProcesos;
	private List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados;
	private List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas;
	private List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas;
	private List<ControlDetalleBatchRallado> controlDetalleBatchRallados1;
	private List<ControlDetalleBatchRallado> controlDetalleBatchRallados2;
	private List<ControlDetalleBatchRallado> controlDetalleBatchRallados3;
	private List<ControlFichaBatch> controlFichaBatches;
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;
	private List<DescongeladoDetalleDuchaAperturaTalla> descongeladoDetalleDuchaAperturaTallas;
	private List<DescongeladoDetalleDuchaTallaMonitoreo> descongeladoDetalleDuchaTallaMonitoreos;
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;
	private List<DescongeladoDetalleProcesoContraloria> descongeladoDetalleProcesoContralorias;
	private List<DescongeladoDetalleProcesoFinForzado> descongeladoDetalleProcesoFinForzados;
	private List<DescongeladoDetalleProcesoTempIng> descongeladoDetalleProcesoTempIngs;
	private List<DescongeladoDetalleProcesoTemperatura> descongeladoDetalleProcesoTemperaturas;
	private List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles;
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas1;
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas2;
	private List<DesperdicioDetalle> desperdicioDetalles;
	private List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles;
	private List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras;
	private List<EnvasadoControlPesoFillDetalle> envasadoControlPesoFillDetalles;
	private List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabeceras;
	private List<EnvasadoControlPesoNetoDetalle> envasadoControlPesoNetoDetalles;
	private List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios;
	private List<EnvasadoProceso> envasadoProcesos;
	private List<EspecialidadesProceso> especialidadesProcesos;
	private List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados;
	private List<EstandarEficienciaKilosPagoPlexus> estandarEficienciaKilosPagoPlexuses1;
	private List<EstandarEficienciaKilosPagoPlexus> estandarEficienciaKilosPagoPlexuses2;
	private List<EstandarEficienciaKilosPlexus> estandarEficienciaKilosPlexuses1;
	private List<EstandarEficienciaKilosPlexus> estandarEficienciaKilosPlexuses2;
	private List<EvisceradoAuditoriaReimpresion> evisceradoAuditoriaReimpresions;
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions1;
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions2;
	private List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches;
	private List<EvisceradoDetalleProceso> evisceradoDetalleProcesos;
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;
	private List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions;
	private List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches;
	private List<EvisceradoRackeoLote> evisceradoRackeoLotes;
	private List<EvisceradoReanudacionSecCoche> evisceradoReanudacionSecCoches;
	private List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos;
	private List<EvolutionAuditoriaDetalle> evolutionAuditoriaDetalles;
	private List<GestionTurno> gestionTurnos;
	private List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes;
	private List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes;
	private List<ImpresionDetalle> impresionDetalles;
	private List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas;
	private List<LimpiezaCabeceraCortesPlanta> limpiezaCabeceraCortesPlantas;
	private List<LimpiezaCabeceraCortesPlantaLineaEmpleado> limpiezaCabeceraCortesPlantaLineaEmpleados;
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions1;
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions2;
	private List<LimpiezaCocheObservacione> limpiezaCocheObservaciones1;
	private List<LimpiezaCocheObservacione> limpiezaCocheObservaciones2;
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;
	private List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados;
	private List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios;
	private List<LimpiezaDetallePesoDespellejado> limpiezaDetallePesoDespellejados;
	private List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs;
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;
	private List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches;
	private List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches;
	private List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes;
	private List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes;
	private List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas;
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;
	private List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches;
	private List<LimpiezaProceso> limpiezaProcesos;
	private List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados;
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;
	private List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas;
	private List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones;
	private List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials;
	private List<LimpiezaProcesoLineaTara> limpiezaProcesoLineaTaras;
	private List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos;
	private List<LimpiezaRalladoBatchCabecera> limpiezaRalladoBatchCabeceras;
	private List<LimpiezaRalladoBatchDetalle> limpiezaRalladoBatchDetalles;
	private List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches;
	private List<LimpiezaRalladoMezclaBatchCabecera> limpiezaRalladoMezclaBatchCabeceras;
	private List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles;
	private List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches;
	private List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados;
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;
	private List<LonjasOrdenProduccion> lonjasOrdenProduccions;
	private List<LonjasProceso> lonjasProcesos;
	private List<LonjasProcesoEmpleado> lonjasProcesoEmpleados;
	private List<ObservacionesDetalleProceso> observacionesDetalleProcesos;
	private List<ObservacionesProceso> observacionesProcesos;
	private List<ObservacionesPuntoControl> observacionesPuntoControls1;
	private List<ObservacionesPuntoControl> observacionesPuntoControls2;
	private List<ObservacionesPuntoControl> observacionesPuntoControls3;
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;
	private List<OeeDetalleParada> oeeDetalleParadas;
	private List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	private List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	private List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos;
	private List<PanzasDetalleProcesoCoche> panzasDetalleProcesoCoches;
	private List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos;
	private List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes;
	private List<PanzasProceso> panzasProcesos;
	private List<ParametroAuditoria> parametroAuditorias;
	private List<PedidoProduccionArchivoCargaCabecera> pedidoProduccionArchivoCargaCabeceras;
	private List<PedidoProduccionCabecera> pedidoProduccionCabeceras;
	private List<PlanificacionCargaArchivo> planificacionCargaArchivos;
	private List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos;
	private List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes;
	private List<PouchProceso> pouchProcesos;
	private List<ProduccionArchivoCargaLote> produccionArchivoCargaLotes;
	private List<ProduccionArchivoCargaOrden> produccionArchivoCargaOrdens;
	private List<ProduccionCargaArchivoPedido> produccionCargaArchivoPedidos;
	private List<ProduccionDetalleOrden> produccionDetalleOrdens;
	private List<RackeoProceso> rackeoProcesos;
	private List<RackeoProcesoEmpleado> rackeoProcesoEmpleados;
	private List<ReportesNivelesUsuario> reportesNivelesUsuarios;
	private List<ReportesPuntoControl> reportesPuntoControls1;
	private List<ReportesPuntoControl> reportesPuntoControls2;
	private List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches;
	private List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches;
	private List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas;
	private List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches;
	private List<RociadoProceso> rociadoProcesos;
	private List<SeguridadAuditoriaConsultaDocumento> seguridadAuditoriaConsultaDocumentos;
	private List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches;
	private List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas;
	private List<TurnoGestionDetalle> turnoGestionDetalles;
	private Area area;
	private Departamento departamento;
	private Grupo grupo;
	private List<UsuariosAprobacion> usuariosAprobacions;

	public Usuario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}


	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to BarcoDescarga
	@OneToMany(mappedBy="usuario")
	public List<BarcoDescarga> getBarcoDescargas() {
		return this.barcoDescargas;
	}

	public void setBarcoDescargas(List<BarcoDescarga> barcoDescargas) {
		this.barcoDescargas = barcoDescargas;
	}

	public BarcoDescarga addBarcoDescarga(BarcoDescarga barcoDescarga) {
		getBarcoDescargas().add(barcoDescarga);
		barcoDescarga.setUsuario(this);

		return barcoDescarga;
	}

	public BarcoDescarga removeBarcoDescarga(BarcoDescarga barcoDescarga) {
		getBarcoDescargas().remove(barcoDescarga);
		barcoDescarga.setUsuario(null);

		return barcoDescarga;
	}


	//bi-directional many-to-one association to CalidadDescongeladoDetalleTempAgua
	@OneToMany(mappedBy="usuario")
	public List<CalidadDescongeladoDetalleTempAgua> getCalidadDescongeladoDetalleTempAguas() {
		return this.calidadDescongeladoDetalleTempAguas;
	}

	public void setCalidadDescongeladoDetalleTempAguas(List<CalidadDescongeladoDetalleTempAgua> calidadDescongeladoDetalleTempAguas) {
		this.calidadDescongeladoDetalleTempAguas = calidadDescongeladoDetalleTempAguas;
	}

	public CalidadDescongeladoDetalleTempAgua addCalidadDescongeladoDetalleTempAgua(CalidadDescongeladoDetalleTempAgua calidadDescongeladoDetalleTempAgua) {
		getCalidadDescongeladoDetalleTempAguas().add(calidadDescongeladoDetalleTempAgua);
		calidadDescongeladoDetalleTempAgua.setUsuario(this);

		return calidadDescongeladoDetalleTempAgua;
	}

	public CalidadDescongeladoDetalleTempAgua removeCalidadDescongeladoDetalleTempAgua(CalidadDescongeladoDetalleTempAgua calidadDescongeladoDetalleTempAgua) {
		getCalidadDescongeladoDetalleTempAguas().remove(calidadDescongeladoDetalleTempAgua);
		calidadDescongeladoDetalleTempAgua.setUsuario(null);

		return calidadDescongeladoDetalleTempAgua;
	}


	//bi-directional many-to-one association to CalidadDescongeladoDetalleTempPescado
	@OneToMany(mappedBy="usuario")
	public List<CalidadDescongeladoDetalleTempPescado> getCalidadDescongeladoDetalleTempPescados() {
		return this.calidadDescongeladoDetalleTempPescados;
	}

	public void setCalidadDescongeladoDetalleTempPescados(List<CalidadDescongeladoDetalleTempPescado> calidadDescongeladoDetalleTempPescados) {
		this.calidadDescongeladoDetalleTempPescados = calidadDescongeladoDetalleTempPescados;
	}

	public CalidadDescongeladoDetalleTempPescado addCalidadDescongeladoDetalleTempPescado(CalidadDescongeladoDetalleTempPescado calidadDescongeladoDetalleTempPescado) {
		getCalidadDescongeladoDetalleTempPescados().add(calidadDescongeladoDetalleTempPescado);
		calidadDescongeladoDetalleTempPescado.setUsuario(this);

		return calidadDescongeladoDetalleTempPescado;
	}

	public CalidadDescongeladoDetalleTempPescado removeCalidadDescongeladoDetalleTempPescado(CalidadDescongeladoDetalleTempPescado calidadDescongeladoDetalleTempPescado) {
		getCalidadDescongeladoDetalleTempPescados().remove(calidadDescongeladoDetalleTempPescado);
		calidadDescongeladoDetalleTempPescado.setUsuario(null);

		return calidadDescongeladoDetalleTempPescado;
	}


	//bi-directional many-to-one association to CalidadDescongeladoTempAgua
	@OneToMany(mappedBy="usuario")
	public List<CalidadDescongeladoTempAgua> getCalidadDescongeladoTempAguas() {
		return this.calidadDescongeladoTempAguas;
	}

	public void setCalidadDescongeladoTempAguas(List<CalidadDescongeladoTempAgua> calidadDescongeladoTempAguas) {
		this.calidadDescongeladoTempAguas = calidadDescongeladoTempAguas;
	}

	public CalidadDescongeladoTempAgua addCalidadDescongeladoTempAgua(CalidadDescongeladoTempAgua calidadDescongeladoTempAgua) {
		getCalidadDescongeladoTempAguas().add(calidadDescongeladoTempAgua);
		calidadDescongeladoTempAgua.setUsuario(this);

		return calidadDescongeladoTempAgua;
	}

	public CalidadDescongeladoTempAgua removeCalidadDescongeladoTempAgua(CalidadDescongeladoTempAgua calidadDescongeladoTempAgua) {
		getCalidadDescongeladoTempAguas().remove(calidadDescongeladoTempAgua);
		calidadDescongeladoTempAgua.setUsuario(null);

		return calidadDescongeladoTempAgua;
	}


	//bi-directional many-to-one association to CalidadDescongeladoTempPescado
	@OneToMany(mappedBy="usuario")
	public List<CalidadDescongeladoTempPescado> getCalidadDescongeladoTempPescados() {
		return this.calidadDescongeladoTempPescados;
	}

	public void setCalidadDescongeladoTempPescados(List<CalidadDescongeladoTempPescado> calidadDescongeladoTempPescados) {
		this.calidadDescongeladoTempPescados = calidadDescongeladoTempPescados;
	}

	public CalidadDescongeladoTempPescado addCalidadDescongeladoTempPescado(CalidadDescongeladoTempPescado calidadDescongeladoTempPescado) {
		getCalidadDescongeladoTempPescados().add(calidadDescongeladoTempPescado);
		calidadDescongeladoTempPescado.setUsuario(this);

		return calidadDescongeladoTempPescado;
	}

	public CalidadDescongeladoTempPescado removeCalidadDescongeladoTempPescado(CalidadDescongeladoTempPescado calidadDescongeladoTempPescado) {
		getCalidadDescongeladoTempPescados().remove(calidadDescongeladoTempPescado);
		calidadDescongeladoTempPescado.setUsuario(null);

		return calidadDescongeladoTempPescado;
	}


	//bi-directional many-to-one association to CalidadDetalleEspecietallaCajonBanda
	@OneToMany(mappedBy="usuario")
	public List<CalidadDetalleEspecietallaCajonBanda> getCalidadDetalleEspecietallaCajonBandas() {
		return this.calidadDetalleEspecietallaCajonBandas;
	}

	public void setCalidadDetalleEspecietallaCajonBandas(List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas) {
		this.calidadDetalleEspecietallaCajonBandas = calidadDetalleEspecietallaCajonBandas;
	}

	public CalidadDetalleEspecietallaCajonBanda addCalidadDetalleEspecietallaCajonBanda(CalidadDetalleEspecietallaCajonBanda calidadDetalleEspecietallaCajonBanda) {
		getCalidadDetalleEspecietallaCajonBandas().add(calidadDetalleEspecietallaCajonBanda);
		calidadDetalleEspecietallaCajonBanda.setUsuario(this);

		return calidadDetalleEspecietallaCajonBanda;
	}

	public CalidadDetalleEspecietallaCajonBanda removeCalidadDetalleEspecietallaCajonBanda(CalidadDetalleEspecietallaCajonBanda calidadDetalleEspecietallaCajonBanda) {
		getCalidadDetalleEspecietallaCajonBandas().remove(calidadDetalleEspecietallaCajonBanda);
		calidadDetalleEspecietallaCajonBanda.setUsuario(null);

		return calidadDetalleEspecietallaCajonBanda;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoCocina
	@OneToMany(mappedBy="usuario")
	public List<CalidadDetalleMuestreoCocina> getCalidadDetalleMuestreoCocinas() {
		return this.calidadDetalleMuestreoCocinas;
	}

	public void setCalidadDetalleMuestreoCocinas(List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas) {
		this.calidadDetalleMuestreoCocinas = calidadDetalleMuestreoCocinas;
	}

	public CalidadDetalleMuestreoCocina addCalidadDetalleMuestreoCocina(CalidadDetalleMuestreoCocina calidadDetalleMuestreoCocina) {
		getCalidadDetalleMuestreoCocinas().add(calidadDetalleMuestreoCocina);
		calidadDetalleMuestreoCocina.setUsuario(this);

		return calidadDetalleMuestreoCocina;
	}

	public CalidadDetalleMuestreoCocina removeCalidadDetalleMuestreoCocina(CalidadDetalleMuestreoCocina calidadDetalleMuestreoCocina) {
		getCalidadDetalleMuestreoCocinas().remove(calidadDetalleMuestreoCocina);
		calidadDetalleMuestreoCocina.setUsuario(null);

		return calidadDetalleMuestreoCocina;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCoccion
	@OneToMany(mappedBy="usuario")
	public List<CalidadDetalleMuestreoTempCoccion> getCalidadDetalleMuestreoTempCoccions() {
		return this.calidadDetalleMuestreoTempCoccions;
	}

	public void setCalidadDetalleMuestreoTempCoccions(List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions) {
		this.calidadDetalleMuestreoTempCoccions = calidadDetalleMuestreoTempCoccions;
	}

	public CalidadDetalleMuestreoTempCoccion addCalidadDetalleMuestreoTempCoccion(CalidadDetalleMuestreoTempCoccion calidadDetalleMuestreoTempCoccion) {
		getCalidadDetalleMuestreoTempCoccions().add(calidadDetalleMuestreoTempCoccion);
		calidadDetalleMuestreoTempCoccion.setUsuario(this);

		return calidadDetalleMuestreoTempCoccion;
	}

	public CalidadDetalleMuestreoTempCoccion removeCalidadDetalleMuestreoTempCoccion(CalidadDetalleMuestreoTempCoccion calidadDetalleMuestreoTempCoccion) {
		getCalidadDetalleMuestreoTempCoccions().remove(calidadDetalleMuestreoTempCoccion);
		calidadDetalleMuestreoTempCoccion.setUsuario(null);

		return calidadDetalleMuestreoTempCoccion;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="usuario")
	public List<CalidadDetalleMuestreoTempCochesEviscerado> getCalidadDetalleMuestreoTempCochesEviscerados() {
		return this.calidadDetalleMuestreoTempCochesEviscerados;
	}

	public void setCalidadDetalleMuestreoTempCochesEviscerados(List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados) {
		this.calidadDetalleMuestreoTempCochesEviscerados = calidadDetalleMuestreoTempCochesEviscerados;
	}

	public CalidadDetalleMuestreoTempCochesEviscerado addCalidadDetalleMuestreoTempCochesEviscerado(CalidadDetalleMuestreoTempCochesEviscerado calidadDetalleMuestreoTempCochesEviscerado) {
		getCalidadDetalleMuestreoTempCochesEviscerados().add(calidadDetalleMuestreoTempCochesEviscerado);
		calidadDetalleMuestreoTempCochesEviscerado.setUsuario(this);

		return calidadDetalleMuestreoTempCochesEviscerado;
	}

	public CalidadDetalleMuestreoTempCochesEviscerado removeCalidadDetalleMuestreoTempCochesEviscerado(CalidadDetalleMuestreoTempCochesEviscerado calidadDetalleMuestreoTempCochesEviscerado) {
		getCalidadDetalleMuestreoTempCochesEviscerados().remove(calidadDetalleMuestreoTempCochesEviscerado);
		calidadDetalleMuestreoTempCochesEviscerado.setUsuario(null);

		return calidadDetalleMuestreoTempCochesEviscerado;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempLimpieza
	@OneToMany(mappedBy="usuario")
	public List<CalidadDetalleMuestreoTempLimpieza> getCalidadDetalleMuestreoTempLimpiezas() {
		return this.calidadDetalleMuestreoTempLimpiezas;
	}

	public void setCalidadDetalleMuestreoTempLimpiezas(List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas) {
		this.calidadDetalleMuestreoTempLimpiezas = calidadDetalleMuestreoTempLimpiezas;
	}

	public CalidadDetalleMuestreoTempLimpieza addCalidadDetalleMuestreoTempLimpieza(CalidadDetalleMuestreoTempLimpieza calidadDetalleMuestreoTempLimpieza) {
		getCalidadDetalleMuestreoTempLimpiezas().add(calidadDetalleMuestreoTempLimpieza);
		calidadDetalleMuestreoTempLimpieza.setUsuario(this);

		return calidadDetalleMuestreoTempLimpieza;
	}

	public CalidadDetalleMuestreoTempLimpieza removeCalidadDetalleMuestreoTempLimpieza(CalidadDetalleMuestreoTempLimpieza calidadDetalleMuestreoTempLimpieza) {
		getCalidadDetalleMuestreoTempLimpiezas().remove(calidadDetalleMuestreoTempLimpieza);
		calidadDetalleMuestreoTempLimpieza.setUsuario(null);

		return calidadDetalleMuestreoTempLimpieza;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempPanzaEviscerado
	@OneToMany(mappedBy="usuario")
	public List<CalidadDetalleMuestreoTempPanzaEviscerado> getCalidadDetalleMuestreoTempPanzaEviscerados() {
		return this.calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public void setCalidadDetalleMuestreoTempPanzaEviscerados(List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados) {
		this.calidadDetalleMuestreoTempPanzaEviscerados = calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public CalidadDetalleMuestreoTempPanzaEviscerado addCalidadDetalleMuestreoTempPanzaEviscerado(CalidadDetalleMuestreoTempPanzaEviscerado calidadDetalleMuestreoTempPanzaEviscerado) {
		getCalidadDetalleMuestreoTempPanzaEviscerados().add(calidadDetalleMuestreoTempPanzaEviscerado);
		calidadDetalleMuestreoTempPanzaEviscerado.setUsuario(this);

		return calidadDetalleMuestreoTempPanzaEviscerado;
	}

	public CalidadDetalleMuestreoTempPanzaEviscerado removeCalidadDetalleMuestreoTempPanzaEviscerado(CalidadDetalleMuestreoTempPanzaEviscerado calidadDetalleMuestreoTempPanzaEviscerado) {
		getCalidadDetalleMuestreoTempPanzaEviscerados().remove(calidadDetalleMuestreoTempPanzaEviscerado);
		calidadDetalleMuestreoTempPanzaEviscerado.setUsuario(null);

		return calidadDetalleMuestreoTempPanzaEviscerado;
	}


	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="usuario")
	public List<CalidadDetallePcc> getCalidadDetallePccs() {
		return this.calidadDetallePccs;
	}

	public void setCalidadDetallePccs(List<CalidadDetallePcc> calidadDetallePccs) {
		this.calidadDetallePccs = calidadDetallePccs;
	}

	public CalidadDetallePcc addCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().add(calidadDetallePcc);
		calidadDetallePcc.setUsuario(this);

		return calidadDetallePcc;
	}

	public CalidadDetallePcc removeCalidadDetallePcc(CalidadDetallePcc calidadDetallePcc) {
		getCalidadDetallePccs().remove(calidadDetallePcc);
		calidadDetallePcc.setUsuario(null);

		return calidadDetallePcc;
	}


	//bi-directional many-to-one association to CalidadDetallePccRemuestreoCajon
	@OneToMany(mappedBy="usuario")
	public List<CalidadDetallePccRemuestreoCajon> getCalidadDetallePccRemuestreoCajons() {
		return this.calidadDetallePccRemuestreoCajons;
	}

	public void setCalidadDetallePccRemuestreoCajons(List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons) {
		this.calidadDetallePccRemuestreoCajons = calidadDetallePccRemuestreoCajons;
	}

	public CalidadDetallePccRemuestreoCajon addCalidadDetallePccRemuestreoCajon(CalidadDetallePccRemuestreoCajon calidadDetallePccRemuestreoCajon) {
		getCalidadDetallePccRemuestreoCajons().add(calidadDetallePccRemuestreoCajon);
		calidadDetallePccRemuestreoCajon.setUsuario(this);

		return calidadDetallePccRemuestreoCajon;
	}

	public CalidadDetallePccRemuestreoCajon removeCalidadDetallePccRemuestreoCajon(CalidadDetallePccRemuestreoCajon calidadDetallePccRemuestreoCajon) {
		getCalidadDetallePccRemuestreoCajons().remove(calidadDetallePccRemuestreoCajon);
		calidadDetallePccRemuestreoCajon.setUsuario(null);

		return calidadDetallePccRemuestreoCajon;
	}


	//bi-directional many-to-one association to CalidadDetalleSensorialMp
	@OneToMany(mappedBy="usuario")
	public List<CalidadDetalleSensorialMp> getCalidadDetalleSensorialMps() {
		return this.calidadDetalleSensorialMps;
	}

	public void setCalidadDetalleSensorialMps(List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps) {
		this.calidadDetalleSensorialMps = calidadDetalleSensorialMps;
	}

	public CalidadDetalleSensorialMp addCalidadDetalleSensorialMp(CalidadDetalleSensorialMp calidadDetalleSensorialMp) {
		getCalidadDetalleSensorialMps().add(calidadDetalleSensorialMp);
		calidadDetalleSensorialMp.setUsuario(this);

		return calidadDetalleSensorialMp;
	}

	public CalidadDetalleSensorialMp removeCalidadDetalleSensorialMp(CalidadDetalleSensorialMp calidadDetalleSensorialMp) {
		getCalidadDetalleSensorialMps().remove(calidadDetalleSensorialMp);
		calidadDetalleSensorialMp.setUsuario(null);

		return calidadDetalleSensorialMp;
	}


	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="usuario")
	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public CalidadDetalleTemperaturaCajonBanda addCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().add(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setUsuario(this);

		return calidadDetalleTemperaturaCajonBanda;
	}

	public CalidadDetalleTemperaturaCajonBanda removeCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().remove(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setUsuario(null);

		return calidadDetalleTemperaturaCajonBanda;
	}


	//bi-directional many-to-one association to CalidadEspecietallaCajonBanda
	@OneToMany(mappedBy="usuario")
	public List<CalidadEspecietallaCajonBanda> getCalidadEspecietallaCajonBandas() {
		return this.calidadEspecietallaCajonBandas;
	}

	public void setCalidadEspecietallaCajonBandas(List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas) {
		this.calidadEspecietallaCajonBandas = calidadEspecietallaCajonBandas;
	}

	public CalidadEspecietallaCajonBanda addCalidadEspecietallaCajonBanda(CalidadEspecietallaCajonBanda calidadEspecietallaCajonBanda) {
		getCalidadEspecietallaCajonBandas().add(calidadEspecietallaCajonBanda);
		calidadEspecietallaCajonBanda.setUsuario(this);

		return calidadEspecietallaCajonBanda;
	}

	public CalidadEspecietallaCajonBanda removeCalidadEspecietallaCajonBanda(CalidadEspecietallaCajonBanda calidadEspecietallaCajonBanda) {
		getCalidadEspecietallaCajonBandas().remove(calidadEspecietallaCajonBanda);
		calidadEspecietallaCajonBanda.setUsuario(null);

		return calidadEspecietallaCajonBanda;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="usuario")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public CalidadMuestraAreaCabecera addCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().add(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setUsuario(this);

		return calidadMuestraAreaCabecera;
	}

	public CalidadMuestraAreaCabecera removeCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().remove(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setUsuario(null);

		return calidadMuestraAreaCabecera;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaCabeceraAprobacion
	@OneToMany(mappedBy="usuario")
	public List<CalidadMuestraAreaCabeceraAprobacion> getCalidadMuestraAreaCabeceraAprobacions() {
		return this.calidadMuestraAreaCabeceraAprobacions;
	}

	public void setCalidadMuestraAreaCabeceraAprobacions(List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions) {
		this.calidadMuestraAreaCabeceraAprobacions = calidadMuestraAreaCabeceraAprobacions;
	}

	public CalidadMuestraAreaCabeceraAprobacion addCalidadMuestraAreaCabeceraAprobacion(CalidadMuestraAreaCabeceraAprobacion calidadMuestraAreaCabeceraAprobacion) {
		getCalidadMuestraAreaCabeceraAprobacions().add(calidadMuestraAreaCabeceraAprobacion);
		calidadMuestraAreaCabeceraAprobacion.setUsuario(this);

		return calidadMuestraAreaCabeceraAprobacion;
	}

	public CalidadMuestraAreaCabeceraAprobacion removeCalidadMuestraAreaCabeceraAprobacion(CalidadMuestraAreaCabeceraAprobacion calidadMuestraAreaCabeceraAprobacion) {
		getCalidadMuestraAreaCabeceraAprobacions().remove(calidadMuestraAreaCabeceraAprobacion);
		calidadMuestraAreaCabeceraAprobacion.setUsuario(null);

		return calidadMuestraAreaCabeceraAprobacion;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaDetalle
	@OneToMany(mappedBy="usuario")
	public List<CalidadMuestraAreaDetalle> getCalidadMuestraAreaDetalles() {
		return this.calidadMuestraAreaDetalles;
	}

	public void setCalidadMuestraAreaDetalles(List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles) {
		this.calidadMuestraAreaDetalles = calidadMuestraAreaDetalles;
	}

	public CalidadMuestraAreaDetalle addCalidadMuestraAreaDetalle(CalidadMuestraAreaDetalle calidadMuestraAreaDetalle) {
		getCalidadMuestraAreaDetalles().add(calidadMuestraAreaDetalle);
		calidadMuestraAreaDetalle.setUsuario(this);

		return calidadMuestraAreaDetalle;
	}

	public CalidadMuestraAreaDetalle removeCalidadMuestraAreaDetalle(CalidadMuestraAreaDetalle calidadMuestraAreaDetalle) {
		getCalidadMuestraAreaDetalles().remove(calidadMuestraAreaDetalle);
		calidadMuestraAreaDetalle.setUsuario(null);

		return calidadMuestraAreaDetalle;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaDetalleMuestra
	@OneToMany(mappedBy="usuario")
	public List<CalidadMuestraAreaDetalleMuestra> getCalidadMuestraAreaDetalleMuestras() {
		return this.calidadMuestraAreaDetalleMuestras;
	}

	public void setCalidadMuestraAreaDetalleMuestras(List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras) {
		this.calidadMuestraAreaDetalleMuestras = calidadMuestraAreaDetalleMuestras;
	}

	public CalidadMuestraAreaDetalleMuestra addCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra calidadMuestraAreaDetalleMuestra) {
		getCalidadMuestraAreaDetalleMuestras().add(calidadMuestraAreaDetalleMuestra);
		calidadMuestraAreaDetalleMuestra.setUsuario(this);

		return calidadMuestraAreaDetalleMuestra;
	}

	public CalidadMuestraAreaDetalleMuestra removeCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra calidadMuestraAreaDetalleMuestra) {
		getCalidadMuestraAreaDetalleMuestras().remove(calidadMuestraAreaDetalleMuestra);
		calidadMuestraAreaDetalleMuestra.setUsuario(null);

		return calidadMuestraAreaDetalleMuestra;
	}


	//bi-directional many-to-one association to CalidadMuestraCabeceraDescargaMotivo
	@OneToMany(mappedBy="usuario")
	public List<CalidadMuestraCabeceraDescargaMotivo> getCalidadMuestraCabeceraDescargaMotivos() {
		return this.calidadMuestraCabeceraDescargaMotivos;
	}

	public void setCalidadMuestraCabeceraDescargaMotivos(List<CalidadMuestraCabeceraDescargaMotivo> calidadMuestraCabeceraDescargaMotivos) {
		this.calidadMuestraCabeceraDescargaMotivos = calidadMuestraCabeceraDescargaMotivos;
	}

	public CalidadMuestraCabeceraDescargaMotivo addCalidadMuestraCabeceraDescargaMotivo(CalidadMuestraCabeceraDescargaMotivo calidadMuestraCabeceraDescargaMotivo) {
		getCalidadMuestraCabeceraDescargaMotivos().add(calidadMuestraCabeceraDescargaMotivo);
		calidadMuestraCabeceraDescargaMotivo.setUsuario(this);

		return calidadMuestraCabeceraDescargaMotivo;
	}

	public CalidadMuestraCabeceraDescargaMotivo removeCalidadMuestraCabeceraDescargaMotivo(CalidadMuestraCabeceraDescargaMotivo calidadMuestraCabeceraDescargaMotivo) {
		getCalidadMuestraCabeceraDescargaMotivos().remove(calidadMuestraCabeceraDescargaMotivo);
		calidadMuestraCabeceraDescargaMotivo.setUsuario(null);

		return calidadMuestraCabeceraDescargaMotivo;
	}


	//bi-directional many-to-one association to CalidadMuestreoCocina
	@OneToMany(mappedBy="usuario")
	public List<CalidadMuestreoCocina> getCalidadMuestreoCocinas() {
		return this.calidadMuestreoCocinas;
	}

	public void setCalidadMuestreoCocinas(List<CalidadMuestreoCocina> calidadMuestreoCocinas) {
		this.calidadMuestreoCocinas = calidadMuestreoCocinas;
	}

	public CalidadMuestreoCocina addCalidadMuestreoCocina(CalidadMuestreoCocina calidadMuestreoCocina) {
		getCalidadMuestreoCocinas().add(calidadMuestreoCocina);
		calidadMuestreoCocina.setUsuario(this);

		return calidadMuestreoCocina;
	}

	public CalidadMuestreoCocina removeCalidadMuestreoCocina(CalidadMuestreoCocina calidadMuestreoCocina) {
		getCalidadMuestreoCocinas().remove(calidadMuestreoCocina);
		calidadMuestreoCocina.setUsuario(null);

		return calidadMuestreoCocina;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempCoccion
	@OneToMany(mappedBy="usuario")
	public List<CalidadMuestreoTempCoccion> getCalidadMuestreoTempCoccions() {
		return this.calidadMuestreoTempCoccions;
	}

	public void setCalidadMuestreoTempCoccions(List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions) {
		this.calidadMuestreoTempCoccions = calidadMuestreoTempCoccions;
	}

	public CalidadMuestreoTempCoccion addCalidadMuestreoTempCoccion(CalidadMuestreoTempCoccion calidadMuestreoTempCoccion) {
		getCalidadMuestreoTempCoccions().add(calidadMuestreoTempCoccion);
		calidadMuestreoTempCoccion.setUsuario(this);

		return calidadMuestreoTempCoccion;
	}

	public CalidadMuestreoTempCoccion removeCalidadMuestreoTempCoccion(CalidadMuestreoTempCoccion calidadMuestreoTempCoccion) {
		getCalidadMuestreoTempCoccions().remove(calidadMuestreoTempCoccion);
		calidadMuestreoTempCoccion.setUsuario(null);

		return calidadMuestreoTempCoccion;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="usuario")
	public List<CalidadMuestreoTempCochesEviscerado> getCalidadMuestreoTempCochesEviscerados() {
		return this.calidadMuestreoTempCochesEviscerados;
	}

	public void setCalidadMuestreoTempCochesEviscerados(List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados) {
		this.calidadMuestreoTempCochesEviscerados = calidadMuestreoTempCochesEviscerados;
	}

	public CalidadMuestreoTempCochesEviscerado addCalidadMuestreoTempCochesEviscerado(CalidadMuestreoTempCochesEviscerado calidadMuestreoTempCochesEviscerado) {
		getCalidadMuestreoTempCochesEviscerados().add(calidadMuestreoTempCochesEviscerado);
		calidadMuestreoTempCochesEviscerado.setUsuario(this);

		return calidadMuestreoTempCochesEviscerado;
	}

	public CalidadMuestreoTempCochesEviscerado removeCalidadMuestreoTempCochesEviscerado(CalidadMuestreoTempCochesEviscerado calidadMuestreoTempCochesEviscerado) {
		getCalidadMuestreoTempCochesEviscerados().remove(calidadMuestreoTempCochesEviscerado);
		calidadMuestreoTempCochesEviscerado.setUsuario(null);

		return calidadMuestreoTempCochesEviscerado;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempLimpieza
	@OneToMany(mappedBy="usuario")
	public List<CalidadMuestreoTempLimpieza> getCalidadMuestreoTempLimpiezas() {
		return this.calidadMuestreoTempLimpiezas;
	}

	public void setCalidadMuestreoTempLimpiezas(List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas) {
		this.calidadMuestreoTempLimpiezas = calidadMuestreoTempLimpiezas;
	}

	public CalidadMuestreoTempLimpieza addCalidadMuestreoTempLimpieza(CalidadMuestreoTempLimpieza calidadMuestreoTempLimpieza) {
		getCalidadMuestreoTempLimpiezas().add(calidadMuestreoTempLimpieza);
		calidadMuestreoTempLimpieza.setUsuario(this);

		return calidadMuestreoTempLimpieza;
	}

	public CalidadMuestreoTempLimpieza removeCalidadMuestreoTempLimpieza(CalidadMuestreoTempLimpieza calidadMuestreoTempLimpieza) {
		getCalidadMuestreoTempLimpiezas().remove(calidadMuestreoTempLimpieza);
		calidadMuestreoTempLimpieza.setUsuario(null);

		return calidadMuestreoTempLimpieza;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempPanzasEviscerado
	@OneToMany(mappedBy="usuario")
	public List<CalidadMuestreoTempPanzasEviscerado> getCalidadMuestreoTempPanzasEviscerados() {
		return this.calidadMuestreoTempPanzasEviscerados;
	}

	public void setCalidadMuestreoTempPanzasEviscerados(List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados) {
		this.calidadMuestreoTempPanzasEviscerados = calidadMuestreoTempPanzasEviscerados;
	}

	public CalidadMuestreoTempPanzasEviscerado addCalidadMuestreoTempPanzasEviscerado(CalidadMuestreoTempPanzasEviscerado calidadMuestreoTempPanzasEviscerado) {
		getCalidadMuestreoTempPanzasEviscerados().add(calidadMuestreoTempPanzasEviscerado);
		calidadMuestreoTempPanzasEviscerado.setUsuario(this);

		return calidadMuestreoTempPanzasEviscerado;
	}

	public CalidadMuestreoTempPanzasEviscerado removeCalidadMuestreoTempPanzasEviscerado(CalidadMuestreoTempPanzasEviscerado calidadMuestreoTempPanzasEviscerado) {
		getCalidadMuestreoTempPanzasEviscerados().remove(calidadMuestreoTempPanzasEviscerado);
		calidadMuestreoTempPanzasEviscerado.setUsuario(null);

		return calidadMuestreoTempPanzasEviscerado;
	}


	//bi-directional many-to-one association to CalidadPccRemuestreoCajon
	@OneToMany(mappedBy="usuario")
	public List<CalidadPccRemuestreoCajon> getCalidadPccRemuestreoCajons() {
		return this.calidadPccRemuestreoCajons;
	}

	public void setCalidadPccRemuestreoCajons(List<CalidadPccRemuestreoCajon> calidadPccRemuestreoCajons) {
		this.calidadPccRemuestreoCajons = calidadPccRemuestreoCajons;
	}

	public CalidadPccRemuestreoCajon addCalidadPccRemuestreoCajon(CalidadPccRemuestreoCajon calidadPccRemuestreoCajon) {
		getCalidadPccRemuestreoCajons().add(calidadPccRemuestreoCajon);
		calidadPccRemuestreoCajon.setUsuario(this);

		return calidadPccRemuestreoCajon;
	}

	public CalidadPccRemuestreoCajon removeCalidadPccRemuestreoCajon(CalidadPccRemuestreoCajon calidadPccRemuestreoCajon) {
		getCalidadPccRemuestreoCajons().remove(calidadPccRemuestreoCajon);
		calidadPccRemuestreoCajon.setUsuario(null);

		return calidadPccRemuestreoCajon;
	}


	//bi-directional many-to-one association to CalidadRespuestaPreguntaBpmclasificacion
	@OneToMany(mappedBy="usuario")
	public List<CalidadRespuestaPreguntaBpmclasificacion> getCalidadRespuestaPreguntaBpmclasificacions() {
		return this.calidadRespuestaPreguntaBpmclasificacions;
	}

	public void setCalidadRespuestaPreguntaBpmclasificacions(List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions) {
		this.calidadRespuestaPreguntaBpmclasificacions = calidadRespuestaPreguntaBpmclasificacions;
	}

	public CalidadRespuestaPreguntaBpmclasificacion addCalidadRespuestaPreguntaBpmclasificacion(CalidadRespuestaPreguntaBpmclasificacion calidadRespuestaPreguntaBpmclasificacion) {
		getCalidadRespuestaPreguntaBpmclasificacions().add(calidadRespuestaPreguntaBpmclasificacion);
		calidadRespuestaPreguntaBpmclasificacion.setUsuario(this);

		return calidadRespuestaPreguntaBpmclasificacion;
	}

	public CalidadRespuestaPreguntaBpmclasificacion removeCalidadRespuestaPreguntaBpmclasificacion(CalidadRespuestaPreguntaBpmclasificacion calidadRespuestaPreguntaBpmclasificacion) {
		getCalidadRespuestaPreguntaBpmclasificacions().remove(calidadRespuestaPreguntaBpmclasificacion);
		calidadRespuestaPreguntaBpmclasificacion.setUsuario(null);

		return calidadRespuestaPreguntaBpmclasificacion;
	}


	//bi-directional many-to-one association to CalidadRespuestaPreguntaBpmdesembarco
	@OneToMany(mappedBy="usuario")
	public List<CalidadRespuestaPreguntaBpmdesembarco> getCalidadRespuestaPreguntaBpmdesembarcos() {
		return this.calidadRespuestaPreguntaBpmdesembarcos;
	}

	public void setCalidadRespuestaPreguntaBpmdesembarcos(List<CalidadRespuestaPreguntaBpmdesembarco> calidadRespuestaPreguntaBpmdesembarcos) {
		this.calidadRespuestaPreguntaBpmdesembarcos = calidadRespuestaPreguntaBpmdesembarcos;
	}

	public CalidadRespuestaPreguntaBpmdesembarco addCalidadRespuestaPreguntaBpmdesembarco(CalidadRespuestaPreguntaBpmdesembarco calidadRespuestaPreguntaBpmdesembarco) {
		getCalidadRespuestaPreguntaBpmdesembarcos().add(calidadRespuestaPreguntaBpmdesembarco);
		calidadRespuestaPreguntaBpmdesembarco.setUsuario(this);

		return calidadRespuestaPreguntaBpmdesembarco;
	}

	public CalidadRespuestaPreguntaBpmdesembarco removeCalidadRespuestaPreguntaBpmdesembarco(CalidadRespuestaPreguntaBpmdesembarco calidadRespuestaPreguntaBpmdesembarco) {
		getCalidadRespuestaPreguntaBpmdesembarcos().remove(calidadRespuestaPreguntaBpmdesembarco);
		calidadRespuestaPreguntaBpmdesembarco.setUsuario(null);

		return calidadRespuestaPreguntaBpmdesembarco;
	}


	//bi-directional many-to-one association to CalidadTemperaturaCajonBanda
	@OneToMany(mappedBy="usuario")
	public List<CalidadTemperaturaCajonBanda> getCalidadTemperaturaCajonBandas() {
		return this.calidadTemperaturaCajonBandas;
	}

	public void setCalidadTemperaturaCajonBandas(List<CalidadTemperaturaCajonBanda> calidadTemperaturaCajonBandas) {
		this.calidadTemperaturaCajonBandas = calidadTemperaturaCajonBandas;
	}

	public CalidadTemperaturaCajonBanda addCalidadTemperaturaCajonBanda(CalidadTemperaturaCajonBanda calidadTemperaturaCajonBanda) {
		getCalidadTemperaturaCajonBandas().add(calidadTemperaturaCajonBanda);
		calidadTemperaturaCajonBanda.setUsuario(this);

		return calidadTemperaturaCajonBanda;
	}

	public CalidadTemperaturaCajonBanda removeCalidadTemperaturaCajonBanda(CalidadTemperaturaCajonBanda calidadTemperaturaCajonBanda) {
		getCalidadTemperaturaCajonBandas().remove(calidadTemperaturaCajonBanda);
		calidadTemperaturaCajonBanda.setUsuario(null);

		return calidadTemperaturaCajonBanda;
	}


	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="usuario")
	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public CamaraCajon addCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().add(camaraCajon);
		camaraCajon.setUsuario(this);

		return camaraCajon;
	}

	public CamaraCajon removeCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().remove(camaraCajon);
		camaraCajon.setUsuario(null);

		return camaraCajon;
	}


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	public List<CoccionDetalleMuestreoTempCoche> getCoccionDetalleMuestreoTempCoches() {
		return this.coccionDetalleMuestreoTempCoches;
	}

	public void setCoccionDetalleMuestreoTempCoches(List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches) {
		this.coccionDetalleMuestreoTempCoches = coccionDetalleMuestreoTempCoches;
	}

	public CoccionDetalleMuestreoTempCoche addCoccionDetalleMuestreoTempCoch(CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoch) {
		getCoccionDetalleMuestreoTempCoches().add(coccionDetalleMuestreoTempCoch);
		coccionDetalleMuestreoTempCoch.setUsuario(this);

		return coccionDetalleMuestreoTempCoch;
	}

	public CoccionDetalleMuestreoTempCoche removeCoccionDetalleMuestreoTempCoch(CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoch) {
		getCoccionDetalleMuestreoTempCoches().remove(coccionDetalleMuestreoTempCoch);
		coccionDetalleMuestreoTempCoch.setUsuario(null);

		return coccionDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheAdic
	@OneToMany(mappedBy="usuario")
	public List<CoccionDetalleMuestreoTempCocheAdic> getCoccionDetalleMuestreoTempCocheAdics() {
		return this.coccionDetalleMuestreoTempCocheAdics;
	}

	public void setCoccionDetalleMuestreoTempCocheAdics(List<CoccionDetalleMuestreoTempCocheAdic> coccionDetalleMuestreoTempCocheAdics) {
		this.coccionDetalleMuestreoTempCocheAdics = coccionDetalleMuestreoTempCocheAdics;
	}

	public CoccionDetalleMuestreoTempCocheAdic addCoccionDetalleMuestreoTempCocheAdic(CoccionDetalleMuestreoTempCocheAdic coccionDetalleMuestreoTempCocheAdic) {
		getCoccionDetalleMuestreoTempCocheAdics().add(coccionDetalleMuestreoTempCocheAdic);
		coccionDetalleMuestreoTempCocheAdic.setUsuario(this);

		return coccionDetalleMuestreoTempCocheAdic;
	}

	public CoccionDetalleMuestreoTempCocheAdic removeCoccionDetalleMuestreoTempCocheAdic(CoccionDetalleMuestreoTempCocheAdic coccionDetalleMuestreoTempCocheAdic) {
		getCoccionDetalleMuestreoTempCocheAdics().remove(coccionDetalleMuestreoTempCocheAdic);
		coccionDetalleMuestreoTempCocheAdic.setUsuario(null);

		return coccionDetalleMuestreoTempCocheAdic;
	}


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheIngreso
	@OneToMany(mappedBy="usuario")
	public List<CoccionDetalleMuestreoTempCocheIngreso> getCoccionDetalleMuestreoTempCocheIngresos() {
		return this.coccionDetalleMuestreoTempCocheIngresos;
	}

	public void setCoccionDetalleMuestreoTempCocheIngresos(List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos) {
		this.coccionDetalleMuestreoTempCocheIngresos = coccionDetalleMuestreoTempCocheIngresos;
	}

	public CoccionDetalleMuestreoTempCocheIngreso addCoccionDetalleMuestreoTempCocheIngreso(CoccionDetalleMuestreoTempCocheIngreso coccionDetalleMuestreoTempCocheIngreso) {
		getCoccionDetalleMuestreoTempCocheIngresos().add(coccionDetalleMuestreoTempCocheIngreso);
		coccionDetalleMuestreoTempCocheIngreso.setUsuario(this);

		return coccionDetalleMuestreoTempCocheIngreso;
	}

	public CoccionDetalleMuestreoTempCocheIngreso removeCoccionDetalleMuestreoTempCocheIngreso(CoccionDetalleMuestreoTempCocheIngreso coccionDetalleMuestreoTempCocheIngreso) {
		getCoccionDetalleMuestreoTempCocheIngresos().remove(coccionDetalleMuestreoTempCocheIngreso);
		coccionDetalleMuestreoTempCocheIngreso.setUsuario(null);

		return coccionDetalleMuestreoTempCocheIngreso;
	}


	//bi-directional many-to-one association to CoccionDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="usuario")
	public List<CoccionDetalleProcesoCocheTemperatura> getCoccionDetalleProcesoCocheTemperaturas() {
		return this.coccionDetalleProcesoCocheTemperaturas;
	}

	public void setCoccionDetalleProcesoCocheTemperaturas(List<CoccionDetalleProcesoCocheTemperatura> coccionDetalleProcesoCocheTemperaturas) {
		this.coccionDetalleProcesoCocheTemperaturas = coccionDetalleProcesoCocheTemperaturas;
	}

	public CoccionDetalleProcesoCocheTemperatura addCoccionDetalleProcesoCocheTemperatura(CoccionDetalleProcesoCocheTemperatura coccionDetalleProcesoCocheTemperatura) {
		getCoccionDetalleProcesoCocheTemperaturas().add(coccionDetalleProcesoCocheTemperatura);
		coccionDetalleProcesoCocheTemperatura.setUsuario(this);

		return coccionDetalleProcesoCocheTemperatura;
	}

	public CoccionDetalleProcesoCocheTemperatura removeCoccionDetalleProcesoCocheTemperatura(CoccionDetalleProcesoCocheTemperatura coccionDetalleProcesoCocheTemperatura) {
		getCoccionDetalleProcesoCocheTemperaturas().remove(coccionDetalleProcesoCocheTemperatura);
		coccionDetalleProcesoCocheTemperatura.setUsuario(null);

		return coccionDetalleProcesoCocheTemperatura;
	}


	//bi-directional many-to-one association to CoccionMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	public List<CoccionMuestreoTempCoche> getCoccionMuestreoTempCoches() {
		return this.coccionMuestreoTempCoches;
	}

	public void setCoccionMuestreoTempCoches(List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches) {
		this.coccionMuestreoTempCoches = coccionMuestreoTempCoches;
	}

	public CoccionMuestreoTempCoche addCoccionMuestreoTempCoch(CoccionMuestreoTempCoche coccionMuestreoTempCoch) {
		getCoccionMuestreoTempCoches().add(coccionMuestreoTempCoch);
		coccionMuestreoTempCoch.setUsuario(this);

		return coccionMuestreoTempCoch;
	}

	public CoccionMuestreoTempCoche removeCoccionMuestreoTempCoch(CoccionMuestreoTempCoche coccionMuestreoTempCoch) {
		getCoccionMuestreoTempCoches().remove(coccionMuestreoTempCoch);
		coccionMuestreoTempCoch.setUsuario(null);

		return coccionMuestreoTempCoch;
	}


	//bi-directional many-to-one association to CoccionMuestreoTempCocheIngreso
	@OneToMany(mappedBy="usuario")
	public List<CoccionMuestreoTempCocheIngreso> getCoccionMuestreoTempCocheIngresos() {
		return this.coccionMuestreoTempCocheIngresos;
	}

	public void setCoccionMuestreoTempCocheIngresos(List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos) {
		this.coccionMuestreoTempCocheIngresos = coccionMuestreoTempCocheIngresos;
	}

	public CoccionMuestreoTempCocheIngreso addCoccionMuestreoTempCocheIngreso(CoccionMuestreoTempCocheIngreso coccionMuestreoTempCocheIngreso) {
		getCoccionMuestreoTempCocheIngresos().add(coccionMuestreoTempCocheIngreso);
		coccionMuestreoTempCocheIngreso.setUsuario(this);

		return coccionMuestreoTempCocheIngreso;
	}

	public CoccionMuestreoTempCocheIngreso removeCoccionMuestreoTempCocheIngreso(CoccionMuestreoTempCocheIngreso coccionMuestreoTempCocheIngreso) {
		getCoccionMuestreoTempCocheIngresos().remove(coccionMuestreoTempCocheIngreso);
		coccionMuestreoTempCocheIngreso.setUsuario(null);

		return coccionMuestreoTempCocheIngreso;
	}


	//bi-directional many-to-one association to CoccionProceso
	@OneToMany(mappedBy="usuario")
	public List<CoccionProceso> getCoccionProcesos() {
		return this.coccionProcesos;
	}

	public void setCoccionProcesos(List<CoccionProceso> coccionProcesos) {
		this.coccionProcesos = coccionProcesos;
	}

	public CoccionProceso addCoccionProceso(CoccionProceso coccionProceso) {
		getCoccionProcesos().add(coccionProceso);
		coccionProceso.setUsuario(this);

		return coccionProceso;
	}

	public CoccionProceso removeCoccionProceso(CoccionProceso coccionProceso) {
		getCoccionProcesos().remove(coccionProceso);
		coccionProceso.setUsuario(null);

		return coccionProceso;
	}


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@OneToMany(mappedBy="usuario")
	public List<CocinaAperturaCierreDetalle> getCocinaAperturaCierreDetalles() {
		return this.cocinaAperturaCierreDetalles;
	}

	public void setCocinaAperturaCierreDetalles(List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles) {
		this.cocinaAperturaCierreDetalles = cocinaAperturaCierreDetalles;
	}

	public CocinaAperturaCierreDetalle addCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		getCocinaAperturaCierreDetalles().add(cocinaAperturaCierreDetalle);
		cocinaAperturaCierreDetalle.setUsuario(this);

		return cocinaAperturaCierreDetalle;
	}

	public CocinaAperturaCierreDetalle removeCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		getCocinaAperturaCierreDetalles().remove(cocinaAperturaCierreDetalle);
		cocinaAperturaCierreDetalle.setUsuario(null);

		return cocinaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to CocinaProcesoControlEspinaDetalle
	@OneToMany(mappedBy="usuario")
	public List<CocinaProcesoControlEspinaDetalle> getCocinaProcesoControlEspinaDetalles() {
		return this.cocinaProcesoControlEspinaDetalles;
	}

	public void setCocinaProcesoControlEspinaDetalles(List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles) {
		this.cocinaProcesoControlEspinaDetalles = cocinaProcesoControlEspinaDetalles;
	}

	public CocinaProcesoControlEspinaDetalle addCocinaProcesoControlEspinaDetalle(CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle) {
		getCocinaProcesoControlEspinaDetalles().add(cocinaProcesoControlEspinaDetalle);
		cocinaProcesoControlEspinaDetalle.setUsuario(this);

		return cocinaProcesoControlEspinaDetalle;
	}

	public CocinaProcesoControlEspinaDetalle removeCocinaProcesoControlEspinaDetalle(CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle) {
		getCocinaProcesoControlEspinaDetalles().remove(cocinaProcesoControlEspinaDetalle);
		cocinaProcesoControlEspinaDetalle.setUsuario(null);

		return cocinaProcesoControlEspinaDetalle;
	}


	//bi-directional many-to-one association to ContraloriaCoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	public List<ContraloriaCoccionDetalleMuestreoTempCoche> getContraloriaCoccionDetalleMuestreoTempCoches() {
		return this.contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public void setContraloriaCoccionDetalleMuestreoTempCoches(List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches) {
		this.contraloriaCoccionDetalleMuestreoTempCoches = contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public ContraloriaCoccionDetalleMuestreoTempCoche addContraloriaCoccionDetalleMuestreoTempCoch(ContraloriaCoccionDetalleMuestreoTempCoche contraloriaCoccionDetalleMuestreoTempCoch) {
		getContraloriaCoccionDetalleMuestreoTempCoches().add(contraloriaCoccionDetalleMuestreoTempCoch);
		contraloriaCoccionDetalleMuestreoTempCoch.setUsuario(this);

		return contraloriaCoccionDetalleMuestreoTempCoch;
	}

	public ContraloriaCoccionDetalleMuestreoTempCoche removeContraloriaCoccionDetalleMuestreoTempCoch(ContraloriaCoccionDetalleMuestreoTempCoche contraloriaCoccionDetalleMuestreoTempCoch) {
		getContraloriaCoccionDetalleMuestreoTempCoches().remove(contraloriaCoccionDetalleMuestreoTempCoch);
		contraloriaCoccionDetalleMuestreoTempCoch.setUsuario(null);

		return contraloriaCoccionDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to ContraloriaDetalleRackeoProcesoTemperatura
	@OneToMany(mappedBy="usuario")
	public List<ContraloriaDetalleRackeoProcesoTemperatura> getContraloriaDetalleRackeoProcesoTemperaturas() {
		return this.contraloriaDetalleRackeoProcesoTemperaturas;
	}

	public void setContraloriaDetalleRackeoProcesoTemperaturas(List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas) {
		this.contraloriaDetalleRackeoProcesoTemperaturas = contraloriaDetalleRackeoProcesoTemperaturas;
	}

	public ContraloriaDetalleRackeoProcesoTemperatura addContraloriaDetalleRackeoProcesoTemperatura(ContraloriaDetalleRackeoProcesoTemperatura contraloriaDetalleRackeoProcesoTemperatura) {
		getContraloriaDetalleRackeoProcesoTemperaturas().add(contraloriaDetalleRackeoProcesoTemperatura);
		contraloriaDetalleRackeoProcesoTemperatura.setUsuario(this);

		return contraloriaDetalleRackeoProcesoTemperatura;
	}

	public ContraloriaDetalleRackeoProcesoTemperatura removeContraloriaDetalleRackeoProcesoTemperatura(ContraloriaDetalleRackeoProcesoTemperatura contraloriaDetalleRackeoProcesoTemperatura) {
		getContraloriaDetalleRackeoProcesoTemperaturas().remove(contraloriaDetalleRackeoProcesoTemperatura);
		contraloriaDetalleRackeoProcesoTemperatura.setUsuario(null);

		return contraloriaDetalleRackeoProcesoTemperatura;
	}


	//bi-directional many-to-one association to ContraloriaEvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getContraloriaEvisceradoDetalleMuestreoTempCoches() {
		return this.contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public void setContraloriaEvisceradoDetalleMuestreoTempCoches(List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches) {
		this.contraloriaEvisceradoDetalleMuestreoTempCoches = contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public ContraloriaEvisceradoDetalleMuestreoTempCoche addContraloriaEvisceradoDetalleMuestreoTempCoch(ContraloriaEvisceradoDetalleMuestreoTempCoche contraloriaEvisceradoDetalleMuestreoTempCoch) {
		getContraloriaEvisceradoDetalleMuestreoTempCoches().add(contraloriaEvisceradoDetalleMuestreoTempCoch);
		contraloriaEvisceradoDetalleMuestreoTempCoch.setUsuario(this);

		return contraloriaEvisceradoDetalleMuestreoTempCoch;
	}

	public ContraloriaEvisceradoDetalleMuestreoTempCoche removeContraloriaEvisceradoDetalleMuestreoTempCoch(ContraloriaEvisceradoDetalleMuestreoTempCoche contraloriaEvisceradoDetalleMuestreoTempCoch) {
		getContraloriaEvisceradoDetalleMuestreoTempCoches().remove(contraloriaEvisceradoDetalleMuestreoTempCoch);
		contraloriaEvisceradoDetalleMuestreoTempCoch.setUsuario(null);

		return contraloriaEvisceradoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to ControlBatchProceso
	@OneToMany(mappedBy="usuario")
	public List<ControlBatchProceso> getControlBatchProcesos() {
		return this.controlBatchProcesos;
	}

	public void setControlBatchProcesos(List<ControlBatchProceso> controlBatchProcesos) {
		this.controlBatchProcesos = controlBatchProcesos;
	}

	public ControlBatchProceso addControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		getControlBatchProcesos().add(controlBatchProceso);
		controlBatchProceso.setUsuario(this);

		return controlBatchProceso;
	}

	public ControlBatchProceso removeControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		getControlBatchProcesos().remove(controlBatchProceso);
		controlBatchProceso.setUsuario(null);

		return controlBatchProceso;
	}


	//bi-directional many-to-one association to ControlDetalleBatchEsterilizado
	@OneToMany(mappedBy="usuario")
	public List<ControlDetalleBatchEsterilizado> getControlDetalleBatchEsterilizados() {
		return this.controlDetalleBatchEsterilizados;
	}

	public void setControlDetalleBatchEsterilizados(List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados) {
		this.controlDetalleBatchEsterilizados = controlDetalleBatchEsterilizados;
	}

	public ControlDetalleBatchEsterilizado addControlDetalleBatchEsterilizado(ControlDetalleBatchEsterilizado controlDetalleBatchEsterilizado) {
		getControlDetalleBatchEsterilizados().add(controlDetalleBatchEsterilizado);
		controlDetalleBatchEsterilizado.setUsuario(this);

		return controlDetalleBatchEsterilizado;
	}

	public ControlDetalleBatchEsterilizado removeControlDetalleBatchEsterilizado(ControlDetalleBatchEsterilizado controlDetalleBatchEsterilizado) {
		getControlDetalleBatchEsterilizados().remove(controlDetalleBatchEsterilizado);
		controlDetalleBatchEsterilizado.setUsuario(null);

		return controlDetalleBatchEsterilizado;
	}


	//bi-directional many-to-one association to ControlDetalleBatchLimpieza
	@OneToMany(mappedBy="usuario")
	public List<ControlDetalleBatchLimpieza> getControlDetalleBatchLimpiezas() {
		return this.controlDetalleBatchLimpiezas;
	}

	public void setControlDetalleBatchLimpiezas(List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas) {
		this.controlDetalleBatchLimpiezas = controlDetalleBatchLimpiezas;
	}

	public ControlDetalleBatchLimpieza addControlDetalleBatchLimpieza(ControlDetalleBatchLimpieza controlDetalleBatchLimpieza) {
		getControlDetalleBatchLimpiezas().add(controlDetalleBatchLimpieza);
		controlDetalleBatchLimpieza.setUsuario(this);

		return controlDetalleBatchLimpieza;
	}

	public ControlDetalleBatchLimpieza removeControlDetalleBatchLimpieza(ControlDetalleBatchLimpieza controlDetalleBatchLimpieza) {
		getControlDetalleBatchLimpiezas().remove(controlDetalleBatchLimpieza);
		controlDetalleBatchLimpieza.setUsuario(null);

		return controlDetalleBatchLimpieza;
	}


	//bi-directional many-to-one association to ControlDetalleBatchMaquina
	@OneToMany(mappedBy="usuario")
	public List<ControlDetalleBatchMaquina> getControlDetalleBatchMaquinas() {
		return this.controlDetalleBatchMaquinas;
	}

	public void setControlDetalleBatchMaquinas(List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas) {
		this.controlDetalleBatchMaquinas = controlDetalleBatchMaquinas;
	}

	public ControlDetalleBatchMaquina addControlDetalleBatchMaquina(ControlDetalleBatchMaquina controlDetalleBatchMaquina) {
		getControlDetalleBatchMaquinas().add(controlDetalleBatchMaquina);
		controlDetalleBatchMaquina.setUsuario(this);

		return controlDetalleBatchMaquina;
	}

	public ControlDetalleBatchMaquina removeControlDetalleBatchMaquina(ControlDetalleBatchMaquina controlDetalleBatchMaquina) {
		getControlDetalleBatchMaquinas().remove(controlDetalleBatchMaquina);
		controlDetalleBatchMaquina.setUsuario(null);

		return controlDetalleBatchMaquina;
	}


	//bi-directional many-to-one association to ControlDetalleBatchRallado
	@OneToMany(mappedBy="usuario1")
	public List<ControlDetalleBatchRallado> getControlDetalleBatchRallados1() {
		return this.controlDetalleBatchRallados1;
	}

	public void setControlDetalleBatchRallados1(List<ControlDetalleBatchRallado> controlDetalleBatchRallados1) {
		this.controlDetalleBatchRallados1 = controlDetalleBatchRallados1;
	}

	public ControlDetalleBatchRallado addControlDetalleBatchRallados1(ControlDetalleBatchRallado controlDetalleBatchRallados1) {
		getControlDetalleBatchRallados1().add(controlDetalleBatchRallados1);
		controlDetalleBatchRallados1.setUsuario1(this);

		return controlDetalleBatchRallados1;
	}

	public ControlDetalleBatchRallado removeControlDetalleBatchRallados1(ControlDetalleBatchRallado controlDetalleBatchRallados1) {
		getControlDetalleBatchRallados1().remove(controlDetalleBatchRallados1);
		controlDetalleBatchRallados1.setUsuario1(null);

		return controlDetalleBatchRallados1;
	}


	//bi-directional many-to-one association to ControlDetalleBatchRallado
	@OneToMany(mappedBy="usuario2")
	public List<ControlDetalleBatchRallado> getControlDetalleBatchRallados2() {
		return this.controlDetalleBatchRallados2;
	}

	public void setControlDetalleBatchRallados2(List<ControlDetalleBatchRallado> controlDetalleBatchRallados2) {
		this.controlDetalleBatchRallados2 = controlDetalleBatchRallados2;
	}

	public ControlDetalleBatchRallado addControlDetalleBatchRallados2(ControlDetalleBatchRallado controlDetalleBatchRallados2) {
		getControlDetalleBatchRallados2().add(controlDetalleBatchRallados2);
		controlDetalleBatchRallados2.setUsuario2(this);

		return controlDetalleBatchRallados2;
	}

	public ControlDetalleBatchRallado removeControlDetalleBatchRallados2(ControlDetalleBatchRallado controlDetalleBatchRallados2) {
		getControlDetalleBatchRallados2().remove(controlDetalleBatchRallados2);
		controlDetalleBatchRallados2.setUsuario2(null);

		return controlDetalleBatchRallados2;
	}


	//bi-directional many-to-one association to ControlDetalleBatchRallado
	@OneToMany(mappedBy="usuario3")
	public List<ControlDetalleBatchRallado> getControlDetalleBatchRallados3() {
		return this.controlDetalleBatchRallados3;
	}

	public void setControlDetalleBatchRallados3(List<ControlDetalleBatchRallado> controlDetalleBatchRallados3) {
		this.controlDetalleBatchRallados3 = controlDetalleBatchRallados3;
	}

	public ControlDetalleBatchRallado addControlDetalleBatchRallados3(ControlDetalleBatchRallado controlDetalleBatchRallados3) {
		getControlDetalleBatchRallados3().add(controlDetalleBatchRallados3);
		controlDetalleBatchRallados3.setUsuario3(this);

		return controlDetalleBatchRallados3;
	}

	public ControlDetalleBatchRallado removeControlDetalleBatchRallados3(ControlDetalleBatchRallado controlDetalleBatchRallados3) {
		getControlDetalleBatchRallados3().remove(controlDetalleBatchRallados3);
		controlDetalleBatchRallados3.setUsuario3(null);

		return controlDetalleBatchRallados3;
	}


	//bi-directional many-to-one association to ControlFichaBatch
	@OneToMany(mappedBy="usuario")
	public List<ControlFichaBatch> getControlFichaBatches() {
		return this.controlFichaBatches;
	}

	public void setControlFichaBatches(List<ControlFichaBatch> controlFichaBatches) {
		this.controlFichaBatches = controlFichaBatches;
	}

	public ControlFichaBatch addControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		getControlFichaBatches().add(controlFichaBatch);
		controlFichaBatch.setUsuario(this);

		return controlFichaBatch;
	}

	public ControlFichaBatch removeControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		getControlFichaBatches().remove(controlFichaBatch);
		controlFichaBatch.setUsuario(null);

		return controlFichaBatch;
	}


	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="usuario")
	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public DescongeladoCajonModificacion addDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().add(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setUsuario(this);

		return descongeladoCajonModificacion;
	}

	public DescongeladoCajonModificacion removeDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().remove(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setUsuario(null);

		return descongeladoCajonModificacion;
	}


	//bi-directional many-to-one association to DescongeladoDetalleDuchaAperturaTalla
	@OneToMany(mappedBy="usuario")
	public List<DescongeladoDetalleDuchaAperturaTalla> getDescongeladoDetalleDuchaAperturaTallas() {
		return this.descongeladoDetalleDuchaAperturaTallas;
	}

	public void setDescongeladoDetalleDuchaAperturaTallas(List<DescongeladoDetalleDuchaAperturaTalla> descongeladoDetalleDuchaAperturaTallas) {
		this.descongeladoDetalleDuchaAperturaTallas = descongeladoDetalleDuchaAperturaTallas;
	}

	public DescongeladoDetalleDuchaAperturaTalla addDescongeladoDetalleDuchaAperturaTalla(DescongeladoDetalleDuchaAperturaTalla descongeladoDetalleDuchaAperturaTalla) {
		getDescongeladoDetalleDuchaAperturaTallas().add(descongeladoDetalleDuchaAperturaTalla);
		descongeladoDetalleDuchaAperturaTalla.setUsuario(this);

		return descongeladoDetalleDuchaAperturaTalla;
	}

	public DescongeladoDetalleDuchaAperturaTalla removeDescongeladoDetalleDuchaAperturaTalla(DescongeladoDetalleDuchaAperturaTalla descongeladoDetalleDuchaAperturaTalla) {
		getDescongeladoDetalleDuchaAperturaTallas().remove(descongeladoDetalleDuchaAperturaTalla);
		descongeladoDetalleDuchaAperturaTalla.setUsuario(null);

		return descongeladoDetalleDuchaAperturaTalla;
	}


	//bi-directional many-to-one association to DescongeladoDetalleDuchaTallaMonitoreo
	@OneToMany(mappedBy="usuario")
	public List<DescongeladoDetalleDuchaTallaMonitoreo> getDescongeladoDetalleDuchaTallaMonitoreos() {
		return this.descongeladoDetalleDuchaTallaMonitoreos;
	}

	public void setDescongeladoDetalleDuchaTallaMonitoreos(List<DescongeladoDetalleDuchaTallaMonitoreo> descongeladoDetalleDuchaTallaMonitoreos) {
		this.descongeladoDetalleDuchaTallaMonitoreos = descongeladoDetalleDuchaTallaMonitoreos;
	}

	public DescongeladoDetalleDuchaTallaMonitoreo addDescongeladoDetalleDuchaTallaMonitoreo(DescongeladoDetalleDuchaTallaMonitoreo descongeladoDetalleDuchaTallaMonitoreo) {
		getDescongeladoDetalleDuchaTallaMonitoreos().add(descongeladoDetalleDuchaTallaMonitoreo);
		descongeladoDetalleDuchaTallaMonitoreo.setUsuario(this);

		return descongeladoDetalleDuchaTallaMonitoreo;
	}

	public DescongeladoDetalleDuchaTallaMonitoreo removeDescongeladoDetalleDuchaTallaMonitoreo(DescongeladoDetalleDuchaTallaMonitoreo descongeladoDetalleDuchaTallaMonitoreo) {
		getDescongeladoDetalleDuchaTallaMonitoreos().remove(descongeladoDetalleDuchaTallaMonitoreo);
		descongeladoDetalleDuchaTallaMonitoreo.setUsuario(null);

		return descongeladoDetalleDuchaTallaMonitoreo;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="usuario")
	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public DescongeladoDetalleProceso addDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().add(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setUsuario(this);

		return descongeladoDetalleProceso;
	}

	public DescongeladoDetalleProceso removeDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().remove(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setUsuario(null);

		return descongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProcesoContraloria
	@OneToMany(mappedBy="usuario")
	public List<DescongeladoDetalleProcesoContraloria> getDescongeladoDetalleProcesoContralorias() {
		return this.descongeladoDetalleProcesoContralorias;
	}

	public void setDescongeladoDetalleProcesoContralorias(List<DescongeladoDetalleProcesoContraloria> descongeladoDetalleProcesoContralorias) {
		this.descongeladoDetalleProcesoContralorias = descongeladoDetalleProcesoContralorias;
	}

	public DescongeladoDetalleProcesoContraloria addDescongeladoDetalleProcesoContraloria(DescongeladoDetalleProcesoContraloria descongeladoDetalleProcesoContraloria) {
		getDescongeladoDetalleProcesoContralorias().add(descongeladoDetalleProcesoContraloria);
		descongeladoDetalleProcesoContraloria.setUsuario(this);

		return descongeladoDetalleProcesoContraloria;
	}

	public DescongeladoDetalleProcesoContraloria removeDescongeladoDetalleProcesoContraloria(DescongeladoDetalleProcesoContraloria descongeladoDetalleProcesoContraloria) {
		getDescongeladoDetalleProcesoContralorias().remove(descongeladoDetalleProcesoContraloria);
		descongeladoDetalleProcesoContraloria.setUsuario(null);

		return descongeladoDetalleProcesoContraloria;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProcesoFinForzado
	@OneToMany(mappedBy="usuario")
	public List<DescongeladoDetalleProcesoFinForzado> getDescongeladoDetalleProcesoFinForzados() {
		return this.descongeladoDetalleProcesoFinForzados;
	}

	public void setDescongeladoDetalleProcesoFinForzados(List<DescongeladoDetalleProcesoFinForzado> descongeladoDetalleProcesoFinForzados) {
		this.descongeladoDetalleProcesoFinForzados = descongeladoDetalleProcesoFinForzados;
	}

	public DescongeladoDetalleProcesoFinForzado addDescongeladoDetalleProcesoFinForzado(DescongeladoDetalleProcesoFinForzado descongeladoDetalleProcesoFinForzado) {
		getDescongeladoDetalleProcesoFinForzados().add(descongeladoDetalleProcesoFinForzado);
		descongeladoDetalleProcesoFinForzado.setUsuario(this);

		return descongeladoDetalleProcesoFinForzado;
	}

	public DescongeladoDetalleProcesoFinForzado removeDescongeladoDetalleProcesoFinForzado(DescongeladoDetalleProcesoFinForzado descongeladoDetalleProcesoFinForzado) {
		getDescongeladoDetalleProcesoFinForzados().remove(descongeladoDetalleProcesoFinForzado);
		descongeladoDetalleProcesoFinForzado.setUsuario(null);

		return descongeladoDetalleProcesoFinForzado;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="usuario")
	public List<DescongeladoDetalleProcesoTempIng> getDescongeladoDetalleProcesoTempIngs() {
		return this.descongeladoDetalleProcesoTempIngs;
	}

	public void setDescongeladoDetalleProcesoTempIngs(List<DescongeladoDetalleProcesoTempIng> descongeladoDetalleProcesoTempIngs) {
		this.descongeladoDetalleProcesoTempIngs = descongeladoDetalleProcesoTempIngs;
	}

	public DescongeladoDetalleProcesoTempIng addDescongeladoDetalleProcesoTempIng(DescongeladoDetalleProcesoTempIng descongeladoDetalleProcesoTempIng) {
		getDescongeladoDetalleProcesoTempIngs().add(descongeladoDetalleProcesoTempIng);
		descongeladoDetalleProcesoTempIng.setUsuario(this);

		return descongeladoDetalleProcesoTempIng;
	}

	public DescongeladoDetalleProcesoTempIng removeDescongeladoDetalleProcesoTempIng(DescongeladoDetalleProcesoTempIng descongeladoDetalleProcesoTempIng) {
		getDescongeladoDetalleProcesoTempIngs().remove(descongeladoDetalleProcesoTempIng);
		descongeladoDetalleProcesoTempIng.setUsuario(null);

		return descongeladoDetalleProcesoTempIng;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProcesoTemperatura
	@OneToMany(mappedBy="usuario")
	public List<DescongeladoDetalleProcesoTemperatura> getDescongeladoDetalleProcesoTemperaturas() {
		return this.descongeladoDetalleProcesoTemperaturas;
	}

	public void setDescongeladoDetalleProcesoTemperaturas(List<DescongeladoDetalleProcesoTemperatura> descongeladoDetalleProcesoTemperaturas) {
		this.descongeladoDetalleProcesoTemperaturas = descongeladoDetalleProcesoTemperaturas;
	}

	public DescongeladoDetalleProcesoTemperatura addDescongeladoDetalleProcesoTemperatura(DescongeladoDetalleProcesoTemperatura descongeladoDetalleProcesoTemperatura) {
		getDescongeladoDetalleProcesoTemperaturas().add(descongeladoDetalleProcesoTemperatura);
		descongeladoDetalleProcesoTemperatura.setUsuario(this);

		return descongeladoDetalleProcesoTemperatura;
	}

	public DescongeladoDetalleProcesoTemperatura removeDescongeladoDetalleProcesoTemperatura(DescongeladoDetalleProcesoTemperatura descongeladoDetalleProcesoTemperatura) {
		getDescongeladoDetalleProcesoTemperaturas().remove(descongeladoDetalleProcesoTemperatura);
		descongeladoDetalleProcesoTemperatura.setUsuario(null);

		return descongeladoDetalleProcesoTemperatura;
	}


	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@OneToMany(mappedBy="usuario")
	public List<DescongeladoDuchaAperturaCierreDetalle> getDescongeladoDuchaAperturaCierreDetalles() {
		return this.descongeladoDuchaAperturaCierreDetalles;
	}

	public void setDescongeladoDuchaAperturaCierreDetalles(List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles) {
		this.descongeladoDuchaAperturaCierreDetalles = descongeladoDuchaAperturaCierreDetalles;
	}

	public DescongeladoDuchaAperturaCierreDetalle addDescongeladoDuchaAperturaCierreDetalle(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle) {
		getDescongeladoDuchaAperturaCierreDetalles().add(descongeladoDuchaAperturaCierreDetalle);
		descongeladoDuchaAperturaCierreDetalle.setUsuario(this);

		return descongeladoDuchaAperturaCierreDetalle;
	}

	public DescongeladoDuchaAperturaCierreDetalle removeDescongeladoDuchaAperturaCierreDetalle(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle) {
		getDescongeladoDuchaAperturaCierreDetalles().remove(descongeladoDuchaAperturaCierreDetalle);
		descongeladoDuchaAperturaCierreDetalle.setUsuario(null);

		return descongeladoDuchaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="usuario1")
	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas1() {
		return this.desperdicioCajonHarinas1;
	}

	public void setDesperdicioCajonHarinas1(List<DesperdicioCajonHarina> desperdicioCajonHarinas1) {
		this.desperdicioCajonHarinas1 = desperdicioCajonHarinas1;
	}

	public DesperdicioCajonHarina addDesperdicioCajonHarinas1(DesperdicioCajonHarina desperdicioCajonHarinas1) {
		getDesperdicioCajonHarinas1().add(desperdicioCajonHarinas1);
		desperdicioCajonHarinas1.setUsuario1(this);

		return desperdicioCajonHarinas1;
	}

	public DesperdicioCajonHarina removeDesperdicioCajonHarinas1(DesperdicioCajonHarina desperdicioCajonHarinas1) {
		getDesperdicioCajonHarinas1().remove(desperdicioCajonHarinas1);
		desperdicioCajonHarinas1.setUsuario1(null);

		return desperdicioCajonHarinas1;
	}


	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="usuario2")
	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas2() {
		return this.desperdicioCajonHarinas2;
	}

	public void setDesperdicioCajonHarinas2(List<DesperdicioCajonHarina> desperdicioCajonHarinas2) {
		this.desperdicioCajonHarinas2 = desperdicioCajonHarinas2;
	}

	public DesperdicioCajonHarina addDesperdicioCajonHarinas2(DesperdicioCajonHarina desperdicioCajonHarinas2) {
		getDesperdicioCajonHarinas2().add(desperdicioCajonHarinas2);
		desperdicioCajonHarinas2.setUsuario2(this);

		return desperdicioCajonHarinas2;
	}

	public DesperdicioCajonHarina removeDesperdicioCajonHarinas2(DesperdicioCajonHarina desperdicioCajonHarinas2) {
		getDesperdicioCajonHarinas2().remove(desperdicioCajonHarinas2);
		desperdicioCajonHarinas2.setUsuario2(null);

		return desperdicioCajonHarinas2;
	}


	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="usuario")
	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public DesperdicioDetalle addDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().add(desperdicioDetalle);
		desperdicioDetalle.setUsuario(this);

		return desperdicioDetalle;
	}

	public DesperdicioDetalle removeDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().remove(desperdicioDetalle);
		desperdicioDetalle.setUsuario(null);

		return desperdicioDetalle;
	}


	//bi-directional many-to-one association to DuchaAperturaCierreDetalle
	@OneToMany(mappedBy="usuario")
	public List<DuchaAperturaCierreDetalle> getDuchaAperturaCierreDetalles() {
		return this.duchaAperturaCierreDetalles;
	}

	public void setDuchaAperturaCierreDetalles(List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles) {
		this.duchaAperturaCierreDetalles = duchaAperturaCierreDetalles;
	}

	public DuchaAperturaCierreDetalle addDuchaAperturaCierreDetalle(DuchaAperturaCierreDetalle duchaAperturaCierreDetalle) {
		getDuchaAperturaCierreDetalles().add(duchaAperturaCierreDetalle);
		duchaAperturaCierreDetalle.setUsuario(this);

		return duchaAperturaCierreDetalle;
	}

	public DuchaAperturaCierreDetalle removeDuchaAperturaCierreDetalle(DuchaAperturaCierreDetalle duchaAperturaCierreDetalle) {
		getDuchaAperturaCierreDetalles().remove(duchaAperturaCierreDetalle);
		duchaAperturaCierreDetalle.setUsuario(null);

		return duchaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoFillCabecera
	@OneToMany(mappedBy="usuario")
	public List<EnvasadoControlPesoFillCabecera> getEnvasadoControlPesoFillCabeceras() {
		return this.envasadoControlPesoFillCabeceras;
	}

	public void setEnvasadoControlPesoFillCabeceras(List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras) {
		this.envasadoControlPesoFillCabeceras = envasadoControlPesoFillCabeceras;
	}

	public EnvasadoControlPesoFillCabecera addEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().add(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setUsuario(this);

		return envasadoControlPesoFillCabecera;
	}

	public EnvasadoControlPesoFillCabecera removeEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().remove(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setUsuario(null);

		return envasadoControlPesoFillCabecera;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoFillDetalle
	@OneToMany(mappedBy="usuario")
	public List<EnvasadoControlPesoFillDetalle> getEnvasadoControlPesoFillDetalles() {
		return this.envasadoControlPesoFillDetalles;
	}

	public void setEnvasadoControlPesoFillDetalles(List<EnvasadoControlPesoFillDetalle> envasadoControlPesoFillDetalles) {
		this.envasadoControlPesoFillDetalles = envasadoControlPesoFillDetalles;
	}

	public EnvasadoControlPesoFillDetalle addEnvasadoControlPesoFillDetalle(EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle) {
		getEnvasadoControlPesoFillDetalles().add(envasadoControlPesoFillDetalle);
		envasadoControlPesoFillDetalle.setUsuario(this);

		return envasadoControlPesoFillDetalle;
	}

	public EnvasadoControlPesoFillDetalle removeEnvasadoControlPesoFillDetalle(EnvasadoControlPesoFillDetalle envasadoControlPesoFillDetalle) {
		getEnvasadoControlPesoFillDetalles().remove(envasadoControlPesoFillDetalle);
		envasadoControlPesoFillDetalle.setUsuario(null);

		return envasadoControlPesoFillDetalle;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoNetoCabecera
	@OneToMany(mappedBy="usuario")
	public List<EnvasadoControlPesoNetoCabecera> getEnvasadoControlPesoNetoCabeceras() {
		return this.envasadoControlPesoNetoCabeceras;
	}

	public void setEnvasadoControlPesoNetoCabeceras(List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabeceras) {
		this.envasadoControlPesoNetoCabeceras = envasadoControlPesoNetoCabeceras;
	}

	public EnvasadoControlPesoNetoCabecera addEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabeceras().add(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setUsuario(this);

		return envasadoControlPesoNetoCabecera;
	}

	public EnvasadoControlPesoNetoCabecera removeEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabeceras().remove(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setUsuario(null);

		return envasadoControlPesoNetoCabecera;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoNetoDetalle
	@OneToMany(mappedBy="usuario")
	public List<EnvasadoControlPesoNetoDetalle> getEnvasadoControlPesoNetoDetalles() {
		return this.envasadoControlPesoNetoDetalles;
	}

	public void setEnvasadoControlPesoNetoDetalles(List<EnvasadoControlPesoNetoDetalle> envasadoControlPesoNetoDetalles) {
		this.envasadoControlPesoNetoDetalles = envasadoControlPesoNetoDetalles;
	}

	public EnvasadoControlPesoNetoDetalle addEnvasadoControlPesoNetoDetalle(EnvasadoControlPesoNetoDetalle envasadoControlPesoNetoDetalle) {
		getEnvasadoControlPesoNetoDetalles().add(envasadoControlPesoNetoDetalle);
		envasadoControlPesoNetoDetalle.setUsuario(this);

		return envasadoControlPesoNetoDetalle;
	}

	public EnvasadoControlPesoNetoDetalle removeEnvasadoControlPesoNetoDetalle(EnvasadoControlPesoNetoDetalle envasadoControlPesoNetoDetalle) {
		getEnvasadoControlPesoNetoDetalles().remove(envasadoControlPesoNetoDetalle);
		envasadoControlPesoNetoDetalle.setUsuario(null);

		return envasadoControlPesoNetoDetalle;
	}


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@OneToMany(mappedBy="usuario")
	public List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambios() {
		return this.envasadoDetalleProcesoCambios;
	}

	public void setEnvasadoDetalleProcesoCambios(List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios) {
		this.envasadoDetalleProcesoCambios = envasadoDetalleProcesoCambios;
	}

	public EnvasadoDetalleProcesoCambio addEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().add(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setUsuario(this);

		return envasadoDetalleProcesoCambio;
	}

	public EnvasadoDetalleProcesoCambio removeEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().remove(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setUsuario(null);

		return envasadoDetalleProcesoCambio;
	}


	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="usuario")
	public List<EnvasadoProceso> getEnvasadoProcesos() {
		return this.envasadoProcesos;
	}

	public void setEnvasadoProcesos(List<EnvasadoProceso> envasadoProcesos) {
		this.envasadoProcesos = envasadoProcesos;
	}

	public EnvasadoProceso addEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().add(envasadoProceso);
		envasadoProceso.setUsuario(this);

		return envasadoProceso;
	}

	public EnvasadoProceso removeEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().remove(envasadoProceso);
		envasadoProceso.setUsuario(null);

		return envasadoProceso;
	}


	//bi-directional many-to-one association to EspecialidadesProceso
	@OneToMany(mappedBy="usuario")
	public List<EspecialidadesProceso> getEspecialidadesProcesos() {
		return this.especialidadesProcesos;
	}

	public void setEspecialidadesProcesos(List<EspecialidadesProceso> especialidadesProcesos) {
		this.especialidadesProcesos = especialidadesProcesos;
	}

	public EspecialidadesProceso addEspecialidadesProceso(EspecialidadesProceso especialidadesProceso) {
		getEspecialidadesProcesos().add(especialidadesProceso);
		especialidadesProceso.setUsuario(this);

		return especialidadesProceso;
	}

	public EspecialidadesProceso removeEspecialidadesProceso(EspecialidadesProceso especialidadesProceso) {
		getEspecialidadesProcesos().remove(especialidadesProceso);
		especialidadesProceso.setUsuario(null);

		return especialidadesProceso;
	}


	//bi-directional many-to-one association to EspecialidadesProcesoEnlatado
	@OneToMany(mappedBy="usuario")
	public List<EspecialidadesProcesoEnlatado> getEspecialidadesProcesoEnlatados() {
		return this.especialidadesProcesoEnlatados;
	}

	public void setEspecialidadesProcesoEnlatados(List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados) {
		this.especialidadesProcesoEnlatados = especialidadesProcesoEnlatados;
	}

	public EspecialidadesProcesoEnlatado addEspecialidadesProcesoEnlatado(EspecialidadesProcesoEnlatado especialidadesProcesoEnlatado) {
		getEspecialidadesProcesoEnlatados().add(especialidadesProcesoEnlatado);
		especialidadesProcesoEnlatado.setUsuario(this);

		return especialidadesProcesoEnlatado;
	}

	public EspecialidadesProcesoEnlatado removeEspecialidadesProcesoEnlatado(EspecialidadesProcesoEnlatado especialidadesProcesoEnlatado) {
		getEspecialidadesProcesoEnlatados().remove(especialidadesProcesoEnlatado);
		especialidadesProcesoEnlatado.setUsuario(null);

		return especialidadesProcesoEnlatado;
	}


	//bi-directional many-to-one association to EstandarEficienciaKilosPagoPlexus
	@OneToMany(mappedBy="usuario1")
	public List<EstandarEficienciaKilosPagoPlexus> getEstandarEficienciaKilosPagoPlexuses1() {
		return this.estandarEficienciaKilosPagoPlexuses1;
	}

	public void setEstandarEficienciaKilosPagoPlexuses1(List<EstandarEficienciaKilosPagoPlexus> estandarEficienciaKilosPagoPlexuses1) {
		this.estandarEficienciaKilosPagoPlexuses1 = estandarEficienciaKilosPagoPlexuses1;
	}

	public EstandarEficienciaKilosPagoPlexus addEstandarEficienciaKilosPagoPlexuses1(EstandarEficienciaKilosPagoPlexus estandarEficienciaKilosPagoPlexuses1) {
		getEstandarEficienciaKilosPagoPlexuses1().add(estandarEficienciaKilosPagoPlexuses1);
		estandarEficienciaKilosPagoPlexuses1.setUsuario1(this);

		return estandarEficienciaKilosPagoPlexuses1;
	}

	public EstandarEficienciaKilosPagoPlexus removeEstandarEficienciaKilosPagoPlexuses1(EstandarEficienciaKilosPagoPlexus estandarEficienciaKilosPagoPlexuses1) {
		getEstandarEficienciaKilosPagoPlexuses1().remove(estandarEficienciaKilosPagoPlexuses1);
		estandarEficienciaKilosPagoPlexuses1.setUsuario1(null);

		return estandarEficienciaKilosPagoPlexuses1;
	}


	//bi-directional many-to-one association to EstandarEficienciaKilosPagoPlexus
	@OneToMany(mappedBy="usuario2")
	public List<EstandarEficienciaKilosPagoPlexus> getEstandarEficienciaKilosPagoPlexuses2() {
		return this.estandarEficienciaKilosPagoPlexuses2;
	}

	public void setEstandarEficienciaKilosPagoPlexuses2(List<EstandarEficienciaKilosPagoPlexus> estandarEficienciaKilosPagoPlexuses2) {
		this.estandarEficienciaKilosPagoPlexuses2 = estandarEficienciaKilosPagoPlexuses2;
	}

	public EstandarEficienciaKilosPagoPlexus addEstandarEficienciaKilosPagoPlexuses2(EstandarEficienciaKilosPagoPlexus estandarEficienciaKilosPagoPlexuses2) {
		getEstandarEficienciaKilosPagoPlexuses2().add(estandarEficienciaKilosPagoPlexuses2);
		estandarEficienciaKilosPagoPlexuses2.setUsuario2(this);

		return estandarEficienciaKilosPagoPlexuses2;
	}

	public EstandarEficienciaKilosPagoPlexus removeEstandarEficienciaKilosPagoPlexuses2(EstandarEficienciaKilosPagoPlexus estandarEficienciaKilosPagoPlexuses2) {
		getEstandarEficienciaKilosPagoPlexuses2().remove(estandarEficienciaKilosPagoPlexuses2);
		estandarEficienciaKilosPagoPlexuses2.setUsuario2(null);

		return estandarEficienciaKilosPagoPlexuses2;
	}


	//bi-directional many-to-one association to EstandarEficienciaKilosPlexus
	@OneToMany(mappedBy="usuario1")
	public List<EstandarEficienciaKilosPlexus> getEstandarEficienciaKilosPlexuses1() {
		return this.estandarEficienciaKilosPlexuses1;
	}

	public void setEstandarEficienciaKilosPlexuses1(List<EstandarEficienciaKilosPlexus> estandarEficienciaKilosPlexuses1) {
		this.estandarEficienciaKilosPlexuses1 = estandarEficienciaKilosPlexuses1;
	}

	public EstandarEficienciaKilosPlexus addEstandarEficienciaKilosPlexuses1(EstandarEficienciaKilosPlexus estandarEficienciaKilosPlexuses1) {
		getEstandarEficienciaKilosPlexuses1().add(estandarEficienciaKilosPlexuses1);
		estandarEficienciaKilosPlexuses1.setUsuario1(this);

		return estandarEficienciaKilosPlexuses1;
	}

	public EstandarEficienciaKilosPlexus removeEstandarEficienciaKilosPlexuses1(EstandarEficienciaKilosPlexus estandarEficienciaKilosPlexuses1) {
		getEstandarEficienciaKilosPlexuses1().remove(estandarEficienciaKilosPlexuses1);
		estandarEficienciaKilosPlexuses1.setUsuario1(null);

		return estandarEficienciaKilosPlexuses1;
	}


	//bi-directional many-to-one association to EstandarEficienciaKilosPlexus
	@OneToMany(mappedBy="usuario2")
	public List<EstandarEficienciaKilosPlexus> getEstandarEficienciaKilosPlexuses2() {
		return this.estandarEficienciaKilosPlexuses2;
	}

	public void setEstandarEficienciaKilosPlexuses2(List<EstandarEficienciaKilosPlexus> estandarEficienciaKilosPlexuses2) {
		this.estandarEficienciaKilosPlexuses2 = estandarEficienciaKilosPlexuses2;
	}

	public EstandarEficienciaKilosPlexus addEstandarEficienciaKilosPlexuses2(EstandarEficienciaKilosPlexus estandarEficienciaKilosPlexuses2) {
		getEstandarEficienciaKilosPlexuses2().add(estandarEficienciaKilosPlexuses2);
		estandarEficienciaKilosPlexuses2.setUsuario2(this);

		return estandarEficienciaKilosPlexuses2;
	}

	public EstandarEficienciaKilosPlexus removeEstandarEficienciaKilosPlexuses2(EstandarEficienciaKilosPlexus estandarEficienciaKilosPlexuses2) {
		getEstandarEficienciaKilosPlexuses2().remove(estandarEficienciaKilosPlexuses2);
		estandarEficienciaKilosPlexuses2.setUsuario2(null);

		return estandarEficienciaKilosPlexuses2;
	}


	//bi-directional many-to-one association to EvisceradoAuditoriaReimpresion
	@OneToMany(mappedBy="usuario")
	public List<EvisceradoAuditoriaReimpresion> getEvisceradoAuditoriaReimpresions() {
		return this.evisceradoAuditoriaReimpresions;
	}

	public void setEvisceradoAuditoriaReimpresions(List<EvisceradoAuditoriaReimpresion> evisceradoAuditoriaReimpresions) {
		this.evisceradoAuditoriaReimpresions = evisceradoAuditoriaReimpresions;
	}

	public EvisceradoAuditoriaReimpresion addEvisceradoAuditoriaReimpresion(EvisceradoAuditoriaReimpresion evisceradoAuditoriaReimpresion) {
		getEvisceradoAuditoriaReimpresions().add(evisceradoAuditoriaReimpresion);
		evisceradoAuditoriaReimpresion.setUsuario(this);

		return evisceradoAuditoriaReimpresion;
	}

	public EvisceradoAuditoriaReimpresion removeEvisceradoAuditoriaReimpresion(EvisceradoAuditoriaReimpresion evisceradoAuditoriaReimpresion) {
		getEvisceradoAuditoriaReimpresions().remove(evisceradoAuditoriaReimpresion);
		evisceradoAuditoriaReimpresion.setUsuario(null);

		return evisceradoAuditoriaReimpresion;
	}


	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="usuario1")
	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions1() {
		return this.evisceradoCocheModificacions1;
	}

	public void setEvisceradoCocheModificacions1(List<EvisceradoCocheModificacion> evisceradoCocheModificacions1) {
		this.evisceradoCocheModificacions1 = evisceradoCocheModificacions1;
	}

	public EvisceradoCocheModificacion addEvisceradoCocheModificacions1(EvisceradoCocheModificacion evisceradoCocheModificacions1) {
		getEvisceradoCocheModificacions1().add(evisceradoCocheModificacions1);
		evisceradoCocheModificacions1.setUsuario1(this);

		return evisceradoCocheModificacions1;
	}

	public EvisceradoCocheModificacion removeEvisceradoCocheModificacions1(EvisceradoCocheModificacion evisceradoCocheModificacions1) {
		getEvisceradoCocheModificacions1().remove(evisceradoCocheModificacions1);
		evisceradoCocheModificacions1.setUsuario1(null);

		return evisceradoCocheModificacions1;
	}


	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="usuario2")
	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions2() {
		return this.evisceradoCocheModificacions2;
	}

	public void setEvisceradoCocheModificacions2(List<EvisceradoCocheModificacion> evisceradoCocheModificacions2) {
		this.evisceradoCocheModificacions2 = evisceradoCocheModificacions2;
	}

	public EvisceradoCocheModificacion addEvisceradoCocheModificacions2(EvisceradoCocheModificacion evisceradoCocheModificacions2) {
		getEvisceradoCocheModificacions2().add(evisceradoCocheModificacions2);
		evisceradoCocheModificacions2.setUsuario2(this);

		return evisceradoCocheModificacions2;
	}

	public EvisceradoCocheModificacion removeEvisceradoCocheModificacions2(EvisceradoCocheModificacion evisceradoCocheModificacions2) {
		getEvisceradoCocheModificacions2().remove(evisceradoCocheModificacions2);
		evisceradoCocheModificacions2.setUsuario2(null);

		return evisceradoCocheModificacions2;
	}


	//bi-directional many-to-one association to EvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	public List<EvisceradoDetalleMuestreoTempCoche> getEvisceradoDetalleMuestreoTempCoches() {
		return this.evisceradoDetalleMuestreoTempCoches;
	}

	public void setEvisceradoDetalleMuestreoTempCoches(List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches) {
		this.evisceradoDetalleMuestreoTempCoches = evisceradoDetalleMuestreoTempCoches;
	}

	public EvisceradoDetalleMuestreoTempCoche addEvisceradoDetalleMuestreoTempCoch(EvisceradoDetalleMuestreoTempCoche evisceradoDetalleMuestreoTempCoch) {
		getEvisceradoDetalleMuestreoTempCoches().add(evisceradoDetalleMuestreoTempCoch);
		evisceradoDetalleMuestreoTempCoch.setUsuario(this);

		return evisceradoDetalleMuestreoTempCoch;
	}

	public EvisceradoDetalleMuestreoTempCoche removeEvisceradoDetalleMuestreoTempCoch(EvisceradoDetalleMuestreoTempCoche evisceradoDetalleMuestreoTempCoch) {
		getEvisceradoDetalleMuestreoTempCoches().remove(evisceradoDetalleMuestreoTempCoch);
		evisceradoDetalleMuestreoTempCoch.setUsuario(null);

		return evisceradoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@OneToMany(mappedBy="usuario")
	public List<EvisceradoDetalleProceso> getEvisceradoDetalleProcesos() {
		return this.evisceradoDetalleProcesos;
	}

	public void setEvisceradoDetalleProcesos(List<EvisceradoDetalleProceso> evisceradoDetalleProcesos) {
		this.evisceradoDetalleProcesos = evisceradoDetalleProcesos;
	}

	public EvisceradoDetalleProceso addEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		getEvisceradoDetalleProcesos().add(evisceradoDetalleProceso);
		evisceradoDetalleProceso.setUsuario(this);

		return evisceradoDetalleProceso;
	}

	public EvisceradoDetalleProceso removeEvisceradoDetalleProceso(EvisceradoDetalleProceso evisceradoDetalleProceso) {
		getEvisceradoDetalleProcesos().remove(evisceradoDetalleProceso);
		evisceradoDetalleProceso.setUsuario(null);

		return evisceradoDetalleProceso;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public EvisceradoDetalleProcesoCoche addEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().add(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setUsuario(this);

		return evisceradoDetalleProcesoCoch;
	}

	public EvisceradoDetalleProcesoCoche removeEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().remove(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setUsuario(null);

		return evisceradoDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoModificacion
	@OneToMany(mappedBy="usuario")
	public List<EvisceradoDetalleProcesoModificacion> getEvisceradoDetalleProcesoModificacions() {
		return this.evisceradoDetalleProcesoModificacions;
	}

	public void setEvisceradoDetalleProcesoModificacions(List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions) {
		this.evisceradoDetalleProcesoModificacions = evisceradoDetalleProcesoModificacions;
	}

	public EvisceradoDetalleProcesoModificacion addEvisceradoDetalleProcesoModificacion(EvisceradoDetalleProcesoModificacion evisceradoDetalleProcesoModificacion) {
		getEvisceradoDetalleProcesoModificacions().add(evisceradoDetalleProcesoModificacion);
		evisceradoDetalleProcesoModificacion.setUsuario(this);

		return evisceradoDetalleProcesoModificacion;
	}

	public EvisceradoDetalleProcesoModificacion removeEvisceradoDetalleProcesoModificacion(EvisceradoDetalleProcesoModificacion evisceradoDetalleProcesoModificacion) {
		getEvisceradoDetalleProcesoModificacions().remove(evisceradoDetalleProcesoModificacion);
		evisceradoDetalleProcesoModificacion.setUsuario(null);

		return evisceradoDetalleProcesoModificacion;
	}


	//bi-directional many-to-one association to EvisceradoMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	public List<EvisceradoMuestreoTempCoche> getEvisceradoMuestreoTempCoches() {
		return this.evisceradoMuestreoTempCoches;
	}

	public void setEvisceradoMuestreoTempCoches(List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches) {
		this.evisceradoMuestreoTempCoches = evisceradoMuestreoTempCoches;
	}

	public EvisceradoMuestreoTempCoche addEvisceradoMuestreoTempCoch(EvisceradoMuestreoTempCoche evisceradoMuestreoTempCoch) {
		getEvisceradoMuestreoTempCoches().add(evisceradoMuestreoTempCoch);
		evisceradoMuestreoTempCoch.setUsuario(this);

		return evisceradoMuestreoTempCoch;
	}

	public EvisceradoMuestreoTempCoche removeEvisceradoMuestreoTempCoch(EvisceradoMuestreoTempCoche evisceradoMuestreoTempCoch) {
		getEvisceradoMuestreoTempCoches().remove(evisceradoMuestreoTempCoch);
		evisceradoMuestreoTempCoch.setUsuario(null);

		return evisceradoMuestreoTempCoch;
	}


	//bi-directional many-to-one association to EvisceradoRackeoLote
	@OneToMany(mappedBy="usuario")
	public List<EvisceradoRackeoLote> getEvisceradoRackeoLotes() {
		return this.evisceradoRackeoLotes;
	}

	public void setEvisceradoRackeoLotes(List<EvisceradoRackeoLote> evisceradoRackeoLotes) {
		this.evisceradoRackeoLotes = evisceradoRackeoLotes;
	}

	public EvisceradoRackeoLote addEvisceradoRackeoLote(EvisceradoRackeoLote evisceradoRackeoLote) {
		getEvisceradoRackeoLotes().add(evisceradoRackeoLote);
		evisceradoRackeoLote.setUsuario(this);

		return evisceradoRackeoLote;
	}

	public EvisceradoRackeoLote removeEvisceradoRackeoLote(EvisceradoRackeoLote evisceradoRackeoLote) {
		getEvisceradoRackeoLotes().remove(evisceradoRackeoLote);
		evisceradoRackeoLote.setUsuario(null);

		return evisceradoRackeoLote;
	}


	//bi-directional many-to-one association to EvisceradoReanudacionSecCoche
	@OneToMany(mappedBy="usuario")
	public List<EvisceradoReanudacionSecCoche> getEvisceradoReanudacionSecCoches() {
		return this.evisceradoReanudacionSecCoches;
	}

	public void setEvisceradoReanudacionSecCoches(List<EvisceradoReanudacionSecCoche> evisceradoReanudacionSecCoches) {
		this.evisceradoReanudacionSecCoches = evisceradoReanudacionSecCoches;
	}

	public EvisceradoReanudacionSecCoche addEvisceradoReanudacionSecCoch(EvisceradoReanudacionSecCoche evisceradoReanudacionSecCoch) {
		getEvisceradoReanudacionSecCoches().add(evisceradoReanudacionSecCoch);
		evisceradoReanudacionSecCoch.setUsuario(this);

		return evisceradoReanudacionSecCoch;
	}

	public EvisceradoReanudacionSecCoche removeEvisceradoReanudacionSecCoch(EvisceradoReanudacionSecCoche evisceradoReanudacionSecCoch) {
		getEvisceradoReanudacionSecCoches().remove(evisceradoReanudacionSecCoch);
		evisceradoReanudacionSecCoch.setUsuario(null);

		return evisceradoReanudacionSecCoch;
	}


	//bi-directional many-to-one association to EvisceradoSubproductoCrudo
	@OneToMany(mappedBy="usuario")
	public List<EvisceradoSubproductoCrudo> getEvisceradoSubproductoCrudos() {
		return this.evisceradoSubproductoCrudos;
	}

	public void setEvisceradoSubproductoCrudos(List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos) {
		this.evisceradoSubproductoCrudos = evisceradoSubproductoCrudos;
	}

	public EvisceradoSubproductoCrudo addEvisceradoSubproductoCrudo(EvisceradoSubproductoCrudo evisceradoSubproductoCrudo) {
		getEvisceradoSubproductoCrudos().add(evisceradoSubproductoCrudo);
		evisceradoSubproductoCrudo.setUsuario(this);

		return evisceradoSubproductoCrudo;
	}

	public EvisceradoSubproductoCrudo removeEvisceradoSubproductoCrudo(EvisceradoSubproductoCrudo evisceradoSubproductoCrudo) {
		getEvisceradoSubproductoCrudos().remove(evisceradoSubproductoCrudo);
		evisceradoSubproductoCrudo.setUsuario(null);

		return evisceradoSubproductoCrudo;
	}


	//bi-directional many-to-one association to EvolutionAuditoriaDetalle
	@OneToMany(mappedBy="usuario")
	public List<EvolutionAuditoriaDetalle> getEvolutionAuditoriaDetalles() {
		return this.evolutionAuditoriaDetalles;
	}

	public void setEvolutionAuditoriaDetalles(List<EvolutionAuditoriaDetalle> evolutionAuditoriaDetalles) {
		this.evolutionAuditoriaDetalles = evolutionAuditoriaDetalles;
	}

	public EvolutionAuditoriaDetalle addEvolutionAuditoriaDetalle(EvolutionAuditoriaDetalle evolutionAuditoriaDetalle) {
		getEvolutionAuditoriaDetalles().add(evolutionAuditoriaDetalle);
		evolutionAuditoriaDetalle.setUsuario(this);

		return evolutionAuditoriaDetalle;
	}

	public EvolutionAuditoriaDetalle removeEvolutionAuditoriaDetalle(EvolutionAuditoriaDetalle evolutionAuditoriaDetalle) {
		getEvolutionAuditoriaDetalles().remove(evolutionAuditoriaDetalle);
		evolutionAuditoriaDetalle.setUsuario(null);

		return evolutionAuditoriaDetalle;
	}


	//bi-directional many-to-one association to GestionTurno
	@OneToMany(mappedBy="usuario")
	public List<GestionTurno> getGestionTurnos() {
		return this.gestionTurnos;
	}

	public void setGestionTurnos(List<GestionTurno> gestionTurnos) {
		this.gestionTurnos = gestionTurnos;
	}

	public GestionTurno addGestionTurno(GestionTurno gestionTurno) {
		getGestionTurnos().add(gestionTurno);
		gestionTurno.setUsuario(this);

		return gestionTurno;
	}

	public GestionTurno removeGestionTurno(GestionTurno gestionTurno) {
		getGestionTurnos().remove(gestionTurno);
		gestionTurno.setUsuario(null);

		return gestionTurno;
	}


	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="usuario")
	public List<HarinaRecepcionDetallePescaComprobante> getHarinaRecepcionDetallePescaComprobantes() {
		return this.harinaRecepcionDetallePescaComprobantes;
	}

	public void setHarinaRecepcionDetallePescaComprobantes(List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes) {
		this.harinaRecepcionDetallePescaComprobantes = harinaRecepcionDetallePescaComprobantes;
	}

	public HarinaRecepcionDetallePescaComprobante addHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		getHarinaRecepcionDetallePescaComprobantes().add(harinaRecepcionDetallePescaComprobante);
		harinaRecepcionDetallePescaComprobante.setUsuario(this);

		return harinaRecepcionDetallePescaComprobante;
	}

	public HarinaRecepcionDetallePescaComprobante removeHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		getHarinaRecepcionDetallePescaComprobantes().remove(harinaRecepcionDetallePescaComprobante);
		harinaRecepcionDetallePescaComprobante.setUsuario(null);

		return harinaRecepcionDetallePescaComprobante;
	}


	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@OneToMany(mappedBy="usuario")
	public List<HarinaRecepcionPescaComprobante> getHarinaRecepcionPescaComprobantes() {
		return this.harinaRecepcionPescaComprobantes;
	}

	public void setHarinaRecepcionPescaComprobantes(List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes) {
		this.harinaRecepcionPescaComprobantes = harinaRecepcionPescaComprobantes;
	}

	public HarinaRecepcionPescaComprobante addHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		getHarinaRecepcionPescaComprobantes().add(harinaRecepcionPescaComprobante);
		harinaRecepcionPescaComprobante.setUsuario(this);

		return harinaRecepcionPescaComprobante;
	}

	public HarinaRecepcionPescaComprobante removeHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		getHarinaRecepcionPescaComprobantes().remove(harinaRecepcionPescaComprobante);
		harinaRecepcionPescaComprobante.setUsuario(null);

		return harinaRecepcionPescaComprobante;
	}


	//bi-directional many-to-one association to ImpresionDetalle
	@OneToMany(mappedBy="usuario")
	public List<ImpresionDetalle> getImpresionDetalles() {
		return this.impresionDetalles;
	}

	public void setImpresionDetalles(List<ImpresionDetalle> impresionDetalles) {
		this.impresionDetalles = impresionDetalles;
	}

	public ImpresionDetalle addImpresionDetalle(ImpresionDetalle impresionDetalle) {
		getImpresionDetalles().add(impresionDetalle);
		impresionDetalle.setUsuario(this);

		return impresionDetalle;
	}

	public ImpresionDetalle removeImpresionDetalle(ImpresionDetalle impresionDetalle) {
		getImpresionDetalles().remove(impresionDetalle);
		impresionDetalle.setUsuario(null);

		return impresionDetalle;
	}


	//bi-directional many-to-one association to LimpiezaAsignacionCanastilla
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaAsignacionCanastilla> getLimpiezaAsignacionCanastillas() {
		return this.limpiezaAsignacionCanastillas;
	}

	public void setLimpiezaAsignacionCanastillas(List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas) {
		this.limpiezaAsignacionCanastillas = limpiezaAsignacionCanastillas;
	}

	public LimpiezaAsignacionCanastilla addLimpiezaAsignacionCanastilla(LimpiezaAsignacionCanastilla limpiezaAsignacionCanastilla) {
		getLimpiezaAsignacionCanastillas().add(limpiezaAsignacionCanastilla);
		limpiezaAsignacionCanastilla.setUsuario(this);

		return limpiezaAsignacionCanastilla;
	}

	public LimpiezaAsignacionCanastilla removeLimpiezaAsignacionCanastilla(LimpiezaAsignacionCanastilla limpiezaAsignacionCanastilla) {
		getLimpiezaAsignacionCanastillas().remove(limpiezaAsignacionCanastilla);
		limpiezaAsignacionCanastilla.setUsuario(null);

		return limpiezaAsignacionCanastilla;
	}


	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlanta
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaCabeceraCortesPlanta> getLimpiezaCabeceraCortesPlantas() {
		return this.limpiezaCabeceraCortesPlantas;
	}

	public void setLimpiezaCabeceraCortesPlantas(List<LimpiezaCabeceraCortesPlanta> limpiezaCabeceraCortesPlantas) {
		this.limpiezaCabeceraCortesPlantas = limpiezaCabeceraCortesPlantas;
	}

	public LimpiezaCabeceraCortesPlanta addLimpiezaCabeceraCortesPlanta(LimpiezaCabeceraCortesPlanta limpiezaCabeceraCortesPlanta) {
		getLimpiezaCabeceraCortesPlantas().add(limpiezaCabeceraCortesPlanta);
		limpiezaCabeceraCortesPlanta.setUsuario(this);

		return limpiezaCabeceraCortesPlanta;
	}

	public LimpiezaCabeceraCortesPlanta removeLimpiezaCabeceraCortesPlanta(LimpiezaCabeceraCortesPlanta limpiezaCabeceraCortesPlanta) {
		getLimpiezaCabeceraCortesPlantas().remove(limpiezaCabeceraCortesPlanta);
		limpiezaCabeceraCortesPlanta.setUsuario(null);

		return limpiezaCabeceraCortesPlanta;
	}


	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlantaLineaEmpleado
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaCabeceraCortesPlantaLineaEmpleado> getLimpiezaCabeceraCortesPlantaLineaEmpleados() {
		return this.limpiezaCabeceraCortesPlantaLineaEmpleados;
	}

	public void setLimpiezaCabeceraCortesPlantaLineaEmpleados(List<LimpiezaCabeceraCortesPlantaLineaEmpleado> limpiezaCabeceraCortesPlantaLineaEmpleados) {
		this.limpiezaCabeceraCortesPlantaLineaEmpleados = limpiezaCabeceraCortesPlantaLineaEmpleados;
	}

	public LimpiezaCabeceraCortesPlantaLineaEmpleado addLimpiezaCabeceraCortesPlantaLineaEmpleado(LimpiezaCabeceraCortesPlantaLineaEmpleado limpiezaCabeceraCortesPlantaLineaEmpleado) {
		getLimpiezaCabeceraCortesPlantaLineaEmpleados().add(limpiezaCabeceraCortesPlantaLineaEmpleado);
		limpiezaCabeceraCortesPlantaLineaEmpleado.setUsuario(this);

		return limpiezaCabeceraCortesPlantaLineaEmpleado;
	}

	public LimpiezaCabeceraCortesPlantaLineaEmpleado removeLimpiezaCabeceraCortesPlantaLineaEmpleado(LimpiezaCabeceraCortesPlantaLineaEmpleado limpiezaCabeceraCortesPlantaLineaEmpleado) {
		getLimpiezaCabeceraCortesPlantaLineaEmpleados().remove(limpiezaCabeceraCortesPlantaLineaEmpleado);
		limpiezaCabeceraCortesPlantaLineaEmpleado.setUsuario(null);

		return limpiezaCabeceraCortesPlantaLineaEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public LimpiezaCalidadDetalleProcesoBandeja addLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().add(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setUsuario(this);

		return limpiezaCalidadDetalleProcesoBandeja;
	}

	public LimpiezaCalidadDetalleProcesoBandeja removeLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().remove(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setUsuario(null);

		return limpiezaCalidadDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="usuario1")
	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions1() {
		return this.limpiezaCocheModificacions1;
	}

	public void setLimpiezaCocheModificacions1(List<LimpiezaCocheModificacion> limpiezaCocheModificacions1) {
		this.limpiezaCocheModificacions1 = limpiezaCocheModificacions1;
	}

	public LimpiezaCocheModificacion addLimpiezaCocheModificacions1(LimpiezaCocheModificacion limpiezaCocheModificacions1) {
		getLimpiezaCocheModificacions1().add(limpiezaCocheModificacions1);
		limpiezaCocheModificacions1.setUsuario1(this);

		return limpiezaCocheModificacions1;
	}

	public LimpiezaCocheModificacion removeLimpiezaCocheModificacions1(LimpiezaCocheModificacion limpiezaCocheModificacions1) {
		getLimpiezaCocheModificacions1().remove(limpiezaCocheModificacions1);
		limpiezaCocheModificacions1.setUsuario1(null);

		return limpiezaCocheModificacions1;
	}


	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="usuario2")
	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions2() {
		return this.limpiezaCocheModificacions2;
	}

	public void setLimpiezaCocheModificacions2(List<LimpiezaCocheModificacion> limpiezaCocheModificacions2) {
		this.limpiezaCocheModificacions2 = limpiezaCocheModificacions2;
	}

	public LimpiezaCocheModificacion addLimpiezaCocheModificacions2(LimpiezaCocheModificacion limpiezaCocheModificacions2) {
		getLimpiezaCocheModificacions2().add(limpiezaCocheModificacions2);
		limpiezaCocheModificacions2.setUsuario2(this);

		return limpiezaCocheModificacions2;
	}

	public LimpiezaCocheModificacion removeLimpiezaCocheModificacions2(LimpiezaCocheModificacion limpiezaCocheModificacions2) {
		getLimpiezaCocheModificacions2().remove(limpiezaCocheModificacions2);
		limpiezaCocheModificacions2.setUsuario2(null);

		return limpiezaCocheModificacions2;
	}


	//bi-directional many-to-one association to LimpiezaCocheObservacione
	@OneToMany(mappedBy="usuario1")
	public List<LimpiezaCocheObservacione> getLimpiezaCocheObservaciones1() {
		return this.limpiezaCocheObservaciones1;
	}

	public void setLimpiezaCocheObservaciones1(List<LimpiezaCocheObservacione> limpiezaCocheObservaciones1) {
		this.limpiezaCocheObservaciones1 = limpiezaCocheObservaciones1;
	}

	public LimpiezaCocheObservacione addLimpiezaCocheObservaciones1(LimpiezaCocheObservacione limpiezaCocheObservaciones1) {
		getLimpiezaCocheObservaciones1().add(limpiezaCocheObservaciones1);
		limpiezaCocheObservaciones1.setUsuario1(this);

		return limpiezaCocheObservaciones1;
	}

	public LimpiezaCocheObservacione removeLimpiezaCocheObservaciones1(LimpiezaCocheObservacione limpiezaCocheObservaciones1) {
		getLimpiezaCocheObservaciones1().remove(limpiezaCocheObservaciones1);
		limpiezaCocheObservaciones1.setUsuario1(null);

		return limpiezaCocheObservaciones1;
	}


	//bi-directional many-to-one association to LimpiezaCocheObservacione
	@OneToMany(mappedBy="usuario2")
	public List<LimpiezaCocheObservacione> getLimpiezaCocheObservaciones2() {
		return this.limpiezaCocheObservaciones2;
	}

	public void setLimpiezaCocheObservaciones2(List<LimpiezaCocheObservacione> limpiezaCocheObservaciones2) {
		this.limpiezaCocheObservaciones2 = limpiezaCocheObservaciones2;
	}

	public LimpiezaCocheObservacione addLimpiezaCocheObservaciones2(LimpiezaCocheObservacione limpiezaCocheObservaciones2) {
		getLimpiezaCocheObservaciones2().add(limpiezaCocheObservaciones2);
		limpiezaCocheObservaciones2.setUsuario2(this);

		return limpiezaCocheObservaciones2;
	}

	public LimpiezaCocheObservacione removeLimpiezaCocheObservaciones2(LimpiezaCocheObservacione limpiezaCocheObservaciones2) {
		getLimpiezaCocheObservaciones2().remove(limpiezaCocheObservaciones2);
		limpiezaCocheObservaciones2.setUsuario2(null);

		return limpiezaCocheObservaciones2;
	}


	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public LimpiezaDespellejadoPonchada addLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().add(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setUsuario(this);

		return limpiezaDespellejadoPonchada;
	}

	public LimpiezaDespellejadoPonchada removeLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().remove(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setUsuario(null);

		return limpiezaDespellejadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaDetalleCortesPlantaLineaEmpleado
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetalleCortesPlantaLineaEmpleado> getLimpiezaDetalleCortesPlantaLineaEmpleados() {
		return this.limpiezaDetalleCortesPlantaLineaEmpleados;
	}

	public void setLimpiezaDetalleCortesPlantaLineaEmpleados(List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados) {
		this.limpiezaDetalleCortesPlantaLineaEmpleados = limpiezaDetalleCortesPlantaLineaEmpleados;
	}

	public LimpiezaDetalleCortesPlantaLineaEmpleado addLimpiezaDetalleCortesPlantaLineaEmpleado(LimpiezaDetalleCortesPlantaLineaEmpleado limpiezaDetalleCortesPlantaLineaEmpleado) {
		getLimpiezaDetalleCortesPlantaLineaEmpleados().add(limpiezaDetalleCortesPlantaLineaEmpleado);
		limpiezaDetalleCortesPlantaLineaEmpleado.setUsuario(this);

		return limpiezaDetalleCortesPlantaLineaEmpleado;
	}

	public LimpiezaDetalleCortesPlantaLineaEmpleado removeLimpiezaDetalleCortesPlantaLineaEmpleado(LimpiezaDetalleCortesPlantaLineaEmpleado limpiezaDetalleCortesPlantaLineaEmpleado) {
		getLimpiezaDetalleCortesPlantaLineaEmpleados().remove(limpiezaDetalleCortesPlantaLineaEmpleado);
		limpiezaDetalleCortesPlantaLineaEmpleado.setUsuario(null);

		return limpiezaDetalleCortesPlantaLineaEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaDetalleDesperdicio
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetalleDesperdicio> getLimpiezaDetalleDesperdicios() {
		return this.limpiezaDetalleDesperdicios;
	}

	public void setLimpiezaDetalleDesperdicios(List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios) {
		this.limpiezaDetalleDesperdicios = limpiezaDetalleDesperdicios;
	}

	public LimpiezaDetalleDesperdicio addLimpiezaDetalleDesperdicio(LimpiezaDetalleDesperdicio limpiezaDetalleDesperdicio) {
		getLimpiezaDetalleDesperdicios().add(limpiezaDetalleDesperdicio);
		limpiezaDetalleDesperdicio.setUsuario(this);

		return limpiezaDetalleDesperdicio;
	}

	public LimpiezaDetalleDesperdicio removeLimpiezaDetalleDesperdicio(LimpiezaDetalleDesperdicio limpiezaDetalleDesperdicio) {
		getLimpiezaDetalleDesperdicios().remove(limpiezaDetalleDesperdicio);
		limpiezaDetalleDesperdicio.setUsuario(null);

		return limpiezaDetalleDesperdicio;
	}


	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejado
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetallePesoDespellejado> getLimpiezaDetallePesoDespellejados() {
		return this.limpiezaDetallePesoDespellejados;
	}

	public void setLimpiezaDetallePesoDespellejados(List<LimpiezaDetallePesoDespellejado> limpiezaDetallePesoDespellejados) {
		this.limpiezaDetallePesoDespellejados = limpiezaDetallePesoDespellejados;
	}

	public LimpiezaDetallePesoDespellejado addLimpiezaDetallePesoDespellejado(LimpiezaDetallePesoDespellejado limpiezaDetallePesoDespellejado) {
		getLimpiezaDetallePesoDespellejados().add(limpiezaDetallePesoDespellejado);
		limpiezaDetallePesoDespellejado.setUsuario(this);

		return limpiezaDetallePesoDespellejado;
	}

	public LimpiezaDetallePesoDespellejado removeLimpiezaDetallePesoDespellejado(LimpiezaDetallePesoDespellejado limpiezaDetallePesoDespellejado) {
		getLimpiezaDetallePesoDespellejados().remove(limpiezaDetallePesoDespellejado);
		limpiezaDetallePesoDespellejado.setUsuario(null);

		return limpiezaDetallePesoDespellejado;
	}


	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejadoT
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetallePesoDespellejadoT> getLimpiezaDetallePesoDespellejadoTs() {
		return this.limpiezaDetallePesoDespellejadoTs;
	}

	public void setLimpiezaDetallePesoDespellejadoTs(List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs) {
		this.limpiezaDetallePesoDespellejadoTs = limpiezaDetallePesoDespellejadoTs;
	}

	public LimpiezaDetallePesoDespellejadoT addLimpiezaDetallePesoDespellejadoT(LimpiezaDetallePesoDespellejadoT limpiezaDetallePesoDespellejadoT) {
		getLimpiezaDetallePesoDespellejadoTs().add(limpiezaDetallePesoDespellejadoT);
		limpiezaDetallePesoDespellejadoT.setUsuario(this);

		return limpiezaDetallePesoDespellejadoT;
	}

	public LimpiezaDetallePesoDespellejadoT removeLimpiezaDetallePesoDespellejadoT(LimpiezaDetallePesoDespellejadoT limpiezaDetallePesoDespellejadoT) {
		getLimpiezaDetallePesoDespellejadoTs().remove(limpiezaDetallePesoDespellejadoT);
		limpiezaDetallePesoDespellejadoT.setUsuario(null);

		return limpiezaDetallePesoDespellejadoT;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public LimpiezaDetalleProcesoBandeja addLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().add(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setUsuario(this);

		return limpiezaDetalleProcesoBandeja;
	}

	public LimpiezaDetalleProcesoBandeja removeLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().remove(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setUsuario(null);

		return limpiezaDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions() {
		return this.limpiezaDetalleProcesoBandejaAprobacions;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions) {
		this.limpiezaDetalleProcesoBandejaAprobacions = limpiezaDetalleProcesoBandejaAprobacions;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion addLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().add(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setUsuario(this);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion removeLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().remove(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setUsuario(null);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetalleProcesoCoche> getLimpiezaDetalleProcesoCoches() {
		return this.limpiezaDetalleProcesoCoches;
	}

	public void setLimpiezaDetalleProcesoCoches(List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches) {
		this.limpiezaDetalleProcesoCoches = limpiezaDetalleProcesoCoches;
	}

	public LimpiezaDetalleProcesoCoche addLimpiezaDetalleProcesoCoch(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoch) {
		getLimpiezaDetalleProcesoCoches().add(limpiezaDetalleProcesoCoch);
		limpiezaDetalleProcesoCoch.setUsuario(this);

		return limpiezaDetalleProcesoCoch;
	}

	public LimpiezaDetalleProcesoCoche removeLimpiezaDetalleProcesoCoch(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoch) {
		getLimpiezaDetalleProcesoCoches().remove(limpiezaDetalleProcesoCoch);
		limpiezaDetalleProcesoCoch.setUsuario(null);

		return limpiezaDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCocheTemperaturaBatch
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetalleProcesoCocheTemperaturaBatch> getLimpiezaDetalleProcesoCocheTemperaturaBatches() {
		return this.limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

	public void setLimpiezaDetalleProcesoCocheTemperaturaBatches(List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches) {
		this.limpiezaDetalleProcesoCocheTemperaturaBatches = limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

	public LimpiezaDetalleProcesoCocheTemperaturaBatch addLimpiezaDetalleProcesoCocheTemperaturaBatch(LimpiezaDetalleProcesoCocheTemperaturaBatch limpiezaDetalleProcesoCocheTemperaturaBatch) {
		getLimpiezaDetalleProcesoCocheTemperaturaBatches().add(limpiezaDetalleProcesoCocheTemperaturaBatch);
		limpiezaDetalleProcesoCocheTemperaturaBatch.setUsuario(this);

		return limpiezaDetalleProcesoCocheTemperaturaBatch;
	}

	public LimpiezaDetalleProcesoCocheTemperaturaBatch removeLimpiezaDetalleProcesoCocheTemperaturaBatch(LimpiezaDetalleProcesoCocheTemperaturaBatch limpiezaDetalleProcesoCocheTemperaturaBatch) {
		getLimpiezaDetalleProcesoCocheTemperaturaBatches().remove(limpiezaDetalleProcesoCocheTemperaturaBatch);
		limpiezaDetalleProcesoCocheTemperaturaBatch.setUsuario(null);

		return limpiezaDetalleProcesoCocheTemperaturaBatch;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetalleProcesoLote> getLimpiezaDetalleProcesoLotes() {
		return this.limpiezaDetalleProcesoLotes;
	}

	public void setLimpiezaDetalleProcesoLotes(List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes) {
		this.limpiezaDetalleProcesoLotes = limpiezaDetalleProcesoLotes;
	}

	public LimpiezaDetalleProcesoLote addLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		getLimpiezaDetalleProcesoLotes().add(limpiezaDetalleProcesoLote);
		limpiezaDetalleProcesoLote.setUsuario(this);

		return limpiezaDetalleProcesoLote;
	}

	public LimpiezaDetalleProcesoLote removeLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		getLimpiezaDetalleProcesoLotes().remove(limpiezaDetalleProcesoLote);
		limpiezaDetalleProcesoLote.setUsuario(null);

		return limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LimpiezaDetalleTipoCorte
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetalleTipoCorte> getLimpiezaDetalleTipoCortes() {
		return this.limpiezaDetalleTipoCortes;
	}

	public void setLimpiezaDetalleTipoCortes(List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes) {
		this.limpiezaDetalleTipoCortes = limpiezaDetalleTipoCortes;
	}

	public LimpiezaDetalleTipoCorte addLimpiezaDetalleTipoCorte(LimpiezaDetalleTipoCorte limpiezaDetalleTipoCorte) {
		getLimpiezaDetalleTipoCortes().add(limpiezaDetalleTipoCorte);
		limpiezaDetalleTipoCorte.setUsuario(this);

		return limpiezaDetalleTipoCorte;
	}

	public LimpiezaDetalleTipoCorte removeLimpiezaDetalleTipoCorte(LimpiezaDetalleTipoCorte limpiezaDetalleTipoCorte) {
		getLimpiezaDetalleTipoCortes().remove(limpiezaDetalleTipoCorte);
		limpiezaDetalleTipoCorte.setUsuario(null);

		return limpiezaDetalleTipoCorte;
	}


	//bi-directional many-to-one association to LimpiezaDetalleTipoPara
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaDetalleTipoPara> getLimpiezaDetalleTipoParas() {
		return this.limpiezaDetalleTipoParas;
	}

	public void setLimpiezaDetalleTipoParas(List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas) {
		this.limpiezaDetalleTipoParas = limpiezaDetalleTipoParas;
	}

	public LimpiezaDetalleTipoPara addLimpiezaDetalleTipoPara(LimpiezaDetalleTipoPara limpiezaDetalleTipoPara) {
		getLimpiezaDetalleTipoParas().add(limpiezaDetalleTipoPara);
		limpiezaDetalleTipoPara.setUsuario(this);

		return limpiezaDetalleTipoPara;
	}

	public LimpiezaDetalleTipoPara removeLimpiezaDetalleTipoPara(LimpiezaDetalleTipoPara limpiezaDetalleTipoPara) {
		getLimpiezaDetalleTipoParas().remove(limpiezaDetalleTipoPara);
		limpiezaDetalleTipoPara.setUsuario(null);

		return limpiezaDetalleTipoPara;
	}


	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public LimpiezaFileteadoPonchada addLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().add(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setUsuario(this);

		return limpiezaFileteadoPonchada;
	}

	public LimpiezaFileteadoPonchada removeLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().remove(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setUsuario(null);

		return limpiezaFileteadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaLomoLimpioCoche
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaLomoLimpioCoche> getLimpiezaLomoLimpioCoches() {
		return this.limpiezaLomoLimpioCoches;
	}

	public void setLimpiezaLomoLimpioCoches(List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches) {
		this.limpiezaLomoLimpioCoches = limpiezaLomoLimpioCoches;
	}

	public LimpiezaLomoLimpioCoche addLimpiezaLomoLimpioCoch(LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoch) {
		getLimpiezaLomoLimpioCoches().add(limpiezaLomoLimpioCoch);
		limpiezaLomoLimpioCoch.setUsuario(this);

		return limpiezaLomoLimpioCoch;
	}

	public LimpiezaLomoLimpioCoche removeLimpiezaLomoLimpioCoch(LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoch) {
		getLimpiezaLomoLimpioCoches().remove(limpiezaLomoLimpioCoch);
		limpiezaLomoLimpioCoch.setUsuario(null);

		return limpiezaLomoLimpioCoch;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
	}

	public LimpiezaProceso addLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().add(limpiezaProceso);
		limpiezaProceso.setUsuario(this);

		return limpiezaProceso;
	}

	public LimpiezaProceso removeLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().remove(limpiezaProceso);
		limpiezaProceso.setUsuario(null);

		return limpiezaProceso;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaProcesoEmpleado> getLimpiezaProcesoEmpleados() {
		return this.limpiezaProcesoEmpleados;
	}

	public void setLimpiezaProcesoEmpleados(List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados) {
		this.limpiezaProcesoEmpleados = limpiezaProcesoEmpleados;
	}

	public LimpiezaProcesoEmpleado addLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		getLimpiezaProcesoEmpleados().add(limpiezaProcesoEmpleado);
		limpiezaProcesoEmpleado.setUsuario(this);

		return limpiezaProcesoEmpleado;
	}

	public LimpiezaProcesoEmpleado removeLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		getLimpiezaProcesoEmpleados().remove(limpiezaProcesoEmpleado);
		limpiezaProcesoEmpleado.setUsuario(null);

		return limpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento addLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().add(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setUsuario(this);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento removeLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().remove(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setUsuario(null);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoFalta
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaProcesoEmpleadoFalta> getLimpiezaProcesoEmpleadoFaltas() {
		return this.limpiezaProcesoEmpleadoFaltas;
	}

	public void setLimpiezaProcesoEmpleadoFaltas(List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas) {
		this.limpiezaProcesoEmpleadoFaltas = limpiezaProcesoEmpleadoFaltas;
	}

	public LimpiezaProcesoEmpleadoFalta addLimpiezaProcesoEmpleadoFalta(LimpiezaProcesoEmpleadoFalta limpiezaProcesoEmpleadoFalta) {
		getLimpiezaProcesoEmpleadoFaltas().add(limpiezaProcesoEmpleadoFalta);
		limpiezaProcesoEmpleadoFalta.setUsuario(this);

		return limpiezaProcesoEmpleadoFalta;
	}

	public LimpiezaProcesoEmpleadoFalta removeLimpiezaProcesoEmpleadoFalta(LimpiezaProcesoEmpleadoFalta limpiezaProcesoEmpleadoFalta) {
		getLimpiezaProcesoEmpleadoFaltas().remove(limpiezaProcesoEmpleadoFalta);
		limpiezaProcesoEmpleadoFalta.setUsuario(null);

		return limpiezaProcesoEmpleadoFalta;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoMarcacione
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaProcesoEmpleadoMarcacione> getLimpiezaProcesoEmpleadoMarcaciones() {
		return this.limpiezaProcesoEmpleadoMarcaciones;
	}

	public void setLimpiezaProcesoEmpleadoMarcaciones(List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones) {
		this.limpiezaProcesoEmpleadoMarcaciones = limpiezaProcesoEmpleadoMarcaciones;
	}

	public LimpiezaProcesoEmpleadoMarcacione addLimpiezaProcesoEmpleadoMarcacione(LimpiezaProcesoEmpleadoMarcacione limpiezaProcesoEmpleadoMarcacione) {
		getLimpiezaProcesoEmpleadoMarcaciones().add(limpiezaProcesoEmpleadoMarcacione);
		limpiezaProcesoEmpleadoMarcacione.setUsuario(this);

		return limpiezaProcesoEmpleadoMarcacione;
	}

	public LimpiezaProcesoEmpleadoMarcacione removeLimpiezaProcesoEmpleadoMarcacione(LimpiezaProcesoEmpleadoMarcacione limpiezaProcesoEmpleadoMarcacione) {
		getLimpiezaProcesoEmpleadoMarcaciones().remove(limpiezaProcesoEmpleadoMarcacione);
		limpiezaProcesoEmpleadoMarcacione.setUsuario(null);

		return limpiezaProcesoEmpleadoMarcacione;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoTotalInicial
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaProcesoEmpleadoTotalInicial> getLimpiezaProcesoEmpleadoTotalInicials() {
		return this.limpiezaProcesoEmpleadoTotalInicials;
	}

	public void setLimpiezaProcesoEmpleadoTotalInicials(List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials) {
		this.limpiezaProcesoEmpleadoTotalInicials = limpiezaProcesoEmpleadoTotalInicials;
	}

	public LimpiezaProcesoEmpleadoTotalInicial addLimpiezaProcesoEmpleadoTotalInicial(LimpiezaProcesoEmpleadoTotalInicial limpiezaProcesoEmpleadoTotalInicial) {
		getLimpiezaProcesoEmpleadoTotalInicials().add(limpiezaProcesoEmpleadoTotalInicial);
		limpiezaProcesoEmpleadoTotalInicial.setUsuario(this);

		return limpiezaProcesoEmpleadoTotalInicial;
	}

	public LimpiezaProcesoEmpleadoTotalInicial removeLimpiezaProcesoEmpleadoTotalInicial(LimpiezaProcesoEmpleadoTotalInicial limpiezaProcesoEmpleadoTotalInicial) {
		getLimpiezaProcesoEmpleadoTotalInicials().remove(limpiezaProcesoEmpleadoTotalInicial);
		limpiezaProcesoEmpleadoTotalInicial.setUsuario(null);

		return limpiezaProcesoEmpleadoTotalInicial;
	}


	//bi-directional many-to-one association to LimpiezaProcesoLineaTara
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaProcesoLineaTara> getLimpiezaProcesoLineaTaras() {
		return this.limpiezaProcesoLineaTaras;
	}

	public void setLimpiezaProcesoLineaTaras(List<LimpiezaProcesoLineaTara> limpiezaProcesoLineaTaras) {
		this.limpiezaProcesoLineaTaras = limpiezaProcesoLineaTaras;
	}

	public LimpiezaProcesoLineaTara addLimpiezaProcesoLineaTara(LimpiezaProcesoLineaTara limpiezaProcesoLineaTara) {
		getLimpiezaProcesoLineaTaras().add(limpiezaProcesoLineaTara);
		limpiezaProcesoLineaTara.setUsuario(this);

		return limpiezaProcesoLineaTara;
	}

	public LimpiezaProcesoLineaTara removeLimpiezaProcesoLineaTara(LimpiezaProcesoLineaTara limpiezaProcesoLineaTara) {
		getLimpiezaProcesoLineaTaras().remove(limpiezaProcesoLineaTara);
		limpiezaProcesoLineaTara.setUsuario(null);

		return limpiezaProcesoLineaTara;
	}


	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaProcesoLoteActivo> getLimpiezaProcesoLoteActivos() {
		return this.limpiezaProcesoLoteActivos;
	}

	public void setLimpiezaProcesoLoteActivos(List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos) {
		this.limpiezaProcesoLoteActivos = limpiezaProcesoLoteActivos;
	}

	public LimpiezaProcesoLoteActivo addLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		getLimpiezaProcesoLoteActivos().add(limpiezaProcesoLoteActivo);
		limpiezaProcesoLoteActivo.setUsuario(this);

		return limpiezaProcesoLoteActivo;
	}

	public LimpiezaProcesoLoteActivo removeLimpiezaProcesoLoteActivo(LimpiezaProcesoLoteActivo limpiezaProcesoLoteActivo) {
		getLimpiezaProcesoLoteActivos().remove(limpiezaProcesoLoteActivo);
		limpiezaProcesoLoteActivo.setUsuario(null);

		return limpiezaProcesoLoteActivo;
	}


	//bi-directional many-to-one association to LimpiezaRalladoBatchCabecera
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaRalladoBatchCabecera> getLimpiezaRalladoBatchCabeceras() {
		return this.limpiezaRalladoBatchCabeceras;
	}

	public void setLimpiezaRalladoBatchCabeceras(List<LimpiezaRalladoBatchCabecera> limpiezaRalladoBatchCabeceras) {
		this.limpiezaRalladoBatchCabeceras = limpiezaRalladoBatchCabeceras;
	}

	public LimpiezaRalladoBatchCabecera addLimpiezaRalladoBatchCabecera(LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera) {
		getLimpiezaRalladoBatchCabeceras().add(limpiezaRalladoBatchCabecera);
		limpiezaRalladoBatchCabecera.setUsuario(this);

		return limpiezaRalladoBatchCabecera;
	}

	public LimpiezaRalladoBatchCabecera removeLimpiezaRalladoBatchCabecera(LimpiezaRalladoBatchCabecera limpiezaRalladoBatchCabecera) {
		getLimpiezaRalladoBatchCabeceras().remove(limpiezaRalladoBatchCabecera);
		limpiezaRalladoBatchCabecera.setUsuario(null);

		return limpiezaRalladoBatchCabecera;
	}


	//bi-directional many-to-one association to LimpiezaRalladoBatchDetalle
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaRalladoBatchDetalle> getLimpiezaRalladoBatchDetalles() {
		return this.limpiezaRalladoBatchDetalles;
	}

	public void setLimpiezaRalladoBatchDetalles(List<LimpiezaRalladoBatchDetalle> limpiezaRalladoBatchDetalles) {
		this.limpiezaRalladoBatchDetalles = limpiezaRalladoBatchDetalles;
	}

	public LimpiezaRalladoBatchDetalle addLimpiezaRalladoBatchDetalle(LimpiezaRalladoBatchDetalle limpiezaRalladoBatchDetalle) {
		getLimpiezaRalladoBatchDetalles().add(limpiezaRalladoBatchDetalle);
		limpiezaRalladoBatchDetalle.setUsuario(this);

		return limpiezaRalladoBatchDetalle;
	}

	public LimpiezaRalladoBatchDetalle removeLimpiezaRalladoBatchDetalle(LimpiezaRalladoBatchDetalle limpiezaRalladoBatchDetalle) {
		getLimpiezaRalladoBatchDetalles().remove(limpiezaRalladoBatchDetalle);
		limpiezaRalladoBatchDetalle.setUsuario(null);

		return limpiezaRalladoBatchDetalle;
	}


	//bi-directional many-to-one association to LimpiezaRalladoGabetaMezclaBatch
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaRalladoGabetaMezclaBatch> getLimpiezaRalladoGabetaMezclaBatches() {
		return this.limpiezaRalladoGabetaMezclaBatches;
	}

	public void setLimpiezaRalladoGabetaMezclaBatches(List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches) {
		this.limpiezaRalladoGabetaMezclaBatches = limpiezaRalladoGabetaMezclaBatches;
	}

	public LimpiezaRalladoGabetaMezclaBatch addLimpiezaRalladoGabetaMezclaBatch(LimpiezaRalladoGabetaMezclaBatch limpiezaRalladoGabetaMezclaBatch) {
		getLimpiezaRalladoGabetaMezclaBatches().add(limpiezaRalladoGabetaMezclaBatch);
		limpiezaRalladoGabetaMezclaBatch.setUsuario(this);

		return limpiezaRalladoGabetaMezclaBatch;
	}

	public LimpiezaRalladoGabetaMezclaBatch removeLimpiezaRalladoGabetaMezclaBatch(LimpiezaRalladoGabetaMezclaBatch limpiezaRalladoGabetaMezclaBatch) {
		getLimpiezaRalladoGabetaMezclaBatches().remove(limpiezaRalladoGabetaMezclaBatch);
		limpiezaRalladoGabetaMezclaBatch.setUsuario(null);

		return limpiezaRalladoGabetaMezclaBatch;
	}


	//bi-directional many-to-one association to LimpiezaRalladoMezclaBatchCabecera
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaRalladoMezclaBatchCabecera> getLimpiezaRalladoMezclaBatchCabeceras() {
		return this.limpiezaRalladoMezclaBatchCabeceras;
	}

	public void setLimpiezaRalladoMezclaBatchCabeceras(List<LimpiezaRalladoMezclaBatchCabecera> limpiezaRalladoMezclaBatchCabeceras) {
		this.limpiezaRalladoMezclaBatchCabeceras = limpiezaRalladoMezclaBatchCabeceras;
	}

	public LimpiezaRalladoMezclaBatchCabecera addLimpiezaRalladoMezclaBatchCabecera(LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera) {
		getLimpiezaRalladoMezclaBatchCabeceras().add(limpiezaRalladoMezclaBatchCabecera);
		limpiezaRalladoMezclaBatchCabecera.setUsuario(this);

		return limpiezaRalladoMezclaBatchCabecera;
	}

	public LimpiezaRalladoMezclaBatchCabecera removeLimpiezaRalladoMezclaBatchCabecera(LimpiezaRalladoMezclaBatchCabecera limpiezaRalladoMezclaBatchCabecera) {
		getLimpiezaRalladoMezclaBatchCabeceras().remove(limpiezaRalladoMezclaBatchCabecera);
		limpiezaRalladoMezclaBatchCabecera.setUsuario(null);

		return limpiezaRalladoMezclaBatchCabecera;
	}


	//bi-directional many-to-one association to LimpiezaRalladoMezclaBatchDetalle
	@OneToMany(mappedBy="usuario")
	public List<LimpiezaRalladoMezclaBatchDetalle> getLimpiezaRalladoMezclaBatchDetalles() {
		return this.limpiezaRalladoMezclaBatchDetalles;
	}

	public void setLimpiezaRalladoMezclaBatchDetalles(List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles) {
		this.limpiezaRalladoMezclaBatchDetalles = limpiezaRalladoMezclaBatchDetalles;
	}

	public LimpiezaRalladoMezclaBatchDetalle addLimpiezaRalladoMezclaBatchDetalle(LimpiezaRalladoMezclaBatchDetalle limpiezaRalladoMezclaBatchDetalle) {
		getLimpiezaRalladoMezclaBatchDetalles().add(limpiezaRalladoMezclaBatchDetalle);
		limpiezaRalladoMezclaBatchDetalle.setUsuario(this);

		return limpiezaRalladoMezclaBatchDetalle;
	}

	public LimpiezaRalladoMezclaBatchDetalle removeLimpiezaRalladoMezclaBatchDetalle(LimpiezaRalladoMezclaBatchDetalle limpiezaRalladoMezclaBatchDetalle) {
		getLimpiezaRalladoMezclaBatchDetalles().remove(limpiezaRalladoMezclaBatchDetalle);
		limpiezaRalladoMezclaBatchDetalle.setUsuario(null);

		return limpiezaRalladoMezclaBatchDetalle;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	public List<LonjasDetalleProcesoCoche> getLonjasDetalleProcesoCoches() {
		return this.lonjasDetalleProcesoCoches;
	}

	public void setLonjasDetalleProcesoCoches(List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches) {
		this.lonjasDetalleProcesoCoches = lonjasDetalleProcesoCoches;
	}

	public LonjasDetalleProcesoCoche addLonjasDetalleProcesoCoch(LonjasDetalleProcesoCoche lonjasDetalleProcesoCoch) {
		getLonjasDetalleProcesoCoches().add(lonjasDetalleProcesoCoch);
		lonjasDetalleProcesoCoch.setUsuario(this);

		return lonjasDetalleProcesoCoch;
	}

	public LonjasDetalleProcesoCoche removeLonjasDetalleProcesoCoch(LonjasDetalleProcesoCoche lonjasDetalleProcesoCoch) {
		getLonjasDetalleProcesoCoches().remove(lonjasDetalleProcesoCoch);
		lonjasDetalleProcesoCoch.setUsuario(null);

		return lonjasDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@OneToMany(mappedBy="usuario")
	public List<LonjasDetalleProcesoCocheEmpacado> getLonjasDetalleProcesoCocheEmpacados() {
		return this.lonjasDetalleProcesoCocheEmpacados;
	}

	public void setLonjasDetalleProcesoCocheEmpacados(List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados) {
		this.lonjasDetalleProcesoCocheEmpacados = lonjasDetalleProcesoCocheEmpacados;
	}

	public LonjasDetalleProcesoCocheEmpacado addLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		getLonjasDetalleProcesoCocheEmpacados().add(lonjasDetalleProcesoCocheEmpacado);
		lonjasDetalleProcesoCocheEmpacado.setUsuario(this);

		return lonjasDetalleProcesoCocheEmpacado;
	}

	public LonjasDetalleProcesoCocheEmpacado removeLonjasDetalleProcesoCocheEmpacado(LonjasDetalleProcesoCocheEmpacado lonjasDetalleProcesoCocheEmpacado) {
		getLonjasDetalleProcesoCocheEmpacados().remove(lonjasDetalleProcesoCocheEmpacado);
		lonjasDetalleProcesoCocheEmpacado.setUsuario(null);

		return lonjasDetalleProcesoCocheEmpacado;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="usuario")
	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public LonjasDetalleProcesoConteo addLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().add(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setUsuario(this);

		return lonjasDetalleProcesoConteo;
	}

	public LonjasDetalleProcesoConteo removeLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().remove(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setUsuario(null);

		return lonjasDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="usuario")
	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

	public LonjasDetalleProcesoEmpaque addLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().add(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setUsuario(this);

		return lonjasDetalleProcesoEmpaque;
	}

	public LonjasDetalleProcesoEmpaque removeLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().remove(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setUsuario(null);

		return lonjasDetalleProcesoEmpaque;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="usuario")
	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public LonjasDetalleProcesoLote addLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().add(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setUsuario(this);

		return lonjasDetalleProcesoLote;
	}

	public LonjasDetalleProcesoLote removeLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().remove(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setUsuario(null);

		return lonjasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LonjasOrdenProduccion
	@OneToMany(mappedBy="usuario")
	public List<LonjasOrdenProduccion> getLonjasOrdenProduccions() {
		return this.lonjasOrdenProduccions;
	}

	public void setLonjasOrdenProduccions(List<LonjasOrdenProduccion> lonjasOrdenProduccions) {
		this.lonjasOrdenProduccions = lonjasOrdenProduccions;
	}

	public LonjasOrdenProduccion addLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		getLonjasOrdenProduccions().add(lonjasOrdenProduccion);
		lonjasOrdenProduccion.setUsuario(this);

		return lonjasOrdenProduccion;
	}

	public LonjasOrdenProduccion removeLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		getLonjasOrdenProduccions().remove(lonjasOrdenProduccion);
		lonjasOrdenProduccion.setUsuario(null);

		return lonjasOrdenProduccion;
	}


	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="usuario")
	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
	}

	public LonjasProceso addLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().add(lonjasProceso);
		lonjasProceso.setUsuario(this);

		return lonjasProceso;
	}

	public LonjasProceso removeLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().remove(lonjasProceso);
		lonjasProceso.setUsuario(null);

		return lonjasProceso;
	}


	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@OneToMany(mappedBy="usuario")
	public List<LonjasProcesoEmpleado> getLonjasProcesoEmpleados() {
		return this.lonjasProcesoEmpleados;
	}

	public void setLonjasProcesoEmpleados(List<LonjasProcesoEmpleado> lonjasProcesoEmpleados) {
		this.lonjasProcesoEmpleados = lonjasProcesoEmpleados;
	}

	public LonjasProcesoEmpleado addLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		getLonjasProcesoEmpleados().add(lonjasProcesoEmpleado);
		lonjasProcesoEmpleado.setUsuario(this);

		return lonjasProcesoEmpleado;
	}

	public LonjasProcesoEmpleado removeLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		getLonjasProcesoEmpleados().remove(lonjasProcesoEmpleado);
		lonjasProcesoEmpleado.setUsuario(null);

		return lonjasProcesoEmpleado;
	}


	//bi-directional many-to-one association to ObservacionesDetalleProceso
	@OneToMany(mappedBy="usuario")
	public List<ObservacionesDetalleProceso> getObservacionesDetalleProcesos() {
		return this.observacionesDetalleProcesos;
	}

	public void setObservacionesDetalleProcesos(List<ObservacionesDetalleProceso> observacionesDetalleProcesos) {
		this.observacionesDetalleProcesos = observacionesDetalleProcesos;
	}

	public ObservacionesDetalleProceso addObservacionesDetalleProceso(ObservacionesDetalleProceso observacionesDetalleProceso) {
		getObservacionesDetalleProcesos().add(observacionesDetalleProceso);
		observacionesDetalleProceso.setUsuario(this);

		return observacionesDetalleProceso;
	}

	public ObservacionesDetalleProceso removeObservacionesDetalleProceso(ObservacionesDetalleProceso observacionesDetalleProceso) {
		getObservacionesDetalleProcesos().remove(observacionesDetalleProceso);
		observacionesDetalleProceso.setUsuario(null);

		return observacionesDetalleProceso;
	}


	//bi-directional many-to-one association to ObservacionesProceso
	@OneToMany(mappedBy="usuario")
	public List<ObservacionesProceso> getObservacionesProcesos() {
		return this.observacionesProcesos;
	}

	public void setObservacionesProcesos(List<ObservacionesProceso> observacionesProcesos) {
		this.observacionesProcesos = observacionesProcesos;
	}

	public ObservacionesProceso addObservacionesProceso(ObservacionesProceso observacionesProceso) {
		getObservacionesProcesos().add(observacionesProceso);
		observacionesProceso.setUsuario(this);

		return observacionesProceso;
	}

	public ObservacionesProceso removeObservacionesProceso(ObservacionesProceso observacionesProceso) {
		getObservacionesProcesos().remove(observacionesProceso);
		observacionesProceso.setUsuario(null);

		return observacionesProceso;
	}


	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="usuario1")
	public List<ObservacionesPuntoControl> getObservacionesPuntoControls1() {
		return this.observacionesPuntoControls1;
	}

	public void setObservacionesPuntoControls1(List<ObservacionesPuntoControl> observacionesPuntoControls1) {
		this.observacionesPuntoControls1 = observacionesPuntoControls1;
	}

	public ObservacionesPuntoControl addObservacionesPuntoControls1(ObservacionesPuntoControl observacionesPuntoControls1) {
		getObservacionesPuntoControls1().add(observacionesPuntoControls1);
		observacionesPuntoControls1.setUsuario1(this);

		return observacionesPuntoControls1;
	}

	public ObservacionesPuntoControl removeObservacionesPuntoControls1(ObservacionesPuntoControl observacionesPuntoControls1) {
		getObservacionesPuntoControls1().remove(observacionesPuntoControls1);
		observacionesPuntoControls1.setUsuario1(null);

		return observacionesPuntoControls1;
	}


	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="usuario2")
	public List<ObservacionesPuntoControl> getObservacionesPuntoControls2() {
		return this.observacionesPuntoControls2;
	}

	public void setObservacionesPuntoControls2(List<ObservacionesPuntoControl> observacionesPuntoControls2) {
		this.observacionesPuntoControls2 = observacionesPuntoControls2;
	}

	public ObservacionesPuntoControl addObservacionesPuntoControls2(ObservacionesPuntoControl observacionesPuntoControls2) {
		getObservacionesPuntoControls2().add(observacionesPuntoControls2);
		observacionesPuntoControls2.setUsuario2(this);

		return observacionesPuntoControls2;
	}

	public ObservacionesPuntoControl removeObservacionesPuntoControls2(ObservacionesPuntoControl observacionesPuntoControls2) {
		getObservacionesPuntoControls2().remove(observacionesPuntoControls2);
		observacionesPuntoControls2.setUsuario2(null);

		return observacionesPuntoControls2;
	}


	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="usuario3")
	public List<ObservacionesPuntoControl> getObservacionesPuntoControls3() {
		return this.observacionesPuntoControls3;
	}

	public void setObservacionesPuntoControls3(List<ObservacionesPuntoControl> observacionesPuntoControls3) {
		this.observacionesPuntoControls3 = observacionesPuntoControls3;
	}

	public ObservacionesPuntoControl addObservacionesPuntoControls3(ObservacionesPuntoControl observacionesPuntoControls3) {
		getObservacionesPuntoControls3().add(observacionesPuntoControls3);
		observacionesPuntoControls3.setUsuario3(this);

		return observacionesPuntoControls3;
	}

	public ObservacionesPuntoControl removeObservacionesPuntoControls3(ObservacionesPuntoControl observacionesPuntoControls3) {
		getObservacionesPuntoControls3().remove(observacionesPuntoControls3);
		observacionesPuntoControls3.setUsuario3(null);

		return observacionesPuntoControls3;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="usuario")
	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public OeeDetalleMediosConDefecto addOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().add(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setUsuario(this);

		return oeeDetalleMediosConDefecto;
	}

	public OeeDetalleMediosConDefecto removeOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().remove(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setUsuario(null);

		return oeeDetalleMediosConDefecto;
	}


	//bi-directional many-to-one association to OeeDetalleParada
	@OneToMany(mappedBy="usuario")
	public List<OeeDetalleParada> getOeeDetalleParadas() {
		return this.oeeDetalleParadas;
	}

	public void setOeeDetalleParadas(List<OeeDetalleParada> oeeDetalleParadas) {
		this.oeeDetalleParadas = oeeDetalleParadas;
	}

	public OeeDetalleParada addOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		getOeeDetalleParadas().add(oeeDetalleParada);
		oeeDetalleParada.setUsuario(this);

		return oeeDetalleParada;
	}

	public OeeDetalleParada removeOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		getOeeDetalleParadas().remove(oeeDetalleParada);
		oeeDetalleParada.setUsuario(null);

		return oeeDetalleParada;
	}


	//bi-directional many-to-one association to OeeEnvasadoCabeceraVelocidadMaquinaCerradora
	@OneToMany(mappedBy="usuario")
	public List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoCabeceraVelocidadMaquinaCerradoras(List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras = oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora addOeeEnvasadoCabeceraVelocidadMaquinaCerradora(OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras().add(oeeEnvasadoCabeceraVelocidadMaquinaCerradora);
		oeeEnvasadoCabeceraVelocidadMaquinaCerradora.setUsuario(this);

		return oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora removeOeeEnvasadoCabeceraVelocidadMaquinaCerradora(OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras().remove(oeeEnvasadoCabeceraVelocidadMaquinaCerradora);
		oeeEnvasadoCabeceraVelocidadMaquinaCerradora.setUsuario(null);

		return oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}


	//bi-directional many-to-one association to OeeEnvasadoDetalleVelocidadMaquinaCerradora
	@OneToMany(mappedBy="usuario")
	public List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> getOeeEnvasadoDetalleVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoDetalleVelocidadMaquinaCerradoras(List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras = oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

	public OeeEnvasadoDetalleVelocidadMaquinaCerradora addOeeEnvasadoDetalleVelocidadMaquinaCerradora(OeeEnvasadoDetalleVelocidadMaquinaCerradora oeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		getOeeEnvasadoDetalleVelocidadMaquinaCerradoras().add(oeeEnvasadoDetalleVelocidadMaquinaCerradora);
		oeeEnvasadoDetalleVelocidadMaquinaCerradora.setUsuario(this);

		return oeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}

	public OeeEnvasadoDetalleVelocidadMaquinaCerradora removeOeeEnvasadoDetalleVelocidadMaquinaCerradora(OeeEnvasadoDetalleVelocidadMaquinaCerradora oeeEnvasadoDetalleVelocidadMaquinaCerradora) {
		getOeeEnvasadoDetalleVelocidadMaquinaCerradoras().remove(oeeEnvasadoDetalleVelocidadMaquinaCerradora);
		oeeEnvasadoDetalleVelocidadMaquinaCerradora.setUsuario(null);

		return oeeEnvasadoDetalleVelocidadMaquinaCerradora;
	}


	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@OneToMany(mappedBy="usuario")
	public List<OeePeriodoBaseObjetivo> getOeePeriodoBaseObjetivos() {
		return this.oeePeriodoBaseObjetivos;
	}

	public void setOeePeriodoBaseObjetivos(List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos) {
		this.oeePeriodoBaseObjetivos = oeePeriodoBaseObjetivos;
	}

	public OeePeriodoBaseObjetivo addOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		getOeePeriodoBaseObjetivos().add(oeePeriodoBaseObjetivo);
		oeePeriodoBaseObjetivo.setUsuario(this);

		return oeePeriodoBaseObjetivo;
	}

	public OeePeriodoBaseObjetivo removeOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		getOeePeriodoBaseObjetivos().remove(oeePeriodoBaseObjetivo);
		oeePeriodoBaseObjetivo.setUsuario(null);

		return oeePeriodoBaseObjetivo;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	public List<PanzasDetalleProcesoCoche> getPanzasDetalleProcesoCoches() {
		return this.panzasDetalleProcesoCoches;
	}

	public void setPanzasDetalleProcesoCoches(List<PanzasDetalleProcesoCoche> panzasDetalleProcesoCoches) {
		this.panzasDetalleProcesoCoches = panzasDetalleProcesoCoches;
	}

	public PanzasDetalleProcesoCoche addPanzasDetalleProcesoCoch(PanzasDetalleProcesoCoche panzasDetalleProcesoCoch) {
		getPanzasDetalleProcesoCoches().add(panzasDetalleProcesoCoch);
		panzasDetalleProcesoCoch.setUsuario(this);

		return panzasDetalleProcesoCoch;
	}

	public PanzasDetalleProcesoCoche removePanzasDetalleProcesoCoch(PanzasDetalleProcesoCoche panzasDetalleProcesoCoch) {
		getPanzasDetalleProcesoCoches().remove(panzasDetalleProcesoCoch);
		panzasDetalleProcesoCoch.setUsuario(null);

		return panzasDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoConteo
	@OneToMany(mappedBy="usuario")
	public List<PanzasDetalleProcesoConteo> getPanzasDetalleProcesoConteos() {
		return this.panzasDetalleProcesoConteos;
	}

	public void setPanzasDetalleProcesoConteos(List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos) {
		this.panzasDetalleProcesoConteos = panzasDetalleProcesoConteos;
	}

	public PanzasDetalleProcesoConteo addPanzasDetalleProcesoConteo(PanzasDetalleProcesoConteo panzasDetalleProcesoConteo) {
		getPanzasDetalleProcesoConteos().add(panzasDetalleProcesoConteo);
		panzasDetalleProcesoConteo.setUsuario(this);

		return panzasDetalleProcesoConteo;
	}

	public PanzasDetalleProcesoConteo removePanzasDetalleProcesoConteo(PanzasDetalleProcesoConteo panzasDetalleProcesoConteo) {
		getPanzasDetalleProcesoConteos().remove(panzasDetalleProcesoConteo);
		panzasDetalleProcesoConteo.setUsuario(null);

		return panzasDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoLote
	@OneToMany(mappedBy="usuario")
	public List<PanzasDetalleProcesoLote> getPanzasDetalleProcesoLotes() {
		return this.panzasDetalleProcesoLotes;
	}

	public void setPanzasDetalleProcesoLotes(List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes) {
		this.panzasDetalleProcesoLotes = panzasDetalleProcesoLotes;
	}

	public PanzasDetalleProcesoLote addPanzasDetalleProcesoLote(PanzasDetalleProcesoLote panzasDetalleProcesoLote) {
		getPanzasDetalleProcesoLotes().add(panzasDetalleProcesoLote);
		panzasDetalleProcesoLote.setUsuario(this);

		return panzasDetalleProcesoLote;
	}

	public PanzasDetalleProcesoLote removePanzasDetalleProcesoLote(PanzasDetalleProcesoLote panzasDetalleProcesoLote) {
		getPanzasDetalleProcesoLotes().remove(panzasDetalleProcesoLote);
		panzasDetalleProcesoLote.setUsuario(null);

		return panzasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to PanzasProceso
	@OneToMany(mappedBy="usuario")
	public List<PanzasProceso> getPanzasProcesos() {
		return this.panzasProcesos;
	}

	public void setPanzasProcesos(List<PanzasProceso> panzasProcesos) {
		this.panzasProcesos = panzasProcesos;
	}

	public PanzasProceso addPanzasProceso(PanzasProceso panzasProceso) {
		getPanzasProcesos().add(panzasProceso);
		panzasProceso.setUsuario(this);

		return panzasProceso;
	}

	public PanzasProceso removePanzasProceso(PanzasProceso panzasProceso) {
		getPanzasProcesos().remove(panzasProceso);
		panzasProceso.setUsuario(null);

		return panzasProceso;
	}


	//bi-directional many-to-one association to ParametroAuditoria
	@OneToMany(mappedBy="usuario")
	public List<ParametroAuditoria> getParametroAuditorias() {
		return this.parametroAuditorias;
	}

	public void setParametroAuditorias(List<ParametroAuditoria> parametroAuditorias) {
		this.parametroAuditorias = parametroAuditorias;
	}

	public ParametroAuditoria addParametroAuditoria(ParametroAuditoria parametroAuditoria) {
		getParametroAuditorias().add(parametroAuditoria);
		parametroAuditoria.setUsuario(this);

		return parametroAuditoria;
	}

	public ParametroAuditoria removeParametroAuditoria(ParametroAuditoria parametroAuditoria) {
		getParametroAuditorias().remove(parametroAuditoria);
		parametroAuditoria.setUsuario(null);

		return parametroAuditoria;
	}


	//bi-directional many-to-one association to PedidoProduccionArchivoCargaCabecera
	@OneToMany(mappedBy="usuario")
	public List<PedidoProduccionArchivoCargaCabecera> getPedidoProduccionArchivoCargaCabeceras() {
		return this.pedidoProduccionArchivoCargaCabeceras;
	}

	public void setPedidoProduccionArchivoCargaCabeceras(List<PedidoProduccionArchivoCargaCabecera> pedidoProduccionArchivoCargaCabeceras) {
		this.pedidoProduccionArchivoCargaCabeceras = pedidoProduccionArchivoCargaCabeceras;
	}

	public PedidoProduccionArchivoCargaCabecera addPedidoProduccionArchivoCargaCabecera(PedidoProduccionArchivoCargaCabecera pedidoProduccionArchivoCargaCabecera) {
		getPedidoProduccionArchivoCargaCabeceras().add(pedidoProduccionArchivoCargaCabecera);
		pedidoProduccionArchivoCargaCabecera.setUsuario(this);

		return pedidoProduccionArchivoCargaCabecera;
	}

	public PedidoProduccionArchivoCargaCabecera removePedidoProduccionArchivoCargaCabecera(PedidoProduccionArchivoCargaCabecera pedidoProduccionArchivoCargaCabecera) {
		getPedidoProduccionArchivoCargaCabeceras().remove(pedidoProduccionArchivoCargaCabecera);
		pedidoProduccionArchivoCargaCabecera.setUsuario(null);

		return pedidoProduccionArchivoCargaCabecera;
	}


	//bi-directional many-to-one association to PedidoProduccionCabecera
	@OneToMany(mappedBy="usuario")
	public List<PedidoProduccionCabecera> getPedidoProduccionCabeceras() {
		return this.pedidoProduccionCabeceras;
	}

	public void setPedidoProduccionCabeceras(List<PedidoProduccionCabecera> pedidoProduccionCabeceras) {
		this.pedidoProduccionCabeceras = pedidoProduccionCabeceras;
	}

	public PedidoProduccionCabecera addPedidoProduccionCabecera(PedidoProduccionCabecera pedidoProduccionCabecera) {
		getPedidoProduccionCabeceras().add(pedidoProduccionCabecera);
		pedidoProduccionCabecera.setUsuario(this);

		return pedidoProduccionCabecera;
	}

	public PedidoProduccionCabecera removePedidoProduccionCabecera(PedidoProduccionCabecera pedidoProduccionCabecera) {
		getPedidoProduccionCabeceras().remove(pedidoProduccionCabecera);
		pedidoProduccionCabecera.setUsuario(null);

		return pedidoProduccionCabecera;
	}


	//bi-directional many-to-one association to PlanificacionCargaArchivo
	@OneToMany(mappedBy="usuario")
	public List<PlanificacionCargaArchivo> getPlanificacionCargaArchivos() {
		return this.planificacionCargaArchivos;
	}

	public void setPlanificacionCargaArchivos(List<PlanificacionCargaArchivo> planificacionCargaArchivos) {
		this.planificacionCargaArchivos = planificacionCargaArchivos;
	}

	public PlanificacionCargaArchivo addPlanificacionCargaArchivo(PlanificacionCargaArchivo planificacionCargaArchivo) {
		getPlanificacionCargaArchivos().add(planificacionCargaArchivo);
		planificacionCargaArchivo.setUsuario(this);

		return planificacionCargaArchivo;
	}

	public PlanificacionCargaArchivo removePlanificacionCargaArchivo(PlanificacionCargaArchivo planificacionCargaArchivo) {
		getPlanificacionCargaArchivos().remove(planificacionCargaArchivo);
		planificacionCargaArchivo.setUsuario(null);

		return planificacionCargaArchivo;
	}


	//bi-directional many-to-one association to PouchDetalleProcesoConteo
	@OneToMany(mappedBy="usuario")
	public List<PouchDetalleProcesoConteo> getPouchDetalleProcesoConteos() {
		return this.pouchDetalleProcesoConteos;
	}

	public void setPouchDetalleProcesoConteos(List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos) {
		this.pouchDetalleProcesoConteos = pouchDetalleProcesoConteos;
	}

	public PouchDetalleProcesoConteo addPouchDetalleProcesoConteo(PouchDetalleProcesoConteo pouchDetalleProcesoConteo) {
		getPouchDetalleProcesoConteos().add(pouchDetalleProcesoConteo);
		pouchDetalleProcesoConteo.setUsuario(this);

		return pouchDetalleProcesoConteo;
	}

	public PouchDetalleProcesoConteo removePouchDetalleProcesoConteo(PouchDetalleProcesoConteo pouchDetalleProcesoConteo) {
		getPouchDetalleProcesoConteos().remove(pouchDetalleProcesoConteo);
		pouchDetalleProcesoConteo.setUsuario(null);

		return pouchDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to PouchDetalleProcesoLote
	@OneToMany(mappedBy="usuario")
	public List<PouchDetalleProcesoLote> getPouchDetalleProcesoLotes() {
		return this.pouchDetalleProcesoLotes;
	}

	public void setPouchDetalleProcesoLotes(List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes) {
		this.pouchDetalleProcesoLotes = pouchDetalleProcesoLotes;
	}

	public PouchDetalleProcesoLote addPouchDetalleProcesoLote(PouchDetalleProcesoLote pouchDetalleProcesoLote) {
		getPouchDetalleProcesoLotes().add(pouchDetalleProcesoLote);
		pouchDetalleProcesoLote.setUsuario(this);

		return pouchDetalleProcesoLote;
	}

	public PouchDetalleProcesoLote removePouchDetalleProcesoLote(PouchDetalleProcesoLote pouchDetalleProcesoLote) {
		getPouchDetalleProcesoLotes().remove(pouchDetalleProcesoLote);
		pouchDetalleProcesoLote.setUsuario(null);

		return pouchDetalleProcesoLote;
	}


	//bi-directional many-to-one association to PouchProceso
	@OneToMany(mappedBy="usuario")
	public List<PouchProceso> getPouchProcesos() {
		return this.pouchProcesos;
	}

	public void setPouchProcesos(List<PouchProceso> pouchProcesos) {
		this.pouchProcesos = pouchProcesos;
	}

	public PouchProceso addPouchProceso(PouchProceso pouchProceso) {
		getPouchProcesos().add(pouchProceso);
		pouchProceso.setUsuario(this);

		return pouchProceso;
	}

	public PouchProceso removePouchProceso(PouchProceso pouchProceso) {
		getPouchProcesos().remove(pouchProceso);
		pouchProceso.setUsuario(null);

		return pouchProceso;
	}


	//bi-directional many-to-one association to ProduccionArchivoCargaLote
	@OneToMany(mappedBy="usuario")
	public List<ProduccionArchivoCargaLote> getProduccionArchivoCargaLotes() {
		return this.produccionArchivoCargaLotes;
	}

	public void setProduccionArchivoCargaLotes(List<ProduccionArchivoCargaLote> produccionArchivoCargaLotes) {
		this.produccionArchivoCargaLotes = produccionArchivoCargaLotes;
	}

	public ProduccionArchivoCargaLote addProduccionArchivoCargaLote(ProduccionArchivoCargaLote produccionArchivoCargaLote) {
		getProduccionArchivoCargaLotes().add(produccionArchivoCargaLote);
		produccionArchivoCargaLote.setUsuario(this);

		return produccionArchivoCargaLote;
	}

	public ProduccionArchivoCargaLote removeProduccionArchivoCargaLote(ProduccionArchivoCargaLote produccionArchivoCargaLote) {
		getProduccionArchivoCargaLotes().remove(produccionArchivoCargaLote);
		produccionArchivoCargaLote.setUsuario(null);

		return produccionArchivoCargaLote;
	}


	//bi-directional many-to-one association to ProduccionArchivoCargaOrden
	@OneToMany(mappedBy="usuario")
	public List<ProduccionArchivoCargaOrden> getProduccionArchivoCargaOrdens() {
		return this.produccionArchivoCargaOrdens;
	}

	public void setProduccionArchivoCargaOrdens(List<ProduccionArchivoCargaOrden> produccionArchivoCargaOrdens) {
		this.produccionArchivoCargaOrdens = produccionArchivoCargaOrdens;
	}

	public ProduccionArchivoCargaOrden addProduccionArchivoCargaOrden(ProduccionArchivoCargaOrden produccionArchivoCargaOrden) {
		getProduccionArchivoCargaOrdens().add(produccionArchivoCargaOrden);
		produccionArchivoCargaOrden.setUsuario(this);

		return produccionArchivoCargaOrden;
	}

	public ProduccionArchivoCargaOrden removeProduccionArchivoCargaOrden(ProduccionArchivoCargaOrden produccionArchivoCargaOrden) {
		getProduccionArchivoCargaOrdens().remove(produccionArchivoCargaOrden);
		produccionArchivoCargaOrden.setUsuario(null);

		return produccionArchivoCargaOrden;
	}


	//bi-directional many-to-one association to ProduccionCargaArchivoPedido
	@OneToMany(mappedBy="usuario")
	public List<ProduccionCargaArchivoPedido> getProduccionCargaArchivoPedidos() {
		return this.produccionCargaArchivoPedidos;
	}

	public void setProduccionCargaArchivoPedidos(List<ProduccionCargaArchivoPedido> produccionCargaArchivoPedidos) {
		this.produccionCargaArchivoPedidos = produccionCargaArchivoPedidos;
	}

	public ProduccionCargaArchivoPedido addProduccionCargaArchivoPedido(ProduccionCargaArchivoPedido produccionCargaArchivoPedido) {
		getProduccionCargaArchivoPedidos().add(produccionCargaArchivoPedido);
		produccionCargaArchivoPedido.setUsuario(this);

		return produccionCargaArchivoPedido;
	}

	public ProduccionCargaArchivoPedido removeProduccionCargaArchivoPedido(ProduccionCargaArchivoPedido produccionCargaArchivoPedido) {
		getProduccionCargaArchivoPedidos().remove(produccionCargaArchivoPedido);
		produccionCargaArchivoPedido.setUsuario(null);

		return produccionCargaArchivoPedido;
	}


	//bi-directional many-to-one association to ProduccionDetalleOrden
	@OneToMany(mappedBy="usuario")
	public List<ProduccionDetalleOrden> getProduccionDetalleOrdens() {
		return this.produccionDetalleOrdens;
	}

	public void setProduccionDetalleOrdens(List<ProduccionDetalleOrden> produccionDetalleOrdens) {
		this.produccionDetalleOrdens = produccionDetalleOrdens;
	}

	public ProduccionDetalleOrden addProduccionDetalleOrden(ProduccionDetalleOrden produccionDetalleOrden) {
		getProduccionDetalleOrdens().add(produccionDetalleOrden);
		produccionDetalleOrden.setUsuario(this);

		return produccionDetalleOrden;
	}

	public ProduccionDetalleOrden removeProduccionDetalleOrden(ProduccionDetalleOrden produccionDetalleOrden) {
		getProduccionDetalleOrdens().remove(produccionDetalleOrden);
		produccionDetalleOrden.setUsuario(null);

		return produccionDetalleOrden;
	}


	//bi-directional many-to-one association to RackeoProceso
	@OneToMany(mappedBy="usuario")
	public List<RackeoProceso> getRackeoProcesos() {
		return this.rackeoProcesos;
	}

	public void setRackeoProcesos(List<RackeoProceso> rackeoProcesos) {
		this.rackeoProcesos = rackeoProcesos;
	}

	public RackeoProceso addRackeoProceso(RackeoProceso rackeoProceso) {
		getRackeoProcesos().add(rackeoProceso);
		rackeoProceso.setUsuario(this);

		return rackeoProceso;
	}

	public RackeoProceso removeRackeoProceso(RackeoProceso rackeoProceso) {
		getRackeoProcesos().remove(rackeoProceso);
		rackeoProceso.setUsuario(null);

		return rackeoProceso;
	}


	//bi-directional many-to-one association to RackeoProcesoEmpleado
	@OneToMany(mappedBy="usuario")
	public List<RackeoProcesoEmpleado> getRackeoProcesoEmpleados() {
		return this.rackeoProcesoEmpleados;
	}

	public void setRackeoProcesoEmpleados(List<RackeoProcesoEmpleado> rackeoProcesoEmpleados) {
		this.rackeoProcesoEmpleados = rackeoProcesoEmpleados;
	}

	public RackeoProcesoEmpleado addRackeoProcesoEmpleado(RackeoProcesoEmpleado rackeoProcesoEmpleado) {
		getRackeoProcesoEmpleados().add(rackeoProcesoEmpleado);
		rackeoProcesoEmpleado.setUsuario(this);

		return rackeoProcesoEmpleado;
	}

	public RackeoProcesoEmpleado removeRackeoProcesoEmpleado(RackeoProcesoEmpleado rackeoProcesoEmpleado) {
		getRackeoProcesoEmpleados().remove(rackeoProcesoEmpleado);
		rackeoProcesoEmpleado.setUsuario(null);

		return rackeoProcesoEmpleado;
	}


	//bi-directional many-to-one association to ReportesNivelesUsuario
	@OneToMany(mappedBy="usuario")
	public List<ReportesNivelesUsuario> getReportesNivelesUsuarios() {
		return this.reportesNivelesUsuarios;
	}

	public void setReportesNivelesUsuarios(List<ReportesNivelesUsuario> reportesNivelesUsuarios) {
		this.reportesNivelesUsuarios = reportesNivelesUsuarios;
	}

	public ReportesNivelesUsuario addReportesNivelesUsuario(ReportesNivelesUsuario reportesNivelesUsuario) {
		getReportesNivelesUsuarios().add(reportesNivelesUsuario);
		reportesNivelesUsuario.setUsuario(this);

		return reportesNivelesUsuario;
	}

	public ReportesNivelesUsuario removeReportesNivelesUsuario(ReportesNivelesUsuario reportesNivelesUsuario) {
		getReportesNivelesUsuarios().remove(reportesNivelesUsuario);
		reportesNivelesUsuario.setUsuario(null);

		return reportesNivelesUsuario;
	}


	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="usuario1")
	public List<ReportesPuntoControl> getReportesPuntoControls1() {
		return this.reportesPuntoControls1;
	}

	public void setReportesPuntoControls1(List<ReportesPuntoControl> reportesPuntoControls1) {
		this.reportesPuntoControls1 = reportesPuntoControls1;
	}

	public ReportesPuntoControl addReportesPuntoControls1(ReportesPuntoControl reportesPuntoControls1) {
		getReportesPuntoControls1().add(reportesPuntoControls1);
		reportesPuntoControls1.setUsuario1(this);

		return reportesPuntoControls1;
	}

	public ReportesPuntoControl removeReportesPuntoControls1(ReportesPuntoControl reportesPuntoControls1) {
		getReportesPuntoControls1().remove(reportesPuntoControls1);
		reportesPuntoControls1.setUsuario1(null);

		return reportesPuntoControls1;
	}


	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="usuario2")
	public List<ReportesPuntoControl> getReportesPuntoControls2() {
		return this.reportesPuntoControls2;
	}

	public void setReportesPuntoControls2(List<ReportesPuntoControl> reportesPuntoControls2) {
		this.reportesPuntoControls2 = reportesPuntoControls2;
	}

	public ReportesPuntoControl addReportesPuntoControls2(ReportesPuntoControl reportesPuntoControls2) {
		getReportesPuntoControls2().add(reportesPuntoControls2);
		reportesPuntoControls2.setUsuario2(this);

		return reportesPuntoControls2;
	}

	public ReportesPuntoControl removeReportesPuntoControls2(ReportesPuntoControl reportesPuntoControls2) {
		getReportesPuntoControls2().remove(reportesPuntoControls2);
		reportesPuntoControls2.setUsuario2(null);

		return reportesPuntoControls2;
	}


	//bi-directional many-to-one association to RociadoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	public List<RociadoDetalleMuestreoTempCoche> getRociadoDetalleMuestreoTempCoches() {
		return this.rociadoDetalleMuestreoTempCoches;
	}

	public void setRociadoDetalleMuestreoTempCoches(List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches) {
		this.rociadoDetalleMuestreoTempCoches = rociadoDetalleMuestreoTempCoches;
	}

	public RociadoDetalleMuestreoTempCoche addRociadoDetalleMuestreoTempCoch(RociadoDetalleMuestreoTempCoche rociadoDetalleMuestreoTempCoch) {
		getRociadoDetalleMuestreoTempCoches().add(rociadoDetalleMuestreoTempCoch);
		rociadoDetalleMuestreoTempCoch.setUsuario(this);

		return rociadoDetalleMuestreoTempCoch;
	}

	public RociadoDetalleMuestreoTempCoche removeRociadoDetalleMuestreoTempCoch(RociadoDetalleMuestreoTempCoche rociadoDetalleMuestreoTempCoch) {
		getRociadoDetalleMuestreoTempCoches().remove(rociadoDetalleMuestreoTempCoch);
		rociadoDetalleMuestreoTempCoch.setUsuario(null);

		return rociadoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	public List<RociadoDetalleProcesoCoche> getRociadoDetalleProcesoCoches() {
		return this.rociadoDetalleProcesoCoches;
	}

	public void setRociadoDetalleProcesoCoches(List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches) {
		this.rociadoDetalleProcesoCoches = rociadoDetalleProcesoCoches;
	}

	public RociadoDetalleProcesoCoche addRociadoDetalleProcesoCoch(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoch) {
		getRociadoDetalleProcesoCoches().add(rociadoDetalleProcesoCoch);
		rociadoDetalleProcesoCoch.setUsuario(this);

		return rociadoDetalleProcesoCoch;
	}

	public RociadoDetalleProcesoCoche removeRociadoDetalleProcesoCoch(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoch) {
		getRociadoDetalleProcesoCoches().remove(rociadoDetalleProcesoCoch);
		rociadoDetalleProcesoCoch.setUsuario(null);

		return rociadoDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to RociadoDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="usuario")
	public List<RociadoDetalleProcesoCocheTemperatura> getRociadoDetalleProcesoCocheTemperaturas() {
		return this.rociadoDetalleProcesoCocheTemperaturas;
	}

	public void setRociadoDetalleProcesoCocheTemperaturas(List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas) {
		this.rociadoDetalleProcesoCocheTemperaturas = rociadoDetalleProcesoCocheTemperaturas;
	}

	public RociadoDetalleProcesoCocheTemperatura addRociadoDetalleProcesoCocheTemperatura(RociadoDetalleProcesoCocheTemperatura rociadoDetalleProcesoCocheTemperatura) {
		getRociadoDetalleProcesoCocheTemperaturas().add(rociadoDetalleProcesoCocheTemperatura);
		rociadoDetalleProcesoCocheTemperatura.setUsuario(this);

		return rociadoDetalleProcesoCocheTemperatura;
	}

	public RociadoDetalleProcesoCocheTemperatura removeRociadoDetalleProcesoCocheTemperatura(RociadoDetalleProcesoCocheTemperatura rociadoDetalleProcesoCocheTemperatura) {
		getRociadoDetalleProcesoCocheTemperaturas().remove(rociadoDetalleProcesoCocheTemperatura);
		rociadoDetalleProcesoCocheTemperatura.setUsuario(null);

		return rociadoDetalleProcesoCocheTemperatura;
	}


	//bi-directional many-to-one association to RociadoMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	public List<RociadoMuestreoTempCoche> getRociadoMuestreoTempCoches() {
		return this.rociadoMuestreoTempCoches;
	}

	public void setRociadoMuestreoTempCoches(List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches) {
		this.rociadoMuestreoTempCoches = rociadoMuestreoTempCoches;
	}

	public RociadoMuestreoTempCoche addRociadoMuestreoTempCoch(RociadoMuestreoTempCoche rociadoMuestreoTempCoch) {
		getRociadoMuestreoTempCoches().add(rociadoMuestreoTempCoch);
		rociadoMuestreoTempCoch.setUsuario(this);

		return rociadoMuestreoTempCoch;
	}

	public RociadoMuestreoTempCoche removeRociadoMuestreoTempCoch(RociadoMuestreoTempCoche rociadoMuestreoTempCoch) {
		getRociadoMuestreoTempCoches().remove(rociadoMuestreoTempCoch);
		rociadoMuestreoTempCoch.setUsuario(null);

		return rociadoMuestreoTempCoch;
	}


	//bi-directional many-to-one association to RociadoProceso
	@OneToMany(mappedBy="usuario")
	public List<RociadoProceso> getRociadoProcesos() {
		return this.rociadoProcesos;
	}

	public void setRociadoProcesos(List<RociadoProceso> rociadoProcesos) {
		this.rociadoProcesos = rociadoProcesos;
	}

	public RociadoProceso addRociadoProceso(RociadoProceso rociadoProceso) {
		getRociadoProcesos().add(rociadoProceso);
		rociadoProceso.setUsuario(this);

		return rociadoProceso;
	}

	public RociadoProceso removeRociadoProceso(RociadoProceso rociadoProceso) {
		getRociadoProcesos().remove(rociadoProceso);
		rociadoProceso.setUsuario(null);

		return rociadoProceso;
	}


	//bi-directional many-to-one association to SeguridadAuditoriaConsultaDocumento
	@OneToMany(mappedBy="usuario")
	public List<SeguridadAuditoriaConsultaDocumento> getSeguridadAuditoriaConsultaDocumentos() {
		return this.seguridadAuditoriaConsultaDocumentos;
	}

	public void setSeguridadAuditoriaConsultaDocumentos(List<SeguridadAuditoriaConsultaDocumento> seguridadAuditoriaConsultaDocumentos) {
		this.seguridadAuditoriaConsultaDocumentos = seguridadAuditoriaConsultaDocumentos;
	}

	public SeguridadAuditoriaConsultaDocumento addSeguridadAuditoriaConsultaDocumento(SeguridadAuditoriaConsultaDocumento seguridadAuditoriaConsultaDocumento) {
		getSeguridadAuditoriaConsultaDocumentos().add(seguridadAuditoriaConsultaDocumento);
		seguridadAuditoriaConsultaDocumento.setUsuario(this);

		return seguridadAuditoriaConsultaDocumento;
	}

	public SeguridadAuditoriaConsultaDocumento removeSeguridadAuditoriaConsultaDocumento(SeguridadAuditoriaConsultaDocumento seguridadAuditoriaConsultaDocumento) {
		getSeguridadAuditoriaConsultaDocumentos().remove(seguridadAuditoriaConsultaDocumento);
		seguridadAuditoriaConsultaDocumento.setUsuario(null);

		return seguridadAuditoriaConsultaDocumento;
	}


	//bi-directional many-to-one association to TunelDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	public List<TunelDetalleProcesoCoche> getTunelDetalleProcesoCoches() {
		return this.tunelDetalleProcesoCoches;
	}

	public void setTunelDetalleProcesoCoches(List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches) {
		this.tunelDetalleProcesoCoches = tunelDetalleProcesoCoches;
	}

	public TunelDetalleProcesoCoche addTunelDetalleProcesoCoch(TunelDetalleProcesoCoche tunelDetalleProcesoCoch) {
		getTunelDetalleProcesoCoches().add(tunelDetalleProcesoCoch);
		tunelDetalleProcesoCoch.setUsuario(this);

		return tunelDetalleProcesoCoch;
	}

	public TunelDetalleProcesoCoche removeTunelDetalleProcesoCoch(TunelDetalleProcesoCoche tunelDetalleProcesoCoch) {
		getTunelDetalleProcesoCoches().remove(tunelDetalleProcesoCoch);
		tunelDetalleProcesoCoch.setUsuario(null);

		return tunelDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to TunelDetalleProcesoCocheSalida
	@OneToMany(mappedBy="usuario")
	public List<TunelDetalleProcesoCocheSalida> getTunelDetalleProcesoCocheSalidas() {
		return this.tunelDetalleProcesoCocheSalidas;
	}

	public void setTunelDetalleProcesoCocheSalidas(List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas) {
		this.tunelDetalleProcesoCocheSalidas = tunelDetalleProcesoCocheSalidas;
	}

	public TunelDetalleProcesoCocheSalida addTunelDetalleProcesoCocheSalida(TunelDetalleProcesoCocheSalida tunelDetalleProcesoCocheSalida) {
		getTunelDetalleProcesoCocheSalidas().add(tunelDetalleProcesoCocheSalida);
		tunelDetalleProcesoCocheSalida.setUsuario(this);

		return tunelDetalleProcesoCocheSalida;
	}

	public TunelDetalleProcesoCocheSalida removeTunelDetalleProcesoCocheSalida(TunelDetalleProcesoCocheSalida tunelDetalleProcesoCocheSalida) {
		getTunelDetalleProcesoCocheSalidas().remove(tunelDetalleProcesoCocheSalida);
		tunelDetalleProcesoCocheSalida.setUsuario(null);

		return tunelDetalleProcesoCocheSalida;
	}


	//bi-directional many-to-one association to TurnoGestionDetalle
	@OneToMany(mappedBy="usuario")
	public List<TurnoGestionDetalle> getTurnoGestionDetalles() {
		return this.turnoGestionDetalles;
	}

	public void setTurnoGestionDetalles(List<TurnoGestionDetalle> turnoGestionDetalles) {
		this.turnoGestionDetalles = turnoGestionDetalles;
	}

	public TurnoGestionDetalle addTurnoGestionDetalle(TurnoGestionDetalle turnoGestionDetalle) {
		getTurnoGestionDetalles().add(turnoGestionDetalle);
		turnoGestionDetalle.setUsuario(this);

		return turnoGestionDetalle;
	}

	public TurnoGestionDetalle removeTurnoGestionDetalle(TurnoGestionDetalle turnoGestionDetalle) {
		getTurnoGestionDetalles().remove(turnoGestionDetalle);
		turnoGestionDetalle.setUsuario(null);

		return turnoGestionDetalle;
	}


	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}


	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="iddepartamento")
	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="idgrupo")
	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


	//bi-directional many-to-one association to UsuariosAprobacion
	@OneToMany(mappedBy="usuario")
	public List<UsuariosAprobacion> getUsuariosAprobacions() {
		return this.usuariosAprobacions;
	}

	public void setUsuariosAprobacions(List<UsuariosAprobacion> usuariosAprobacions) {
		this.usuariosAprobacions = usuariosAprobacions;
	}

	public UsuariosAprobacion addUsuariosAprobacion(UsuariosAprobacion usuariosAprobacion) {
		getUsuariosAprobacions().add(usuariosAprobacion);
		usuariosAprobacion.setUsuario(this);

		return usuariosAprobacion;
	}

	public UsuariosAprobacion removeUsuariosAprobacion(UsuariosAprobacion usuariosAprobacion) {
		getUsuariosAprobacions().remove(usuariosAprobacion);
		usuariosAprobacion.setUsuario(null);

		return usuariosAprobacion;
	}

}