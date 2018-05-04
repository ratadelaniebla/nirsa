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
@NamedQuery(name="LonjasDetalleProcesoConteo.findAll", query="SELECT l FROM LonjasDetalleProcesoConteo l")
public class LonjasDetalleProcesoConteo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlonjasdetalleprocesoconteo;
	private Integer estandarSml;
	private Timestamp fechareg;
	private Integer idcoche;
	private String tarjetapersonalinea;
	private Integer totalfundas;
	private Integer ubicacion;
	private LonjasDetalleProcesoLote lonjasDetalleProcesoLote;
	private LonjasEstandarFundasTalla lonjasEstandarFundasTalla;
	private LonjasMaterial lonjasMaterial;
	private LonjasOrdenProduccion lonjasOrdenProduccion;
	private LonjasProcesoEmpleado lonjasProcesoEmpleado;
	private LonjasProcesoTipo lonjasProcesoTipo;
	private LonjasTunel lonjasTunel;
	private Turno turno;
	private Usuario usuario;

	public LonjasDetalleProcesoConteo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlonjasdetalleprocesoconteo() {
		return this.idlonjasdetalleprocesoconteo;
	}

	public void setIdlonjasdetalleprocesoconteo(Long idlonjasdetalleprocesoconteo) {
		this.idlonjasdetalleprocesoconteo = idlonjasdetalleprocesoconteo;
	}


	@Column(name="estandar_sml")
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


	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlojnasdetalleprocesolote")
	public LonjasDetalleProcesoLote getLonjasDetalleProcesoLote() {
		return this.lonjasDetalleProcesoLote;
	}

	public void setLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		this.lonjasDetalleProcesoLote = lonjasDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LonjasEstandarFundasTalla
	@ManyToOne
	@JoinColumn(name="idlonjasestandarfundastallas")
	public LonjasEstandarFundasTalla getLonjasEstandarFundasTalla() {
		return this.lonjasEstandarFundasTalla;
	}

	public void setLonjasEstandarFundasTalla(LonjasEstandarFundasTalla lonjasEstandarFundasTalla) {
		this.lonjasEstandarFundasTalla = lonjasEstandarFundasTalla;
	}


	//bi-directional many-to-one association to LonjasMaterial
	@ManyToOne
	@JoinColumn(name="idlonjasmaterial")
	public LonjasMaterial getLonjasMaterial() {
		return this.lonjasMaterial;
	}

	public void setLonjasMaterial(LonjasMaterial lonjasMaterial) {
		this.lonjasMaterial = lonjasMaterial;
	}


	//bi-directional many-to-one association to LonjasOrdenProduccion
	@ManyToOne
	@JoinColumn(name="idlonjasordenproduccion")
	public LonjasOrdenProduccion getLonjasOrdenProduccion() {
		return this.lonjasOrdenProduccion;
	}

	public void setLonjasOrdenProduccion(LonjasOrdenProduccion lonjasOrdenProduccion) {
		this.lonjasOrdenProduccion = lonjasOrdenProduccion;
	}


	//bi-directional many-to-one association to LonjasProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idlonjasprocesoempleado")
	public LonjasProcesoEmpleado getLonjasProcesoEmpleado() {
		return this.lonjasProcesoEmpleado;
	}

	public void setLonjasProcesoEmpleado(LonjasProcesoEmpleado lonjasProcesoEmpleado) {
		this.lonjasProcesoEmpleado = lonjasProcesoEmpleado;
	}


	//bi-directional many-to-one association to LonjasProcesoTipo
	@ManyToOne
	@JoinColumn(name="idlonjasprocesotipo")
	public LonjasProcesoTipo getLonjasProcesoTipo() {
		return this.lonjasProcesoTipo;
	}

	public void setLonjasProcesoTipo(LonjasProcesoTipo lonjasProcesoTipo) {
		this.lonjasProcesoTipo = lonjasProcesoTipo;
	}


	//bi-directional many-to-one association to LonjasTunel
	@ManyToOne
	@JoinColumn(name="idlonjastunel")
	public LonjasTunel getLonjasTunel() {
		return this.lonjasTunel;
	}

	public void setLonjasTunel(LonjasTunel lonjasTunel) {
		this.lonjasTunel = lonjasTunel;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
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

}