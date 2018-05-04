package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eviscerado_rango_parametro_temperatura_gerencia database table.
 * 
 */
@Entity
@Table(name="eviscerado_rango_parametro_temperatura_gerencia")
@NamedQuery(name="EvisceradoRangoParametroTemperaturaGerencia.findAll", query="SELECT e FROM EvisceradoRangoParametroTemperaturaGerencia e")
public class EvisceradoRangoParametroTemperaturaGerencia implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idevisceradorangoparametrotemperaturagerencia;
	private String color;
	private double desde;
	private double hasta;

	public EvisceradoRangoParametroTemperaturaGerencia() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdevisceradorangoparametrotemperaturagerencia() {
		return this.idevisceradorangoparametrotemperaturagerencia;
	}

	public void setIdevisceradorangoparametrotemperaturagerencia(Integer idevisceradorangoparametrotemperaturagerencia) {
		this.idevisceradorangoparametrotemperaturagerencia = idevisceradorangoparametrotemperaturagerencia;
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