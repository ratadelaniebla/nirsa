package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atc_limpieza_proceso_empleado database table.
 * 
 */
@Entity
@Table(name="atc_limpieza_proceso_empleado")
public class AtcLimpiezaProcesoEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idatclimpiezaprocesoempleado;

	private Timestamp fechareg;

	private Integer idatclimpiezacargo;

	private String tarjetapersonalinea;

	private Integer ubicacion;

	//bi-directional many-to-one association to AtcLimpiezaDetalleBandeja
	@OneToMany(mappedBy="atcLimpiezaProcesoEmpleado")
	private List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas;

	//bi-directional many-to-one association to AtcLimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idatclinea")
	private AtcLimpiezaLinea atcLimpiezaLinea;

	//bi-directional many-to-one association to AtcLimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idatclimpiezaproceso")
	private AtcLimpiezaProceso atcLimpiezaProceso;

	//bi-directional many-to-one association to AtcUsuario
	@ManyToOne
	@JoinColumn(name="idatcusuario")
	private AtcUsuario atcUsuario;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;

	public AtcLimpiezaProcesoEmpleado() {
	}

	public Long getIdatclimpiezaprocesoempleado() {
		return this.idatclimpiezaprocesoempleado;
	}

	public void setIdatclimpiezaprocesoempleado(Long idatclimpiezaprocesoempleado) {
		this.idatclimpiezaprocesoempleado = idatclimpiezaprocesoempleado;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getIdatclimpiezacargo() {
		return this.idatclimpiezacargo;
	}

	public void setIdatclimpiezacargo(Integer idatclimpiezacargo) {
		this.idatclimpiezacargo = idatclimpiezacargo;
	}

	public String getTarjetapersonalinea() {
		return this.tarjetapersonalinea;
	}

	public void setTarjetapersonalinea(String tarjetapersonalinea) {
		this.tarjetapersonalinea = tarjetapersonalinea;
	}

	public Integer getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<AtcLimpiezaDetalleBandeja> getAtcLimpiezaDetalleBandejas() {
		return this.atcLimpiezaDetalleBandejas;
	}

	public void setAtcLimpiezaDetalleBandejas(List<AtcLimpiezaDetalleBandeja> atcLimpiezaDetalleBandejas) {
		this.atcLimpiezaDetalleBandejas = atcLimpiezaDetalleBandejas;
	}

	public AtcLimpiezaLinea getAtcLimpiezaLinea() {
		return this.atcLimpiezaLinea;
	}

	public void setAtcLimpiezaLinea(AtcLimpiezaLinea atcLimpiezaLinea) {
		this.atcLimpiezaLinea = atcLimpiezaLinea;
	}

	public AtcLimpiezaProceso getAtcLimpiezaProceso() {
		return this.atcLimpiezaProceso;
	}

	public void setAtcLimpiezaProceso(AtcLimpiezaProceso atcLimpiezaProceso) {
		this.atcLimpiezaProceso = atcLimpiezaProceso;
	}

	public AtcUsuario getAtcUsuario() {
		return this.atcUsuario;
	}

	public void setAtcUsuario(AtcUsuario atcUsuario) {
		this.atcUsuario = atcUsuario;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}