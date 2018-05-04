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
@NamedQuery(name="LimpiezaTipoPara.findAll", query="SELECT l FROM LimpiezaTipoPara l")
public class LimpiezaTipoPara implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idlimpiezatipopara;
	private String descripcion;
	private List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas;

	public LimpiezaTipoPara() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	//bi-directional many-to-one association to LimpiezaDetalleTipoPara
	@OneToMany(mappedBy="limpiezaTipoPara")
	public List<LimpiezaDetalleTipoPara> getLimpiezaDetalleTipoParas() {
		return this.limpiezaDetalleTipoParas;
	}

	public void setLimpiezaDetalleTipoParas(List<LimpiezaDetalleTipoPara> limpiezaDetalleTipoParas) {
		this.limpiezaDetalleTipoParas = limpiezaDetalleTipoParas;
	}

	public LimpiezaDetalleTipoPara addLimpiezaDetalleTipoPara(LimpiezaDetalleTipoPara limpiezaDetalleTipoPara) {
		getLimpiezaDetalleTipoParas().add(limpiezaDetalleTipoPara);
		limpiezaDetalleTipoPara.setLimpiezaTipoPara(this);

		return limpiezaDetalleTipoPara;
	}

	public LimpiezaDetalleTipoPara removeLimpiezaDetalleTipoPara(LimpiezaDetalleTipoPara limpiezaDetalleTipoPara) {
		getLimpiezaDetalleTipoParas().remove(limpiezaDetalleTipoPara);
		limpiezaDetalleTipoPara.setLimpiezaTipoPara(null);

		return limpiezaDetalleTipoPara;
	}

}