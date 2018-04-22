package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_desperdicio_atun database table.
 * 
 */
@Entity
@Table(name="estandar_desperdicio_atun")
public class EstandarDesperdicioAtun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandardesperdicioatun;

	private double valor;

	//bi-directional many-to-one association to EspecieTalla
	@ManyToOne
	@JoinColumn(name="idespecietalla")
	private EspecieTalla especieTalla;

	public EstandarDesperdicioAtun() {
	}

	public Integer getIdestandardesperdicioatun() {
		return this.idestandardesperdicioatun;
	}

	public void setIdestandardesperdicioatun(Integer idestandardesperdicioatun) {
		this.idestandardesperdicioatun = idestandardesperdicioatun;
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