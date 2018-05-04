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
@NamedQuery(name="OeeDetalleParada.findAll", query="SELECT o FROM OeeDetalleParada o")
public class OeeDetalleParada implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idOeeDetalleParada;
	private Boolean estandarModificado;
	private Timestamp fechaHoraFin;
	private Timestamp fechaHoraInicio;
	private Timestamp fechaRegistro;
	private String observacion;
	private double tiempoDescontar;
	private OeeParada oeeParada;
	private ProcesoAperturaCierre procesoAperturaCierre;
	private Usuario usuario;
	private List<OeeDetalleParadaEnvasado> oeeDetalleParadaEnvasados;
	private List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas;
	private List<OeeDetalleParadaLonja> oeeDetalleParadaLonjas;
	private List<OeeDetalleParadaRackeo> oeeDetalleParadaRackeos;

	public OeeDetalleParada() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_detalle_parada")
	public Long getIdOeeDetalleParada() {
		return this.idOeeDetalleParada;
	}

	public void setIdOeeDetalleParada(Long idOeeDetalleParada) {
		this.idOeeDetalleParada = idOeeDetalleParada;
	}


	@Column(name="estandar_modificado")
	public Boolean getEstandarModificado() {
		return this.estandarModificado;
	}

	public void setEstandarModificado(Boolean estandarModificado) {
		this.estandarModificado = estandarModificado;
	}


	@Column(name="fecha_hora_fin")
	public Timestamp getFechaHoraFin() {
		return this.fechaHoraFin;
	}

	public void setFechaHoraFin(Timestamp fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}


	@Column(name="fecha_hora_inicio")
	public Timestamp getFechaHoraInicio() {
		return this.fechaHoraInicio;
	}

	public void setFechaHoraInicio(Timestamp fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}


	@Column(name="fecha_registro")
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


	@Column(name="tiempo_descontar")
	public double getTiempoDescontar() {
		return this.tiempoDescontar;
	}

	public void setTiempoDescontar(double tiempoDescontar) {
		this.tiempoDescontar = tiempoDescontar;
	}


	//bi-directional many-to-one association to OeeParada
	@ManyToOne
	@JoinColumn(name="id_oee_parada")
	public OeeParada getOeeParada() {
		return this.oeeParada;
	}

	public void setOeeParada(OeeParada oeeParada) {
		this.oeeParada = oeeParada;
	}


	//bi-directional many-to-one association to ProcesoAperturaCierre
	@ManyToOne
	@JoinColumn(name="idprocesoaperturacierre")
	public ProcesoAperturaCierre getProcesoAperturaCierre() {
		return this.procesoAperturaCierre;
	}

	public void setProcesoAperturaCierre(ProcesoAperturaCierre procesoAperturaCierre) {
		this.procesoAperturaCierre = procesoAperturaCierre;
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


	//bi-directional many-to-one association to OeeDetalleParadaEnvasado
	@OneToMany(mappedBy="oeeDetalleParada")
	public List<OeeDetalleParadaEnvasado> getOeeDetalleParadaEnvasados() {
		return this.oeeDetalleParadaEnvasados;
	}

	public void setOeeDetalleParadaEnvasados(List<OeeDetalleParadaEnvasado> oeeDetalleParadaEnvasados) {
		this.oeeDetalleParadaEnvasados = oeeDetalleParadaEnvasados;
	}

	public OeeDetalleParadaEnvasado addOeeDetalleParadaEnvasado(OeeDetalleParadaEnvasado oeeDetalleParadaEnvasado) {
		getOeeDetalleParadaEnvasados().add(oeeDetalleParadaEnvasado);
		oeeDetalleParadaEnvasado.setOeeDetalleParada(this);

		return oeeDetalleParadaEnvasado;
	}

	public OeeDetalleParadaEnvasado removeOeeDetalleParadaEnvasado(OeeDetalleParadaEnvasado oeeDetalleParadaEnvasado) {
		getOeeDetalleParadaEnvasados().remove(oeeDetalleParadaEnvasado);
		oeeDetalleParadaEnvasado.setOeeDetalleParada(null);

		return oeeDetalleParadaEnvasado;
	}


	//bi-directional many-to-one association to OeeDetalleParadaLimpieza
	@OneToMany(mappedBy="oeeDetalleParada")
	public List<OeeDetalleParadaLimpieza> getOeeDetalleParadaLimpiezas() {
		return this.oeeDetalleParadaLimpiezas;
	}

	public void setOeeDetalleParadaLimpiezas(List<OeeDetalleParadaLimpieza> oeeDetalleParadaLimpiezas) {
		this.oeeDetalleParadaLimpiezas = oeeDetalleParadaLimpiezas;
	}

	public OeeDetalleParadaLimpieza addOeeDetalleParadaLimpieza(OeeDetalleParadaLimpieza oeeDetalleParadaLimpieza) {
		getOeeDetalleParadaLimpiezas().add(oeeDetalleParadaLimpieza);
		oeeDetalleParadaLimpieza.setOeeDetalleParada(this);

		return oeeDetalleParadaLimpieza;
	}

	public OeeDetalleParadaLimpieza removeOeeDetalleParadaLimpieza(OeeDetalleParadaLimpieza oeeDetalleParadaLimpieza) {
		getOeeDetalleParadaLimpiezas().remove(oeeDetalleParadaLimpieza);
		oeeDetalleParadaLimpieza.setOeeDetalleParada(null);

		return oeeDetalleParadaLimpieza;
	}


	//bi-directional many-to-one association to OeeDetalleParadaLonja
	@OneToMany(mappedBy="oeeDetalleParada")
	public List<OeeDetalleParadaLonja> getOeeDetalleParadaLonjas() {
		return this.oeeDetalleParadaLonjas;
	}

	public void setOeeDetalleParadaLonjas(List<OeeDetalleParadaLonja> oeeDetalleParadaLonjas) {
		this.oeeDetalleParadaLonjas = oeeDetalleParadaLonjas;
	}

	public OeeDetalleParadaLonja addOeeDetalleParadaLonja(OeeDetalleParadaLonja oeeDetalleParadaLonja) {
		getOeeDetalleParadaLonjas().add(oeeDetalleParadaLonja);
		oeeDetalleParadaLonja.setOeeDetalleParada(this);

		return oeeDetalleParadaLonja;
	}

	public OeeDetalleParadaLonja removeOeeDetalleParadaLonja(OeeDetalleParadaLonja oeeDetalleParadaLonja) {
		getOeeDetalleParadaLonjas().remove(oeeDetalleParadaLonja);
		oeeDetalleParadaLonja.setOeeDetalleParada(null);

		return oeeDetalleParadaLonja;
	}


	//bi-directional many-to-one association to OeeDetalleParadaRackeo
	@OneToMany(mappedBy="oeeDetalleParada")
	public List<OeeDetalleParadaRackeo> getOeeDetalleParadaRackeos() {
		return this.oeeDetalleParadaRackeos;
	}

	public void setOeeDetalleParadaRackeos(List<OeeDetalleParadaRackeo> oeeDetalleParadaRackeos) {
		this.oeeDetalleParadaRackeos = oeeDetalleParadaRackeos;
	}

	public OeeDetalleParadaRackeo addOeeDetalleParadaRackeo(OeeDetalleParadaRackeo oeeDetalleParadaRackeo) {
		getOeeDetalleParadaRackeos().add(oeeDetalleParadaRackeo);
		oeeDetalleParadaRackeo.setOeeDetalleParada(this);

		return oeeDetalleParadaRackeo;
	}

	public OeeDetalleParadaRackeo removeOeeDetalleParadaRackeo(OeeDetalleParadaRackeo oeeDetalleParadaRackeo) {
		getOeeDetalleParadaRackeos().remove(oeeDetalleParadaRackeo);
		oeeDetalleParadaRackeo.setOeeDetalleParada(null);

		return oeeDetalleParadaRackeo;
	}

}