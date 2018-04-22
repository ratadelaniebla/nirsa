package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bi_estandar_clasificacion_tallas database table.
 * 
 */
@Entity
@Table(name="bi_estandar_clasificacion_tallas")
public class BiEstandarClasificacionTalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idbiestandarclasificaciontallas;

	private double valor;

	//bi-directional many-to-one association to LimpiezaTipo
	@ManyToOne
	@JoinColumn(name="idlimpiezatipo")
	private LimpiezaTipo limpiezaTipo;

	//bi-directional many-to-one association to Talla
	@ManyToOne
	@JoinColumn(name="idtalla")
	private Talla talla;

	public BiEstandarClasificacionTalla() {
	}

	public Integer getIdbiestandarclasificaciontallas() {
		return this.idbiestandarclasificaciontallas;
	}

	public void setIdbiestandarclasificaciontallas(Integer idbiestandarclasificaciontallas) {
		this.idbiestandarclasificaciontallas = idbiestandarclasificaciontallas;
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