package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the limpieza_bonificaciones_ponchadas database table.
 * 
 */
@Entity
@Table(name="limpieza_bonificaciones_ponchadas")
@NamedQuery(name="LimpiezaBonificacionesPonchada.findAll", query="SELECT l FROM LimpiezaBonificacionesPonchada l")
public class LimpiezaBonificacionesPonchada implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezabonificacionesponchadas;
	private Integer idturno;
	private String linea;
	private Integer porcentaje;
	private Integer rango1;
	private Integer rango2;

	public LimpiezaBonificacionesPonchada() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdlimpiezabonificacionesponchadas() {
		return this.idlimpiezabonificacionesponchadas;
	}

	public void setIdlimpiezabonificacionesponchadas(Integer idlimpiezabonificacionesponchadas) {
		this.idlimpiezabonificacionesponchadas = idlimpiezabonificacionesponchadas;
	}


	public Integer getIdturno() {
		return this.idturno;
	}

	public void setIdturno(Integer idturno) {
		this.idturno = idturno;
	}


	public String getLinea() {
		return this.linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}


	public Integer getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(Integer porcentaje) {
		this.porcentaje = porcentaje;
	}


	public Integer getRango1() {
		return this.rango1;
	}

	public void setRango1(Integer rango1) {
		this.rango1 = rango1;
	}


	public Integer getRango2() {
		return this.rango2;
	}

	public void setRango2(Integer rango2) {
		this.rango2 = rango2;
	}

}