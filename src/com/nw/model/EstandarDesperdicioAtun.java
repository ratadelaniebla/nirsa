package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_desperdicio_atun database table.
 * 
 */
@Entity
@Table(name="estandar_desperdicio_atun")
@NamedQuery(name="EstandarDesperdicioAtun.findAll", query="SELECT e FROM EstandarDesperdicioAtun e")
public class EstandarDesperdicioAtun implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandardesperdicioatun;
	private double valor;
	private EspecieTalla especieTalla;

	public EstandarDesperdicioAtun() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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