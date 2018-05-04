package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_rendimientos_atun database table.
 * 
 */
@Entity
@Table(name="estandar_rendimientos_atun")
@NamedQuery(name="EstandarRendimientosAtun.findAll", query="SELECT e FROM EstandarRendimientosAtun e")
public class EstandarRendimientosAtun implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandarrendimientosatun;
	private Integer idtipo;
	private String unidadmedida;
	private double valor;
	private EspecieTalla especieTalla;

	public EstandarRendimientosAtun() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdestandarrendimientosatun() {
		return this.idestandarrendimientosatun;
	}

	public void setIdestandarrendimientosatun(Integer idestandarrendimientosatun) {
		this.idestandarrendimientosatun = idestandarrendimientosatun;
	}


	public Integer getIdtipo() {
		return this.idtipo;
	}

	public void setIdtipo(Integer idtipo) {
		this.idtipo = idtipo;
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


	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}

}