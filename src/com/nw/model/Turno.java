package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the turno database table.
 * 
 */
@Entity
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idturno;

	private String nombre;

	//bi-directional many-to-one association to CalidadDescongeladoDetalleTempAgua
	@OneToMany(mappedBy="turno")
	private List<CalidadDescongeladoDetalleTempAgua> calidadDescongeladoDetalleTempAguas;

	//bi-directional many-to-one association to CalidadDescongeladoDetalleTempPescado
	@OneToMany(mappedBy="turno")
	private List<CalidadDescongeladoDetalleTempPescado> calidadDescongeladoDetalleTempPescados;

	//bi-directional many-to-one association to CalidadDescongeladoTempAgua
	@OneToMany(mappedBy="turno")
	private List<CalidadDescongeladoTempAgua> calidadDescongeladoTempAguas;

	//bi-directional many-to-one association to CalidadDescongeladoTempPescado
	@OneToMany(mappedBy="turno")
	private List<CalidadDescongeladoTempPescado> calidadDescongeladoTempPescados;

	//bi-directional many-to-one association to CalidadDetalleEspecietallaCajonBanda
	@OneToMany(mappedBy="turno")
	private List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas;

	//bi-directional many-to-one association to CalidadDetalleMuestreoCocina
	@OneToMany(mappedBy="turno")
	private List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCoccion
	@OneToMany(mappedBy="turno")
	private List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="turno")
	private List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempLimpieza
	@OneToMany(mappedBy="turno")
	private List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas;

	//bi-directional many-to-one association to CalidadDetalleMuestreoTempPanzaEviscerado
	@OneToMany(mappedBy="turno")
	private List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados;

	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="turno")
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;

	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="turno")
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;

	//bi-directional many-to-one association to CalidadMuestraAreaDetalle
	@OneToMany(mappedBy="turno")
	private List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles;

	//bi-directional many-to-one association to CalidadMuestraAreaDetalleMuestra
	@OneToMany(mappedBy="turno")
	private List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras;

	//bi-directional many-to-one association to CalidadMuestreoCocina
	@OneToMany(mappedBy="turno")
	private List<CalidadMuestreoCocina> calidadMuestreoCocinas;

	//bi-directional many-to-one association to CalidadMuestreoTempCoccion
	@OneToMany(mappedBy="turno")
	private List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions;

	//bi-directional many-to-one association to CalidadMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="turno")
	private List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados;

	//bi-directional many-to-one association to CalidadMuestreoTempLimpieza
	@OneToMany(mappedBy="turno")
	private List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas;

	//bi-directional many-to-one association to CalidadMuestreoTempPanzasEviscerado
	@OneToMany(mappedBy="turno")
	private List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados;

	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="turno")
	private List<CamaraCajon> camaraCajons;

	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	private List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheAdic
	@OneToMany(mappedBy="turno")
	private List<CoccionDetalleMuestreoTempCocheAdic> coccionDetalleMuestreoTempCocheAdics;

	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheIngreso
	@OneToMany(mappedBy="turno")
	private List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos;

	//bi-directional many-to-one association to CoccionDetalleProcesoCoche
	@OneToMany(mappedBy="turno")
	private List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches;

	//bi-directional many-to-one association to CoccionDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="turno")
	private List<CoccionDetalleProcesoCocheTemperatura> coccionDetalleProcesoCocheTemperaturas;

	//bi-directional many-to-one association to CoccionMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	private List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches;

	//bi-directional many-to-one association to CoccionMuestreoTempCocheIngreso
	@OneToMany(mappedBy="turno")
	private List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos;

	//bi-directional many-to-one association to ContraloriaCoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	private List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to ContraloriaDetalleRackeoProcesoTemperatura
	@OneToMany(mappedBy="turno")
	private List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas;

	//bi-directional many-to-one association to ContraloriaEvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	private List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to ControlBatchProceso
	@OneToMany(mappedBy="turno")
	private List<ControlBatchProceso> controlBatchProcesos;

	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="turno")
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="turno")
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;

	//bi-directional many-to-one association to DescongeladoDetalleProcesoContraloria
	@OneToMany(mappedBy="turno")
	private List<DescongeladoDetalleProcesoContraloria> descongeladoDetalleProcesoContralorias;

	//bi-directional many-to-one association to DescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="turno")
	private List<DescongeladoDetalleProcesoTempIng> descongeladoDetalleProcesoTempIngs;

	//bi-directional many-to-one association to DescongeladoDetalleProcesoTemperatura
	@OneToMany(mappedBy="turno")
	private List<DescongeladoDetalleProcesoTemperatura> descongeladoDetalleProcesoTemperaturas;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="turno1")
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas1;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="turno2")
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas2;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="turno3")
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas3;

	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="turno")
	private List<DesperdicioDetalle> desperdicioDetalles;

	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="turno")
	private List<EnvasadoProceso> envasadoProcesos;

	//bi-directional many-to-one association to EspecialidadesProcesoEnlatado
	@OneToMany(mappedBy="turno")
	private List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados;

	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="turno")
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;

	//bi-directional many-to-one association to EvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	private List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="turno")
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;

	//bi-directional many-to-one association to EvisceradoMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	private List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches;

	//bi-directional many-to-one association to GestionTurno
	@OneToMany(mappedBy="turno")
	private List<GestionTurno> gestionTurnos;

	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="turno")
	private List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes;

	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@OneToMany(mappedBy="turno")
	private List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes;

	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="turno")
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="turno")
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions;

	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="turno")
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="turno")
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="turno")
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@OneToMany(mappedBy="turno")
	private List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="turno")
	private List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes;

	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="turno")
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;

	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="turno")
	private List<LimpiezaProceso> limpiezaProcesos;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoFalta
	@OneToMany(mappedBy="turno")
	private List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoMarcacione
	@OneToMany(mappedBy="turno")
	private List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones;

	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="turno")
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;

	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="turno")
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;

	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="turno")
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;

	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="turno")
	private List<LonjasProceso> lonjasProcesos;

	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="turno")
	private List<ObservacionesPuntoControl> observacionesPuntoControls;

	//bi-directional many-to-one association to PanzasDetalleProcesoConteo
	@OneToMany(mappedBy="turno")
	private List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos;

	//bi-directional many-to-one association to PanzasDetalleProcesoLote
	@OneToMany(mappedBy="turno")
	private List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes;

	//bi-directional many-to-one association to PanzasProceso
	@OneToMany(mappedBy="turno")
	private List<PanzasProceso> panzasProcesos;

	//bi-directional many-to-one association to PedidoProduccionArchivoCargaDetalle
	@OneToMany(mappedBy="turno")
	private List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles;

	//bi-directional many-to-one association to PedidoProduccionDetalle
	@OneToMany(mappedBy="turno")
	private List<PedidoProduccionDetalle> pedidoProduccionDetalles;

	//bi-directional many-to-one association to PlanificacionCargaDetalle
	@OneToMany(mappedBy="turno")
	private List<PlanificacionCargaDetalle> planificacionCargaDetalles;

	//bi-directional many-to-one association to PouchDetalleProcesoConteo
	@OneToMany(mappedBy="turno")
	private List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos;

	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="turno")
	private List<ProduccionDetalleLote> produccionDetalleLotes;

	//bi-directional many-to-one association to ProduccionDetalleLoteCarryover
	@OneToMany(mappedBy="turno")
	private List<ProduccionDetalleLoteCarryover> produccionDetalleLoteCarryovers;

	//bi-directional many-to-one association to ProduccionOrdenPedido
	@OneToMany(mappedBy="turno")
	private List<ProduccionOrdenPedido> produccionOrdenPedidos;

	//bi-directional many-to-one association to RackeoProceso
	@OneToMany(mappedBy="turno")
	private List<RackeoProceso> rackeoProcesos;

	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="turno")
	private List<ReportesPuntoControl> reportesPuntoControls;

	//bi-directional many-to-one association to RociadoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	private List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches;

	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@OneToMany(mappedBy="turno")
	private List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches;

	//bi-directional many-to-one association to RociadoDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="turno")
	private List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas;

	//bi-directional many-to-one association to RociadoMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	private List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches;

	//bi-directional many-to-one association to TurnoGestionDetalle
	@OneToMany(mappedBy="turno")
	private List<TurnoGestionDetalle> turnoGestionDetalles;

	public Turno() {
	}

	public Integer getIdturno() {
		return this.idturno;
	}

	public void setIdturno(Integer idturno) {
		this.idturno = idturno;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public List<CoccionDetalleProcesoCoche> getCoccionDetalleProcesoCoches() {
		return this.coccionDetalleProcesoCoches;
	}

	public void setCoccionDetalleProcesoCoches(List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches) {
		this.coccionDetalleProcesoCoches = coccionDetalleProcesoCoches;
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

	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
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

	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas3() {
		return this.desperdicioCajonHarinas3;
	}

	public void setDesperdicioCajonHarinas3(List<DesperdicioCajonHarina> desperdicioCajonHarinas3) {
		this.desperdicioCajonHarinas3 = desperdicioCajonHarinas3;
	}

	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public List<EnvasadoProceso> getEnvasadoProcesos() {
		return this.envasadoProcesos;
	}

	public void setEnvasadoProcesos(List<EnvasadoProceso> envasadoProcesos) {
		this.envasadoProcesos = envasadoProcesos;
	}

	public List<EspecialidadesProcesoEnlatado> getEspecialidadesProcesoEnlatados() {
		return this.especialidadesProcesoEnlatados;
	}

	public void setEspecialidadesProcesoEnlatados(List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados) {
		this.especialidadesProcesoEnlatados = especialidadesProcesoEnlatados;
	}

	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public List<EvisceradoDetalleMuestreoTempCoche> getEvisceradoDetalleMuestreoTempCoches() {
		return this.evisceradoDetalleMuestreoTempCoches;
	}

	public void setEvisceradoDetalleMuestreoTempCoches(List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches) {
		this.evisceradoDetalleMuestreoTempCoches = evisceradoDetalleMuestreoTempCoches;
	}

	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public List<EvisceradoMuestreoTempCoche> getEvisceradoMuestreoTempCoches() {
		return this.evisceradoMuestreoTempCoches;
	}

	public void setEvisceradoMuestreoTempCoches(List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches) {
		this.evisceradoMuestreoTempCoches = evisceradoMuestreoTempCoches;
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

	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions() {
		return this.limpiezaCocheModificacions;
	}

	public void setLimpiezaCocheModificacions(List<LimpiezaCocheModificacion> limpiezaCocheModificacions) {
		this.limpiezaCocheModificacions = limpiezaCocheModificacions;
	}

	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
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

	public List<LimpiezaDetalleProcesoLote> getLimpiezaDetalleProcesoLotes() {
		return this.limpiezaDetalleProcesoLotes;
	}

	public void setLimpiezaDetalleProcesoLotes(List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes) {
		this.limpiezaDetalleProcesoLotes = limpiezaDetalleProcesoLotes;
	}

	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
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

	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
	}

	public List<ObservacionesPuntoControl> getObservacionesPuntoControls() {
		return this.observacionesPuntoControls;
	}

	public void setObservacionesPuntoControls(List<ObservacionesPuntoControl> observacionesPuntoControls) {
		this.observacionesPuntoControls = observacionesPuntoControls;
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

	public List<PouchDetalleProcesoConteo> getPouchDetalleProcesoConteos() {
		return this.pouchDetalleProcesoConteos;
	}

	public void setPouchDetalleProcesoConteos(List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos) {
		this.pouchDetalleProcesoConteos = pouchDetalleProcesoConteos;
	}

	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

	public List<ProduccionDetalleLoteCarryover> getProduccionDetalleLoteCarryovers() {
		return this.produccionDetalleLoteCarryovers;
	}

	public void setProduccionDetalleLoteCarryovers(List<ProduccionDetalleLoteCarryover> produccionDetalleLoteCarryovers) {
		this.produccionDetalleLoteCarryovers = produccionDetalleLoteCarryovers;
	}

	public List<ProduccionOrdenPedido> getProduccionOrdenPedidos() {
		return this.produccionOrdenPedidos;
	}

	public void setProduccionOrdenPedidos(List<ProduccionOrdenPedido> produccionOrdenPedidos) {
		this.produccionOrdenPedidos = produccionOrdenPedidos;
	}

	public List<RackeoProceso> getRackeoProcesos() {
		return this.rackeoProcesos;
	}

	public void setRackeoProcesos(List<RackeoProceso> rackeoProcesos) {
		this.rackeoProcesos = rackeoProcesos;
	}

	public List<ReportesPuntoControl> getReportesPuntoControls() {
		return this.reportesPuntoControls;
	}

	public void setReportesPuntoControls(List<ReportesPuntoControl> reportesPuntoControls) {
		this.reportesPuntoControls = reportesPuntoControls;
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

	public List<TurnoGestionDetalle> getTurnoGestionDetalles() {
		return this.turnoGestionDetalles;
	}

	public void setTurnoGestionDetalles(List<TurnoGestionDetalle> turnoGestionDetalles) {
		this.turnoGestionDetalles = turnoGestionDetalles;
	}

}