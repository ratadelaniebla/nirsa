package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rackeo_proceso_empleado database table.
 * 
 */
@Entity
@Table(name="rackeo_proceso_empleado")
public class RackeoProcesoEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idrackeoprocesoempleado;

	private Integer estado;

	private Timestamp fechareg;

	private Integer mesa;

	private Integer ubicacion;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;

	//bi-directional many-to-one association to RackeoProceso
	@ManyToOne
	@JoinColumn(name="idrackeoproceso")
	private RackeoProceso rackeoProceso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public RackeoProcesoEmpleado() {
	}

	public Long getIdrackeoprocesoempleado() {
		return this.idrackeoprocesoempleado;
	}

	public void setIdrackeoprocesoempleado(Long idrackeoprocesoempleado) {
		this.idrackeoprocesoempleado = idrackeoprocesoempleado;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechareg() {
		return this.fechareg;
	}

	public void setFechareg(Timestamp fechareg) {
		this.fechareg = fechareg;
	}

	public Integer getMesa() {
		return this.mesa;
	}

	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}

	public Integer getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public RackeoProceso getRackeoProceso() {
		return this.rackeoProceso;
	}

	public void setRackeoProceso(RackeoProceso rackeoProceso) {
		this.rackeoProceso = rackeoProceso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}