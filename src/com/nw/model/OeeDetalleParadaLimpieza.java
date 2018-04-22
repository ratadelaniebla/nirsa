package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_parada_limpieza database table.
 * 
 */
@Entity
@Table(name="oee_detalle_parada_limpieza")
public class OeeDetalleParadaLimpieza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idoeedetalleparadalimpieza;

	private Integer personas;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoempleado")
	private LimpiezaProcesoEmpleado limpiezaProcesoEmpleado;

	//bi-directional many-to-one association to OeeDetalleParada
	@ManyToOne
	@JoinColumn(name="idoeedetalleparada")
	private OeeDetalleParada oeeDetalleParada;

	public OeeDetalleParadaLimpieza() {
	}

	public Long getIdoeedetalleparadalimpieza() {
		return this.idoeedetalleparadalimpieza;
	}

	public void setIdoeedetalleparadalimpieza(Long idoeedetalleparadalimpieza) {
		this.idoeedetalleparadalimpieza = idoeedetalleparadalimpieza;
	}

	public Integer getPersonas() {
		return this.personas;
	}

	public void setPersonas(Integer personas) {
		this.personas = personas;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public LimpiezaProcesoEmpleado getLimpiezaProcesoEmpleado() {
		return this.limpiezaProcesoEmpleado;
	}

	public void setLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		this.limpiezaProcesoEmpleado = limpiezaProcesoEmpleado;
	}

	public OeeDetalleParada getOeeDetalleParada() {
		return this.oeeDetalleParada;
	}

	public void setOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		this.oeeDetalleParada = oeeDetalleParada;
	}

}