package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idusuario;

	private String clave;

	private String usuario;

	//bi-directional many-to-one association to BarcoDescarga
	@OneToMany(mappedBy="usuario")
	private List<BarcoDescarga> barcoDescargas;

	//bi-directional many-to-one association to CalidadDescongeladoDetalleTempAgua
	@OneToMany(mappedBy="usuario")
	private List<CalidadDescongeladoDetalleTempAgua> calidadDescongeladoDetalleTempAguas;

	//bi-directional many-to-one association to CalidadDescongeladoDetalleTempPescado
	@OneToMany(mappedBy="usuario")
	private List<CalidadDescongeladoDetalleTempPescado> calidadDescongeladoDetalleTempPescados;

	//bi-directional many-to-one association to CalidadDescongeladoTempAgua
	@OneToMany(mappedBy="usuario")
	private List<CalidadDescongeladoTempAgua> calidadDescongeladoTempAguas;

	//bi-directional many-to-one association to CalidadDescongeladoTempPescado
	@OneToMany(mappedBy="usuario")
	private List<CalidadDescongeladoTempPescado> calidadDescongeladoTempPescados;

	//bi-directional many-to-one association to CalidadDetalleEspecietallaCajonBanda
	@OneToMany(mappedBy="usuario")
	private List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas;

	//bi-directional many-to-one association to CalidadDetalleMuestreoCocina
	@OneToMany(mappedBy="usuario")
	private List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCoccion
	@OneToMany(mappedBy="usuario")
	private List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="usuario")
	private List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempLimpieza
	@OneToMany(mappedBy="usuario")
	private List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempPanzaEviscerado
	@OneToMany(mappedBy="usuario")
	private List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados;

	//bi-directional many-to-one association to CalidadDetallePcc
	@OneToMany(mappedBy="usuario")
	private List<CalidadDetallePcc> calidadDetallePccs;

	//bi-directional many-to-one association to CalidadDetallePccRemuestreoCajon
	@OneToMany(mappedBy="usuario")
	private List<CalidadDetallePccRemuestreoCajon> calidadDetallePccRemuestreoCajons;

	//bi-directional many-to-one association to CalidadDetalleSensorialMp
	@OneToMany(mappedBy="usuario")
	private List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps;

	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="usuario")
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;

	//bi-directional many-to-one association to CalidadEspecietallaCajonBanda
	@OneToMany(mappedBy="usuario")
	private List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="usuario")
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;

	//bi-directional many-to-one association to CalidadMuestraAreaCabeceraAprobacion
	@OneToMany(mappedBy="usuario")
	private List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions;

	//bi-directional many-to-one association to CalidadMuestraAreaDetalle
	@OneToMany(mappedBy="usuario")
	private List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles;

	//bi-directional many-to-one association to CalidadMuestraAreaDetalleMuestra
	@OneToMany(mappedBy="usuario")
	private List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras;

	//bi-directional many-to-one association to CalidadMuestraCabeceraDescargaMotivo
	@OneToMany(mappedBy="usuario")
	private List<CalidadMuestraCabeceraDescargaMotivo> calidadMuestraCabeceraDescargaMotivos;

	//bi-directional many-to-one association to CalidadMuestreoCocina
	@OneToMany(mappedBy="usuario")
	private List<CalidadMuestreoCocina> calidadMuestreoCocinas;

	//bi-directional many-to-one association to CalidadMuestreoTempCoccion
	@OneToMany(mappedBy="usuario")
	private List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions;

	//bi-directional many-to-one association to CalidadMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="usuario")
	private List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados;

	//bi-directional many-to-one association to CalidadMuestreoTempLimpieza
	@OneToMany(mappedBy="usuario")
	private List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas;

	//bi-directional many-to-one association to CalidadMuestreoTempPanzasEviscerado
	@OneToMany(mappedBy="usuario")
	private List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados;

	//bi-directional many-to-one association to CalidadPccRemuestreoCajon
	@OneToMany(mappedBy="usuario")
	private List<CalidadPccRemuestreoCajon> calidadPccRemuestreoCajons;

	//bi-directional many-to-one association to CalidadRespuestaPreguntaBpmclasificacion
	@OneToMany(mappedBy="usuario")
	private List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions;

	//bi-directional many-to-one association to CalidadRespuestaPreguntaBpmdesembarco
	@OneToMany(mappedBy="usuario")
	private List<CalidadRespuestaPreguntaBpmdesembarco> calidadRespuestaPreguntaBpmdesembarcos;

	//bi-directional many-to-one association to CalidadTemperaturaCajonBanda
	@OneToMany(mappedBy="usuario")
	private List<CalidadTemperaturaCajonBanda> calidadTemperaturaCajonBandas;

	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="usuario")
	private List<CamaraCajon> camaraCajons;

	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	private List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheAdic
	@OneToMany(mappedBy="usuario")
	private List<CoccionDetalleMuestreoTempCocheAdic> coccionDetalleMuestreoTempCocheAdics;

	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheIngreso
	@OneToMany(mappedBy="usuario")
	private List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos;

	//bi-directional many-to-one association to CoccionDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="usuario")
	private List<CoccionDetalleProcesoCocheTemperatura> coccionDetalleProcesoCocheTemperaturas;

	//bi-directional many-to-one association to CoccionMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	private List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches;

	//bi-directional many-to-one association to CoccionMuestreoTempCocheIngreso
	@OneToMany(mappedBy="usuario")
	private List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos;

	//bi-directional many-to-one association to CoccionProceso
	@OneToMany(mappedBy="usuario")
	private List<CoccionProceso> coccionProcesos;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@OneToMany(mappedBy="usuario")
	private List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles;

	//bi-directional many-to-one association to CocinaProcesoControlEspinaDetalle
	@OneToMany(mappedBy="usuario")
	private List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles;

	//bi-directional many-to-one association to ContraloriaCoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	private List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to ContraloriaDetalleRackeoProcesoTemperatura
	@OneToMany(mappedBy="usuario")
	private List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas;

	//bi-directional many-to-one association to ContraloriaEvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	private List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to ControlBatchProceso
	@OneToMany(mappedBy="usuario")
	private List<ControlBatchProceso> controlBatchProcesos;

	//bi-directional many-to-one association to ControlDetalleBatchEsterilizado
	@OneToMany(mappedBy="usuario")
	private List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados;

	//bi-directional many-to-one association to ControlDetalleBatchLimpieza
	@OneToMany(mappedBy="usuario")
	private List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas;

	//bi-directional many-to-one association to ControlDetalleBatchMaquina
	@OneToMany(mappedBy="usuario")
	private List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas;

	//bi-directional many-to-one association to ControlDetalleBatchRallado
	@OneToMany(mappedBy="usuario1")
	private List<ControlDetalleBatchRallado> controlDetalleBatchRallados1;

	//bi-directional many-to-one association to ControlDetalleBatchRallado
	@OneToMany(mappedBy="usuario2")
	private List<ControlDetalleBatchRallado> controlDetalleBatchRallados2;

	//bi-directional many-to-one association to ControlDetalleBatchRallado
	@OneToMany(mappedBy="usuario3")
	private List<ControlDetalleBatchRallado> controlDetalleBatchRallados3;

	//bi-directional many-to-one association to ControlFichaBatch
	@OneToMany(mappedBy="usuario")
	private List<ControlFichaBatch> controlFichaBatches;

	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="usuario")
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;

	//bi-directional many-to-one association to DescongeladoDetalleDuchaAperturaTalla
	@OneToMany(mappedBy="usuario")
	private List<DescongeladoDetalleDuchaAperturaTalla> descongeladoDetalleDuchaAperturaTallas;

	//bi-directional many-to-one association to DescongeladoDetalleDuchaTallaMonitoreo
	@OneToMany(mappedBy="usuario")
	private List<DescongeladoDetalleDuchaTallaMonitoreo> descongeladoDetalleDuchaTallaMonitoreos;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="usuario")
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;

	//bi-directional many-to-one association to DescongeladoDetalleProcesoContraloria
	@OneToMany(mappedBy="usuario")
	private List<DescongeladoDetalleProcesoContraloria> descongeladoDetalleProcesoContralorias;

	//bi-directional many-to-one association to DescongeladoDetalleProcesoFinForzado
	@OneToMany(mappedBy="usuario")
	private List<DescongeladoDetalleProcesoFinForzado> descongeladoDetalleProcesoFinForzados;

	//bi-directional many-to-one association to DescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="usuario")
	private List<DescongeladoDetalleProcesoTempIng> descongeladoDetalleProcesoTempIngs;

	//bi-directional many-to-one association to DescongeladoDetalleProcesoTemperatura
	@OneToMany(mappedBy="usuario")
	private List<DescongeladoDetalleProcesoTemperatura> descongeladoDetalleProcesoTemperaturas;

	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@OneToMany(mappedBy="usuario")
	private List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="usuario1")
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas1;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="usuario2")
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas2;

	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="usuario")
	private List<DesperdicioDetalle> desperdicioDetalles;

	//bi-directional many-to-one association to DuchaAperturaCierreDetalle
	@OneToMany(mappedBy="usuario")
	private List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles;

	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="usuario")
	private List<EnvasadoProceso> envasadoProcesos;

	//bi-directional many-to-one association to EspecialidadesProceso
	@OneToMany(mappedBy="usuario")
	private List<EspecialidadesProceso> especialidadesProcesos;

	//bi-directional many-to-one association to EspecialidadesProcesoEnlatado
	@OneToMany(mappedBy="usuario")
	private List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados;

	//bi-directional many-to-one association to EstandarEficienciaKilosPagoPlexus
	@OneToMany(mappedBy="usuario1")
	private List<EstandarEficienciaKilosPagoPlexus> estandarEficienciaKilosPagoPlexuses1;

	//bi-directional many-to-one association to EstandarEficienciaKilosPagoPlexus
	@OneToMany(mappedBy="usuario2")
	private List<EstandarEficienciaKilosPagoPlexus> estandarEficienciaKilosPagoPlexuses2;

	//bi-directional many-to-one association to EstandarEficienciaKilosPlexus
	@OneToMany(mappedBy="usuario1")
	private List<EstandarEficienciaKilosPlexus> estandarEficienciaKilosPlexuses1;

	//bi-directional many-to-one association to EstandarEficienciaKilosPlexus
	@OneToMany(mappedBy="usuario2")
	private List<EstandarEficienciaKilosPlexus> estandarEficienciaKilosPlexuses2;

	//bi-directional many-to-one association to EvisceradoAuditoriaReimpresion
	@OneToMany(mappedBy="usuario")
	private List<EvisceradoAuditoriaReimpresion> evisceradoAuditoriaReimpresions;

	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="usuario1")
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions1;

	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="usuario2")
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions2;

	//bi-directional many-to-one association to EvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	private List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to EvisceradoDetalleProceso
	@OneToMany(mappedBy="usuario")
	private List<EvisceradoDetalleProceso> evisceradoDetalleProcesos;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoModificacion
	@OneToMany(mappedBy="usuario")
	private List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions;

	//bi-directional many-to-one association to EvisceradoMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	private List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches;

	//bi-directional many-to-one association to EvisceradoRackeoLote
	@OneToMany(mappedBy="usuario")
	private List<EvisceradoRackeoLote> evisceradoRackeoLotes;

	//bi-directional many-to-one association to EvisceradoReanudacionSecCoche
	@OneToMany(mappedBy="usuario")
	private List<EvisceradoReanudacionSecCoche> evisceradoReanudacionSecCoches;

	//bi-directional many-to-one association to EvisceradoSubproductoCrudo
	@OneToMany(mappedBy="usuario")
	private List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos;

	//bi-directional many-to-one association to EvolutionAuditoriaDetalle
	@OneToMany(mappedBy="usuario")
	private List<EvolutionAuditoriaDetalle> evolutionAuditoriaDetalles;

	//bi-directional many-to-one association to GestionTurno
	@OneToMany(mappedBy="usuario")
	private List<GestionTurno> gestionTurnos;

	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="usuario")
	private List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes;

	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@OneToMany(mappedBy="usuario")
	private List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes;

	//bi-directional many-to-one association to ImpresionDetalle
	@OneToMany(mappedBy="usuario")
	private List<ImpresionDetalle> impresionDetalles;

	//bi-directional many-to-one association to LimpiezaAsignacionCanastilla
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas;

	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlanta
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaCabeceraCortesPlanta> limpiezaCabeceraCortesPlantas;

	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlantaLineaEmpleado
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaCabeceraCortesPlantaLineaEmpleado> limpiezaCabeceraCortesPlantaLineaEmpleados;

	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="usuario1")
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions1;

	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="usuario2")
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions2;

	//bi-directional many-to-one association to LimpiezaCocheObservacione
	@OneToMany(mappedBy="usuario1")
	private List<LimpiezaCocheObservacione> limpiezaCocheObservaciones1;

	//bi-directional many-to-one association to LimpiezaCocheObservacione
	@OneToMany(mappedBy="usuario2")
	private List<LimpiezaCocheObservacione> limpiezaCocheObservaciones2;

	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;

	//bi-directional many-to-one association to LimpiezaDetalleCortesPlantaLineaEmpleado
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados;

	//bi-directional many-to-one association to LimpiezaDetalleDesperdicio
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios;

	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejado
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetallePesoDespellejado> limpiezaDetallePesoDespellejados;

	//bi-directional many-to-one association to LimpiezaDetallePesoDespellejadoT
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoCocheTemperaturaBatch
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes;

	//bi-directional many-to-one association to LimpiezaDetalleTipoCorte
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes;

	//bi-directional many-to-one association to LimpiezaDetalleTipoPara
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas;

	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;

	//bi-directional many-to-one association to LimpiezaLomoLimpioCoche
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches;

	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaProceso> limpiezaProcesos;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoFalta
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoMarcacione
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoTotalInicial
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials;

	//bi-directional many-to-one association to LimpiezaProcesoLineaTara
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaProcesoLineaTara> limpiezaProcesoLineaTaras;

	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos;

	//bi-directional many-to-one association to LimpiezaRalladoBatchCabecera
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaRalladoBatchCabecera> limpiezaRalladoBatchCabeceras;

	//bi-directional many-to-one association to LimpiezaRalladoBatchDetalle
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaRalladoBatchDetalle> limpiezaRalladoBatchDetalles;

	//bi-directional many-to-one association to LimpiezaRalladoGabetaMezclaBatch
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches;

	//bi-directional many-to-one association to LimpiezaRalladoMezclaBatchCabecera
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaRalladoMezclaBatchCabecera> limpiezaRalladoMezclaBatchCabeceras;

	//bi-directional many-to-one association to LimpiezaRalladoMezclaBatchDetalle
	@OneToMany(mappedBy="usuario")
	private List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles;

	//bi-directional many-to-one association to LonjasDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	private List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches;

	//bi-directional many-to-one association to LonjasDetalleProcesoCocheEmpacado
	@OneToMany(mappedBy="usuario")
	private List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados;

	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="usuario")
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;

	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="usuario")
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;

	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="usuario")
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;

	//bi-directional many-to-one association to LonjasOrdenProduccion
	@OneToMany(mappedBy="usuario")
	private List<LonjasOrdenProduccion> lonjasOrdenProduccions;

	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="usuario")
	private List<LonjasProceso> lonjasProcesos;

	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@OneToMany(mappedBy="usuario")
	private List<LonjasProcesoEmpleado> lonjasProcesoEmpleados;

	//bi-directional many-to-one association to ObservacionesDetalleProceso
	@OneToMany(mappedBy="usuario")
	private List<ObservacionesDetalleProceso> observacionesDetalleProcesos;

	//bi-directional many-to-one association to ObservacionesProceso
	@OneToMany(mappedBy="usuario")
	private List<ObservacionesProceso> observacionesProcesos;

	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="usuario1")
	private List<ObservacionesPuntoControl> observacionesPuntoControls1;

	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="usuario2")
	private List<ObservacionesPuntoControl> observacionesPuntoControls2;

	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="usuario3")
	private List<ObservacionesPuntoControl> observacionesPuntoControls3;

	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="usuario")
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;

	//bi-directional many-to-one association to OeeDetalleParada
	@OneToMany(mappedBy="usuario")
	private List<OeeDetalleParada> oeeDetalleParadas;

	//bi-directional many-to-one association to OeeEnvasadoCabeceraVelocidadMaquinaCerradora
	@OneToMany(mappedBy="usuario")
	private List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;

	//bi-directional many-to-one association to OeeEnvasadoDetalleVelocidadMaquinaCerradora
	@OneToMany(mappedBy="usuario")
	private List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras;

	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@OneToMany(mappedBy="usuario")
	private List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos;

	//bi-directional many-to-one association to PanzasDetalleProcesoConteo
	@OneToMany(mappedBy="usuario")
	private List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos;

	//bi-directional many-to-one association to PanzasDetalleProcesoLote
	@OneToMany(mappedBy="usuario")
	private List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes;

	//bi-directional many-to-one association to PanzasProceso
	@OneToMany(mappedBy="usuario")
	private List<PanzasProceso> panzasProcesos;

	//bi-directional many-to-one association to ParametroAuditoria
	@OneToMany(mappedBy="usuario")
	private List<ParametroAuditoria> parametroAuditorias;

	//bi-directional many-to-one association to PedidoProduccionArchivoCargaCabecera
	@OneToMany(mappedBy="usuario")
	private List<PedidoProduccionArchivoCargaCabecera> pedidoProduccionArchivoCargaCabeceras;

	//bi-directional many-to-one association to PedidoProduccionCabecera
	@OneToMany(mappedBy="usuario")
	private List<PedidoProduccionCabecera> pedidoProduccionCabeceras;

	//bi-directional many-to-one association to PlanificacionCargaArchivo
	@OneToMany(mappedBy="usuario")
	private List<PlanificacionCargaArchivo> planificacionCargaArchivos;

	//bi-directional many-to-one association to PouchDetalleProcesoConteo
	@OneToMany(mappedBy="usuario")
	private List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos;

	//bi-directional many-to-one association to PouchDetalleProcesoLote
	@OneToMany(mappedBy="usuario")
	private List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes;

	//bi-directional many-to-one association to PouchProceso
	@OneToMany(mappedBy="usuario")
	private List<PouchProceso> pouchProcesos;

	//bi-directional many-to-one association to ProduccionArchivoCargaLote
	@OneToMany(mappedBy="usuario")
	private List<ProduccionArchivoCargaLote> produccionArchivoCargaLotes;

	//bi-directional many-to-one association to ProduccionCargaArchivoPedido
	@OneToMany(mappedBy="usuario")
	private List<ProduccionCargaArchivoPedido> produccionCargaArchivoPedidos;

	//bi-directional many-to-one association to RackeoProceso
	@OneToMany(mappedBy="usuario")
	private List<RackeoProceso> rackeoProcesos;

	//bi-directional many-to-one association to RackeoProcesoEmpleado
	@OneToMany(mappedBy="usuario")
	private List<RackeoProcesoEmpleado> rackeoProcesoEmpleados;

	//bi-directional many-to-one association to ReportesNivelesUsuario
	@OneToMany(mappedBy="usuario")
	private List<ReportesNivelesUsuario> reportesNivelesUsuarios;

	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="usuario1")
	private List<ReportesPuntoControl> reportesPuntoControls1;

	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="usuario2")
	private List<ReportesPuntoControl> reportesPuntoControls2;

	//bi-directional many-to-one association to RociadoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	private List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	private List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches;

	//bi-directional many-to-one association to RociadoDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="usuario")
	private List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas;

	//bi-directional many-to-one association to RociadoMuestreoTempCoche
	@OneToMany(mappedBy="usuario")
	private List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches;

	//bi-directional many-to-one association to RociadoProceso
	@OneToMany(mappedBy="usuario")
	private List<RociadoProceso> rociadoProcesos;

	//bi-directional many-to-one association to SeguridadAuditoriaConsultaDocumento
	@OneToMany(mappedBy="usuario")
	private List<SeguridadAuditoriaConsultaDocumento> seguridadAuditoriaConsultaDocumentos;

	//bi-directional many-to-one association to TunelDetalleProcesoCoche
	@OneToMany(mappedBy="usuario")
	private List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches;

	//bi-directional many-to-one association to TunelDetalleProcesoCocheSalida
	@OneToMany(mappedBy="usuario")
	private List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas;

	//bi-directional many-to-one association to TurnoGestionDetalle
	@OneToMany(mappedBy="usuario")
	private List<TurnoGestionDetalle> turnoGestionDetalles;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="idarea")
	private Area area;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="iddepartamento")
	private Departamento departamento;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="idgrupo")
	private Grupo grupo;

	//bi-directional many-to-one association to UsuariosAprobacion
	@OneToMany(mappedBy="usuario")
	private List<UsuariosAprobacion> usuariosAprobacions;

	public Usuario() {
	}

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

	public List<BarcoDescarga> getBarcoDescargas() {
		return this.barcoDescargas;
	}

	public void setBarcoDescargas(List<BarcoDescarga> barcoDescargas) {
		this.barcoDescargas = barcoDescargas;
	}

	public List<CalidadDescongeladoDetalleTempAgua> getCalidadDescongeladoDetalleTempAguas() {
		return this.calidadDescongeladoDetalleTempAguas;
	}

	public void setCalidadDescongeladoDetalleTempAguas(List<CalidadDescongeladoDetalleTempAgua> calidadDescongeladoDetalleTempAguas) {
		this.calidadDescongeladoDetalleTempAguas = calidadDescongeladoDetalleTempAguas;
	}

	public List<CalidadDescongeladoDetalleTempPescado> getCalidadDescongeladoDetalleTempPescados() {
		return this.calidadDescongeladoDetalleTempPescados;
	}

	public void setCalidadDescongeladoDetalleTempPescados(List<CalidadDescongeladoDetalleTempPescado> calidadDescongeladoDetalleTempPescados) {
		this.calidadDescongeladoDetalleTempPescados = calidadDescongeladoDetalleTempPescados;
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

	public List<CalidadDetalleEspecietallaCajonBanda> getCalidadDetalleEspecietallaCajonBandas() {
		return this.calidadDetalleEspecietallaCajonBandas;
	}

	public void setCalidadDetalleEspecietallaCajonBandas(List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas) {
		this.calidadDetalleEspecietallaCajonBandas = calidadDetalleEspecietallaCajonBandas;
	}

	public List<CalidadDetalleMuestreoCocina> getCalidadDetalleMuestreoCocinas() {
		return this.calidadDetalleMuestreoCocinas;
	}

	public void setCalidadDetalleMuestreoCocinas(List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas) {
		this.calidadDetalleMuestreoCocinas = calidadDetalleMuestreoCocinas;
	}

	public List<CalidadDetalleMuestreoTempCoccion> getCalidadDetalleMuestreoTempCoccions() {
		return this.calidadDetalleMuestreoTempCoccions;
	}

	public void setCalidadDetalleMuestreoTempCoccions(List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions) {
		this.calidadDetalleMuestreoTempCoccions = calidadDetalleMuestreoTempCoccions;
	}

	public List<CalidadDetalleMuestreoTempCochesEviscerado> getCalidadDetalleMuestreoTempCochesEviscerados() {
		return this.calidadDetalleMuestreoTempCochesEviscerados;
	}

	public void setCalidadDetalleMuestreoTempCochesEviscerados(List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados) {
		this.calidadDetalleMuestreoTempCochesEviscerados = calidadDetalleMuestreoTempCochesEviscerados;
	}

	public List<CalidadDetalleMuestreoTempLimpieza> getCalidadDetalleMuestreoTempLimpiezas() {
		return this.calidadDetalleMuestreoTempLimpiezas;
	}

	public void setCalidadDetalleMuestreoTempLimpiezas(List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas) {
		this.calidadDetalleMuestreoTempLimpiezas = calidadDetalleMuestreoTempLimpiezas;
	}

	public List<CalidadDetalleMuestreoTempPanzaEviscerado> getCalidadDetalleMuestreoTempPanzaEviscerados() {
		return this.calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public void setCalidadDetalleMuestreoTempPanzaEviscerados(List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados) {
		this.calidadDetalleMuestreoTempPanzaEviscerados = calidadDetalleMuestreoTempPanzaEviscerados;
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

	public List<CalidadDetalleSensorialMp> getCalidadDetalleSensorialMps() {
		return this.calidadDetalleSensorialMps;
	}

	public void setCalidadDetalleSensorialMps(List<CalidadDetalleSensorialMp> calidadDetalleSensorialMps) {
		this.calidadDetalleSensorialMps = calidadDetalleSensorialMps;
	}

	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public List<CalidadEspecietallaCajonBanda> getCalidadEspecietallaCajonBandas() {
		return this.calidadEspecietallaCajonBandas;
	}

	public void setCalidadEspecietallaCajonBandas(List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas) {
		this.calidadEspecietallaCajonBandas = calidadEspecietallaCajonBandas;
	}

	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public List<CalidadMuestraAreaCabeceraAprobacion> getCalidadMuestraAreaCabeceraAprobacions() {
		return this.calidadMuestraAreaCabeceraAprobacions;
	}

	public void setCalidadMuestraAreaCabeceraAprobacions(List<CalidadMuestraAreaCabeceraAprobacion> calidadMuestraAreaCabeceraAprobacions) {
		this.calidadMuestraAreaCabeceraAprobacions = calidadMuestraAreaCabeceraAprobacions;
	}

	public List<CalidadMuestraAreaDetalle> getCalidadMuestraAreaDetalles() {
		return this.calidadMuestraAreaDetalles;
	}

	public void setCalidadMuestraAreaDetalles(List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles) {
		this.calidadMuestraAreaDetalles = calidadMuestraAreaDetalles;
	}

	public List<CalidadMuestraAreaDetalleMuestra> getCalidadMuestraAreaDetalleMuestras() {
		return this.calidadMuestraAreaDetalleMuestras;
	}

	public void setCalidadMuestraAreaDetalleMuestras(List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras) {
		this.calidadMuestraAreaDetalleMuestras = calidadMuestraAreaDetalleMuestras;
	}

	public List<CalidadMuestraCabeceraDescargaMotivo> getCalidadMuestraCabeceraDescargaMotivos() {
		return this.calidadMuestraCabeceraDescargaMotivos;
	}

	public void setCalidadMuestraCabeceraDescargaMotivos(List<CalidadMuestraCabeceraDescargaMotivo> calidadMuestraCabeceraDescargaMotivos) {
		this.calidadMuestraCabeceraDescargaMotivos = calidadMuestraCabeceraDescargaMotivos;
	}

	public List<CalidadMuestreoCocina> getCalidadMuestreoCocinas() {
		return this.calidadMuestreoCocinas;
	}

	public void setCalidadMuestreoCocinas(List<CalidadMuestreoCocina> calidadMuestreoCocinas) {
		this.calidadMuestreoCocinas = calidadMuestreoCocinas;
	}

	public List<CalidadMuestreoTempCoccion> getCalidadMuestreoTempCoccions() {
		return this.calidadMuestreoTempCoccions;
	}

	public void setCalidadMuestreoTempCoccions(List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions) {
		this.calidadMuestreoTempCoccions = calidadMuestreoTempCoccions;
	}

	public List<CalidadMuestreoTempCochesEviscerado> getCalidadMuestreoTempCochesEviscerados() {
		return this.calidadMuestreoTempCochesEviscerados;
	}

	public void setCalidadMuestreoTempCochesEviscerados(List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados) {
		this.calidadMuestreoTempCochesEviscerados = calidadMuestreoTempCochesEviscerados;
	}

	public List<CalidadMuestreoTempLimpieza> getCalidadMuestreoTempLimpiezas() {
		return this.calidadMuestreoTempLimpiezas;
	}

	public void setCalidadMuestreoTempLimpiezas(List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas) {
		this.calidadMuestreoTempLimpiezas = calidadMuestreoTempLimpiezas;
	}

	public List<CalidadMuestreoTempPanzasEviscerado> getCalidadMuestreoTempPanzasEviscerados() {
		return this.calidadMuestreoTempPanzasEviscerados;
	}

	public void setCalidadMuestreoTempPanzasEviscerados(List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados) {
		this.calidadMuestreoTempPanzasEviscerados = calidadMuestreoTempPanzasEviscerados;
	}

	public List<CalidadPccRemuestreoCajon> getCalidadPccRemuestreoCajons() {
		return this.calidadPccRemuestreoCajons;
	}

	public void setCalidadPccRemuestreoCajons(List<CalidadPccRemuestreoCajon> calidadPccRemuestreoCajons) {
		this.calidadPccRemuestreoCajons = calidadPccRemuestreoCajons;
	}

	public List<CalidadRespuestaPreguntaBpmclasificacion> getCalidadRespuestaPreguntaBpmclasificacions() {
		return this.calidadRespuestaPreguntaBpmclasificacions;
	}

	public void setCalidadRespuestaPreguntaBpmclasificacions(List<CalidadRespuestaPreguntaBpmclasificacion> calidadRespuestaPreguntaBpmclasificacions) {
		this.calidadRespuestaPreguntaBpmclasificacions = calidadRespuestaPreguntaBpmclasificacions;
	}

	public List<CalidadRespuestaPreguntaBpmdesembarco> getCalidadRespuestaPreguntaBpmdesembarcos() {
		return this.calidadRespuestaPreguntaBpmdesembarcos;
	}

	public void setCalidadRespuestaPreguntaBpmdesembarcos(List<CalidadRespuestaPreguntaBpmdesembarco> calidadRespuestaPreguntaBpmdesembarcos) {
		this.calidadRespuestaPreguntaBpmdesembarcos = calidadRespuestaPreguntaBpmdesembarcos;
	}

	public List<CalidadTemperaturaCajonBanda> getCalidadTemperaturaCajonBandas() {
		return this.calidadTemperaturaCajonBandas;
	}

	public void setCalidadTemperaturaCajonBandas(List<CalidadTemperaturaCajonBanda> calidadTemperaturaCajonBandas) {
		this.calidadTemperaturaCajonBandas = calidadTemperaturaCajonBandas;
	}

	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public List<CoccionDetalleMuestreoTempCoche> getCoccionDetalleMuestreoTempCoches() {
		return this.coccionDetalleMuestreoTempCoches;
	}

	public void setCoccionDetalleMuestreoTempCoches(List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches) {
		this.coccionDetalleMuestreoTempCoches = coccionDetalleMuestreoTempCoches;
	}

	public List<CoccionDetalleMuestreoTempCocheAdic> getCoccionDetalleMuestreoTempCocheAdics() {
		return this.coccionDetalleMuestreoTempCocheAdics;
	}

	public void setCoccionDetalleMuestreoTempCocheAdics(List<CoccionDetalleMuestreoTempCocheAdic> coccionDetalleMuestreoTempCocheAdics) {
		this.coccionDetalleMuestreoTempCocheAdics = coccionDetalleMuestreoTempCocheAdics;
	}

	public List<CoccionDetalleMuestreoTempCocheIngreso> getCoccionDetalleMuestreoTempCocheIngresos() {
		return this.coccionDetalleMuestreoTempCocheIngresos;
	}

	public void setCoccionDetalleMuestreoTempCocheIngresos(List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos) {
		this.coccionDetalleMuestreoTempCocheIngresos = coccionDetalleMuestreoTempCocheIngresos;
	}

	public List<CoccionDetalleProcesoCocheTemperatura> getCoccionDetalleProcesoCocheTemperaturas() {
		return this.coccionDetalleProcesoCocheTemperaturas;
	}

	public void setCoccionDetalleProcesoCocheTemperaturas(List<CoccionDetalleProcesoCocheTemperatura> coccionDetalleProcesoCocheTemperaturas) {
		this.coccionDetalleProcesoCocheTemperaturas = coccionDetalleProcesoCocheTemperaturas;
	}

	public List<CoccionMuestreoTempCoche> getCoccionMuestreoTempCoches() {
		return this.coccionMuestreoTempCoches;
	}

	public void setCoccionMuestreoTempCoches(List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches) {
		this.coccionMuestreoTempCoches = coccionMuestreoTempCoches;
	}

	public List<CoccionMuestreoTempCocheIngreso> getCoccionMuestreoTempCocheIngresos() {
		return this.coccionMuestreoTempCocheIngresos;
	}

	public void setCoccionMuestreoTempCocheIngresos(List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos) {
		this.coccionMuestreoTempCocheIngresos = coccionMuestreoTempCocheIngresos;
	}

	public List<CoccionProceso> getCoccionProcesos() {
		return this.coccionProcesos;
	}

	public void setCoccionProcesos(List<CoccionProceso> coccionProcesos) {
		this.coccionProcesos = coccionProcesos;
	}

	public List<CocinaAperturaCierreDetalle> getCocinaAperturaCierreDetalles() {
		return this.cocinaAperturaCierreDetalles;
	}

	public void setCocinaAperturaCierreDetalles(List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles) {
		this.cocinaAperturaCierreDetalles = cocinaAperturaCierreDetalles;
	}

	public List<CocinaProcesoControlEspinaDetalle> getCocinaProcesoControlEspinaDetalles() {
		return this.cocinaProcesoControlEspinaDetalles;
	}

	public void setCocinaProcesoControlEspinaDetalles(List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles) {
		this.cocinaProcesoControlEspinaDetalles = cocinaProcesoControlEspinaDetalles;
	}

	public List<ContraloriaCoccionDetalleMuestreoTempCoche> getContraloriaCoccionDetalleMuestreoTempCoches() {
		return this.contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public void setContraloriaCoccionDetalleMuestreoTempCoches(List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches) {
		this.contraloriaCoccionDetalleMuestreoTempCoches = contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public List<ContraloriaDetalleRackeoProcesoTemperatura> getContraloriaDetalleRackeoProcesoTemperaturas() {
		return this.contraloriaDetalleRackeoProcesoTemperaturas;
	}

	public void setContraloriaDetalleRackeoProcesoTemperaturas(List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas) {
		this.contraloriaDetalleRackeoProcesoTemperaturas = contraloriaDetalleRackeoProcesoTemperaturas;
	}

	public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getContraloriaEvisceradoDetalleMuestreoTempCoches() {
		return this.contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public void setContraloriaEvisceradoDetalleMuestreoTempCoches(List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches) {
		this.contraloriaEvisceradoDetalleMuestreoTempCoches = contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public List<ControlBatchProceso> getControlBatchProcesos() {
		return this.controlBatchProcesos;
	}

	public void setControlBatchProcesos(List<ControlBatchProceso> controlBatchProcesos) {
		this.controlBatchProcesos = controlBatchProcesos;
	}

	public List<ControlDetalleBatchEsterilizado> getControlDetalleBatchEsterilizados() {
		return this.controlDetalleBatchEsterilizados;
	}

	public void setControlDetalleBatchEsterilizados(List<ControlDetalleBatchEsterilizado> controlDetalleBatchEsterilizados) {
		this.controlDetalleBatchEsterilizados = controlDetalleBatchEsterilizados;
	}

	public List<ControlDetalleBatchLimpieza> getControlDetalleBatchLimpiezas() {
		return this.controlDetalleBatchLimpiezas;
	}

	public void setControlDetalleBatchLimpiezas(List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas) {
		this.controlDetalleBatchLimpiezas = controlDetalleBatchLimpiezas;
	}

	public List<ControlDetalleBatchMaquina> getControlDetalleBatchMaquinas() {
		return this.controlDetalleBatchMaquinas;
	}

	public void setControlDetalleBatchMaquinas(List<ControlDetalleBatchMaquina> controlDetalleBatchMaquinas) {
		this.controlDetalleBatchMaquinas = controlDetalleBatchMaquinas;
	}

	public List<ControlDetalleBatchRallado> getControlDetalleBatchRallados1() {
		return this.controlDetalleBatchRallados1;
	}

	public void setControlDetalleBatchRallados1(List<ControlDetalleBatchRallado> controlDetalleBatchRallados1) {
		this.controlDetalleBatchRallados1 = controlDetalleBatchRallados1;
	}

	public List<ControlDetalleBatchRallado> getControlDetalleBatchRallados2() {
		return this.controlDetalleBatchRallados2;
	}

	public void setControlDetalleBatchRallados2(List<ControlDetalleBatchRallado> controlDetalleBatchRallados2) {
		this.controlDetalleBatchRallados2 = controlDetalleBatchRallados2;
	}

	public List<ControlDetalleBatchRallado> getControlDetalleBatchRallados3() {
		return this.controlDetalleBatchRallados3;
	}

	public void setControlDetalleBatchRallados3(List<ControlDetalleBatchRallado> controlDetalleBatchRallados3) {
		this.controlDetalleBatchRallados3 = controlDetalleBatchRallados3;
	}

	public List<ControlFichaBatch> getControlFichaBatches() {
		return this.controlFichaBatches;
	}

	public void setControlFichaBatches(List<ControlFichaBatch> controlFichaBatches) {
		this.controlFichaBatches = controlFichaBatches;
	}

	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public List<DescongeladoDetalleDuchaAperturaTalla> getDescongeladoDetalleDuchaAperturaTallas() {
		return this.descongeladoDetalleDuchaAperturaTallas;
	}

	public void setDescongeladoDetalleDuchaAperturaTallas(List<DescongeladoDetalleDuchaAperturaTalla> descongeladoDetalleDuchaAperturaTallas) {
		this.descongeladoDetalleDuchaAperturaTallas = descongeladoDetalleDuchaAperturaTallas;
	}

	public List<DescongeladoDetalleDuchaTallaMonitoreo> getDescongeladoDetalleDuchaTallaMonitoreos() {
		return this.descongeladoDetalleDuchaTallaMonitoreos;
	}

	public void setDescongeladoDetalleDuchaTallaMonitoreos(List<DescongeladoDetalleDuchaTallaMonitoreo> descongeladoDetalleDuchaTallaMonitoreos) {
		this.descongeladoDetalleDuchaTallaMonitoreos = descongeladoDetalleDuchaTallaMonitoreos;
	}

	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public List<DescongeladoDetalleProcesoContraloria> getDescongeladoDetalleProcesoContralorias() {
		return this.descongeladoDetalleProcesoContralorias;
	}

	public void setDescongeladoDetalleProcesoContralorias(List<DescongeladoDetalleProcesoContraloria> descongeladoDetalleProcesoContralorias) {
		this.descongeladoDetalleProcesoContralorias = descongeladoDetalleProcesoContralorias;
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

	public List<DescongeladoDuchaAperturaCierreDetalle> getDescongeladoDuchaAperturaCierreDetalles() {
		return this.descongeladoDuchaAperturaCierreDetalles;
	}

	public void setDescongeladoDuchaAperturaCierreDetalles(List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles) {
		this.descongeladoDuchaAperturaCierreDetalles = descongeladoDuchaAperturaCierreDetalles;
	}

	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas1() {
		return this.desperdicioCajonHarinas1;
	}

	public void setDesperdicioCajonHarinas1(List<DesperdicioCajonHarina> desperdicioCajonHarinas1) {
		this.desperdicioCajonHarinas1 = desperdicioCajonHarinas1;
	}

	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas2() {
		return this.desperdicioCajonHarinas2;
	}

	public void setDesperdicioCajonHarinas2(List<DesperdicioCajonHarina> desperdicioCajonHarinas2) {
		this.desperdicioCajonHarinas2 = desperdicioCajonHarinas2;
	}

	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public List<DuchaAperturaCierreDetalle> getDuchaAperturaCierreDetalles() {
		return this.duchaAperturaCierreDetalles;
	}

	public void setDuchaAperturaCierreDetalles(List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles) {
		this.duchaAperturaCierreDetalles = duchaAperturaCierreDetalles;
	}

	public List<EnvasadoProceso> getEnvasadoProcesos() {
		return this.envasadoProcesos;
	}

	public void setEnvasadoProcesos(List<EnvasadoProceso> envasadoProcesos) {
		this.envasadoProcesos = envasadoProcesos;
	}

	public List<EspecialidadesProceso> getEspecialidadesProcesos() {
		return this.especialidadesProcesos;
	}

	public void setEspecialidadesProcesos(List<EspecialidadesProceso> especialidadesProcesos) {
		this.especialidadesProcesos = especialidadesProcesos;
	}

	public List<EspecialidadesProcesoEnlatado> getEspecialidadesProcesoEnlatados() {
		return this.especialidadesProcesoEnlatados;
	}

	public void setEspecialidadesProcesoEnlatados(List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados) {
		this.especialidadesProcesoEnlatados = especialidadesProcesoEnlatados;
	}

	public List<EstandarEficienciaKilosPagoPlexus> getEstandarEficienciaKilosPagoPlexuses1() {
		return this.estandarEficienciaKilosPagoPlexuses1;
	}

	public void setEstandarEficienciaKilosPagoPlexuses1(List<EstandarEficienciaKilosPagoPlexus> estandarEficienciaKilosPagoPlexuses1) {
		this.estandarEficienciaKilosPagoPlexuses1 = estandarEficienciaKilosPagoPlexuses1;
	}

	public List<EstandarEficienciaKilosPagoPlexus> getEstandarEficienciaKilosPagoPlexuses2() {
		return this.estandarEficienciaKilosPagoPlexuses2;
	}

	public void setEstandarEficienciaKilosPagoPlexuses2(List<EstandarEficienciaKilosPagoPlexus> estandarEficienciaKilosPagoPlexuses2) {
		this.estandarEficienciaKilosPagoPlexuses2 = estandarEficienciaKilosPagoPlexuses2;
	}

	public List<EstandarEficienciaKilosPlexus> getEstandarEficienciaKilosPlexuses1() {
		return this.estandarEficienciaKilosPlexuses1;
	}

	public void setEstandarEficienciaKilosPlexuses1(List<EstandarEficienciaKilosPlexus> estandarEficienciaKilosPlexuses1) {
		this.estandarEficienciaKilosPlexuses1 = estandarEficienciaKilosPlexuses1;
	}

	public List<EstandarEficienciaKilosPlexus> getEstandarEficienciaKilosPlexuses2() {
		return this.estandarEficienciaKilosPlexuses2;
	}

	public void setEstandarEficienciaKilosPlexuses2(List<EstandarEficienciaKilosPlexus> estandarEficienciaKilosPlexuses2) {
		this.estandarEficienciaKilosPlexuses2 = estandarEficienciaKilosPlexuses2;
	}

	public List<EvisceradoAuditoriaReimpresion> getEvisceradoAuditoriaReimpresions() {
		return this.evisceradoAuditoriaReimpresions;
	}

	public void setEvisceradoAuditoriaReimpresions(List<EvisceradoAuditoriaReimpresion> evisceradoAuditoriaReimpresions) {
		this.evisceradoAuditoriaReimpresions = evisceradoAuditoriaReimpresions;
	}

	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions1() {
		return this.evisceradoCocheModificacions1;
	}

	public void setEvisceradoCocheModificacions1(List<EvisceradoCocheModificacion> evisceradoCocheModificacions1) {
		this.evisceradoCocheModificacions1 = evisceradoCocheModificacions1;
	}

	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions2() {
		return this.evisceradoCocheModificacions2;
	}

	public void setEvisceradoCocheModificacions2(List<EvisceradoCocheModificacion> evisceradoCocheModificacions2) {
		this.evisceradoCocheModificacions2 = evisceradoCocheModificacions2;
	}

	public List<EvisceradoDetalleMuestreoTempCoche> getEvisceradoDetalleMuestreoTempCoches() {
		return this.evisceradoDetalleMuestreoTempCoches;
	}

	public void setEvisceradoDetalleMuestreoTempCoches(List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches) {
		this.evisceradoDetalleMuestreoTempCoches = evisceradoDetalleMuestreoTempCoches;
	}

	public List<EvisceradoDetalleProceso> getEvisceradoDetalleProcesos() {
		return this.evisceradoDetalleProcesos;
	}

	public void setEvisceradoDetalleProcesos(List<EvisceradoDetalleProceso> evisceradoDetalleProcesos) {
		this.evisceradoDetalleProcesos = evisceradoDetalleProcesos;
	}

	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public List<EvisceradoDetalleProcesoModificacion> getEvisceradoDetalleProcesoModificacions() {
		return this.evisceradoDetalleProcesoModificacions;
	}

	public void setEvisceradoDetalleProcesoModificacions(List<EvisceradoDetalleProcesoModificacion> evisceradoDetalleProcesoModificacions) {
		this.evisceradoDetalleProcesoModificacions = evisceradoDetalleProcesoModificacions;
	}

	public List<EvisceradoMuestreoTempCoche> getEvisceradoMuestreoTempCoches() {
		return this.evisceradoMuestreoTempCoches;
	}

	public void setEvisceradoMuestreoTempCoches(List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches) {
		this.evisceradoMuestreoTempCoches = evisceradoMuestreoTempCoches;
	}

	public List<EvisceradoRackeoLote> getEvisceradoRackeoLotes() {
		return this.evisceradoRackeoLotes;
	}

	public void setEvisceradoRackeoLotes(List<EvisceradoRackeoLote> evisceradoRackeoLotes) {
		this.evisceradoRackeoLotes = evisceradoRackeoLotes;
	}

	public List<EvisceradoReanudacionSecCoche> getEvisceradoReanudacionSecCoches() {
		return this.evisceradoReanudacionSecCoches;
	}

	public void setEvisceradoReanudacionSecCoches(List<EvisceradoReanudacionSecCoche> evisceradoReanudacionSecCoches) {
		this.evisceradoReanudacionSecCoches = evisceradoReanudacionSecCoches;
	}

	public List<EvisceradoSubproductoCrudo> getEvisceradoSubproductoCrudos() {
		return this.evisceradoSubproductoCrudos;
	}

	public void setEvisceradoSubproductoCrudos(List<EvisceradoSubproductoCrudo> evisceradoSubproductoCrudos) {
		this.evisceradoSubproductoCrudos = evisceradoSubproductoCrudos;
	}

	public List<EvolutionAuditoriaDetalle> getEvolutionAuditoriaDetalles() {
		return this.evolutionAuditoriaDetalles;
	}

	public void setEvolutionAuditoriaDetalles(List<EvolutionAuditoriaDetalle> evolutionAuditoriaDetalles) {
		this.evolutionAuditoriaDetalles = evolutionAuditoriaDetalles;
	}

	public List<GestionTurno> getGestionTurnos() {
		return this.gestionTurnos;
	}

	public void setGestionTurnos(List<GestionTurno> gestionTurnos) {
		this.gestionTurnos = gestionTurnos;
	}

	public List<HarinaRecepcionDetallePescaComprobante> getHarinaRecepcionDetallePescaComprobantes() {
		return this.harinaRecepcionDetallePescaComprobantes;
	}

	public void setHarinaRecepcionDetallePescaComprobantes(List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes) {
		this.harinaRecepcionDetallePescaComprobantes = harinaRecepcionDetallePescaComprobantes;
	}

	public List<HarinaRecepcionPescaComprobante> getHarinaRecepcionPescaComprobantes() {
		return this.harinaRecepcionPescaComprobantes;
	}

	public void setHarinaRecepcionPescaComprobantes(List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes) {
		this.harinaRecepcionPescaComprobantes = harinaRecepcionPescaComprobantes;
	}

	public List<ImpresionDetalle> getImpresionDetalles() {
		return this.impresionDetalles;
	}

	public void setImpresionDetalles(List<ImpresionDetalle> impresionDetalles) {
		this.impresionDetalles = impresionDetalles;
	}

	public List<LimpiezaAsignacionCanastilla> getLimpiezaAsignacionCanastillas() {
		return this.limpiezaAsignacionCanastillas;
	}

	public void setLimpiezaAsignacionCanastillas(List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas) {
		this.limpiezaAsignacionCanastillas = limpiezaAsignacionCanastillas;
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

	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions1() {
		return this.limpiezaCocheModificacions1;
	}

	public void setLimpiezaCocheModificacions1(List<LimpiezaCocheModificacion> limpiezaCocheModificacions1) {
		this.limpiezaCocheModificacions1 = limpiezaCocheModificacions1;
	}

	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions2() {
		return this.limpiezaCocheModificacions2;
	}

	public void setLimpiezaCocheModificacions2(List<LimpiezaCocheModificacion> limpiezaCocheModificacions2) {
		this.limpiezaCocheModificacions2 = limpiezaCocheModificacions2;
	}

	public List<LimpiezaCocheObservacione> getLimpiezaCocheObservaciones1() {
		return this.limpiezaCocheObservaciones1;
	}

	public void setLimpiezaCocheObservaciones1(List<LimpiezaCocheObservacione> limpiezaCocheObservaciones1) {
		this.limpiezaCocheObservaciones1 = limpiezaCocheObservaciones1;
	}

	public List<LimpiezaCocheObservacione> getLimpiezaCocheObservaciones2() {
		return this.limpiezaCocheObservaciones2;
	}

	public void setLimpiezaCocheObservaciones2(List<LimpiezaCocheObservacione> limpiezaCocheObservaciones2) {
		this.limpiezaCocheObservaciones2 = limpiezaCocheObservaciones2;
	}

	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public List<LimpiezaDetalleCortesPlantaLineaEmpleado> getLimpiezaDetalleCortesPlantaLineaEmpleados() {
		return this.limpiezaDetalleCortesPlantaLineaEmpleados;
	}

	public void setLimpiezaDetalleCortesPlantaLineaEmpleados(List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados) {
		this.limpiezaDetalleCortesPlantaLineaEmpleados = limpiezaDetalleCortesPlantaLineaEmpleados;
	}

	public List<LimpiezaDetalleDesperdicio> getLimpiezaDetalleDesperdicios() {
		return this.limpiezaDetalleDesperdicios;
	}

	public void setLimpiezaDetalleDesperdicios(List<LimpiezaDetalleDesperdicio> limpiezaDetalleDesperdicios) {
		this.limpiezaDetalleDesperdicios = limpiezaDetalleDesperdicios;
	}

	public List<LimpiezaDetallePesoDespellejado> getLimpiezaDetallePesoDespellejados() {
		return this.limpiezaDetallePesoDespellejados;
	}

	public void setLimpiezaDetallePesoDespellejados(List<LimpiezaDetallePesoDespellejado> limpiezaDetallePesoDespellejados) {
		this.limpiezaDetallePesoDespellejados = limpiezaDetallePesoDespellejados;
	}

	public List<LimpiezaDetallePesoDespellejadoT> getLimpiezaDetallePesoDespellejadoTs() {
		return this.limpiezaDetallePesoDespellejadoTs;
	}

	public void setLimpiezaDetallePesoDespellejadoTs(List<LimpiezaDetallePesoDespellejadoT> limpiezaDetallePesoDespellejadoTs) {
		this.limpiezaDetallePesoDespellejadoTs = limpiezaDetallePesoDespellejadoTs;
	}

	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions() {
		return this.limpiezaDetalleProcesoBandejaAprobacions;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions) {
		this.limpiezaDetalleProcesoBandejaAprobacions = limpiezaDetalleProcesoBandejaAprobacions;
	}

	public List<LimpiezaDetalleProcesoCoche> getLimpiezaDetalleProcesoCoches() {
		return this.limpiezaDetalleProcesoCoches;
	}

	public void setLimpiezaDetalleProcesoCoches(List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches) {
		this.limpiezaDetalleProcesoCoches = limpiezaDetalleProcesoCoches;
	}

	public List<LimpiezaDetalleProcesoCocheTemperaturaBatch> getLimpiezaDetalleProcesoCocheTemperaturaBatches() {
		return this.limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

	public void setLimpiezaDetalleProcesoCocheTemperaturaBatches(List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches) {
		this.limpiezaDetalleProcesoCocheTemperaturaBatches = limpiezaDetalleProcesoCocheTemperaturaBatches;
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

	public List<LimpiezaLomoLimpioCoche> getLimpiezaLomoLimpioCoches() {
		return this.limpiezaLomoLimpioCoches;
	}

	public void setLimpiezaLomoLimpioCoches(List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches) {
		this.limpiezaLomoLimpioCoches = limpiezaLomoLimpioCoches;
	}

	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
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

	public List<LimpiezaProcesoEmpleadoFalta> getLimpiezaProcesoEmpleadoFaltas() {
		return this.limpiezaProcesoEmpleadoFaltas;
	}

	public void setLimpiezaProcesoEmpleadoFaltas(List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas) {
		this.limpiezaProcesoEmpleadoFaltas = limpiezaProcesoEmpleadoFaltas;
	}

	public List<LimpiezaProcesoEmpleadoMarcacione> getLimpiezaProcesoEmpleadoMarcaciones() {
		return this.limpiezaProcesoEmpleadoMarcaciones;
	}

	public void setLimpiezaProcesoEmpleadoMarcaciones(List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones) {
		this.limpiezaProcesoEmpleadoMarcaciones = limpiezaProcesoEmpleadoMarcaciones;
	}

	public List<LimpiezaProcesoEmpleadoTotalInicial> getLimpiezaProcesoEmpleadoTotalInicials() {
		return this.limpiezaProcesoEmpleadoTotalInicials;
	}

	public void setLimpiezaProcesoEmpleadoTotalInicials(List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials) {
		this.limpiezaProcesoEmpleadoTotalInicials = limpiezaProcesoEmpleadoTotalInicials;
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

	public List<LimpiezaRalladoBatchDetalle> getLimpiezaRalladoBatchDetalles() {
		return this.limpiezaRalladoBatchDetalles;
	}

	public void setLimpiezaRalladoBatchDetalles(List<LimpiezaRalladoBatchDetalle> limpiezaRalladoBatchDetalles) {
		this.limpiezaRalladoBatchDetalles = limpiezaRalladoBatchDetalles;
	}

	public List<LimpiezaRalladoGabetaMezclaBatch> getLimpiezaRalladoGabetaMezclaBatches() {
		return this.limpiezaRalladoGabetaMezclaBatches;
	}

	public void setLimpiezaRalladoGabetaMezclaBatches(List<LimpiezaRalladoGabetaMezclaBatch> limpiezaRalladoGabetaMezclaBatches) {
		this.limpiezaRalladoGabetaMezclaBatches = limpiezaRalladoGabetaMezclaBatches;
	}

	public List<LimpiezaRalladoMezclaBatchCabecera> getLimpiezaRalladoMezclaBatchCabeceras() {
		return this.limpiezaRalladoMezclaBatchCabeceras;
	}

	public void setLimpiezaRalladoMezclaBatchCabeceras(List<LimpiezaRalladoMezclaBatchCabecera> limpiezaRalladoMezclaBatchCabeceras) {
		this.limpiezaRalladoMezclaBatchCabeceras = limpiezaRalladoMezclaBatchCabeceras;
	}

	public List<LimpiezaRalladoMezclaBatchDetalle> getLimpiezaRalladoMezclaBatchDetalles() {
		return this.limpiezaRalladoMezclaBatchDetalles;
	}

	public void setLimpiezaRalladoMezclaBatchDetalles(List<LimpiezaRalladoMezclaBatchDetalle> limpiezaRalladoMezclaBatchDetalles) {
		this.limpiezaRalladoMezclaBatchDetalles = limpiezaRalladoMezclaBatchDetalles;
	}

	public List<LonjasDetalleProcesoCoche> getLonjasDetalleProcesoCoches() {
		return this.lonjasDetalleProcesoCoches;
	}

	public void setLonjasDetalleProcesoCoches(List<LonjasDetalleProcesoCoche> lonjasDetalleProcesoCoches) {
		this.lonjasDetalleProcesoCoches = lonjasDetalleProcesoCoches;
	}

	public List<LonjasDetalleProcesoCocheEmpacado> getLonjasDetalleProcesoCocheEmpacados() {
		return this.lonjasDetalleProcesoCocheEmpacados;
	}

	public void setLonjasDetalleProcesoCocheEmpacados(List<LonjasDetalleProcesoCocheEmpacado> lonjasDetalleProcesoCocheEmpacados) {
		this.lonjasDetalleProcesoCocheEmpacados = lonjasDetalleProcesoCocheEmpacados;
	}

	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public List<LonjasOrdenProduccion> getLonjasOrdenProduccions() {
		return this.lonjasOrdenProduccions;
	}

	public void setLonjasOrdenProduccions(List<LonjasOrdenProduccion> lonjasOrdenProduccions) {
		this.lonjasOrdenProduccions = lonjasOrdenProduccions;
	}

	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
	}

	public List<LonjasProcesoEmpleado> getLonjasProcesoEmpleados() {
		return this.lonjasProcesoEmpleados;
	}

	public void setLonjasProcesoEmpleados(List<LonjasProcesoEmpleado> lonjasProcesoEmpleados) {
		this.lonjasProcesoEmpleados = lonjasProcesoEmpleados;
	}

	public List<ObservacionesDetalleProceso> getObservacionesDetalleProcesos() {
		return this.observacionesDetalleProcesos;
	}

	public void setObservacionesDetalleProcesos(List<ObservacionesDetalleProceso> observacionesDetalleProcesos) {
		this.observacionesDetalleProcesos = observacionesDetalleProcesos;
	}

	public List<ObservacionesProceso> getObservacionesProcesos() {
		return this.observacionesProcesos;
	}

	public void setObservacionesProcesos(List<ObservacionesProceso> observacionesProcesos) {
		this.observacionesProcesos = observacionesProcesos;
	}

	public List<ObservacionesPuntoControl> getObservacionesPuntoControls1() {
		return this.observacionesPuntoControls1;
	}

	public void setObservacionesPuntoControls1(List<ObservacionesPuntoControl> observacionesPuntoControls1) {
		this.observacionesPuntoControls1 = observacionesPuntoControls1;
	}

	public List<ObservacionesPuntoControl> getObservacionesPuntoControls2() {
		return this.observacionesPuntoControls2;
	}

	public void setObservacionesPuntoControls2(List<ObservacionesPuntoControl> observacionesPuntoControls2) {
		this.observacionesPuntoControls2 = observacionesPuntoControls2;
	}

	public List<ObservacionesPuntoControl> getObservacionesPuntoControls3() {
		return this.observacionesPuntoControls3;
	}

	public void setObservacionesPuntoControls3(List<ObservacionesPuntoControl> observacionesPuntoControls3) {
		this.observacionesPuntoControls3 = observacionesPuntoControls3;
	}

	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public List<OeeDetalleParada> getOeeDetalleParadas() {
		return this.oeeDetalleParadas;
	}

	public void setOeeDetalleParadas(List<OeeDetalleParada> oeeDetalleParadas) {
		this.oeeDetalleParadas = oeeDetalleParadas;
	}

	public List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoCabeceraVelocidadMaquinaCerradoras(List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras = oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> getOeeEnvasadoDetalleVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoDetalleVelocidadMaquinaCerradoras(List<OeeEnvasadoDetalleVelocidadMaquinaCerradora> oeeEnvasadoDetalleVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoDetalleVelocidadMaquinaCerradoras = oeeEnvasadoDetalleVelocidadMaquinaCerradoras;
	}

	public List<OeePeriodoBaseObjetivo> getOeePeriodoBaseObjetivos() {
		return this.oeePeriodoBaseObjetivos;
	}

	public void setOeePeriodoBaseObjetivos(List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos) {
		this.oeePeriodoBaseObjetivos = oeePeriodoBaseObjetivos;
	}

	public List<PanzasDetalleProcesoConteo> getPanzasDetalleProcesoConteos() {
		return this.panzasDetalleProcesoConteos;
	}

	public void setPanzasDetalleProcesoConteos(List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos) {
		this.panzasDetalleProcesoConteos = panzasDetalleProcesoConteos;
	}

	public List<PanzasDetalleProcesoLote> getPanzasDetalleProcesoLotes() {
		return this.panzasDetalleProcesoLotes;
	}

	public void setPanzasDetalleProcesoLotes(List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes) {
		this.panzasDetalleProcesoLotes = panzasDetalleProcesoLotes;
	}

	public List<PanzasProceso> getPanzasProcesos() {
		return this.panzasProcesos;
	}

	public void setPanzasProcesos(List<PanzasProceso> panzasProcesos) {
		this.panzasProcesos = panzasProcesos;
	}

	public List<ParametroAuditoria> getParametroAuditorias() {
		return this.parametroAuditorias;
	}

	public void setParametroAuditorias(List<ParametroAuditoria> parametroAuditorias) {
		this.parametroAuditorias = parametroAuditorias;
	}

	public List<PedidoProduccionArchivoCargaCabecera> getPedidoProduccionArchivoCargaCabeceras() {
		return this.pedidoProduccionArchivoCargaCabeceras;
	}

	public void setPedidoProduccionArchivoCargaCabeceras(List<PedidoProduccionArchivoCargaCabecera> pedidoProduccionArchivoCargaCabeceras) {
		this.pedidoProduccionArchivoCargaCabeceras = pedidoProduccionArchivoCargaCabeceras;
	}

	public List<PedidoProduccionCabecera> getPedidoProduccionCabeceras() {
		return this.pedidoProduccionCabeceras;
	}

	public void setPedidoProduccionCabeceras(List<PedidoProduccionCabecera> pedidoProduccionCabeceras) {
		this.pedidoProduccionCabeceras = pedidoProduccionCabeceras;
	}

	public List<PlanificacionCargaArchivo> getPlanificacionCargaArchivos() {
		return this.planificacionCargaArchivos;
	}

	public void setPlanificacionCargaArchivos(List<PlanificacionCargaArchivo> planificacionCargaArchivos) {
		this.planificacionCargaArchivos = planificacionCargaArchivos;
	}

	public List<PouchDetalleProcesoConteo> getPouchDetalleProcesoConteos() {
		return this.pouchDetalleProcesoConteos;
	}

	public void setPouchDetalleProcesoConteos(List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos) {
		this.pouchDetalleProcesoConteos = pouchDetalleProcesoConteos;
	}

	public List<PouchDetalleProcesoLote> getPouchDetalleProcesoLotes() {
		return this.pouchDetalleProcesoLotes;
	}

	public void setPouchDetalleProcesoLotes(List<PouchDetalleProcesoLote> pouchDetalleProcesoLotes) {
		this.pouchDetalleProcesoLotes = pouchDetalleProcesoLotes;
	}

	public List<PouchProceso> getPouchProcesos() {
		return this.pouchProcesos;
	}

	public void setPouchProcesos(List<PouchProceso> pouchProcesos) {
		this.pouchProcesos = pouchProcesos;
	}

	public List<ProduccionArchivoCargaLote> getProduccionArchivoCargaLotes() {
		return this.produccionArchivoCargaLotes;
	}

	public void setProduccionArchivoCargaLotes(List<ProduccionArchivoCargaLote> produccionArchivoCargaLotes) {
		this.produccionArchivoCargaLotes = produccionArchivoCargaLotes;
	}

	public List<ProduccionCargaArchivoPedido> getProduccionCargaArchivoPedidos() {
		return this.produccionCargaArchivoPedidos;
	}

	public void setProduccionCargaArchivoPedidos(List<ProduccionCargaArchivoPedido> produccionCargaArchivoPedidos) {
		this.produccionCargaArchivoPedidos = produccionCargaArchivoPedidos;
	}

	public List<RackeoProceso> getRackeoProcesos() {
		return this.rackeoProcesos;
	}

	public void setRackeoProcesos(List<RackeoProceso> rackeoProcesos) {
		this.rackeoProcesos = rackeoProcesos;
	}

	public List<RackeoProcesoEmpleado> getRackeoProcesoEmpleados() {
		return this.rackeoProcesoEmpleados;
	}

	public void setRackeoProcesoEmpleados(List<RackeoProcesoEmpleado> rackeoProcesoEmpleados) {
		this.rackeoProcesoEmpleados = rackeoProcesoEmpleados;
	}

	public List<ReportesNivelesUsuario> getReportesNivelesUsuarios() {
		return this.reportesNivelesUsuarios;
	}

	public void setReportesNivelesUsuarios(List<ReportesNivelesUsuario> reportesNivelesUsuarios) {
		this.reportesNivelesUsuarios = reportesNivelesUsuarios;
	}

	public List<ReportesPuntoControl> getReportesPuntoControls1() {
		return this.reportesPuntoControls1;
	}

	public void setReportesPuntoControls1(List<ReportesPuntoControl> reportesPuntoControls1) {
		this.reportesPuntoControls1 = reportesPuntoControls1;
	}

	public List<ReportesPuntoControl> getReportesPuntoControls2() {
		return this.reportesPuntoControls2;
	}

	public void setReportesPuntoControls2(List<ReportesPuntoControl> reportesPuntoControls2) {
		this.reportesPuntoControls2 = reportesPuntoControls2;
	}

	public List<RociadoDetalleMuestreoTempCoche> getRociadoDetalleMuestreoTempCoches() {
		return this.rociadoDetalleMuestreoTempCoches;
	}

	public void setRociadoDetalleMuestreoTempCoches(List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches) {
		this.rociadoDetalleMuestreoTempCoches = rociadoDetalleMuestreoTempCoches;
	}

	public List<RociadoDetalleProcesoCoche> getRociadoDetalleProcesoCoches() {
		return this.rociadoDetalleProcesoCoches;
	}

	public void setRociadoDetalleProcesoCoches(List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches) {
		this.rociadoDetalleProcesoCoches = rociadoDetalleProcesoCoches;
	}

	public List<RociadoDetalleProcesoCocheTemperatura> getRociadoDetalleProcesoCocheTemperaturas() {
		return this.rociadoDetalleProcesoCocheTemperaturas;
	}

	public void setRociadoDetalleProcesoCocheTemperaturas(List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas) {
		this.rociadoDetalleProcesoCocheTemperaturas = rociadoDetalleProcesoCocheTemperaturas;
	}

	public List<RociadoMuestreoTempCoche> getRociadoMuestreoTempCoches() {
		return this.rociadoMuestreoTempCoches;
	}

	public void setRociadoMuestreoTempCoches(List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches) {
		this.rociadoMuestreoTempCoches = rociadoMuestreoTempCoches;
	}

	public List<RociadoProceso> getRociadoProcesos() {
		return this.rociadoProcesos;
	}

	public void setRociadoProcesos(List<RociadoProceso> rociadoProcesos) {
		this.rociadoProcesos = rociadoProcesos;
	}

	public List<SeguridadAuditoriaConsultaDocumento> getSeguridadAuditoriaConsultaDocumentos() {
		return this.seguridadAuditoriaConsultaDocumentos;
	}

	public void setSeguridadAuditoriaConsultaDocumentos(List<SeguridadAuditoriaConsultaDocumento> seguridadAuditoriaConsultaDocumentos) {
		this.seguridadAuditoriaConsultaDocumentos = seguridadAuditoriaConsultaDocumentos;
	}

	public List<TunelDetalleProcesoCoche> getTunelDetalleProcesoCoches() {
		return this.tunelDetalleProcesoCoches;
	}

	public void setTunelDetalleProcesoCoches(List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches) {
		this.tunelDetalleProcesoCoches = tunelDetalleProcesoCoches;
	}

	public List<TunelDetalleProcesoCocheSalida> getTunelDetalleProcesoCocheSalidas() {
		return this.tunelDetalleProcesoCocheSalidas;
	}

	public void setTunelDetalleProcesoCocheSalidas(List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas) {
		this.tunelDetalleProcesoCocheSalidas = tunelDetalleProcesoCocheSalidas;
	}

	public List<TurnoGestionDetalle> getTurnoGestionDetalles() {
		return this.turnoGestionDetalles;
	}

	public void setTurnoGestionDetalles(List<TurnoGestionDetalle> turnoGestionDetalles) {
		this.turnoGestionDetalles = turnoGestionDetalles;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<UsuariosAprobacion> getUsuariosAprobacions() {
		return this.usuariosAprobacions;
	}

	public void setUsuariosAprobacions(List<UsuariosAprobacion> usuariosAprobacions) {
		this.usuariosAprobacions = usuariosAprobacions;
	}

}