package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the lonjas_detalle_proceso_empaque database table.
 * 
 */
@Entity
@Table(name="lonjas_detalle_proceso_empaque")
public class LonjasDetalleProcesoEmpaque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlonjasdetalleprocesoempaque;

	private Timestamp fechareg;

	private double peso;

	private String tarjetapersonalinea;

	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlonjasdetalleprocesolote")
	private LonjasDetalleProcesoLote lonjasDetalleProcesoLote;

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

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LonjasDetalleProcesoEmpaque() {
	}

	public Long getIdlonjasdetalleprocesoempaque() {
		return this.idlonjasdetalleprocesoempaque;
	}

	public void setIdlonjasdetalleprocesoempaque(Long idlonjasdetalleprocesoempaque) {
		this.idlonjasdetalleprocesoempaque = idlonjasdetalleprocesoempaque;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getTarjetapersonalinea() {
		return this.tarjetapersonalinea;
	}

	public void setTarjetapersonalinea(String tarjetapersonalinea) {
		this.tarjetapersonalinea = tarjetapersonalinea;
	}

	public LonjasDetalleProcesoLote getLonjasDetalleProcesoLote() {
		return this.lonjasDetalleProcesoLote;
	}

	public void setLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		this.lonjasDetalleProcesoLote = lonjasDetalleProcesoLote;
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