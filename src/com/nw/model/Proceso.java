package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proceso database table.
 * 
 */
@Entity
@NamedQuery(name="Proceso.findAll", query="SELECT p FROM Proceso p")
public class Proceso implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idproceso;
	private String descripcionproceso;
	private List<AreaProceso> areaProcesos;
	private List<DispositivoDestino> dispositivoDestinos;
	private List<GestionTurno> gestionTurnos;
	private List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches;
	private List<ObservacionesProceso> observacionesProcesos;
	private List<ObservacionesPuntoControl> observacionesPuntoControls;
	private List<OeeDefecto> oeeDefectos;
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;
	private List<OeeParada> oeeParadas;
	private List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos;
	private List<ProcesoAperturaCierre> procesoAperturaCierres;
	private List<Reporte> reportes;

	public Proceso() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AreaProceso
	@OneToMany(mappedBy="proceso")
	public List<AreaProceso> getAreaProcesos() {
		return this.areaProcesos;
	}

	public void setAreaProcesos(List<AreaProceso> areaProcesos) {
		this.areaProcesos = areaProcesos;
	}

	public AreaProceso addAreaProceso(AreaProceso areaProceso) {
		getAreaProcesos().add(areaProceso);
		areaProceso.setProceso(this);

		return areaProceso;
	}

	public AreaProceso removeAreaProceso(AreaProceso areaProceso) {
		getAreaProcesos().remove(areaProceso);
		areaProceso.setProceso(null);

		return areaProceso;
	}


	//bi-directional many-to-one association to DispositivoDestino
	@OneToMany(mappedBy="proceso")
	public List<DispositivoDestino> getDispositivoDestinos() {
		return this.dispositivoDestinos;
	}

	public void setDispositivoDestinos(List<DispositivoDestino> dispositivoDestinos) {
		this.dispositivoDestinos = dispositivoDestinos;
	}

	public DispositivoDestino addDispositivoDestino(DispositivoDestino dispositivoDestino) {
		getDispositivoDestinos().add(dispositivoDestino);
		dispositivoDestino.setProceso(this);

		return dispositivoDestino;
	}

	public DispositivoDestino removeDispositivoDestino(DispositivoDestino dispositivoDestino) {
		getDispositivoDestinos().remove(dispositivoDestino);
		dispositivoDestino.setProceso(null);

		return dispositivoDestino;
	}


	//bi-directional many-to-one association to GestionTurno
	@OneToMany(mappedBy="proceso")
	public List<GestionTurno> getGestionTurnos() {
		return this.gestionTurnos;
	}

	public void setGestionTurnos(List<GestionTurno> gestionTurnos) {
		this.gestionTurnos = gestionTurnos;
	}

	public GestionTurno addGestionTurno(GestionTurno gestionTurno) {
		getGestionTurnos().add(gestionTurno);
		gestionTurno.setProceso(this);

		return gestionTurno;
	}

	public GestionTurno removeGestionTurno(GestionTurno gestionTurno) {
		getGestionTurnos().remove(gestionTurno);
		gestionTurno.setProceso(null);

		return gestionTurno;
	}


	//bi-directional many-to-one association to LimpiezaLomoLimpioCoche
	@OneToMany(mappedBy="proceso")
	public List<LimpiezaLomoLimpioCoche> getLimpiezaLomoLimpioCoches() {
		return this.limpiezaLomoLimpioCoches;
	}

	public void setLimpiezaLomoLimpioCoches(List<LimpiezaLomoLimpioCoche> limpiezaLomoLimpioCoches) {
		this.limpiezaLomoLimpioCoches = limpiezaLomoLimpioCoches;
	}

	public LimpiezaLomoLimpioCoche addLimpiezaLomoLimpioCoch(LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoch) {
		getLimpiezaLomoLimpioCoches().add(limpiezaLomoLimpioCoch);
		limpiezaLomoLimpioCoch.setProceso(this);

		return limpiezaLomoLimpioCoch;
	}

	public LimpiezaLomoLimpioCoche removeLimpiezaLomoLimpioCoch(LimpiezaLomoLimpioCoche limpiezaLomoLimpioCoch) {
		getLimpiezaLomoLimpioCoches().remove(limpiezaLomoLimpioCoch);
		limpiezaLomoLimpioCoch.setProceso(null);

		return limpiezaLomoLimpioCoch;
	}


	//bi-directional many-to-one association to ObservacionesProceso
	@OneToMany(mappedBy="proceso")
	public List<ObservacionesProceso> getObservacionesProcesos() {
		return this.observacionesProcesos;
	}

	public void setObservacionesProcesos(List<ObservacionesProceso> observacionesProcesos) {
		this.observacionesProcesos = observacionesProcesos;
	}

	public ObservacionesProceso addObservacionesProceso(ObservacionesProceso observacionesProceso) {
		getObservacionesProcesos().add(observacionesProceso);
		observacionesProceso.setProceso(this);

		return observacionesProceso;
	}

	public ObservacionesProceso removeObservacionesProceso(ObservacionesProceso observacionesProceso) {
		getObservacionesProcesos().remove(observacionesProceso);
		observacionesProceso.setProceso(null);

		return observacionesProceso;
	}


	//bi-directional many-to-one association to ObservacionesPuntoControl
	@OneToMany(mappedBy="proceso")
	public List<ObservacionesPuntoControl> getObservacionesPuntoControls() {
		return this.observacionesPuntoControls;
	}

	public void setObservacionesPuntoControls(List<ObservacionesPuntoControl> observacionesPuntoControls) {
		this.observacionesPuntoControls = observacionesPuntoControls;
	}

	public ObservacionesPuntoControl addObservacionesPuntoControl(ObservacionesPuntoControl observacionesPuntoControl) {
		getObservacionesPuntoControls().add(observacionesPuntoControl);
		observacionesPuntoControl.setProceso(this);

		return observacionesPuntoControl;
	}

	public ObservacionesPuntoControl removeObservacionesPuntoControl(ObservacionesPuntoControl observacionesPuntoControl) {
		getObservacionesPuntoControls().remove(observacionesPuntoControl);
		observacionesPuntoControl.setProceso(null);

		return observacionesPuntoControl;
	}


	//bi-directional many-to-one association to OeeDefecto
	@OneToMany(mappedBy="proceso")
	public List<OeeDefecto> getOeeDefectos() {
		return this.oeeDefectos;
	}

	public void setOeeDefectos(List<OeeDefecto> oeeDefectos) {
		this.oeeDefectos = oeeDefectos;
	}

	public OeeDefecto addOeeDefecto(OeeDefecto oeeDefecto) {
		getOeeDefectos().add(oeeDefecto);
		oeeDefecto.setProceso(this);

		return oeeDefecto;
	}

	public OeeDefecto removeOeeDefecto(OeeDefecto oeeDefecto) {
		getOeeDefectos().remove(oeeDefecto);
		oeeDefecto.setProceso(null);

		return oeeDefecto;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="proceso")
	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public OeeDetalleMediosConDefecto addOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().add(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setProceso(this);

		return oeeDetalleMediosConDefecto;
	}

	public OeeDetalleMediosConDefecto removeOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().remove(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setProceso(null);

		return oeeDetalleMediosConDefecto;
	}


	//bi-directional many-to-one association to OeeParada
	@OneToMany(mappedBy="proceso")
	public List<OeeParada> getOeeParadas() {
		return this.oeeParadas;
	}

	public void setOeeParadas(List<OeeParada> oeeParadas) {
		this.oeeParadas = oeeParadas;
	}

	public OeeParada addOeeParada(OeeParada oeeParada) {
		getOeeParadas().add(oeeParada);
		oeeParada.setProceso(this);

		return oeeParada;
	}

	public OeeParada removeOeeParada(OeeParada oeeParada) {
		getOeeParadas().remove(oeeParada);
		oeeParada.setProceso(null);

		return oeeParada;
	}


	//bi-directional many-to-one association to OeePeriodoBaseObjetivo
	@OneToMany(mappedBy="proceso")
	public List<OeePeriodoBaseObjetivo> getOeePeriodoBaseObjetivos() {
		return this.oeePeriodoBaseObjetivos;
	}

	public void setOeePeriodoBaseObjetivos(List<OeePeriodoBaseObjetivo> oeePeriodoBaseObjetivos) {
		this.oeePeriodoBaseObjetivos = oeePeriodoBaseObjetivos;
	}

	public OeePeriodoBaseObjetivo addOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		getOeePeriodoBaseObjetivos().add(oeePeriodoBaseObjetivo);
		oeePeriodoBaseObjetivo.setProceso(this);

		return oeePeriodoBaseObjetivo;
	}

	public OeePeriodoBaseObjetivo removeOeePeriodoBaseObjetivo(OeePeriodoBaseObjetivo oeePeriodoBaseObjetivo) {
		getOeePeriodoBaseObjetivos().remove(oeePeriodoBaseObjetivo);
		oeePeriodoBaseObjetivo.setProceso(null);

		return oeePeriodoBaseObjetivo;
	}


	//bi-directional many-to-one association to ProcesoAperturaCierre
	@OneToMany(mappedBy="proceso")
	public List<ProcesoAperturaCierre> getProcesoAperturaCierres() {
		return this.procesoAperturaCierres;
	}

	public void setProcesoAperturaCierres(List<ProcesoAperturaCierre> procesoAperturaCierres) {
		this.procesoAperturaCierres = procesoAperturaCierres;
	}

	public ProcesoAperturaCierre addProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		getProcesoAperturaCierres().add(procesoAperturaCierre);
		procesoAperturaCierre.setProceso(this);

		return procesoAperturaCierre;
	}

	public ProcesoAperturaCierre removeProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		getProcesoAperturaCierres().remove(procesoAperturaCierre);
		procesoAperturaCierre.setProceso(null);

		return procesoAperturaCierre;
	}


	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="proceso")
	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setProceso(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setProceso(null);

		return reporte;
	}

}