package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_rallado_linea database table.
 * 
 */
@Entity
@Table(name="estandar_rallado_linea")
public class EstandarRalladoLinea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandarralladolinea;

	private double rangodesde;

	private double rangohasta;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	public EstandarRalladoLinea() {
	}

	public Integer getIdestandarralladolinea() {
		return this.idestandarralladolinea;
	}

	public void setIdestandarralladolinea(Integer idestandarralladolinea) {
		this.idestandarralladolinea = idestandarralladolinea;
	}

	public double getRangodesde() {
		return this.rangodesde;
	}

	public void setRangodesde(double rangodesde) {
		this.rangodesde = rangodesde;
	}

	public double getRangohasta() {
		return this.rangohasta;
	}

	public void setRangohasta(double rangohasta) {
		this.rangohasta = rangohasta;
	}

	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
	}

}