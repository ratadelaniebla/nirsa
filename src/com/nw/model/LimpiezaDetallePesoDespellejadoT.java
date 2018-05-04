package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_detalle_peso_despellejado_t database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_peso_despellejado_t")
@NamedQuery(name="LimpiezaDetallePesoDespellejadoT.findAll", query="SELECT l FROM LimpiezaDetallePesoDespellejadoT l")
public class LimpiezaDetallePesoDespellejadoT implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadetallepesodespellejadot;
	private Timestamp fechareg;
	private double peso;
	private String tarjetadespellejador;
	private EvisceradoPescadosLata evisceradoPescadosLata;
	private LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote;
	private LimpiezaProcesoEmpleado limpiezaProcesoEmpleado;
	private Usuario usuario;

	public LimpiezaDetallePesoDespellejadoT() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezadetallepesodespellejadot() {
		return this.idlimpiezadetallepesodespellejadot;
	}

	public void setIdlimpiezadetallepesodespellejadot(Long idlimpiezadetallepesodespellejadot) {
		this.idlimpiezadetallepesodespellejadot = idlimpiezadetallepesodespellejadot;
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


	public String getTarjetadespellejador() {
		return this.tarjetadespellejador;
	}

	public void setTarjetadespellejador(String tarjetadespellejador) {
		this.tarjetadespellejador = tarjetadespellejador;
	}


	//bi-directional many-to-one association to EvisceradoPescadosLata
	@ManyToOne
	@JoinColumn(name="idpescadosporlata")
	public EvisceradoPescadosLata getEvisceradoPescadosLata() {
		return this.evisceradoPescadosLata;
	}

	public void setEvisceradoPescadosLata(EvisceradoPescadosLata evisceradoPescadosLata) {
		this.evisceradoPescadosLata = evisceradoPescadosLata;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesolote")
	public LimpiezaDetalleProcesoLote getLimpiezaDetalleProcesoLote() {
		return this.limpiezaDetalleProcesoLote;
	}

	public void setLimpiezaDetalleProcesoLote(LimpiezaDetalleProcesoLote limpiezaDetalleProcesoLote) {
		this.limpiezaDetalleProcesoLote = limpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoempleado")
	public LimpiezaProcesoEmpleado getLimpiezaProcesoEmpleado() {
		return this.limpiezaProcesoEmpleado;
	}

	public void setLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		this.limpiezaProcesoEmpleado = limpiezaProcesoEmpleado;
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