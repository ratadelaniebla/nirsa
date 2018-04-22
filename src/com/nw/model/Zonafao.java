package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zonafao database table.
 * 
 */
@Entity
public class Zonafao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idzonafao;

	private String codigosap;

	private String descripcion;

	public Zonafao() {
	}

	public Integer getIdzonafao() {
		return this.idzonafao;
	}

	public void setIdzonafao(Integer idzonafao) {
		this.idzonafao = idzonafao;
	}

	public String getCodigosap() {
		return this.codigosap;
	}

	public void setCodigosap(String codigosap) {
		this.codigosap = codigosap;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}