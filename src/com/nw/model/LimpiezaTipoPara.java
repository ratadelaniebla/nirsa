package com.nw.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the limpieza_tipo_para database table.
 * 
 */
@Entity
@Table(name="limpieza_tipo_para")
public class LimpiezaTipoPara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idlimpiezatipopara;

	private String descripcion;

	//bi-directional many-to-one association to LimpiezaDetalleTipoPara
	@OneToMany(mappedBy="limpiezaTipoPara")
	private List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas;

	public LimpiezaTipoPara() {
	}

	public Integer getIdlimpiezatipopara() {
		return this.idlimpiezatipopara;
	}

	public void setIdlimpiezatipopara(Integer idlimpiezatipopara) {
		this.idlimpiezatipopara = idlimpiezatipopara;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<LimpiezaDetalleTipoPara> getLimpiezaDetalleTipoParas() {
		return this.limpiezaDetalleTipoParas;
	}

	public void setLimpiezaDetalleTipoParas(List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas) {
		this.limpiezaDetalleTipoParas = limpiezaDetalleTipoParas;
	}

}