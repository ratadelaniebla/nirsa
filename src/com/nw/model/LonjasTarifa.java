package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lonjas_tarifas database table.
 * 
 */
@Entity
@Table(name="lonjas_tarifas")
@NamedQuery(name="LonjasTarifa.findAll", query="SELECT l FROM LonjasTarifa l")
public class LonjasTarifa implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idlonjastarifa;
	private Integer fundaspordia;
	private Integer fundasporhora;
	private Integer hora;
	private String idtalla;
	private double incentivopordia;

	public LonjasTarifa() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdlonjastarifa() {
		return this.idlonjastarifa;
	}

	public void setIdlonjastarifa(Long idlonjastarifa) {
		this.idlonjastarifa = idlonjastarifa;
	}


	public Integer getFundaspordia() {
		return this.fundaspordia;
	}

	public void setFundaspordia(Integer fundaspordia) {
		this.fundaspordia = fundaspordia;
	}


	public Integer getFundasporhora() {
		return this.fundasporhora;
	}

	public void setFundasporhora(Integer fundasporhora) {
		this.fundasporhora = fundasporhora;
	}


	public Integer getHora() {
		return this.hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}


	public String getIdtalla() {
		return this.idtalla;
	}

	public void setIdtalla(String idtalla) {
		this.idtalla = idtalla;
	}


	public double getIncentivopordia() {
		return this.incentivopordia;
	}

	public void setIncentivopordia(double incentivopordia) {
		this.incentivopordia = incentivopordia;
	}

}