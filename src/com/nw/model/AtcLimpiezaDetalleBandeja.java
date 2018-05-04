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
@NamedQuery(name="AtcLimpiezaDetalleBandeja.findAll", query="SELECT a FROM AtcLimpiezaDetalleBandeja a")
public class AtcLimpiezaDetalleBandeja implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idatclimpiezadetallebandeja;
	private Timestamp fechareg;
	private double peso;
	private String tarjetapersonalinea;
	private Integer ubicacionpersona;
	private AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote;
	private AtcLimpiezaLinea atcLimpiezaLinea;
	private AtcLimpiezaMaterial atcLimpiezaMaterial;
	private AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado;
	private AtcTurno atcTurno;
	private AtcUsuario atcUsuario;

	public AtcLimpiezaDetalleBandeja() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to AtcLimpiezaDetalleProcesoLote
	@ManyToOne
	@JoinColumn(name="idatclimpiezadetalleprocesolote")
	public AtcLimpiezaDetalleProcesoLote getAtcLimpiezaDetalleProcesoLote() {
		return this.atcLimpiezaDetalleProcesoLote;
	}

	public void setAtcLimpiezaDetalleProcesoLote(AtcLimpiezaDetalleProcesoLote atcLimpiezaDetalleProcesoLote) {
		this.atcLimpiezaDetalleProcesoLote = atcLimpiezaDetalleProcesoLote;
	}


	//bi-directional many-to-one association to AtcLimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idatclimpiezalinea")
	public AtcLimpiezaLinea getAtcLimpiezaLinea() {
		return this.atcLimpiezaLinea;
	}

	public void setAtcLimpiezaLinea(AtcLimpiezaLinea atcLimpiezaLinea) {
		this.atcLimpiezaLinea = atcLimpiezaLinea;
	}


	//bi-directional many-to-one association to AtcLimpiezaMaterial
	@ManyToOne
	@JoinColumn(name="idatclimpiezamaterial")
	public AtcLimpiezaMaterial getAtcLimpiezaMaterial() {
		return this.atcLimpiezaMaterial;
	}

	public void setAtcLimpiezaMaterial(AtcLimpiezaMaterial atcLimpiezaMaterial) {
		this.atcLimpiezaMaterial = atcLimpiezaMaterial;
	}


	//bi-directional many-to-one association to AtcLimpiezaProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idatclimpiezaprocesoempleado")
	public AtcLimpiezaProcesoEmpleado getAtcLimpiezaProcesoEmpleado() {
		return this.atcLimpiezaProcesoEmpleado;
	}

	public void setAtcLimpiezaProcesoEmpleado(AtcLimpiezaProcesoEmpleado atcLimpiezaProcesoEmpleado) {
		this.atcLimpiezaProcesoEmpleado = atcLimpiezaProcesoEmpleado;
	}


	//bi-directional many-to-one association to AtcTurno
	@ManyToOne
	@JoinColumn(name="idatcturno")
	public AtcTurno getAtcTurno() {
		return this.atcTurno;
	}

	public void setAtcTurno(AtcTurno atcTurno) {
		this.atcTurno = atcTurno;
	}


	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

}