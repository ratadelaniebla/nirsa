package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_linea database table.
 * 
 */
@Entity
@Table(name="limpieza_linea")
public class LimpiezaLinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezalinea;

	private String descripcion;

	//bi-directional many-to-one association to ControlDetalleBatchLimpieza
	@OneToMany(mappedBy="limpiezaLinea")
	private List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas;

	//bi-directional many-to-one association to LimpiezaCalidadDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaCalidadDetalleProcesoBandeja> limpiezaCalidadDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaCocheModificacion
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaCocheModificacion> limpiezaCocheModificacions;

	//bi-directional many-to-one association to LimpiezaDespellejadoPonchada
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaDespellejadoPonchada> limpiezaDespellejadoPonchadas;

	//bi-directional many-to-one association to LimpiezaDetalleCortesPlantaLineaEmpleado
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandeja
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaDetalleProcesoBandeja> limpiezaDetalleProcesoBandejas;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoBandejaAprobacion
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaDetalleProcesoBandejaAprobacion> limpiezaDetalleProcesoBandejaAprobacions;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaDetalleProcesoCoche> limpiezaDetalleProcesoCoches;

	//bi-directional many-to-one association to LimpiezaDetalleTipoCorte
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaDetalleTipoCorte> limpiezaDetalleTipoCortes;

	//bi-directional many-to-one association to LimpiezaDetalleTipoPara
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas;

	//bi-directional many-to-one association to LimpiezaFileteadoPonchada
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaFileteadoPonchada> limpiezaFileteadoPonchadas;

	//bi-directional many-to-one association to LimpiezaLineaGrupo
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaLineaGrupo> limpiezaLineaGrupos;

	//bi-directional many-to-one association to LimpiezaLomoLimpioCoche
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaProcesoEmpleado> limpiezaProcesoEmpleados;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoTotalInicial
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaProcesoEmpleadoTotalInicial> limpiezaProcesoEmpleadoTotalInicials;

	//bi-directional many-to-one association to LimpiezaProcesoJornadaLinea
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaProcesoJornadaLinea> limpiezaProcesoJornadaLineas;

	//bi-directional many-to-one association to LimpiezaProcesoLineaTara
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaProcesoLineaTara> limpiezaProcesoLineaTaras;

	//bi-directional many-to-one association to LimpiezaProcesoLoteActivo
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaProcesoLoteActivo> limpiezaProcesoLoteActivos;

	//bi-directional many-to-one association to LimpiezaRalladoDetallePeso
	@OneToMany(mappedBy="limpiezaLinea")
	private List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos;

	//bi-directional many-to-one association to OeeDetalleMediosConDefectoLimpieza
	@OneToMany(mappedBy="limpiezaLinea")
	private List<OeeDetalleMediosConDefectoLimpieza> oeeDetalleMediosConDefectoLimpiezas;

	//bi-directional many-to-one association to OeeDetalleParadaLimpieza
	@OneToMany(mappedBy="limpiezaLinea")
	private List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas;

	public LimpiezaLinea() {
	}

	public Integer getIdlimpiezalinea() {
		return this.idlimpiezalinea;
	}

	public void setIdlimpiezalinea(Integer idlimpiezalinea) {
		this.idlimpiezalinea = idlimpiezalinea;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ControlDetalleBatchLimpieza> getControlDetalleBatchLimpiezas() {
		return this.controlDetalleBatchLimpiezas;
	}

	public void setControlDetalleBatchLimpiezas(List<ControlDetalleBatchLimpieza> controlDetalleBatchLimpiezas) {
		this.controlDetalleBatchLimpiezas = controlDetalleBatchLimpiezas;
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

	public List<LimpiezaDetalleCortesPlantaLineaEmpleado> getLimpiezaDetalleCortesPlantaLineaEmpleados() {
		return this.limpiezaDetalleCortesPlantaLineaEmpleados;
	}

	public void setLimpiezaDetalleCortesPlantaLineaEmpleados(List<LimpiezaDetalleCortesPlantaLineaEmpleado> limpiezaDetalleCortesPlantaLineaEmpleados) {
		this.limpiezaDetalleCortesPlantaLineaEmpleados = limpiezaDetalleCortesPlantaLineaEmpleados;
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

	public List<LimpiezaLineaGrupo> getLimpiezaLineaGrupos() {
		return this.limpiezaLineaGrupos;
	}

	public void setLimpiezaLineaGrupos(List<LimpiezaLineaGrupo> limpiezaLineaGrupos) {
		this.limpiezaLineaGrupos = limpiezaLineaGrupos;
	}

	public List<LimpiezaLomoLimpioCoche> getLimpiezaLomoLimpioCoches() {
		return this.limpiezaLomoLimpioCoches;
	}

	public void setLimpiezaLomoLimpioCoches(List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches) {
		this.limpiezaLomoLimpioCoches = limpiezaLomoLimpioCoches;
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

	public List<LimpiezaRalladoDetallePeso> getLimpiezaRalladoDetallePesos() {
		return this.limpiezaRalladoDetallePesos;
	}

	public void setLimpiezaRalladoDetallePesos(List<LimpiezaRalladoDetallePeso> limpiezaRalladoDetallePesos) {
		this.limpiezaRalladoDetallePesos = limpiezaRalladoDetallePesos;
	}

	public List<OeeDetalleMediosConDefectoLimpieza> getOeeDetalleMediosConDefectoLimpiezas() {
		return this.oeeDetalleMediosConDefectoLimpiezas;
	}

	public void setOeeDetalleMediosConDefectoLimpiezas(List<OeeDetalleMediosConDefectoLimpieza> oeeDetalleMediosConDefectoLimpiezas) {
		this.oeeDetalleMediosConDefectoLimpiezas = oeeDetalleMediosConDefectoLimpiezas;
	}

	public List<OeeDetalleParadaLimpieza> getOeeDetalleParadaLimpiezas() {
		return this.oeeDetalleParadaLimpiezas;
	}

	public void setOeeDetalleParadaLimpiezas(List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas) {
		this.oeeDetalleParadaLimpiezas = oeeDetalleParadaLimpiezas;
	}

}