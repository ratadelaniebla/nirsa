package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_rallado_linea database table.
 * 
 */
@Entity
@Table(name="estandar_rallado_linea")
@NamedQuery(name="EstandarRalladoLinea.findAll", query="SELECT e FROM EstandarRalladoLinea e")
public class EstandarRalladoLinea implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandarralladolinea;
	private double rangodesde;
	private double rangohasta;
	private LimpiezaTipo limpiezaTipo;

	public EstandarRalladoLinea() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
	}

}