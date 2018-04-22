package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_eficiencia_atun_limpio database table.
 * 
 */
@Entity
@Table(name="estandar_eficiencia_atun_limpio")
public class EstandarEficienciaAtunLimpio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandareficienciaatunlimpio;

	private double costo;

	private double factor;

	private double factor2;

	private double factor3;

	private String unidadmedida;

	private double valor;

	private double valor1;

	private double valor2;

	private double valor3;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	public EstandarEficienciaAtunLimpio() {
	}

	public Integer getIdestandareficienciaatunlimpio() {
		return this.idestandareficienciaatunlimpio;
	}

	public void setIdestandareficienciaatunlimpio(Integer idestandareficienciaatunlimpio) {
		this.idestandareficienciaatunlimpio = idestandareficienciaatunlimpio;
	}

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getFactor() {
		return this.factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public double getFactor2() {
		return this.factor2;
	}

	public void setFactor2(double factor2) {
		this.factor2 = factor2;
	}

	public double getFactor3() {
		return this.factor3;
	}

	public void setFactor3(double factor3) {
		this.factor3 = factor3;
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

	public double getValor1() {
		return this.valor1;
	}

	public void setValor1(double valor1) {
		this.valor1 = valor1;
	}

	public double getValor2() {
		return this.valor2;
	}

	public void setValor2(double valor2) {
		this.valor2 = valor2;
	}

	public double getValor3() {
		return this.valor3;
	}

	public void setValor3(double valor3) {
		this.valor3 = valor3;
	}

	public LimpiezaTipo getLimpiezaTipo() {
		return this.limpiezaTipo;
	}

	public void setLimpiezaTipo(LimpiezaTipo limpiezaTipo) {
		this.limpiezaTipo = limpiezaTipo;
	}

	public Talla getTalla() {
		return this.talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

}