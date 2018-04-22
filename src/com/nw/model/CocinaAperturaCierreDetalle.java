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
public class CocinaAperturaCierreDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	//bi-directional many-to-one association to Cocina
	@ManyToOne
	@JoinColumn(name="idcocina")
	private Cocina cocina;

	//bi-directional many-to-one association to CocinaChoqueTermico
	@ManyToOne
	@JoinColumn(name="idcocinachoquetermico")
	private CocinaChoqueTermico cocinaChoqueTermico;

	//bi-directional many-to-one association to CocinaCurva
	@ManyToOne
	@JoinColumn(name="idcocinacurva")
	private CocinaCurva cocinaCurva;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to CocinaProcesoControlEspinaDetalle
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	private List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles;

	//bi-directional many-to-one association to ControlFichaBatch
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	private List<ControlFichaBatch> controlFichaBatches;

	//bi-directional many-to-one association to CuartoChillroomCocinadaDetalle
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	private List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles;

	//bi-directional many-to-one association to EvisceradoCocheModificacion
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	private List<EvisceradoCocheModificacion> evisceradoCocheModificacions;

	//bi-directional many-to-one association to EvisceradoDetalleProcesoCoche
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	private List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches;

	//bi-directional many-to-one association to LimpiezaDetalleProcesoCocheTemperaturaBatch
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	private List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches;

	//bi-directional many-to-one association to RociadoCicloDetalle
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	private List<RociadoCicloDetalle> rociadoCicloDetalles;

	//bi-directional many-to-one association to RociadoCocinadaDetalle
	@OneToMany(mappedBy="cocinaAperturaCierreDetalle")
	private List<RociadoCocinadaDetalle> rociadoCocinadaDetalles;

	public CocinaAperturaCierreDetalle() {
	}

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

	public Cocina getCocina() {
		return this.cocina;
	}

	public void setCocina(Cocina cocina) {
		this.cocina = cocina;
	}

	public CocinaChoqueTermico getCocinaChoqueTermico() {
		return this.cocinaChoqueTermico;
	}

	public void setCocinaChoqueTermico(CocinaChoqueTermico cocinaChoqueTermico) {
		this.cocinaChoqueTermico = cocinaChoqueTermico;
	}

	public CocinaCurva getCocinaCurva() {
		return this.cocinaCurva;
	}

	public void setCocinaCurva(CocinaCurva cocinaCurva) {
		this.cocinaCurva = cocinaCurva;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<CocinaProcesoControlEspinaDetalle> getCocinaProcesoControlEspinaDetalles() {
		return this.cocinaProcesoControlEspinaDetalles;
	}

	public void setCocinaProcesoControlEspinaDetalles(List<CocinaProcesoControlEspinaDetalle> cocinaProcesoControlEspinaDetalles) {
		this.cocinaProcesoControlEspinaDetalles = cocinaProcesoControlEspinaDetalles;
	}

	public List<ControlFichaBatch> getControlFichaBatches() {
		return this.controlFichaBatches;
	}

	public void setControlFichaBatches(List<ControlFichaBatch> controlFichaBatches) {
		this.controlFichaBatches = controlFichaBatches;
	}

	public List<CuartoChillroomCocinadaDetalle> getCuartoChillroomCocinadaDetalles() {
		return this.cuartoChillroomCocinadaDetalles;
	}

	public void setCuartoChillroomCocinadaDetalles(List<CuartoChillroomCocinadaDetalle> cuartoChillroomCocinadaDetalles) {
		this.cuartoChillroomCocinadaDetalles = cuartoChillroomCocinadaDetalles;
	}

	public List<EvisceradoCocheModificacion> getEvisceradoCocheModificacions() {
		return this.evisceradoCocheModificacions;
	}

	public void setEvisceradoCocheModificacions(List<EvisceradoCocheModificacion> evisceradoCocheModificacions) {
		this.evisceradoCocheModificacions = evisceradoCocheModificacions;
	}

	public List<EvisceradoDetalleProcesoCoche> getEvisceradoDetalleProcesoCoches() {
		return this.evisceradoDetalleProcesoCoches;
	}

	public void setEvisceradoDetalleProcesoCoches(List<EvisceradoDetalleProcesoCoche> evisceradoDetalleProcesoCoches) {
		this.evisceradoDetalleProcesoCoches = evisceradoDetalleProcesoCoches;
	}

	public List<LimpiezaDetalleProcesoCocheTemperaturaBatch> getLimpiezaDetalleProcesoCocheTemperaturaBatches() {
		return this.limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

	public void setLimpiezaDetalleProcesoCocheTemperaturaBatches(List<LimpiezaDetalleProcesoCocheTemperaturaBatch> limpiezaDetalleProcesoCocheTemperaturaBatches) {
		this.limpiezaDetalleProcesoCocheTemperaturaBatches = limpiezaDetalleProcesoCocheTemperaturaBatches;
	}

	public List<RociadoCicloDetalle> getRociadoCicloDetalles() {
		return this.rociadoCicloDetalles;
	}

	public void setRociadoCicloDetalles(List<RociadoCicloDetalle> rociadoCicloDetalles) {
		this.rociadoCicloDetalles = rociadoCicloDetalles;
	}

	public List<RociadoCocinadaDetalle> getRociadoCocinadaDetalles() {
		return this.rociadoCocinadaDetalles;
	}

	public void setRociadoCocinadaDetalles(List<RociadoCocinadaDetalle> rociadoCocinadaDetalles) {
		this.rociadoCocinadaDetalles = rociadoCocinadaDetalles;
	}

}