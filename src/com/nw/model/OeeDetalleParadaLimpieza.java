package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oee_detalle_parada_limpieza database table.
 * 
 */
@Entity
@Table(name="oee_detalle_parada_limpieza")
@NamedQuery(name="OeeDetalleParadaLimpieza.findAll", query="SELECT o FROM OeeDetalleParadaLimpieza o")
public class OeeDetalleParadaLimpieza implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idoeedetalleparadalimpieza;
	private Integer personas;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaProcesoEmpleado limpiezaProcesoEmpleado;
	private OeeDetalleParada oeeDetalleParada;

	public OeeDetalleParadaLimpieza() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
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


	//bi-directional many-to-one association to OeeDetalleParada
	@ManyToOne
	@JoinColumn(name="idoeedetalleparada")
	public OeeDetalleParada getOeeDetalleParada() {
		return this.oeeDetalleParada;
	}

	public void setOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		this.oeeDetalleParada = oeeDetalleParada;
	}

}