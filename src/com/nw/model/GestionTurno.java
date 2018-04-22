package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the gestion_turno database table.
 * 
 */
@Entity
@Table(name="gestion_turno")
public class GestionTurno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idgestionturno;

	private Timestamp fechahorafin;

	private Timestamp fechahoraincio;

	private Timestamp fechaproduccion;

	private Timestamp fecharegistro;

	private String observacion;

	//bi-directional many-to-one association to Proceso
	@ManyToOne
	@JoinColumn(name="idproceso")
	private Proceso proceso;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public GestionTurno() {
	}

	public Long getIdgestionturno() {
		return this.idgestionturno;
	}

	public void setIdgestionturno(Long idgestionturno) {
		this.idgestionturno = idgestionturno;
	}

	public Timestamp getFechahorafin() {
		return this.fechahorafin;
	}

	public void setFechahorafin(Timestamp fechahorafin) {
		this.fechahorafin = fechahorafin;
	}

	public Timestamp getFechahoraincio() {
		return this.fechahoraincio;
	}

	public void setFechahoraincio(Timestamp fechahoraincio) {
		this.fechahoraincio = fechahoraincio;
	}

	public Timestamp getFechaproduccion() {
		return this.fechaproduccion;
	}

	public void setFechaproduccion(Timestamp fechaproduccion) {
		this.fechaproduccion = fechaproduccion;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Proceso getProceso() {
		return this.proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
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