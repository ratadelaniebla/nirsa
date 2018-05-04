package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eviscerado_rango_parametro_temperatura database table.
 * 
 */
@Entity
@Table(name="eviscerado_rango_parametro_temperatura")
@NamedQuery(name="EvisceradoRangoParametroTemperatura.findAll", query="SELECT e FROM EvisceradoRangoParametroTemperatura e")
public class EvisceradoRangoParametroTemperatura implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idevisceradorangoparametrotemperatura;
	private double desde;
	private double hasta;

	public EvisceradoRangoParametroTemperatura() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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