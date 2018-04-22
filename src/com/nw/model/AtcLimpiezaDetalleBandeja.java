package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the atc_limpieza_detalle_bandeja database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_detalle_bandeja")
public class AtcLimpiezaDetalleBandeja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatclimpiezadetallebandeja;

	private Timestamp fechareg;

	private double peso;

	private String tarjetapersonalinea;

	private Integer ubicacionpersona;

	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idatclimpiezadetalleprocesolote")
	private AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote;

	//bi-directional many-to-one association to AtcLimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idatclimpiezalinea")
	private AtcLimpiezaLinea atcLimpiezaLinea;

	//bi-directional many-to-one association to AtcLimpiezaMaterial
	@ManyToOne
	@JoinColumn(name="idatclimpiezamaterial")
	private AtcLimpiezaMaterial atcLimpiezaMaterial;

	//bi-directional many-to-one association to AtcLimpiezaProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idatclimpiezaprocesoempleado")
	private AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado;

	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	private AtcTurno atcTurno;

	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	private AtcUsuario atcUsuario;

	public AtcLimpiezaDetalleBandeja() {
	}

	public Long getIdatclimpiezadetallebandeja() {
		return this.idatclimpiezadetallebandeja;
	}

	public void setIdatclimpiezadetallebandeja(Long idatclimpiezadetallebandeja) {
		this.idatclimpiezadetallebandeja = idatclimpiezadetallebandeja;
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

	public Integer getUbicacionpersona() {
		return this.ubicacionpersona;
	}

	public void setUbicacionpersona(Integer ubicacionpersona) {
		this.ubicacionpersona = ubicacionpersona;
	}

	public AtcLimpiezaDetalleProcesoLote getAtcLimpiezaDetalleProcesoLote() {
		return this.atcLimpiezaDetalleProcesoLote;
	}

	public void setAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		this.atcLimpiezaDetalleProcesoLote = atcLimpiezaDetalleProcesoLote;
	}

	public AtcLimpiezaLinea getAtcLimpiezaLinea() {
		return this.atcLimpiezaLinea;
	}

	public void setAtcLimpiezaLinea(AtcLimpiezaLinea atcLimpiezaLinea) {
		this.atcLimpiezaLinea = atcLimpiezaLinea;
	}

	public AtcLimpiezaMaterial getAtcLimpiezaMaterial() {
		return this.atcLimpiezaMaterial;
	}

	public void setAtcLimpiezaMaterial(AtcLimpiezaMaterial atcLimpiezaMaterial) {
		this.atcLimpiezaMaterial = atcLimpiezaMaterial;
	}

	public AtcLimpiezaProcesoEmpleado getAtcLimpiezaProcesoEmpleado() {
		return this.atcLimpiezaProcesoEmpleado;
	}

	public void setAtcLimpiezaProcesoEmpleado(AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado) {
		this.atcLimpiezaProcesoEmpleado = atcLimpiezaProcesoEmpleado;
	}

	public AtcTurno getAtcTurno() {
		return this.atcTurno;
	}

	public void setAtcTurno(AtcTurno atcTurno) {
		this.atcTurno = atcTurno;
	}

	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

}