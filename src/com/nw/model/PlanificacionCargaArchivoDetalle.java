package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the planificacion_carga_archivo_detalle database table.
 * 
 */
@Entity
@Table(name="planificacion_carga_archivo_detalle")
public class PlanificacionCargaArchivoDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idplanificacioncargaarchivodetalle;

	private String camara;

	private String columna;

	private Timestamp entregacamara;

	private Timestamp entregaprecamara;

	private Integer estado;

	private Timestamp fechaproduccion;

	private String fila;

	private String idcajon;

	private Timestamp ingresodescongelado;

	private Integer item;

	private String lotesap;

	private Integer pedido;

	private String producto;

	private Integer turno;

	//bi-directional many-to-one association to PlanificacionCargaArchivo
	@ManyToOne
	@JoinColumn(name="idplanificacioncargaarchivo")
	private PlanificacionCargaArchivo planificacionCargaArchivo;

	public PlanificacionCargaArchivoDetalle() {
	}

	public Long getIdplanificacioncargaarchivodetalle() {
		return this.idplanificacioncargaarchivodetalle;
	}

	public void setIdplanificacioncargaarchivodetalle(Long idplanificacioncargaarchivodetalle) {
		this.idplanificacioncargaarchivodetalle = idplanificacioncargaarchivodetalle;
	}

	public String getCamara() {
		return this.camara;
	}

	public void setCamara(String camara) {
		this.camara = camara;
	}

	public String getColumna() {
		return this.columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public Timestamp getEntregacamara() {
		return this.entregacamara;
	}

	public void setEntregacamara(Timestamp entregacamara) {
		this.entregacamara = entregacamara;
	}

	public Timestamp getEntregaprecamara() {
		return this.entregaprecamara;
	}

	public void setEntregaprecamara(Timestamp entregaprecamara) {
		this.entregaprecamara = entregaprecamara;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFechaproduccion() {
		return this.fechaproduccion;
	}

	public void setFechaproduccion(Timestamp fechaproduccion) {
		this.fechaproduccion = fechaproduccion;
	}

	public String getFila() {
		return this.fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public String getIdcajon() {
		return this.idcajon;
	}

	public void setIdcajon(String idcajon) {
		this.idcajon = idcajon;
	}

	public Timestamp getIngresodescongelado() {
		return this.ingresodescongelado;
	}

	public void setIngresodescongelado(Timestamp ingresodescongelado) {
		this.ingresodescongelado = ingresodescongelado;
	}

	public Integer getItem() {
		return this.item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getLotesap() {
		return this.lotesap;
	}

	public void setLotesap(String lotesap) {
		this.lotesap = lotesap;
	}

	public Integer getPedido() {
		return this.pedido;
	}

	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public String getProducto() {
		return this.producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Integer getTurno() {
		return this.turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	public PlanificacionCargaArchivo getPlanificacionCargaArchivo() {
		return this.planificacionCargaArchivo;
	}

	public void setPlanificacionCargaArchivo(PlanificacionCargaArchivo planificacionCargaArchivo) {
		this.planificacionCargaArchivo = planificacionCargaArchivo;
	}

}