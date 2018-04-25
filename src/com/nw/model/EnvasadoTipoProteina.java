package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the envasado_tipo_proteina database table.
 * 
 */
@Entity
@Table(name="envasado_tipo_proteina")
@NamedQuery(name="EnvasadoTipoProteina.findAll", query="SELECT e FROM EnvasadoTipoProteina e")
public class EnvasadoTipoProteina implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idenvasadotipoproteina;
	private String descripcion;

	public EnvasadoTipoProteina() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdenvasadotipoproteina() {
		return this.idenvasadotipoproteina;
	}

	public void setIdenvasadotipoproteina(Integer idenvasadotipoproteina) {
		this.idenvasadotipoproteina = idenvasadotipoproteina;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}