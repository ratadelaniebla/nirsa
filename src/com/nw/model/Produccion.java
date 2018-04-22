package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the produccion database table.
 * 
 */
@Entity
public class Produccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproduccion;

	private Integer estado;

	private Timestamp fechaproduccion;

	//bi-directional many-to-one association to CoccionProceso
	@OneToMany(mappedBy="produccion")
	private List<CoccionProceso> coccionProcesos;

	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@OneToMany(mappedBy="produccion")
	private List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles;

	//bi-directional many-to-one association to ControlBatchProceso
	@OneToMany(mappedBy="produccion")
	private List<ControlBatchProceso> controlBatchProcesos;

	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@OneToMany(mappedBy="produccion")
	private List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles;

	//bi-directional many-to-one association to DescongeladoProceso
	@OneToMany(mappedBy="produccion")
	private List<DescongeladoProceso> descongeladoProcesos;

	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="produccion")
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas;

	//bi-directional many-to-one association to DuchaAperturaCierreDetalle
	@OneToMany(mappedBy="produccion")
	private List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles;

	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="produccion")
	private List<EnvasadoProceso> envasadoProcesos;

	//bi-directional many-to-one association to EspecialidadesProceso
	@OneToMany(mappedBy="produccion")
	private List<EspecialidadesProceso> especialidadesProcesos;

	//bi-directional many-to-one association to EvisceradoProceso
	@OneToMany(mappedBy="produccion")
	private List<EvisceradoProceso> evisceradoProcesos;

	//bi-directional many-to-one association to EvolutionAuditoriaDetalle
	@OneToMany(mappedBy="produccion")
	private List<EvolutionAuditoriaDetalle> evolutionAuditoriaDetalles;

	//bi-directional many-to-one association to LimpiezaAsignacionCanastilla
	@OneToMany(mappedBy="produccion")
	private List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas;

	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="produccion")
	private List<LimpiezaProceso> limpiezaProcesos;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoFalta
	@OneToMany(mappedBy="produccion")
	private List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoMarcacione
	@OneToMany(mappedBy="produccion")
	private List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones;

	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="produccion")
	private List<LonjasProceso> lonjasProcesos;

	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="produccion")
	private List<ObservacionesPuntoControl> observacionesPuntoControls;

	//bi-directional many-to-one association to PanzasProceso
	@OneToMany(mappedBy="produccion")
	private List<PanzasProceso> panzasProcesos;

	//bi-directional many-to-one association to PedidoProduccionArchivoCargaCabecera
	@OneToMany(mappedBy="produccion")
	private List<PedidoProduccionArchivoCargaCabecera> pedidoProduccionArchivoCargaCabeceras;

	//bi-directional many-to-one association to PedidoProduccionCabecera
	@OneToMany(mappedBy="produccion")
	private List<PedidoProduccionCabecera> pedidoProduccionCabeceras;

	//bi-directional many-to-one association to PlanificacionCargaArchivo
	@OneToMany(mappedBy="produccion")
	private List<PlanificacionCargaArchivo> planificacionCargaArchivos;

	//bi-directional many-to-one association to PlanificacionCargaDetalle
	@OneToMany(mappedBy="produccion")
	private List<PlanificacionCargaDetalle> planificacionCargaDetalles;

	//bi-directional many-to-one association to PouchProceso
	@OneToMany(mappedBy="produccion")
	private List<PouchProceso> pouchProcesos;

	//bi-directional many-to-one association to ProduccionArchivoCargaLote
	@OneToMany(mappedBy="produccion")
	private List<ProduccionArchivoCargaLote> produccionArchivoCargaLotes;

	//bi-directional many-to-one association to ProduccionCargaArchivoPedido
	@OneToMany(mappedBy="produccion")
	private List<ProduccionCargaArchivoPedido> produccionCargaArchivoPedidos;

	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="produccion")
	private List<ProduccionDetalleLote> produccionDetalleLotes;

	//bi-directional many-to-one association to ProduccionDetalleLoteCarryover
	@OneToMany(mappedBy="produccion")
	private List<ProduccionDetalleLoteCarryover> produccionDetalleLoteCarryovers;

	//bi-directional many-to-one association to ProduccionOrdenPedido
	@OneToMany(mappedBy="produccion")
	private List<ProduccionOrdenPedido> produccionOrdenPedidos;

	//bi-directional many-to-one association to RackeoProceso
	@OneToMany(mappedBy="produccion")
	private List<RackeoProceso> rackeoProcesos;

	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="produccion")
	private List<ReportesPuntoControl> reportesPuntoControls;

	//bi-directional many-to-one association to RociadoProceso
	@OneToMany(mappedBy="produccion")
	private List<RociadoProceso> rociadoProcesos;

	public Produccion() {
	}

	public Long getIdproduccion() {
		return this.idproduccion;
	}

	public void setIdproduccion(Long idproduccion) {
		this.idproduccion = idproduccion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaproduccion() {
		return this.fechaproduccion;
	}

	public void setFechaproduccion(Timestamp fechaproduccion) {
		this.fechaproduccion = fechaproduccion;
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

	public List<ControlBatchProceso> getControlBatchProcesos() {
		return this.controlBatchProcesos;
	}

	public void setControlBatchProcesos(List<ControlBatchProceso> controlBatchProcesos) {
		this.controlBatchProcesos = controlBatchProcesos;
	}

	public List<DescongeladoDuchaAperturaCierreDetalle> getDescongeladoDuchaAperturaCierreDetalles() {
		return this.descongeladoDuchaAperturaCierreDetalles;
	}

	public void setDescongeladoDuchaAperturaCierreDetalles(List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles) {
		this.descongeladoDuchaAperturaCierreDetalles = descongeladoDuchaAperturaCierreDetalles;
	}

	public List<DescongeladoProceso> getDescongeladoProcesos() {
		return this.descongeladoProcesos;
	}

	public void setDescongeladoProcesos(List<DescongeladoProceso> descongeladoProcesos) {
		this.descongeladoProcesos = descongeladoProcesos;
	}

	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas() {
		return this.desperdicioCajonHarinas;
	}

	public void setDesperdicioCajonHarinas(List<DesperdicioCajonHarina> desperdicioCajonHarinas) {
		this.desperdicioCajonHarinas = desperdicioCajonHarinas;
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

	public List<EvisceradoProceso> getEvisceradoProcesos() {
		return this.evisceradoProcesos;
	}

	public void setEvisceradoProcesos(List<EvisceradoProceso> evisceradoProcesos) {
		this.evisceradoProcesos = evisceradoProcesos;
	}

	public List<EvolutionAuditoriaDetalle> getEvolutionAuditoriaDetalles() {
		return this.evolutionAuditoriaDetalles;
	}

	public void setEvolutionAuditoriaDetalles(List<EvolutionAuditoriaDetalle> evolutionAuditoriaDetalles) {
		this.evolutionAuditoriaDetalles = evolutionAuditoriaDetalles;
	}

	public List<LimpiezaAsignacionCanastilla> getLimpiezaAsignacionCanastillas() {
		return this.limpiezaAsignacionCanastillas;
	}

	public void setLimpiezaAsignacionCanastillas(List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas) {
		this.limpiezaAsignacionCanastillas = limpiezaAsignacionCanastillas;
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

	public List<PanzasProceso> getPanzasProcesos() {
		return this.panzasProcesos;
	}

	public void setPanzasProcesos(List<PanzasProceso> panzasProcesos) {
		this.panzasProcesos = panzasProcesos;
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

	public List<PlanificacionCargaDetalle> getPlanificacionCargaDetalles() {
		return this.planificacionCargaDetalles;
	}

	public void setPlanificacionCargaDetalles(List<PlanificacionCargaDetalle> planificacionCargaDetalles) {
		this.planificacionCargaDetalles = planificacionCargaDetalles;
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

	public List<RociadoProceso> getRociadoProcesos() {
		return this.rociadoProcesos;
	}

	public void setRociadoProcesos(List<RociadoProceso> rociadoProcesos) {
		this.rociadoProcesos = rociadoProcesos;
	}

}