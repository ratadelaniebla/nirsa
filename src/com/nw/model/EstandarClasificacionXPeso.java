package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estandar_clasificacion_x_peso database table.
 * 
 */
@Entity
@Table(name="estandar_clasificacion_x_peso")
public class EstandarClasificacionXPeso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idestandarclasificacionxpeso;

	private double peso;

	//bi-directional many-to-one association to EvisceradoPescadosLata
	@ManyToOne
	@JoinColumn(name="idevisceradopescadoslata")
	private EvisceradoPescadosLata evisceradoPescadosLata;

	public EstandarClasificacionXPeso() {
	}

	public Integer getIdestandarclasificacionxpeso() {
		return this.idestandarclasificacionxpeso;
	}

	public void setIdestandarclasificacionxpeso(Integer idestandarclasificacionxpeso) {
		this.idestandarclasificacionxpeso = idestandarclasificacionxpeso;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public EvisceradoPescadosLata getEvisceradoPescadosLata() {
		return this.evisceradoPescadosLata;
	}

	public void setEvisceradoPescadosLata(EvisceradoPescadosLata evisceradoPescadosLata) {
		this.evisceradoPescadosLata = evisceradoPescadosLata;
	}

}