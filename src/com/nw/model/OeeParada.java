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
@NamedQuery(name="OeeParada.findAll", query="SELECT o FROM OeeParada o")
public class OeeParada implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idOeeParada;
	private String descripcionParada;
	private Boolean estandarModificado;
	private Boolean programada;
	private Boolean tiempoMuerto;
	private double tiempoParadaProgramada;
	private Boolean tipoEquipoPersona;
	private List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos;
	private List<OeeDetalleParada> oeeDetalleParadas;
	private Proceso proceso;

	public OeeParada() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_oee_parada")
	public Integer getIdOeeParada() {
		return this.idOeeParada;
	}

	public void setIdOeeParada(Integer idOeeParada) {
		this.idOeeParada = idOeeParada;
	}


	@Column(name="descripcion_parada")
	public String getDescripcionParada() {
		return this.descripcionParada;
	}

	public void setDescripcionParada(String descripcionParada) {
		this.descripcionParada = descripcionParada;
	}


	@Column(name="estandar_modificado")
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


	@Column(name="tiempo_muerto")
	public Boolean getTiempoMuerto() {
		return this.tiempoMuerto;
	}

	public void setTiempoMuerto(Boolean tiempoMuerto) {
		this.tiempoMuerto = tiempoMuerto;
	}


	@Column(name="tiempo_parada_programada")
	public double getTiempoParadaProgramada() {
		return this.tiempoParadaProgramada;
	}

	public void setTiempoParadaProgramada(double tiempoParadaProgramada) {
		this.tiempoParadaProgramada = tiempoParadaProgramada;
	}


	@Column(name="tipo_equipo_persona")
	public Boolean getTipoEquipoPersona() {
		return this.tipoEquipoPersona;
	}

	public void setTipoEquipoPersona(Boolean tipoEquipoPersona) {
		this.tipoEquipoPersona = tipoEquipoPersona;
	}


	//bi-directional many-to-one association to LimpiezaProcesoEmpleadoAditoriaMovimiento
	@OneToMany(mappedBy="oeeParada")
	public List<LimpiezaProcesoEmpleadoAditoriaMovimiento> getLimpiezaProcesoEmpleadoAditoriaMovimientos() {
		return this.limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public void setLimpiezaProcesoEmpleadoAditoriaMovimientos(List<LimpiezaProcesoEmpleadoAditoriaMovimiento> limpiezaProcesoEmpleadoAditoriaMovimientos) {
		this.limpiezaProcesoEmpleadoAditoriaMovimientos = limpiezaProcesoEmpleadoAditoriaMovimientos;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento addLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().add(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setOeeParada(this);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}

	public LimpiezaProcesoEmpleadoAditoriaMovimiento removeLimpiezaProcesoEmpleadoAditoriaMovimiento(LimpiezaProcesoEmpleadoAditoriaMovimiento limpiezaProcesoEmpleadoAditoriaMovimiento) {
		getLimpiezaProcesoEmpleadoAditoriaMovimientos().remove(limpiezaProcesoEmpleadoAditoriaMovimiento);
		limpiezaProcesoEmpleadoAditoriaMovimiento.setOeeParada(null);

		return limpiezaProcesoEmpleadoAditoriaMovimiento;
	}


	//bi-directional many-to-one association to OeeDetalleParada
	@OneToMany(mappedBy="oeeParada")
	public List<OeeDetalleParada> getOeeDetalleParadas() {
		return this.oeeDetalleParadas;
	}

	public void setOeeDetalleParadas(List<OeeDetalleParada> oeeDetalleParadas) {
		this.oeeDetalleParadas = oeeDetalleParadas;
	}

	public OeeDetalleParada addOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		getOeeDetalleParadas().add(oeeDetalleParada);
		oeeDetalleParada.setOeeParada(this);

		return oeeDetalleParada;
	}

	public OeeDetalleParada removeOeeDetalleParada(OeeDetalleParada oeeDetalleParada) {
		getOeeDetalleParadas().remove(oeeDetalleParada);
		oeeDetalleParada.setOeeParada(null);

		return oeeDetalleParada;
	}


	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

}