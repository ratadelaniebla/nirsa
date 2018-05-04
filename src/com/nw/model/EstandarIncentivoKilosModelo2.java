package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_incentivo_kilos_modelo2 database table.
 * 
 */
@Entity
@Table(name="estandar_incentivo_kilos_modelo2")
@NamedQuery(name="EstandarIncentivoKilosModelo2.findAll", query="SELECT e FROM EstandarIncentivoKilosModelo2 e")
public class EstandarIncentivoKilosModelo2 implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idestandarincentivokilos;
	private double eficienciaentero;
	private double eficiencialimpio;
	private double incentivo;
	private double porcentajeeficiencia;
	private double sueldomensual;
	private double sueldototal;
	private LimpiezaTipo limpiezaTipo;

	public EstandarIncentivoKilosModelo2() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdestandarincentivokilos() {
		return this.idestandarincentivokilos;
	}

	public void setIdestandarincentivokilos(Integer idestandarincentivokilos) {
		this.idestandarincentivokilos = idestandarincentivokilos;
	}


	public double getEficienciaentero() {
		return this.eficienciaentero;
	}

	public void setEficienciaentero(double eficienciaentero) {
		this.eficienciaentero = eficienciaentero;
	}


	public double getEficiencialimpio() {
		return this.eficiencialimpio;
	}

	public void setEficiencialimpio(double eficiencialimpio) {
		this.eficiencialimpio = eficiencialimpio;
	}


	public double getIncentivo() {
		return this.incentivo;
	}

	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}


	public double getPorcentajeeficiencia() {
		return this.porcentajeeficiencia;
	}

	public void setPorcentajeeficiencia(double porcentajeeficiencia) {
		this.porcentajeeficiencia = porcentajeeficiencia;
	}


	public double getSueldomensual() {
		return this.sueldomensual;
	}

	public void setSueldomensual(double sueldomensual) {
		this.sueldomensual = sueldomensual;
	}


	public double getSueldototal() {
		return this.sueldototal;
	}

	public void setSueldototal(double sueldototal) {
		this.sueldototal = sueldototal;
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

}