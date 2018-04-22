package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_eficiencia_ponchada_plexus database table.
 * 
 */
@Entity
@Table(name="estandar_eficiencia_ponchada_plexus")
public class EstandarEficienciaPonchadaPlexus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandareficienciaponchadaplexus;

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

	public EstandarEficienciaPonchadaPlexus() {
	}

	public Integer getIdestandareficienciaponchadaplexus() {
		return this.idestandareficienciaponchadaplexus;
	}

	public void setIdestandareficienciaponchadaplexus(Integer idestandareficienciaponchadaplexus) {
		this.idestandareficienciaponchadaplexus = idestandareficienciaponchadaplexus;
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