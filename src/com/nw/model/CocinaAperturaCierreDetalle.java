package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the cocina_apertura_cierre_detalle database table.
 * 
 */
@Entity
@Table(name="cocina_apertura_cierre_detalle")
@NamedQuery(name="CocinaAperturaCierreDetalle.findAll", query="SELECT c FROM CocinaAperturaCierreDetalle c")
public class CocinaAperturaCierreDetalle implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcocinaaperturacierredetalle;
	private double corte;
	private Integer estado;
	private Integer estadococinada;
	private Timestamp fechafincocinada;
	private Timestamp fechartdcocinada;
	private Integer finproceso;
	private Integer graficada;
	private Timestamp horafin;
	private Timestamp horainicio;
	private Integer numerococinada;
	private Integer numerococinadageneral;
	private String observacion;
	private double temperatura;
	private Cocina cocina;
	private CocinaChoqueTermico cocinaChoqueTermico;
	private CocinaCurva cocinaCurva;
	private Produccion produccion;
	private Usuario usuario;
	private List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles;
	private List<ControlFichaBatch> controlFichaBatches;
	private List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles;
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;
	private List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches;
	private List<RociadoCicloDetalle> rociadoCicloDetalles;
	private List<RociadoCocinadaDetalle> rociadoCocinadaDetalles;

	public CocinaAperturaCierreDetalle() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcocinaaperturacierredetalle() {
		return this.idcocinaaperturacierredetalle;
	}

	public void setIdcocinaaperturacierredetalle(Long idcocinaaperturacierredetalle) {
		this.idcocinaaperturacierredetalle = idcocinaaperturacierredetalle;
	}


	public double getCorte() {
		return this.corte;
	}

	public void setCorte(double corte) {
		this.corte = corte;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Integer getEstadococinada() {
		return this.estadococinada;
	}

	public void setEstadococinada(Integer estadococinada) {
		this.estadococinada = estadococinada;
	}


	public Timestamp getFechafincocinada() {
		return this.fechafincocinada;
	}

	public void setFechafincocinada(Timestamp fechafincocinada) {
		this.fechafincocinada = fechafincocinada;
	}


	public Timestamp getFechartdcocinada() {
		return this.fechartdcocinada;
	}

	public void setFechartdcocinada(Timestamp fechartdcocinada) {
		this.fechartdcocinada = fechartdcocinada;
	}


	public Integer getFinproceso() {
		return this.finproceso;
	}

	public void setFinproceso(Integer finproceso) {
		this.finproceso = finproceso;
	}


	public Integer getGraficada() {
		return this.graficada;
	}

	public void setGraficada(Integer graficada) {
		this.graficada = graficada;
	}


	public Timestamp getHorafin() {
		return this.horafin;
	}

	public void setHorafin(Timestamp horafin) {
		this.horafin = horafin;
	}


	public Timestamp getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Timestamp horainicio) {
		this.horainicio = horainicio;
	}


	public Integer getNumerococinada() {
		return this.numerococinada;
	}

	public void setNumerococinada(Integer numerococinada) {
		this.numerococinada = numerococinada;
	}


	public Integer getNumerococinadageneral() {
		return this.numerococinadageneral;
	}

	public void setNumerococinadageneral(Integer numerococinadageneral) {
		this.numerococinadageneral = numerococinadageneral;
	}


	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public double getTemperatura() {
		return this.temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}


	//bi-directional many-to-one association to Cocina
	@ManyToOne
	@JoinColumn(name="idcocina")
	public Cocina getCocina() {
		return this.cocina;
	}

	public void setCocina(Cocina cocina) {
		this.cocina = cocina;
	}


	//bi-directional many-to-one association to CocinaChoqueTermico
	@ManyToOne
	@JoinColumn(name="idcocinachoquetermico")
	public CocinaChoqueTermico getCocinaChoqueTermico() {
		return this.cocinaChoqueTermico;
	}

	public void setCocinaChoqueTermico(CocinaChoqueTermico cocinaChoqueTermico) {
		this.cocinaChoqueTermico = cocinaChoqueTermico;
	}


	//bi-directional many-to-one association to CocinaCurva
	@ManyToOne
	@JoinColumn(name="idcocinacurva")
	public CocinaCurva getCocinaCurva() {
		return this.cocinaCurva;
	}

	public void setCocinaCurva(CocinaCurva cocinaCurva) {
		this.cocinaCurva = cocinaCurva;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to CocinaProcesoControlEspinaDetalle
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	public List<CocinaProcesoControlEspinaDetalle> getCocinaProcesoControlEspinaDetalles() {
		return this.cocinaProcesoControlEspinaDetalles;
	}

	public void setCocinaProcesoControlEspinaDetalles(List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles) {
		this.cocinaProcesoControlEspinaDetalles = cocinaProcesoControlEspinaDetalles;
	}

	public CocinaProcesoControlEspinaDetalle addCocinaProcesoControlEspinaDetalle(CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle) {
		getCocinaProcesoControlEspinaDetalles().add(cocinaProcesoControlEspinaDetalle);
		cocinaProcesoControlEspinaDetalle.setCocinaAperturaCierreDetalle(this);

		return cocinaProcesoControlEspinaDetalle;
	}

	public CocinaProcesoControlEspinaDetalle removeCocinaProcesoControlEspinaDetalle(CocinaProcesoControlEspinaDetalle cocinaProcesoControlEspinaDetalle) {
		getCocinaProcesoControlEspinaDetalles().remove(cocinaProcesoControlEspinaDetalle);
		cocinaProcesoControlEspinaDetalle.setCocinaAperturaCierreDetalle(null);

		return cocinaProcesoControlEspinaDetalle;
	}


	//bi-directional many-to-one association to ControlFichaBatch
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	public List<ControlFichaBatch> getControlFichaBatches() {
		return this.controlFichaBatches;
	}

	public void setControlFichaBatches(List<ControlFichaBatch> controlFichaBatches) {
		this.controlFichaBatches = controlFichaBatches;
	}

	public ControlFichaBatch addControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		getControlFichaBatches().add(controlFichaBatch);
		controlFichaBatch.setCocinaAperturaCierreDetalle(this);

		return controlFichaBatch;
	}

	public ControlFichaBatch removeControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		getControlFichaBatches().remove(controlFichaBatch);
		controlFichaBatch.setCocinaAperturaCierreDetalle(null);

		return controlFichaBatch;
	}


	//bi-directional many-to-one association to CuartoChillroomCocinadaDetalle
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	public List<CuartoChillroomCocinadaDetalle> getCuartoChillroomCocinadaDetalles() {
		return this.cuartoChillroomCocinadaDetalles;
	}

	public void setCuartoChillroomCocinadaDetalles(List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles) {
		this.cuartoChillroomCocinadaDetalles = cuartoChillroomCocinadaDetalles;
	}

	public CuartoChillroomCocinadaDetalle addCuartoChillroomCocinadaDetalle(CuartoChillroomCocinadaDetalle cuartoChillroomCocinadaDetalle) {
		getCuartoChillroomCocinadaDetalles().add(cuartoChillroomCocinadaDetalle);
		cuartoChillroomCocinadaDetalle.setCocinaAperturaCierreDetalle(this);

		return cuartoChillroomCocinadaDetalle;
	}

	public CuartoChillroomCocinadaDetalle removeCuartoChillroomCocinadaDetalle(CuartoChillroomCocinadaDetalle cuartoChillroomCocinadaDetalle) {
		getCuartoChillroomCocinadaDetalles().remove(cuartoChillroomCocinadaDetalle);
		cuartoChillroomCocinadaDetalle.setCocinaAperturaCierreDetalle(null);

		return cuartoChillroomCocinadaDetalle;
	}


	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public EvisceradoCocheModificacion addEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().add(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setCocinaAperturaCierreDetalle(this);

		return evisceradoCocheModificacion;
	}

	public EvisceradoCocheModificacion removeEvisceradoCocheModificacion(EvisceradoCocheModificacion evisceradoCocheModificacion) {
		getEvisceradoCocheModificacions().remove(evisceradoCocheModificacion);
		evisceradoCocheModificacion.setCocinaAperturaCierreDetalle(null);

		return evisceradoCocheModificacion;
	}


	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public EvisceradoDetalleProcesoCoche addEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().add(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setCocinaAperturaCierreDetalle(this);

		return evisceradoDetalleProcesoCoch;
	}

	public EvisceradoDetalleProcesoCoche removeEvisceradoDetalleProcesoCoch(EvisceradoDetalleProcesoCoche evisceradoDetalleProcesoCoch) {
		getEvisceradoDetalleProcesoCoches().remove(evisceradoDetalleProcesoCoch);
		evisceradoDetalleProcesoCoch.setCocinaAperturaCierreDetalle(null);

		return evisceradoDetalleProcesoCoch;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCocheTemperaturaBatch
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	public List<LimpiezaDetalleProcesoCocheTemperaturaBatch> getLimpiezaDetalleProcesoCocheTemperaturaBatches() {
		return this.limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

	public void setLimpiezaDetalleProcesoCocheTemperaturaBatches(List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches) {
		this.limpiezaDetalleProcesoCocheTemperaturaBatches = limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

	public LimpiezaDetalleProcesoCocheTemperaturaBatch addLimpiezaDetalleProcesoCocheTemperaturaBatch(LimpiezaDetalleProcesoCocheTemperaturaBatch limpiezaDetalleProcesoCocheTemperaturaBatch) {
		getLimpiezaDetalleProcesoCocheTemperaturaBatches().add(limpiezaDetalleProcesoCocheTemperaturaBatch);
		limpiezaDetalleProcesoCocheTemperaturaBatch.setCocinaAperturaCierreDetalle(this);

		return limpiezaDetalleProcesoCocheTemperaturaBatch;
	}

	public LimpiezaDetalleProcesoCocheTemperaturaBatch removeLimpiezaDetalleProcesoCocheTemperaturaBatch(LimpiezaDetalleProcesoCocheTemperaturaBatch limpiezaDetalleProcesoCocheTemperaturaBatch) {
		getLimpiezaDetalleProcesoCocheTemperaturaBatches().remove(limpiezaDetalleProcesoCocheTemperaturaBatch);
		limpiezaDetalleProcesoCocheTemperaturaBatch.setCocinaAperturaCierreDetalle(null);

		return limpiezaDetalleProcesoCocheTemperaturaBatch;
	}


	//bi-directional many-to-one association to RociadoCicloDetalle
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	public List<RociadoCicloDetalle> getRociadoCicloDetalles() {
		return this.rociadoCicloDetalles;
	}

	public void setRociadoCicloDetalles(List<RociadoCicloDetalle> rociadoCicloDetalles) {
		this.rociadoCicloDetalles = rociadoCicloDetalles;
	}

	public RociadoCicloDetalle addRociadoCicloDetalle(RociadoCicloDetalle rociadoCicloDetalle) {
		getRociadoCicloDetalles().add(rociadoCicloDetalle);
		rociadoCicloDetalle.setCocinaAperturaCierreDetalle(this);

		return rociadoCicloDetalle;
	}

	public RociadoCicloDetalle removeRociadoCicloDetalle(RociadoCicloDetalle rociadoCicloDetalle) {
		getRociadoCicloDetalles().remove(rociadoCicloDetalle);
		rociadoCicloDetalle.setCocinaAperturaCierreDetalle(null);

		return rociadoCicloDetalle;
	}


	//bi-directional many-to-one association to RociadoCocinadaDetalle
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	public List<RociadoCocinadaDetalle> getRociadoCocinadaDetalles() {
		return this.rociadoCocinadaDetalles;
	}

	public void setRociadoCocinadaDetalles(List<RociadoCocinadaDetalle> rociadoCocinadaDetalles) {
		this.rociadoCocinadaDetalles = rociadoCocinadaDetalles;
	}

	public RociadoCocinadaDetalle addRociadoCocinadaDetalle(RociadoCocinadaDetalle rociadoCocinadaDetalle) {
		getRociadoCocinadaDetalles().add(rociadoCocinadaDetalle);
		rociadoCocinadaDetalle.setCocinaAperturaCierreDetalle(this);

		return rociadoCocinadaDetalle;
	}

	public RociadoCocinadaDetalle removeRociadoCocinadaDetalle(RociadoCocinadaDetalle rociadoCocinadaDetalle) {
		getRociadoCocinadaDetalles().remove(rociadoCocinadaDetalle);
		rociadoCocinadaDetalle.setCocinaAperturaCierreDetalle(null);

		return rociadoCocinadaDetalle;
	}

}