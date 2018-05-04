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
@NamedQuery(name="LonjasDetalleProcesoEmpaque.findAll", query="SELECT l FROM LonjasDetalleProcesoEmpaque l")
public class LonjasDetalleProcesoEmpaque implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlonjasdetalleprocesoempaque;
	private Timestamp fechareg;
	private double peso;
	private String tarjetapersonalinea;
	private LonjasDetalleProcesoLote lonjasDetalleProcesoLote;
	private LonjasMaterial lonjasMaterial;
	private LonjasOrdenProduccion lonjasOrdenProduccion;
	private LonjasProcesoEmpleado lonjasProcesoEmpleado;
	private LonjasProcesoTipo lonjasProcesoTipo;
	private Turno turno;
	private Usuario usuario;

	public LonjasDetalleProcesoEmpaque() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LonjasDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlonjasdetalleprocesolote")
	public LonjasDetalleProcesoLote getLonjasDetalleProcesoLote() {
		return this.lonjasDetalleProcesoLote;
	}

	public void setLonjasDetalleProcesoLote(LonjasDetalleProcesoLote lonjasDetalleProcesoLote) {
		this.lonjasDetalleProcesoLote = lonjasDetalleProcesoLote;
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