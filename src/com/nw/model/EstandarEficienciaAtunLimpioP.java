package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_eficiencia_atun_limpio_p database table.
 * 
 */
@Entity
@Table(name="estandar_eficiencia_atun_limpio_p")
public class EstandarEficienciaAtunLimpioP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandareficienciaatunlimpiop;

	private String unidadmedida;

	private double valor;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	public EstandarEficienciaAtunLimpioP() {
	}

	public Integer getIdestandareficienciaatunlimpiop() {
		return this.idestandareficienciaatunlimpiop;
	}

	public void setIdestandareficienciaatunlimpiop(Integer idestandareficienciaatunlimpiop) {
		this.idestandareficienciaatunlimpiop = idestandareficienciaatunlimpiop;
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