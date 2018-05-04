package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_coche_observaciones database table.
 * 
 */
@Entity
@Table(name="limpieza_coche_observaciones")
@NamedQuery(name="LimpiezaCocheObservacione.findAll", query="SELECT l FROM LimpiezaCocheObservacione l")
public class LimpiezaCocheObservacione implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezacocheobservaciones;
	private Integer estado;
	private Timestamp fechaaccion;
	private Timestamp fechadesviacion;
	private Integer origendesviacion;
	private LimpiezaCocheDesviacion limpiezaCocheDesviacion;
	private LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche;
	private Usuario usuario1;
	private Usuario usuario2;

	public LimpiezaCocheObservacione() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlimpiezacocheobservaciones() {
		return this.idlimpiezacocheobservaciones;
	}

	public void setIdlimpiezacocheobservaciones(Long idlimpiezacocheobservaciones) {
		this.idlimpiezacocheobservaciones = idlimpiezacocheobservaciones;
	}


	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}


	public Timestamp getFechaaccion() {
		return this.fechaaccion;
	}

	public void setFechaaccion(Timestamp fechaaccion) {
		this.fechaaccion = fechaaccion;
	}


	public Timestamp getFechadesviacion() {
		return this.fechadesviacion;
	}

	public void setFechadesviacion(Timestamp fechadesviacion) {
		this.fechadesviacion = fechadesviacion;
	}


	public Integer getOrigendesviacion() {
		return this.origendesviacion;
	}

	public void setOrigendesviacion(Integer origendesviacion) {
		this.origendesviacion = origendesviacion;
	}


	//bi-directional many-to-one association to LimpiezaCocheDesviacion
	@ManyToOne
	@JoinColumn(name="idlimpiezacochedesviacion")
	public LimpiezaCocheDesviacion getLimpiezaCocheDesviacion() {
		return this.limpiezaCocheDesviacion;
	}

	public void setLimpiezaCocheDesviacion(LimpiezaCocheDesviacion limpiezaCocheDesviacion) {
		this.limpiezaCocheDesviacion = limpiezaCocheDesviacion;
	}


	//bi-directional many-to-one association to LimpiezaDetalleProcesoCoche
	@ManyToOne
	@JoinColumn(name="idlimpiezadetalleprocesocoche")
	public LimpiezaDetalleProcesoCoche getLimpiezaDetalleProcesoCoche() {
		return this.limpiezaDetalleProcesoCoche;
	}

	public void setLimpiezaDetalleProcesoCoche(LimpiezaDetalleProcesoCoche limpiezaDetalleProcesoCoche) {
		this.limpiezaDetalleProcesoCoche = limpiezaDetalleProcesoCoche;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuarioaccion")
	public Usuario getUsuario1() {
		return this.usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuariodesviacion")
	public Usuario getUsuario2() {
		return this.usuario2;
	}

	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}

}