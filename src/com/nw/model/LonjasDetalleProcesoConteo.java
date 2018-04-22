package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the lonjas_detalle_proceso_conteo database table.
 * 
 */
@Entity
@Table(name="lonjas_detalle_proceso_conteo")
public class LonjasDetalleProcesoConteo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlonjasdetalleprocesoconteo;

	@Column(name="estandar_sml")
	private Integer estandarSml;

	private Timestamp fechareg;

	private Integer idcoche;

	private String tarjetapersonalinea;

	private Integer totalfundas;

	private Integer ubicacion;

	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlojnasdetalleprocesolote")
	private LonjasDetalleProcesoLote lonjasDetalleProcesoLote;

	//bi-directional many-to-one association to LonjasEstandarFundasTalla
	@ManyToOne
	@JoinColumn(name="idlonjasestandarfundastallas")
	private LonjasEstandarFundasTalla lonjasEstandarFundasTalla;

	//bi-directional many-to-one association to LonjasMaterial
	@ManyToOne
	@JoinColumn(name="idlonjasmaterial")
	private LonjasMaterial lonjasMaterial;

	//bi-directional many-to-one association to LonjasOrdenProduccion
	@ManyToOne
	@JoinColumn(name="idlonjasordenproduccion")
	private LonjasOrdenProduccion lonjasOrdenProduccion;

	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idlonjasprocesoempleado")
	private LonjasProcesoEmpleado lonjasProcesoEmpleado;

	//bi-directional many-to-one association to LonjasProcesoTipo
	@ManyToOne
	@JoinColumn(name="idlonjasprocesotipo")
	private LonjasProcesoTipo lonjasProcesoTipo;

	//bi-directional many-to-one association to LonjasTunel
	@ManyToOne
	@JoinColumn(name="idlonjastunel")
	private LonjasTunel lonjasTunel;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LonjasDetalleProcesoConteo() {
	}

	public Long getIdlonjasdetalleprocesoconteo() {
		return this.idlonjasdetalleprocesoconteo;
	}

	public void setIdlonjasdetalleprocesoconteo(Long idlonjasdetalleprocesoconteo) {
		this.idlonjasdetalleprocesoconteo = idlonjasdetalleprocesoconteo;
	}

	public Integer getEstandarSml() {
		return this.estandarSml;
	}

	public void setEstandarSml(Integer estandarSml) {
		this.estandarSml = estandarSml;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getIdcoche() {
		return this.idcoche;
	}

	public void setIdcoche(Integer idcoche) {
		this.idcoche = idcoche;
	}

	public String getTarjetapersonalinea() {
		return this.tarjetapersonalinea;
	}

	public void setTarjetapersonalinea(String tarjetapersonalinea) {
		this.tarjetapersonalinea = tarjetapersonalinea;
	}

	public Integer getTotalfundas() {
		return this.totalfundas;
	}

	public void setTotalfundas(Integer totalfundas) {
		this.totalfundas = totalfundas;
	}

	public Integer getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public LonjasDetalleProcesoLote getLonjasDetalleProcesoLote() {
		return this.lonjasDetalleProcesoLote;
	}

	public void setLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		this.lonjasDetalleProcesoLote = lonjasDetalleProcesoLote;
	}

	public LonjasEstandarFundasTalla getLonjasEstandarFundasTalla() {
		return this.lonjasEstandarFundasTalla;
	}

	public void setLonjasEstandarFundasTalla(LonjasEstandarFundasTalla lonjasEstandarFundasTalla) {
		this.lonjasEstandarFundasTalla = lonjasEstandarFundasTalla;
	}

	public LonjasMaterial getLonjasMaterial() {
		return this.lonjasMaterial;
	}

	public void setLonjasMaterial(LonjasMaterial lonjasMaterial) {
		this.lonjasMaterial = lonjasMaterial;
	}

	public LonjasOrdenProduccion getLonjasOrdenProduccion() {
		return this.lonjasOrdenProduccion;
	}

	public void setLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		this.lonjasOrdenProduccion = lonjasOrdenProduccion;
	}

	public LonjasProcesoEmpleado getLonjasProcesoEmpleado() {
		return this.lonjasProcesoEmpleado;
	}

	public void setLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		this.lonjasProcesoEmpleado = lonjasProcesoEmpleado;
	}

	public LonjasProcesoTipo getLonjasProcesoTipo() {
		return this.lonjasProcesoTipo;
	}

	public void setLonjasProcesoTipo(LonjasProcesoTipo lonjasProcesoTipo) {
		this.lonjasProcesoTipo = lonjasProcesoTipo;
	}

	public LonjasTunel getLonjasTunel() {
		return this.lonjasTunel;
	}

	public void setLonjasTunel(LonjasTunel lonjasTunel) {
		this.lonjasTunel = lonjasTunel;
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