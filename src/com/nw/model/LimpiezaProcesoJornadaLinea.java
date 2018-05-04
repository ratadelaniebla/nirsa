package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_proceso_jornada_lineas database table.
 * 
 */
@Entity
@Table(name="limpieza_proceso_jornada_lineas")
@NamedQuery(name="LimpiezaProcesoJornadaLinea.findAll", query="SELECT l FROM LimpiezaProcesoJornadaLinea l")
public class LimpiezaProcesoJornadaLinea implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezaprocesojornadalineas;
	private Timestamp fechaHoraFinJornada;
	private Timestamp fechaHoraInicioJornada;
	private LimpiezaLinea limpiezaLinea;
	private LimpiezaProceso limpiezaProceso;

	public LimpiezaProcesoJornadaLinea() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezaprocesojornadalineas() {
		return this.idlimpiezaprocesojornadalineas;
	}

	public void setIdlimpiezaprocesojornadalineas(Long idlimpiezaprocesojornadalineas) {
		this.idlimpiezaprocesojornadalineas = idlimpiezaprocesojornadalineas;
	}


	@Column(name="fecha_hora_fin_jornada")
	public Timestamp getFechaHoraFinJornada() {
		return this.fechaHoraFinJornada;
	}

	public void setFechaHoraFinJornada(Timestamp fechaHoraFinJornada) {
		this.fechaHoraFinJornada = fechaHoraFinJornada;
	}


	@Column(name="fecha_hora_inicio_jornada")
	public Timestamp getFechaHoraInicioJornada() {
		return this.fechaHoraInicioJornada;
	}

	public void setFechaHoraInicioJornada(Timestamp fechaHoraInicioJornada) {
		this.fechaHoraInicioJornada = fechaHoraInicioJornada;
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


	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

}