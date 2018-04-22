package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eviscerado_rango_parametro_temperatura database table.
 * 
 */
@Entity
@Table(name="eviscerado_rango_parametro_temperatura")
public class EvisceradoRangoParametroTemperatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idevisceradorangoparametrotemperatura;

	private double desde;

	private double hasta;

	public EvisceradoRangoParametroTemperatura() {
	}

	public Integer getIdevisceradorangoparametrotemperatura() {
		return this.idevisceradorangoparametrotemperatura;
	}

	public void setIdevisceradorangoparametrotemperatura(Integer idevisceradorangoparametrotemperatura) {
		this.idevisceradorangoparametrotemperatura = idevisceradorangoparametrotemperatura;
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