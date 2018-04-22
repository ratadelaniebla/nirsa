package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_rendimiento_atun database table.
 * 
 */
@Entity
@Table(name="estandar_rendimiento_atun")
public class EstandarRendimientoAtun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandarrendimientoatun;

	private Integer idtipo;

	private String unidadmedida;

	private double valor;

	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	private EspecieTalla especieTalla;

	public EstandarRendimientoAtun() {
	}

	public Integer getIdestandarrendimientoatun() {
		return this.idestandarrendimientoatun;
	}

	public void setIdestandarrendimientoatun(Integer idestandarrendimientoatun) {
		this.idestandarrendimientoatun = idestandarrendimientoatun;
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

	public EspecieTalla getEspecieTalla() {
		return this.especieTalla;
	}

	public void setEspecieTalla(EspecieTalla especieTalla) {
		this.especieTalla = especieTalla;
	}

}