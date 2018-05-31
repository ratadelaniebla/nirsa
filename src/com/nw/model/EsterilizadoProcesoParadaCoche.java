package com.nw.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the esterilizado_proceso_parada_coche database table.
 * 
 */
@Entity
@Table(name="esterilizado_proceso_parada_coche")
@NamedQuery(name="EsterilizadoProcesoParadaCoche.findAll", query="SELECT e FROM EsterilizadoProcesoParadaCoche e")
public class EsterilizadoProcesoParadaCoche implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idesterilizadoprocesoparadacoche;
	private Integer estado;
	private Timestamp fechaingreso;
	private Timestamp fechasalida;
	private EsterilizadoCoche esterilizadoCoche;
	private EsterilizadoProcesoParada esterilizadoProcesoParada;
	private Turno turno;
	private Usuario usuario;

	public EsterilizadoProcesoParadaCoche() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdesterilizadoprocesoparadacoche() {
		return this.idesterilizadoprocesoparadacoche;
	}

	public void setIdesterilizadoprocesoparadacoche(Long idesterilizadoprocesoparadacoche) {
		this.idesterilizadoprocesoparadacoche = idesterilizadoprocesoparadacoche;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechaingreso() {
		return this.fechaingreso;
	}

	public void setFechaingreso(Timestamp fechaingreso) {
		this.fechaingreso = fechaingreso;
	}


	public Timestamp getFechasalida() {
		return this.fechasalida;
	}

	public void setFechasalida(Timestamp fechasalida) {
		this.fechasalida = fechasalida;
	}


	//bi-directional many-to-one association to EsterilizadoCoche
	@ManyToOne
	@JoinColumn(name="idesterilizadocoche")
	public EsterilizadoCoche getEsterilizadoCoche() {
		return this.esterilizadoCoche;
	}

	public void setEsterilizadoCoche(EsterilizadoCoche esterilizadoCoche) {
		this.esterilizadoCoche = esterilizadoCoche;
	}


	//bi-directional many-to-one association to EsterilizadoProcesoParada
	@ManyToOne
	@JoinColumn(name="idesterilizadoprocesoparada")
	public EsterilizadoProcesoParada getEsterilizadoProcesoParada() {
		return this.esterilizadoProcesoParada;
	}

	public void setEsterilizadoProcesoParada(EsterilizadoProcesoParada esterilizadoProcesoParada) {
		this.esterilizadoProcesoParada = esterilizadoProcesoParada;
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