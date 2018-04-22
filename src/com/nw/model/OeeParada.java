package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oee_parada database table.
 * 
 */
@Entity
@Table(name="oee_parada")
public class OeeParada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_parada")
	private Integer idOeeParada;

	@Column(name="descripcion_parada")
	private String descripcionParada;

	@Column(name="estandar_modificado")
	private Boolean estandarModificado;

	private Boolean programada;

	@Column(name="tiempo_muerto")
	private Boolean tiempoMuerto;

	@Column(name="tiempo_parada_programada")
	private double tiempoParadaProgramada;

	@Column(name="tipo_equipo_persona")
	private Boolean tipoEquipoPersona;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="oeeParada")
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;

	//bi-directional many-to-one association to OeeDetalleParada
	@OneToMany(mappedBy="oeeParada")
	private List<OeeDetalleParada> oeeDetalleParadas;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	public OeeParada() {
	}

	public Integer getIdOeeParada() {
		return this.idOeeParada;
	}

	public void setIdOeeParada(Integer idOeeParada) {
		this.idOeeParada = idOeeParada;
	}

	public String getDescripcionParada() {
		return this.descripcionParada;
	}

	public void setDescripcionParada(String descripcionParada) {
		this.descripcionParada = descripcionParada;
	}

	public Boolean getEstandarModificado() {
		return this.estandarModificado;
	}

	public void setEstandarModificado(Boolean estandarModificado) {
		this.estandarModificado = estandarModificado;
	}

	public Boolean getProgramada() {
		return this.programada;
	}

	public void setProgramada(Boolean programada) {
		this.programada = programada;
	}

	public Boolean getTiempoMuerto() {
		return this.tiempoMuerto;
	}

	public void setTiempoMuerto(Boolean tiempoMuerto) {
		this.tiempoMuerto = tiempoMuerto;
	}

	public double getTiempoParadaProgramada() {
		return this.tiempoParadaProgramada;
	}

	public void setTiempoParadaProgramada(double tiempoParadaProgramada) {
		this.tiempoParadaProgramada = tiempoParadaProgramada;
	}

	public Boolean getTipoEquipoPersona() {
		return this.tipoEquipoPersona;
	}

	public void setTipoEquipoPersona(Boolean tipoEquipoPersona) {
		this.tipoEquipoPersona = tipoEquipoPersona;
	}

	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public List<OeeDetalleParada> getOeeDetalleParadas() {
		return this.oeeDetalleParadas;
	}

	public void setOeeDetalleParadas(List<OeeDetalleParada> oeeDetalleParadas) {
		this.oeeDetalleParadas = oeeDetalleParadas;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

}