package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the limpieza_detalle_cortes_planta database table.
 * 
 */
@Entity
@Table(name="limpieza_detalle_cortes_planta")
public class LimpiezaDetalleCortesPlanta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlimpiezadetallecortesplanta;

	private Integer corte;
	
	private double personaspanza;
	
	
	@Column(name="fecha_desde")
	private Timestamp fechaDesde;

	@Column(name="fecha_fin_corte_anterior")
	private Timestamp fechaFinCorteAnterior;

	@Column(name="fecha_hasta")
	private Timestamp fechaHasta;

	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlanta
	@ManyToOne
	@JoinColumn(name="idlimpiezacabeceracortesplanta")
	private LimpiezaCabeceraCortesPlanta limpiezaCabeceraCortesPlanta;

	public LimpiezaDetalleCortesPlanta() {
	}

	public Long getIdlimpiezadetallecortesplanta() {
		return this.idlimpiezadetallecortesplanta;
	}

	public void setIdlimpiezadetallecortesplanta(Long idlimpiezadetallecortesplanta) {
		this.idlimpiezadetallecortesplanta = idlimpiezadetallecortesplanta;
	}

	public Integer getCorte() {
		return this.corte;
	}

	public void setCorte(Integer corte) {
		this.corte = corte;
	}

	public Timestamp getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Timestamp fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Timestamp getFechaFinCorteAnterior() {
		return this.fechaFinCorteAnterior;
	}

	public void setFechaFinCorteAnterior(Timestamp fechaFinCorteAnterior) {
		this.fechaFinCorteAnterior = fechaFinCorteAnterior;
	}

	public Timestamp getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Timestamp fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public LimpiezaCabeceraCortesPlanta getLimpiezaCabeceraCortesPlanta() {
		return this.limpiezaCabeceraCortesPlanta;
	}

	public void setLimpiezaCabeceraCortesPlanta(LimpiezaCabeceraCortesPlanta limpiezaCabeceraCortesPlanta) {
		this.limpiezaCabeceraCortesPlanta = limpiezaCabeceraCortesPlanta;
	}

	public double getPersonaspanza() {
		return personaspanza;
	}

	public void setPersonaspanza(double personaspanza) {
		this.personaspanza = personaspanza;
	}

}