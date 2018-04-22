package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the descongelado_detalle_proceso_fin_forzado database table.
 * 
 */
@Entity
@Table(name="descongelado_detalle_proceso_fin_forzado")
public class DescongeladoDetalleProcesoFinForzado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long iddescongeladodetalleprocesofinforzado;

	private Timestamp fechamovimiento;

	private Timestamp horafin;

	private Timestamp horafinforzado;

	private Timestamp horaingreso;

	private Timestamp horainicio;

	private double horastranscurridas;

	private double minutostranscurridos;

	private String observaciones;

	private double segundostranscurridos;

	//bi-directional many-to-one association to DescongeladoDetalleProceso
	@ManyToOne
	@JoinColumn(name="iddescongeladodetalleproceso")
	private DescongeladoDetalleProceso descongeladoDetalleProceso;

	//bi-directional many-to-one association to DescongeladoDuchaAperturaCierreDetalle
	@ManyToOne
	@JoinColumn(name="iddescongeladoduchaaperturacierredetalle")
	private DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public DescongeladoDetalleProcesoFinForzado() {
	}

	public Long getIddescongeladodetalleprocesofinforzado() {
		return this.iddescongeladodetalleprocesofinforzado;
	}

	public void setIddescongeladodetalleprocesofinforzado(Long iddescongeladodetalleprocesofinforzado) {
		this.iddescongeladodetalleprocesofinforzado = iddescongeladodetalleprocesofinforzado;
	}

	public Timestamp getFechamovimiento() {
		return this.fechamovimiento;
	}

	public void setFechamovimiento(Timestamp fechamovimiento) {
		this.fechamovimiento = fechamovimiento;
	}

	public Timestamp getHorafin() {
		return this.horafin;
	}

	public void setHorafin(Timestamp horafin) {
		this.horafin = horafin;
	}

	public Timestamp getHorafinforzado() {
		return this.horafinforzado;
	}

	public void setHorafinforzado(Timestamp horafinforzado) {
		this.horafinforzado = horafinforzado;
	}

	public Timestamp getHoraingreso() {
		return this.horaingreso;
	}

	public void setHoraingreso(Timestamp horaingreso) {
		this.horaingreso = horaingreso;
	}

	public Timestamp getHorainicio() {
		return this.horainicio;
	}

	public void setHorainicio(Timestamp horainicio) {
		this.horainicio = horainicio;
	}

	public double getHorastranscurridas() {
		return this.horastranscurridas;
	}

	public void setHorastranscurridas(double horastranscurridas) {
		this.horastranscurridas = horastranscurridas;
	}

	public double getMinutostranscurridos() {
		return this.minutostranscurridos;
	}

	public void setMinutostranscurridos(double minutostranscurridos) {
		this.minutostranscurridos = minutostranscurridos;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public double getSegundostranscurridos() {
		return this.segundostranscurridos;
	}

	public void setSegundostranscurridos(double segundostranscurridos) {
		this.segundostranscurridos = segundostranscurridos;
	}

	public DescongeladoDetalleProceso getDescongeladoDetalleProceso() {
		return this.descongeladoDetalleProceso;
	}

	public void setDescongeladoDetalleProceso(DescongeladoDetalleProceso descongeladoDetalleProceso) {
		this.descongeladoDetalleProceso = descongeladoDetalleProceso;
	}

	public DescongeladoDuchaAperturaCierreDetalle getDescongeladoDuchaAperturaCierreDetalle() {
		return this.descongeladoDuchaAperturaCierreDetalle;
	}

	public void setDescongeladoDuchaAperturaCierreDetalle(DescongeladoDuchaAperturaCierreDetalle descongeladoDuchaAperturaCierreDetalle) {
		this.descongeladoDuchaAperturaCierreDetalle = descongeladoDuchaAperturaCierreDetalle;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}