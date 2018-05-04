package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the atc_parametro database table.
 * 
 */
@Entity
@Table(name="atc_parametro")
@NamedQuery(name="AtcParametro.findAll", query="SELECT a FROM AtcParametro a")
public class AtcParametro implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idatcparametro;
	private String descripcionparametro;
	private String permiso;
	private double valor;

	public AtcParametro() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdatcparametro() {
		return this.idatcparametro;
	}

	public void setIdatcparametro(Integer idatcparametro) {
		this.idatcparametro = idatcparametro;
	}


	public String getDescripcionparametro() {
		return this.descripcionparametro;
	}

	public void setDescripcionparametro(String descripcionparametro) {
		this.descripcionparametro = descripcionparametro;
	}


	public String getPermiso() {
		return this.permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}


	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}