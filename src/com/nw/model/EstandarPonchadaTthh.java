package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_ponchada_tthh database table.
 * 
 */
@Entity
@Table(name="estandar_ponchada_tthh")
@NamedQuery(name="EstandarPonchadaTthh.findAll", query="SELECT e FROM EstandarPonchadaTthh e")
public class EstandarPonchadaTthh implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandarponchadatthh;
	private String unidadmedida;
	private double valor;
	private EvisceradoPescadosLata evisceradoPescadosLata;
	private LimpiezaTipo limpiezaTipo;
	private Talla talla;

	public EstandarPonchadaTthh() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdestandarponchadatthh() {
		return this.idestandarponchadatthh;
	}

	public void setIdestandarponchadatthh(Integer idestandarponchadatthh) {
		this.idestandarponchadatthh = idestandarponchadatthh;
	}


	public String getUnidadmedida() {
		return this.unidadmedida;
	}

	public void setUnidadmedida(String unidadmedida) {
		this.unidadmedida = unidadmedida;
	}


	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	//bi-directional many-to-one association to EvisceradoPescadosLata
	@ManyToOne
	@JoinColumn(name="idevisceradopescadoslata")
	public EvisceradoPescadosLata getEvisceradoPescadosLata() {
		return this.evisceradoPescadosLata;
	}

	public void setEvisceradoPescadosLata(EvisceradoPescadosLata evisceradoPescadosLata) {
		this.evisceradoPescadosLata = evisceradoPescadosLata;
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


	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}