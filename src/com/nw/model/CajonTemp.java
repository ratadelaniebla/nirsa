package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cajon_temp database table.
 * 
 */
@Entity
@Table(name="cajon_temp")
@NamedQuery(name="CajonTemp.findAll", query="SELECT c FROM CajonTemp c")
public class CajonTemp implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idcajon;
	private String observaciones;
	private double tara;

	public CajonTemp() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getIdcajon() {
		return this.idcajon;
	}

	public void setIdcajon(String idcajon) {
		this.idcajon = idcajon;
	}


	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public double getTara() {
		return this.tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

}