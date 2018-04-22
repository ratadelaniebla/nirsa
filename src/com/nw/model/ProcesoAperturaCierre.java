package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the proceso_apertura_cierre database table.
 * 
 */
@Entity
@Table(name="proceso_apertura_cierre")
public class ProcesoAperturaCierre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idprocesoaperturacierre;

	private Integer estado;

	private Timestamp fechaapertura;

	private Timestamp fechacierre;

	//bi-directional many-to-one association to ControlBatchProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<ControlBatchProceso> controlBatchProcesos;

	//bi-directional many-to-one association to DescongeladoProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<DescongeladoProceso> descongeladoProcesos;

	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<EnvasadoProceso> envasadoProcesos;

	//bi-directional many-to-one association to EspecialidadesProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<EspecialidadesProceso> especialidadesProcesos;

	//bi-directional many-to-one association to EvisceradoProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<EvisceradoProceso> evisceradoProcesos;

	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<LimpiezaProceso> limpiezaProcesos;

	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<LonjasProceso> lonjasProcesos;

	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;

	//bi-directional many-to-one association to OeeDetalleParada
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<OeeDetalleParada> oeeDetalleParadas;

	//bi-directional many-to-one association to OeeEnvasadoCabeceraVelocidadMaquinaCerradora
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;

	//bi-directional many-to-one association to PanzasProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<PanzasProceso> panzasProcesos;

	//bi-directional many-to-one association to PouchProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<PouchProceso> pouchProcesos;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	//bi-directional many-to-one association to RackeoProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<RackeoProceso> rackeoProcesos;

	//bi-directional many-to-one association to TunelDetalleProcesoCoche
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches;

	//bi-directional many-to-one association to TunelDetalleProcesoCocheSalida
	@OneToMany(mappedBy="procesoAperturaCierre")
	private List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas;

	public ProcesoAperturaCierre() {
	}

	public Long getIdprocesoaperturacierre() {
		return this.idprocesoaperturacierre;
	}

	public void setIdprocesoaperturacierre(Long idprocesoaperturacierre) {
		this.idprocesoaperturacierre = idprocesoaperturacierre;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaapertura() {
		return this.fechaapertura;
	}

	public void setFechaapertura(Timestamp fechaapertura) {
		this.fechaapertura = fechaapertura;
	}

	public Timestamp getFechacierre() {
		return this.fechacierre;
	}

	public void setFechacierre(Timestamp fechacierre) {
		this.fechacierre = fechacierre;
	}

	public List<ControlBatchProceso> getControlBatchProcesos() {
		return this.controlBatchProcesos;
	}

	public void setControlBatchProcesos(List<ControlBatchProceso> controlBatchProcesos) {
		this.controlBatchProcesos = controlBatchProcesos;
	}

	public List<DescongeladoProceso> getDescongeladoProcesos() {
		return this.descongeladoProcesos;
	}

	public void setDescongeladoProcesos(List<DescongeladoProceso> descongeladoProcesos) {
		this.descongeladoProcesos = descongeladoProcesos;
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

	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
	}

	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
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

	public List<PanzasProceso> getPanzasProcesos() {
		return this.panzasProcesos;
	}

	public void setPanzasProcesos(List<PanzasProceso> panzasProcesos) {
		this.panzasProcesos = panzasProcesos;
	}

	public List<PouchProceso> getPouchProcesos() {
		return this.pouchProcesos;
	}

	public void setPouchProcesos(List<PouchProceso> pouchProcesos) {
		this.pouchProcesos = pouchProcesos;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	public List<RackeoProceso> getRackeoProcesos() {
		return this.rackeoProcesos;
	}

	public void setRackeoProcesos(List<RackeoProceso> rackeoProcesos) {
		this.rackeoProcesos = rackeoProcesos;
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

}