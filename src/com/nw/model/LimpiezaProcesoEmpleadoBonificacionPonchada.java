package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_proceso_empleado_bonificacion_ponchadas database table.
 * 
 */
@Entity
@Table(name="limpieza_proceso_empleado_bonificacion_ponchadas")
public class LimpiezaProcesoEmpleadoBonificacionPonchada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezabonificacionponchadas;

	private Integer cantidadextra100;

	private Integer cantidadextra50;

	private Integer cantidadnormal;

	private Integer estado;

	private Timestamp fecharegistro;

	private double tarifabonificacion;

	private double tarifanormal;

	private Integer total;

	private double valor100;

	private double valor50;

	private double valornormal;

	private double valortotal;

	//bi-directional many-to-one association to LimpiezaProcesoEmpleado
	@ManyToOne
	@JoinColumn(name="idlimpiezaprocesoempleado")
	private LimpiezaProcesoEmpleado limpiezaProcesoEmpleado;

	//bi-directional many-to-one association to LimpiezaTarifaPonchada
	@ManyToOne
	@JoinColumn(name="idlimpiezatarifaponchadas")
	private LimpiezaTarifaPonchada limpiezaTarifaPonchada;

	public LimpiezaProcesoEmpleadoBonificacionPonchada() {
	}

	public Long getIdlimpiezabonificacionponchadas() {
		return this.idlimpiezabonificacionponchadas;
	}

	public void setIdlimpiezabonificacionponchadas(Long idlimpiezabonificacionponchadas) {
		this.idlimpiezabonificacionponchadas = idlimpiezabonificacionponchadas;
	}

	public Integer getCantidadextra100() {
		return this.cantidadextra100;
	}

	public void setCantidadextra100(Integer cantidadextra100) {
		this.cantidadextra100 = cantidadextra100;
	}

	public Integer getCantidadextra50() {
		return this.cantidadextra50;
	}

	public void setCantidadextra50(Integer cantidadextra50) {
		this.cantidadextra50 = cantidadextra50;
	}

	public Integer getCantidadnormal() {
		return this.cantidadnormal;
	}

	public void setCantidadnormal(Integer cantidadnormal) {
		this.cantidadnormal = cantidadnormal;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Timestamp getFecharegistro() {
		return this.fecharegistro;
	}

	public void setFecharegistro(Timestamp fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public double getTarifabonificacion() {
		return this.tarifabonificacion;
	}

	public void setTarifabonificacion(double tarifabonificacion) {
		this.tarifabonificacion = tarifabonificacion;
	}

	public double getTarifanormal() {
		return this.tarifanormal;
	}

	public void setTarifanormal(double tarifanormal) {
		this.tarifanormal = tarifanormal;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public double getValor100() {
		return this.valor100;
	}

	public void setValor100(double valor100) {
		this.valor100 = valor100;
	}

	public double getValor50() {
		return this.valor50;
	}

	public void setValor50(double valor50) {
		this.valor50 = valor50;
	}

	public double getValornormal() {
		return this.valornormal;
	}

	public void setValornormal(double valornormal) {
		this.valornormal = valornormal;
	}

	public double getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}

	public LimpiezaProcesoEmpleado getLimpiezaProcesoEmpleado() {
		return this.limpiezaProcesoEmpleado;
	}

	public void setLimpiezaProcesoEmpleado(LimpiezaProcesoEmpleado limpiezaProcesoEmpleado) {
		this.limpiezaProcesoEmpleado = limpiezaProcesoEmpleado;
	}

	public LimpiezaTarifaPonchada getLimpiezaTarifaPonchada() {
		return this.limpiezaTarifaPonchada;
	}

	public void setLimpiezaTarifaPonchada(LimpiezaTarifaPonchada limpiezaTarifaPonchada) {
		this.limpiezaTarifaPonchada = limpiezaTarifaPonchada;
	}

}