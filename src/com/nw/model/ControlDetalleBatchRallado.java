package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the control_detalle_batch_rallado database table.
 * 
 */
@Entity
@Table(name="control_detalle_batch_rallado")
@NamedQuery(name="ControlDetalleBatchRallado.findAll", query="SELECT c FROM ControlDetalleBatchRallado c")
public class ControlDetalleBatchRallado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idcontroldetallebatchrallado;
	private Integer estado;
	private Timestamp fechaactualizacion;
	private Timestamp fechafin;
	private Timestamp fechainicio;
	private String observaciones;
	private ControlFichaBatch controlFichaBatch;
	private LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso;
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;

	public ControlDetalleBatchRallado() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdcontroldetallebatchrallado() {
		return this.idcontroldetallebatchrallado;
	}

	public void setIdcontroldetallebatchrallado(Long idcontroldetallebatchrallado) {
		this.idcontroldetallebatchrallado = idcontroldetallebatchrallado;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechaactualizacion() {
		return this.fechaactualizacion;
	}

	public void setFechaactualizacion(Timestamp fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}


	public Timestamp getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Timestamp fechafin) {
		this.fechafin = fechafin;
	}


	public Timestamp getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Timestamp fechainicio) {
		this.fechainicio = fechainicio;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	//bi-directional many-to-one association to ControlFichaBatch
	@ManyToOne
	@JoinColumn(name="idcontrolfichabatch")
	public ControlFichaBatch getControlFichaBatch() {
		return this.controlFichaBatch;
	}

	public void setControlFichaBatch(ControlFichaBatch controlFichaBatch) {
		this.controlFichaBatch = controlFichaBatch;
	}


	//bi-directional many-to-one association to LimpiezaRalladoDetallePeso
	@ManyToOne
	@JoinColumn(name="idlimpiezaralladodetallepesos")
	public LimpiezaRalladoDetallePeso getLimpiezaRalladoDetallePeso() {
		return this.limpiezaRalladoDetallePeso;
	}

	public void setLimpiezaRalladoDetallePeso(LimpiezaRalladoDetallePeso limpiezaRalladoDetallePeso) {
		this.limpiezaRalladoDetallePeso = limpiezaRalladoDetallePeso;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioactualizacion")
	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariofin")
	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioinicio")
	public Usuario getUsuario3() {
		return this.usuario3;
	}

	public void setUsuario3(Usuario usuario3) {
		this.usuario3 = usuario3;
	}

}