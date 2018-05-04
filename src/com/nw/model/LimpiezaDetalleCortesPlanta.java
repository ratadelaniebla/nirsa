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
@NamedQuery(name="LimpiezaDetalleCortesPlanta.findAll", query="SELECT l FROM LimpiezaDetalleCortesPlanta l")
public class LimpiezaDetalleCortesPlanta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlimpiezadetallecortesplanta;
	private Integer corte;
	private Timestamp fechaDesde;
	private Timestamp fechaFinCorteAnterior;
	private Timestamp fechaHasta;
	private double personaspanza;
	private LimpiezaCabeceraCortesPlanta limpiezaCabeceraCortesPlanta;

	public LimpiezaDetalleCortesPlanta() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Column(name="fecha_desde")
	public Timestamp getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Timestamp fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	@Column(name="fecha_fin_corte_anterior")
	public Timestamp getFechaFinCorteAnterior() {
		return this.fechaFinCorteAnterior;
	}

	public void setFechaFinCorteAnterior(Timestamp fechaFinCorteAnterior) {
		this.fechaFinCorteAnterior = fechaFinCorteAnterior;
	}


	@Column(name="fecha_hasta")
	public Timestamp getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Timestamp fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	public double getPersonaspanza() {
		return this.personaspanza;
	}

	public void setPersonaspanza(double personaspanza) {
		this.personaspanza = personaspanza;
	}


	//bi-directional many-to-one association to LimpiezaCabeceraCortesPlanta
	@ManyToOne
	@JoinColumn(name="idlimpiezacabeceracortesplanta")
	public LimpiezaCabeceraCortesPlanta getLimpiezaCabeceraCortesPlanta() {
		return this.limpiezaCabeceraCortesPlanta;
	}

	public void setLimpiezaCabeceraCortesPlanta(LimpiezaCabeceraCortesPlanta limpiezaCabeceraCortesPlanta) {
		this.limpiezaCabeceraCortesPlanta = limpiezaCabeceraCortesPlanta;
	}

}