package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_eficiencia_atun database table.
 * 
 */
@Entity
@Table(name="estandar_eficiencia_atun")
@NamedQuery(name="EstandarEficienciaAtun.findAll", query="SELECT e FROM EstandarEficienciaAtun e")
public class EstandarEficienciaAtun implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandareficienciaatun;
	private String unidadmedida;
	private double valor;
	private LimpiezaTipo limpiezaTipo;
	private Talla talla;

	public EstandarEficienciaAtun() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdestandareficienciaatun() {
		return this.idestandareficienciaatun;
	}

	public void setIdestandareficienciaatun(Integer idestandareficienciaatun) {
		this.idestandareficienciaatun = idestandareficienciaatun;
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