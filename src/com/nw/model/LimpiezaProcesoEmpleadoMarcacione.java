package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_proceso_empleado_marcaciones database table.
 * 
 */
@Entity
@Table(name="limpieza_proceso_empleado_marcaciones")
public class LimpiezaProcesoEmpleadoMarcacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaprocesoempleadomarcaciones;

	private String cedula;

	@Column(name="fecha_hora_fin")
	private Timestamp fechaHoraFin;

	@Column(name="fecha_hora_inicio")
	private Timestamp fechaHoraInicio;

	private Timestamp fecharegistro;

	private Boolean justificado;

	private String tipo;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public LimpiezaProcesoEmpleadoMarcacione() {
	}

	public Long getIdlimpiezaprocesoempleadomarcaciones() {
		return this.idlimpiezaprocesoempleadomarcaciones;
	}

	public void setIdlimpiezaprocesoempleadomarcaciones(Long idlimpiezaprocesoempleadomarcaciones) {
		this.idlimpiezaprocesoempleadomarcaciones = idlimpiezaprocesoempleadomarcaciones;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Timestamp getFechaHoraFin() {
		return this.fechaHoraFin;
	}

	public void setFechaHoraFin(Timestamp fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public Timestamp getFechaHoraInicio() {
		return this.fechaHoraInicio;
	}

	public void setFechaHoraInicio(Timestamp fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public Boolean getJustificado() {
		return this.justificado;
	}

	public void setJustificado(Boolean justificado) {
		this.justificado = justificado;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}