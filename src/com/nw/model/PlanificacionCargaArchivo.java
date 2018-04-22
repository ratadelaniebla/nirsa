package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the planificacion_carga_archivo database table.
 * 
 */
@Entity
@Table(name="planificacion_carga_archivo")
public class PlanificacionCargaArchivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idplanificacioncargaarchivo;

	private Timestamp fechaarchivo;

	private Timestamp fechacarga;

	private Integer idsemana;

	private String nombrearchivo;

	private Integer turnoarchivo;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	//bi-directional many-to-one association to PlanificacionCargaArchivoDetalle
	@OneToMany(mappedBy="planificacionCargaArchivo")
	private List<PlanificacionCargaArchivoDetalle> planificacionCargaArchivoDetalles;

	public PlanificacionCargaArchivo() {
	}

	public Long getIdplanificacioncargaarchivo() {
		return this.idplanificacioncargaarchivo;
	}

	public void setIdplanificacioncargaarchivo(Long idplanificacioncargaarchivo) {
		this.idplanificacioncargaarchivo = idplanificacioncargaarchivo;
	}

	public Timestamp getFechaarchivo() {
		return this.fechaarchivo;
	}

	public void setFechaarchivo(Timestamp fechaarchivo) {
		this.fechaarchivo = fechaarchivo;
	}

	public Timestamp getFechacarga() {
		return this.fechacarga;
	}

	public void setFechacarga(Timestamp fechacarga) {
		this.fechacarga = fechacarga;
	}

	public Integer getIdsemana() {
		return this.idsemana;
	}

	public void setIdsemana(Integer idsemana) {
		this.idsemana = idsemana;
	}

	public String getNombrearchivo() {
		return this.nombrearchivo;
	}

	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}

	public Integer getTurnoarchivo() {
		return this.turnoarchivo;
	}

	public void setTurnoarchivo(Integer turnoarchivo) {
		this.turnoarchivo = turnoarchivo;
	}

	public Produccion getProduccion() {
		return this.produccion;
	}

	public void setProduccion(Produccion produccion) {
		this.produccion = produccion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<PlanificacionCargaArchivoDetalle> getPlanificacionCargaArchivoDetalles() {
		return this.planificacionCargaArchivoDetalles;
	}

	public void setPlanificacionCargaArchivoDetalles(List<PlanificacionCargaArchivoDetalle> planificacionCargaArchivoDetalles) {
		this.planificacionCargaArchivoDetalles = planificacionCargaArchivoDetalles;
	}

}