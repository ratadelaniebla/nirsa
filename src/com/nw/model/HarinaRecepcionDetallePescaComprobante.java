package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the harina_recepcion_detalle_pesca_comprobante database table.
 * 
 */
@Entity
@Table(name="harina_recepcion_detalle_pesca_comprobante")
public class HarinaRecepcionDetallePescaComprobante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idharinarecepciondetallepescacomprobante;

	private Integer estado;

	private Timestamp fecharegistro;

	private String observaciones;

	private double pesobruto;

	private double tara;

	private String tipoingreso;

	//bi-directional many-to-one association to HarinaDetalleEspeceRecepcionDetallePescaComprobante
	@OneToMany(mappedBy="harinaRecepcionDetallePescaComprobante")
	private List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> harinaDetalleEspeceRecepcionDetallePescaComprobantes;

	//bi-directional many-to-one association to Cajon
	@ManyToOne
	@JoinColumn(name="idcajon")
	private Cajon cajon;

	//bi-directional many-to-one association to HarinaEspecie
	@ManyToOne
	@JoinColumn(name="idharinaespecie")
	private HarinaEspecie harinaEspecie;

	//bi-directional many-to-one association to HarinaRecepcionPescaComprobante
	@ManyToOne
	@JoinColumn(name="idharinarecepcionpescacomprobante")
	private HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public HarinaRecepcionDetallePescaComprobante() {
	}

	public Long getIdharinarecepciondetallepescacomprobante() {
		return this.idharinarecepciondetallepescacomprobante;
	}

	public void setIdharinarecepciondetallepescacomprobante(Long idharinarecepciondetallepescacomprobante) {
		this.idharinarecepciondetallepescacomprobante = idharinarecepciondetallepescacomprobante;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public double getPesobruto() {
		return this.pesobruto;
	}

	public void setPesobruto(double pesobruto) {
		this.pesobruto = pesobruto;
	}

	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	public String getTipoingreso() {
		return this.tipoingreso;
	}

	public void setTipoingreso(String tipoingreso) {
		this.tipoingreso = tipoingreso;
	}

	public List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> getHarinaDetalleEspeceRecepcionDetallePescaComprobantes() {
		return this.harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	}

	public void setHarinaDetalleEspeceRecepcionDetallePescaComprobantes(List<HarinaDetalleEspeceRecepcionDetallePescaComprobante> harinaDetalleEspeceRecepcionDetallePescaComprobantes) {
		this.harinaDetalleEspeceRecepcionDetallePescaComprobantes = harinaDetalleEspeceRecepcionDetallePescaComprobantes;
	}

	public Cajon getCajon() {
		return this.cajon;
	}

	public void setCajon(Cajon cajon) {
		this.cajon = cajon;
	}

	public HarinaEspecie getHarinaEspecie() {
		return this.harinaEspecie;
	}

	public void setHarinaEspecie(HarinaEspecie harinaEspecie) {
		this.harinaEspecie = harinaEspecie;
	}

	public HarinaRecepcionPescaComprobante getHarinaRecepcionPescaComprobante() {
		return this.harinaRecepcionPescaComprobante;
	}

	public void setHarinaRecepcionPescaComprobante(HarinaRecepcionPescaComprobante harinaRecepcionPescaComprobante) {
		this.harinaRecepcionPescaComprobante = harinaRecepcionPescaComprobante;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}