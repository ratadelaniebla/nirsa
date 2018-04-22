package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the planificacion_carga_detalle database table.
 * 
 */
@Entity
@Table(name="planificacion_carga_detalle")
public class PlanificacionCargaDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idplanificacioncargadetalle;

	private String camara;

	private String columna;

	private Timestamp entregacamara;

	private Timestamp entregaprecamara;

	private String fila;

	private Timestamp ingresodescongelado;

	private Integer item;

	private Integer pedido;

	private String producto;

	//bi-directional many-to-one association to CamaraCajon
	@ManyToOne
	@JoinColumn(name="idcamaracajon")
	private CamaraCajon camaraCajon;

	//bi-directional many-to-one association to Produccion
	@ManyToOne
	@JoinColumn(name="idproduccion")
	private Produccion produccion;

	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="idturno")
	private Turno turno;

	public PlanificacionCargaDetalle() {
	}

	public Long getIdplanificacioncargadetalle() {
		return this.idplanificacioncargadetalle;
	}

	public void setIdplanificacioncargadetalle(Long idplanificacioncargadetalle) {
		this.idplanificacioncargadetalle = idplanificacioncargadetalle;
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

	public String getFila() {
		return this.fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
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

	public CamaraCajon getCamaraCajon() {
		return this.camaraCajon;
	}

	public void setCamaraCajon(CamaraCajon camaraCajon) {
		this.camaraCajon = camaraCajon;
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

}