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
public class LimpiezaProcesoJornadaLinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezaprocesojornadalineas;

	@Column(name="fecha_hora_fin_jornada")
	private Timestamp fechaHoraFinJornada;

	@Column(name="fecha_hora_inicio_jornada")
	private Timestamp fechaHoraInicioJornada;

	//bi-directional many-to-one association to LimpiezaLinea
	@ManyToOne
	@JoinColumn(name="idlimpiezalinea")
	private LimpiezaLinea limpiezaLinea;

	//bi-directional many-to-one association to LimpiezaProceso
	@ManyToOne
	@JoinColumn(name="idlimpiezaproceso")
	private LimpiezaProceso limpiezaProceso;

	public LimpiezaProcesoJornadaLinea() {
	}

	public Long getIdlimpiezaprocesojornadalineas() {
		return this.idlimpiezaprocesojornadalineas;
	}

	public void setIdlimpiezaprocesojornadalineas(Long idlimpiezaprocesojornadalineas) {
		this.idlimpiezaprocesojornadalineas = idlimpiezaprocesojornadalineas;
	}

	public Timestamp getFechaHoraFinJornada() {
		return this.fechaHoraFinJornada;
	}

	public void setFechaHoraFinJornada(Timestamp fechaHoraFinJornada) {
		this.fechaHoraFinJornada = fechaHoraFinJornada;
	}

	public Timestamp getFechaHoraInicioJornada() {
		return this.fechaHoraInicioJornada;
	}

	public void setFechaHoraInicioJornada(Timestamp fechaHoraInicioJornada) {
		this.fechaHoraInicioJornada = fechaHoraInicioJornada;
	}

	public LimpiezaLinea getLimpiezaLinea() {
		return this.limpiezaLinea;
	}

	public void setLimpiezaLinea(LimpiezaLinea limpiezaLinea) {
		this.limpiezaLinea = limpiezaLinea;
	}

	public LimpiezaProceso getLimpiezaProceso() {
		return this.limpiezaProceso;
	}

	public void setLimpiezaProceso(LimpiezaProceso limpiezaProceso) {
		this.limpiezaProceso = limpiezaProceso;
	}

}