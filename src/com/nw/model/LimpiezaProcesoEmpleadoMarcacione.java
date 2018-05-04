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
@NamedQuery(name="LimpiezaProcesoEmpleadoMarcacione.findAll", query="SELECT l FROM LimpiezaProcesoEmpleadoMarcacione l")
public class LimpiezaProcesoEmpleadoMarcacione implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaprocesoempleadomarcaciones;
	private String cedula;
	private Timestamp fechaHoraFin;
	private Timestamp fechaHoraInicio;
	private Timestamp fecharegistro;
	private Boolean justificado;
	private String tipo;
	private Empleado empleado;
	private Produccion produccion;
	private Turno turno;
	private Usuario usuario;

	public LimpiezaProcesoEmpleadoMarcacione() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="fecha_hora_fin")
	public Timestamp getFechaHoraFin() {
		return this.fechaHoraFin;
	}

	public void setFechaHoraFin(Timestamp fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}


	@Column(name="fecha_hora_inicio")
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


	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}


	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
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