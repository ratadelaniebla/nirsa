package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proceso database table.
 * 
 */
@Entity
public class Proceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idproceso;

	private String descripcionproceso;

	//bi-directional many-to-one association to AreaProceso
	@OneToMany(mappedBy="proceso")
	private List<AreaProceso> areaProcesos;

	//bi-directional many-to-one association to DispositivoDestino
	@OneToMany(mappedBy="proceso")
	private List<DispositivoDestino> dispositivoDestinos;

	//bi-directional many-to-one association to GestionTurno
	@OneToMany(mappedBy="proceso")
	private List<GestionTurno> gestionTurnos;

	//bi-directional many-to-one association to LimpiezaLomoLimpioCoche
	@OneToMany(mappedBy="proceso")
	private List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches;

	//bi-directional many-to-one association to ObservacionesProceso
	@OneToMany(mappedBy="proceso")
	private List<ObservacionesProceso> observacionesProcesos;

	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="proceso")
	private List<ObservacionesPuntoControl> observacionesPuntoControls;

	//bi-directional many-to-one association to OeeDefecto
	@OneToMany(mappedBy="proceso")
	private List<OeeDefecto> oeeDefectos;

	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="proceso")
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;

	//bi-directional many-to-one association to OeeParada
	@OneToMany(mappedBy="proceso")
	private List<OeeParada> oeeParadas;

	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@OneToMany(mappedBy="proceso")
	private List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@OneToMany(mappedBy="proceso")
	private List<ProcesoAperturaCierre> procesoAperturaCierres;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="proceso")
	private List<Reporte> reportes;

	public Proceso() {
	}

	public Integer getIdproceso() {
		return this.idproceso;
	}

	public void setIdproceso(Integer idproceso) {
		this.idproceso = idproceso;
	}

	public String getDescripcionproceso() {
		return this.descripcionproceso;
	}

	public void setDescripcionproceso(String descripcionproceso) {
		this.descripcionproceso = descripcionproceso;
	}

	public List<AreaProceso> getAreaProcesos() {
		return this.areaProcesos;
	}

	public void setAreaProcesos(List<AreaProceso> areaProcesos) {
		this.areaProcesos = areaProcesos;
	}

	public List<DispositivoDestino> getDispositivoDestinos() {
		return this.dispositivoDestinos;
	}

	public void setDispositivoDestinos(List<DispositivoDestino> dispositivoDestinos) {
		this.dispositivoDestinos = dispositivoDestinos;
	}

	public List<GestionTurno> getGestionTurnos() {
		return this.gestionTurnos;
	}

	public void setGestionTurnos(List<GestionTurno> gestionTurnos) {
		this.gestionTurnos = gestionTurnos;
	}

	public List<LimpiezaLomoLimpioCoche> getLimpiezaLomoLimpioCoches() {
		return this.limpiezaLomoLimpioCoches;
	}

	public void setLimpiezaLomoLimpioCoches(List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches) {
		this.limpiezaLomoLimpioCoches = limpiezaLomoLimpioCoches;
	}

	public List<ObservacionesProceso> getObservacionesProcesos() {
		return this.observacionesProcesos;
	}

	public void setObservacionesProcesos(List<ObservacionesProceso> observacionesProcesos) {
		this.observacionesProcesos = observacionesProcesos;
	}

	public List<ObservacionesPuntoControl> getObservacionesPuntoControls() {
		return this.observacionesPuntoControls;
	}

	public void setObservacionesPuntoControls(List<ObservacionesPuntoControl> observacionesPuntoControls) {
		this.observacionesPuntoControls = observacionesPuntoControls;
	}

	public List<OeeDefecto> getOeeDefectos() {
		return this.oeeDefectos;
	}

	public void setOeeDefectos(List<OeeDefecto> oeeDefectos) {
		this.oeeDefectos = oeeDefectos;
	}

	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public List<OeeParada> getOeeParadas() {
		return this.oeeParadas;
	}

	public void setOeeParadas(List<OeeParada> oeeParadas) {
		this.oeeParadas = oeeParadas;
	}

	public List<OeePeriodoBaseObjetivo> getOeePeriodoBaseObjetivos() {
		return this.oeePeriodoBaseObjetivos;
	}

	public void setOeePeriodoBaseObjetivos(List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos) {
		this.oeePeriodoBaseObjetivos = oeePeriodoBaseObjetivos;
	}

	public List<ProcesoAperturaCierre> getProcesoAperturaCierres() {
		return this.procesoAperturaCierres;
	}

	public void setProcesoAperturaCierres(List<ProcesoAperturaCierre> procesoAperturaCierres) {
		this.procesoAperturaCierres = procesoAperturaCierres;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

}