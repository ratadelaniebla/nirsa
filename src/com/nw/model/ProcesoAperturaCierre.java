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
@NamedQuery(name="ProcesoAperturaCierre.findAll", query="SELECT p FROM ProcesoAperturaCierre p")
public class ProcesoAperturaCierre implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idprocesoaperturacierre;
	private Integer estado;
	private Timestamp fechaapertura;
	private Timestamp fechacierre;
	private List<ControlBatchProceso> controlBatchProcesos;
	private List<DescongeladoProceso> descongeladoProcesos;
	private List<EnvasadoProceso> envasadoProcesos;
	private List<EspecialidadesProceso> especialidadesProcesos;
	private List<EvisceradoProceso> evisceradoProcesos;
	private List<LimpiezaProceso> limpiezaProcesos;
	private List<LonjasProceso> lonjasProcesos;
	private List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos;
	private List<OeeDetalleParada> oeeDetalleParadas;
	private List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	private List<PanzasProceso> panzasProcesos;
	private List<PouchProceso> pouchProcesos;
	private Proceso proceso;
	private List<RackeoProceso> rackeoProcesos;
	private List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches;
	private List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas;

	public ProcesoAperturaCierre() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to ControlBatchProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<ControlBatchProceso> getControlBatchProcesos() {
		return this.controlBatchProcesos;
	}

	public void setControlBatchProcesos(List<ControlBatchProceso> controlBatchProcesos) {
		this.controlBatchProcesos = controlBatchProcesos;
	}

	public ControlBatchProceso addControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		getControlBatchProcesos().add(controlBatchProceso);
		controlBatchProceso.setProcesoAperturaCierre(this);

		return controlBatchProceso;
	}

	public ControlBatchProceso removeControlBatchProceso(ControlBatchProceso controlBatchProceso) {
		getControlBatchProcesos().remove(controlBatchProceso);
		controlBatchProceso.setProcesoAperturaCierre(null);

		return controlBatchProceso;
	}


	//bi-directional many-to-one association to DescongeladoProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<DescongeladoProceso> getDescongeladoProcesos() {
		return this.descongeladoProcesos;
	}

	public void setDescongeladoProcesos(List<DescongeladoProceso> descongeladoProcesos) {
		this.descongeladoProcesos = descongeladoProcesos;
	}

	public DescongeladoProceso addDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		getDescongeladoProcesos().add(descongeladoProceso);
		descongeladoProceso.setProcesoAperturaCierre(this);

		return descongeladoProceso;
	}

	public DescongeladoProceso removeDescongeladoProceso(DescongeladoProceso descongeladoProceso) {
		getDescongeladoProcesos().remove(descongeladoProceso);
		descongeladoProceso.setProcesoAperturaCierre(null);

		return descongeladoProceso;
	}


	//bi-directional many-to-one association to EnvasadoProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<EnvasadoProceso> getEnvasadoProcesos() {
		return this.envasadoProcesos;
	}

	public void setEnvasadoProcesos(List<EnvasadoProceso> envasadoProcesos) {
		this.envasadoProcesos = envasadoProcesos;
	}

	public EnvasadoProceso addEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().add(envasadoProceso);
		envasadoProceso.setProcesoAperturaCierre(this);

		return envasadoProceso;
	}

	public EnvasadoProceso removeEnvasadoProceso(EnvasadoProceso envasadoProceso) {
		getEnvasadoProcesos().remove(envasadoProceso);
		envasadoProceso.setProcesoAperturaCierre(null);

		return envasadoProceso;
	}


	//bi-directional many-to-one association to EspecialidadesProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<EspecialidadesProceso> getEspecialidadesProcesos() {
		return this.especialidadesProcesos;
	}

	public void setEspecialidadesProcesos(List<EspecialidadesProceso> especialidadesProcesos) {
		this.especialidadesProcesos = especialidadesProcesos;
	}

	public EspecialidadesProceso addEspecialidadesProceso(EspecialidadesProceso especialidadesProceso) {
		getEspecialidadesProcesos().add(especialidadesProceso);
		especialidadesProceso.setProcesoAperturaCierre(this);

		return especialidadesProceso;
	}

	public EspecialidadesProceso removeEspecialidadesProceso(EspecialidadesProceso especialidadesProceso) {
		getEspecialidadesProcesos().remove(especialidadesProceso);
		especialidadesProceso.setProcesoAperturaCierre(null);

		return especialidadesProceso;
	}


	//bi-directional many-to-one association to EvisceradoProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<EvisceradoProceso> getEvisceradoProcesos() {
		return this.evisceradoProcesos;
	}

	public void setEvisceradoProcesos(List<EvisceradoProceso> evisceradoProcesos) {
		this.evisceradoProcesos = evisceradoProcesos;
	}

	public EvisceradoProceso addEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		getEvisceradoProcesos().add(evisceradoProceso);
		evisceradoProceso.setProcesoAperturaCierre(this);

		return evisceradoProceso;
	}

	public EvisceradoProceso removeEvisceradoProceso(EvisceradoProceso evisceradoProceso) {
		getEvisceradoProcesos().remove(evisceradoProceso);
		evisceradoProceso.setProcesoAperturaCierre(null);

		return evisceradoProceso;
	}


	//bi-directional many-to-one association to LimpiezaProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<LimpiezaProceso> getLimpiezaProcesos() {
		return this.limpiezaProcesos;
	}

	public void setLimpiezaProcesos(List<LimpiezaProceso> limpiezaProcesos) {
		this.limpiezaProcesos = limpiezaProcesos;
	}

	public LimpiezaProceso addLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().add(limpiezaProceso);
		limpiezaProceso.setProcesoAperturaCierre(this);

		return limpiezaProceso;
	}

	public LimpiezaProceso removeLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		getLimpiezaProcesos().remove(limpiezaProceso);
		limpiezaProceso.setProcesoAperturaCierre(null);

		return limpiezaProceso;
	}


	//bi-directional many-to-one association to LonjasProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<LonjasProceso> getLonjasProcesos() {
		return this.lonjasProcesos;
	}

	public void setLonjasProcesos(List<LonjasProceso> lonjasProcesos) {
		this.lonjasProcesos = lonjasProcesos;
	}

	public LonjasProceso addLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().add(lonjasProceso);
		lonjasProceso.setProcesoAperturaCierre(this);

		return lonjasProceso;
	}

	public LonjasProceso removeLonjasProceso(LonjasProceso lonjasProceso) {
		getLonjasProcesos().remove(lonjasProceso);
		lonjasProceso.setProcesoAperturaCierre(null);

		return lonjasProceso;
	}


	//bi-directional many-to-one association to OeeDetalleMediosConDefecto
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<OeeDetalleMediosConDefecto> getOeeDetalleMediosConDefectos() {
		return this.oeeDetalleMediosConDefectos;
	}

	public void setOeeDetalleMediosConDefectos(List<OeeDetalleMediosConDefecto> oeeDetalleMediosConDefectos) {
		this.oeeDetalleMediosConDefectos = oeeDetalleMediosConDefectos;
	}

	public OeeDetalleMediosConDefecto addOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().add(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setProcesoAperturaCierre(this);

		return oeeDetalleMediosConDefecto;
	}

	public OeeDetalleMediosConDefecto removeOeeDetalleMediosConDefecto(OeeDetalleMediosConDefecto oeeDetalleMediosConDefecto) {
		getOeeDetalleMediosConDefectos().remove(oeeDetalleMediosConDefecto);
		oeeDetalleMediosConDefecto.setProcesoAperturaCierre(null);

		return oeeDetalleMediosConDefecto;
	}


	//bi-directional many-to-one association to OeeDetalleParada
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<OeeDetalleParada> getOeeDetalleParadas() {
		return this.oeeDetalleParadas;
	}

	public void setOeeDetalleParadas(List<OeeDetalleParada> oeeDetalleParadas) {
		this.oeeDetalleParadas = oeeDetalleParadas;
	}

	public OeeDetalleParada addOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		getOeeDetalleParadas().add(oeeDetalleParada);
		oeeDetalleParada.setProcesoAperturaCierre(this);

		return oeeDetalleParada;
	}

	public OeeDetalleParada removeOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		getOeeDetalleParadas().remove(oeeDetalleParada);
		oeeDetalleParada.setProcesoAperturaCierre(null);

		return oeeDetalleParada;
	}


	//bi-directional many-to-one association to OeeEnvasadoCabeceraVelocidadMaquinaCerradora
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras() {
		return this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public void setOeeEnvasadoCabeceraVelocidadMaquinaCerradoras(List<OeeEnvasadoCabeceraVelocidadMaquinaCerradora> oeeEnvasadoCabeceraVelocidadMaquinaCerradoras) {
		this.oeeEnvasadoCabeceraVelocidadMaquinaCerradoras = oeeEnvasadoCabeceraVelocidadMaquinaCerradoras;
	}

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora addOeeEnvasadoCabeceraVelocidadMaquinaCerradora(OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras().add(oeeEnvasadoCabeceraVelocidadMaquinaCerradora);
		oeeEnvasadoCabeceraVelocidadMaquinaCerradora.setProcesoAperturaCierre(this);

		return oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}

	public OeeEnvasadoCabeceraVelocidadMaquinaCerradora removeOeeEnvasadoCabeceraVelocidadMaquinaCerradora(OeeEnvasadoCabeceraVelocidadMaquinaCerradora oeeEnvasadoCabeceraVelocidadMaquinaCerradora) {
		getOeeEnvasadoCabeceraVelocidadMaquinaCerradoras().remove(oeeEnvasadoCabeceraVelocidadMaquinaCerradora);
		oeeEnvasadoCabeceraVelocidadMaquinaCerradora.setProcesoAperturaCierre(null);

		return oeeEnvasadoCabeceraVelocidadMaquinaCerradora;
	}


	//bi-directional many-to-one association to PanzasProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<PanzasProceso> getPanzasProcesos() {
		return this.panzasProcesos;
	}

	public void setPanzasProcesos(List<PanzasProceso> panzasProcesos) {
		this.panzasProcesos = panzasProcesos;
	}

	public PanzasProceso addPanzasProceso(PanzasProceso panzasProceso) {
		getPanzasProcesos().add(panzasProceso);
		panzasProceso.setProcesoAperturaCierre(this);

		return panzasProceso;
	}

	public PanzasProceso removePanzasProceso(PanzasProceso panzasProceso) {
		getPanzasProcesos().remove(panzasProceso);
		panzasProceso.setProcesoAperturaCierre(null);

		return panzasProceso;
	}


	//bi-directional many-to-one association to PouchProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<PouchProceso> getPouchProcesos() {
		return this.pouchProcesos;
	}

	public void setPouchProcesos(List<PouchProceso> pouchProcesos) {
		this.pouchProcesos = pouchProcesos;
	}

	public PouchProceso addPouchProceso(PouchProceso pouchProceso) {
		getPouchProcesos().add(pouchProceso);
		pouchProceso.setProcesoAperturaCierre(this);

		return pouchProceso;
	}

	public PouchProceso removePouchProceso(PouchProceso pouchProceso) {
		getPouchProcesos().remove(pouchProceso);
		pouchProceso.setProcesoAperturaCierre(null);

		return pouchProceso;
	}


	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}


	//bi-directional many-to-one association to RackeoProceso
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<RackeoProceso> getRackeoProcesos() {
		return this.rackeoProcesos;
	}

	public void setRackeoProcesos(List<RackeoProceso> rackeoProcesos) {
		this.rackeoProcesos = rackeoProcesos;
	}

	public RackeoProceso addRackeoProceso(RackeoProceso rackeoProceso) {
		getRackeoProcesos().add(rackeoProceso);
		rackeoProceso.setProcesoAperturaCierre(this);

		return rackeoProceso;
	}

	public RackeoProceso removeRackeoProceso(RackeoProceso rackeoProceso) {
		getRackeoProcesos().remove(rackeoProceso);
		rackeoProceso.setProcesoAperturaCierre(null);

		return rackeoProceso;
	}


	//bi-directional many-to-one association to TunelDetalleProcesoCoche
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<TunelDetalleProcesoCoche> getTunelDetalleProcesoCoches() {
		return this.tunelDetalleProcesoCoches;
	}

	public void setTunelDetalleProcesoCoches(List<TunelDetalleProcesoCoche> tunelDetalleProcesoCoches) {
		this.tunelDetalleProcesoCoches = tunelDetalleProcesoCoches;
	}

	public TunelDetalleProcesoCoche addTunelDetalleProcesoCoch(TunelDetalleProcesoCoche tunelDetalleProcesoCoch) {
		getTunelDetalleProcesoCoches().add(tunelDetalleProcesoCoch);
		tunelDetalleProcesoCoch.setProcesoAperturaCierre(this);

		return tunelDetalleProcesoCoch;
	}

	public TunelDetalleProcesoCoche removeTunelDetalleProcesoCoch(TunelDetalleProcesoCoche tunelDetalleProcesoCoch) {
		getTunelDetalleProcesoCoches().remove(tunelDetalleProcesoCoch);
		tunelDetalleProcesoCoch.setProcesoAperturaCierre(null);

		return tunelDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to TunelDetalleProcesoCocheSalida
	@OneToMany(mappedBy="procesoAperturaCierre")
	public List<TunelDetalleProcesoCocheSalida> getTunelDetalleProcesoCocheSalidas() {
		return this.tunelDetalleProcesoCocheSalidas;
	}

	public void setTunelDetalleProcesoCocheSalidas(List<TunelDetalleProcesoCocheSalida> tunelDetalleProcesoCocheSalidas) {
		this.tunelDetalleProcesoCocheSalidas = tunelDetalleProcesoCocheSalidas;
	}

	public TunelDetalleProcesoCocheSalida addTunelDetalleProcesoCocheSalida(TunelDetalleProcesoCocheSalida tunelDetalleProcesoCocheSalida) {
		getTunelDetalleProcesoCocheSalidas().add(tunelDetalleProcesoCocheSalida);
		tunelDetalleProcesoCocheSalida.setProcesoAperturaCierre(this);

		return tunelDetalleProcesoCocheSalida;
	}

	public TunelDetalleProcesoCocheSalida removeTunelDetalleProcesoCocheSalida(TunelDetalleProcesoCocheSalida tunelDetalleProcesoCocheSalida) {
		getTunelDetalleProcesoCocheSalidas().remove(tunelDetalleProcesoCocheSalida);
		tunelDetalleProcesoCocheSalida.setProcesoAperturaCierre(null);

		return tunelDetalleProcesoCocheSalida;
	}

}