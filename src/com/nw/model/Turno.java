package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the turno database table.
 * 
 */
@Entity
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idturno;
	private String nombre;
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
	private List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas;
	private List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas;
	private List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras;
	private List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles;
	private List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras;
	private List<CalidadMuestreoCocina> calidadMuestreoCocinas;
	private List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions;
	private List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados;
	private List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas;
	private List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados;
	private List<CamaraCajon> camaraCajons;
	private List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches;
	private List<CoccionDetalleMuestreoTempCocheAdic> coccionDetalleMuestreoTempCocheAdics;
	private List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos;
	private List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches;
	private List<CoccionDetalleProcesoCocheTemperatura> coccionDetalleProcesoCocheTemperaturas;
	private List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches;
	private List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos;
	private List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches;
	private List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas;
	private List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches;
	private List<ControlBatchProceso> controlBatchProcesos;
	private List<DescongeladoCajonModificacion> descongeladoCajonModificacions;
	private List<DescongeladoDetalleProceso> descongeladoDetalleProcesos;
	private List<DescongeladoDetalleProcesoContraloria> descongeladoDetalleProcesoContralorias;
	private List<DescongeladoDetalleProcesoTempIng> descongeladoDetalleProcesoTempIngs;
	private List<DescongeladoDetalleProcesoTemperatura> descongeladoDetalleProcesoTemperaturas;
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas1;
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas2;
	private List<DesperdicioCajonHarina> desperdicioCajonHarinas3;
	private List<DesperdicioDetalle> desperdicioDetalles;
	private List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras;
	private List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabeceras;
	private List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios;
	private List<EnvasadoProceso> envasadoProcesos;
	private List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados;
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;
	private List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches;
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;
	private List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches;
	private List<GestionTurno> gestionTurnos;
	private List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes;
	private List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes;
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions;
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;
	private List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches;
	private List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes;
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;
	private List<LimpiezaProceso> limpiezaProcesos;
	private List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas;
	private List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones;
	private List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos;
	private List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques;
	private List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes;
	private List<LonjasProceso> lonjasProcesos;
	private List<ObservacionesPuntoControl> observacionesPuntoControls;
	private List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos;
	private List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes;
	private List<PanzasProceso> panzasProcesos;
	private List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles;
	private List<PedidoProduccionDetalle> pedidoProduccionDetalles;
	private List<PlanificacionCargaDetalle> planificacionCargaDetalles;
	private List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos;
	private List<ProduccionArchivoCargaOrdenDetalle> produccionArchivoCargaOrdenDetalles;
	private List<ProduccionDetalleLote> produccionDetalleLotes;
	private List<ProduccionDetalleLoteCarryover> produccionDetalleLoteCarryovers;
	private List<ProduccionDetalleOrden> produccionDetalleOrdens;
	private List<ProduccionOrdenPedido> produccionOrdenPedidos;
	private List<RackeoProceso> rackeoProcesos;
	private List<ReportesPuntoControl> reportesPuntoControls;
	private List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches;
	private List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches;
	private List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas;
	private List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches;
	private List<TurnoGestionDetalle> turnoGestionDetalles;

	public Turno() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to CalidadDescongeladoDetalleTempAgua
	@OneToMany(mappedBy="turno")
	public List<CalidadDescongeladoDetalleTempAgua> getCalidadDescongeladoDetalleTempAguas() {
		return this.calidadDescongeladoDetalleTempAguas;
	}

	public void setCalidadDescongeladoDetalleTempAguas(List<CalidadDescongeladoDetalleTempAgua> calidadDescongeladoDetalleTempAguas) {
		this.calidadDescongeladoDetalleTempAguas = calidadDescongeladoDetalleTempAguas;
	}

	public CalidadDescongeladoDetalleTempAgua addCalidadDescongeladoDetalleTempAgua(CalidadDescongeladoDetalleTempAgua calidadDescongeladoDetalleTempAgua) {
		getCalidadDescongeladoDetalleTempAguas().add(calidadDescongeladoDetalleTempAgua);
		calidadDescongeladoDetalleTempAgua.setTurno(this);

		return calidadDescongeladoDetalleTempAgua;
	}

	public CalidadDescongeladoDetalleTempAgua removeCalidadDescongeladoDetalleTempAgua(CalidadDescongeladoDetalleTempAgua calidadDescongeladoDetalleTempAgua) {
		getCalidadDescongeladoDetalleTempAguas().remove(calidadDescongeladoDetalleTempAgua);
		calidadDescongeladoDetalleTempAgua.setTurno(null);

		return calidadDescongeladoDetalleTempAgua;
	}


	//bi-directional many-to-one association to CalidadDescongeladoDetalleTempPescado
	@OneToMany(mappedBy="turno")
	public List<CalidadDescongeladoDetalleTempPescado> getCalidadDescongeladoDetalleTempPescados() {
		return this.calidadDescongeladoDetalleTempPescados;
	}

	public void setCalidadDescongeladoDetalleTempPescados(List<CalidadDescongeladoDetalleTempPescado> calidadDescongeladoDetalleTempPescados) {
		this.calidadDescongeladoDetalleTempPescados = calidadDescongeladoDetalleTempPescados;
	}

	public CalidadDescongeladoDetalleTempPescado addCalidadDescongeladoDetalleTempPescado(CalidadDescongeladoDetalleTempPescado calidadDescongeladoDetalleTempPescado) {
		getCalidadDescongeladoDetalleTempPescados().add(calidadDescongeladoDetalleTempPescado);
		calidadDescongeladoDetalleTempPescado.setTurno(this);

		return calidadDescongeladoDetalleTempPescado;
	}

	public CalidadDescongeladoDetalleTempPescado removeCalidadDescongeladoDetalleTempPescado(CalidadDescongeladoDetalleTempPescado calidadDescongeladoDetalleTempPescado) {
		getCalidadDescongeladoDetalleTempPescados().remove(calidadDescongeladoDetalleTempPescado);
		calidadDescongeladoDetalleTempPescado.setTurno(null);

		return calidadDescongeladoDetalleTempPescado;
	}


	//bi-directional many-to-one association to CalidadDescongeladoTempAgua
	@OneToMany(mappedBy="turno")
	public List<CalidadDescongeladoTempAgua> getCalidadDescongeladoTempAguas() {
		return this.calidadDescongeladoTempAguas;
	}

	public void setCalidadDescongeladoTempAguas(List<CalidadDescongeladoTempAgua> calidadDescongeladoTempAguas) {
		this.calidadDescongeladoTempAguas = calidadDescongeladoTempAguas;
	}

	public CalidadDescongeladoTempAgua addCalidadDescongeladoTempAgua(CalidadDescongeladoTempAgua calidadDescongeladoTempAgua) {
		getCalidadDescongeladoTempAguas().add(calidadDescongeladoTempAgua);
		calidadDescongeladoTempAgua.setTurno(this);

		return calidadDescongeladoTempAgua;
	}

	public CalidadDescongeladoTempAgua removeCalidadDescongeladoTempAgua(CalidadDescongeladoTempAgua calidadDescongeladoTempAgua) {
		getCalidadDescongeladoTempAguas().remove(calidadDescongeladoTempAgua);
		calidadDescongeladoTempAgua.setTurno(null);

		return calidadDescongeladoTempAgua;
	}


	//bi-directional many-to-one association to CalidadDescongeladoTempPescado
	@OneToMany(mappedBy="turno")
	public List<CalidadDescongeladoTempPescado> getCalidadDescongeladoTempPescados() {
		return this.calidadDescongeladoTempPescados;
	}

	public void setCalidadDescongeladoTempPescados(List<CalidadDescongeladoTempPescado> calidadDescongeladoTempPescados) {
		this.calidadDescongeladoTempPescados = calidadDescongeladoTempPescados;
	}

	public CalidadDescongeladoTempPescado addCalidadDescongeladoTempPescado(CalidadDescongeladoTempPescado calidadDescongeladoTempPescado) {
		getCalidadDescongeladoTempPescados().add(calidadDescongeladoTempPescado);
		calidadDescongeladoTempPescado.setTurno(this);

		return calidadDescongeladoTempPescado;
	}

	public CalidadDescongeladoTempPescado removeCalidadDescongeladoTempPescado(CalidadDescongeladoTempPescado calidadDescongeladoTempPescado) {
		getCalidadDescongeladoTempPescados().remove(calidadDescongeladoTempPescado);
		calidadDescongeladoTempPescado.setTurno(null);

		return calidadDescongeladoTempPescado;
	}


	//bi-directional many-to-one association to CalidadDetalleEspecietallaCajonBanda
	@OneToMany(mappedBy="turno")
	public List<CalidadDetalleEspecietallaCajonBanda> getCalidadDetalleEspecietallaCajonBandas() {
		return this.calidadDetalleEspecietallaCajonBandas;
	}

	public void setCalidadDetalleEspecietallaCajonBandas(List<CalidadDetalleEspecietallaCajonBanda> calidadDetalleEspecietallaCajonBandas) {
		this.calidadDetalleEspecietallaCajonBandas = calidadDetalleEspecietallaCajonBandas;
	}

	public CalidadDetalleEspecietallaCajonBanda addCalidadDetalleEspecietallaCajonBanda(CalidadDetalleEspecietallaCajonBanda calidadDetalleEspecietallaCajonBanda) {
		getCalidadDetalleEspecietallaCajonBandas().add(calidadDetalleEspecietallaCajonBanda);
		calidadDetalleEspecietallaCajonBanda.setTurno(this);

		return calidadDetalleEspecietallaCajonBanda;
	}

	public CalidadDetalleEspecietallaCajonBanda removeCalidadDetalleEspecietallaCajonBanda(CalidadDetalleEspecietallaCajonBanda calidadDetalleEspecietallaCajonBanda) {
		getCalidadDetalleEspecietallaCajonBandas().remove(calidadDetalleEspecietallaCajonBanda);
		calidadDetalleEspecietallaCajonBanda.setTurno(null);

		return calidadDetalleEspecietallaCajonBanda;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoCocina
	@OneToMany(mappedBy="turno")
	public List<CalidadDetalleMuestreoCocina> getCalidadDetalleMuestreoCocinas() {
		return this.calidadDetalleMuestreoCocinas;
	}

	public void setCalidadDetalleMuestreoCocinas(List<CalidadDetalleMuestreoCocina> calidadDetalleMuestreoCocinas) {
		this.calidadDetalleMuestreoCocinas = calidadDetalleMuestreoCocinas;
	}

	public CalidadDetalleMuestreoCocina addCalidadDetalleMuestreoCocina(CalidadDetalleMuestreoCocina calidadDetalleMuestreoCocina) {
		getCalidadDetalleMuestreoCocinas().add(calidadDetalleMuestreoCocina);
		calidadDetalleMuestreoCocina.setTurno(this);

		return calidadDetalleMuestreoCocina;
	}

	public CalidadDetalleMuestreoCocina removeCalidadDetalleMuestreoCocina(CalidadDetalleMuestreoCocina calidadDetalleMuestreoCocina) {
		getCalidadDetalleMuestreoCocinas().remove(calidadDetalleMuestreoCocina);
		calidadDetalleMuestreoCocina.setTurno(null);

		return calidadDetalleMuestreoCocina;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCoccion
	@OneToMany(mappedBy="turno")
	public List<CalidadDetalleMuestreoTempCoccion> getCalidadDetalleMuestreoTempCoccions() {
		return this.calidadDetalleMuestreoTempCoccions;
	}

	public void setCalidadDetalleMuestreoTempCoccions(List<CalidadDetalleMuestreoTempCoccion> calidadDetalleMuestreoTempCoccions) {
		this.calidadDetalleMuestreoTempCoccions = calidadDetalleMuestreoTempCoccions;
	}

	public CalidadDetalleMuestreoTempCoccion addCalidadDetalleMuestreoTempCoccion(CalidadDetalleMuestreoTempCoccion calidadDetalleMuestreoTempCoccion) {
		getCalidadDetalleMuestreoTempCoccions().add(calidadDetalleMuestreoTempCoccion);
		calidadDetalleMuestreoTempCoccion.setTurno(this);

		return calidadDetalleMuestreoTempCoccion;
	}

	public CalidadDetalleMuestreoTempCoccion removeCalidadDetalleMuestreoTempCoccion(CalidadDetalleMuestreoTempCoccion calidadDetalleMuestreoTempCoccion) {
		getCalidadDetalleMuestreoTempCoccions().remove(calidadDetalleMuestreoTempCoccion);
		calidadDetalleMuestreoTempCoccion.setTurno(null);

		return calidadDetalleMuestreoTempCoccion;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="turno")
	public List<CalidadDetalleMuestreoTempCochesEviscerado> getCalidadDetalleMuestreoTempCochesEviscerados() {
		return this.calidadDetalleMuestreoTempCochesEviscerados;
	}

	public void setCalidadDetalleMuestreoTempCochesEviscerados(List<CalidadDetalleMuestreoTempCochesEviscerado> calidadDetalleMuestreoTempCochesEviscerados) {
		this.calidadDetalleMuestreoTempCochesEviscerados = calidadDetalleMuestreoTempCochesEviscerados;
	}

	public CalidadDetalleMuestreoTempCochesEviscerado addCalidadDetalleMuestreoTempCochesEviscerado(CalidadDetalleMuestreoTempCochesEviscerado calidadDetalleMuestreoTempCochesEviscerado) {
		getCalidadDetalleMuestreoTempCochesEviscerados().add(calidadDetalleMuestreoTempCochesEviscerado);
		calidadDetalleMuestreoTempCochesEviscerado.setTurno(this);

		return calidadDetalleMuestreoTempCochesEviscerado;
	}

	public CalidadDetalleMuestreoTempCochesEviscerado removeCalidadDetalleMuestreoTempCochesEviscerado(CalidadDetalleMuestreoTempCochesEviscerado calidadDetalleMuestreoTempCochesEviscerado) {
		getCalidadDetalleMuestreoTempCochesEviscerados().remove(calidadDetalleMuestreoTempCochesEviscerado);
		calidadDetalleMuestreoTempCochesEviscerado.setTurno(null);

		return calidadDetalleMuestreoTempCochesEviscerado;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempLimpieza
	@OneToMany(mappedBy="turno")
	public List<CalidadDetalleMuestreoTempLimpieza> getCalidadDetalleMuestreoTempLimpiezas() {
		return this.calidadDetalleMuestreoTempLimpiezas;
	}

	public void setCalidadDetalleMuestreoTempLimpiezas(List<CalidadDetalleMuestreoTempLimpieza> calidadDetalleMuestreoTempLimpiezas) {
		this.calidadDetalleMuestreoTempLimpiezas = calidadDetalleMuestreoTempLimpiezas;
	}

	public CalidadDetalleMuestreoTempLimpieza addCalidadDetalleMuestreoTempLimpieza(CalidadDetalleMuestreoTempLimpieza calidadDetalleMuestreoTempLimpieza) {
		getCalidadDetalleMuestreoTempLimpiezas().add(calidadDetalleMuestreoTempLimpieza);
		calidadDetalleMuestreoTempLimpieza.setTurno(this);

		return calidadDetalleMuestreoTempLimpieza;
	}

	public CalidadDetalleMuestreoTempLimpieza removeCalidadDetalleMuestreoTempLimpieza(CalidadDetalleMuestreoTempLimpieza calidadDetalleMuestreoTempLimpieza) {
		getCalidadDetalleMuestreoTempLimpiezas().remove(calidadDetalleMuestreoTempLimpieza);
		calidadDetalleMuestreoTempLimpieza.setTurno(null);

		return calidadDetalleMuestreoTempLimpieza;
	}


	//bi-directional many-to-one association to CalidadDetalleMuestreoTempPanzaEviscerado
	@OneToMany(mappedBy="turno")
	public List<CalidadDetalleMuestreoTempPanzaEviscerado> getCalidadDetalleMuestreoTempPanzaEviscerados() {
		return this.calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public void setCalidadDetalleMuestreoTempPanzaEviscerados(List<CalidadDetalleMuestreoTempPanzaEviscerado> calidadDetalleMuestreoTempPanzaEviscerados) {
		this.calidadDetalleMuestreoTempPanzaEviscerados = calidadDetalleMuestreoTempPanzaEviscerados;
	}

	public CalidadDetalleMuestreoTempPanzaEviscerado addCalidadDetalleMuestreoTempPanzaEviscerado(CalidadDetalleMuestreoTempPanzaEviscerado calidadDetalleMuestreoTempPanzaEviscerado) {
		getCalidadDetalleMuestreoTempPanzaEviscerados().add(calidadDetalleMuestreoTempPanzaEviscerado);
		calidadDetalleMuestreoTempPanzaEviscerado.setTurno(this);

		return calidadDetalleMuestreoTempPanzaEviscerado;
	}

	public CalidadDetalleMuestreoTempPanzaEviscerado removeCalidadDetalleMuestreoTempPanzaEviscerado(CalidadDetalleMuestreoTempPanzaEviscerado calidadDetalleMuestreoTempPanzaEviscerado) {
		getCalidadDetalleMuestreoTempPanzaEviscerados().remove(calidadDetalleMuestreoTempPanzaEviscerado);
		calidadDetalleMuestreoTempPanzaEviscerado.setTurno(null);

		return calidadDetalleMuestreoTempPanzaEviscerado;
	}


	//bi-directional many-to-one association to CalidadDetalleTemperaturaCajonBanda
	@OneToMany(mappedBy="turno")
	public List<CalidadDetalleTemperaturaCajonBanda> getCalidadDetalleTemperaturaCajonBandas() {
		return this.calidadDetalleTemperaturaCajonBandas;
	}

	public void setCalidadDetalleTemperaturaCajonBandas(List<CalidadDetalleTemperaturaCajonBanda> calidadDetalleTemperaturaCajonBandas) {
		this.calidadDetalleTemperaturaCajonBandas = calidadDetalleTemperaturaCajonBandas;
	}

	public CalidadDetalleTemperaturaCajonBanda addCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().add(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setTurno(this);

		return calidadDetalleTemperaturaCajonBanda;
	}

	public CalidadDetalleTemperaturaCajonBanda removeCalidadDetalleTemperaturaCajonBanda(CalidadDetalleTemperaturaCajonBanda calidadDetalleTemperaturaCajonBanda) {
		getCalidadDetalleTemperaturaCajonBandas().remove(calidadDetalleTemperaturaCajonBanda);
		calidadDetalleTemperaturaCajonBanda.setTurno(null);

		return calidadDetalleTemperaturaCajonBanda;
	}


	//bi-directional many-to-one association to CalidadEspecietallaCajonBanda
	@OneToMany(mappedBy="turno")
	public List<CalidadEspecietallaCajonBanda> getCalidadEspecietallaCajonBandas() {
		return this.calidadEspecietallaCajonBandas;
	}

	public void setCalidadEspecietallaCajonBandas(List<CalidadEspecietallaCajonBanda> calidadEspecietallaCajonBandas) {
		this.calidadEspecietallaCajonBandas = calidadEspecietallaCajonBandas;
	}

	public CalidadEspecietallaCajonBanda addCalidadEspecietallaCajonBanda(CalidadEspecietallaCajonBanda calidadEspecietallaCajonBanda) {
		getCalidadEspecietallaCajonBandas().add(calidadEspecietallaCajonBanda);
		calidadEspecietallaCajonBanda.setTurno(this);

		return calidadEspecietallaCajonBanda;
	}

	public CalidadEspecietallaCajonBanda removeCalidadEspecietallaCajonBanda(CalidadEspecietallaCajonBanda calidadEspecietallaCajonBanda) {
		getCalidadEspecietallaCajonBandas().remove(calidadEspecietallaCajonBanda);
		calidadEspecietallaCajonBanda.setTurno(null);

		return calidadEspecietallaCajonBanda;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaCabecera
	@OneToMany(mappedBy="turno")
	public List<CalidadMuestraAreaCabecera> getCalidadMuestraAreaCabeceras() {
		return this.calidadMuestraAreaCabeceras;
	}

	public void setCalidadMuestraAreaCabeceras(List<CalidadMuestraAreaCabecera> calidadMuestraAreaCabeceras) {
		this.calidadMuestraAreaCabeceras = calidadMuestraAreaCabeceras;
	}

	public CalidadMuestraAreaCabecera addCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().add(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setTurno(this);

		return calidadMuestraAreaCabecera;
	}

	public CalidadMuestraAreaCabecera removeCalidadMuestraAreaCabecera(CalidadMuestraAreaCabecera calidadMuestraAreaCabecera) {
		getCalidadMuestraAreaCabeceras().remove(calidadMuestraAreaCabecera);
		calidadMuestraAreaCabecera.setTurno(null);

		return calidadMuestraAreaCabecera;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaDetalle
	@OneToMany(mappedBy="turno")
	public List<CalidadMuestraAreaDetalle> getCalidadMuestraAreaDetalles() {
		return this.calidadMuestraAreaDetalles;
	}

	public void setCalidadMuestraAreaDetalles(List<CalidadMuestraAreaDetalle> calidadMuestraAreaDetalles) {
		this.calidadMuestraAreaDetalles = calidadMuestraAreaDetalles;
	}

	public CalidadMuestraAreaDetalle addCalidadMuestraAreaDetalle(CalidadMuestraAreaDetalle calidadMuestraAreaDetalle) {
		getCalidadMuestraAreaDetalles().add(calidadMuestraAreaDetalle);
		calidadMuestraAreaDetalle.setTurno(this);

		return calidadMuestraAreaDetalle;
	}

	public CalidadMuestraAreaDetalle removeCalidadMuestraAreaDetalle(CalidadMuestraAreaDetalle calidadMuestraAreaDetalle) {
		getCalidadMuestraAreaDetalles().remove(calidadMuestraAreaDetalle);
		calidadMuestraAreaDetalle.setTurno(null);

		return calidadMuestraAreaDetalle;
	}


	//bi-directional many-to-one association to CalidadMuestraAreaDetalleMuestra
	@OneToMany(mappedBy="turno")
	public List<CalidadMuestraAreaDetalleMuestra> getCalidadMuestraAreaDetalleMuestras() {
		return this.calidadMuestraAreaDetalleMuestras;
	}

	public void setCalidadMuestraAreaDetalleMuestras(List<CalidadMuestraAreaDetalleMuestra> calidadMuestraAreaDetalleMuestras) {
		this.calidadMuestraAreaDetalleMuestras = calidadMuestraAreaDetalleMuestras;
	}

	public CalidadMuestraAreaDetalleMuestra addCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra calidadMuestraAreaDetalleMuestra) {
		getCalidadMuestraAreaDetalleMuestras().add(calidadMuestraAreaDetalleMuestra);
		calidadMuestraAreaDetalleMuestra.setTurno(this);

		return calidadMuestraAreaDetalleMuestra;
	}

	public CalidadMuestraAreaDetalleMuestra removeCalidadMuestraAreaDetalleMuestra(CalidadMuestraAreaDetalleMuestra calidadMuestraAreaDetalleMuestra) {
		getCalidadMuestraAreaDetalleMuestras().remove(calidadMuestraAreaDetalleMuestra);
		calidadMuestraAreaDetalleMuestra.setTurno(null);

		return calidadMuestraAreaDetalleMuestra;
	}


	//bi-directional many-to-one association to CalidadMuestreoCocina
	@OneToMany(mappedBy="turno")
	public List<CalidadMuestreoCocina> getCalidadMuestreoCocinas() {
		return this.calidadMuestreoCocinas;
	}

	public void setCalidadMuestreoCocinas(List<CalidadMuestreoCocina> calidadMuestreoCocinas) {
		this.calidadMuestreoCocinas = calidadMuestreoCocinas;
	}

	public CalidadMuestreoCocina addCalidadMuestreoCocina(CalidadMuestreoCocina calidadMuestreoCocina) {
		getCalidadMuestreoCocinas().add(calidadMuestreoCocina);
		calidadMuestreoCocina.setTurno(this);

		return calidadMuestreoCocina;
	}

	public CalidadMuestreoCocina removeCalidadMuestreoCocina(CalidadMuestreoCocina calidadMuestreoCocina) {
		getCalidadMuestreoCocinas().remove(calidadMuestreoCocina);
		calidadMuestreoCocina.setTurno(null);

		return calidadMuestreoCocina;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempCoccion
	@OneToMany(mappedBy="turno")
	public List<CalidadMuestreoTempCoccion> getCalidadMuestreoTempCoccions() {
		return this.calidadMuestreoTempCoccions;
	}

	public void setCalidadMuestreoTempCoccions(List<CalidadMuestreoTempCoccion> calidadMuestreoTempCoccions) {
		this.calidadMuestreoTempCoccions = calidadMuestreoTempCoccions;
	}

	public CalidadMuestreoTempCoccion addCalidadMuestreoTempCoccion(CalidadMuestreoTempCoccion calidadMuestreoTempCoccion) {
		getCalidadMuestreoTempCoccions().add(calidadMuestreoTempCoccion);
		calidadMuestreoTempCoccion.setTurno(this);

		return calidadMuestreoTempCoccion;
	}

	public CalidadMuestreoTempCoccion removeCalidadMuestreoTempCoccion(CalidadMuestreoTempCoccion calidadMuestreoTempCoccion) {
		getCalidadMuestreoTempCoccions().remove(calidadMuestreoTempCoccion);
		calidadMuestreoTempCoccion.setTurno(null);

		return calidadMuestreoTempCoccion;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempCochesEviscerado
	@OneToMany(mappedBy="turno")
	public List<CalidadMuestreoTempCochesEviscerado> getCalidadMuestreoTempCochesEviscerados() {
		return this.calidadMuestreoTempCochesEviscerados;
	}

	public void setCalidadMuestreoTempCochesEviscerados(List<CalidadMuestreoTempCochesEviscerado> calidadMuestreoTempCochesEviscerados) {
		this.calidadMuestreoTempCochesEviscerados = calidadMuestreoTempCochesEviscerados;
	}

	public CalidadMuestreoTempCochesEviscerado addCalidadMuestreoTempCochesEviscerado(CalidadMuestreoTempCochesEviscerado calidadMuestreoTempCochesEviscerado) {
		getCalidadMuestreoTempCochesEviscerados().add(calidadMuestreoTempCochesEviscerado);
		calidadMuestreoTempCochesEviscerado.setTurno(this);

		return calidadMuestreoTempCochesEviscerado;
	}

	public CalidadMuestreoTempCochesEviscerado removeCalidadMuestreoTempCochesEviscerado(CalidadMuestreoTempCochesEviscerado calidadMuestreoTempCochesEviscerado) {
		getCalidadMuestreoTempCochesEviscerados().remove(calidadMuestreoTempCochesEviscerado);
		calidadMuestreoTempCochesEviscerado.setTurno(null);

		return calidadMuestreoTempCochesEviscerado;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempLimpieza
	@OneToMany(mappedBy="turno")
	public List<CalidadMuestreoTempLimpieza> getCalidadMuestreoTempLimpiezas() {
		return this.calidadMuestreoTempLimpiezas;
	}

	public void setCalidadMuestreoTempLimpiezas(List<CalidadMuestreoTempLimpieza> calidadMuestreoTempLimpiezas) {
		this.calidadMuestreoTempLimpiezas = calidadMuestreoTempLimpiezas;
	}

	public CalidadMuestreoTempLimpieza addCalidadMuestreoTempLimpieza(CalidadMuestreoTempLimpieza calidadMuestreoTempLimpieza) {
		getCalidadMuestreoTempLimpiezas().add(calidadMuestreoTempLimpieza);
		calidadMuestreoTempLimpieza.setTurno(this);

		return calidadMuestreoTempLimpieza;
	}

	public CalidadMuestreoTempLimpieza removeCalidadMuestreoTempLimpieza(CalidadMuestreoTempLimpieza calidadMuestreoTempLimpieza) {
		getCalidadMuestreoTempLimpiezas().remove(calidadMuestreoTempLimpieza);
		calidadMuestreoTempLimpieza.setTurno(null);

		return calidadMuestreoTempLimpieza;
	}


	//bi-directional many-to-one association to CalidadMuestreoTempPanzasEviscerado
	@OneToMany(mappedBy="turno")
	public List<CalidadMuestreoTempPanzasEviscerado> getCalidadMuestreoTempPanzasEviscerados() {
		return this.calidadMuestreoTempPanzasEviscerados;
	}

	public void setCalidadMuestreoTempPanzasEviscerados(List<CalidadMuestreoTempPanzasEviscerado> calidadMuestreoTempPanzasEviscerados) {
		this.calidadMuestreoTempPanzasEviscerados = calidadMuestreoTempPanzasEviscerados;
	}

	public CalidadMuestreoTempPanzasEviscerado addCalidadMuestreoTempPanzasEviscerado(CalidadMuestreoTempPanzasEviscerado calidadMuestreoTempPanzasEviscerado) {
		getCalidadMuestreoTempPanzasEviscerados().add(calidadMuestreoTempPanzasEviscerado);
		calidadMuestreoTempPanzasEviscerado.setTurno(this);

		return calidadMuestreoTempPanzasEviscerado;
	}

	public CalidadMuestreoTempPanzasEviscerado removeCalidadMuestreoTempPanzasEviscerado(CalidadMuestreoTempPanzasEviscerado calidadMuestreoTempPanzasEviscerado) {
		getCalidadMuestreoTempPanzasEviscerados().remove(calidadMuestreoTempPanzasEviscerado);
		calidadMuestreoTempPanzasEviscerado.setTurno(null);

		return calidadMuestreoTempPanzasEviscerado;
	}


	//bi-directional many-to-one association to CamaraCajon
	@OneToMany(mappedBy="turno")
	public List<CamaraCajon> getCamaraCajons() {
		return this.camaraCajons;
	}

	public void setCamaraCajons(List<CamaraCajon> camaraCajons) {
		this.camaraCajons = camaraCajons;
	}

	public CamaraCajon addCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().add(camaraCajon);
		camaraCajon.setTurno(this);

		return camaraCajon;
	}

	public CamaraCajon removeCamaraCajon(CamaraCajon camaraCajon) {
		getCamaraCajons().remove(camaraCajon);
		camaraCajon.setTurno(null);

		return camaraCajon;
	}


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	public List<CoccionDetalleMuestreoTempCoche> getCoccionDetalleMuestreoTempCoches() {
		return this.coccionDetalleMuestreoTempCoches;
	}

	public void setCoccionDetalleMuestreoTempCoches(List<CoccionDetalleMuestreoTempCoche> coccionDetalleMuestreoTempCoches) {
		this.coccionDetalleMuestreoTempCoches = coccionDetalleMuestreoTempCoches;
	}

	public CoccionDetalleMuestreoTempCoche addCoccionDetalleMuestreoTempCoch(CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoch) {
		getCoccionDetalleMuestreoTempCoches().add(coccionDetalleMuestreoTempCoch);
		coccionDetalleMuestreoTempCoch.setTurno(this);

		return coccionDetalleMuestreoTempCoch;
	}

	public CoccionDetalleMuestreoTempCoche removeCoccionDetalleMuestreoTempCoch(CoccionDetalleMuestreoTempCoche coccionDetalleMuestreoTempCoch) {
		getCoccionDetalleMuestreoTempCoches().remove(coccionDetalleMuestreoTempCoch);
		coccionDetalleMuestreoTempCoch.setTurno(null);

		return coccionDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheAdic
	@OneToMany(mappedBy="turno")
	public List<CoccionDetalleMuestreoTempCocheAdic> getCoccionDetalleMuestreoTempCocheAdics() {
		return this.coccionDetalleMuestreoTempCocheAdics;
	}

	public void setCoccionDetalleMuestreoTempCocheAdics(List<CoccionDetalleMuestreoTempCocheAdic> coccionDetalleMuestreoTempCocheAdics) {
		this.coccionDetalleMuestreoTempCocheAdics = coccionDetalleMuestreoTempCocheAdics;
	}

	public CoccionDetalleMuestreoTempCocheAdic addCoccionDetalleMuestreoTempCocheAdic(CoccionDetalleMuestreoTempCocheAdic coccionDetalleMuestreoTempCocheAdic) {
		getCoccionDetalleMuestreoTempCocheAdics().add(coccionDetalleMuestreoTempCocheAdic);
		coccionDetalleMuestreoTempCocheAdic.setTurno(this);

		return coccionDetalleMuestreoTempCocheAdic;
	}

	public CoccionDetalleMuestreoTempCocheAdic removeCoccionDetalleMuestreoTempCocheAdic(CoccionDetalleMuestreoTempCocheAdic coccionDetalleMuestreoTempCocheAdic) {
		getCoccionDetalleMuestreoTempCocheAdics().remove(coccionDetalleMuestreoTempCocheAdic);
		coccionDetalleMuestreoTempCocheAdic.setTurno(null);

		return coccionDetalleMuestreoTempCocheAdic;
	}


	//bi-directional many-to-one association to CoccionDetalleMuestreoTempCocheIngreso
	@OneToMany(mappedBy="turno")
	public List<CoccionDetalleMuestreoTempCocheIngreso> getCoccionDetalleMuestreoTempCocheIngresos() {
		return this.coccionDetalleMuestreoTempCocheIngresos;
	}

	public void setCoccionDetalleMuestreoTempCocheIngresos(List<CoccionDetalleMuestreoTempCocheIngreso> coccionDetalleMuestreoTempCocheIngresos) {
		this.coccionDetalleMuestreoTempCocheIngresos = coccionDetalleMuestreoTempCocheIngresos;
	}

	public CoccionDetalleMuestreoTempCocheIngreso addCoccionDetalleMuestreoTempCocheIngreso(CoccionDetalleMuestreoTempCocheIngreso coccionDetalleMuestreoTempCocheIngreso) {
		getCoccionDetalleMuestreoTempCocheIngresos().add(coccionDetalleMuestreoTempCocheIngreso);
		coccionDetalleMuestreoTempCocheIngreso.setTurno(this);

		return coccionDetalleMuestreoTempCocheIngreso;
	}

	public CoccionDetalleMuestreoTempCocheIngreso removeCoccionDetalleMuestreoTempCocheIngreso(CoccionDetalleMuestreoTempCocheIngreso coccionDetalleMuestreoTempCocheIngreso) {
		getCoccionDetalleMuestreoTempCocheIngresos().remove(coccionDetalleMuestreoTempCocheIngreso);
		coccionDetalleMuestreoTempCocheIngreso.setTurno(null);

		return coccionDetalleMuestreoTempCocheIngreso;
	}


	//bi-directional many-to-one association to CoccionDetalleProcesoCoche
	@OneToMany(mappedBy="turno")
	public List<CoccionDetalleProcesoCoche> getCoccionDetalleProcesoCoches() {
		return this.coccionDetalleProcesoCoches;
	}

	public void setCoccionDetalleProcesoCoches(List<CoccionDetalleProcesoCoche> coccionDetalleProcesoCoches) {
		this.coccionDetalleProcesoCoches = coccionDetalleProcesoCoches;
	}

	public CoccionDetalleProcesoCoche addCoccionDetalleProcesoCoch(CoccionDetalleProcesoCoche coccionDetalleProcesoCoch) {
		getCoccionDetalleProcesoCoches().add(coccionDetalleProcesoCoch);
		coccionDetalleProcesoCoch.setTurno(this);

		return coccionDetalleProcesoCoch;
	}

	public CoccionDetalleProcesoCoche removeCoccionDetalleProcesoCoch(CoccionDetalleProcesoCoche coccionDetalleProcesoCoch) {
		getCoccionDetalleProcesoCoches().remove(coccionDetalleProcesoCoch);
		coccionDetalleProcesoCoch.setTurno(null);

		return coccionDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to CoccionDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="turno")
	public List<CoccionDetalleProcesoCocheTemperatura> getCoccionDetalleProcesoCocheTemperaturas() {
		return this.coccionDetalleProcesoCocheTemperaturas;
	}

	public void setCoccionDetalleProcesoCocheTemperaturas(List<CoccionDetalleProcesoCocheTemperatura> coccionDetalleProcesoCocheTemperaturas) {
		this.coccionDetalleProcesoCocheTemperaturas = coccionDetalleProcesoCocheTemperaturas;
	}

	public CoccionDetalleProcesoCocheTemperatura addCoccionDetalleProcesoCocheTemperatura(CoccionDetalleProcesoCocheTemperatura coccionDetalleProcesoCocheTemperatura) {
		getCoccionDetalleProcesoCocheTemperaturas().add(coccionDetalleProcesoCocheTemperatura);
		coccionDetalleProcesoCocheTemperatura.setTurno(this);

		return coccionDetalleProcesoCocheTemperatura;
	}

	public CoccionDetalleProcesoCocheTemperatura removeCoccionDetalleProcesoCocheTemperatura(CoccionDetalleProcesoCocheTemperatura coccionDetalleProcesoCocheTemperatura) {
		getCoccionDetalleProcesoCocheTemperaturas().remove(coccionDetalleProcesoCocheTemperatura);
		coccionDetalleProcesoCocheTemperatura.setTurno(null);

		return coccionDetalleProcesoCocheTemperatura;
	}


	//bi-directional many-to-one association to CoccionMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	public List<CoccionMuestreoTempCoche> getCoccionMuestreoTempCoches() {
		return this.coccionMuestreoTempCoches;
	}

	public void setCoccionMuestreoTempCoches(List<CoccionMuestreoTempCoche> coccionMuestreoTempCoches) {
		this.coccionMuestreoTempCoches = coccionMuestreoTempCoches;
	}

	public CoccionMuestreoTempCoche addCoccionMuestreoTempCoch(CoccionMuestreoTempCoche coccionMuestreoTempCoch) {
		getCoccionMuestreoTempCoches().add(coccionMuestreoTempCoch);
		coccionMuestreoTempCoch.setTurno(this);

		return coccionMuestreoTempCoch;
	}

	public CoccionMuestreoTempCoche removeCoccionMuestreoTempCoch(CoccionMuestreoTempCoche coccionMuestreoTempCoch) {
		getCoccionMuestreoTempCoches().remove(coccionMuestreoTempCoch);
		coccionMuestreoTempCoch.setTurno(null);

		return coccionMuestreoTempCoch;
	}


	//bi-directional many-to-one association to CoccionMuestreoTempCocheIngreso
	@OneToMany(mappedBy="turno")
	public List<CoccionMuestreoTempCocheIngreso> getCoccionMuestreoTempCocheIngresos() {
		return this.coccionMuestreoTempCocheIngresos;
	}

	public void setCoccionMuestreoTempCocheIngresos(List<CoccionMuestreoTempCocheIngreso> coccionMuestreoTempCocheIngresos) {
		this.coccionMuestreoTempCocheIngresos = coccionMuestreoTempCocheIngresos;
	}

	public CoccionMuestreoTempCocheIngreso addCoccionMuestreoTempCocheIngreso(CoccionMuestreoTempCocheIngreso coccionMuestreoTempCocheIngreso) {
		getCoccionMuestreoTempCocheIngresos().add(coccionMuestreoTempCocheIngreso);
		coccionMuestreoTempCocheIngreso.setTurno(this);

		return coccionMuestreoTempCocheIngreso;
	}

	public CoccionMuestreoTempCocheIngreso removeCoccionMuestreoTempCocheIngreso(CoccionMuestreoTempCocheIngreso coccionMuestreoTempCocheIngreso) {
		getCoccionMuestreoTempCocheIngresos().remove(coccionMuestreoTempCocheIngreso);
		coccionMuestreoTempCocheIngreso.setTurno(null);

		return coccionMuestreoTempCocheIngreso;
	}


	//bi-directional many-to-one association to ContraloriaCoccionDetalleMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	public List<ContraloriaCoccionDetalleMuestreoTempCoche> getContraloriaCoccionDetalleMuestreoTempCoches() {
		return this.contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public void setContraloriaCoccionDetalleMuestreoTempCoches(List<ContraloriaCoccionDetalleMuestreoTempCoche> contraloriaCoccionDetalleMuestreoTempCoches) {
		this.contraloriaCoccionDetalleMuestreoTempCoches = contraloriaCoccionDetalleMuestreoTempCoches;
	}

	public ContraloriaCoccionDetalleMuestreoTempCoche addContraloriaCoccionDetalleMuestreoTempCoch(ContraloriaCoccionDetalleMuestreoTempCoche contraloriaCoccionDetalleMuestreoTempCoch) {
		getContraloriaCoccionDetalleMuestreoTempCoches().add(contraloriaCoccionDetalleMuestreoTempCoch);
		contraloriaCoccionDetalleMuestreoTempCoch.setTurno(this);

		return contraloriaCoccionDetalleMuestreoTempCoch;
	}

	public ContraloriaCoccionDetalleMuestreoTempCoche removeContraloriaCoccionDetalleMuestreoTempCoch(ContraloriaCoccionDetalleMuestreoTempCoche contraloriaCoccionDetalleMuestreoTempCoch) {
		getContraloriaCoccionDetalleMuestreoTempCoches().remove(contraloriaCoccionDetalleMuestreoTempCoch);
		contraloriaCoccionDetalleMuestreoTempCoch.setTurno(null);

		return contraloriaCoccionDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to ContraloriaDetalleRackeoProcesoTemperatura
	@OneToMany(mappedBy="turno")
	public List<ContraloriaDetalleRackeoProcesoTemperatura> getContraloriaDetalleRackeoProcesoTemperaturas() {
		return this.contraloriaDetalleRackeoProcesoTemperaturas;
	}

	public void setContraloriaDetalleRackeoProcesoTemperaturas(List<ContraloriaDetalleRackeoProcesoTemperatura> contraloriaDetalleRackeoProcesoTemperaturas) {
		this.contraloriaDetalleRackeoProcesoTemperaturas = contraloriaDetalleRackeoProcesoTemperaturas;
	}

	public ContraloriaDetalleRackeoProcesoTemperatura addContraloriaDetalleRackeoProcesoTemperatura(ContraloriaDetalleRackeoProcesoTemperatura contraloriaDetalleRackeoProcesoTemperatura) {
		getContraloriaDetalleRackeoProcesoTemperaturas().add(contraloriaDetalleRackeoProcesoTemperatura);
		contraloriaDetalleRackeoProcesoTemperatura.setTurno(this);

		return contraloriaDetalleRackeoProcesoTemperatura;
	}

	public ContraloriaDetalleRackeoProcesoTemperatura removeContraloriaDetalleRackeoProcesoTemperatura(ContraloriaDetalleRackeoProcesoTemperatura contraloriaDetalleRackeoProcesoTemperatura) {
		getContraloriaDetalleRackeoProcesoTemperaturas().remove(contraloriaDetalleRackeoProcesoTemperatura);
		contraloriaDetalleRackeoProcesoTemperatura.setTurno(null);

		return contraloriaDetalleRackeoProcesoTemperatura;
	}


	//bi-directional many-to-one association to ContraloriaEvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	public List<ContraloriaEvisceradoDetalleMuestreoTempCoche> getContraloriaEvisceradoDetalleMuestreoTempCoches() {
		return this.contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public void setContraloriaEvisceradoDetalleMuestreoTempCoches(List<ContraloriaEvisceradoDetalleMuestreoTempCoche> contraloriaEvisceradoDetalleMuestreoTempCoches) {
		this.contraloriaEvisceradoDetalleMuestreoTempCoches = contraloriaEvisceradoDetalleMuestreoTempCoches;
	}

	public ContraloriaEvisceradoDetalleMuestreoTempCoche addContraloriaEvisceradoDetalleMuestreoTempCoch(ContraloriaEvisceradoDetalleMuestreoTempCoche contraloriaEvisceradoDetalleMuestreoTempCoch) {
		getContraloriaEvisceradoDetalleMuestreoTempCoches().add(contraloriaEvisceradoDetalleMuestreoTempCoch);
		contraloriaEvisceradoDetalleMuestreoTempCoch.setTurno(this);

		return contraloriaEvisceradoDetalleMuestreoTempCoch;
	}

	public ContraloriaEvisceradoDetalleMuestreoTempCoche removeContraloriaEvisceradoDetalleMuestreoTempCoch(ContraloriaEvisceradoDetalleMuestreoTempCoche contraloriaEvisceradoDetalleMuestreoTempCoch) {
		getContraloriaEvisceradoDetalleMuestreoTempCoches().remove(contraloriaEvisceradoDetalleMuestreoTempCoch);
		contraloriaEvisceradoDetalleMuestreoTempCoch.setTurno(null);

		return contraloriaEvisceradoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to ControlBatchProceso
	@OneToMany(mappedBy="turno")
	public List<ControlBatchProceso> getControlBatchProcesos() {
		return this.controlBatchProcesos;
	}

	public void setControlBatchProcesos(List<ControlBatchProceso> controlBatchProcesos) {
		this.controlBatchProcesos = controlBatchProcesos;
	}

	public ControlBatchProceso addControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		getControlBatchProcesos().add(controlBatchProceso);
		controlBatchProceso.setTurno(this);

		return controlBatchProceso;
	}

	public ControlBatchProceso removeControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		getControlBatchProcesos().remove(controlBatchProceso);
		controlBatchProceso.setTurno(null);

		return controlBatchProceso;
	}


	//bi-directional many-to-one association to DescongeladoCajonModificacion
	@OneToMany(mappedBy="turno")
	public List<DescongeladoCajonModificacion> getDescongeladoCajonModificacions() {
		return this.descongeladoCajonModificacions;
	}

	public void setDescongeladoCajonModificacions(List<DescongeladoCajonModificacion> descongeladoCajonModificacions) {
		this.descongeladoCajonModificacions = descongeladoCajonModificacions;
	}

	public DescongeladoCajonModificacion addDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().add(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setTurno(this);

		return descongeladoCajonModificacion;
	}

	public DescongeladoCajonModificacion removeDescongeladoCajonModificacion(DescongeladoCajonModificacion descongeladoCajonModificacion) {
		getDescongeladoCajonModificacions().remove(descongeladoCajonModificacion);
		descongeladoCajonModificacion.setTurno(null);

		return descongeladoCajonModificacion;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@OneToMany(mappedBy="turno")
	public List<DescongeladoDetalleProceso> getDescongeladoDetalleProcesos() {
		return this.descongeladoDetalleProcesos;
	}

	public void setDescongeladoDetalleProcesos(List<DescongeladoDetalleProceso> descongeladoDetalleProcesos) {
		this.descongeladoDetalleProcesos = descongeladoDetalleProcesos;
	}

	public DescongeladoDetalleProceso addDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().add(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setTurno(this);

		return descongeladoDetalleProceso;
	}

	public DescongeladoDetalleProceso removeDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		getDescongeladoDetalleProcesos().remove(descongeladoDetalleProceso);
		descongeladoDetalleProceso.setTurno(null);

		return descongeladoDetalleProceso;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProcesoContraloria
	@OneToMany(mappedBy="turno")
	public List<DescongeladoDetalleProcesoContraloria> getDescongeladoDetalleProcesoContralorias() {
		return this.descongeladoDetalleProcesoContralorias;
	}

	public void setDescongeladoDetalleProcesoContralorias(List<DescongeladoDetalleProcesoContraloria> descongeladoDetalleProcesoContralorias) {
		this.descongeladoDetalleProcesoContralorias = descongeladoDetalleProcesoContralorias;
	}

	public DescongeladoDetalleProcesoContraloria addDescongeladoDetalleProcesoContraloria(DescongeladoDetalleProcesoContraloria descongeladoDetalleProcesoContraloria) {
		getDescongeladoDetalleProcesoContralorias().add(descongeladoDetalleProcesoContraloria);
		descongeladoDetalleProcesoContraloria.setTurno(this);

		return descongeladoDetalleProcesoContraloria;
	}

	public DescongeladoDetalleProcesoContraloria removeDescongeladoDetalleProcesoContraloria(DescongeladoDetalleProcesoContraloria descongeladoDetalleProcesoContraloria) {
		getDescongeladoDetalleProcesoContralorias().remove(descongeladoDetalleProcesoContraloria);
		descongeladoDetalleProcesoContraloria.setTurno(null);

		return descongeladoDetalleProcesoContraloria;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProcesoTempIng
	@OneToMany(mappedBy="turno")
	public List<DescongeladoDetalleProcesoTempIng> getDescongeladoDetalleProcesoTempIngs() {
		return this.descongeladoDetalleProcesoTempIngs;
	}

	public void setDescongeladoDetalleProcesoTempIngs(List<DescongeladoDetalleProcesoTempIng> descongeladoDetalleProcesoTempIngs) {
		this.descongeladoDetalleProcesoTempIngs = descongeladoDetalleProcesoTempIngs;
	}

	public DescongeladoDetalleProcesoTempIng addDescongeladoDetalleProcesoTempIng(DescongeladoDetalleProcesoTempIng descongeladoDetalleProcesoTempIng) {
		getDescongeladoDetalleProcesoTempIngs().add(descongeladoDetalleProcesoTempIng);
		descongeladoDetalleProcesoTempIng.setTurno(this);

		return descongeladoDetalleProcesoTempIng;
	}

	public DescongeladoDetalleProcesoTempIng removeDescongeladoDetalleProcesoTempIng(DescongeladoDetalleProcesoTempIng descongeladoDetalleProcesoTempIng) {
		getDescongeladoDetalleProcesoTempIngs().remove(descongeladoDetalleProcesoTempIng);
		descongeladoDetalleProcesoTempIng.setTurno(null);

		return descongeladoDetalleProcesoTempIng;
	}


	//bi-directional many-to-one association to DescongeladoDetalleProcesoTemperatura
	@OneToMany(mappedBy="turno")
	public List<DescongeladoDetalleProcesoTemperatura> getDescongeladoDetalleProcesoTemperaturas() {
		return this.descongeladoDetalleProcesoTemperaturas;
	}

	public void setDescongeladoDetalleProcesoTemperaturas(List<DescongeladoDetalleProcesoTemperatura> descongeladoDetalleProcesoTemperaturas) {
		this.descongeladoDetalleProcesoTemperaturas = descongeladoDetalleProcesoTemperaturas;
	}

	public DescongeladoDetalleProcesoTemperatura addDescongeladoDetalleProcesoTemperatura(DescongeladoDetalleProcesoTemperatura descongeladoDetalleProcesoTemperatura) {
		getDescongeladoDetalleProcesoTemperaturas().add(descongeladoDetalleProcesoTemperatura);
		descongeladoDetalleProcesoTemperatura.setTurno(this);

		return descongeladoDetalleProcesoTemperatura;
	}

	public DescongeladoDetalleProcesoTemperatura removeDescongeladoDetalleProcesoTemperatura(DescongeladoDetalleProcesoTemperatura descongeladoDetalleProcesoTemperatura) {
		getDescongeladoDetalleProcesoTemperaturas().remove(descongeladoDetalleProcesoTemperatura);
		descongeladoDetalleProcesoTemperatura.setTurno(null);

		return descongeladoDetalleProcesoTemperatura;
	}


	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="turno1")
	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas1() {
		return this.desperdicioCajonHarinas1;
	}

	public void setDesperdicioCajonHarinas1(List<DesperdicioCajonHarina> desperdicioCajonHarinas1) {
		this.desperdicioCajonHarinas1 = desperdicioCajonHarinas1;
	}

	public DesperdicioCajonHarina addDesperdicioCajonHarinas1(DesperdicioCajonHarina desperdicioCajonHarinas1) {
		getDesperdicioCajonHarinas1().add(desperdicioCajonHarinas1);
		desperdicioCajonHarinas1.setTurno1(this);

		return desperdicioCajonHarinas1;
	}

	public DesperdicioCajonHarina removeDesperdicioCajonHarinas1(DesperdicioCajonHarina desperdicioCajonHarinas1) {
		getDesperdicioCajonHarinas1().remove(desperdicioCajonHarinas1);
		desperdicioCajonHarinas1.setTurno1(null);

		return desperdicioCajonHarinas1;
	}


	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="turno2")
	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas2() {
		return this.desperdicioCajonHarinas2;
	}

	public void setDesperdicioCajonHarinas2(List<DesperdicioCajonHarina> desperdicioCajonHarinas2) {
		this.desperdicioCajonHarinas2 = desperdicioCajonHarinas2;
	}

	public DesperdicioCajonHarina addDesperdicioCajonHarinas2(DesperdicioCajonHarina desperdicioCajonHarinas2) {
		getDesperdicioCajonHarinas2().add(desperdicioCajonHarinas2);
		desperdicioCajonHarinas2.setTurno2(this);

		return desperdicioCajonHarinas2;
	}

	public DesperdicioCajonHarina removeDesperdicioCajonHarinas2(DesperdicioCajonHarina desperdicioCajonHarinas2) {
		getDesperdicioCajonHarinas2().remove(desperdicioCajonHarinas2);
		desperdicioCajonHarinas2.setTurno2(null);

		return desperdicioCajonHarinas2;
	}


	//bi-directional many-to-one association to DesperdicioCajonHarina
	@OneToMany(mappedBy="turno3")
	public List<DesperdicioCajonHarina> getDesperdicioCajonHarinas3() {
		return this.desperdicioCajonHarinas3;
	}

	public void setDesperdicioCajonHarinas3(List<DesperdicioCajonHarina> desperdicioCajonHarinas3) {
		this.desperdicioCajonHarinas3 = desperdicioCajonHarinas3;
	}

	public DesperdicioCajonHarina addDesperdicioCajonHarinas3(DesperdicioCajonHarina desperdicioCajonHarinas3) {
		getDesperdicioCajonHarinas3().add(desperdicioCajonHarinas3);
		desperdicioCajonHarinas3.setTurno3(this);

		return desperdicioCajonHarinas3;
	}

	public DesperdicioCajonHarina removeDesperdicioCajonHarinas3(DesperdicioCajonHarina desperdicioCajonHarinas3) {
		getDesperdicioCajonHarinas3().remove(desperdicioCajonHarinas3);
		desperdicioCajonHarinas3.setTurno3(null);

		return desperdicioCajonHarinas3;
	}


	//bi-directional many-to-one association to DesperdicioDetalle
	@OneToMany(mappedBy="turno")
	public List<DesperdicioDetalle> getDesperdicioDetalles() {
		return this.desperdicioDetalles;
	}

	public void setDesperdicioDetalles(List<DesperdicioDetalle> desperdicioDetalles) {
		this.desperdicioDetalles = desperdicioDetalles;
	}

	public DesperdicioDetalle addDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().add(desperdicioDetalle);
		desperdicioDetalle.setTurno(this);

		return desperdicioDetalle;
	}

	public DesperdicioDetalle removeDesperdicioDetalle(DesperdicioDetalle desperdicioDetalle) {
		getDesperdicioDetalles().remove(desperdicioDetalle);
		desperdicioDetalle.setTurno(null);

		return desperdicioDetalle;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoFillCabecera
	@OneToMany(mappedBy="turno")
	public List<EnvasadoControlPesoFillCabecera> getEnvasadoControlPesoFillCabeceras() {
		return this.envasadoControlPesoFillCabeceras;
	}

	public void setEnvasadoControlPesoFillCabeceras(List<EnvasadoControlPesoFillCabecera> envasadoControlPesoFillCabeceras) {
		this.envasadoControlPesoFillCabeceras = envasadoControlPesoFillCabeceras;
	}

	public EnvasadoControlPesoFillCabecera addEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().add(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setTurno(this);

		return envasadoControlPesoFillCabecera;
	}

	public EnvasadoControlPesoFillCabecera removeEnvasadoControlPesoFillCabecera(EnvasadoControlPesoFillCabecera envasadoControlPesoFillCabecera) {
		getEnvasadoControlPesoFillCabeceras().remove(envasadoControlPesoFillCabecera);
		envasadoControlPesoFillCabecera.setTurno(null);

		return envasadoControlPesoFillCabecera;
	}


	//bi-directional many-to-one association to EnvasadoControlPesoNetoCabecera
	@OneToMany(mappedBy="turno")
	public List<EnvasadoControlPesoNetoCabecera> getEnvasadoControlPesoNetoCabeceras() {
		return this.envasadoControlPesoNetoCabeceras;
	}

	public void setEnvasadoControlPesoNetoCabeceras(List<EnvasadoControlPesoNetoCabecera> envasadoControlPesoNetoCabeceras) {
		this.envasadoControlPesoNetoCabeceras = envasadoControlPesoNetoCabeceras;
	}

	public EnvasadoControlPesoNetoCabecera addEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabeceras().add(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setTurno(this);

		return envasadoControlPesoNetoCabecera;
	}

	public EnvasadoControlPesoNetoCabecera removeEnvasadoControlPesoNetoCabecera(EnvasadoControlPesoNetoCabecera envasadoControlPesoNetoCabecera) {
		getEnvasadoControlPesoNetoCabeceras().remove(envasadoControlPesoNetoCabecera);
		envasadoControlPesoNetoCabecera.setTurno(null);

		return envasadoControlPesoNetoCabecera;
	}


	//bi-directional many-to-one association to EnvasadoDetalleProcesoCambio
	@OneToMany(mappedBy="turno")
	public List<EnvasadoDetalleProcesoCambio> getEnvasadoDetalleProcesoCambios() {
		return this.envasadoDetalleProcesoCambios;
	}

	public void setEnvasadoDetalleProcesoCambios(List<EnvasadoDetalleProcesoCambio> envasadoDetalleProcesoCambios) {
		this.envasadoDetalleProcesoCambios = envasadoDetalleProcesoCambios;
	}

	public EnvasadoDetalleProcesoCambio addEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().add(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setTurno(this);

		return envasadoDetalleProcesoCambio;
	}

	public EnvasadoDetalleProcesoCambio removeEnvasadoDetalleProcesoCambio(EnvasadoDetalleProcesoCambio envasadoDetalleProcesoCambio) {
		getEnvasadoDetalleProcesoCambios().remove(envasadoDetalleProcesoCambio);
		envasadoDetalleProcesoCambio.setTurno(null);

		return envasadoDetalleProcesoCambio;
	}


	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="turno")
	public List<EnvasadoProceso> getEnvasadoProcesos() {
		return this.envasadoProcesos;
	}

	public void setEnvasadoProcesos(List<EnvasadoProceso> envasadoProcesos) {
		this.envasadoProcesos = envasadoProcesos;
	}

	public EnvasadoProceso addEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().add(envasadoProceso);
		envasadoProceso.setTurno(this);

		return envasadoProceso;
	}

	public EnvasadoProceso removeEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().remove(envasadoProceso);
		envasadoProceso.setTurno(null);

		return envasadoProceso;
	}


	//bi-directional many-to-one association to EspecialidadesProcesoEnlatado
	@OneToMany(mappedBy="turno")
	public List<EspecialidadesProcesoEnlatado> getEspecialidadesProcesoEnlatados() {
		return this.especialidadesProcesoEnlatados;
	}

	public void setEspecialidadesProcesoEnlatados(List<EspecialidadesProcesoEnlatado> especialidadesProcesoEnlatados) {
		this.especialidadesProcesoEnlatados = especialidadesProcesoEnlatados;
	}

	public EspecialidadesProcesoEnlatado addEspecialidadesProcesoEnlatado(EspecialidadesProcesoEnlatado especialidadesProcesoEnlatado) {
		getEspecialidadesProcesoEnlatados().add(especialidadesProcesoEnlatado);
		especialidadesProcesoEnlatado.setTurno(this);

		return especialidadesProcesoEnlatado;
	}

	public EspecialidadesProcesoEnlatado removeEspecialidadesProcesoEnlatado(EspecialidadesProcesoEnlatado especialidadesProcesoEnlatado) {
		getEspecialidadesProcesoEnlatados().remove(especialidadesProcesoEnlatado);
		especialidadesProcesoEnlatado.setTurno(null);

		return especialidadesProcesoEnlatado;
	}


	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="turno")
	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public EvisceradoCocheModificacion addEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().add(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setTurno(this);

		return evisceradoCocheModificacion;
	}

	public EvisceradoCocheModificacion removeEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().remove(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setTurno(null);

		return evisceradoCocheModificacion;
	}


	//bi-directional many-to-one association to EvisceradoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	public List<EvisceradoDetalleMuestreoTempCoche> getEvisceradoDetalleMuestreoTempCoches() {
		return this.evisceradoDetalleMuestreoTempCoches;
	}

	public void setEvisceradoDetalleMuestreoTempCoches(List<EvisceradoDetalleMuestreoTempCoche> evisceradoDetalleMuestreoTempCoches) {
		this.evisceradoDetalleMuestreoTempCoches = evisceradoDetalleMuestreoTempCoches;
	}

	public EvisceradoDetalleMuestreoTempCoche addEvisceradoDetalleMuestreoTempCoch(EvisceradoDetalleMuestreoTempCoche evisceradoDetalleMuestreoTempCoch) {
		getEvisceradoDetalleMuestreoTempCoches().add(evisceradoDetalleMuestreoTempCoch);
		evisceradoDetalleMuestreoTempCoch.setTurno(this);

		return evisceradoDetalleMuestreoTempCoch;
	}

	public EvisceradoDetalleMuestreoTempCoche removeEvisceradoDetalleMuestreoTempCoch(EvisceradoDetalleMuestreoTempCoche evisceradoDetalleMuestreoTempCoch) {
		getEvisceradoDetalleMuestreoTempCoches().remove(evisceradoDetalleMuestreoTempCoch);
		evisceradoDetalleMuestreoTempCoch.setTurno(null);

		return evisceradoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="turno")
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public EvisceradoDetalleProcesoCoche addEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().add(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setTurno(this);

		return evisceradoDetalleProcesoCoch;
	}

	public EvisceradoDetalleProcesoCoche removeEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().remove(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setTurno(null);

		return evisceradoDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to EvisceradoMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	public List<EvisceradoMuestreoTempCoche> getEvisceradoMuestreoTempCoches() {
		return this.evisceradoMuestreoTempCoches;
	}

	public void setEvisceradoMuestreoTempCoches(List<EvisceradoMuestreoTempCoche> evisceradoMuestreoTempCoches) {
		this.evisceradoMuestreoTempCoches = evisceradoMuestreoTempCoches;
	}

	public EvisceradoMuestreoTempCoche addEvisceradoMuestreoTempCoch(EvisceradoMuestreoTempCoche evisceradoMuestreoTempCoch) {
		getEvisceradoMuestreoTempCoches().add(evisceradoMuestreoTempCoch);
		evisceradoMuestreoTempCoch.setTurno(this);

		return evisceradoMuestreoTempCoch;
	}

	public EvisceradoMuestreoTempCoche removeEvisceradoMuestreoTempCoch(EvisceradoMuestreoTempCoche evisceradoMuestreoTempCoch) {
		getEvisceradoMuestreoTempCoches().remove(evisceradoMuestreoTempCoch);
		evisceradoMuestreoTempCoch.setTurno(null);

		return evisceradoMuestreoTempCoch;
	}


	//bi-directional many-to-one association to GestionTurno
	@OneToMany(mappedBy="turno")
	public List<GestionTurno> getGestionTurnos() {
		return this.gestionTurnos;
	}

	public void setGestionTurnos(List<GestionTurno> gestionTurnos) {
		this.gestionTurnos = gestionTurnos;
	}

	public GestionTurno addGestionTurno(GestionTurno gestionTurno) {
		getGestionTurnos().add(gestionTurno);
		gestionTurno.setTurno(this);

		return gestionTurno;
	}

	public GestionTurno removeGestionTurno(GestionTurno gestionTurno) {
		getGestionTurnos().remove(gestionTurno);
		gestionTurno.setTurno(null);

		return gestionTurno;
	}


	//bi-directional many-to-one association to HarinaRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="turno")
	public List<HarinaRecepcionDetallePescaComprobante> getHarinaRecepcionDetallePescaComprobantes() {
		return this.harinaRecepcionDetallePescaComprobantes;
	}

	public void setHarinaRecepcionDetallePescaComprobantes(List<HarinaRecepcionDetallePescaComprobante> harinaRecepcionDetallePescaComprobantes) {
		this.harinaRecepcionDetallePescaComprobantes = harinaRecepcionDetallePescaComprobantes;
	}

	public HarinaRecepcionDetallePescaComprobante addHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		getHarinaRecepcionDetallePescaComprobantes().add(harinaRecepcionDetallePescaComprobante);
		harinaRecepcionDetallePescaComprobante.setTurno(this);

		return harinaRecepcionDetallePescaComprobante;
	}

	public HarinaRecepcionDetallePescaComprobante removeHarinaRecepcionDetallePescaComprobante(HarinaRecepcionDetallePescaComprobante harinaRecepcionDetallePescaComprobante) {
		getHarinaRecepcionDetallePescaComprobantes().remove(harinaRecepcionDetallePescaComprobante);
		harinaRecepcionDetallePescaComprobante.setTurno(null);

		return harinaRecepcionDetallePescaComprobante;
	}


	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@OneToMany(mappedBy="turno")
	public List<HarinaRecepcionPescaComprobante> getHarinaRecepcionPescaComprobantes() {
		return this.harinaRecepcionPescaComprobantes;
	}

	public void setHarinaRecepcionPescaComprobantes(List<HarinaRecepcionPescaComprobante> harinaRecepcionPescaComprobantes) {
		this.harinaRecepcionPescaComprobantes = harinaRecepcionPescaComprobantes;
	}

	public HarinaRecepcionPescaComprobante addHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		getHarinaRecepcionPescaComprobantes().add(harinaRecepcionPescaComprobante);
		harinaRecepcionPescaComprobante.setTurno(this);

		return harinaRecepcionPescaComprobante;
	}

	public HarinaRecepcionPescaComprobante removeHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		getHarinaRecepcionPescaComprobantes().remove(harinaRecepcionPescaComprobante);
		harinaRecepcionPescaComprobante.setTurno(null);

		return harinaRecepcionPescaComprobante;
	}


	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="turno")
	public List<LimpiezaCalidadDetalleProcesoBandeja> getLimpiezaCalidadDetalleProcesoBandejas() {
		return this.limpiezaCalidadDetalleProcesoBandejas;
	}

	public void setLimpiezaCalidadDetalleProcesoBandejas(List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas) {
		this.limpiezaCalidadDetalleProcesoBandejas = limpiezaCalidadDetalleProcesoBandejas;
	}

	public LimpiezaCalidadDetalleProcesoBandeja addLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().add(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setTurno(this);

		return limpiezaCalidadDetalleProcesoBandeja;
	}

	public LimpiezaCalidadDetalleProcesoBandeja removeLimpiezaCalidadDetalleProcesoBandeja(LimpiezaCalidadDetalleProcesoBandeja limpiezaCalidadDetalleProcesoBandeja) {
		getLimpiezaCalidadDetalleProcesoBandejas().remove(limpiezaCalidadDetalleProcesoBandeja);
		limpiezaCalidadDetalleProcesoBandeja.setTurno(null);

		return limpiezaCalidadDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="turno")
	public List<LimpiezaCocheModificacion> getLimpiezaCocheModificacions() {
		return this.limpiezaCocheModificacions;
	}

	public void setLimpiezaCocheModificacions(List<LimpiezaCocheModificacion> limpiezaCocheModificacions) {
		this.limpiezaCocheModificacions = limpiezaCocheModificacions;
	}

	public LimpiezaCocheModificacion addLimpiezaCocheModificacion(LimpiezaCocheModificacion limpiezaCocheModificacion) {
		getLimpiezaCocheModificacions().add(limpiezaCocheModificacion);
		limpiezaCocheModificacion.setTurno(this);

		return limpiezaCocheModificacion;
	}

	public LimpiezaCocheModificacion removeLimpiezaCocheModificacion(LimpiezaCocheModificacion limpiezaCocheModificacion) {
		getLimpiezaCocheModificacions().remove(limpiezaCocheModificacion);
		limpiezaCocheModificacion.setTurno(null);

		return limpiezaCocheModificacion;
	}


	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="turno")
	public List<LimpiezaDespellejadoPonchada> getLimpiezaDespellejadoPonchadas() {
		return this.limpiezaDespellejadoPonchadas;
	}

	public void setLimpiezaDespellejadoPonchadas(List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas) {
		this.limpiezaDespellejadoPonchadas = limpiezaDespellejadoPonchadas;
	}

	public LimpiezaDespellejadoPonchada addLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().add(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setTurno(this);

		return limpiezaDespellejadoPonchada;
	}

	public LimpiezaDespellejadoPonchada removeLimpiezaDespellejadoPonchada(LimpiezaDespellejadoPonchada limpiezaDespellejadoPonchada) {
		getLimpiezaDespellejadoPonchadas().remove(limpiezaDespellejadoPonchada);
		limpiezaDespellejadoPonchada.setTurno(null);

		return limpiezaDespellejadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="turno")
	public List<LimpiezaDetalleProcesoBandeja> getLimpiezaDetalleProcesoBandejas() {
		return this.limpiezaDetalleProcesoBandejas;
	}

	public void setLimpiezaDetalleProcesoBandejas(List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas) {
		this.limpiezaDetalleProcesoBandejas = limpiezaDetalleProcesoBandejas;
	}

	public LimpiezaDetalleProcesoBandeja addLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().add(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setTurno(this);

		return limpiezaDetalleProcesoBandeja;
	}

	public LimpiezaDetalleProcesoBandeja removeLimpiezaDetalleProcesoBandeja(LimpiezaDetalleProcesoBandeja limpiezaDetalleProcesoBandeja) {
		getLimpiezaDetalleProcesoBandejas().remove(limpiezaDetalleProcesoBandeja);
		limpiezaDetalleProcesoBandeja.setTurno(null);

		return limpiezaDetalleProcesoBandeja;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="turno")
	public List<LimpiezaDetalleProcesoBandejaAprobacion> getLimpiezaDetalleProcesoBandejaAprobacions() {
		return this.limpiezaDetalleProcesoBandejaAprobacions;
	}

	public void setLimpiezaDetalleProcesoBandejaAprobacions(List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions) {
		this.limpiezaDetalleProcesoBandejaAprobacions = limpiezaDetalleProcesoBandejaAprobacions;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion addLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().add(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setTurno(this);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}

	public LimpiezaDetalleProcesoBandejaAprobacion removeLimpiezaDetalleProcesoBandejaAprobacion(LimpiezaDetalleProcesoBandejaAprobacion limpiezaDetalleProcesoBandejaAprobacion) {
		getLimpiezaDetalleProcesoBandejaAprobacions().remove(limpiezaDetalleProcesoBandejaAprobacion);
		limpiezaDetalleProcesoBandejaAprobacion.setTurno(null);

		return limpiezaDetalleProcesoBandejaAprobacion;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@OneToMany(mappedBy="turno")
	public List<LimpiezaDetalleProcesoCoche> getLimpiezaDetalleProcesoCoches() {
		return this.limpiezaDetalleProcesoCoches;
	}

	public void setLimpiezaDetalleProcesoCoches(List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches) {
		this.limpiezaDetalleProcesoCoches = limpiezaDetalleProcesoCoches;
	}

	public LimpiezaDetalleProcesoCoche addLimpiezaDetalleProcesoCoch(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoch) {
		getLimpiezaDetalleProcesoCoches().add(limpiezaDetalleProcesoCoch);
		limpiezaDetalleProcesoCoch.setTurno(this);

		return limpiezaDetalleProcesoCoch;
	}

	public LimpiezaDetalleProcesoCoche removeLimpiezaDetalleProcesoCoch(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoch) {
		getLimpiezaDetalleProcesoCoches().remove(limpiezaDetalleProcesoCoch);
		limpiezaDetalleProcesoCoch.setTurno(null);

		return limpiezaDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@OneToMany(mappedBy="turno")
	public List<LimpiezaDetalleProcesoLote> getLimpiezaDetalleProcesoLotes() {
		return this.limpiezaDetalleProcesoLotes;
	}

	public void setLimpiezaDetalleProcesoLotes(List<LimpiezaDetalleProcesoLote> limpiezaDetalleProcesoLotes) {
		this.limpiezaDetalleProcesoLotes = limpiezaDetalleProcesoLotes;
	}

	public LimpiezaDetalleProcesoLote addLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		getLimpiezaDetalleProcesoLotes().add(limpiezaDetalleProcesoLote);
		limpiezaDetalleProcesoLote.setTurno(this);

		return limpiezaDetalleProcesoLote;
	}

	public LimpiezaDetalleProcesoLote removeLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		getLimpiezaDetalleProcesoLotes().remove(limpiezaDetalleProcesoLote);
		limpiezaDetalleProcesoLote.setTurno(null);

		return limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="turno")
	public List<LimpiezaFileteadoPonchada> getLimpiezaFileteadoPonchadas() {
		return this.limpiezaFileteadoPonchadas;
	}

	public void setLimpiezaFileteadoPonchadas(List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas) {
		this.limpiezaFileteadoPonchadas = limpiezaFileteadoPonchadas;
	}

	public LimpiezaFileteadoPonchada addLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().add(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setTurno(this);

		return limpiezaFileteadoPonchada;
	}

	public LimpiezaFileteadoPonchada removeLimpiezaFileteadoPonchada(LimpiezaFileteadoPonchada limpiezaFileteadoPonchada) {
		getLimpiezaFileteadoPonchadas().remove(limpiezaFileteadoPonchada);
		limpiezaFileteadoPonchada.setTurno(null);

		return limpiezaFileteadoPonchada;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="turno")
	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
	}

	public LimpiezaProceso addLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().add(limpiezaProceso);
		limpiezaProceso.setTurno(this);

		return limpiezaProceso;
	}

	public LimpiezaProceso removeLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().remove(limpiezaProceso);
		limpiezaProceso.setTurno(null);

		return limpiezaProceso;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoFalta
	@OneToMany(mappedBy="turno")
	public List<LimpiezaProcesoEmpleadoFalta> getLimpiezaProcesoEmpleadoFaltas() {
		return this.limpiezaProcesoEmpleadoFaltas;
	}

	public void setLimpiezaProcesoEmpleadoFaltas(List<LimpiezaProcesoEmpleadoFalta> limpiezaProcesoEmpleadoFaltas) {
		this.limpiezaProcesoEmpleadoFaltas = limpiezaProcesoEmpleadoFaltas;
	}

	public LimpiezaProcesoEmpleadoFalta addLimpiezaProcesoEmpleadoFalta(LimpiezaProcesoEmpleadoFalta limpiezaProcesoEmpleadoFalta) {
		getLimpiezaProcesoEmpleadoFaltas().add(limpiezaProcesoEmpleadoFalta);
		limpiezaProcesoEmpleadoFalta.setTurno(this);

		return limpiezaProcesoEmpleadoFalta;
	}

	public LimpiezaProcesoEmpleadoFalta removeLimpiezaProcesoEmpleadoFalta(LimpiezaProcesoEmpleadoFalta limpiezaProcesoEmpleadoFalta) {
		getLimpiezaProcesoEmpleadoFaltas().remove(limpiezaProcesoEmpleadoFalta);
		limpiezaProcesoEmpleadoFalta.setTurno(null);

		return limpiezaProcesoEmpleadoFalta;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoMarcacione
	@OneToMany(mappedBy="turno")
	public List<LimpiezaProcesoEmpleadoMarcacione> getLimpiezaProcesoEmpleadoMarcaciones() {
		return this.limpiezaProcesoEmpleadoMarcaciones;
	}

	public void setLimpiezaProcesoEmpleadoMarcaciones(List<LimpiezaProcesoEmpleadoMarcacione> limpiezaProcesoEmpleadoMarcaciones) {
		this.limpiezaProcesoEmpleadoMarcaciones = limpiezaProcesoEmpleadoMarcaciones;
	}

	public LimpiezaProcesoEmpleadoMarcacione addLimpiezaProcesoEmpleadoMarcacione(LimpiezaProcesoEmpleadoMarcacione limpiezaProcesoEmpleadoMarcacione) {
		getLimpiezaProcesoEmpleadoMarcaciones().add(limpiezaProcesoEmpleadoMarcacione);
		limpiezaProcesoEmpleadoMarcacione.setTurno(this);

		return limpiezaProcesoEmpleadoMarcacione;
	}

	public LimpiezaProcesoEmpleadoMarcacione removeLimpiezaProcesoEmpleadoMarcacione(LimpiezaProcesoEmpleadoMarcacione limpiezaProcesoEmpleadoMarcacione) {
		getLimpiezaProcesoEmpleadoMarcaciones().remove(limpiezaProcesoEmpleadoMarcacione);
		limpiezaProcesoEmpleadoMarcacione.setTurno(null);

		return limpiezaProcesoEmpleadoMarcacione;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoConteo
	@OneToMany(mappedBy="turno")
	public List<LonjasDetalleProcesoConteo> getLonjasDetalleProcesoConteos() {
		return this.lonjasDetalleProcesoConteos;
	}

	public void setLonjasDetalleProcesoConteos(List<LonjasDetalleProcesoConteo> lonjasDetalleProcesoConteos) {
		this.lonjasDetalleProcesoConteos = lonjasDetalleProcesoConteos;
	}

	public LonjasDetalleProcesoConteo addLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().add(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setTurno(this);

		return lonjasDetalleProcesoConteo;
	}

	public LonjasDetalleProcesoConteo removeLonjasDetalleProcesoConteo(LonjasDetalleProcesoConteo lonjasDetalleProcesoConteo) {
		getLonjasDetalleProcesoConteos().remove(lonjasDetalleProcesoConteo);
		lonjasDetalleProcesoConteo.setTurno(null);

		return lonjasDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoEmpaque
	@OneToMany(mappedBy="turno")
	public List<LonjasDetalleProcesoEmpaque> getLonjasDetalleProcesoEmpaques() {
		return this.lonjasDetalleProcesoEmpaques;
	}

	public void setLonjasDetalleProcesoEmpaques(List<LonjasDetalleProcesoEmpaque> lonjasDetalleProcesoEmpaques) {
		this.lonjasDetalleProcesoEmpaques = lonjasDetalleProcesoEmpaques;
	}

	public LonjasDetalleProcesoEmpaque addLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().add(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setTurno(this);

		return lonjasDetalleProcesoEmpaque;
	}

	public LonjasDetalleProcesoEmpaque removeLonjasDetalleProcesoEmpaque(LonjasDetalleProcesoEmpaque lonjasDetalleProcesoEmpaque) {
		getLonjasDetalleProcesoEmpaques().remove(lonjasDetalleProcesoEmpaque);
		lonjasDetalleProcesoEmpaque.setTurno(null);

		return lonjasDetalleProcesoEmpaque;
	}


	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@OneToMany(mappedBy="turno")
	public List<LonjasDetalleProcesoLote> getLonjasDetalleProcesoLotes() {
		return this.lonjasDetalleProcesoLotes;
	}

	public void setLonjasDetalleProcesoLotes(List<LonjasDetalleProcesoLote> lonjasDetalleProcesoLotes) {
		this.lonjasDetalleProcesoLotes = lonjasDetalleProcesoLotes;
	}

	public LonjasDetalleProcesoLote addLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().add(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setTurno(this);

		return lonjasDetalleProcesoLote;
	}

	public LonjasDetalleProcesoLote removeLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		getLonjasDetalleProcesoLotes().remove(lonjasDetalleProcesoLote);
		lonjasDetalleProcesoLote.setTurno(null);

		return lonjasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="turno")
	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
	}

	public LonjasProceso addLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().add(lonjasProceso);
		lonjasProceso.setTurno(this);

		return lonjasProceso;
	}

	public LonjasProceso removeLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().remove(lonjasProceso);
		lonjasProceso.setTurno(null);

		return lonjasProceso;
	}


	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="turno")
	public List<ObservacionesPuntoControl> getObservacionesPuntoControls() {
		return this.observacionesPuntoControls;
	}

	public void setObservacionesPuntoControls(List<ObservacionesPuntoControl> observacionesPuntoControls) {
		this.observacionesPuntoControls = observacionesPuntoControls;
	}

	public ObservacionesPuntoControl addObservacionesPuntoControl(ObservacionesPuntoControl observacionesPuntoControl) {
		getObservacionesPuntoControls().add(observacionesPuntoControl);
		observacionesPuntoControl.setTurno(this);

		return observacionesPuntoControl;
	}

	public ObservacionesPuntoControl removeObservacionesPuntoControl(ObservacionesPuntoControl observacionesPuntoControl) {
		getObservacionesPuntoControls().remove(observacionesPuntoControl);
		observacionesPuntoControl.setTurno(null);

		return observacionesPuntoControl;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoConteo
	@OneToMany(mappedBy="turno")
	public List<PanzasDetalleProcesoConteo> getPanzasDetalleProcesoConteos() {
		return this.panzasDetalleProcesoConteos;
	}

	public void setPanzasDetalleProcesoConteos(List<PanzasDetalleProcesoConteo> panzasDetalleProcesoConteos) {
		this.panzasDetalleProcesoConteos = panzasDetalleProcesoConteos;
	}

	public PanzasDetalleProcesoConteo addPanzasDetalleProcesoConteo(PanzasDetalleProcesoConteo panzasDetalleProcesoConteo) {
		getPanzasDetalleProcesoConteos().add(panzasDetalleProcesoConteo);
		panzasDetalleProcesoConteo.setTurno(this);

		return panzasDetalleProcesoConteo;
	}

	public PanzasDetalleProcesoConteo removePanzasDetalleProcesoConteo(PanzasDetalleProcesoConteo panzasDetalleProcesoConteo) {
		getPanzasDetalleProcesoConteos().remove(panzasDetalleProcesoConteo);
		panzasDetalleProcesoConteo.setTurno(null);

		return panzasDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to PanzasDetalleProcesoLote
	@OneToMany(mappedBy="turno")
	public List<PanzasDetalleProcesoLote> getPanzasDetalleProcesoLotes() {
		return this.panzasDetalleProcesoLotes;
	}

	public void setPanzasDetalleProcesoLotes(List<PanzasDetalleProcesoLote> panzasDetalleProcesoLotes) {
		this.panzasDetalleProcesoLotes = panzasDetalleProcesoLotes;
	}

	public PanzasDetalleProcesoLote addPanzasDetalleProcesoLote(PanzasDetalleProcesoLote panzasDetalleProcesoLote) {
		getPanzasDetalleProcesoLotes().add(panzasDetalleProcesoLote);
		panzasDetalleProcesoLote.setTurno(this);

		return panzasDetalleProcesoLote;
	}

	public PanzasDetalleProcesoLote removePanzasDetalleProcesoLote(PanzasDetalleProcesoLote panzasDetalleProcesoLote) {
		getPanzasDetalleProcesoLotes().remove(panzasDetalleProcesoLote);
		panzasDetalleProcesoLote.setTurno(null);

		return panzasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to PanzasProceso
	@OneToMany(mappedBy="turno")
	public List<PanzasProceso> getPanzasProcesos() {
		return this.panzasProcesos;
	}

	public void setPanzasProcesos(List<PanzasProceso> panzasProcesos) {
		this.panzasProcesos = panzasProcesos;
	}

	public PanzasProceso addPanzasProceso(PanzasProceso panzasProceso) {
		getPanzasProcesos().add(panzasProceso);
		panzasProceso.setTurno(this);

		return panzasProceso;
	}

	public PanzasProceso removePanzasProceso(PanzasProceso panzasProceso) {
		getPanzasProcesos().remove(panzasProceso);
		panzasProceso.setTurno(null);

		return panzasProceso;
	}


	//bi-directional many-to-one association to PedidoProduccionArchivoCargaDetalle
	@OneToMany(mappedBy="turno")
	public List<PedidoProduccionArchivoCargaDetalle> getPedidoProduccionArchivoCargaDetalles() {
		return this.pedidoProduccionArchivoCargaDetalles;
	}

	public void setPedidoProduccionArchivoCargaDetalles(List<PedidoProduccionArchivoCargaDetalle> pedidoProduccionArchivoCargaDetalles) {
		this.pedidoProduccionArchivoCargaDetalles = pedidoProduccionArchivoCargaDetalles;
	}

	public PedidoProduccionArchivoCargaDetalle addPedidoProduccionArchivoCargaDetalle(PedidoProduccionArchivoCargaDetalle pedidoProduccionArchivoCargaDetalle) {
		getPedidoProduccionArchivoCargaDetalles().add(pedidoProduccionArchivoCargaDetalle);
		pedidoProduccionArchivoCargaDetalle.setTurno(this);

		return pedidoProduccionArchivoCargaDetalle;
	}

	public PedidoProduccionArchivoCargaDetalle removePedidoProduccionArchivoCargaDetalle(PedidoProduccionArchivoCargaDetalle pedidoProduccionArchivoCargaDetalle) {
		getPedidoProduccionArchivoCargaDetalles().remove(pedidoProduccionArchivoCargaDetalle);
		pedidoProduccionArchivoCargaDetalle.setTurno(null);

		return pedidoProduccionArchivoCargaDetalle;
	}


	//bi-directional many-to-one association to PedidoProduccionDetalle
	@OneToMany(mappedBy="turno")
	public List<PedidoProduccionDetalle> getPedidoProduccionDetalles() {
		return this.pedidoProduccionDetalles;
	}

	public void setPedidoProduccionDetalles(List<PedidoProduccionDetalle> pedidoProduccionDetalles) {
		this.pedidoProduccionDetalles = pedidoProduccionDetalles;
	}

	public PedidoProduccionDetalle addPedidoProduccionDetalle(PedidoProduccionDetalle pedidoProduccionDetalle) {
		getPedidoProduccionDetalles().add(pedidoProduccionDetalle);
		pedidoProduccionDetalle.setTurno(this);

		return pedidoProduccionDetalle;
	}

	public PedidoProduccionDetalle removePedidoProduccionDetalle(PedidoProduccionDetalle pedidoProduccionDetalle) {
		getPedidoProduccionDetalles().remove(pedidoProduccionDetalle);
		pedidoProduccionDetalle.setTurno(null);

		return pedidoProduccionDetalle;
	}


	//bi-directional many-to-one association to PlanificacionCargaDetalle
	@OneToMany(mappedBy="turno")
	public List<PlanificacionCargaDetalle> getPlanificacionCargaDetalles() {
		return this.planificacionCargaDetalles;
	}

	public void setPlanificacionCargaDetalles(List<PlanificacionCargaDetalle> planificacionCargaDetalles) {
		this.planificacionCargaDetalles = planificacionCargaDetalles;
	}

	public PlanificacionCargaDetalle addPlanificacionCargaDetalle(PlanificacionCargaDetalle planificacionCargaDetalle) {
		getPlanificacionCargaDetalles().add(planificacionCargaDetalle);
		planificacionCargaDetalle.setTurno(this);

		return planificacionCargaDetalle;
	}

	public PlanificacionCargaDetalle removePlanificacionCargaDetalle(PlanificacionCargaDetalle planificacionCargaDetalle) {
		getPlanificacionCargaDetalles().remove(planificacionCargaDetalle);
		planificacionCargaDetalle.setTurno(null);

		return planificacionCargaDetalle;
	}


	//bi-directional many-to-one association to PouchDetalleProcesoConteo
	@OneToMany(mappedBy="turno")
	public List<PouchDetalleProcesoConteo> getPouchDetalleProcesoConteos() {
		return this.pouchDetalleProcesoConteos;
	}

	public void setPouchDetalleProcesoConteos(List<PouchDetalleProcesoConteo> pouchDetalleProcesoConteos) {
		this.pouchDetalleProcesoConteos = pouchDetalleProcesoConteos;
	}

	public PouchDetalleProcesoConteo addPouchDetalleProcesoConteo(PouchDetalleProcesoConteo pouchDetalleProcesoConteo) {
		getPouchDetalleProcesoConteos().add(pouchDetalleProcesoConteo);
		pouchDetalleProcesoConteo.setTurno(this);

		return pouchDetalleProcesoConteo;
	}

	public PouchDetalleProcesoConteo removePouchDetalleProcesoConteo(PouchDetalleProcesoConteo pouchDetalleProcesoConteo) {
		getPouchDetalleProcesoConteos().remove(pouchDetalleProcesoConteo);
		pouchDetalleProcesoConteo.setTurno(null);

		return pouchDetalleProcesoConteo;
	}


	//bi-directional many-to-one association to ProduccionArchivoCargaOrdenDetalle
	@OneToMany(mappedBy="turno")
	public List<ProduccionArchivoCargaOrdenDetalle> getProduccionArchivoCargaOrdenDetalles() {
		return this.produccionArchivoCargaOrdenDetalles;
	}

	public void setProduccionArchivoCargaOrdenDetalles(List<ProduccionArchivoCargaOrdenDetalle> produccionArchivoCargaOrdenDetalles) {
		this.produccionArchivoCargaOrdenDetalles = produccionArchivoCargaOrdenDetalles;
	}

	public ProduccionArchivoCargaOrdenDetalle addProduccionArchivoCargaOrdenDetalle(ProduccionArchivoCargaOrdenDetalle produccionArchivoCargaOrdenDetalle) {
		getProduccionArchivoCargaOrdenDetalles().add(produccionArchivoCargaOrdenDetalle);
		produccionArchivoCargaOrdenDetalle.setTurno(this);

		return produccionArchivoCargaOrdenDetalle;
	}

	public ProduccionArchivoCargaOrdenDetalle removeProduccionArchivoCargaOrdenDetalle(ProduccionArchivoCargaOrdenDetalle produccionArchivoCargaOrdenDetalle) {
		getProduccionArchivoCargaOrdenDetalles().remove(produccionArchivoCargaOrdenDetalle);
		produccionArchivoCargaOrdenDetalle.setTurno(null);

		return produccionArchivoCargaOrdenDetalle;
	}


	//bi-directional many-to-one association to ProduccionDetalleLote
	@OneToMany(mappedBy="turno")
	public List<ProduccionDetalleLote> getProduccionDetalleLotes() {
		return this.produccionDetalleLotes;
	}

	public void setProduccionDetalleLotes(List<ProduccionDetalleLote> produccionDetalleLotes) {
		this.produccionDetalleLotes = produccionDetalleLotes;
	}

	public ProduccionDetalleLote addProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().add(produccionDetalleLote);
		produccionDetalleLote.setTurno(this);

		return produccionDetalleLote;
	}

	public ProduccionDetalleLote removeProduccionDetalleLote(ProduccionDetalleLote produccionDetalleLote) {
		getProduccionDetalleLotes().remove(produccionDetalleLote);
		produccionDetalleLote.setTurno(null);

		return produccionDetalleLote;
	}


	//bi-directional many-to-one association to ProduccionDetalleLoteCarryover
	@OneToMany(mappedBy="turno")
	public List<ProduccionDetalleLoteCarryover> getProduccionDetalleLoteCarryovers() {
		return this.produccionDetalleLoteCarryovers;
	}

	public void setProduccionDetalleLoteCarryovers(List<ProduccionDetalleLoteCarryover> produccionDetalleLoteCarryovers) {
		this.produccionDetalleLoteCarryovers = produccionDetalleLoteCarryovers;
	}

	public ProduccionDetalleLoteCarryover addProduccionDetalleLoteCarryover(ProduccionDetalleLoteCarryover produccionDetalleLoteCarryover) {
		getProduccionDetalleLoteCarryovers().add(produccionDetalleLoteCarryover);
		produccionDetalleLoteCarryover.setTurno(this);

		return produccionDetalleLoteCarryover;
	}

	public ProduccionDetalleLoteCarryover removeProduccionDetalleLoteCarryover(ProduccionDetalleLoteCarryover produccionDetalleLoteCarryover) {
		getProduccionDetalleLoteCarryovers().remove(produccionDetalleLoteCarryover);
		produccionDetalleLoteCarryover.setTurno(null);

		return produccionDetalleLoteCarryover;
	}


	//bi-directional many-to-one association to ProduccionDetalleOrden
	@OneToMany(mappedBy="turno")
	public List<ProduccionDetalleOrden> getProduccionDetalleOrdens() {
		return this.produccionDetalleOrdens;
	}

	public void setProduccionDetalleOrdens(List<ProduccionDetalleOrden> produccionDetalleOrdens) {
		this.produccionDetalleOrdens = produccionDetalleOrdens;
	}

	public ProduccionDetalleOrden addProduccionDetalleOrden(ProduccionDetalleOrden produccionDetalleOrden) {
		getProduccionDetalleOrdens().add(produccionDetalleOrden);
		produccionDetalleOrden.setTurno(this);

		return produccionDetalleOrden;
	}

	public ProduccionDetalleOrden removeProduccionDetalleOrden(ProduccionDetalleOrden produccionDetalleOrden) {
		getProduccionDetalleOrdens().remove(produccionDetalleOrden);
		produccionDetalleOrden.setTurno(null);

		return produccionDetalleOrden;
	}


	//bi-directional many-to-one association to ProduccionOrdenPedido
	@OneToMany(mappedBy="turno")
	public List<ProduccionOrdenPedido> getProduccionOrdenPedidos() {
		return this.produccionOrdenPedidos;
	}

	public void setProduccionOrdenPedidos(List<ProduccionOrdenPedido> produccionOrdenPedidos) {
		this.produccionOrdenPedidos = produccionOrdenPedidos;
	}

	public ProduccionOrdenPedido addProduccionOrdenPedido(ProduccionOrdenPedido produccionOrdenPedido) {
		getProduccionOrdenPedidos().add(produccionOrdenPedido);
		produccionOrdenPedido.setTurno(this);

		return produccionOrdenPedido;
	}

	public ProduccionOrdenPedido removeProduccionOrdenPedido(ProduccionOrdenPedido produccionOrdenPedido) {
		getProduccionOrdenPedidos().remove(produccionOrdenPedido);
		produccionOrdenPedido.setTurno(null);

		return produccionOrdenPedido;
	}


	//bi-directional many-to-one association to RackeoProceso
	@OneToMany(mappedBy="turno")
	public List<RackeoProceso> getRackeoProcesos() {
		return this.rackeoProcesos;
	}

	public void setRackeoProcesos(List<RackeoProceso> rackeoProcesos) {
		this.rackeoProcesos = rackeoProcesos;
	}

	public RackeoProceso addRackeoProceso(RackeoProceso rackeoProceso) {
		getRackeoProcesos().add(rackeoProceso);
		rackeoProceso.setTurno(this);

		return rackeoProceso;
	}

	public RackeoProceso removeRackeoProceso(RackeoProceso rackeoProceso) {
		getRackeoProcesos().remove(rackeoProceso);
		rackeoProceso.setTurno(null);

		return rackeoProceso;
	}


	//bi-directional many-to-one association to ReportesPuntoControl
	@OneToMany(mappedBy="turno")
	public List<ReportesPuntoControl> getReportesPuntoControls() {
		return this.reportesPuntoControls;
	}

	public void setReportesPuntoControls(List<ReportesPuntoControl> reportesPuntoControls) {
		this.reportesPuntoControls = reportesPuntoControls;
	}

	public ReportesPuntoControl addReportesPuntoControl(ReportesPuntoControl reportesPuntoControl) {
		getReportesPuntoControls().add(reportesPuntoControl);
		reportesPuntoControl.setTurno(this);

		return reportesPuntoControl;
	}

	public ReportesPuntoControl removeReportesPuntoControl(ReportesPuntoControl reportesPuntoControl) {
		getReportesPuntoControls().remove(reportesPuntoControl);
		reportesPuntoControl.setTurno(null);

		return reportesPuntoControl;
	}


	//bi-directional many-to-one association to RociadoDetalleMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	public List<RociadoDetalleMuestreoTempCoche> getRociadoDetalleMuestreoTempCoches() {
		return this.rociadoDetalleMuestreoTempCoches;
	}

	public void setRociadoDetalleMuestreoTempCoches(List<RociadoDetalleMuestreoTempCoche> rociadoDetalleMuestreoTempCoches) {
		this.rociadoDetalleMuestreoTempCoches = rociadoDetalleMuestreoTempCoches;
	}

	public RociadoDetalleMuestreoTempCoche addRociadoDetalleMuestreoTempCoch(RociadoDetalleMuestreoTempCoche rociadoDetalleMuestreoTempCoch) {
		getRociadoDetalleMuestreoTempCoches().add(rociadoDetalleMuestreoTempCoch);
		rociadoDetalleMuestreoTempCoch.setTurno(this);

		return rociadoDetalleMuestreoTempCoch;
	}

	public RociadoDetalleMuestreoTempCoche removeRociadoDetalleMuestreoTempCoch(RociadoDetalleMuestreoTempCoche rociadoDetalleMuestreoTempCoch) {
		getRociadoDetalleMuestreoTempCoches().remove(rociadoDetalleMuestreoTempCoch);
		rociadoDetalleMuestreoTempCoch.setTurno(null);

		return rociadoDetalleMuestreoTempCoch;
	}


	//bi-directional many-to-one association to RociadoDetalleProcesoCoche
	@OneToMany(mappedBy="turno")
	public List<RociadoDetalleProcesoCoche> getRociadoDetalleProcesoCoches() {
		return this.rociadoDetalleProcesoCoches;
	}

	public void setRociadoDetalleProcesoCoches(List<RociadoDetalleProcesoCoche> rociadoDetalleProcesoCoches) {
		this.rociadoDetalleProcesoCoches = rociadoDetalleProcesoCoches;
	}

	public RociadoDetalleProcesoCoche addRociadoDetalleProcesoCoch(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoch) {
		getRociadoDetalleProcesoCoches().add(rociadoDetalleProcesoCoch);
		rociadoDetalleProcesoCoch.setTurno(this);

		return rociadoDetalleProcesoCoch;
	}

	public RociadoDetalleProcesoCoche removeRociadoDetalleProcesoCoch(RociadoDetalleProcesoCoche rociadoDetalleProcesoCoch) {
		getRociadoDetalleProcesoCoches().remove(rociadoDetalleProcesoCoch);
		rociadoDetalleProcesoCoch.setTurno(null);

		return rociadoDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to RociadoDetalleProcesoCocheTemperatura
	@OneToMany(mappedBy="turno")
	public List<RociadoDetalleProcesoCocheTemperatura> getRociadoDetalleProcesoCocheTemperaturas() {
		return this.rociadoDetalleProcesoCocheTemperaturas;
	}

	public void setRociadoDetalleProcesoCocheTemperaturas(List<RociadoDetalleProcesoCocheTemperatura> rociadoDetalleProcesoCocheTemperaturas) {
		this.rociadoDetalleProcesoCocheTemperaturas = rociadoDetalleProcesoCocheTemperaturas;
	}

	public RociadoDetalleProcesoCocheTemperatura addRociadoDetalleProcesoCocheTemperatura(RociadoDetalleProcesoCocheTemperatura rociadoDetalleProcesoCocheTemperatura) {
		getRociadoDetalleProcesoCocheTemperaturas().add(rociadoDetalleProcesoCocheTemperatura);
		rociadoDetalleProcesoCocheTemperatura.setTurno(this);

		return rociadoDetalleProcesoCocheTemperatura;
	}

	public RociadoDetalleProcesoCocheTemperatura removeRociadoDetalleProcesoCocheTemperatura(RociadoDetalleProcesoCocheTemperatura rociadoDetalleProcesoCocheTemperatura) {
		getRociadoDetalleProcesoCocheTemperaturas().remove(rociadoDetalleProcesoCocheTemperatura);
		rociadoDetalleProcesoCocheTemperatura.setTurno(null);

		return rociadoDetalleProcesoCocheTemperatura;
	}


	//bi-directional many-to-one association to RociadoMuestreoTempCoche
	@OneToMany(mappedBy="turno")
	public List<RociadoMuestreoTempCoche> getRociadoMuestreoTempCoches() {
		return this.rociadoMuestreoTempCoches;
	}

	public void setRociadoMuestreoTempCoches(List<RociadoMuestreoTempCoche> rociadoMuestreoTempCoches) {
		this.rociadoMuestreoTempCoches = rociadoMuestreoTempCoches;
	}

	public RociadoMuestreoTempCoche addRociadoMuestreoTempCoch(RociadoMuestreoTempCoche rociadoMuestreoTempCoch) {
		getRociadoMuestreoTempCoches().add(rociadoMuestreoTempCoch);
		rociadoMuestreoTempCoch.setTurno(this);

		return rociadoMuestreoTempCoch;
	}

	public RociadoMuestreoTempCoche removeRociadoMuestreoTempCoch(RociadoMuestreoTempCoche rociadoMuestreoTempCoch) {
		getRociadoMuestreoTempCoches().remove(rociadoMuestreoTempCoch);
		rociadoMuestreoTempCoch.setTurno(null);

		return rociadoMuestreoTempCoch;
	}


	//bi-directional many-to-one association to TurnoGestionDetalle
	@OneToMany(mappedBy="turno")
	public List<TurnoGestionDetalle> getTurnoGestionDetalles() {
		return this.turnoGestionDetalles;
	}

	public void setTurnoGestionDetalles(List<TurnoGestionDetalle> turnoGestionDetalles) {
		this.turnoGestionDetalles = turnoGestionDetalles;
	}

	public TurnoGestionDetalle addTurnoGestionDetalle(TurnoGestionDetalle turnoGestionDetalle) {
		getTurnoGestionDetalles().add(turnoGestionDetalle);
		turnoGestionDetalle.setTurno(this);

		return turnoGestionDetalle;
	}

	public TurnoGestionDetalle removeTurnoGestionDetalle(TurnoGestionDetalle turnoGestionDetalle) {
		getTurnoGestionDetalles().remove(turnoGestionDetalle);
		turnoGestionDetalle.setTurno(null);

		return turnoGestionDetalle;
	}

}