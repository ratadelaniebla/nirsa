package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the oee_detalle_parada database table.
 * 
 */
@Entity
@Table(name="oee_detalle_parada")
public class OeeDetalleParada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_detalle_parada")
	private Long idOeeDetalleParada;

	@Column(name="estandar_modificado")
	private Boolean estandarModificado;

	@Column(name="fecha_hora_fin")
	private Timestamp fechaHoraFin;

	@Column(name="fecha_hora_inicio")
	private Timestamp fechaHoraInicio;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	private String observacion;

	@Column(name="tiempo_descontar")
	private double tiempoDescontar;

	//bi-directional many-to-one association to OeeParada
	@ManyToOne
	@JoinColumn(name="id_oee_parada")
	private OeeParada oeeParada;

	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	private ProcesoAperturaCierre procesoAperturaCierre;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to OeeDetalleParadaEnvasado
	@OneToMany(mappedBy="oeeDetalleParada")
	private List<OeeDetalleParadaEnvasado> oeeDetalleParadaEnvasados;

	//bi-directional many-to-one association to OeeDetalleParadaLimpieza
	@OneToMany(mappedBy="oeeDetalleParada")
	private List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas;

	//bi-directional many-to-one association to OeeDetalleParadaLonja
	@OneToMany(mappedBy="oeeDetalleParada")
	private List<OeeDetalleParadaLonja> oeeDetalleParadaLonjas;

	//bi-directional many-to-one association to OeeDetalleParadaRackeo
	@OneToMany(mappedBy="oeeDetalleParada")
	private List<OeeDetalleParadaRackeo> oeeDetalleParadaRackeos;

	public OeeDetalleParada() {
	}

	public Long getIdOeeDetalleParada() {
		return this.idOeeDetalleParada;
	}

	public void setIdOeeDetalleParada(Long idOeeDetalleParada) {
		this.idOeeDetalleParada = idOeeDetalleParada;
	}

	public Boolean getEstandarModificado() {
		return this.estandarModificado;
	}

	public void setEstandarModificado(Boolean estandarModificado) {
		this.estandarModificado = estandarModificado;
	}

	public Timestamp getFechaHoraFin() {
		return this.fechaHoraFin;
	}

	public void setFechaHoraFin(Timestamp fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public Timestamp getFechaHoraInicio() {
		return this.fechaHoraInicio;
	}

	public void setFechaHoraInicio(Timestamp fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public double getTiempoDescontar() {
		return this.tiempoDescontar;
	}

	public void setTiempoDescontar(double tiempoDescontar) {
		this.tiempoDescontar = tiempoDescontar;
	}

	public OeeParada getOeeParada() {
		return this.oeeParada;
	}

	public void setOeeParada(OeeParada oeeParada) {
		this.oeeParada = oeeParada;
	}

	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<OeeDetalleParadaEnvasado> getOeeDetalleParadaEnvasados() {
		return this.oeeDetalleParadaEnvasados;
	}

	public void setOeeDetalleParadaEnvasados(List<OeeDetalleParadaEnvasado> oeeDetalleParadaEnvasados) {
		this.oeeDetalleParadaEnvasados = oeeDetalleParadaEnvasados;
	}

	public List<OeeDetalleParadaLimpieza> getOeeDetalleParadaLimpiezas() {
		return this.oeeDetalleParadaLimpiezas;
	}

	public void setOeeDetalleParadaLimpiezas(List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas) {
		this.oeeDetalleParadaLimpiezas = oeeDetalleParadaLimpiezas;
	}

	public List<OeeDetalleParadaLonja> getOeeDetalleParadaLonjas() {
		return this.oeeDetalleParadaLonjas;
	}

	public void setOeeDetalleParadaLonjas(List<OeeDetalleParadaLonja> oeeDetalleParadaLonjas) {
		this.oeeDetalleParadaLonjas = oeeDetalleParadaLonjas;
	}

	public List<OeeDetalleParadaRackeo> getOeeDetalleParadaRackeos() {
		return this.oeeDetalleParadaRackeos;
	}

	public void setOeeDetalleParadaRackeos(List<OeeDetalleParadaRackeo> oeeDetalleParadaRackeos) {
		this.oeeDetalleParadaRackeos = oeeDetalleParadaRackeos;
	}

}