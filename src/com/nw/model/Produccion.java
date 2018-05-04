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
@NamedQuery(name="Produccion.findAll", query="SELECT p FROM Produccion p")
public class Produccion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idproduccion;
	private Integer estado;
	private Timestamp fechaproduccion;
	private List<CoccionProceso> coccionProcesos;
	private List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles;
	private List<ControlBatchProceso> controlBatchProcesos;
	private List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles;
	private List<DescongeladoProceso> descongeladoProcesos;
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas;
	private List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles;
	private List<EnvasadoProceso> envasadoProcesos;
	private List<EspecialidadesProceso> especialidadesProcesos;
	private List<EvisceradoProceso> evisceradoProcesos;
	private List<EvolutionAuditoriaDetalle> evolutionAuditoriaDetalles;
	private List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas;
	private List<LimpiezaProceso> limpiezaProcesos;
	private List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas;
	private List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones;
	private List<LonjasProceso> lonjasProcesos;
	private List<ObservacionesPuntoControl> observacionesPuntoControls;
	private List<PanzasProceso> panzasProcesos;
	private List<PedidoProduccionArchivoCargaCabecera> pedidoProduccionArchivoCargaCabeceras;
	private List<PedidoProduccionCabecera> pedidoProduccionCabeceras;
	private List<PlanificacionCargaArchivo> planificacionCargaArchivos;
	private List<PlanificacionCargaDetalle> planificacionCargaDetalles;
	private List<PouchProceso> pouchProcesos;
	private List<ProduccionArchivoCargaLote> produccionArchivoCargaLotes;
	private List<ProduccionArchivoCargaOrden> produccionArchivoCargaOrdens;
	private List<ProduccionCargaArchivoPedido> produccionCargaArchivoPedidos;
	private List<ProduccionDetalleLote> produccionDetalleLotes;
	private List<ProduccionDetalleLoteCarryover> produccionDetalleLoteCarryovers;
	private List<ProduccionDetalleOrden> produccionDetalleOrdens;
	private List<ProduccionOrdenPedido> produccionOrdenPedidos;
	private List<RackeoProceso> rackeoProcesos;
	private List<ReportesPuntoControl> reportesPuntoControls;
	private List<RociadoProceso> rociadoProcesos;

	public Produccion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CoccionProceso
	@OneToMany(mappedBy="produccion")
	public List<CoccionProceso> getCoccionProcesos() {
		return this.coccionProcesos;
	}

	public void setCoccionProcesos(List<CoccionProceso> coccionProcesos) {
		this.coccionProcesos = coccionProcesos;
	}

	public CoccionProceso addCoccionProceso(CoccionProceso coccionProceso) {
		getCoccionProcesos().add(coccionProceso);
		coccionProceso.setProduccion(this);

		return coccionProceso;
	}

	public CoccionProceso removeCoccionProceso(CoccionProceso coccionProceso) {
		getCoccionProcesos().remove(coccionProceso);
		coccionProceso.setProduccion(null);

		return coccionProceso;
	}


	//bi-directional many-to-one association to CocinaAperturaCierreDetalle
	@OneToMany(mappedBy="produccion")
	public List<CocinaAperturaCierreDetalle> getCocinaAperturaCierreDetalles() {
		return this.cocinaAperturaCierreDetalles;
	}

	public void setCocinaAperturaCierreDetalles(List<CocinaAperturaCierreDetalle> cocinaAperturaCierreDetalles) {
		this.cocinaAperturaCierreDetalles = cocinaAperturaCierreDetalles;
	}

	public CocinaAperturaCierreDetalle addCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		getCocinaAperturaCierreDetalles().add(cocinaAperturaCierreDetalle);
		cocinaAperturaCierreDetalle.setProduccion(this);

		return cocinaAperturaCierreDetalle;
	}

	public CocinaAperturaCierreDetalle removeCocinaAperturaCierreDetalle(CocinaAperturaCierreDetalle cocinaAperturaCierreDetalle) {
		getCocinaAperturaCierreDetalles().remove(cocinaAperturaCierreDetalle);
		cocinaAperturaCierreDetalle.setProduccion(null);

		return cocinaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to ControlBatchProceso
	@OneToMany(mappedBy="produccion")
	public List<ControlBatchProceso> getControlBatchProcesos() {
		return this.controlBatchProcesos;
	}

	public void setControlBatchProcesos(List<ControlBatchProceso> controlBatchProcesos) {
		this.controlBatchProcesos = controlBatchProcesos;
	}

	public ControlBatchProceso addControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		getControlBatchProcesos().add(controlBatchProceso);
		controlBatchProceso.setProduccion(this);

		return controlBatchProceso;
	}

	public ControlBatchProceso removeControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		getControlBatchProcesos().remove(controlBatchProceso);
		controlBatchProceso.setProduccion(null);

		return controlBatchProceso;
	}


	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@OneToMany(mappedBy="produccion")
	public List<DescongeladoDuchaAperturaCierreDetalle> getDescongeladoDuchaAperturaCierreDetalles() {
		return this.descongeladoDuchaAperturaCierreDetalles;
	}

	public void setDescongeladoDuchaAperturaCierreDetalles(List<DescongeladoDuchaAperturaCierreDetalle> descongeladoDuchaAperturaCierreDetalles) {
		this.descongeladoDuchaAperturaCierreDetalles = descongeladoDuchaAperturaCierreDetalles;
	}

	public DescongeladoDuchaAperturaCierreDetalle addDescongeladoDuchaAperturaCierreDetalle(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle) {
		getDescongeladoDuchaAperturaCierreDetalles().add(descongeladoDuchaAperturaCierreDetalle);
		descongeladoDuchaAperturaCierreDetalle.setProduccion(this);

		return descongeladoDuchaAperturaCierreDetalle;
	}

	public DescongeladoDuchaAperturaCierreDetalle removeDescongeladoDuchaAperturaCierreDetalle(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle) {
		getDescongeladoDuchaAperturaCierreDetalles().remove(descongeladoDuchaAperturaCierreDetalle);
		descongeladoDuchaAperturaCierreDetalle.setProduccion(null);

		return descongeladoDuchaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to DescongeladoProceso
	@OneToMany(mappedBy="produccion")
	public List<DescongeladoProceso> getDescongeladoProcesos() {
		return this.descongeladoProcesos;
	}

	public void setDescongeladoProcesos(List<DescongeladoProceso> descongeladoProcesos) {
		this.descongeladoProcesos = descongeladoProcesos;
	}

	public DescongeladoProceso addDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		getDescongeladoProcesos().add(descongeladoProceso);
		descongeladoProceso.setProduccion(this);

		return descongeladoProceso;
	}

	public DescongeladoProceso removeDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		getDescongeladoProcesos().remove(descongeladoProceso);
		descongeladoProceso.setProduccion(null);

		return descongeladoProceso;
	}


	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="produccion")
	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas() {
		return this.desperdicioCajonHarinas;
	}

	public void setDesperdicioCajonHarinas(List<DesperdicioCajonHarina> desperdicioCajonHarinas) {
		this.desperdicioCajonHarinas = desperdicioCajonHarinas;
	}

	public DesperdicioCajonHarina addDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		getDesperdicioCajonHarinas().add(desperdicioCajonHarina);
		desperdicioCajonHarina.setProduccion(this);

		return desperdicioCajonHarina;
	}

	public DesperdicioCajonHarina removeDesperdicioCajonHarina(DesperdicioCajonHarina desperdicioCajonHarina) {
		getDesperdicioCajonHarinas().remove(desperdicioCajonHarina);
		desperdicioCajonHarina.setProduccion(null);

		return desperdicioCajonHarina;
	}


	//bi-directional many-to-one association to DuchaAperturaCierreDetalle
	@OneToMany(mappedBy="produccion")
	public List<DuchaAperturaCierreDetalle> getDuchaAperturaCierreDetalles() {
		return this.duchaAperturaCierreDetalles;
	}

	public void setDuchaAperturaCierreDetalles(List<DuchaAperturaCierreDetalle> duchaAperturaCierreDetalles) {
		this.duchaAperturaCierreDetalles = duchaAperturaCierreDetalles;
	}

	public DuchaAperturaCierreDetalle addDuchaAperturaCierreDetalle(DuchaAperturaCierreDetalle duchaAperturaCierreDetalle) {
		getDuchaAperturaCierreDetalles().add(duchaAperturaCierreDetalle);
		duchaAperturaCierreDetalle.setProduccion(this);

		return duchaAperturaCierreDetalle;
	}

	public DuchaAperturaCierreDetalle removeDuchaAperturaCierreDetalle(DuchaAperturaCierreDetalle duchaAperturaCierreDetalle) {
		getDuchaAperturaCierreDetalles().remove(duchaAperturaCierreDetalle);
		duchaAperturaCierreDetalle.setProduccion(null);

		return duchaAperturaCierreDetalle;
	}


	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="produccion")
	public List<EnvasadoProceso> getEnvasadoProcesos() {
		return this.envasadoProcesos;
	}

	public void setEnvasadoProcesos(List<EnvasadoProceso> envasadoProcesos) {
		this.envasadoProcesos = envasadoProcesos;
	}

	public EnvasadoProceso addEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().add(envasadoProceso);
		envasadoProceso.setProduccion(this);

		return envasadoProceso;
	}

	public EnvasadoProceso removeEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().remove(envasadoProceso);
		envasadoProceso.setProduccion(null);

		return envasadoProceso;
	}


	//bi-directional many-to-one association to EspecialidadesProceso
	@OneToMany(mappedBy="produccion")
	public List<EspecialidadesProceso> getEspecialidadesProcesos() {
		return this.especialidadesProcesos;
	}

	public void setEspecialidadesProcesos(List<EspecialidadesProceso> especialidadesProcesos) {
		this.especialidadesProcesos = especialidadesProcesos;
	}

	public EspecialidadesProceso addEspecialidadesProceso(EspecialidadesProceso especialidadesProceso) {
		getEspecialidadesProcesos().add(especialidadesProceso);
		especialidadesProceso.setProduccion(this);

		return especialidadesProceso;
	}

	public EspecialidadesProceso removeEspecialidadesProceso(EspecialidadesProceso especialidadesProceso) {
		getEspecialidadesProcesos().remove(especialidadesProceso);
		especialidadesProceso.setProduccion(null);

		return especialidadesProceso;
	}


	//bi-directional many-to-one association to EvisceradoProceso
	@OneToMany(mappedBy="produccion")
	public List<EvisceradoProceso> getEvisceradoProcesos() {
		return this.evisceradoProcesos;
	}

	public void setEvisceradoProcesos(List<EvisceradoProceso> evisceradoProcesos) {
		this.evisceradoProcesos = evisceradoProcesos;
	}

	public EvisceradoProceso addEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		getEvisceradoProcesos().add(evisceradoProceso);
		evisceradoProceso.setProduccion(this);

		return evisceradoProceso;
	}

	public EvisceradoProceso removeEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		getEvisceradoProcesos().remove(evisceradoProceso);
		evisceradoProceso.setProduccion(null);

		return evisceradoProceso;
	}


	//bi-directional many-to-one association to EvolutionAuditoriaDetalle
	@OneToMany(mappedBy="produccion")
	public List<EvolutionAuditoriaDetalle> getEvolutionAuditoriaDetalles() {
		return this.evolutionAuditoriaDetalles;
	}

	public void setEvolutionAuditoriaDetalles(List<EvolutionAuditoriaDetalle> evolutionAuditoriaDetalles) {
		this.evolutionAuditoriaDetalles = evolutionAuditoriaDetalles;
	}

	public EvolutionAuditoriaDetalle addEvolutionAuditoriaDetalle(EvolutionAuditoriaDetalle evolutionAuditoriaDetalle) {
		getEvolutionAuditoriaDetalles().add(evolutionAuditoriaDetalle);
		evolutionAuditoriaDetalle.setProduccion(this);

		return evolutionAuditoriaDetalle;
	}

	public EvolutionAuditoriaDetalle removeEvolutionAuditoriaDetalle(EvolutionAuditoriaDetalle evolutionAuditoriaDetalle) {
		getEvolutionAuditoriaDetalles().remove(evolutionAuditoriaDetalle);
		evolutionAuditoriaDetalle.setProduccion(null);

		return evolutionAuditoriaDetalle;
	}


	//bi-directional many-to-one association to LimpiezaAsignacionCanastilla
	@OneToMany(mappedBy="produccion")
	public List<LimpiezaAsignacionCanastilla> getLimpiezaAsignacionCanastillas() {
		return this.limpiezaAsignacionCanastillas;
	}

	public void setLimpiezaAsignacionCanastillas(List<LimpiezaAsignacionCanastilla> limpiezaAsignacionCanastillas) {
		this.limpiezaAsignacionCanastillas = limpiezaAsignacionCanastillas;
	}

	public LimpiezaAsignacionCanastilla addLimpiezaAsignacionCanastilla(LimpiezaAsignacionCanastilla limpiezaAsignacionCanastilla) {
		getLimpiezaAsignacionCanastillas().add(limpiezaAsignacionCanastilla);
		limpiezaAsignacionCanastilla.setProduccion(this);

		return limpiezaAsignacionCanastilla;
	}

	public LimpiezaAsignacionCanastilla removeLimpiezaAsignacionCanastilla(LimpiezaAsignacionCanastilla limpiezaAsignacionCanastilla) {
		getLimpiezaAsignacionCanastillas().remove(limpiezaAsignacionCanastilla);
		limpiezaAsignacionCanastilla.setProduccion(null);

		return limpiezaAsignacionCanastilla;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="produccion")
	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
	}

	public LimpiezaProceso addLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().add(limpiezaProceso);
		limpiezaProceso.setProduccion(this);

		return limpiezaProceso;
	}

	public LimpiezaProceso removeLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().remove(limpiezaProceso);
		limpiezaProceso.setProduccion(null);

		return limpiezaProceso;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoFalta
	@OneToMany(mappedBy="produccion")
	public List<LimpiezaProcesoEmpleadoFalta> getLimpiezaProcesoEmpleadoFaltas() {
		return this.limpiezaProcesoEmpleadoFaltas;
	}

	public void setLimpiezaProcesoEmpleadoFaltas(List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas) {
		this.limpiezaProcesoEmpleadoFaltas = limpiezaProcesoEmpleadoFaltas;
	}

	public LimpiezaProcesoEmpleadoFalta addLimpiezaProcesoEmpleadoFalta(LimpiezaProcesoEmpleadoFalta limpiezaProcesoEmpleadoFalta) {
		getLimpiezaProcesoEmpleadoFaltas().add(limpiezaProcesoEmpleadoFalta);
		limpiezaProcesoEmpleadoFalta.setProduccion(this);

		return limpiezaProcesoEmpleadoFalta;
	}

	public LimpiezaProcesoEmpleadoFalta removeLimpiezaProcesoEmpleadoFalta(LimpiezaProcesoEmpleadoFalta limpiezaProcesoEmpleadoFalta) {
		getLimpiezaProcesoEmpleadoFaltas().remove(limpiezaProcesoEmpleadoFalta);
		limpiezaProcesoEmpleadoFalta.setProduccion(null);

		return limpiezaProcesoEmpleadoFalta;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoMarcacione
	@OneToMany(mappedBy="produccion")
	public List<LimpiezaProcesoEmpleadoMarcacione> getLimpiezaProcesoEmpleadoMarcaciones() {
		return this.limpiezaProcesoEmpleadoMarcaciones;
	}

	public void setLimpiezaProcesoEmpleadoMarcaciones(List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones) {
		this.limpiezaProcesoEmpleadoMarcaciones = limpiezaProcesoEmpleadoMarcaciones;
	}

	public LimpiezaProcesoEmpleadoMarcacione addLimpiezaProcesoEmpleadoMarcacione(LimpiezaProcesoEmpleadoMarcacione limpiezaProcesoEmpleadoMarcacione) {
		getLimpiezaProcesoEmpleadoMarcaciones().add(limpiezaProcesoEmpleadoMarcacione);
		limpiezaProcesoEmpleadoMarcacione.setProduccion(this);

		return limpiezaProcesoEmpleadoMarcacione;
	}

	public LimpiezaProcesoEmpleadoMarcacione removeLimpiezaProcesoEmpleadoMarcacione(LimpiezaProcesoEmpleadoMarcacione limpiezaProcesoEmpleadoMarcacione) {
		getLimpiezaProcesoEmpleadoMarcaciones().remove(limpiezaProcesoEmpleadoMarcacione);
		limpiezaProcesoEmpleadoMarcacione.setProduccion(null);

		return limpiezaProcesoEmpleadoMarcacione;
	}


	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="produccion")
	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
	}

	public LonjasProceso addLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().add(lonjasProceso);
		lonjasProceso.setProduccion(this);

		return lonjasProceso;
	}

	public LonjasProceso removeLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().remove(lonjasProceso);
		lonjasProceso.setProduccion(null);

		return lonjasProceso;
	}


	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="produccion")
	public List<ObservacionesPuntoControl> getObservacionesPuntoControls() {
		return this.observacionesPuntoControls;
	}

	public void setObservacionesPuntoControls(List<ObservacionesPuntoControl> observacionesPuntoControls) {
		this.observacionesPuntoControls = observacionesPuntoControls;
	}

	public ObservacionesPuntoControl addObservacionesPuntoControl(ObservacionesPuntoControl observacionesPuntoControl) {
		getObservacionesPuntoControls().add(observacionesPuntoControl);
		observacionesPuntoControl.setProduccion(this);

		return observacionesPuntoControl;
	}

	public ObservacionesPuntoControl removeObservacionesPuntoControl(ObservacionesPuntoControl observacionesPuntoControl) {
		getObservacionesPuntoControls().remove(observacionesPuntoControl);
		observacionesPuntoControl.setProduccion(null);

		return observacionesPuntoControl;
	}


	//bi-directional many-to-one association to PanzasProceso
	@OneToMany(mappedBy="produccion")
	public List<PanzasProceso> getPanzasProcesos() {
		return this.panzasProcesos;
	}

	public void setPanzasProcesos(List<PanzasProceso> panzasProcesos) {
		this.panzasProcesos = panzasProcesos;
	}

	public PanzasProceso addPanzasProceso(PanzasProceso panzasProceso) {
		getPanzasProcesos().add(panzasProceso);
		panzasProceso.setProduccion(this);

		return panzasProceso;
	}

	public PanzasProceso removePanzasProceso(PanzasProceso panzasProceso) {
		getPanzasProcesos().remove(panzasProceso);
		panzasProceso.setProduccion(null);

		return panzasProceso;
	}


	//bi-directional many-to-one association to PedidoProduccionArchivoCargaCabecera
	@OneToMany(mappedBy="produccion")
	public List<PedidoProduccionArchivoCargaCabecera> getPedidoProduccionArchivoCargaCabeceras() {
		return this.pedidoProduccionArchivoCargaCabeceras;
	}

	public void setPedidoProduccionArchivoCargaCabeceras(List<PedidoProduccionArchivoCargaCabecera> pedidoProduccionArchivoCargaCabeceras) {
		this.pedidoProduccionArchivoCargaCabeceras = pedidoProduccionArchivoCargaCabeceras;
	}

	public PedidoProduccionArchivoCargaCabecera addPedidoProduccionArchivoCargaCabecera(PedidoProduccionArchivoCargaCabecera pedidoProduccionArchivoCargaCabecera) {
		getPedidoProduccionArchivoCargaCabeceras().add(pedidoProduccionArchivoCargaCabecera);
		pedidoProduccionArchivoCargaCabecera.setProduccion(this);

		return pedidoProduccionArchivoCargaCabecera;
	}

	public PedidoProduccionArchivoCargaCabecera removePedidoProduccionArchivoCargaCabecera(PedidoProduccionArchivoCargaCabecera pedidoProduccionArchivoCargaCabecera) {
		getPedidoProduccionArchivoCargaCabeceras().remove(pedidoProduccionArchivoCargaCabecera);
		pedidoProduccionArchivoCargaCabecera.setProduccion(null);

		return pedidoProduccionArchivoCargaCabecera;
	}


	//bi-directional many-to-one association to PedidoProduccionCabecera
	@OneToMany(mappedBy="produccion")
	public List<PedidoProduccionCabecera> getPedidoProduccionCabeceras() {
		return this.pedidoProduccionCabeceras;
	}

	public void setPedidoProduccionCabeceras(List<PedidoProduccionCabecera> pedidoProduccionCabeceras) {
		this.pedidoProduccionCabeceras = pedidoProduccionCabeceras;
	}

	public PedidoProduccionCabecera addPedidoProduccionCabecera(PedidoProduccionCabecera pedidoProduccionCabecera) {
		getPedidoProduccionCabeceras().add(pedidoProduccionCabecera);
		pedidoProduccionCabecera.setProduccion(this);

		return pedidoProduccionCabecera;
	}

	public PedidoProduccionCabecera removePedidoProduccionCabecera(PedidoProduccionCabecera pedidoProduccionCabecera) {
		getPedidoProduccionCabeceras().remove(pedidoProduccionCabecera);
		pedidoProduccionCabecera.setProduccion(null);

		return pedidoProduccionCabecera;
	}


	//bi-directional many-to-one association to PlanificacionCargaArchivo
	@OneToMany(mappedBy="produccion")
	public List<PlanificacionCargaArchivo> getPlanificacionCargaArchivos() {
		return this.planificacionCargaArchivos;
	}

	public void setPlanificacionCargaArchivos(List<PlanificacionCargaArchivo> planificacionCargaArchivos) {
		this.planificacionCargaArchivos = planificacionCargaArchivos;
	}

	public PlanificacionCargaArchivo addPlanificacionCargaArchivo(PlanificacionCargaArchivo planificacionCargaArchivo) {
		getPlanificacionCargaArchivos().add(planificacionCargaArchivo);
		planificacionCargaArchivo.setProduccion(this);

		return planificacionCargaArchivo;
	}

	public PlanificacionCargaArchivo removePlanificacionCargaArchivo(PlanificacionCargaArchivo planificacionCargaArchivo) {
		getPlanificacionCargaArchivos().remove(planificacionCargaArchivo);
		planificacionCargaArchivo.setProduccion(null);

		return planificacionCargaArchivo;
	}


	//bi-directional many-to-one association to PlanificacionCargaDetalle
	@OneToMany(mappedBy="produccion")
	public List<PlanificacionCargaDetalle> getPlanificacionCargaDetalles() {
		return this.planificacionCargaDetalles;
	}

	public void setPlanificacionCargaDetalles(List<PlanificacionCargaDetalle> planificacionCargaDetalles) {
		this.planificacionCargaDetalles = planificacionCargaDetalles;
	}

	public PlanificacionCargaDetalle addPlanificacionCargaDetalle(PlanificacionCargaDetalle planificacionCargaDetalle) {
		getPlanificacionCargaDetalles().add(planificacionCargaDetalle);
		planificacionCargaDetalle.setProduccion(this);

		return planificacionCargaDetalle;
	}

	public PlanificacionCargaDetalle removePlanificacionCargaDetalle(PlanificacionCargaDetalle planificacionCargaDetalle) {
		getPlanificacionCargaDetalles().remove(planificacionCargaDetalle);
		planificacionCargaDetalle.setProduccion(null);

		return planificacionCargaDetalle;
	}


	//bi-directional many-to-one association to PouchProceso
	@OneToMany(mappedBy="produccion")
	public List<PouchProceso> getPouchProcesos() {
		return this.pouchProcesos;
	}

	public void setPouchProcesos(List<PouchProceso> pouchProcesos) {
		this.pouchProcesos = pouchProcesos;
	}

	public PouchProceso addPouchProceso(PouchProceso pouchProceso) {
		getPouchProcesos().add(pouchProceso);
		pouchProceso.setProduccion(this);

		return pouchProceso;
	}

	public PouchProceso removePouchProceso(PouchProceso pouchProceso) {
		getPouchProcesos().remove(pouchProceso);
		pouchProceso.setProduccion(null);

		return pouchProceso;
	}


	//bi-directional many-to-one association to ProduccionArchivoCargaLote
	@OneToMany(mappedBy="produccion")
	public List<ProduccionArchivoCargaLote> getProduccionArchivoCargaLotes() {
		return this.produccionArchivoCargaLotes;
	}

	public void setProduccionArchivoCargaLotes(List<ProduccionArchivoCargaLote> produccionArchivoCargaLotes) {
		this.produccionArchivoCargaLotes = produccionArchivoCargaLotes;
	}

	public ProduccionArchivoCargaLote addProduccionArchivoCargaLote(ProduccionArchivoCargaLote produccionArchivoCargaLote) {
		getProduccionArchivoCargaLotes().add(produccionArchivoCargaLote);
		produccionArchivoCargaLote.setProduccion(this);

		return produccionArchivoCargaLote;
	}

	public ProduccionArchivoCargaLote removeProduccionArchivoCargaLote(ProduccionArchivoCargaLote produccionArchivoCargaLote) {
		getProduccionArchivoCargaLotes().remove(produccionArchivoCargaLote);
		produccionArchivoCargaLote.setProduccion(null);

		return produccionArchivoCargaLote;
	}


	//bi-directional many-to-one association to ProduccionArchivoCargaOrden
	@OneToMany(mappedBy="produccion")
	public List<ProduccionArchivoCargaOrden> getProduccionArchivoCargaOrdens() {
		return this.produccionArchivoCargaOrdens;
	}

	public void setProduccionArchivoCargaOrdens(List<ProduccionArchivoCargaOrden> produccionArchivoCargaOrdens) {
		this.produccionArchivoCargaOrdens = produccionArchivoCargaOrdens;
	}

	public ProduccionArchivoCargaOrden addProduccionArchivoCargaOrden(ProduccionArchivoCargaOrden produccionArchivoCargaOrden) {
		getProduccionArchivoCargaOrdens().add(produccionArchivoCargaOrden);
		produccionArchivoCargaOrden.setProduccion(this);

		return produccionArchivoCargaOrden;
	}

	public ProduccionArchivoCargaOrden removeProduccionArchivoCargaOrden(ProduccionArchivoCargaOrden produccionArchivoCargaOrden) {
		getProduccionArchivoCargaOrdens().remove(produccionArchivoCargaOrden);
		produccionArchivoCargaOrden.setProduccion(null);

		return produccionArchivoCargaOrden;
	}


	//bi-directional many-to-one association to ProduccionCargaArchivoPedido
	@OneToMany(mappedBy="produccion")
	public List<ProduccionCargaArchivoPedido> getProduccionCargaArchivoPedidos() {
		return this.produccionCargaArchivoPedidos;
	}

	public void setProduccionCargaArchivoPedidos(List<ProduccionCargaArchivoPedido> produccionCargaArchivoPedidos) {
		this.produccionCargaArchivoPedidos = produccionCargaArchivoPedidos;
	}

	public ProduccionCargaArchivoPedido addProduccionCargaArchivoPedido(ProduccionCargaArchivoPedido produccionCargaArchivoPedido) {
		getProduccionCargaArchivoPedidos().add(produccionCargaArchivoPedido);
		produccionCargaArchivoPedido.setProduccion(this);

		return produccionCargaArchivoPedido;
	}

	public ProduccionCargaArchivoPedido removeProduccionCargaArchivoPedido(ProduccionCargaArchivoPedido produccionCargaArchivoPedido) {
		getProduccionCargaArchivoPedidos().remove(produccionCargaArchivoPedido);
		produccionCargaArchivoPedido.setProduccion(null);

		return produccionCargaArchivoPedido;
	}


	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="produccion")
	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

	public ProduccionDetalleLote addProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().add(produccionDetalleLote);
		produccionDetalleLote.setProduccion(this);

		return produccionDetalleLote;
	}

	public ProduccionDetalleLote removeProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().remove(produccionDetalleLote);
		produccionDetalleLote.setProduccion(null);

		return produccionDetalleLote;
	}


	//bi-directional many-to-one association to ProduccionDetalleLoteCarryover
	@OneToMany(mappedBy="produccion")
	public List<ProduccionDetalleLoteCarryover> getProduccionDetalleLoteCarryovers() {
		return this.produccionDetalleLoteCarryovers;
	}

	public void setProduccionDetalleLoteCarryovers(List<ProduccionDetalleLoteCarryover> produccionDetalleLoteCarryovers) {
		this.produccionDetalleLoteCarryovers = produccionDetalleLoteCarryovers;
	}

	public ProduccionDetalleLoteCarryover addProduccionDetalleLoteCarryover(ProduccionDetalleLoteCarryover produccionDetalleLoteCarryover) {
		getProduccionDetalleLoteCarryovers().add(produccionDetalleLoteCarryover);
		produccionDetalleLoteCarryover.setProduccion(this);

		return produccionDetalleLoteCarryover;
	}

	public ProduccionDetalleLoteCarryover removeProduccionDetalleLoteCarryover(ProduccionDetalleLoteCarryover produccionDetalleLoteCarryover) {
		getProduccionDetalleLoteCarryovers().remove(produccionDetalleLoteCarryover);
		produccionDetalleLoteCarryover.setProduccion(null);

		return produccionDetalleLoteCarryover;
	}


	//bi-directional many-to-one association to ProduccionDetalleOrden
	@OneToMany(mappedBy="produccion")
	public List<ProduccionDetalleOrden> getProduccionDetalleOrdens() {
		return this.produccionDetalleOrdens;
	}

	public void setProduccionDetalleOrdens(List<ProduccionDetalleOrden> produccionDetalleOrdens) {
		this.produccionDetalleOrdens = produccionDetalleOrdens;
	}

	public ProduccionDetalleOrden addProduccionDetalleOrden(ProduccionDetalleOrden produccionDetalleOrden) {
		getProduccionDetalleOrdens().add(produccionDetalleOrden);
		produccionDetalleOrden.setProduccion(this);

		return produccionDetalleOrden;
	}

	public ProduccionDetalleOrden removeProduccionDetalleOrden(ProduccionDetalleOrden produccionDetalleOrden) {
		getProduccionDetalleOrdens().remove(produccionDetalleOrden);
		produccionDetalleOrden.setProduccion(null);

		return produccionDetalleOrden;
	}


	//bi-directional many-to-one association to ProduccionOrdenPedido
	@OneToMany(mappedBy="produccion")
	public List<ProduccionOrdenPedido> getProduccionOrdenPedidos() {
		return this.produccionOrdenPedidos;
	}

	public void setProduccionOrdenPedidos(List<ProduccionOrdenPedido> produccionOrdenPedidos) {
		this.produccionOrdenPedidos = produccionOrdenPedidos;
	}

	public ProduccionOrdenPedido addProduccionOrdenPedido(ProduccionOrdenPedido produccionOrdenPedido) {
		getProduccionOrdenPedidos().add(produccionOrdenPedido);
		produccionOrdenPedido.setProduccion(this);

		return produccionOrdenPedido;
	}

	public ProduccionOrdenPedido removeProduccionOrdenPedido(ProduccionOrdenPedido produccionOrdenPedido) {
		getProduccionOrdenPedidos().remove(produccionOrdenPedido);
		produccionOrdenPedido.setProduccion(null);

		return produccionOrdenPedido;
	}


	//bi-directional many-to-one association to RackeoProceso
	@OneToMany(mappedBy="produccion")
	public List<RackeoProceso> getRackeoProcesos() {
		return this.rackeoProcesos;
	}

	public void setRackeoProcesos(List<RackeoProceso> rackeoProcesos) {
		this.rackeoProcesos = rackeoProcesos;
	}

	public RackeoProceso addRackeoProceso(RackeoProceso rackeoProceso) {
		getRackeoProcesos().add(rackeoProceso);
		rackeoProceso.setProduccion(this);

		return rackeoProceso;
	}

	public RackeoProceso removeRackeoProceso(RackeoProceso rackeoProceso) {
		getRackeoProcesos().remove(rackeoProceso);
		rackeoProceso.setProduccion(null);

		return rackeoProceso;
	}


	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="produccion")
	public List<ReportesPuntoControl> getReportesPuntoControls() {
		return this.reportesPuntoControls;
	}

	public void setReportesPuntoControls(List<ReportesPuntoControl> reportesPuntoControls) {
		this.reportesPuntoControls = reportesPuntoControls;
	}

	public ReportesPuntoControl addReportesPuntoControl(ReportesPuntoControl reportesPuntoControl) {
		getReportesPuntoControls().add(reportesPuntoControl);
		reportesPuntoControl.setProduccion(this);

		return reportesPuntoControl;
	}

	public ReportesPuntoControl removeReportesPuntoControl(ReportesPuntoControl reportesPuntoControl) {
		getReportesPuntoControls().remove(reportesPuntoControl);
		reportesPuntoControl.setProduccion(null);

		return reportesPuntoControl;
	}


	//bi-directional many-to-one association to RociadoProceso
	@OneToMany(mappedBy="produccion")
	public List<RociadoProceso> getRociadoProcesos() {
		return this.rociadoProcesos;
	}

	public void setRociadoProcesos(List<RociadoProceso> rociadoProcesos) {
		this.rociadoProcesos = rociadoProcesos;
	}

	public RociadoProceso addRociadoProceso(RociadoProceso rociadoProceso) {
		getRociadoProcesos().add(rociadoProceso);
		rociadoProceso.setProduccion(this);

		return rociadoProceso;
	}

	public RociadoProceso removeRociadoProceso(RociadoProceso rociadoProceso) {
		getRociadoProcesos().remove(rociadoProceso);
		rociadoProceso.setProduccion(null);

		return rociadoProceso;
	}

}