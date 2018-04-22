package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eviscerado_rango_parametro_temperatura_contraloria database table.
 * 
 */
@Entity
@Table(name="eviscerado_rango_parametro_temperatura_contraloria")
public class EvisceradoRangoParametroTemperaturaContraloria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idevisceradorangoparametrotemperaturacontraloria;

	private String color;

	private double desde;

	private double hasta;

	public EvisceradoRangoParametroTemperaturaContraloria() {
	}

	public Integer getIdevisceradorangoparametrotemperaturacontraloria() {
		return this.idevisceradorangoparametrotemperaturacontraloria;
	}

	public void setIdevisceradorangoparametrotemperaturacontraloria(Integer idevisceradorangoparametrotemperaturacontraloria) {
		this.idevisceradorangoparametrotemperaturacontraloria = idevisceradorangoparametrotemperaturacontraloria;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getDesde() {
		return this.desde;
	}

	public void setDesde(double desde) {
		this.desde = desde;
	}

	public double getHasta() {
		return this.hasta;
	}

	public void setHasta(double hasta) {
		this.hasta = hasta;
	}

}