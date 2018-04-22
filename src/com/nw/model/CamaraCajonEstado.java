package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the camara_cajon_estado database table.
 * 
 */
@Entity
@Table(name="camara_cajon_estado")
public class CamaraCajonEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idcamaracajonestado;

	private String abreviao;

	private String descripcionestado;

	public CamaraCajonEstado() {
	}

	public Integer getIdcamaracajonestado() {
		return this.idcamaracajonestado;
	}

	public void setIdcamaracajonestado(Integer idcamaracajonestado) {
		this.idcamaracajonestado = idcamaracajonestado;
	}

	public String getAbreviao() {
		return this.abreviao;
	}

	public void setAbreviao(String abreviao) {
		this.abreviao = abreviao;
	}

	public String getDescripcionestado() {
		return this.descripcionestado;
	}

	public void setDescripcionestado(String descripcionestado) {
		this.descripcionestado = descripcionestado;
	}

}